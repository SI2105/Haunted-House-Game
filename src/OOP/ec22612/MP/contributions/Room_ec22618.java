package OOP.ec22612.MP.contributions;

class Room_ec22618 extends Room
{
	private Direction to_direction;
	private Item light = new Item("Torch");
	private boolean visited = false;
	
	public Direction visit(Visitor person, Direction from_direction)
	{
		if(!visited)
		{
			person.tell("There is 4 direction. Enter the direction as N,E,S or W (North,East,South,West)");
			
			char A_direction[] = new char[] {'N','E','S','W'};
			
			char Chosen_direction = person.getChoice("Pick a direction", A_direction);
			
			if(Chosen_direction == 'N')
			{to_direction = Direction.TO_NORTH;}
			else if(Chosen_direction == 'E')
			{to_direction = Direction.TO_EAST;}
			else if(Chosen_direction == 'S')
			{to_direction = Direction.TO_SOUTH;}
			else if(Chosen_direction == 'W')
			{to_direction = Direction.TO_WEST;}
			else
			{to_direction = Direction.UNDEFINED;}
		}
		boolean has_torch = person.hasEqualItem(light);
		
		if(!has_torch)
		{
			person.tell("You left the room");
			person.tell("Due to frustration of not finding anything you brought a torch with 1 gold to prevent this from happen again.");
			person.takeGold(1);
			person.giveItem(light);
			person.tell("But the merchant accidentally drop the gold without noticing it. so you got your gold back.");
			person.giveGold(1);
		}
		else if(from_direction == Direction.opposite(to_direction))
		{
			person.giveGold(5);
			person.tell("You found some gold(5)");
		}

		visited = true;

		if(has_torch)
			return to_direction;
		else
			return Direction.opposite(from_direction);
	}
}