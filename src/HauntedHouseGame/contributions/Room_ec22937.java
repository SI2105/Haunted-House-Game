package HauntedHouseGame.contributions;

class Room_ec22937 extends Room
{
    private boolean STATE_hasDog = false;
    private boolean STATE_boiler = false;
    private boolean STATE_hasNews = false;
    private boolean STATE_bed = false;
    private boolean STATE_keyTaken = false;
    private boolean STATE_codeTaken = false;
    private boolean STATE_mirrorTaken = false;
    public Direction visit(Visitor v, Direction d)
    {
        describeRoom(v, d);
        delayText(v);
        boolean exit = false;
        while (!exit)
        {
            userAction(v);
            exit = decideExit(v);
        }
        checkItems(v);
        delayText(v);
        if (!STATE_mirrorTaken) { handGift(v); }
        return pickExitDirection(v);
    } 
    
    private void describeRoom(Visitor v, Direction d)
    {
        if (!STATE_boiler)
        {
            v.tell("[This room is unimaginably cold.]"); 
            if (v.hasEqualItem(new Item("Coat"))) { v.tell("[You decide to wear the coat that you had found previously.]"); }
        }
        v.tell("[The room seems quite strange, as if it has been lost in the passage of time.]"); 
        v.tell("[Behind the door you see a name etched into the wood. 'Alex Green']");
        
        if (d.equals(Direction.FROM_NORTH)) { 
            if (!STATE_boiler)
            { v.tell("[You notice that the boiler is turned off. That would explain the cold temperature.]"); }
            else
            {v.tell("[The boiler is on. Its much warmer now!]");}
        }
        else if (d.equals(Direction.FROM_EAST)) {
            v.tell("[Every plank you step on starts to creak. Its almost as if the planks could collapse at any moment.]");
            if (!STATE_keyTaken)
            { v.tell("[It looks like there is a note hidden underneath one of the planks.]"); }
        }
        else if (d.equals(Direction.FROM_SOUTH)) { 
            if (!STATE_mirrorTaken)
            { v.tell("[You find a mirror next to the door. Maybe the person living here isn't using it?]"); }
            v.tell("[The design of the walls and the general decor seem very old-fashioned. This design became out-dated maybe a few decades ago.]");
            
        }            
        else {
            if (!STATE_bed) 
            {v.tell("[On the left, you see a bed. Judging by the amount of dust, it looks like hasn't been touched for a while.]");}
            else
            {v.tell("[You see the bed that is now clean and appreciate your handywork.]");}
        
        }
        v.tell("[You hear someone behind you.]");
        v.tell("Hello my name is Alex. Nice to meet you.");
        v.tell("It's been so long since I have had a visitor. Feel free to explore.");
    }
    
    private static void delayText(Visitor v) { v.getChoice("[Press enter to continue]", new char[] {' '}); }
    
    private void userAction(Visitor v)
    {
        final String A = "Insult Alex.";
        final String B = "Drink some water.";
        final String C = "Look through wardrobe.";
        final String D = "Check under the plank.";
        String E = "";
        if (!STATE_boiler) {E = "Re-activate the boiler.";}
        else {E = "Deactivate the boiler.";}
        String F = "";
        if (!STATE_bed) {F = "Clean the bed";}
        else {F = "Lie on the bed";}
        String desc = "a) " + A  + "\n" + "b) " + B + "\n" + "c) " + C + "\n" + "d) " + D + "\n" + "e) " + E + "\n" + "f) " + F;
        char option = v.getChoice(desc, new char[] {'a', 'b', 'c', 'd', 'e', 'f'});
        delayText(v);
        switch (option)
        {
            case 'a': insultGhost(v); break;
            case 'b': drinkWater(v); break; 
            case 'c': lookWardrobe(v); break;
            case 'd': checkPlank(v); break;
            case 'e': activateBoiler(v); break;
            case 'f': cleanBed(v); break;
            default: break;
        }
    }
    
    private void activateBoiler(Visitor v)
    {
        if (STATE_boiler) 
        {
            v.tell("Feeling malicious, you decide to turn off the boiler again.");
            STATE_boiler = false;
            return;
        }
        v.tell("I didn't realise that the boiler was off, thanks for turning it on again. " + 
                "That might explain why my last visitor looked like they were freezing.");
        STATE_boiler = true;
        v.giveGold(5);
    }
    
    private void drinkWater(Visitor v)
    {
        v.tell("[You decide to grab a drink of water but you can't find a glass]");
        v.tell("Oh right! I forgot about water. Let me go grab a glass for you.");
        v.tell("Now that I think about it, I don't remember the last time that I had anything to drink.");
        v.giveGold(1);
    }
    
    private void lookWardrobe(Visitor v)
    {
        v.tell("[You decide to look through the wardrobe. It contains no clothes.]");
        v.tell("Most of my clothes passed straight through me so I threw them most of them out.");
        v.tell("I'm not too sure why all of them are too big for me.");
        v.giveGold(2);
    }
    
