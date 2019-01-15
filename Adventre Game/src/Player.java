import java.util.ArrayList;
import java.util.Scanner;

public class Player
	{

		static Scanner userInput = new Scanner(System.in);

		private String name;
		static int playerX;
		static int playerY;
		private int hp;
		private ArrayList inventory;

		public static int getPlayerX()
			{
				return playerX;
			}

		public static void setPlayerX(int playerX)
			{
				Player.playerX = playerX;
			}

		public static int getPlayerY()
			{
				return playerY;
			}

		public static void setPlayerY(int playerY)
			{
				Player.playerY = playerY;
			}

		
		
		public static void act(){
				System.out.println("\n\n");
				Room currentRoom = Map.map[playerX][playerY];
//				System.out.println("You are in a "+ currentRoom.getRoomType() + " room. There are some doors...");
				currentRoom.printDescription();
				move();
		}
		
		public static void move()
			{
				// Find possible doors
				// String[] doors = {"North","West","East"};
				String[] doors = shortenedDoors(Map.map[playerX][playerY].getDoors());
				System.out.println("Which direction do you move?");
				for (int i = 0; i < doors.length; i++) {
					System.out.println((i + 1) + ": move " + doors[i]);
				}

				int response = 0;
				String res;
				// if its an entrance, it needs "exit" as a choice
				if (Map.map[playerX][playerY].getRoomType() == "Entrance") {
					System.out.println((doors.length + 1) + ": exit dungeon");
					response = askResponse(doors.length + 1);
					if (response == doors.length + 1) {
						res = "exit";
					} else {
						res = doors[response - 1];
					}
				} else {
					response = askResponse(doors.length);
					System.out.println("You chose to move " + doors[response - 1]);
					res = doors[response - 1];
				}
				// actually move in that direction
				switch (res)
					{
					case "north":
						// System.out.println("north");
						playerY--;
						return;

					case "west":
						// System.out.println("west");
						playerX--;
						return;

					case "south":
						// System.out.println("south");
						playerY++;
						return;

					case "east":
						// System.out.println("east");
						playerX++;
						return;

					case "exit":
						System.out.println("You exit the dungeon.");
						System.exit(0);
						return;

					default:
						System.out.println("Something went wrong with the directions. Response:" + doors[response - 1]);
						return;

					}

			}

		public static String[] shortenedDoors(String[] doors)
			{
				int closedDoors = Room.countClosedDoors(doors);

				String[] shortenedDoors = new String[4 - closedDoors];
				int index = 0;
				for (String d : doors) {
					if (d != null) {
						shortenedDoors[index] = d;
						index++;
					}

				}
				return shortenedDoors;
			}

		public static int askResponse(int max)
			{
				int response;
				try {
					Scanner userInput2 = new Scanner(System.in);
					response = userInput2.nextInt();
					if (response > max || response < 0) {
						System.out.println("Not a valid response, try again.");
						response = askResponse(max);

					}
				} catch (Exception e) {
					System.out.println("Not a valid response, try again.");
					response = askResponse(max);
				}
				return response;
			}

	}
