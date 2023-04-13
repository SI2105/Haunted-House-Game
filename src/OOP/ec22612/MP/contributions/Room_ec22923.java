package OOP.ec22612.MP.contributions;

public class Room_ec22923 extends Room {

    static final Item crystal = new Item("Crystal");
    static final Item goldenKey = new Item("Golden Key");
    
    public Direction visit(Visitor v, Direction d) {
        entranceMessage(v, d);
        while(!v.hasIdenticalItem(goldenKey)){
            interactionChoices(v);
        }
        if(v.hasEqualItem(new Item("Key"))){
            v.tell("The key you got earlier starts to shake, maybe you can finally open that chest.");
            interactionChoices(v);
        }
        return chooseExit(v);
    }
    
    private static void entranceMessage(Visitor v, Direction d)
    {
        v.tell("[As you enter,you suddenly hear a voice echo through the room" +
                ": 'Welcome to room ec22923, you have been chosen to solve the puzzle of the combination lock." +
                "The fate of the secret compartment is in your hands. Enter a correct combination and you will " +
                "be rewarded with a key that unlocks a valuable item. But be warned - a wrong answer will have" +
                "consequences. Good luck.']");
        v.tell("[The voice fades away, leaving you standing in front of the locked safe with only the message" +
                "and your wits to solve the puzzle");
        v.tell("[Across the room you see a dimly lit wall with what seems to be numbers...]");
        if(d.equals(Direction.FROM_EAST))
        {
            v.tell("[The door behind you that was very slowly closing, has finally shut - but just before a flashlight rolls towards you" +
                    "that you pick up.]");
            v.giveItem(new Item("Flashlight"));
        }
    }

private static void interactionChoices(Visitor v)
    {
        char choice = v.getChoice("a) Investigate dimly lit wall." +
                "b) Attempt to solve the lock." +
                "c) Your spider senses are tingling, pick up the rock." +
                "d) Look underneath the bed." +
                "e) Open the chest oddly placed in the middle of the room.", new char[] {'a', 'b', 'c', 'd','e'});
        switch(choice)
        {
            case 'a': investigateWall(v);break;
            case 'b': attemptLock(v);break;
            case 'c': investigateRock(v);break;
            case 'd': investigateBed(v);break;
            case 'e': investigateChest(v);break;
        }
    }

    private static void investigateWall(Visitor v)
    {
        if(v.hasEqualItem(new Item("Flashlight")))
        {
            v.tell("[You realise you have a flashlight, and use it to light up the wall." +
                    "On the wall you see the number 28.]");
        }
        else {
            v.tell("[As you approach the wall to get a clearer picture, the floor beneath you breaks," +
                    "destroying any possibility of you investigating the wall. Maybe the rock could help...");
        }
    }

    private static void attemptLock(Visitor v)
    {
        v.tell("[Above the safe, there's a riddle:" +
                "'The sum of the first 5 prime numbers'...]");
        char lockChoice = v.getChoice("a) 5  b) 26  c) 28  d) 30", new char[]{'a', 'b', 'c', 'd'});
        switch(lockChoice)
        {
            case 'a': wrongCode(v);break;
            case 'b': wrongCode(v);break;
            case 'd': wrongCode(v);break;
            case 'c': correctCode(v);break;
        }
    }

    private static void wrongCode(Visitor v)
    {
        v.tell("The safe blasts as you and you feel some of your gold disappear!");
        v.takeGold(1);
    }

    private static void correctCode(Visitor v)
    {
        v.tell("[You hear the satisfying click, and the safe unlocks! In it, you find a Golden Key!]");
        v.tell("[This key looks like it'll open up the doors to exit the room!]");
        v.giveItem(goldenKey);
    }

    private static void investigateRock(Visitor v)
    {
        v.tell("You pick up the rock and instinctively throw the rock at the chandelier above," +
                "which falls and ignites the wood, lighting up the previously dim wall. The numbers 28" +
                "appears before you. ");
    }

    private static void investigateBed(Visitor v)
    {
        if(v.hasEqualItem(new Item("Flashlight")))
        {
            v.tell("[You use your flashlight to check underneath the bed, and to your pleasent surprise " +
                    "you find 3 gold.");
            v.giveGold(3);
        }
        else {
            v.tell("[It's too dark to see anything, you find nothing.]");
        }
    }
    
    private static void investigateChest(Visitor v)
    {
        v.tell("[You attempt to open the lock...]");
        if(v.hasEqualItem(new Item("Key")))
        {
            v.tell("[It doesn't budge, but then you notice a familiarly shaped keyhole.]");
            v.tell("[You use the key you found from earlier.]");
            v.tell("[It unlocks! In it you find a small, ornate box.]");
            v.tell("[As you open the box, you find a mysterious, glowing crystal inside.]");
            v.tell("[The crystal emanates a strange energy and you can feel its power coursing through you.]");
            v.tell("[You decide to keep the crystal with you, feeling that it might come in handy later.]");
            v.giveItem(crystal);
        }

        else {
            v.tell("[You attempt everything in your power to open it but it doesn't budge.]");
        }
    }


    private static Direction chooseExit(Visitor v)
    {
        v.tell("[Now that you have a key, you can finally pick a direction to exit from]\n");
        char exitOption = v.getChoice("[N]orth , [E]ast, [S]outh, [W]est", new char[] {'n', 'e', 's', 'w'});
        Direction exit = Direction.FROM_EAST;
        switch (exitOption) {
            case 'n': exit = Direction.FROM_NORTH;break;
            case 'e':  exit = Direction.FROM_EAST;break;
            case 's':  exit = Direction.FROM_SOUTH;break;
            case 'w':  exit = Direction.FROM_WEST;break;
        }
        return exit;
    }
}
