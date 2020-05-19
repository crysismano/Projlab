package projlab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * It controls the game
 * Initializes the board, starts and end the game
 * Manages snowstorms and rounds
 */
public class Controller {
	/**
	 * All the fields in the game space
	 */
	public static ArrayList<Field> fields = new ArrayList<Field>();
	/**
	 * All of the players
	 */
	public static ArrayList<Player> players = new ArrayList<Player>();
	/**
	 * List of tents
	 */
	public static ArrayList<Tent> tents = new ArrayList<Tent>();
	/**
	 * The polarbear
	 */
	public static PolarBear polarbear = new PolarBear(); 
	
	public static MapWindow mw;
	
	public static InfoFrame infoFrame;
	
	public static HashMap<Player,String> names = new HashMap<Player, String>();
	/**
	 * It initializes the game
	 * Not used in the skeleton
	 */
	public static void Init(){
		fields = new ArrayList<Field>();
		players = new ArrayList<Player>();
		for(int i = 0; i < 36; i++) {
			if(i == 2 || i == 3 || i == 14 || i == 18)
				fields.add(new Hole());
			else
			if(i == 5 || i == 7 || i == 21 || i == 30 || i == 35)
				fields.add(new Unstable());
			else
				fields.add(new Field());
		}
		for(int i = 0; i < 36; i++) {
			if(i-6 >=0 && i-6 <= 35) {
				fields.get(i).SetNeighbour(1, fields.get(i-6));
			}
			if(i + 1 >=0 && i + 1 <=35 && i%6 != 5) {
				fields.get(i).SetNeighbour(2, fields.get(i+1));
			}
			if(i+6 >= 0 && i+6 <= 35) {
				fields.get(i).SetNeighbour(3, fields.get(i+6));
			}
			if(i-1 >= 0 && i-1 <=35 && i%6 != 0) {
				fields.get(i).SetNeighbour(4, fields.get(i-1));
			}
		}
		
		infoFrame = new InfoFrame();
		
		mw = new MapWindow(infoFrame);
		
		for(int i = 0; i < 36; i++) {
			fields.get(i).Register(mw.GetClickableComponent(i));
			mw.GetClickableComponent(i).Update(fields.get(i));
		}
		Random rng = new Random();
		for(int i = 0; i < fields.size(); i++) {
			fields.get(i).AddSnow(rng.nextInt(3)+1);
		}
			
		Eskimo e1 = new Eskimo();
		Eskimo e2 = new Eskimo();
		Explorer ex1 = new Explorer();
		Explorer ex2 = new Explorer();
		
		players.add(e1);
		players.add(e2);
		players.add(ex1);
		players.add(ex2);
		
		names.put(e1, "Eskimo András");
		names.put(e2, "Eskimo Béla");
		names.put(ex1, "Explorer Cecilia");
		names.put(ex2, "Explorer Dora");
		
		infoFrame.SetNamesMap(names);
		
		for(int i = 0; i < players.size(); i++) {
			fields.get(0).AddCharacter(players.get(i));;
		}
		
		fields.get(35).AddCharacter(polarbear);
		int partType = 1;
		for(int i = 0; i < 36; i++) {
			if(i == 4 ||i == 26 || i == 35) {
				Part part = new Part();
				part.SetType(partType);
				fields.get(i).SetItem(part);
				partType++;
			}
			else if(i == 7)
				fields.get(i).SetItem(new FragileShovel());
			else if(i == 8)
				fields.get(i).SetItem(new Suit());
			else if(i == 0 || i == 9)
				fields.get(i).SetItem(new TentBuilder());
			else if(i == 12)
				fields.get(i).SetItem(new Shovel());
			else if(i == 15)
				fields.get(i).SetItem(new Rope());
			else if(i == 23 || i == 25)
				fields.get(i).SetItem(new Food());
		}
		Food food = new Food();
		food.SetPlayer(players.get(0));
		players.get(0).AddItem(food);
		
		
		players.get(0).AddItem(new Shovel());
		
		TentBuilder tb = new TentBuilder();
		tb.SetPlayer(players.get(2));
		players.get(2).AddItem(tb);
		
		Rope rope = new Rope();
		rope.SetPlayer(players.get(0));
		players.get(0).AddItem(rope);
		
		for(int i = 0; i <3; i++) {
			Part p = new Part();
			p.SetType(i+1);
			p.SetPlayer(players.get(0));
			players.get(0).AddItem(p);
		}
		
	}
	
