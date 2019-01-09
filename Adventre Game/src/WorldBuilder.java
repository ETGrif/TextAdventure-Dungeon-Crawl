import java.util.ArrayList;
public class WorldBuilder {

		
		
		
	public static void generateWorld() {

//				

		//P.S. this should be a bell curve, so that its more likely to start towards the center of the map
		int startingX = (int) (((Math.random() * Map.map.length)  +  (Math.random() * Map.map.length))/2);
		int startingY = (int) (((Math.random() * Map.map.length)  +  (Math.random() * Map.map.length))/2);

		System.out.println("Starting Point: " + startingX + ", " + startingY);
		Player.setPlayerX(startingX);
		Player.setPlayerY(startingY);
		
		//start off the branch
		newRoom(startingX, startingY, 0);
		
		//choose an entrance and exit
		
		
		
		
		
		
		System.out.println("Map generated");
		
		
	}

	public static void newRoom(int x, int y, int depth) {

//		System.out.println("\nGenerating Room (" + x + ", " + y + ") with doorWeight of "+ getDoorWeight(depth + 1));
		// generate room at (x,y)
		Map.generateRoom(x, y, getDoorWeight(depth + 1));

		// BRANCH OUT TO OTHER ROOMS

		// North
		if (y != 0) {
			 try {
				 if (Map.map[x][y - 1] == null && Map.map[x][y].getDoors()[0] == "north") {
//					System.out.println("Moving North From (" + x + ", " + y + ")");
					newRoom(x, y - 1, depth + 1);
				 }
			 } catch (Exception e) {
				 
			 }
		}
		

		// West
		if (x != 0) {
			try {
				if (Map.map[x - 1][y] == null && Map.map[x][y].getDoors()[1] == "west") {
//					System.out.println("Moving West From (" + x + ", " + y + ")");
					newRoom(x - 1, y, depth + 1);
				}
			}catch (Exception e) {
				
			}
		}

		// South
		if (y != Map.map[0].length) {
			try {
				if (Map.map[x][y + 1] == null && Map.map[x][y].getDoors()[2] == "south") {
//					System.out.println("Moving South From (" + x + ", " + y + ")");
					newRoom(x, y + 1, depth + 1);
				}
			} catch (Exception e) {
				
			}
		}

		// East
		if (x != Map.map.length) {
			try {
				if (Map.map[x + 1][y] == null && Map.map[x][y].getDoors()[3] == "east") {
//					System.out.println("Moving East From (" + x + ", " + y + ")");
					newRoom(x + 1, y, depth + 1);
				}
			} catch (Exception e) {
				
			}
		}
//		System.out.println("Retacing from ("+x+","+y+")");

	}

	public static int getDoorWeight(int depth) {
		int reach = 5;
//		System.out.println("depth:"+depth);
//		System.out.println("reach:"+reach);
		double fraction = (double) depth/reach;
//		System.out.println("depth/reach:"+a);
		double doorWeight = 1 - Math.pow(0.1, ((-1*fraction)+1));
		return (int) (doorWeight * 100);

	}

	public static String generateRoomType(String[] doors) {
	
		//STEP ONE get the general room structure
		
		int closedDoors = 0;
		for(String d:doors) {
			if(d == null) {
				closedDoors++;
			}
		}
		
		String chosen;
		
		switch(closedDoors) {
		
		case 3:
			//Dead end
//			System.out.println("This is a Deadend room");
			String[] deadEndTypes = {"Dead End", "Treasure Room","Closet","Cellar","Bunks","Armory","Office","Prison"
			};
			chosen= randomString(deadEndTypes);
			break;
			
		case 2:
			if (doors[0] == doors[2] || doors[1] == doors[3]) {
				//hallway
//				System.out.println("This is a Straight room");
				String[] hallwayTypes = {"Hallway","Guarded Entrance","TrapS","Storage Room"
				};
				chosen = randomString(hallwayTypes);
				break;
			}else{
				//turn
//				System.out.println("This is a Turn room");
				String[] turnTypes  = {"HallTurn", "HallTurn","TrapT"
				};
				chosen = randomString(turnTypes);
				break;
			}
		
		case 1:
			//T-Shaped
//			System.out.println("This is a T room");
			String[] tShapedTypes = {"Library","Lounge T","Bare Room T"
			};
			chosen = randomString(tShapedTypes);
			break;
			
		case 0:
			//all four
//			System.out.println("This is an All room");
			String[] AllSideTypes = {"Center Room","Canteen","Lounge A","Bare Room A"
			};
			chosen = randomString(AllSideTypes);
			break;
			
		default:
//			System.out.println("Something went terribly wrong! Very bad.");
			chosen = null;
			
			break;
		}
//		System.out.println(chosen);

		
		return chosen;
		}
	
	public static String randomString(String[] strings) {
		int index = (int)(Math.random()*strings.length);
		String chosen = strings[index];
		return chosen;
	}
	
	public static void chooseDeadEnd() {
			ArrayList<Room> deadends = new ArrayList<Room>();
			for(int y = 0; y < Map.map[0].length; y++){
				for(int x = 0; x< Map.map.length; x++){
					//if a deadend, add it to arraylist
					
					
				}
			}
			
			
	}
	
	
	
	
	//gotta work this out
//	public static String generateDescriptions(int x, int y, String roomType) {
//		 
//		
//		
//	}
	
	
	
	
	
	
	
	
	}
	
	
	
	

