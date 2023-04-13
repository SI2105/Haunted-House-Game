package OOP.ec22612.MP.contributions;

class Room_ex21541 extends Room{

    boolean fridgeOpen = false;
    boolean couchDestroyed = false;
    boolean lightOn = false;
    Direction leavingDirection = null;
    
    
    final Item revolver = new Item("Revolver");
    
    
public Direction visit(Visitor v, Direction d){
    
    char in = v.getChoice("Please select one of the options- a) Enter the room or b) Leave the room the way you came in", new char[] {'a','b'});
    if(in=='a'){
        v.tell("You have entered the room.");
        
        if(lightOn == false){
            v.tell("The room is dark it is hard to see anything.");
            char lchoice = v.getChoice("Would you like to turn the light on? a) yes or b) no",new char[] {'a','b'});
            if(lchoice == 'a'){
                v.tell("The light is on. You can now look around the room.");
                lightOn = true;
            }
            else if(lchoice == 'b'){
                v.tell("The light is still off. There may be something lurking you can't see");
                lightOn = false;
            }
        }
        else if(lightOn == true){
            char lchoice = v.getChoice("The lights are on. Would you like to turn them off? a) yes or b) no",new char[] {'a','b'});
            if(lchoice == 'a'){
                v.tell("The light is now off. There may be some stuff lurking you can't see");
                lightOn = false;
            }
            else if(lchoice == 'b'){
                v.tell("The light is still on. You can still see the room clearly");
                lightOn = true;
        }
        }
            
        
    if(fridgeOpen == false){
    char fchoice = v.getChoice("There is a fridge in the corner. It is closed. Would you like to: a) Open the fridge or b) Leave it closed",new char[] {'a','b'});
    if(fchoice=='a'){
        v.tell("You have opened the fridge. You have found 10 gold!");
        v.giveGold(10);
    }
    else if (fchoice=='b'){
        v.tell("You have left the fridge alone...");
    }
    }
    else if(fridgeOpen == true){
        v.tell("There is a fridge in the corner. It has already been opened.");
    }
        
        
    
    if (couchDestroyed == false){
        char cchoice = v.getChoice("There is a couch. There seems to be something inside the pillows. Would you like to: a) Destroy the couch and see what is inside or b) Leave it alone",new char[] {'a','b'});
    if(cchoice=='a'){
        v.tell("You ripped open the couch to find a snake. It bites down on your leg and steals 3 gold!");
        v.takeGold(3);
        v.tell("However when the snake leaves you find a revolver at the bottom of the couch.");
        v.giveItem(revolver);
        v.tell("3 gold and a snake bite... a small price to pay for a revolver");
        couchDestroyed = true;
        
        
    }
    else if (cchoice=='b'){
        v.tell("You walk away from the couch...");
    }
    }
    else if(couchDestroyed == true){
        v.tell("There is a couch. It has been absolutely ripped to shreds. There may have been something useful inside..");
    }
    
    
    
    char exit = v.getChoice("How would you like to leave the room? a) the way you came in b) through the window c) through the chimney",new char[] {'a','b','c'});
    if(exit == 'a'){
        leavingDirection = d.opposite(d);
    }
    if(exit == 'b'){
        leavingDirection = Direction.TO_NORTH;
    }
    if(exit == 'c'){
        leavingDirection = Direction.TO_EAST;
    }
    }
        
               
    else {
        v.tell("You have left the room the way you entered.");
        leavingDirection = d.opposite(d);
        return leavingDirection;
        
    }
    
               
return leavingDirection;
}
}
