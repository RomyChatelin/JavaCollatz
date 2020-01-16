package collatz;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Keyboard {

	//Frame en panel waar interface op verschijnen
	static JFrame frame;
	JPanel panel; 
	
	//de variabelen die ervoor zorgen dat alle nummers binnenin de Keybaord methode
	String buttonText; 
	JButton calculateButton; 

	static String inputFieldFull = ""; 
	UserInterface userInterface; 
	JTextField userText;
	public static boolean keyBoardClicked; 
	
	public Keyboard() {
		
        frame = new JFrame("Keyboard");
        frame.setSize(200, 200);

        panel = new JPanel();    
		panel.setLayout(null);
		
		//Wanneer het frame gesloten wordt door middel van een click, wordt het frame onzichtbaar gemaakt.
		//Op deze manier kan er op een makkelijke manier voor gezorgd worden dat er altijd maar één keyboard scherm geopend is.
		//En wordt er tussen de methodes afgewisseld tussen een keyboard frame dat zichtbaar/onzichtbaar is.
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
        JButton calculateButton;
		
        //Het aanmaken van de buttons wordt gedaan aan de hand van vijf for-loops. 
        //Elke button roept de buttonText methode aan.
		for(int i = 1; i <4; i++) {
			String buttonText = String.valueOf(i); 
			calculateButton  = new JButton(buttonText);
	        calculateButton.setBounds(30*i, 20, 30, 30);
	        calculateButton.setMargin(new Insets(0, 0, 0, 0));
	        calculateButton.addActionListener(e -> buttonText(buttonText)); 
	        panel.add(calculateButton); 
		}
		
		for(int i = 4; i <7; i++) {
			String buttonText = String.valueOf(i); 
			calculateButton  = new JButton(buttonText);
	        calculateButton.setBounds(30*(i-3), 50, 30, 30);
	        calculateButton.setMargin(new Insets(0, 0, 0, 0));
	        calculateButton.addActionListener(e -> buttonText(buttonText)); 
	        panel.add(calculateButton); 
		}
		
		for(int i = 7; i <10; i++) {
			String buttonText = String.valueOf(i); 
			calculateButton  = new JButton(buttonText);
	        calculateButton.setBounds(30*(i-6), 80, 30, 30);
	        calculateButton.setMargin(new Insets(0, 0, 0, 0));
	        calculateButton.addActionListener(e -> buttonText(buttonText)); 
	        panel.add(calculateButton); 
		}
		
		for(int i = 0; i<1; i++) {
			String buttonText = String.valueOf(i); 
			System.out.println(buttonText); 
			calculateButton  = new JButton(buttonText);
	        calculateButton.setBounds(60, 110, 30, 30);
	        calculateButton.setMargin(new Insets(0, 0, 0, 0));
	        calculateButton.addActionListener(e -> buttonText(buttonText)); 
	        panel.add(calculateButton); 		
	    	System.out.println(calculateButton); 
		}
		
		for(int i = 0; i<1; i++) {
			String buttonText = "-"; 
			System.out.println(buttonText); 
			calculateButton  = new JButton(buttonText);
	        calculateButton.setBounds(30, 110, 30, 30);
	        calculateButton.setMargin(new Insets(0, 0, 0, 0));
	        calculateButton.addActionListener(e -> buttonText(buttonText)); 
	        panel.add(calculateButton); 		
	    	System.out.println(calculateButton); 
		}
		
		frame.add(panel);
        frame.setVisible(false);

	}
	
	//De methode buttonText omvat de string die wordt aangemaakt door het aanklikken van buttons op het onscreen keyboard.
	//De waardes worden doorgegeven aan de userInterface class die de String verwerkt en op deze manier de juiste informatie toont.
	public void buttonText(String buttonText) {
		inputFieldFull = userInterface.userText.getText();
		
		if(buttonText == "-") {
			String inputFieldAdd = buttonText;
			inputFieldFull += inputFieldAdd;
			userInterface.userText.setText(inputFieldFull); 
		} else {
		
			int inputNum = Integer.parseInt(buttonText); 
			
			for(int i = 0; i < 10; i++) {
				if(inputNum == i) {
					String inputFieldAdd = String.valueOf(inputNum); 
					inputFieldFull += inputFieldAdd;
					userInterface.userText.setText(inputFieldFull); 
				}
			}
		}
	}
	
	
}
