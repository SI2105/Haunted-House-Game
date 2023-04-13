package OOP.ec22612.MP.contributions;

class Room_ec22946 extends Room
{
	private Direction FINAL_DIRECTION;
	private Item compass = new Item("Compass");
	private boolean visited = false;
	
	public Direction visit(Visitor visitor, Direction direction_vistor_arrives_from)
	{
		if(!visited)
		{
			visitor.tell("You are at a crossroads.");
			
			char cardinal_points[] = new char[] {'N','E','S','W'};
			
			char compass_point_chosen_by_visitor = visitor.getChoice("Choose a cardinal direction", cardinal_points);
			
			if(compass_point_chosen_by_visitor == 'N')
			{FINAL_DIRECTION = Direction.TO_NORTH;}
			else if(compass_point_chosen_by_visitor == 'E')
			{FINAL_DIRECTION = Direction.TO_EAST;}
			else if(compass_point_chosen_by_visitor == 'S')
			{FINAL_DIRECTION = Direction.TO_SOUTH;}
			else if(compass_point_chosen_by_visitor == 'W')
			{FINAL_DIRECTION = Direction.TO_WEST;}
			else
			{FINAL_DIRECTION = Direction.UNDEFINED;}
		}

		boolean visitor_has_compass = visitor.hasEqualItem(compass);
		
		if(!visitor_has_compass && visitor.takeGold(10) >= 4)
			visitor.giveItem(compass);
		else if(direction_vistor_arrives_from == Direction.opposite(FINAL_DIRECTION))
		{
			visitor.giveGold(4);
			visitor.takeGold(-4);
		}
		
		visited = true;
		
		if(visitor_has_compass)
			return FINAL_DIRECTION;
		else
			return Direction.opposite(direction_vistor_arrives_from);
	}
}