	/**
	 * Checks if the round has ended and starts a new round
	 */
	public static void RoundCheck() {
		boolean allWorkZero = true;
		for(Player p : players ) {
			if(p.GetWork() > 0) {
				allWorkZero = false;
			}
		}
		if(allWorkZero) {
			NextRound();
		}
	}
	/**
	 * Ends the game if a player has died
	 * Not used in skeleton
	 */
	public static void GameOver() {
		mw.GameOverMessage();
	}
	/**
	 * Ends the game if the players won
	 * Not used in skeleton
	 */
	public static void Win() {
		mw.WinMessage();
	}
	
	/**
	 * Starts the next round.
	 */
	public static void NextRound() {
		Random rng = new Random();
		if(polarbear != null) {
			boolean valid = false;
			int index = 0;
			while(!valid) {
				index = rng.nextInt(4)+1;
				if(polarbear.GetField().GetNeighbour(index)!=null)
					valid = true;
			}
			polarbear.Step(index);
		}
		int random = rng.nextInt(100);
		if(random < 75) {
			SnowStorm();
		}
		for(Field f : fields) {
			for(Tent t: tents) {
				if(f.GetIgloo() == t) {
					f.RemoveIgloo();
				}
			}
		}
		tents.clear();
		for(Player p : players ) {
			p.AddWork(4);
			p.SetDrowning(2);
		}
	}
	
	/**
	 * Adds snow to random fields
	 */
	public static void SnowStorm() {
		Random rng = new Random();
		int numberOfSelectedFields = 0;
		numberOfSelectedFields = rng.nextInt(fields.size());
		ArrayList<Field> selectedFields = new ArrayList<Field>();
		for(int i = 0; i < numberOfSelectedFields; i++) {
			int selectedField = rng.nextInt(fields.size());
			selectedFields.add(fields.get(selectedField));
		}
		for(Field f : selectedFields) {
			int snow = rng.nextInt(4);
			f.AddSnow(snow);
		}
	}
	
	/**
	 * Returns the list of players
	 * @return The list of players
	 */
	public static ArrayList<Player> GetPlayers(){
		return players;
	}
	
	/**
	 * Adds a player to the list of players
	 * @param p the player to be added
	 */
	public void AddPlayer(Player p) {
		players.add(p);
	}
	/**
	 * Add an Field to the fields list
	 * @param f the Field
	 */
	public void AddField(Field f) {
		fields.add(f);
	}
	/**
	 * PROTO only! Adds snow to all fields
	 */
	public static void SnowStormAll() {
		for(Field f: fields) {
			f.AddSnow(3);
		}
	}
	/**
	 * Adds a tent to the tents list
	 * @param t the new tent
	 */
	public static void AddTent(Tent t) {
		tents.add(t);
	}
	/**
	 * Sets the polarbear to p
	 * @param p the polarbear
	 */
	public void SetPolarBear(PolarBear p) {
		polarbear = p;
	}
	
	public static void ResetGame() {
		Random rng = new Random();
		for(Field f: fields) {
			f.RemoveAllCharacters();
			f.AddSnow(-1000);
			f.RemoveIgloo();
			f.AddSnow(rng.nextInt(3)+1);
		}
		for(Player p: players) {
			p.RemoveAllItems();
			p.ResetStats();
		}
		for(int i = 0; i < players.size(); i++) {
			fields.get(0).AddCharacter(players.get(i));;
		}
		
		fields.get(35).AddCharacter(polarbear);
		int partType = 1;
		for(int i = 0; i < 36; i++) {
			if(i == 4 ||i == 26 || i == 35) {
				Part part = new Part();
				part.SetType(partType);
				fields.get(i).SetItem(part);
				partType++;
			}
			else if(i == 7)
				fields.get(i).SetItem(new FragileShovel());
			else if(i == 8)
				fields.get(i).SetItem(new Suit());
			else if(i == 0 || i == 9)
				fields.get(i).SetItem(new TentBuilder());
			else if(i == 12)
				fields.get(i).SetItem(new Shovel());
			else if(i == 15)
				fields.get(i).SetItem(new Rope());
			else if(i == 23 || i == 25)
				fields.get(i).SetItem(new Food());
		}
		
	}
}
