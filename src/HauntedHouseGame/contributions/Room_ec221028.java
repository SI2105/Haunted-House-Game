package HauntedHouseGame.contributions;//Sefa A. Yildirim
// Assignment 4 submission 2

class Room_ec221028 extends Room {
	
	Item excalibur = new Item ("Excalibur");
	Item crownOfThorns = new Item ("Crown of Thorns");
    	Item wingedSandals = new Item ("Winged Sandals");
	Item staff = new Item ("Monkey King's Staff");
	Item cursedScimitar = new Item ("Cursed Scimitar");
	
    public Direction visit (Visitor visitor , Direction direction)
    {
		char [] options = {'a','b','c','d','e','f'};
			
        visitor.tell("'Welcome to Merchant Orhan's den of wonderous items!'");
        visitor.tell("It is said Orhan has items from the Sultan's own personal collection.");
		visitor.tell("'Come, come in, enter the world of your dreams...'");
		
		
        if (direction == Direction.FROM_NORTH){
            visitor.tell("You came from the frigid north I see...");
        }
        else if (direction == Direction.FROM_EAST)
        {
            visitor.tell("You came from the deserts in the east I see...");
        }
        else if (direction == Direction.FROM_SOUTH)
        {
            visitor.tell("You came from the forests in the south I see...");
        }
        else if (direction == Direction.FROM_WEST){
            visitor.tell("You came from the mountains in the east I see...");
        }
		
		String message = "Perhaps you'd like to purchase one of Orhan's wares?\n"
		+"a) Excalibur (5 gold), \n"
		+"b) Crown of Thorns (4 gold), \n"
		+"c) Winged Sandals (3 gold), \n"
		+"d) Monkey King's Staff (5 gold), \n"
		+"e) Cursed Scimitar (1 gold), \n"
		+"f) Leave empty handed.";
    	        char choice = visitor.getChoice(message, options);
		
		switch (choice){
			case 'a':
			visitor.tell("The mighty sword said to be once possessed by King Arthur himself. Excellent choice.");
			visitor.takeGold(5);
			visitor.giveItem(excalibur);
			break;
			
			case 'b':
			visitor.tell("There are man rumours of this crown's existence. You have a good eye.");
			visitor.takeGold(4);
			visitor.giveItem(crownOfThorns);
			break;
			
			case 'c':
			visitor.tell("The Winged Sandals blessed by the messenger God. It will give you great speed.");
			visitor.takeGold(3);
			visitor.giveItem(wingedSandals);
			break;
			
			case 'd':
			visitor.tell("That staff comes from the far east and can change size. Very handy for discrete work.");
			visitor.takeGold(5);
			visitor.giveItem(staff);
			break;
			
			case 'e':
			visitor.tell("No, that item is cursed. It is not available for purchase, it should not be on display. Unless you insist on purchasing it...");
			choice = visitor.getChoice("Do you really want the Cursed Scimitar?(y/n)", new char[]{'y','n'});
			if (choice == 'y'){
				visitor.takeGold(1);
				visitor.giveItem(cursedScimitar);
			} else {
				visitor.tell("Good choice.");
			}
			break;
			
			case 'f':
			visitor.tell("That too is alright, come again friend, I am always happy to serve.");
			break;
			
			default:
			visitor.tell("I cannot understand what you desire, please go.");
		}
		
		visitor.tell("I hope we meet again friend.");
        return direction.opposite(direction);
    }
}
