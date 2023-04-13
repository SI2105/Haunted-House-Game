package OOP.ec22612.MP.contributions;

public class Room_ec22675 extends Room {

    private int chestContents = 500;
    // every other person will be lucky
    private boolean lucky = true;
    private int keysToGive = 12;
    private static final Item key = new Item("Key");

    // users can set trap for the next user
    private boolean trapsEnabled = false;


    @Override
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        Direction directionTheyTravelledTo = Direction.opposite(directionVistorArrivesFrom);
        visitor.tell("You travelled" + directionTheyTravelledTo + " and are now in my room");
        visitor.tell("Heres 20 gold for coming to this room!");
        visitor.giveGold(20);

        visitor.tell("There is a chest here which may contain some gold. You have to pay 5 gold to open it.");
        visitor.tell("If other users have taken all the gold, then you will not get any gold, will you take this risk?");
        char choice = visitor.getChoice("Will you take the risk and open the chest for 5 gold?", new char[]{'y', 'n'});
        if (choice == 'y') {
            visitor.takeGold(5);
            visitor.tell("You have chosen to open the chest...lets see if theres any gold left...");
            if (chestContents == 0 ) {
                visitor.tell("Theres no gold left oh no");
            } else {
                visitor.tell("Well done you get 10 gold");
                visitor.giveGold(10);
                chestContents -= 10;
            }

        } else {
            visitor.tell("There was " + chestContents + " gold left in the chest if you opened it!");
        }

        if (this.lucky) {
            visitor.tell("You're lucky, heres 12 gold");
            visitor.giveGold(12);
        }

        this.lucky = !this.lucky;

        if (!trapsEnabled) {
            visitor.tell("Traps have been disabled, would you like to enable them for the next user?");
            char input = visitor.getChoice("Enable traps (y/n)", new char[]{'y','n'});
            if (input == 'y') {
                visitor.tell("The next user doesnt know whats coming. Traps are enabled.");
                this.trapsEnabled = true;
            } else {
                visitor.tell("Ok, traps not enabled for the next user");
            }
        } else {
            visitor.tell("The previous user set the traps up for you, you will lose 5 gold if possible");
            int goldTaken = visitor.takeGold(5);
            visitor.tell(goldTaken + " gold taken!");
            this.trapsEnabled = false;
            visitor.tell("You may now exit the room.");
        }
        if (keysToGive > 0) {
            visitor.tell("I have " + keysToGive + " Keys left which you may find useful in some other rooms, here you go");
            visitor.giveItem(key);
            keysToGive--;
        }
        
        // leave continuing from the direction they arrived here
        return directionVistorArrivesFrom;
    } 
    
}