package OOP.ec22612.MP.contributions;

import java.util.concurrent.ThreadLocalRandom;

class Room_ec22859 extends Room{
    
    private boolean torch = true;  // State used to determine some features of the room.
    private boolean victory = false; // State used to determine the outcome of fighting the Orc.
    private boolean isUnlockable = false; // State used to see if the player can unlock the west side door. 
    private Item fightReward = new Item("Orcish Battleaxe");  // Reward for winning the orc fighting scenario.
    private Item key = new Item("Key");
    private char[] choices = {'a', 'b'}; // Decision making array for the visitor
    private char[] directions = {'n', 's', 'e', 'w'}; // Used for making the decision of which way to leave from.



    /*
     *
     * This method simply takes the Visitor direction and gives them dialogue.
     * 
     * @param visitor is a Visitor object, AKA the object browsing through the room.
     * @param arrivesFrom is a Direction object, determining where the Visitor is coming from.
     * 
     * Returns a direction for the visitor to head to next.
     * 
     */

    public Direction visit(Visitor visitor, Direction arrivesFrom){

        visitor.tell("Welcome adventurer, to Trial of Strength!");
        visitor.tell("You need no guidance, do as you wish but remember, there will be consequences!");


        /*if(torch){
            visitor.tell("The torches lighten the room up!");
        }
        else{
            visitor.tell("It seems dark around here, perhaps you should find a way to light the torches.");


            if(visitor.hasEqualItem(lighter) | visitor.hasIdenticalItem(lighter)){
                visitor.tell("Oh... of course, can just use the lighter I got from these rooms before!");
                torch = true;
            }
            else{
                torch = findTorch(visitor);
            }


            if(torch){
                visitor.tell("The torches lighten the room up!");
                visitor.tell("I'll remember to come back to this room later.");
                return leaveRoom(visitor);
            }
            else{
                visitor.tell("Perhaps this is too dark, you should leave.");
                return leaveRoom(visitor);
            }
        }*/


        if(arrivesFrom == Direction.FROM_SOUTH){
            visitor.tell("Hmmmm, you come from the south.");
            visitor.tell("Not much around here, but hey! at least you found the two coins near the north exit!");
            visitor.giveGold(2);
        }
        else if(arrivesFrom == Direction.FROM_NORTH){
            visitor.tell("Orc Grunt : Hmmmm, you come from the north.");
            visitor.tell("You will either fight me and win in battle, or leave with your pockets empty!");

            if(visitor.hasEqualItem(fightReward) | visitor.hasIdenticalItem(fightReward)){
                visitor.tell("On a second thought, you have a familiar face... oh yes, you defeated me before... You may pass through my friend!");
            }
            else{
                victory = fightOrc(visitor);

                if(victory){
                    visitor.tell("Orc Grunt : You have bested me in an honorable duel, take my weapon as your reward!");
                    visitor.tell("You've obtained the Orcish Battleaxe");
                    visitor.giveItem(fightReward);
                }
                else{
                    visitor.tell("Orc Grunt: You cannot defeat me, outsider! TURN AROUND AND LEAVE! HAHAHA");
                    try {
                        visitor.takeGold(10);
                        visitor.tell("The orc took 10 gold from you!");
                    } catch (Exception tenTooMuch) {
                        try {
                            visitor.takeGold(5);
                            visitor.tell("The orc took 5 gold from you!");
                        } catch (Exception fiveTooMuch) {
                            // what if the visitor is too poor?
                            visitor.tell("You had to little gold for the orc to bother taking it!");
                        }
                    }
                }
            }
            
        }
        else if(arrivesFrom == Direction.FROM_EAST){
            visitor.tell("You enter the room from the East side.");
            visitor.tell("Roadman of The East Ends : oi! give those p's!");

            try {
                visitor.takeGold(5);
            } catch (Exception e) {
                visitor.tell("Oh man... seems like you need gold more than I do, here is 5 gold.");
                visitor.tell("now, get out my face! Door is facing west.");
                visitor.giveGold(5);
            }

            if(visitor.hasEqualItem(key) | visitor.hasIdenticalItem(key));
            else{
                visitor.tell("The roadman dropped his keys, they seem useful so you snatch it before you leave...");
                visitor.giveItem(key);
                visitor.tell("You have obtained a key!");
            }

        }
        else if(arrivesFrom == Direction.FROM_WEST){
            visitor.tell("You enter the room from the west side.");
            visitor.tell("There seems to be more to this room locked behind a door.");
            isUnlockable = lockedDoor(visitor);
            if(isUnlockable){
                visitor.tell("Oh! your key unlocked the door!");
                visitor.tell("Interesting...that was not worth the effort...");
            }
            else{
                visitor.tell("Oh well, you can always come back whenever you find a key!");
            }
        }

        visitor.tell("You flip a switch and decide to leave.");
        torch = !torch;
        return leaveRoom(visitor);
    }


