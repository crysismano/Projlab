package projlab;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoFrame extends JFrame{
	
	private Player selectedPlayer;
	
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
		JPanel pnPanel0;
		JComboBox<String> cmbCharacter;
		JLabel lbTemp;
		JLabel lbTempValue;
		JLabel lbWork;
		JLabel lbDrowning;
		JComboBox<String> cmbItem;
		JButton btPick;
		JComboBox<String> cmbDirection;
		JLabel lbAbilityResult;
		JLabel lbWorkValue;
		JLabel lbStateValue;
		JButton btUse;
		JButton btDig;
		JButton btStepUp;
		JButton btStepRight;
		JButton btStepDown;
		JButton btStepLeft;
		JButton btEnd;
		JButton btAbility;

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

		lbTempValue = new JLabel( "5"  );
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
		
		lbWorkValue = new JLabel( "4"  );
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
		
		lbStateValue = new JLabel( "Drowning"  );
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

		lbAbilityResult = new JLabel( "Capacity: 10"  );
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
	}

}
