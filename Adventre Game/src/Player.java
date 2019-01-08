import java.util.Scanner;
public class Player
	{

		static Scanner userInput = new Scanner(System.in);
		
		private String name;
		static int playerX;
		static int playerY;
		private int hp;
		
		public static void move(){
				//Find possible doors
				String[] doors = {"North","West","East"};
//				String[] doors = shortenedDoors(playerX, playerY);
				System.out.println("Which direction do you move?");
				for(int i = 0; i < doors.length; i++){
					System.out.println((i+1)+": move "+doors[i]);
				}
				int response = askResponse(doors.length);
				System.out.println("You chose to move "+doors[response-1]);
				
				
		}
		
		public static String[] shortenedDoors(int x, int y){
				String[] doors = Map.map[x][y].getDoors();
				String[] shortenedDoors = new String[4-WorldBuilder.countClosedDoors()]; 
				int index = 0;
				for(String d : doors){
					if(d != null){
						shortenedDoors[index] = d;
						index++;
					}
					
				}
		}
		
		public static int askResponse(int max){
				int response;
				try{
					response = userInput.nextInt();
					if(response > max){
						System.out.println("Not a valid response, try again.");
						response = askResponse(max);
						
					}
				}catch(Exception e){
					System.out.println("Not a valid response, try again.");
					response = askResponse(max);
				}
				return response;
		}
		
		
		
	}
