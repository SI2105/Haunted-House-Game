package OOP.ec22612.MP.contributions;

class Room_ec22697 extends Room {

    static final Item BLACKCAT = new Item("Cat");
    static final Item CREEPYDOLL = new Item("Weird-looking doll");

    // 'Main' bit of code; Returns the direction the visitor leaves towards.
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        
        char[] options = {'a', 'b', 'c'};

        visitor.tell("You're now standing in the room of the ghost of ec22697.");
        visitor.tell("In front of you is a small door seemingly leading to another room."); // this should go to next room
        visitor.tell("To your left is a battered wardrobe, with a faint meowing coming from it.");
        visitor.tell("To the right you see a broken doll, staring at you from the floor.");

        char choice = Character.toLowerCase(visitor.getChoice("Do you want to\n\ta) Walk through the door\n\tb) Open the wardrobe\n\tc) Walk towards the doll", options)); // Ensures that even if captials are typed, switch works

        switch (choice) {
            case 'a':
                visitor.tell("You tentatively walk through towards the door...");
                visitor.tell("Suddenly, you see a bright light, temporarily blinding you for a moment.");
                break;
            
            case 'b':
                choiceB(visitor, options);
                break;

            case 'c':
                choiceC(visitor, options);
                break;
        }

        visitor.tell("You look around and find yourself outside of the room of ec22697's ghost.");
        visitor.tell("You turn around, only to discover that the door has now vanished.");

        return Direction.opposite(directionVistorArrivesFrom);
    }

    // For choice B - opening the wardrobe
    void choiceB(Visitor visitor, char[] options) {
        visitor.tell("You creep towards the wardrobe and open it quietly.");
        visitor.tell("Inside is a little cat!");
        visitor.tell("'Meow' it says, pawing at a tin of fish next to it.");

        char choice = visitor.getChoice("Do you:\n\ta) Ignore the cat and close the wardrobe doors\n\tb) Open the tin of fish for it\n\tc) Try and stroke the cat", options);

        switch (choice) {
            case 'a':
                visitor.tell("As soon as you try to close the doors, the cat lunges at you!");
                visitor.tell("It rips open your bag of gold, scattering the gold all over the floor");
                visitor.takeGold(3);
                visitor.tell("You run away as fast as you can, hoping that the cat is too distracted by the gold to injure you further...");
                break;
        
            case 'b':
                visitor.tell("You slowly start to open the tin of fish...");
                visitor.tell("You just about manage to open it!");
                visitor.tell("The cat instantly perks up and eats all of the fish in one go!");
                visitor.tell("The cat moves from its corner in the wardrobe - It's been sitting under a pile of gold this whole time!");
                visitor.tell("You begin to collect the gold when the cat climbs onto your shoulder.");
                visitor.giveGold(4);
                visitor.tell("'Meow' it says, and climbs onto your head");
                visitor.giveItem(BLACKCAT);
                visitor.tell("You close the wardrobe doors and begin to walk out the room...");
                break;
            
            case 'c':
                visitor.tell("You reach your hand out the stroke the cat when it suddenly starts scratching you!");
                visitor.tell("You try and run out as fast as you can not realising that the cat has scratched a hole in your bag of gold!");
                visitor.takeGold(2);
                break;
        }
        return;
    }

    // For choice C - Approaching the doll
    void choiceC(Visitor visitor, char[] options) {
        visitor.tell("As soon as the doll hears you walk fowards, it starts to wail loudly.");
        
        // Hopefully it works if other people also give out random cats!
        if (visitor.hasEqualItem(BLACKCAT)) {
            visitor.tell("Interesting - the doll's wailing quietens slightly when it sees the cat...");
        } else {
            visitor.tell("If only you had a cat...");
        }

        char choice = visitor.getChoice("Do you\n\ta) Try and play with the doll\n\tb) Run away\n\tc) Try and rock her to sleep", options);

        switch (choice) {
            case 'a':
                if (visitor.hasEqualItem(BLACKCAT)) {
                    visitor.tell("Your cat slowly creeps towards the doll and curls up next to it");
                    visitor.tell("The baby falls asleep instantly!");
                    visitor.tell("You wait for a momemnt to check that the doll is still asleep");
                    visitor.tell("Zzz\nZzzz\nZzzzz");
                    visitor.tell("You quietly pick up your cat and walk towards the door...");
                } else {
                    visitor.tell("You quietly approach the doll and give it a piece of gold to play with");
                    visitor.takeGold(1);
                    visitor.tell("It stops wailing and starts babbling happily at you!");
                    visitor.tell("You roll another piece of gold towards the doll to try and distract it as you leave...");
                    visitor.takeGold(1);
                }
                break;
        
            case 'b':
                visitor.tell("You turn around to run away when the doll's wailing becomes even louder!");
                visitor.tell("You sprint as fast as you can, covering your ears to try to dampen the sounds of its wailing");
                visitor.tell("In your haste, you fail to hear the clinking of gold coins dropping to the floor behind you...");
                visitor.takeGold(2);
                break;

            case 'c':
                visitor.tell("You slowly start to rock the doll back and forth until it falls asleep");
                visitor.tell("2 Gold coins fall out of its hands!");
                visitor.tell("You place the baby down gently, pick up the gold and make your way to the door...");
                visitor.giveGold(2);
                break;
        }
        return;
    }
}