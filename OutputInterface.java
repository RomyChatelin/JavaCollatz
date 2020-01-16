package collatz;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class OutputInterface {
	//Frame en panel waar interface op verschijnen
	JFrame frame;
	JPanel panel; 

	//Buttons om te kunnen navigeren door de applicatie
	JButton calculateButton;
	JButton exitButton;
	JButton againButton; 

	//Verschillende labels en textareas die de tekst weergeven nadat er berekeningen hebben plaatsgevonden
	JLabel userLabel; 
	JTextField userText;
	JTextArea calculation;
	JTextArea calculationRed;
	JLabel cyclusNum; 
	JLabel cyclusText; 
	JLabel calculationText; 

	//Instantiëren van het keyboard en de userinterface. 
	UserInterface userInterface;
	Keyboard keyboard; 
	
	public OutputInterface() {    
        frame = new JFrame("Let'z Collatz!");
        frame.setSize(350, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();    
		panel.setLayout(null);

		exitButton = new JButton("exit"); 
		exitButton.setBounds(260, 400, 60, 25); 
		exitButton.addActionListener(e -> exitButtonClicked()); 
		exitButton.setForeground(Color.red);
		panel.add(exitButton); 
		
		againButton = new JButton("again"); 
		againButton.setBounds(180, 400, 70, 25); 
		againButton.addActionListener(e -> againButtonClicked()); 
		panel.add(againButton); 
		
		calculationText = new JLabel("Numbers in sequence:");
		calculationText.setBounds(10, 150, 300, 25);
		calculationText.setVisible(true);
		panel.add(calculationText); 

		//Textarea die de berekening toont. Er is gebruik gemaakt van de scrollfunctie,
		//En van de setLineWrap en setWrapStyleWord om alles netjes te verspreiden over de textarea.
		calculation = new JTextArea("");
		calculation.setLineWrap(true);
		calculation.setWrapStyleWord(true);
		calculation.setForeground(Color.blue);
		calculation.setVisible(true);
		calculation.setEditable(false);
		JScrollPane scroll = new JScrollPane ( calculation );
		scroll.setBounds(10, 180, 300, 200);
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		panel.add(scroll); 

		cyclusNum = new JLabel("Collatz-cyclus:");
		cyclusNum.setBounds(10, 15, 250, 40);
		cyclusNum.setVisible(true);
		cyclusNum.setFont(new Font("", Font.BOLD, 25));
		panel.add(cyclusNum); 
		
		cyclusText = new JLabel("");
		cyclusText.setBounds(10, 50, 300, 25);
		cyclusText.setVisible(true);
		panel.add(cyclusText); 
		
		calculationRed = new JTextArea("");
		calculationRed.setVisible(true);
		calculationRed.setEditable(false);
		JScrollPane scrollCyclus = new JScrollPane (calculationRed); 
		scrollCyclus.setBounds(10, 80, 200, 60);
		scroll.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
		panel.add(scrollCyclus); 
		calculationRed.setForeground(Color.red);
		
		frame.add(panel);
        frame.setVisible(true);
    }

	//Systeem wordt afgesloten wanneer er op de exitbutton geklikt wordt.
	public void exitButtonClicked() {
		System.exit(0); 
		return;
	}

	//UserInterface wordt opnieuws opgestart (waar het invoerveld in staat)
	//De string die alles bijhoudt vanaf het invoerveld voor het keyboard, wordt leeggehaald.
	public void againButtonClicked() {
		frame.dispose();
		userInterface = new UserInterface(); 
		keyboard.inputFieldFull = ""; 
		return;
	}
}
