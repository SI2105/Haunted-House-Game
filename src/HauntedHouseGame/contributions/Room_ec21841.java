package HauntedHouseGame.contributions;

public class Room_ec21841 extends Room{
    private boolean lightsOn;
    private int goldAmount;

    public Room_ec21841() {
        this.lightsOn = false;
        this.goldAmount = 5;
    }
    public Direction visit(Visitor visitor, Direction direction){
        visitor.tell("Welcome to room_ec21841!");
        if (direction == Direction.FROM_NORTH){
            visitor.tell("You came from North.");
        } else if (direction == Direction.FROM_SOUTH){
            visitor.tell("You came from South.");
        } else if (direction == Direction.FROM_EAST){
            visitor.tell("You came from East.");
        } else if (direction == Direction.FROM_WEST){
            visitor.tell("You came from West.");
        }
        if (!lightsOn){
            visitor.tell("The lights are off!");
            char choice = visitor.getChoice("Would you like to turn on the lights? (y/n)", new char[]{'y', 'n'});
            if (choice == 'y'){
                visitor.tell("You turned the lights on.");
                lightsOn = true;
            } else {
                visitor.tell("You left the lights off");
            }
        }
        char choice = visitor.getChoice("There are three chests one to your left, one to your"
            +" right and one in front of you, which one would you like to choose? ", new char[]{'l','r','f'});
        if (choice == 'l'){
            visitor.takeGold(5);
            goldAmount += 5;
            visitor.tell("You chose a poisened chest. and you've lost 5 gold coins.");
        } else if (choice == 'r'){
            visitor.tell("You chose an empty chest! better luck next time!");
        } else if (choice == 'f'){
            if (visitor.hasEqualItem(new Item("key"))){
                visitor.giveGold(5);
                goldAmount -= 5;
                visitor.tell("You opened a treasure, congratulations you got 5 gold coins!");
            }
            else {
                visitor.tell("You need a key for this chest");
            }
        }
        visitor.tell("Thank you for playing in this room! come back again!");
        return Direction.opposite(direction);
    }
}
