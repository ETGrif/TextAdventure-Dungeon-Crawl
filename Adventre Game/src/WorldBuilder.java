
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

		System.out.println("Generating Room (" + x + ", " + y + ")");
		// generate room at (x,y)
		Map.generateRoom(x, y - 1, null, getDoorWeight(depth + 1));

		// BRANCH OUT TO OTHER ROOMS

		// North
		if (y != 0) {
			 
				System.out.println("Moving North From (" + x + ", " + y + ")");
				newRoom(x, y - 1, depth + 1);

			}
		

		// West
		if (x != 0) {
			if (Map.map[x - 1][y] != null) {
				System.out.println("Moving West From (" + x + ", " + y + ")");
				newRoom(x, y - 1, depth + 1);

			}
		}

		// South
		if (y != Map.map[0].length) {
			if (Map.map[x][y + 1] != null) {
				System.out.println("Moving South From (" + x + ", " + y + ")");
				newRoom(x, y - 1, depth + 1);

			}
		}

		// East
		if (x != Map.map.length) {
			if (Map.map[x + 1][y] != null) {
				System.out.println("Moving East From (" + x + ", " + y + ")");
				newRoom(x, y - 1, depth + 1);

			}
		}

	}

	public static double getDoorWeight(int depth) {
		double doorWeight = (1.05 - Math.pow(0.07, ((-.01 * depth) + 1)));
		return doorWeight;

	}
}
