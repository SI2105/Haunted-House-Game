package HauntedHouseGame.contributions;

class Room_ec22418 extends Room {
    
    Item flashlight = new Item("flashlight");
    
    public Direction visit (Visitor visitor, Direction directionVistorArrivesFrom) {
        
        visitor.tell("You walk into another room of the spooky Winchester House.\nIt is very dark in here and you can hear voices all around you whispering... you should try to leave as quickly as possible.");
        char option = visitor.getChoice("a) Examine the writing on the ceiling.\nb) Look out the window.\nc) Examine the paintings.", new char[] {'a', 'b', 'c'});
        
        //if the player chooses to examine the cieling
        if (option == 'a') {
            
            visitor.tell("Scratched into the ceiling you see it says: If you need a light, check your right.");
            visitor.tell("You walk over to the rightmost wall and you see a flashlight on the wall.");
            char optionLight = visitor.getChoice("a) Take flashlight.\nb) Ignore flashlight.", new char[] {'a', 'b'});
            
            if (optionLight == 'a') {
                //Give the visitor the flashlight to investigate room
                visitor.giveItem(flashlight);
                visitor.tell("You shine your flashlight around the room to see if there are anymore clues around.");
                visitor.tell("You see some writing on one of the walls and it says: In order to proceed, the switch you will need.");
                visitor.tell("On the floor you see a small switch");
                char secretDoor = visitor.getChoice("Flip it? (y/n)", new char[] {'y', 'n'});
                
                if (secretDoor == 'y') {
                    visitor.tell("A small portion of the north wall sinks into the floor revealing a secret exit that you walk through");
                    return Direction.TO_NORTH;
                } 
            }
            
        }
        
        else if (option == 'b') {
            
            //The player gets too scared because this room is dark and they leave through the door they came in
            visitor.tell("You look out the window and a horrific face.\nYou're way too crepped out to stay and investigate. You should go.");
            return Direction.TO_EAST;
        }
        
        else if (option == 'c') {
            
            //The player walks to look at the painting but can't do anything with it.
            visitor.tell("You walk over to the painting on the east wall.\nYou can barely make out the scowling faces of the Winchesters on it.");
            visitor.tell("You notice the faint glint of a gold coin on the frame.");
            visitor.giveGold(1);
            visitor.tell("After you remove the coin from the frame you notice a small coin-sized slit on the paining.");
            visitor.tell("A secret passage on the western wall is revealed and you walk through it, into the unkown.");
            return Direction.TO_WEST;
        }
        
        visitor.tell("You're not to sure what to do with yourself now in here so you decide to just go out of the south door.");
        return Direction.TO_SOUTH;
    }
}
