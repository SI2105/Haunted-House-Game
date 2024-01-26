package HauntedHouseGame.contributions;

import java.util.Random;

public class Room_ec22573 extends Room {
    
    //sets intial state of objects in the room
    private boolean lightsOn = false;
    private boolean trunkEmpty = false;
    private boolean poltergeistFriendly = false;

    
    public Direction visit(Visitor visitor, Direction direction) {
        
        // introduce the room and its state to the visitor
        visitor.tell("You have entered Room_ec22573. The lights are " + (lightsOn ? "on" : "off") + ".");
        
        if (!trunkEmpty) {
            visitor.tell("There is a large trunk in the corner of the room.");
        }
        if (!poltergeistFriendly) {
            visitor.tell("You hear a strange noise coming from the walls.");
        }else{
            visitor.tell("This must not have been your first time here.");
        }

        // ask the visitor to make a choice
        char[] choices = {'o', 't', 'c'};
        int choiceIndex = visitor.getChoice("What would you like to do? (o)pen the trunk, (t)urn on the lights, or (c)all out to the poltergeist?", choices);
        char choice = choices[choiceIndex];

        // carry out the consequences of the visitor's choice
        if (choice == 'o') {
            if (!trunkEmpty) {
                visitor.tell("You open the trunk and find a golden key inside!");
                visitor.giveItem(new Item("golden key"));
                trunkEmpty = true;
            } else {
                visitor.tell("The trunk is already empty.");
            }
        } else if (choice == 't') {
            lightsOn = true;
            visitor.tell("You turn on the lights. The room is now well lit.");
        } else if (choice == 'c') {
            if (!poltergeistFriendly) {
                visitor.tell("You call out to the poltergeist, but it responds by throwing a book at you! You lose 5 pieces of gold.");
                int goldLost = visitor.takeGold(5);
                if (goldLost == 0) {
                    visitor.tell("You have no gold to lose.");
                }
            } else {
                visitor.tell("You call out to the poltergeist, but it responds by leaving a shiny gold coin on the ground.");
                visitor.tell("I think you should take it");
                visitor.giveGold(1);
            }
            poltergeistFriendly = new Random().nextBoolean(); // poltergeist's friendliness changes randomly
        }

        // ask the direction the visitor wants to leaves - different parts of the room
        
        char choiceofDirection = visitor.getChoice("Where would you like to go now? Through the tunnel in the wall (a). Into the wardrobe (b).In the hole full of webs (c). Or into a door on fire (d)   ", new char []{'a', 'b', 'c', 'd'});
         
        
        Direction exitDirection = direction;
        
        if (choiceofDirection =='a') {
            exitDirection = Direction.TO_SOUTH;
        } else if (choiceofDirection =='b') {
            exitDirection = Direction.TO_NORTH;
        } else if (choiceofDirection == 'c') {
            exitDirection = Direction.TO_WEST;
        } else if (choiceofDirection =='d') {
            exitDirection = Direction.TO_EAST;
        }

        return exitDirection;
    }
}
