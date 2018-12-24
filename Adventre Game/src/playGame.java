
import java.util.Scanner;
public class playGame
	{
		static Scanner userInput = new Scanner(System.in);
		public static void main(String[] args)
			{
				
//				for(int y = 0; y < Map.map[0].length; y++){
//					for(int x = 0; x < Map.map.length; x++){
//						String blank = userInput.nextLine();
//						Map.generateRoom(x,y, null, 1);
//						System.out.println("\n\n");
//					}
//				}
			
			
			
			WorldBuilder.generateWorld();
			
				
			}
		
		
		
		
		
	}
