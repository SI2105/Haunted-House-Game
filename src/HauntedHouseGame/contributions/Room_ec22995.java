package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22995 extends Room {
	// Items that can be given to the user (one of them only)
	static final Item Dagger = new Item("Dagger");
	static final Item Shuriken = new Item("Shuriken");
	static final Item Sword = new Item("Sword");
	
	// Boolean wether you found the key or not
	boolean foundKey = false;
	
	// Keeps track of what remains in the chest.
	//
	static int chestGold = 7;

	public Direction visit(Visitor visitor, Direction arriving){
		int directionNumber = get_directionNumber(arriving);

		switch (directionNumber) {
			case 1:
				return enteringMysteryRoom(arriving, visitor);
			case 2:
				return enteringMysteryRoom(arriving, visitor);
			case 3:
				return wrongDirection(arriving, visitor);
			case 4:
				return wrongDirection(arriving, visitor);
			case 5:
				return Lost(arriving, visitor);
			default: break;
		}
		return Direction.opposite(arriving);
	}
	
	// returns an integer depending on the arriving direction of the user
	//
	private int get_directionNumber(Direction arriving) {
		if (arriving == Direction.FROM_SOUTH) return 1;
		if (arriving == Direction.FROM_EAST) return 2;
		if (arriving == Direction.FROM_NORTH) return 3;
		if (arriving == Direction.FROM_WEST) return 4;
		if (arriving == Direction.UNDEFINED) return 5;
		else return 0;
	}

	// The user is lost, returns undefined direction
	private Direction Lost(Direction arriving, Visitor visitor) {
		visitor.tell("Sorry my brother you're lost. We can't help you here so see you soon I guess...");
		return Direction.UNDEFINED;
	}
	
	// The user isn't arriving from a valid direction, returns the opposite direction
	//
	private Direction wrongDirection(Direction arriving, Visitor visitor) {
		visitor.tell("Sorry you need to arrive from either south or east in order to see the door of the mystery room. \nYou turn around and leave.");
		return Direction.opposite(arriving);
	}
	
	// The user chooses wether he enters the room or not
	//
	private Direction enteringMysteryRoom(Direction arriving, Visitor visitor) {
		char[] YesNo = {'y', 'n'};
		visitor.tell("Welcome visitor, you are about to enter the mystery Room of the Winchester Mystery House. Are you sure you want to be part of this thrilling adventure ?");
		char choice = visitor.getChoice("(Y) Yes, bring me to wonderland (N) No, let me stay an ignorant fool...", YesNo);
		
		if (choice == 'y') {
			MysteryRoomQuest(visitor);
			if (foundKey) {
				boolean open = openNorthDoor(visitor);
				if (open) {
					return Direction.TO_NORTH; 
				}
				else {
					return Direction.TO_WEST;
				}
			}
			else {
				return Direction.TO_WEST;
			}
		}
		else {
			visitor.tell("You chose not to enter the Room. \nBye Bye, you're missing something... \nYou turn around and leave.");
		}
		return Direction.opposite(arriving);
	}
	
	// Allows the user to choose if he wants to use the key, returns a boolean depending on his choice
	//
	private boolean openNorthDoor(Visitor visitor) {
		char[] YesNo = {'y', 'n'};
		visitor.tell("Congratulations, you found the key of the north door, do you wish to open it?");
		char choice = visitor.getChoice("(Y) Yes open it (N) No, open the west door.", YesNo);
		if (choice == 'y') {
			visitor.tell("You open the north door with the key, Bye Bye...");
			return true;
		}
		else {
			visitor.tell("You chose not to open it and open the west door, Bye Bye...");
			return false;
		}
	}
	
	// The main method for the room's quest
	//
	private void MysteryRoomQuest(Visitor visitor) {
		visitor.tell("As you enter the room a ninja asks you if you want to take one of his weapons, careful in your choice, this quest might get dangerous.");
		
		ninjaNewItem(visitor);
		openChest(visitor);
		
		visitor.tell("Now that you're ready and armed (or not?) you walk deeper into the room.");
		
		visitingRoom(visitor);
		
	}
	
	// The user decides if he accepts a new item
	//
	private void ninjaNewItem(Visitor visitor) {
		char[] possibleChoices = {'a', 'b', 'c', 'd'};
		char choice = visitor.getChoice("(a) Shuriken (b) Sword (c) Dagger (d) No thanks", possibleChoices);
		if (choice == 'a') {
			visitor.giveItem(Shuriken);
		}
		if (choice == 'b') {
			visitor.giveItem(Sword);
		}
		if (choice == 'c') {
			
			visitor.giveItem(Dagger);
		}
		if (choice == 'd') {
			visitor.tell("You didn't want any weapon, what an adventurer !");
		}
		return;
	}
	
	// The user decides if he open's the chest
	//
	private void openChest(Visitor visitor) {
		char[] possibleChoices = {'y', 'n'};
		char choice = visitor.getChoice("There is a chest in front of you do you choose to open it? (y) YESSSS (n) no", possibleChoices);
		if (choice == 'y'){
			if (chestGold > 0) {
				visitor.tell("You open the chest and see " + chestGold + " gold pieces, you try to reach them and take the more you can");
				int givenGold = randomAmount();
				visitor.tell("You were able to take " + givenGold + " pieces of gold");
				visitor.giveGold(givenGold);
				chestGold -= givenGold;
			}
			else if (chestGold == 0) {
				visitor.tell("Sorry you opened the chest but it was empty, you move on.");
			}
		}
		if (choice == 'n') {
			visitor.tell("You don't open the chest and move on.");
		}
	}
	
	// returns a random integer between 1 and the amount of gold remaining in the chest
	//
	private int randomAmount() {
		Random random = new Random();
		int givenGold = random.nextInt(chestGold)+1;
		return givenGold;
	}
	// The user visits the room and go deeper in it
	//
	private void visitingRoom(Visitor visitor) {
		visitor.tell("As you go deeper you start hearing noises, like people complaining. You're wondering what are all those complaints about and suddenly while you're still in your thoughts a vampire attacks you and tries to bite your neck ! \nYou have no choice, you'll have to fight. Unfortunately the Dagger is the only weapon that will have an effect on the vampire.");
		
		if (visitor.hasIdenticalItem(Dagger)) {
			visitor.tell("You are equipped with a Dagger, you kill the vampire and take his money.");
			visitor.giveGold(3);
		}
		else if (visitor.hasIdenticalItem(Sword) || visitor.hasIdenticalItem(Shuriken)) {
			visitor.tell("The vampire bites you and take some gold out of your pocket before flying away.");
			visitor.takeGold(5);
		}
		else {
			visitor.tell("You didn't take any weapon from the ninja and the vampire is greatful for that, you become friends and he gives you the key of the north door");
			this.foundKey = true;
		}
		return;
	}
}
