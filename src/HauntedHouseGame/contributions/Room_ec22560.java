package HauntedHouseGame.contributions;

class Room_ec22560 extends Room {

    private boolean lightsOut; 
    private boolean chestFull; 
    private boolean ghostFriendly; 
    private boolean hot; 
    Item Axe = new Item("axe");

    public Room_ec22560(){
        lightsOut = true;
        chestFull = true;
        ghostFriendly = false;
        hot = true;
    }

    @Override
    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) {
        if (directionVisitorArrivesFrom == Direction.FROM_NORTH) {
            visitor.tell("You entered the room via the north entrance.");
        } else if (directionVisitorArrivesFrom == Direction.FROM_EAST) {
            visitor.tell("You entered the room via the east entrance.");
        } else if (directionVisitorArrivesFrom == Direction.FROM_SOUTH) {
            visitor.tell("You entered the room via the south entrance.");
        } else if (directionVisitorArrivesFrom == Direction.FROM_WEST) {
            visitor.tell("You entered the room via the west entrance.");
        }

        if (lightsOut)
        {
            visitor.tell("The room is very dark, but you can make out a chest in the middle, alongside a lever next to it.");
        }

        else
        {
            visitor.tell("The room is illuminated with a bright light, which allows you to see a chest in the centre, a lever next to it, and an axe in the far corner");
        }

        if (hot)
        {
            visitor.tell("The room is extremely humid, causing you to sweat and your clothes to stick to your body. You feel dehydrated and your body craves water.");
        }

        else {
            visitor.tell("A breeze fills the room, but you are unsure from where. Each breath you take feels more difficult than the last. Perhaps it would be a good idea to leave soon.");
        }

        char[] options = {'1', '2', '3'};

        if (lightsOut){
            int choice = visitor.getChoice("1. Pull the lever \n2. Attempt to open the chest \n3.Look around the room",options);

            if (choice ==1 )
            {
                lightsOut = false;
                visitor.tell("The lights turn on, and an apparition appears in front of you, he possesses you and you die. Sorry.");
            }

            else if (choice ==2)
            {
                visitor.tell("You try to open the chest, but your muscles are too weak. Maybe you should have hit the gym some more. Something taps your shoulder and you turn around to see a ghost in front of you staring into your soul. He climbs into your mouth and possesses you. Your body is never found. ");
            }

            else
            {
                visitor.tell("You choose to look around the room, and your curiosity is rewarded.");
                visitor.tell("Obtained axe!");
                visitor.giveItem(Axe);
                visitor.tell("The ghost comes out and says that he's willing to buy the axe for 5 gold.");
                choice = visitor.getChoice("1. Sell the axe \n2. Attempt to open the chest \n3. Be a sigma and leave",options);
                if (choice==1)
                {
                    visitor.tell("You hand the axe to the ghost, and he gives you the gold as expected.");
                    visitor.giveGold(5);
                    visitor.tell("5 gold obtained!");
                }
                
                else if (choice ==2)
                {
                    if (visitor.hasEqualItem(Axe))
                    {
                        visitor.tell("Now that you have the axe, you're able to smash open the chest with ease.");
                    }

                    else
                    {
                        visitor.tell("Using all your strength, you're able to get the chest open.");
                    }

                    visitor.tell("You see a pouch of gold, filled to the brim.");
                    visitor.giveGold(10);
                    visitor.tell("Your gamble pays off. 10 gold obtained!");
                }
                
                else
                {
                    visitor.tell("You decide to try your luck and walk off.");
                    if (ghostFriendly)
                    {
                        visitor.tell("The ghost feels generous, so he lets you leave.");
                    }
                    
                    else 
                    {
                        visitor.tell("The ghost doesn't like that. He possesses you and makes you jump out the window to your death.");
                        
                    }
                }
            }
        }
        
        else
        {
            int choice = visitor.getChoice("1. Pull the lever \n2. Attempt to open the chest \n3.Look around the room",options);
            if (choice ==1 )
            {
                lightsOut = false;
                visitor.tell("The lights turn off, and an apparition appears in front of you, he possesses you and you die. Sorry.");
            }

            else if (choice ==2)
            {
                visitor.tell("You try to open the chest, but your muscles are too weak. Maybe you should have hit the gym some more. Something taps your shoulder and you turn around to see a ghost in front of you staring into your soul. He climbs into your mouth and possesses you. Your body is never found. ");
            }

            else
            {
                visitor.tell("You look around the room, but you can't see so you trip and crack your head open like an egg.");
            }
        }
        

        return directionVisitorArrivesFrom;
    }




}

// Credit to ec22881
