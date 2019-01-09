
import java.util.Scanner;
public class playGame
	{
		static Scanner userInput = new Scanner(System.in);
		public static void main(String[] args)
			{

//				for(int y = Map.map[0].length-1; y >= 0; y--){
//					for(int x = Map.map.length-1; x >= 0; x--){
//						System.out.println("("+x+","+y+")");
//					
//						Map.generateRoom(x,y, null, 100);
//						System.out.println("\n\n");
//					}
//				}
				
			WorldBuilder.generateWorld();
				
			
			Player.move();
			

			
			


			
			
//			for(int i = 0; i <= 100; i++) {
//				System.out.println(i +":"+ WorldBuilder.getDoorWeight(i));
//				
//			}

			
			
			

			
				
			}
		
		
		
		
		
	}
