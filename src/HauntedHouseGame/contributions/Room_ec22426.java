package HauntedHouseGame.contributions;

class Room_ec22426 extends Room
{
    //boolean variables to check what the user had done
    boolean lightOn = false;
    boolean wardrobeOpened = false;
    
    public Direction visit(Visitor roomVisitor, Direction directionEntered)
    {
        //There is nothing else to do in the room
        if (lightOn == true && wardrobeOpened == true)
        {
            roomVisitor.tell("You enter an empty room with the light on and an open wardrobe.");
            roomVisitor.tell("There is nothing for you to do. Please leave and enter another room.");
        }
        //If the light is off
        else if (lightOn == false)
        {
            roomVisitor.tell("You enter a dark room.");
            
            char[] option = {'Y', 'N'};
            char choice = roomVisitor.getChoice("Do you want to turn the light off? Y/N", option);
            
            if (choice == 'Y')
            {
                turnOnLightbulb(roomVisitor);
            } 
        //If the light is on and the wardrobe is closed
        }  
        else
        {
             openWardrobe(roomVisitor);
        }
        
        //makes sure the user goes in the opposite direction of where they entered
        return Direction.opposite(directionEntered);                  
    }
    
    //the user interacts with the light bulb if it is off
    void turnOnLightbulb(Visitor roomVisitor)
    {  
        roomVisitor.tell("You walk towards the light switch and press it.");
        roomVisitor.tell("The light bulb comes on and reveals a wardrobe.");
        boolean lightOn = true;
        return;
    }
    
    //the user interacts with the light bulb if it is off
    void openWardrobe(Visitor roomVisitor)
    {  
        roomVisitor.tell("You walk towards the wardrobe and open it.");
        roomVisitor.tell("Inside you find 10 gold coins.");
        roomVisitor.giveGold(10);
        boolean wardrobeOpened = true;
        return;     
    }
}
