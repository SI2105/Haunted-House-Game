package HauntedHouseGame.contributions;

class Room_ec22984 extends Room {
    public Direction visit(Visitor v, Direction incoming) {
        final Item knife = new Item("knife"); 
        
        v.tell("Welcome to one of the bedrooms of Sarah Lockwood Pardee Winchester. Beware it is haunted here."); //(Theme)
        
        boolean lights = false; //set the rooms lights to false (off)
        String lightState;
        
        if (lights == false) {
            lightState = "off";
        }
        else {
            lightState = "on";
        }
        
        v.tell("The lights are currently " + lightState);
        
        char[] possibleChoices = {'a', 'b'};
        char userInput1 = v.getChoice("Would you like to: a) Turn lights on, or b) leave them off?", possibleChoices);

        
        if (userInput1 == 'a') {
            lights = true;
            v.tell("Wise choice, you proceed to safely explore the room");
            v.tell("You find something shiny poking out under some old blankets.");
            
            char userInput2 = v.getChoice("do you wish to pick it up? a) Yes, or b) No ", possibleChoices);
            
            if (userInput2 == 'a') {
                v.tell("You have found a knife! Maybe you can use it to keep you safe in the other rooms...");
                if (v.hasIdenticalItem(knife) == true) {
                    v.tell("It seems like you already have a knife on you, and 2 knives sounds like more effort than its worth, so you leave this knife  here.");
                }
                
                else {
                    v.tell("You take the knife. Make sure to use it wisely...");
                    v.giveItem(knife);
                }
                    
                   
                 
            }
            else if (userInput2 == 'b') {
                v.tell("You decide to play it safe and not pick any strange items up.");
            }
            
            v.tell("You keep searching but there is nothing interesting left in the room, you decide to move on to another room...");
                
        }
        else if (userInput1 == 'b') {
            v.tell("You have been pickpocketed in the dark, they stole some gold!! You run away from the room scared.");
            v.takeGold(5);
        }
        
        
        return incoming.opposite(incoming);  //Send user to opposite direction from incoming one
    }
}
