package OOP.ec22612.MP.contributions;

class Room_jpp314171 extends Room {
    static final Item hamood = new Item("Hamood Habibi");

    public Direction visit(Visitor visitor, Direction from) {
        visitor.tell("Welcome to Hamood room...");
        if (visitor.hasIdenticalItem(hamood)||visitor.hasEqualItem(hamood)) {
            visitor.tell("Your Hamood Habibi escapes your clutches and takes 9 coins from you!");
            visitor.takeGold(9);
            visitor.tell("The room becomes foggy and you leave...");
            return Direction.opposite(from);
        }
        else {
            visitor.tell("You hear something 'Hamood Habibi...'");
            char[] choices = {'1', '2'};
            char visitor_choice = visitor.getChoice( "a - go closer to what's making the noise b - leave the room", choices);
            if (visitor_choice == '1') {
                visitor.tell("You see Hamood Habibi locked up in a cell!");
                visitor.tell("Baba Telefon is blocking it, he says it'll be 9 gold to bail out Hamood Habibi");
                char[] free_choice = {'1', '2'};
                char visitor_free_choice = visitor.getChoice("1 - Free Hamood Habibi 2 - leave him and leave the room", free_choice);
                if (visitor_free_choice == '1') {
                    visitor.takeGold(9);
                    visitor.giveItem(hamood);
                    visitor.tell("You got Hamood Habibi now!");
                    visitor.tell("But you lost 9 coins.");
                    visitor.tell("You leave the room with your new friend.");
                    return Direction.opposite(from);
                }
                else {
                    visitor.tell("You leave the room while you hear someone 'Hamood Habibi'...");
                    return Direction.opposite(from);
                }
            }
            else {
                visitor.tell("Where do you want to leave from?");
                char[] direction_choices = {'1', '2'};
                char visitor_leaves_from = visitor.getChoice("1 - From where you came from 2 - the door towards north", direction_choices);
                if (visitor_leaves_from == '1') {
                    return Direction.opposite(from);
                }
                else {
                    return Direction.TO_NORTH;
                }
            }
        }
    }
}
