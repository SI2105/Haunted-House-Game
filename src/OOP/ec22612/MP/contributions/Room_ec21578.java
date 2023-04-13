package OOP.ec22612.MP.contributions;

class Room_ec21578 extends Room {

    public Direction visit(Visitor vis, Direction dir) {
        //asks user direction
        if (dir == dir.FROM_NORTH) {
            vis.tell("You head south into a new room");
        }
        if (dir == dir.FROM_EAST) {
            vis.tell("You head west into a new room");
        }
        if (dir == dir.FROM_SOUTH) {
            vis.tell("You head north into a new room");
        }
        if (dir == dir.FROM_WEST) {
            vis.tell("You head east into a new room");
        }

        vis.tell("You reach a room with a bed and a cupboard. Which will you search?");
        Item AmongUsPlushy = new Item("Among Us Plushy");

        char[] options = {'a', 'b'};
        char decision = vis.getChoice("Search bed (a) or search cupboard (b)?", options);

        if (decision=='a') {
            vis.giveItem(AmongUsPlushy);
            vis.tell("You've acquired an Among Us Plushy!");
        }
        else if (decision=='b') {      
            vis.giveGold(2);
            vis.tell("You found 2 pieces of gold in the cupboard.");
        }

        return dir.opposite(dir);
    }
}
