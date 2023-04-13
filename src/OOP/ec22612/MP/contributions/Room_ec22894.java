package OOP.ec22612.MP.contributions;

class Room_ec22894 extends Room {

    private boolean light = false;
    private boolean emptydraw = false;
    static final Item straw_hat = new Item("Straw Hat");

    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {

        visitor.tell("You entered a room from " + directionVisitorArrivesFrom);
        visitor.tell("There are various items to be obtained...");
        if (light) {
            visitor.tell("The room is dimly lit");
        }
        else {
            visitor.tell("The room is pitch black");
        }

        char lightOnOrOff = visitor.getChoice("Would you like to turn the light on or off [o/f]", new char[] {'o', 'f'});

        if(lightOnOrOff == 'o') {
            if(light) {
                visitor.tell("The light is already on");
            }
            else {
                visitor.tell("You turned the light on");
                light = true;
            }
        }
        else {
            if(light) {
                visitor.tell("The light is now off");
                light = false;
            }
            else {
                visitor.tell("The room remains to be in the darkness");
            }
        }

        char options = visitor.getChoice("There are 3 options for you to do...\n" +
                "a) Open the drawer\n" +
                "b) Look around for other items\n" +
                "c) leave the room\n", new char[] {'a', 'b', 'c'});

        if(options == 'a') {
            if(emptydraw) {
                visitor.tell("The draw is empty");
            }
            else {
                if(visitor.hasIdenticalItem(new Item("key"))) {
                    visitor.tell("The draw has been opened...\n" + "You found some gold!");
                    visitor.giveGold(3);
                    emptydraw = true;
                }
                else {
                    visitor.tell("You do not have a key... the draw will remain closed");
                }
            }
        } else if (options == 'b') {
            if(light) {
                visitor.tell("You found a straw hat on a table");
                visitor.giveItem(straw_hat);
                visitor.tell("You picked up the straw hat and found gold underneath it!");
                visitor.giveGold(3);
            }
            else {
                visitor.tell("As you looked around you tripped");
                visitor.tell("Some gold dropped and you cant find it because its dark!");
                visitor.takeGold(2);
                visitor.tell("");
            }
        } else if (options == 'c') {
            visitor.tell("you leave the room");
            return Direction.opposite(directionVisitorArrivesFrom);
        }
        return Direction.opposite(directionVisitorArrivesFrom);
    }
    
}
