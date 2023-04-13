package OOP.ec22612.MP.contributions;

public class Room_lt19211 extends Room {

    Item Moth = new Item("Moth");

    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {

        visitor.tell("Welcome to the next room. In front of you are 3 chests, you may open only one of them, or none of them. Whatever you find inside is your's to keep");

        String optionsYouHave = "[1] you open the chest on the right, [2] you open the chest in the middle, [3] you open the chest on the left";
        char[] arrayOfOptionsYouHave = {'1', '2', '3'};

        int option = visitor.getChoice(optionsYouHave, arrayOfOptionsYouHave);

        if (option == '1') {
            visitor.giveGold(10);
            visitor.tell("You got 10 gold pieces!");
        } else if (option == '2') {
            visitor.giveGold(1);
            visitor.tell("You got 1 gold piece!");
        } else if (option == '3'){
            visitor.giveItem(Moth);
            visitor.tell("You got Moths - thats to say - you got nothing");
        }

        return Direction.opposite(directionVistorArrivesFrom);
    }
}
