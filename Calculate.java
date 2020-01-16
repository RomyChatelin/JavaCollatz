package collatz;

public class Calculate {
	
	//number is hetgene wat ingevoerd wordt, er is een verschil tussen negatieve en positieve getallen
	public int number;
	private boolean negativeCheck;

	//Variabelen die nodig zijn om de cyclus en de lengte van de cyclus te bepalen
	private int highestNum; 
	private int lowestNum; 
	private int cyclusLength = 0; 
	private int finalNumberCount = 0; 
	private int checkNum; 
	
	//Variabelen die nodig zijn om alles goed op het scherm te krijgen
	private String calculationInputStringRed = "Cyclus: "; 
	private int calculationInput; 
	
	//Methode Calculate omvat de logica achter de Collatz-reeks. Er wordt een onderscheid gemaakt tussen negatieve en positieve getallen.
	//Aan de hiervan wordt de reeks geproduceerd en getoond op het scherm.
	public void Calculate(int number) {
		System.out.println(number);
		calculationInput = number; 
		String calculationInputString = String.valueOf(calculationInput) + "  "; 
		String addInput; 
		
		OutputInterface outputInterface = new OutputInterface(); 
		outputInterface.calculation.setText(calculationInputString); 
		
		if(number < 0) {
			checkNum = highestNum; 
			negativeCheck = true; 
		} else if(number > 0) {
			checkNum = lowestNum; 
			negativeCheck = false;
		}
		
		if(number != 0) {
			checkNum = number; 
			
			while(finalNumberCount != 2) {
				
				if((number % 2) == 0) {
					number = number / 2; 
					addInput = String.valueOf(number); 
					calculationInputString = calculationInputString + addInput + "  " ; 
					outputInterface.calculation.setText(calculationInputString);
					
					if(checkNum == number) {
						finalNumberCount ++;
						System.out.println(finalNumberCount); 
					}
					
					if(negativeCheck) {
						if(number > checkNum) {
							checkNum = number;
						} 
					} else {
						if(number < checkNum) {
							checkNum = number;
						}
					}
					
					if(finalNumberCount == 1) {
						calculationInputStringRed = calculationInputStringRed + addInput  + " / "; 
						outputInterface.calculationRed.setText(calculationInputStringRed);
						cyclusLength++; 
					}

				} else {

					number = number * 3 + 1; 
					addInput = String.valueOf(number); 
					calculationInputString = calculationInputString + addInput  + "   "; 

					outputInterface.calculation.setText(calculationInputString);
					
					if(checkNum == number) {
						finalNumberCount ++;
					}
					
					if(negativeCheck) {
						
						if(number > checkNum) {
							checkNum = number;
						} 
					} else {
						
						if(number < checkNum) {
							checkNum = number;
						}
					}
					
					if(finalNumberCount == 1) {
						calculationInputStringRed = calculationInputStringRed  + addInput + " / "; 
						outputInterface.calculationRed.setText(calculationInputStringRed);
						cyclusLength++; 
					}
				}	
				outputInterface.cyclusText.setText("Cyclus starts with: " + checkNum +" and its length is : " + cyclusLength);
			}
		}
		
	//Wanneer er 0 wordt ingevoerd, verschijnt het volgende op het scherm:
		if(number == 0) {
			calculationInputString = "0 - 0 - 0 - [...]"; 
			outputInterface.calculation.setText(calculationInputString);
			calculationInputStringRed = "0 - 0 - 0 - ..";
			outputInterface.calculationRed.setText(calculationInputStringRed);
			outputInterface.cyclusText.setText("Cyclus starts with: " + "0" +" and its length is... well"); 
		}
	}
	
	//Methode om het maximaal in te vullen nummers in te perken 
	public boolean checkMaxNum(int number) {
		if(number > -100000000 && number < 100000000) {
			return true;
		} else {
			return false; 
		}
	}
	
	//Een methode om te checken of een String een int bevat.
	public boolean checkInt(String number) {
		try {
			Integer.parseInt(number); 
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