    /*
     * 
     * This method allows the visitor to pick where they want to go to next and leave via that direction
     * 
     * @param v is the passed in argument of the visitor so we can get it to choose where to go and
     * also get access to Visitor.tell(String) method.
     * 
     * Returns the Direction to leave from.
     * 
     */

    Direction leaveRoom(Visitor v){
        char chosenDir = v.getChoice("Where are you off to? (n)orth, (s)outh, (e)ast, (w)est?", directions);
        Direction sendTo = Direction.UNDEFINED;

        if(chosenDir == 'n'){
            v.tell("you leave from north!");
            sendTo = Direction.TO_NORTH;
        }
        else if(chosenDir == 's'){
            v.tell("you leave from south!");
            sendTo = Direction.TO_SOUTH;
        }
        else if(chosenDir == 'e'){
            v.tell("you leave from east!");
            sendTo = Direction.TO_EAST;
        }
        else if(chosenDir == 'w'){
            v.tell("you leave from west!");
            sendTo = Direction.TO_WEST;
        }

        return sendTo;
    }


    /*
     * 
     * This method rolls a dice after letting the visitor choose to take risk and find lighter or leave.
     * If the dice roll is in visitor's favor they leave with lighter. Else they lose 2 gold (if they have it)and get out.
     * 
     * @param v is the passed in argument of the visitor so we can get it to choose what to do and 
     * also get access to Visitor.tell(String) method.
     * 
     * Returns the a boolean value corresponding to finding the torch or not.
     * 
     */
    Boolean findTorch(Visitor v){
        boolean isFound = false;
        char choicemade = v.getChoice("Do you want to (a)risk looking around for a lighter or (b)leave?", choices);
        if(choicemade == 'a'){
            int dice = ThreadLocalRandom.current().nextInt(0, 2);
            if(dice == 1 | dice == 2){
                isFound = true;
            }
            else{
                isFound = false;
                try {
                    v.tell("You lose 2 gold in the dark and cannot find a lighter!");
                    v.takeGold(2);
                } catch (Exception e) {
                    // what if they dont have that much gold?
                    v.tell("You cannot find a lighter!");
                }
                v.tell("You start heading out");
            }
        }
        else{
            isFound = false;
            v.tell("You start heading out");
        }

        return isFound;
    }


    /*
     * 
     * This method rolls a dice after letting the visitor choose to take risk and fight or leave.
     * If the dice roll is in visitor's favor they win and receive an item. Else they lose 10 gold (if they have it)and get out.
     * 
     * @param v is the passed in argument of the visitor so we can get it to choose what to do and 
     * also get access to Visitor.tell(String) method.
     * 
     * Returns the a boolean value corresponding to the victory status of the visitor.
     * 
     */
    Boolean fightOrc(Visitor v){
        boolean hasWon = false;
        char choicemade = v.getChoice("Do you want to (a)risk fighting for a reward or (b)leave?", choices);
        if(choicemade == 'a'){
            int dice = ThreadLocalRandom.current().nextInt(0, 2);
            if(dice == 1 | dice == 2){
                hasWon = true;
            }
            else{
                hasWon = false;
            }
        }
        else{
            hasWon = false;
            v.tell("You start heading out but the orc grabs you!");
        }

        return hasWon;
    }


    /*
     * 
     * This method is gonna check if a user has the item Key in their inventory of any sort.
     * If they do, it unlocks the door for them.
     * Else, does not let them pass through
     * 
     * @param v is the passed in argument of the visitor so we can check their inventory for a key.
     * 
     * Returns true or false based on if key was found or not.
     * 
     */
    boolean lockedDoor(Visitor v){
        if(v.hasEqualItem(key) | v.hasIdenticalItem(key)){
            return true;
        }
        else{
            return false;
        }
    }



}
