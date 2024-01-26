package HauntedHouseGame.contributions;

public class Room_ec22652 extends Room {
    
    Item ghostTorch = new Item("Ghost Torch");
    
    public Direction visit(Visitor visitor, Direction dirFrom) {
        visitor.tell("Welcome to the Labyrinth.");
        visitor.tell("Note: Labyrinth still under construction - Expected in ...");
        
        visitor.tell("To the left, there is a torch, maybe. It flickers from reality.");
        char option = visitor.getChoice("Take the torch? Press y for yes, n for no.", new char[]{'y', 'n'});
        
        if (option == 'y') {
            if (!visitor.hasIdenticalItem(ghostTorch)) {
                visitor.tell("You went left and picked up the torch.");
                visitor.giveItem(ghostTorch);
            }
            else {
                visitor.tell("The torch vanishes the moment you try to take it.");
            }
        }
        else if (option == 'n') {
            visitor.tell("You decide to leave it, maybe a wish decision?");
        }
        
        visitor.tell("There is nothing else left.");
        visitor.tell("You decide to trek forward.");
            
        return Direction.opposite(dirFrom);
    }
}
