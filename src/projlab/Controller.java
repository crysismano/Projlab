package projlab;

import java.util.ArrayList;
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
	private static ArrayList<Field> fields = new ArrayList<Field>();
	/**
	 * All of the players
	 */
	private static ArrayList<Player> players = new ArrayList<Player>();
	/**
	 * List of tents
	 */
	private static ArrayList<Tent> tents = new ArrayList<Tent>();
	/**
	 * The polarbear
	 */
	private static PolarBear polarbear; 
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
			if(i + 1 >=0 && i + 1 <=35) {
				fields.get(i).SetNeighbour(2, fields.get(i+1));
			}
			if(i+6 >= 0 && i+6 <= 35) {
				fields.get(i).SetNeighbour(3, fields.get(i+6));
			}
			if(i-1 >= 0 && i-1 <=35) {
				fields.get(i).SetNeighbour(4, fields.get(i-1));
			}
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
		System.out.println("Game Over!");
	}
	/**
	 * Ends the game if the players won
	 * Not used in skeleton
	 */
	public static void Win() {
		System.out.println("Winner!");
	}
	
	/**
	 * Starts the next round.
	 */
	public static void NextRound() {
		Random rng = new Random();
		int random = rng.nextInt(100);
		if(random < 75) {
			SnowStorm();
		}
		for(Player p : players ) {
			p.AddWork(4);
			p.SetDrowning(2);
		}
		for(Field f : fields) {
			for(Tent t: tents) {
				if(f.GetIgloo() == t) {
					f.RemoveIgloo();
				}
			}
		}
		tents.clear();
		if(polarbear != null) {
			polarbear.Step(rng.nextInt(polarbear.GetField().GetNeighboursSize()) + 1);
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
}
