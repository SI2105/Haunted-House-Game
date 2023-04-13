package OOP.ec22612.MP.contributions;

import java.util.Random;
class Room_ec22431 extends Room {
    private boolean lightsOn; //ON or OFF
    private boolean trunkEmpty; //Empty or Not
    private final boolean ghostFriendly; //Friendly or Grumpy
    private boolean isCold; //Chilly or Hot (Stuffy)
    private boolean activityCalm; //Calm or Chaotic
    private int gold;
    static final Item key = new Item("Key");
    static final Item pendant = new Item("Pendent");


    public Room_ec22431(){
        lightsOn = false;
        trunkEmpty = false;
        ghostFriendly = false;
        isCold = true;
        activityCalm = true;
        gold = 5;
    }
    public Direction visit(Visitor visitor, Direction direction) {
        if(direction == Direction.FROM_NORTH){
            visitor.tell("You entered the room from the north.");
        } else if (direction == Direction.FROM_EAST){
            visitor.tell("You entered the room from the east.");
        }else if (direction == Direction.FROM_SOUTH) {
            visitor.tell("You entered the room from the south.");
        }else if (direction == Direction.FROM_WEST) {
            visitor.tell("You entered the room from the west.");
        }
        if(!lightsOn) {
            visitor.tell("It's very hard to see anything inside of the room. Using the moonlight, through the broken window you can make out a few things inside the room:" +
                    "\nA yellowing light switch, A heavy looking, wooden chest covered in a thick layer of dust");
        }else {
            visitor.tell("The room is basked in an unnatural, unnerving light, occasionally flickering. The window is shattered outwards as if someone jumped out of it. You look around the room and see" +
                    "\nA yellowing light switch, A heavy looking, wooden chest covered in a thick layer of dust");
        }
        if(isCold){
            visitor.tell("As you take a deep breath, you feel a chill run down your spine. The air in the room feels crisp and icy, as though there is a sudden drop in temperature.");
        }
        else{
            visitor.tell("As you take a deep breath, an intense wave of heat washes over you, and you immediately start to sweat." +
                    "It's almost as if the heat is coming from within the walls.");
        }

        char[] options = {'1', '2', '3'};
        int choice = visitor.getChoice("1. Flick the Light Switch\n2. Open the Chest\n3.Look around the room",options);
        switch (choice) {
            case '1':
                if(lightsOn) {
                    lightsOn = false;
                    visitor.tell("Now that the light is off you can see a blurry, glowing shape, it's back is towards you so you cannot make out its face, if it even has one.\n " +
                            "You decide to walk towards it, as if suddenly possessed to reach out and touch this glowing entity. However you trip and collapse over an old table, balancing on three legs.\n" +
                            " The table breaks under you,and the trance is broken. As you desperately try to scramble away, your heart racing with fear, the creature suddenly turns around, fixating its gaze upon you,\n" +
                            " and without warning starts to float towards you.");
                    if(!ghostFriendly) {
                        isCold = false;
                        activityCalm = false;
                        visitor.tell("The air grows heavy and stale and suddenly the temperature in the room rises rapidly. Your clothes begin sticking to you as the heat comes unbearable.\n" +
                                " The ghost begins to screech at you, it's voice shattering the stillness of the night. Its voice is deafening, seemly coming from all around you.\n" +
                                " \"YOU KILLED HER!\", the ghost shrieks with unmistakable clarity.\n" +
                                " You attempt to defend yourself but your words catch in your throat. With the ghost's accusing scream still ringing in your ears, you panic and look for an escape.\n" +
                                " You search for a way out, but the door is locked, and there's no way to escape. As you desperately search for a way out");
                        if (visitor.hasIdenticalItem(Room_ec22923.crystal)) {
                            visitor.tell("The crystal glows brightly in your hand, guiding you to an old chest in the corner of the room and you begin searching through it with trembling hands, hoping to find the key to unlock the door.");
                        }
                        TrunkContent(visitor);

                    }else {
                        visitor.tell("As the ghostly figure floats towards you, your heart races with fear. You're still curious about the entity despite the sudden movement that caused you to fall over the table.\n" +
                                " As it draws closer, you can start to make out its features, you can now see the kind and gentle expressions on her pale face.\n" +
                                " You realise she is not just any ghost but a mother who must of once lived in this house, she must have died inside this house and now as a ghost is free to watch over the house.");
                        if (visitor.hasIdenticalItem(Room_ec22923.crystal)){
                            visitor.tell("She points to your crystal and then to the chest in the corner of the room. You take the hint and walk towars the chest");
                        }
                        TrunkContent(visitor);

                    }
                }else{
                    lightsOn = true;
                    visitor.tell("You flip the light switch and the room is suddenly bathed in a bright, unnatural and unnerving light. You can see everything clearly now. " +
                            "\nYou look around and see a painting and the chest");
                    char[] options1 = {'1', '2'};
                    int choice1 = visitor.getChoice("1. Go to the Painting\n2. Open the Chest",options1);
                    switch(choice1){
                        case '1':
                            visitor.tell("You walk towards the painting, and as you get closer, you can see that it's a portrait of a family." +
                                    " The painting is old, and the colors have faded, but the family's faces are still visible.\nYou see a blacked-out section where the father should be in the portrait," +
                                    " as if he was purposely erased. The mother and three children in the painting seem to be looking off to the side, as though they're ignoring the empty space.");
                            visitor.tell("Since you can't decipher anything else out of the portrait, you turn and walk to the chest.");
                            TrunkContent(visitor);
                            break;
                        case'2':
                            TrunkContent(visitor);
                            break;
                    }
                }
                break;
            case '2':
                TrunkContent(visitor);
                break;
            case '3':
                visitor.tell("You look around the room and see a painting and the chest");
                char[] options1 = {'1', '2'};
                int choice1 = visitor.getChoice("1. Go to the Painting\n2. Open the Chest",options1);
                switch(choice1){
                    case '1':
                        visitor.tell("You walk towards the painting, and as you get closer, you can see that it's a portrait of a family." +
                                " The painting is old, and the colors have faded, but the family's faces are still visible.\nYou see a blacked-out section where the father should be in the portrait," +
                                " as if he was purposely erased. The mother and three children in the painting seem to be looking off to the side, as though they're ignoring the empty space.");
                        visitor.tell("Since you can't decipher anything else out of the portrait, you turn and walk to the chest.");
                        TrunkContent(visitor);
                        break;
                    case'2':
                        TrunkContent(visitor);
                        break;
                }
                break;
        }
        if (!visitor.hasIdenticalItem(key)){
            visitor.giveItem(key);
        }
        visitor.tell("You use the key and leave the room, then you enter a tiny hallway, you can either go left, right or forwards");
        char[] directionToGo = {'1', '2','3','4'};
        int choiceDirection = visitor.getChoice("1. Go Left\n2. Go Right\n3.Go Forwards\n4.Go Backwards",directionToGo);
        if(choiceDirection==1){
            direction = Direction.TO_EAST;
        } else if (choiceDirection==2) {
            direction = Direction.TO_WEST;
        }else if (choiceDirection==3)  {
            direction = Direction.TO_NORTH;
        }
        else{
            direction = Direction.TO_SOUTH;
        }

        return direction;
    }

