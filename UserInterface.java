package collatz;

import java.awt.Color;
import javax.swing.*;

public class UserInterface {
	JFrame frame;
	JPanel panel;
	JLabel userLabelError;
	JButton inputButton; 
	JButton calculateButton;
	JButton exitButton;
	JLabel calculation;
	JLabel userLabel; 
	
	static JTextField userText;
	
	Keyboard keyboard; 
	
	//UserInterface omvat het gedeelte dat de gebruiker ziet wanneer het programme geopend wordt.
	public UserInterface() {    
        frame = new JFrame("Let'z Collatz!");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        panel = new JPanel();    
		panel.setLayout(null);
		
		userLabel = new JLabel("Enter number:");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);
        
		userLabelError = new JLabel("Enter integer!");
		userLabelError.setBounds(10,40,80,25);
		userLabelError.setVisible(false);
		userLabelError.setForeground(Color.red);
        panel.add(userLabelError);

        userText = new JTextField();
        userText.setBounds(10,70,165,25);
        panel.add(userText);

        calculateButton = new JButton("Collatz!");
        calculateButton.setBounds(10, 100, 80, 25);
        calculateButton.addActionListener(e -> calculateButtonClicked());
        panel.add(calculateButton); 
		
		exitButton = new JButton("exit"); 
		exitButton.setBounds(210, 320, 60, 25); 
		exitButton.addActionListener(e -> exitButtonClicked()); 
		exitButton.setForeground(Color.red);
		panel.add(exitButton); 
		
		inputButton = new JButton("on-screen keyboard"); 
		inputButton.setBounds(10, 320, 150, 25); 
		inputButton.addActionListener(e -> inputButtonClicked()); 
		panel.add(inputButton); 
		
		calculation = new JLabel("");
		calculation.setBounds(10, 110, 150, 20);
		calculation.setForeground(Color.blue);
		calculation.setVisible(true);
		panel.add(calculation); 
		
		frame.add(panel);
        frame.setVisible(true);
        
        keyboard = new Keyboard(); 
    }
	
	//Wanneer de exit button wordt ingedrukt, stopt het programma met draaien.
	public void exitButtonClicked() {
		System.exit(0); 
		return;
	}
	
	//Onderstaande methode roept de keyboard methode aan. Het keyboard wordt nu getoond op het scherm.
	public void inputButtonClicked() {
		keyboard.inputFieldFull = ""; 
    	keyboard.frame.setVisible(true);
	}
	
	//De calculateButton roept onderstaande methode aan. Hier wordt de calculate class aangeroepen die de collatz reeks produceert.
	public void calculateButtonClicked() {
		String number = userText.getText(); 
		Calculate calculate = new Calculate(); 
		if(calculate.checkInt(number)) {
			if(calculate.checkMaxNum(Integer.parseInt(number))) {
				frame.dispose(); 
				calculate.Calculate(Integer.parseInt(number)); 
			} else {
				userLabelError.setVisible(true);
			}
		} else {
			userLabelError.setVisible(true);
		}
	}
}

	