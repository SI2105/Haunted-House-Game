package HauntedHouseGame.contributions;

class Room_ec22784 extends Room {
    static final Item hamood = new Item("Hamood Habibi");

    public Direction visit(Visitor visitor, Direction from) {
        visitor.tell("You entered Hamood room...");
        if (visitor.hasIdenticalItem(hamood)||visitor.hasEqualItem(hamood)) {
            visitor.tell("Your Hamood Habibi escapes your clutches and takes 9 coins from you!");
            visitor.takeGold(9);
            visitor.tell("The room becomes foggy and you leave...");
            return Direction.opposite(from);
        }
        else {
            visitor.tell("You hear something whisper 'Hamood Habibi...'");
            char[] choices = {'a', 'b'};
            char visitor_choice = visitor.getChoice( "a - go closer to what's making the noise b - leave the room", choices);
            if (visitor_choice == 'a') {
                visitor.tell("You see Hamood Habibi locked up in a cell!");
                visitor.tell("Baba Telefon is blocking it, he says it'll be 9 gold to bail out Hamood Habibi");
                char[] free_choice = {'a', 'b'};
                char visitor_free_choice = visitor.getChoice("a - Free Hamood Habibi b - leave him and leave the room", free_choice);
                if (visitor_free_choice == 'a') {
                    visitor.takeGold(9);
                    visitor.giveItem(hamood);
                    visitor.tell("You got Hamood Habibi now!");
                    visitor.tell("But you lost 9 coins.");
                    visitor.tell("You leave the room with your new friend.");
                    return Direction.opposite(from);
                }
                else {
                    visitor.tell("You leave the room while you hear someone whimper 'Hamood Habibi'...");
                    return Direction.opposite(from);
                }
            }
            else {
                visitor.tell("Where do you want to leave from?");
                char[] direction_choices = {'a', 'b'};
                char visitor_leaves_from = visitor.getChoice("a - From where you came from b - the door towards north c - the door towards east d - the door towards west", direction_choices);
                if (visitor_leaves_from == 'a') {
                    return Direction.opposite(from);
                }
                else if(visitor_leaves_from == 'b') {
                    return Direction.TO_NORTH;
                }
                else if(visitor_leaves_from == 'c') {
                    return Direction.TO_EAST;
                }
                else if(visitor_leaves_from == 'd'){
                    return Direction.TO_NORTH;
                }
                else {
                    visitor.tell("You didn't choose an appropriate option, you get one gold taken and get sent from where you came from");
                    visitor.takeGold(1);
                    return Direction.opposite(from);
                }
            }
        }
    }
}