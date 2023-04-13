package OOP.ec22612.MP.contributions;

class Room_ec22486 extends Room{
    static final Item dinasour = new Item("A cute little dinasour toy");
    static final Item lego = new Item("New lego set");
    static final Item jellycat = new Item("This is the new croissant jellycat that has been released");
    static final Item OldKey = new Item("OldKey11");

    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        visitor.tell("Welcome to my room.");
        Direction direction;
        char[] yesorNo = {'y', 'n'};
        char yesOrNoChoice = visitor.getChoice("Have you been in this room before? y/n", yesorNo);
        if (yesOrNoChoice == 'y'){
            visitor.tell("Great, would you like to have a look again, maybe you missed something?");
        }
        else if (yesOrNoChoice =='n'){
            visitor.tell("Perfect! Enjoy exploring. Would you like to buy any of the items in the room?");
        }
        visitor.tell("In front of you you can see a small dinasour toy, a new lego set, and a croissant jellycat");
        char[] input = {'1', '2', '3'};
        char inputChoice = visitor.getChoice("Which one of the items would you like to buy: \n 1. Dinasour toy (3 gold) \n 2. Lego set (6 gold) \n 3. Croissant jellycat (7 gold)", input);
        if (inputChoice == '1'){
            if(visitor.hasIdenticalItem(dinasour)== true){
                visitor.tell("You already have this item");
            }
            visitor.takeGold(3);
            visitor.giveItem(dinasour);
            visitor.tell("I hope you like your new dinasour toy that you bought");
            direction = Direction.TO_EAST;
        }
        if (inputChoice == '2'){
            if(visitor.hasIdenticalItem(lego)== true){
                visitor.tell("You already have this item");
            }
            visitor.takeGold(6);
            visitor.giveItem(lego);
            visitor.tell("You just bought the newest lego set that is released! Have fun building it");
            direction = Direction.TO_NORTH;
        }
        if (inputChoice == '3'){
            if(visitor.hasIdenticalItem(jellycat)== true){
                visitor.tell("You already have this item");
            }
            visitor.takeGold(7);
            visitor.giveItem(jellycat);
            visitor.tell("Yay you bought the croissant jellycat. Just because you bought this toy, here is a little gift from me");
            visitor.giveGold(4);
            direction = Direction.TO_EAST;
        }
        if (visitor.hasEqualItem(OldKey)){
            visitor.tell("Oh you found my friend. I've been looking for this key for a very long time. Take this gift from me as a show of my appreciation.");
            visitor.giveGold(6);
            direction = Direction.TO_SOUTH;
        }
        else {
            visitor.tell("You just missed you opportunity of buying a cute dinasour toy or a brand new lego set");
            direction = Direction.opposite(directionVistorArrivesFrom);
        }
        return direction;
    }
    
}
