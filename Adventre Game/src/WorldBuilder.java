
public class WorldBuilder {

	public static void generateWorld() {

//				imagineRoom
//				generateRoomType
//				fillRoom
//				generateDescription
//				actuallyGenerateRoom
//				findDoors
//				generateRoom on the most-clockwise room

		int startingX = (int) (Math.random() * Map.map.length);
		int startingY = (int) (Math.random() * Map.map[0].length);

		System.out.println("Starting Point: " + startingX + ", " + startingY);
		newRoom(startingX, startingY, 0);

	}

	public static void newRoom(int x, int y, int depth) {

		System.out.println("\nGenerating Room (" + x + ", " + y + ") with doorWeight of "+ ((int) (getDoorWeight(depth + 1)*100)));
		// generate room at (x,y)
		Map.generateRoom(x, y, null, getDoorWeight(depth + 1));

		// BRANCH OUT TO OTHER ROOMS

		// North
		if (y != 0) {
			 try {
				 if (Map.map[x][y - 1] == null && Map.map[x][y].getDoors()[0] == "north") {
					System.out.println("Moving North From (" + x + ", " + y + ")");
					newRoom(x, y - 1, depth + 1);
				 }
			 } catch (Exception e) {
				 
			 }
		}
		

		// West
		if (x != 0) {
			try {
				if (Map.map[x - 1][y] == null && Map.map[x][y].getDoors()[1] == "west") {
					System.out.println("Moving West From (" + x + ", " + y + ")");
					newRoom(x - 1, y, depth + 1);
				}
			}catch (Exception e) {
				
			}
		}

		// South
		if (y != Map.map[0].length) {
			try {
				if (Map.map[x][y + 1] == null && Map.map[x][y].getDoors()[2] == "south") {
					System.out.println("Moving South From (" + x + ", " + y + ")");
					newRoom(x, y + 1, depth + 1);
				}
			} catch (Exception e) {
				
			}
		}

		// East
		if (x != Map.map.length) {
			try {
				if (Map.map[x + 1][y] == null && Map.map[x][y].getDoors()[3] == "east") {
					System.out.println("Moving East From (" + x + ", " + y + ")");
					newRoom(x + 1, y, depth + 1);
				}
			} catch (Exception e) {
				
			}
		}
		

	}

	public static int getDoorWeight(int depth) {
		int reach = 100;
//		System.out.println("depth:"+depth);
//		System.out.println("reach:"+reach);
		double fraction = (double) depth/reach;
//		System.out.println("depth/reach:"+a);
		double doorWeight = 1 - Math.pow(0.1, ((-1*fraction)+1));
		return (int) (doorWeight * 100);

	}
}
