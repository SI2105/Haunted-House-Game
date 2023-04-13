package OOP.ec22612.MP.contributions;

public class Room_ec22752 extends Room{
    public Direction visit (Visitor visitor, Direction direction){

        visitor.tell("There is a ghost in the room. The lights are off.");
        char answ = visitor.getChoice("Do you want a flashlight?(y/n)",new char[] {'y','n'});
        if(answ == 'y'){
            Item flashlight = new Item("Flashlight");
            if(visitor.hasEqualItem(flashlight)){
                visitor.tell("You already have a flashlight");
            }
            else
            {
                visitor.giveItem(flashlight);
            }
            answ = visitor.getChoice("Do you turn on the flashlight?(y/n)", new char[]{'y','n'});
            if(answ == 'y'){
                visitor.tell("The ghost has attacked you! You lose 2 gold.");
                int gold = visitor.takeGold(2);
                if(gold < 2) {
                    visitor.tell("Seems like you don't have even 2 gold. You can keep what you have.");
                    visitor.giveGold(gold);
                }
                return Direction.TO_NORTH;
            }
            else{
                visitor.tell("Good job. Goshts don't like flashlights! Here's 5 gold!");
                visitor.giveGold(5);
                visitor.tell("You've managed to sneak past the ghost!");
                return Direction.TO_WEST;
            }
        }
        else{
            visitor.tell("Good choice ghosts don't like flashlights. Here's 5 gold!");
            visitor.giveGold(5);
            visitor.tell("You've managed to sneak past the ghost!");
            return Direction.TO_EAST;
        }

    }
}
