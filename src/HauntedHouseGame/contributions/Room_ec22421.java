package HauntedHouseGame.contributions;

class Room_ec22421 extends Room {
	
	public Direction visit(Visitor visitor, Direction from) {
		
		Direction to = from; //Initialise to with from, this will likely change as the user moves on. To is just default to from.
		char user_choice;
		char[] options = {'a', 'b', 'c', 'd'};
		
		//Keys to avoid multiple visits.
		Item keyToA = new Item("Been to option A");
		Item keyToB = new Item("Been to option B");
		Item keyToC = new Item("Been to option C");
		
		//User gets into the room and some options are given to the user.
		visitor.tell("Hi, you are in the room ec22421, this is an abandoned lab in the middle of the Sahara desert. The lights are off, there is something on the ceiling which looks like an alarm, a table with lots of notes on it and a weird looking creature in a glass tube in front of you. You have to make a choice to continue your journey and survive...\n\nDo you\n");
        user_choice = visitor.getChoice("a) Walk towards the wall to use the light switch\nb) Take a look at the notes on the table\nc) Take a close look to the glass tube to learn more about it\nd) Leave the room", options);
        
        //If-else blocks to match user's choices with actions.
        if(user_choice == 'a' && !(visitor.hasEqualItem(keyToA))) {
        	visitor.tell("You chose to use the switch, when you did so, the lights turned on and you started to see better. Thanks to the light you managed to see the 5 golds standing on the ground. You got 5 golds!");
        	visitor.giveGold(5); //Gives 5 golds to the user.
        	visitor.giveItem(keyToA); //Gives the key of A to the user to avoid multiple visits.
        }
        else if (user_choice == 'b' && !(visitor.hasEqualItem(keyToB))) {
        	visitor.tell("You chose to take a look at the notes on the table. You saw that they belong to a doctor named Sam. You also found 5 golds in a letter between the notes with an address written on the letter.");
        	visitor.giveGold(5);
        	visitor.giveItem(keyToB);
        }
        else if(user_choice == 'c' && !(visitor.hasEqualItem(keyToC))) {
        	//An if-else block introduced here affected by users initial choices.
        	if (visitor.hasEqualItem(keyToA)) {
        		visitor.tell("You carefully approached the tube, in the last moment, thanks to the lights you turned on, you saw a wire on the ground and avoided stumbling. You found 5 golds behind the tube and decided not to mess with it any further.");
            	visitor.takeGold(5);
            	visitor.giveItem(keyToC);
        	}
        	else {
        		visitor.tell("You walked towards the tube. Since lights are off and you can't see anything, you stumbled because of a wire on the ground and broke the tube. The creature woke up and right when it was about to attack you, a guard appeared from nowhere and killed it. You were grateful that you were safe but he took 10 golds from you in the cost of saving you.");
            	visitor.takeGold(10);
            	visitor.giveItem(keyToC);
        	}
        }
        else if(user_choice == 'd') {
        	//User chooses to leave, 4 options given to the user, each representing a direction.
        	user_choice = visitor.getChoice("Which direction do you want to leave from?\na) South\nb) West\nc) North\nd) East", options);
        	if(user_choice == 'a') {
        		visitor.tell("You decided to leave the room from south.");
        		to = Direction.TO_SOUTH; 
        	}
        	else if(user_choice == 'b') {
        		visitor.tell("You decided to leave the room from west.");
        		to = Direction.TO_WEST;
        	}
        	else if(user_choice == 'c') {
        		visitor.tell("You decided to leave the room from north.");
        		to = Direction.TO_NORTH;
        	}
        	else if(user_choice == 'd') {
        		visitor.tell("You decided to leave the room from east.");
        		to = Direction.TO_EAST;
        	}
        }
        else {
        	//Printed to the user to inform them about why they can't choose the option they wanted to choose.
        	visitor.tell("You already have been there.");
        }
        return to;
	}

}