    private void checkPlank(Visitor v)
    {
        if (STATE_codeTaken)
        {
            v.tell("[As you come closer to one of the planks, one of them cracks]");
            v.tell("Be careful, you might fall underneath like I did yesterday. It's not a fun experience trying to get back.");
            return;
        }
        v.tell("You pull open the plank to reveal the note underneath");
        if (v.giveItem(new Item("LeverCodeZM"))) {
            v.tell("[It looks like there's a number written on it but the writing is hard to decipher.]");
            v.tell("My handwriting isn't great sorry about that. Could I see that?");
            v.tell("I remember this. A few years ago, I hid some treasure behind a lever challenge in another room. " + 
            "If you picked the correct one you would be rewarded with the treasure but if you were wrong however...");
            v.tell("You're a good kid, I shall tell you that the correct lever is 'Number 4'.");
            STATE_codeTaken = true;
        }
        v.giveGold(3);
    }
        
    private void insultGhost(Visitor v)
    {
        v.tell("[You tell Alex that they are strange and that no-one will ever love them.]");
        v.tell("That comment was uncalled for...");
        v.tell("[Alex teleports behind you]");
        delayText(v);
        for (int i=0; i<17; i++) { v.takeGold(10); }
    }
    
    private void cleanBed(Visitor v)
    {
        if (STATE_bed)
        {
            v.tell("[You decide to lie in bed. You end up falling asleep.]");
            v.tell("[You wake to a Teddy bear sitting next to you]");
            v.giveItem(new Item("Teddy bear"));
            if (STATE_hasDog) {v.tell("[You find a note left on the bedside table. It reads: Thank you!!]");}
            STATE_bed = false;
            return;
        }
        v.tell("[You offer to clean the Alex's bed]");
        v.tell("[10 minutes later...]");
        v.tell("Yeah, it started recently. A while back I noticed that I was never tired so I haven't used the bed in a long time. " + 
        "Maybe I developed insomnia somehow. Anyhoo thanks for cleaning the bed, you really didn't have to");
        v.giveGold(7);
        if (STATE_keyTaken) {return;}
        v.tell("[While you were cleaning the bed you found a key hidden in one of the pillows]");
        v.tell("[This could be used to open a treasure chest in some fantasy garden perhaps.]");
        v.giveItem(new Item("Key"));
        STATE_bed = true;
        STATE_keyTaken = true;
    }
    
    private static boolean decideExit(Visitor v)
    {
        char option = v.getChoice("a) Finish exploring" + "\n" +  "b) Continue", new char[] {'a','b'});
        return (option == 'a');
    }
    
    private void checkItems(Visitor v) 
    { 
        if (v.hasEqualItem(new Item("NewspaperZAM")) && !STATE_hasNews &&
        v.getChoice("Give Alex the newspaper regarding their death (y/n)", new char[] {'y','n'}) == 'y') { informDead(v); } 
        if (v.hasEqualItem(new Item("Baby Cerberus")) && !STATE_hasDog && 
        v.getChoice("Give Alex the Baby Cerburus (y/n)", new char[] {'y','n'}) == 'y') { adoptPet(v); }
    }  
    
    private void informDead(Visitor v)
    {
        v.tell("[You give the newspaper that you found to Alex.]");
        v.tell("You have a note for me? Okay I'll look at it.");
        v.tell("So all this time... I've beeen... dead?");
        v.tell("..." + "\n" + "..." + "\n" + "..." + "\n" + "...");
        v.tell("Just knowing this information means a lot to me. Thank you!");
        v.tell("I see, it must have been that person.");
        v.tell("As long she still remains here, I and many others will never be able to pass on.");
        delayText(v);
        for (int i=0; i< 90; i++) { v.giveGold(10); }
        STATE_hasNews = true;
    }
    
    private void adoptPet(Visitor v)
    {
        v.tell("[The baby Cerberus that you found suddenly crawls out of your bag and jumps into Alex's hands.]");
        v.tell("Thanks for the pet but typically animals ignore me so you should ke-");
        v.tell("[The three dog heads begin to lick Alex]");
        v.tell("It can see me? and feel me?!!");
        v.tell("Thank you so much, I will make sure that I take good care of it!!");
        delayText(v);
        for (int i=0; i<400; i++) { v.giveGold(10); }
        STATE_hasDog = true;
    } 
    
    
    private void handGift(Visitor v)
    {
        v.tell("Before you go, I have a gift for you.");
        if (v.giveItem(new Item("Mirror"))) {
            v.tell("This mirror stopped working for some reason. Its not shattered but I think it might be broken");
            v.tell("[You look through the mirror. Despite everything, its still you.]");
            v.tell("[You are filled with determination... and money]");
            v.giveGold(8);
            STATE_mirrorTaken = true;
        }
    }
    
    private Direction pickExitDirection(Visitor v)
    {
        v.tell("[Pick a direction to exit to]");
        char exit = v.getChoice("a) North, b) East, c) South, d) West", new char[] {'a','b','c','d'});
        Direction directionLeave = Direction.FROM_WEST;
        switch(exit)
        {
            case 'a': directionLeave = Direction.TO_NORTH; break;
            case 'b': directionLeave = Direction.TO_EAST; break;
            case 'c': directionLeave = Direction.TO_SOUTH; break;
            case 'd': directionLeave = Direction.TO_WEST; break;
        }  
        return directionLeave;
    } 
            
}
