package projlab;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoFrame extends JFrame{
	
	private Player selectedPlayer;
	private HashMap<Player, String> names;
	private Field selectedField;
	

	private JPanel pnPanel0;
	private JComboBox<String> cmbCharacter;
	private JLabel lbTemp;
	private JLabel lbTempValue;
	private JLabel lbWork;
	private JLabel lbDrowning;
	private JComboBox<String> cmbItem;
	private JButton btPick;
	private JComboBox<String> cmbDirection;
	private JLabel lbAbilityResult;
	private JLabel lbWorkValue;
	private JLabel lbStateValue;
	private JButton btUse;
	private JButton btDig;
	private JButton btStepUp;
	private JButton btStepRight;
	private JButton btStepDown;
	private JButton btStepLeft;
	private JButton btEnd;
	private JButton btAbility;
	
	public void SetNamesMap(HashMap<Player, String> hm) {
		
		names = hm;
	}
	
	public void setSelectedField(Field f) {
		cmbCharacter.removeAllItems();
		selectedField = f;
		ArrayList<Character> characters = f.GetCharacters();
		for(Character c : characters) {
			cmbCharacter.addItem(names.get(c));
		}
	}
	
	public InfoFrame(){
		super("infoPanel");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300,270);
		this.setLocation(950, 0);
		
		init();
		this.setVisible(true);
		this.setResizable(false);
		
	}
	
	public void init() {
		pnPanel0 = new JPanel();
		GridBagLayout gbPanel0 = new GridBagLayout();
		GridBagConstraints gbcPanel0 = new GridBagConstraints();
		pnPanel0.setLayout( gbPanel0 );

		String []dataCharacteCB = { "" };
		cmbCharacter = new JComboBox<String>( dataCharacteCB );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 1;
		gbcPanel0.gridwidth = 4;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( cmbCharacter, gbcPanel0 );
		pnPanel0.add( cmbCharacter );

		lbTemp = new JLabel( "Temperature:"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 2;
		gbcPanel0.gridwidth = 2;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbTemp, gbcPanel0 );
		pnPanel0.add( lbTemp );

		lbTempValue = new JLabel("-");
		gbcPanel0.gridx = 4;
		gbcPanel0.gridy = 2;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbTempValue, gbcPanel0 );
		pnPanel0.add( lbTempValue );

		lbWork = new JLabel( "Work:"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 3;
		gbcPanel0.gridwidth = 2;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbWork, gbcPanel0 );
		pnPanel0.add( lbWork );
		
		lbWorkValue = new JLabel( "-"  );
		gbcPanel0.gridx = 4;
		gbcPanel0.gridy = 3;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbWorkValue, gbcPanel0 );
		pnPanel0.add( lbWorkValue );

		lbDrowning = new JLabel( "State:"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 4;
		gbcPanel0.gridwidth = 2;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbDrowning, gbcPanel0 );
		pnPanel0.add( lbDrowning );
		
		lbStateValue = new JLabel( "-"  );
		gbcPanel0.gridx = 4;
		gbcPanel0.gridy = 4;
		gbcPanel0.gridwidth = 1;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbStateValue, gbcPanel0 );
		pnPanel0.add( lbStateValue );

		String []dataItemCB = { "" };
		cmbItem = new JComboBox( dataItemCB );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 6;
		gbcPanel0.gridwidth = 4;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( cmbItem, gbcPanel0 );
		pnPanel0.add( cmbItem );

		btPick = new JButton( "Pick up"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 10;
		gbcPanel0.gridwidth = 4;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btPick, gbcPanel0 );
		pnPanel0.add( btPick );

		String []dataDirectionCB = { "Up", "Right", "Down", "Left" };
		cmbDirection = new JComboBox<String>( dataDirectionCB );
		gbcPanel0.gridx = 7;
		gbcPanel0.gridy = 8;
		gbcPanel0.gridwidth = 4;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( cmbDirection, gbcPanel0 );
		pnPanel0.add( cmbDirection );

		lbAbilityResult = new JLabel( "Capacity: -"  );
		gbcPanel0.gridx = 7;
		gbcPanel0.gridy = 10;
		gbcPanel0.gridwidth = 4;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 1;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( lbAbilityResult, gbcPanel0 );
		pnPanel0.add( lbAbilityResult );

		btUse = new JButton( "Use Item"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 8;
		gbcPanel0.gridwidth = 4;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btUse, gbcPanel0 );
		pnPanel0.add( btUse );

		btDig = new JButton( "Dig"  );
		gbcPanel0.gridx = 1;
		gbcPanel0.gridy = 9;
		gbcPanel0.gridwidth = 4;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btDig, gbcPanel0 );
		pnPanel0.add( btDig );

		btStepUp = new JButton( "Move Up"  );
		gbcPanel0.gridx = 7;
		gbcPanel0.gridy = 1;
		gbcPanel0.gridwidth = 4;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btStepUp, gbcPanel0 );
		pnPanel0.add( btStepUp );

		btStepRight = new JButton( "Move Right"  );
		gbcPanel0.gridx = 7;
		gbcPanel0.gridy = 2;
		gbcPanel0.gridwidth = 4;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btStepRight, gbcPanel0 );
		pnPanel0.add( btStepRight );

		btStepDown = new JButton( "Move Down"  );
		gbcPanel0.gridx = 7;
		gbcPanel0.gridy = 3;
		gbcPanel0.gridwidth = 4;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btStepDown, gbcPanel0 );
		pnPanel0.add( btStepDown );
		
		btStepLeft = new JButton( "Move Left"  );
		gbcPanel0.gridx = 7;
		gbcPanel0.gridy = 4;
		gbcPanel0.gridwidth = 4;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btStepLeft, gbcPanel0 );
		pnPanel0.add( btStepLeft );

		btEnd = new JButton( "End Round"  );
		gbcPanel0.gridx = 7;
		gbcPanel0.gridy = 6;
		gbcPanel0.gridwidth = 4;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btEnd, gbcPanel0 );
		pnPanel0.add( btEnd );

		btAbility = new JButton( "Use Ability"  );
		gbcPanel0.gridx = 7;
		gbcPanel0.gridy = 9;
		gbcPanel0.gridwidth = 4;
		gbcPanel0.gridheight = 1;
		gbcPanel0.fill = GridBagConstraints.BOTH;
		gbcPanel0.weightx = 1;
		gbcPanel0.weighty = 0;
		gbcPanel0.anchor = GridBagConstraints.NORTH;
		gbPanel0.setConstraints( btAbility, gbcPanel0 );
		pnPanel0.add( btAbility );
		this.add(pnPanel0);
		
		
		PlayerSelectListener playerSelectListener = new PlayerSelectListener();
		cmbCharacter.addActionListener(playerSelectListener);
		
		UseItemButtonListener useItemButtonListener = new UseItemButtonListener();
		btUse.addActionListener(useItemButtonListener);
		
		DigButtonListener digButtonListener = new DigButtonListener();
		btDig.addActionListener(digButtonListener);
		
		PickButtonListener pickButtonListener = new PickButtonListener();
		btPick.addActionListener(pickButtonListener);
		
		StepButtonListener stepUpListener = new StepButtonListener(1);
		StepButtonListener stepRightListener = new StepButtonListener(2);
		StepButtonListener stepDownListener = new StepButtonListener(3);
		StepButtonListener stepLeftListener = new StepButtonListener(4);
		
		btStepUp.addActionListener(stepUpListener);
		btStepRight.addActionListener(stepRightListener);
		btStepDown.addActionListener(stepDownListener);
		btStepLeft.addActionListener(stepLeftListener);
		
		EndRoundButtonListener endRoundButtonListener = new EndRoundButtonListener();
		btEnd.addActionListener(endRoundButtonListener);
		
		UseAbilityButtonListener useAbilityButtonListener = new UseAbilityButtonListener();
		btAbility.addActionListener(useAbilityButtonListener);
	}
	
	public void UpdateInfoPanel() {
		cmbItem.removeAllItems();
		if(selectedPlayer != null) {
			lbTempValue.setText(String.valueOf(selectedPlayer.GetTemp()));
			lbWorkValue.setText(String.valueOf(selectedPlayer.GetWork()));
			int drowning = selectedPlayer.GetDrowning();
			if(drowning == -1)
				lbStateValue.setText("Has a suit");
			else if(drowning == 0)
				lbStateValue.setText("Is fine");
			else if(drowning == 1)
				lbStateValue.setText("Is sinking");
			else if(drowning == 2)
				lbStateValue.setText("Is drowning");
			for(Item item : selectedPlayer.GetItems()) {
				cmbItem.addItem(item.toString());
			}
		}
	}
	
	public class PlayerSelectListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String name = (String)cmbCharacter.getSelectedItem();
			for(Entry<Player, String> entry : names.entrySet()) {
				if(entry.getValue().equals(name)) {
					selectedPlayer = entry.getKey();
				}
			}
			UpdateInfoPanel();
		}
		
	}
	
	public class UseItemButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(selectedPlayer != null) {
				int idx = cmbItem.getSelectedIndex();
				selectedPlayer.UseItem(idx);
			}
			UpdateInfoPanel();
		}
		
	}
	
	public class DigButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(selectedPlayer != null)
				selectedPlayer.Dig();
			UpdateInfoPanel();
		}
		
	}
	
	public class PickButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(selectedPlayer != null)
				selectedPlayer.Pick();
			UpdateInfoPanel();
		}
		
	}
	
	public class StepButtonListener implements ActionListener{
		private int direction;
		
		public StepButtonListener(int dir) {
			direction = dir;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(selectedPlayer != null) {
				selectedPlayer.Step(direction);
			}
			UpdateInfoPanel();
		}
		
	}
	
	public class EndRoundButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(selectedPlayer != null)
				selectedPlayer.EndRound();
			UpdateInfoPanel();
			
		}
		
	}
	
	public class UseAbilityButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(selectedPlayer != null) {
				int dir = cmbDirection.getSelectedIndex() + 1;
				selectedPlayer.UseAbility(dir);
				if(selectedPlayer instanceof Explorer) {
					Explorer ex = (Explorer)selectedPlayer;
					int capacity = ex.GetLastExploredFieldCapacity();
					lbAbilityResult.setText(String.valueOf("Capacity: "+ capacity));
				}
				UpdateInfoPanel();
			}
		}
		
	}

}
