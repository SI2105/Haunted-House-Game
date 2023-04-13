package OOP.ec22612.MP.contributions;

class Room_ec22484 extends Room {
    
    private boolean lightsOn = false;
    private boolean chestOpen = false;
    
    static final Item flamethrower = new Item("flamethrower"); //Can be used against bats
    static final Item key = new Item("key"); //Used to unlock chest, get gold
    static final Item wand = new Item("wand");
    
    
    public Direction visit (Visitor v, Direction from_direction) {
        
        v.tell("You enter a musty room in which you have an uneasy, unshakeable feeling that you are being watched...");
        char[] lights_and_button = {'a', 'b'};
        char[] story_options = {'a', 'b', 'c'}; //good, bad, maybe good maybe bad
        
        if (lightsOn == false)
        {
            v.tell("The room is pitch dark.");
            char lightsChoice = v.getChoice("Switch on the lamp?, (a) for yes, (b) for no.", lights_and_button);
            
            if (lightsChoice == 'a')
            {
                v.tell("You turned on the lamp and see a flamethrower on the ground with a gold coin next to it.");
                lightsOn = true;
                v.giveGold(1);
                v.giveItem(flamethrower);
            }
            
            else
            {
                v.tell("You chose to keep the lights off.");
            }
        }
        
        char storyChoice = v.getChoice("Do you choose to (a), traverse the room in a straight line, (b), walk along the outskirts of the room, or (c) walk diagonally?", story_options);
        
        if (storyChoice == 'a')
        {
            v.tell("You walk in a straight line and trip over an unknown, solid mass. Surprised, you check to see what it was and see 5 gold coins!");
            v.giveGold(5);
            
            return Direction.TO_EAST;
        }
        
        else if (storyChoice == 'b')
        {
            v.tell("While brushing against the wall, you see an ancient-looking button coated with dust.");
            char buttonChoice = v.getChoice("Do you (a) leave the button be, or (b) push the button?", lights_and_button);
            
            if (buttonChoice == 'a')
            {
                v.tell("You walk past the button unbothered.");
            }
            
            else
            {
                v.tell("Oh no! When you pressed the button, a creaky hatch opened in the ceiling and bats are flying out!!");
                
                if (v.hasEqualItem(flamethrower))
                {
                    v.tell("No worries, for you have the flamethrower of dreams! SLAY THE BATS!");
                    v.tell("You killed the bat horde, receive 2 gold for your efforts.");    
                    v.giveGold(2);
                }
                
                else 
                {
                    v.tell("RUN FOR YOUR LIFE!!!");
                    v.tell("You check your pockets and realise you dropped some gold from the scuffle.");
                    v.takeGold(5);
                }
            }    
            
            return Direction.opposite(from_direction);
        }
        
        else if (storyChoice == 'c')
        {
            v.tell("While travelling diagonally across the room, you notice a finely guilded chest with a sturdy padlock.");
            
            if (chestOpen == true)
            {
                v.tell("You notice that the chest has already been breached and you go about your day.");
                v.tell("On a whim, you leave a gold coin behind for any travellers that may come by.");
                v.takeGold(1);
            }
            
            else if (chestOpen == false)
            {
                if (v.hasEqualItem(key))
                {
                    v.tell("You pull out the key you found in another room and open the chest and see a stick of sorts.");
                    v.giveItem(wand);
                    chestOpen = true;
                }
                else 
                {
                    v.tell("After realising the padlock won't budge, you keep it moving.");
                }  
            }    
            
            
        }    
        return Direction.TO_WEST;
   
    }
    
    
}    
