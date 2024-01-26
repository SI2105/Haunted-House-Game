package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22740 extends Room{
    
    boolean lightOn = false;
    boolean chestOpenned = false;
    final Item Key = new Item("Key_ec22740"); 
    
    public Direction visit(Visitor visitor, Direction directionFrom) {
        
        // ask the visitor if they want to turn on the light if the light is off
        if (lightOn == false) {
            visitor.tell("You have entered a dark room, there's a light switch on the wall next to you.");
            char[] lightChoices = {'Y','y','N','n'};
            char lightOnChoice = visitor.getChoice("Would you like to turn the light on?", lightChoices);
            
            // set lightOn to true if visitor choose to 
            if (lightOnChoice == 'Y'|| lightOnChoice == 'y') {
                lightOn = true;
            }
            // if not, can't find anything and leave the room
            else {
                visitor.tell("You can't find anything in the darkness.");
                
                return Direction.opposite(directionFrom);
            }
        }
        
        // if the light is already on 
        else {
            // tell what is in the room 
            visitor.tell("You look around the room.");
            visitor.tell("There's a book on a desk, a black cat on the window sill, and a wardrobe on the side of room.");

            // ask the visitor to make a choice
            char[] choices = {'a','b','c','d'};
            char choice = visitor.getChoice("Would you like to: a. leave the room; b. check the chest, c. open the wardrobe d. stroke the cat", choices);

            // leave the room
            if (choice == 'a') {
                visitor.tell("You decide to leave the room.");
                return Direction.opposite(directionFrom);
            }
            
            // given a key in the book 
            else if (choice == 'b') {
                visitor.tell("You decide to look at the book. You found a key inside the book.");
                visitor.giveItem(Key);
            }
            
            // found a chest in the wardrobe
            else if (choice == 'c') {
                visitor.tell("You open the wardrobe and found a chest.");
                
                // can't open the chest without a key if it's openned
                if (chestOpenned == false && (visitor.hasIdenticalItem(Key))==false) {
                    visitor.tell("The chest is locked and you don't have a key.");
                }
                
                // open the chest and get gold if has the key and the chest is not openned
                else if (chestOpenned == false && visitor.hasIdenticalItem(Key)) {
                    int goldGiven = (new Random()).nextInt(10);
                    visitor.giveGold(goldGiven);
                    visitor.tell("You have found " + goldGiven + " gold.");
                    
                }
                
                // nothing inside if the chest is already opened
                else if (chestOpenned == true) {
                    visitor.tell("The chest is already openned, all gold have been taken.");
                }
            }  
            
            // gold being snatched by the cat
            else if (choice == 'd') {
                int goldTaken = (new Random()).nextInt(10);
                visitor.takeGold(goldTaken);
                visitor.tell("You move towards the cat, and got snatched " + goldTaken + " gold from you.");
             }
                
        }
        
        // give the direction to leave
        return Direction.opposite(directionFrom);
    }
} 
