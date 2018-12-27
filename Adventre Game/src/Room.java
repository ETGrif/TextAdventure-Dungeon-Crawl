import java.util.ArrayList;
public class Room
	{
		private String roomType;
		private String[] doors;
		private ArrayList objects;
		private String description;
		
		
		public Room(String rT, String[] ds, ArrayList ob, String de){
			roomType = rT;
			doors = ds;
			objects = ob;
			description = de;
			
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
				return objects;
			}
		public void setThingsInRoom(ArrayList thingsInRoom)
			{
				this.objects = thingsInRoom;
			}
		
	}