    public void TrunkContent(Visitor visitor) {
        char[] options = {'1', '2'};

        if (trunkEmpty) {
            visitor.tell("The chest seems to be empty, it seems you have already cleared it");
        } else {
            Random rand = new Random();
            if (rand.nextInt(2) == 1) {
                visitor.tell("You open the chest and find gold ");
                if(gold<10) {
                    int temp = 10-gold;
                    gold = rand.nextInt(temp)+1;
                    visitor.giveGold(gold);
                    visitor.tell("You take " + gold + "gold bars");
                    visitor.tell("You also find a key and a pendant inside.");
                    int choice = visitor.getChoice("1. Take the Pendent\n2. Take the key",options);

                    if (gold >= 10) {
                        visitor.tell("You have too much gold, in order to take an item you drop a gold bar");
                        visitor.takeGold(1);
                        gold--;
                    }
                    switch (choice) {
                        case '1':
                            visitor.giveItem(pendant);
                            break;
                        case '2':
                            visitor.giveItem(key);
                            break;
                    }
                }
                else {
                    visitor.tell("You cannot take anymore gold");
                    visitor.tell("You also find a key and a pendant inside.");
                    int choice = visitor.getChoice("1. Take the Pendent\n2. Take the key", options);
                    if (gold >= 10) {
                        visitor.tell("You have too much gold, in order to take an item you drop a gold bar");
                        visitor.takeGold(1);
                        gold--;
                    }
                    switch (choice) {
                        case '1':
                            visitor.giveItem(pendant);
                            break;
                        case '2':
                            visitor.giveItem(key);
                            break;
                    }
                }
            } else {
                visitor.tell("You open the chest and find a key and a pendant inside.");
                int choice = visitor.getChoice("1. Take the Pendent\n2. Take the key", options);
                if (gold >= 10) {
                    visitor.tell("You have too much gold, in order to take an item you drop a gold bar");
                    visitor.takeGold(1);
                    gold--;
                }
                switch (choice) {
                    case '1':
                        visitor.giveItem(pendant);
                        break;
                    case '2':
                        visitor.giveItem(key);
                        break;
                }
            }
            trunkEmpty = true;
        }
    }
}
