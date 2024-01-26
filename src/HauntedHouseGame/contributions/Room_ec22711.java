package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22711 extends Room 
{
    static boolean hasInteractedWithMimic = false;
    static boolean hasTakenItemFromMimic = false;
    static Item previouslyTakenItem = new Item("");
    static int mimicNumberOfGold = 10000;
    
    public Direction visit (Visitor visitor, Direction visitorArrivalDirection) 
    {   
        final int MAX_NUM_GOLD_TO_TAKE = 5;
    
        char[] yesOrNo = {'y', 'n'};
        char[] options = {'a', 'b', 'c'};
        char[] headsOrTails = {'h', 't'};
        char visitorChoice = 'x';
        
        Item[] mimicCurrentItems = {new Item("Moonlight Greatsword"), new Item("Vergil's Yamato"), 
        new Item("HF Murasama Blade"), new Item("BFG-9000"), new Item("Mortal Blade"), new Item("Moonveil Katana"),
        new Item("Maliketh's Black Blade")};
        
        Item wantedItem = new Item("Key");
        
        //DIALOGUE
        //ROOM NARRATOR
        final String roomWelcome = "You enter this room, and see a suspicious looking treasure chest in the centre.";
        final String welcomeBack = "You enter a familiar room, and see the mimic sleeping soundly in the centre.";
        final String notApproachChest = "You decided not to approach the chest as it looked creepy. You left the room.";
        final String notApproachChest02 = "You decided not to approach the mimic, as you have already taken a '" + previouslyTakenItem.name +"' from it.";
        final String notApproachChest03 = "You decided not to approach the mimic";
        final String approachChestChoice = "Would you like to walk to it and open it? (y/n)";
        final String approachChest = "You approach the chest and find out that it is in fact a mimic!";
        final String approachChest02 = "You approach the mimic again and gently wake it up.";
        final String mimicInteractionChoice = "Would you like to a. Trade with the mimic, b. Gamble with the mimic, c. Apologise for waking it up and leave";
        
        //MIMIC
        final String mimicGreeting = "Hmm? Who are you? Ah, well, I don't really care, let me see if you have a '" + wantedItem.name + "'...";
        final String visitorHasKey = "Ahh, very good, you appear to have just what I want. Well go on then, reach inside and pick something out...";
        final String visitorNoKey = "No, you don't appear to have a key, leave me alone, in fact, I'm taking some of your gold just for wasting my time.";
        final String itemPickup = "You reached in and picked up a '";
        final String mimicFinalDialogue = "Well, you've had your pick, and I'm already sick of you, so go away!";
        final String alreadyTakenItem = "Hmm? You, again? I already gave you what you wanted, go away!";
        
        if(!hasInteractedWithMimic)
            visitor.tell("\n" + roomWelcome);
        else
            visitor.tell("\n" + welcomeBack);
        
        //INTERACTION CHOICE
        visitorChoice = visitor.getChoice(approachChestChoice, yesOrNo);
        
        if(visitorChoice == 'y') 
        {
            if(!hasInteractedWithMimic)
                visitor.tell(approachChest);
            else
                visitor.tell(approachChest02);

            hasInteractedWithMimic = true;
            
            //OPTIONS MENU
            visitorChoice = visitor.getChoice(mimicInteractionChoice, options);
            
            if(visitorChoice == 'a') //TRADE
            {
                if(hasTakenItemFromMimic == false) 
                {        
                    visitor.tell(mimicGreeting);
                    if(visitor.hasEqualItem(wantedItem) == true) 
                    {
                        visitor.tell(visitorHasKey);

                        int numberOfMimicItems = mimicCurrentItems.length;
                        int randomItem = getRandInt(numberOfMimicItems);

                        visitor.giveItem(mimicCurrentItems[randomItem]);
                        previouslyTakenItem = mimicCurrentItems[randomItem];

                        if(mimicNumberOfGold > 0) 
                        {
                            int numGold = getRandInt(10);
                            visitor.giveGold(numGold+1);
                            visitor.tell("The mimic gave you "+numGold+ " gold.");
                        }

                        visitor.tell(itemPickup + mimicCurrentItems[randomItem].name + "'.");

                        visitor.tell(mimicFinalDialogue);

                        hasTakenItemFromMimic = true;
                    }
                    else 
                    {
                        visitor.tell(visitorNoKey);

                        int numberOfGoldTaken = visitor.takeGold(getRandInt(MAX_NUM_GOLD_TO_TAKE) + 1);

                        mimicNumberOfGold += numberOfGoldTaken;

                        visitor.tell("The mimic has stolen " + numberOfGoldTaken + " gold from you!");
                        visitor.tell("You don't possess a '" + wantedItem.name + "' at the moment, come back to this room with one and talk to the mimic again.");

                    }
                }
                else 
                {
                    visitor.tell(alreadyTakenItem);
                    visitor.tell("You have already taken an item from the mimic during a previous visit, you cannot take another.");
                }
            }
            else if(visitorChoice == 'b') //GAMBLE
            {
                visitor.tell("I see that you want to gamble, well then, I shall flip a coin.");
                visitorChoice = visitor.getChoice("heads or tails? (h/t)", headsOrTails);
                
                int randomNum = getRandInt(1000);
                int result = randomNum % 2;
                int randomGold = getRandInt(10);
                
                if(visitorWonBet(visitor, result, visitorChoice)) 
                {
                    visitor.tell("It appears that you have won the bet. Fine! Here's some gold...");
                    visitor.giveGold(randomGold+1);
                    mimicNumberOfGold -= randomGold+1;
                    if(mimicNumberOfGold <0)
                        mimicNumberOfGold = 0;
                }
                else 
                {
                    visitor.tell("You guessed wrong! Hand over the gold!");
                    mimicNumberOfGold = visitor.takeGold(randomGold+1);
                }
            }
            else //LEAVE ROOM
            {
                visitor.tell("Thanks for wasting my time and waking me up!");
                visitor.tell("You decided to leave the room");
            }
        }
        
        else //Didn't approach chest
        {
            if(hasInteractedWithMimic == false)
                visitor.tell(notApproachChest);
            else
                if(previouslyTakenItem.name.equals(""))
                    visitor.tell(notApproachChest03);
                else
                    visitor.tell(notApproachChest02);
        }
        
        return Direction.opposite(visitorArrivalDirection);
    }
    
    boolean visitorWonBet(Visitor visitor, int result, char vistorCharChoice) 
    {
        int visitorIntChoice;
    
        if(result == 0) 
        {
            visitor.tell("The result heads.");
        }
        else 
        {
            visitor.tell("The result is tails.");
        }
        
        if(vistorCharChoice == 'h') 
        {
            visitorIntChoice = 0;
        }
        else 
        {
            visitorIntChoice = 1;
        }
        
        return visitorIntChoice == result; 
    }
    
    int getRandInt(int maxInt) 
    {
        Random rand = new Random();
        return rand.nextInt(maxInt);
    }
}
