
public class Map
	{

		static Room[][] map = new Room[10][10];

		public Room[][] getMap()
			{
				return map;
			}

		public void setMap(Room[][] map)
			{
				Map.map = map;
			}

		public static void generateRoom(int x, int y, String roomType, int doorWeight)
			{

				map[x][y] = new Room(roomType, generateDoors(x, y, doorWeight), null, "Just a Generic Room");

			}

		public static String[] generateDoors(int x, int y, int doorWeight)
			{

				String north = "north";
				String west = "west";
				String south = "south";
				String east = "east";
				String[] directions = { north, west, south, east };

				String[] doors = new String[4];
				
				
				// First set all rooms as random
				 System.out.println("setting rooms to random for room at"+x+", "+y);
				 System.out.println(doorWeight);
				for (int i = 0; i < directions.length; i++) {
					int random = (int)(Math.random() *100)+1;
					System.out.println(random);
					if (random < doorWeight) {
						doors[i] = directions[i];
//						 System.out.println("randomly created door facing "+directions[i]);
					}
				}
//				System.out.println("Rands doors  "+doors[0]+":"+doors[1]+":"+doors[2]+":"+doors[3]);
				
				
				
				
				// Second , check all adjacent rooms, and if one exists, make
				// the doors consistent

				// NORTH
				System.out.println("Checking North");
				try {
					// if room above, set to that room
					System.out.println("Room Test: "+map[x][y - 1].getDoors()[2]);
					if (map[x][y - 1].getDoors()[2] != null) {
						doors[0] = north;
					} else {
						doors[0] = null;
					}
				
				} catch (Exception e) {
					System.out.println("Caught");
					// if no room allowed, make it null
					// System.out.println("No room existed north, door not made");
					doors[0] = null;
				}
				
				System.out.println("North Checked");

				// WEST
				try {
					// if room to left, set to that room
					if (map[x - 1][y] != null) {

						if (map[x - 1][y].getDoors()[3] == east) {
							doors[1] = west;
						} else {
							doors[1] = null;
						}
					}
				} catch (Exception e) {
					// if no room allowed, make it null
					// System.out.println("No room existed west, door not made");
					doors[1] = null;
				}

				// SOUTH
				try {
					if (map[x][y + 1] != null) {
						// if room below, set to that room

						if (map[x][y + 1].getDoors()[0] == south) {
							doors[2] = south;
						} else {
							doors[2] = null;
						}
						// System.out.println("Door facing South made
						// consistent");
					}
				} catch (Exception e) {
					// if no room allowed, make it null
					// System.out.println("No room existed south, door not made");
					doors[2] = null;
				}

				// EAST
				try {
					if (map[x + 1][y] != null) {
						// if room below, set to that room

						if (map[x + 1][y].getDoors()[1] == west) {
							doors[3] = east;
						} else {
							doors[3] = null;
						}
						// System.out.println("Door facing East made
						// consistent");
					}
				} catch (Exception e) {
					// if no room, make it null
					// System.out.println("No room existed east, door not made");
					doors[3] = null;
				}

				 System.out.println("Final doors  "+doors[0]+":"+doors[1]+":"+doors[2]+":"+doors[3]);

				return doors;

			}

			}
