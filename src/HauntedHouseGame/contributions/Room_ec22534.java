package HauntedHouseGame.contributions;

abstract class Room_ec22534 extends Room {
    public Direction Visit (Visitor v, Direction d) {
        char[] choices = {1,2,3,4};
        v.tell("Nice room, let me take some gold.");
        v.takeGold(5);
        v.tell("Thanks for the gold!");

        return d.opposite(d);
    }
}
