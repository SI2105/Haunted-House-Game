package HauntedHouseGame.contributions;

public class Room_ec22863 extends Room {

    public Direction visit(Visitor visitor, Direction givenDirection) {

        visitor.tell("You are now in Hugh's room. You can do a few things in here.");
        String givenOptions = "you can [1] look in the pantry, [2] lift up the floorboards, [3]";
        char[] arrOfOptions = {1, 2, 3};

        int option = visitor.getChoice(givenOptions, arrOfOptions);
        Item DeadCat = new Item("Dead Cat");

        if (option == '1') {
            visitor.giveGold(10);
            visitor.tell("You found some gold!. You now have 10 gold pieces.");
        } else if (option == '2') {
            visitor.giveItem(DeadCat);
            visitor.tell("You collected a dead cat from under the floorboards");
        } else if (option == '3'){
            visitor.giveGold(2);
            visitor.tell("You got 2 gold");
        }
     


        return Direction.opposite(givenDirection);
    }
}