import java.util.ArrayList;
public class Room
	{
		private String roomType;
		private String[] doors;
		private ArrayList thingsInRoom;
		
		public Room(String rT, String[] d, ArrayList t){
			roomType = rT;
			doors = d;
			thingsInRoom = t;
			
		}
		
		
		public String getRoomType()
			{
				return roomType;
			}
		public void setRoomType(String roomType)
			{
				this.roomType = roomType;
			}
		public String[] getDoors()
			{
				return doors;
			}
		public void setDoors(String[] doors)
			{
				this.doors = doors;
			}
		public ArrayList getThingsInRoom()
			{
				return thingsInRoom;
			}
		public void setThingsInRoom(ArrayList thingsInRoom)
			{
				this.thingsInRoom = thingsInRoom;
			}
		
		
		
		
		
		
	}

