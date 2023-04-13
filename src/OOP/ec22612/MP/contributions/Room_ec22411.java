package OOP.ec22612.MP.contributions;

class Room_ec22411 extends Room {
    //a4 submission 3
    static final Item MACE = new Item("Mace"); 
        
    public Direction visit(Visitor v , Direction d) {
        v.tell("You enter a... room? Where are you?");
        v.tell("There is no light within the room and it seems as if you have walked into a void.");
        v.tell("You hear a voice that seems to whisper right into your ear:");
        v.tell("'Present an offering of gold to me if you wish to pass through or else be doomed to unspeakable horrors.'");
        
        char[] choiceGold = {'a','b','c','d'};

        v.tell("\t[a] Place some money on the floor, hoping it is enough to spare your sanity.");
        v.tell("\t[b] Scream and attack.");
        v.tell("\t[c] Refuse to pay the voice, you will not be threatened.");
        v.tell("\t[d] Demand money from the voice instead to assert dominance.");

        char opt = v.getChoice("What will you do?", choiceGold);
        boolean hasKnife = v.hasIdenticalItem(Room_ec22467.knife);
        int amtGold;
        
        if (opt=='a') { //offer gold
            amtGold = v.takeGold(5);
            if(amtGold==0){
                v.tell("You have nothing to offer and instead try to just stay still in hopes you won't be noticed.");
                v.tell("It's a dumb idea and doesn't work. You run for your life and try to find a door, eventually finding one and escaping with your life.");
            }
            else{
                v.tell("You put some gold pieces on the ground. The voice hums in acceptance.\n'This is adequate, I guess,' It says.");
                v.tell("The room shines a small path of light that leads you to the opposite side of the room.");
                v.tell("That was easy?");
            }
        }
        else if (opt=='b') { //scream and fight
            amtGold = v.takeGold(8);
            if(hasKnife){
                v.tell("You scream in fear and start swinging around the knife you found in the room earlier.");
                if(amtGold!=0){
                    v.tell("A few pieces of gold fall out of your pocket as you pull it out.");
                }
            }
            else{
                v.tell("You scream in fear and throw some gold at the direction of the voice. It doesn't seem to like this...");
            }
            v.tell("The room starts rumbling slowly at first but quickly increasing in magnitude to the point you cannot even stand up without being flung across the room.");
            v.tell("All of a sudden, the shaking stops and the lights flicker on for a second before turning off again."); 
            v.tell("The second was long enough to catch a glimpse of the horrific disfigured creatures staring at you and watcing your every move with demented smiles.");
            v.tell("The voice has not said anything since you screamed. You feel your heart beating quicker and start to run across the room to where you remember seeing a door.");
            }
        else if (opt=='c') { //refuse to pay
            v.tell("You refuse to pay, telling the voice that it can't threaten you because you have no sense of danger.");
            v.tell("There is silence for a few moments before the voice speaks up.");
            v.tell("'You know what, I respect that. I won't bother you...for now.'");
            v.tell("The path to what you assume is the exit lights up and you follow it. Somehow you came out of this interaction unscathed? A mystery.");
        }
        else if (opt=='d') { //assert dominance
            v.tell("Instead of giving in to the voice's demand, you counter it with another demand for the same thing.");
            v.tell("You hear sounds of confusion. It seems the voice is so baffled at your request that it is incapable of doing anything at all.");
            v.tell("There is nothing you can see so you walk forward slowly, looking for an exit, as the voice tries to process your words.");
            if (v.hasIdenticalItem(MACE)==false){
                v.tell("You feel your hand pass along the handle of something and could grab it on your way out.");
                if(v.giveItem(MACE)==true){
                    v.tell("Acquired a mace. Do with it what you will...");
                }
                else{
                    v.tell("You decide to not touch things you don't know anything about. That seems rational enough, but what if you regret this decision... It's too late now anyway :) ");                 
                }
            }
            v.tell("Your hand eventually reaches a door knob and you leave the room, hearing the utter devastation in the voice when it asks itself what just happened.");
            v.tell("Successfully asserted dominance.");
        }
        return Direction.opposite(d); // leaves room opposite side of the way they entered
    }
}
