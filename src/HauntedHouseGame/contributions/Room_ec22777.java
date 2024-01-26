package HauntedHouseGame.contributions;

public class Room_ec22777 extends Room {

    Item moth = new Item("Moth");

    public Direction visit(Visitor visitor, Direction from) {
        visitor.tell("Welcome to the next room. In front of you are 3 chests. You may open only one of them, or none of them. Whatever you find inside is yours to keep.");

        String options = "[1] Open the chest on the right\n[2] Open the chest in the middle\n[3] Open the chest on the left";
        char[] arrayOfOptions = {'1', '2', '3'};

        int choice = visitor.getChoice(options, arrayOfOptions);

        switch (choice) {
            case '1':
                visitor.giveGold(10);
                visitor.tell("You got 10 gold pieces!");
                break;
            case '2':
                visitor.giveGold(1);
                visitor.tell("You got 1 gold piece!");
                break;
            case '3':
                visitor.giveItem(moth);
                visitor.tell("You got moths - that is to say - you got nothing");
                break;
            default:
                visitor.tell("You didn't open any chests.");
                break;
        }

        return Direction.opposite(from);
    }
}
