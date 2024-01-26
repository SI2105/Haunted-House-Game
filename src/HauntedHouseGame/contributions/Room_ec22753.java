package HauntedHouseGame.contributions;

class Room_ec22753 extends Room{
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        Item pocketwatch = new Item("pocketwatch");
        visitor.tell("You enter a room off to the side.");
        if (directionVistorArrivesFrom == Direction.FROM_NORTH) {
            visitor.tell("You have arrived from the North Entrance");
        }else if (directionVistorArrivesFrom == Direction.FROM_EAST) {
            visitor.tell("You have arrived from the East Entrance");
        }else if (directionVistorArrivesFrom == Direction.FROM_SOUTH) {
            visitor.tell("You have arrived from the South Entrance");
        }else if (directionVistorArrivesFrom == Direction.FROM_WEST) {
            visitor.tell("You have arrived from the West Entrance");
        }else{
            visitor.tell("How did you get here?");
        }
        visitor.tell("You see two pedestals in the middle of the room");
        try {
            char choice = visitor.getChoice("On these pedestals there are two boxes which one do you reach into (A or B)", new char[]{'A','B'});
            if(choice=='A') {
                visitor.tell("You get a watch");
                visitor.tell("The watch looks pretty expensive you gain 4 gold");
                visitor.giveGold(4);
                if(visitor.hasIdenticalItem(pocketwatch)) {
                    visitor.tell("The pocketwatch you picked up and the pocketwatch you just obtained vibrate");
                    visitor.tell("You look and find that you have 3 watches. You gain 4 more gold");
                    visitor.giveGold(4);
                }
            }else if(choice=='B') {
                if(visitor.hasIdenticalItem(pocketwatch)) {
                    visitor.tell("A dark hand reaches out and checks the time using your pocketwatch");
                }else{
                    visitor.tell("A had reaches out and snatches a gold piece");
                    visitor.tell("You lose 1 Gold Piece");
                    visitor.takeGold(1);
                } 
            }
        } catch (Exception e) {
            visitor.tell("Somehow you do nothing");
        }
        return Direction.opposite(directionVistorArrivesFrom);        
    }
}