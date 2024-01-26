package HauntedHouseGame.contributions;

class Room_ec221024 extends Room {
    
    static final Item shoes = new Item("Toga Virilis Loafers");
    static final Item LEBook = new Item("Super Limited Edition original copy of Vagabond");
    static final Item torch = new Item("torch");
    boolean lightSwitchOn = false;
    boolean moodAngry = false;   //the dress's mood
    char[] multipleChoice = {'a','b','c'};
    char[] twoChoice = {'a','b'};
    Direction leaving = Direction.UNDEFINED;
    
    public Direction visit(Visitor person, Direction direction){
        
        String where = "";
        
        if (direction == Direction.FROM_SOUTH){
            where = "Southern";
        } else if (direction == Direction.FROM_WEST){
            where = "Western";
        } else if (direction == Direction.FROM_NORTH){
            where = "Northern";
        } else if (direction == Direction.FROM_EAST){
            where = "Eastern";
        }
        
        person.tell("You have stumbled into the dressing hall located in the " + where + " wing of the Winchester Mansion.");
        person.tell("Looking down to see what it was exactly that you stumbled over, you find a purse of gold coins.");
        person.giveGold(3);
        
        if(lightSwitchOn == false){
            
            if(person.hasIdenticalItem(torch)||person.hasEqualItem(torch)){
                person.tell("You turn your torch on and use it to look around the hall.");
            } else{
                person.tell("In pitch black darkness, you fumble around looking for a light swtich.");
                person.tell("When you bumb into a what feels like a vending machine...");
                person.tell("On the machine you see a coin slot that has the word, SWITCH in a luminous green glow on top of it.");
                person.takeGold(1);
                lightSwitchOn = true;
                person.tell("After putting one gold coin into the machine the lights dramatically turn on.");
            }
        } else {
            person.tell("The lights have been left on from your previous visit.");
        }
        
        person.tell("In the middle of the hall, resting in mid-air is a shiny shimmering sheath dress in red.");
        person.tell("It drapes the floor as it hovers towards you, the dress is seeming possessed by the person who used this dressing hall.");
        person.tell("Befriend the dress, or put it in a happy mood. Otherwise you might suffer the wrath of the possessor.");
        
        person.tell("Pick the right thing to say");
        person.tell("Red Dress - What business do you have here intruder?");
        
        char choice = person.getChoice("a)I'm not sure, I got lost.  b)What a beatiful dress!  c)What! Are speaking to me!?", multipleChoice);
        
        if (choice == 'a'){
            person.tell("The Dress is indifferent to you and tells you to be on your way");
            moodAngry = false;
            
        } else if (choice == 'b'){
            person.tell("The Dress is delighted and offers you one of its two treasures!");
            moodAngry = false;
            
            char option = person.getChoice("Would you like either a)Toga Virilis Loafers  or  b)Super Limited Edition original copy of Vagabond", twoChoice);
            if (option == 'a'){
                
                person.giveItem(shoes);
                
            }else if (option == 'b'){
                
                person.giveItem(LEBook);
            }
                
        } else if (choice == 'c'){
            person.tell("The Dress is INFURIATED, and is determined to curse you.");
            person.tell("Two of your coins go missing as the Dress is cursing you with poverty!!");
            person.takeGold(2);
            moodAngry = true;
            
        } else {
            
            person.tell("That wasn't an option");
            person.tell("For wasting the Dress's time and not answering the question, it is now angry with you and chases you out!");
            moodAngry = true;
        }
        
        
        if (moodAngry == true){
            leaving = Direction.TO_WEST;
            
        }else if (moodAngry == false){
            
            char whichWay = person.getChoice("a)North  b)South  c)East",multipleChoice);
            if (whichWay == 'a'){
                lightSwitchOn = false;
                leaving = Direction.TO_NORTH;
            } else if (whichWay == 'b'){
                lightSwitchOn = false;
                leaving = Direction.TO_SOUTH;
            } else if (whichWay == 'c'){
                lightSwitchOn = false;
                leaving = Direction.TO_EAST;
            } 
            
        }
    
        return leaving;
    }
    
}
