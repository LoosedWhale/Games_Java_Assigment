import java.util.*;
public class Hashmapgames {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> gameHash = new HashMap<>();
		gameHash.put("Minecraft", "Microsoft");
		gameHash.put("RDR2", "Rockstar");
		System.out.println(gameHash);

		while(true) {
			System.out.println("Välj en operation:"
					+ "\n1. Printa ut alla spel"
					+ "\n2. Printa ut alla företag"
					+ "\n3. Printa ut spelsamligen"
					+ "\n4. Sök efter ett spel"
					+ "\n5. Sök efter ett företag"
					+ "\n6. Lägg till ett nytt spel"
					+ "\n7. Avsluta programmet");
							
            
            String choice = sc.nextLine();
		
		
            switch (choice) {
            	
            //Skriv ut alla spel	
            case "1": {
            	for (String i : gameHash.keySet()) {
            	      System.out.println("Spel: " + i);
            	}
            	break;
            }
            //Skriv ut alla företag
			case "2": {
				for (String i : gameHash.keySet()) {
          	      System.out.println("Företag: " + gameHash.get(i));
				}         	
				 break;
            }
			
			//Skriv ut spel samlingen
			case "3": {
				for (String i : gameHash.keySet()) {
          	      System.out.println("Spel: " + i + " Företag: " + gameHash.get(i));
				}
            	break;
            }
			//Sök efter ett spel
			case "4": {
				System.out.println("Vilket spel vill du söka efter:");
				sc.nextLine();
				String game = sc.nextLine();
				
				if (gameHash.containsKey(game)) {
					System.out.println("Spelet finns");
					break;
					
				} else {
					System.out.println(game + " Finns inte, vill du läga till det?");
					System.out.println("1. Ja");
					System.out.println("2. Nej");
					int choiceAdd = sc.nextInt();
			        sc.nextLine();
			        if (choiceAdd == 1) {
			        	addGame(gameHash, sc);	
			        } else {
			        	System.out.println("Alr");
			        	
			        }
	
				}
            	
            	break;
            }
			//Sök efter ett företag
			case "5": {
			    System.out.println("Vilket företag vill du söka efter:");
			    //sc.nextLine();
			    String company = sc.nextLine();

			    boolean found = false;
			    for (String game : gameHash.keySet()) {
			        String gameCompany = gameHash.get(game);
			        if (gameCompany.equalsIgnoreCase(company)) {
			            System.out.println("Spel: " + game);
			            found = true;
			        }
			    }

			    if (!found) {
			        System.out.println("Inget spel hittades från företaget: " + company);
			    }
            	
			    
            	break;
            
			}
			//Lägg till ett nytt spel
			case "6": {
				addGame(gameHash, sc);
            	break;
            }
            
			//Stänger programmet
			case "7":
	        	sc.close();
	        	System.exit(0);
	        //Default 	
	        default: 
	        	System.out.println("Ogitligt val. Försök igen.");
	        	   break;
	        	   		
            
            } // Main While loop
            
		
		
		}
		
		
	}

	
	public static void addGame(HashMap<String, String> gameHash, Scanner sc) {
        System.out.println("Ange namnet på det nya spelet:");
        String newGame = sc.nextLine();

        System.out.println("Ange företaget för det nya spelet:");
        String newCompany = sc.nextLine();

        gameHash.put(newGame, newCompany);
        System.out.println("Spel tillagt: " + newGame + " (Företag: " + newCompany + ")");
    }
}
