import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Game> gameCollection = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		gameCollection.add(new Game("Minecraft"));
		gameCollection.add(new Game("CSGO"));
		gameCollection.add(new Game("GTA"));
		gameCollection.add(new Game("Valorant"));
		gameCollection.add(new Game("Roblox"));
		gameCollection.add(new Game("Fifa"));
		gameCollection.add(new Game("Forza"));
		gameCollection.add(new Game("Overwatch"));		
		
		while(true) {
			System.out.println("Välj en operation:");
            System.out.println("1. Printa ut alla spel");
            System.out.println("2. Sök efter ett spel");
            System.out.println("3. Lägg till ett nytt spel");
            System.out.println("4. Ersätt ett spel med ett annat spel");
            System.out.println("5. Avsluta programmet");
           
           int choice = scanner.nextInt();
           
           switch (choice) {
           case 1:
        	   for (Game game: gameCollection) {
        		   System.out.println(game);
        	   }
        	   break;
        	   
           case 2:
        	   scanner.nextLine();
        	   System.out.println("Vilket spel vill du söka efter:");
        	   String searchName = scanner.nextLine();
        	   boolean found = false;
        	   for (Game game: gameCollection) {
        		   if (game.namn.equalsIgnoreCase(searchName)) {
        			   System.out.println("Hittat spel; " + game);
        			   found = true;
        			   break;
        		   }
        	   }
        	   if (!found) {
        		   System.out.println("Spelet gittades inte.");
        	   }
        	   break;
       
           case 3:
	           scanner.nextLine();
	           System.out.println("Ange namnet på spelet du vill lägga till; ");
	           String newName = scanner.nextLine();
	           Game newGame = new Game(newName);
	           gameCollection.add(newGame);
	           System.out.println("Nytt spel har lagts till:" + newGame);
	           break;
           case 4:
        	   scanner.nextLine();
        	   System.out.println("Ange spelet du vill ersätta;");
        	   String repName = scanner.nextLine();
        	   System.out.println("Ange namnet på det nya spelet;");
        	   String newGameName = scanner.nextLine();
        	   
        	   for (int i = 0; i < gameCollection.size(); i++) {
        	   		Game game = gameCollection.get(i);
        	   		if(game.namn.equalsIgnoreCase(repName)) {
        	   			Game newGamerep = new Game(newGameName);
        	   			gameCollection.set(i,  newGamerep);
        	   			break;
        	   		}
           		}
        	   	break;
           case 5:
        	   scanner.close();
        	   System.exit(0);
           default: 
        	   System.out.println("Ogitligt val. Försök igen.");
        	   break;
        	   		
           }
        		   
		}
		
		
		
	}

}




class Game {
	String namn;


	public Game(String namn) {
		this.namn = namn;
	}
		
	@Override
	public String toString() {
		return namn;
	
	}

}