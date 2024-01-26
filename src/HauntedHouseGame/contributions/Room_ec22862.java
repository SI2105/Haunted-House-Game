package HauntedHouseGame.contributions;

class Room_ec22862 extends Room {
    private boolean lightsOn = false;
    private boolean shelfEmpty = false;
    private boolean shopkeeperPresent = true;

    
    public Direction visit(Visitor visitor, Direction arrivedFrom) {
        visitor.tell("You've entered Room_ec22862, which is currently said to be one of the most haunted rooms within the house. At the moment, it is ");
        if (lightsOn) {
            visitor.tell("well-lit and  ");
        } else {
            visitor.tell("dimly-lit and ");
        }
        if (!shelfEmpty) {
            visitor.tell("the room is surrounded by shelves that fully go around the room and are tighly packed with items. ");
        } else {
            visitor.tell("room is surrounded by shelves that fully go around the room but seem fully empty. ");
        }
        if (shopkeeperPresent) {
            visitor.tell("A transparent counter can like surface can be seen in one of the corners with a ghastly individual standing behind it");
        } else {
            visitor.tell("A transparent counter can be seen with nothing around it ");
        }

        
        char[] options = {'a', 'b', 'c'};
        int choice = visitor.getChoice("What would you like to do? a.light the candles, b.pry open the trunk, or c. try to interact with the poltergeist?", options);
        if (choice == 'a') {
            if (!lightsOn) {
                visitor.tell("You light the candles and the room brightens up.");
                lightsOn = true;
            } else {
                visitor.tell("The candles are already lit.");
            }
        } else if (choice == 'b') {
            if (shelfEmpty) {
                visitor.tell("You approach the shelves but still find them empty.");
            } else {
                visitor.tell("You approach the shelves and find a camera.");
                visitor.giveItem(new Item("camera"));
                shelfEmpty = true;
            }
        } else if (choice == 'c') {
            if (shopkeeperPresent) {
                visitor.tell("You approach the ghostly shopkeeper who offers you an item for free, but as you leave you realise it has taken some of your gold");
                visitor.takeGold(2);
                
            } else {
                visitor.tell("You attempt to speak to the ghostly shopkeeper but it gradually vanishes away with a devious smile");
                visitor.takeGold(3);
                shopkeeperPresent = false;
            }
        }

        
        return Direction.opposite(arrivedFrom);
    }
}
