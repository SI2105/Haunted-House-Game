package HauntedHouseGame.contributions;

public class Room_ec22758 extends Room {

    Item iPhone14 = new Item("iPhone14");
    Item Car_Keys  = new Item("Car Keys");
    Item Laptop = new Item("Laptop");


    
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {

        visitor.tell("You are in the room. Steal one Item.");

        String optionsYouHave = "You can choose an iPhone14 (a),Car Keys (b) or a Laptop (c)";
        char[] arrayOfOptionsYouHave = {'a', 'b', 'c'};

        int option = visitor.getChoice(optionsYouHave, arrayOfOptionsYouHave);

        if (option == 'a') {
            visitor.giveItem(iPhone14);
            visitor.tell("You stole an iPhone14");
        } else if (option == 'b') {
            visitor.giveItem(Car_Keys);
            visitor.tell("You stole a set of Car Keys");
        } else if (option == 'c'){
            visitor.giveItem(Laptop);
            visitor.tell("You stole a Laptop");
        }

        return Direction.opposite(directionVistorArrivesFrom);
    }
}
