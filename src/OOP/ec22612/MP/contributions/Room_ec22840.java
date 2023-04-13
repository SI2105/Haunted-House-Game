package OOP.ec22612.MP.contributions;

import java.util.Random;
class Room_ec22840 extends Room{
	
	static final Item [] items = {new Item("diamond necklace"),new Item("Creepy Doll"),new Item("Candle"),new Item("elixir"),new Item ("Compass"),new Item("Key")};
	static final Item [] gooditem ={new Item("Candle"),new Item("elixir"),new Item ("Compass"),new Item("Key")};
	static boolean visited = false;
	
	
	public Direction visit (Visitor visitor, Direction d)
	{
		if(!visited)
		{
			visitor.tell("WELLCOME TO MY MYSTERY ROOM :)");
			visitor.tell ("To escape you have to open boxes in the room and get the Key");
			visitor.tell("Would you like to come in ?");
			char [] option = new char[] {'a','b','c'};
			char userchoice = visitor.getChoice("Please choose a.come in and give me a token b. come in without giving me a token c. exit my room ",option);
			
			if (userchoice == 'a')
			{
				visitor.takeGold(1);
				visitor.tell("Since you are kind and give me a token I will make it easier for you.");
				Random r = new Random();
				int random = r.nextInt(gooditem.length);
				Item obtain = gooditem[random];
				if (random == 3) 
				{
					visitor.giveItem(obtain);
					visitor.tell("You are so lucky to get the key!");
					visitor.tell("Thank you for visiting!");
					visited = true;
					visitor.tell("You now leave,bye");
					return Direction.opposite(d);	
				}
				else if (random == 1) 
				{
					visitor.giveItem(obtain);
					visitor.tell("You get the elixir! You only have to give me 1 token to leave");
					visitor.takeGold(1);
					visited = true;
					visitor.tell("You now leave,bye");
					return Direction.opposite(d);
				}
				else 
				{
					visitor.giveItem(obtain);
					visitor.tell("You did not get the key, I will collect 3 token from you and let you go");
					visitor.takeGold(3);
					visited = true;
					visitor.tell("You now leave,bye");
					return Direction.opposite(d);
					

				}
				
			}
			else if (userchoice == 'b') 
			{
				visitor.tell ("You are so selfish, you are not going to escape my room hahahahaha!!");
				Random r = new Random();
				int random = r.nextInt(items.length);
				Item obtain = items[random];
				if (random == 5 )
				{
					obtain = items[5];
					visitor.giveItem(obtain);
					visitor.tell("You are so lucky to get the key! I will let you leave.");
					visitor.tell("Thank you for visiting!");
					visited = true;
					visitor.tell("You now leave,bye");
					return Direction.opposite(d);				
				}
				else 
				{
					visitor.giveItem(obtain);
					visitor.tell("You did not get the key, I will collect 5 token from you and let you go");
					visitor.takeGold(5);
					visited = true;
					visitor.tell("You now leave,bye");
					return Direction.opposite(d);
				}
			}
			else if (userchoice == 'c') 
			{
				visitor.tell("Goodbye, see you next time");
				return Direction.opposite(d);
			}
			
		}
		return Direction.opposite(d);
	}

}
