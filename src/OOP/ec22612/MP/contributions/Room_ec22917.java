package OOP.ec22612.MP.contributions;

class Room_ec22917 extends Room
{

    boolean southPeoniesState = false;
    boolean southDoorState = false;
    boolean westWateringCanState = false;
    boolean westShovelState = false;
    boolean westSeedsState = false;
    boolean westInkState = false;
    boolean northFlagState = false;
    boolean northCerberusState = false;
    boolean eastCloakState = false;
    boolean eastLilyState = false;
    
    public Direction visit(Visitor x, Direction directionFrom) {

        roomDes(x, directionFrom);
        return Direction.TO_NORTH;
    }

    public void roomDes(Visitor x, Direction directionFrom) {

        x.tell("You are now in a small garden in a closed room.");
        x.tell("Above you on the ceiling is a painting of a sea serpent wreaking havoc on a pirate ship, bits of gold flying out the ship.");
        x.tell("");

        final int startGoldVal = 5;
        x.giveGold(startGoldVal);
        x.tell("[You have been given 5 pieces of gold to begin with. Wrong choices lose gold, discoveries gain gold.]");
        x.tell("");

        if(directionFrom.equals(Direction.FROM_SOUTH))
        {
            south(x);
        }
        else if(directionFrom.equals(Direction.FROM_WEST))
        {
            west(x);
        }
        else if(directionFrom.equals(Direction.FROM_NORTH))
        {
            north(x);
        }
        else if(directionFrom.equals(Direction.FROM_EAST))
        {
            east(x);
        }
        else
        {
            System.out.println("Direction switch error.");
        }
    }

    public void south(Visitor x) {

        x.tell("In front of you is a small flower bed with fully bloomed peonies. Beyond the flower bed is another door.");

        String optionsTest = "Do you want to step on the peonies? [y = yes, n = no]";
        char[] optTest = {'y', 'n'};

        switch(x.getChoice(optionsTest, optTest))
        {
            case 'y':
                if(southPeoniesState) { x.tell("Again?! Artemis, the Goddess of Nature, would not be happy..."); return; }
                x.tell("");
                x.tell("That's not nice.");
                x.takeGold(1); x.tell("[-1 gold]");
                southPeoniesState = true;
                break;
            case 'n':
                x.tell("");
                x.tell("You are a kind one.");
                x.giveGold(2); x.tell("[+2 gold]");
                break;
            default:
                System.out.println("Testing choice error.");
                break;
        }

        x.tell("");
        String optionsS = "\na) pick up a peony\nb) open the door";
        char[] optS = {'a', 'b'};

        switch(x.getChoice(optionsS, optS))
        {
            case 'a':
                x.tell("");
                x.tell("What a nice flower~");
                break;
            case 'b':
                if(!x.hasEqualItem(new Item("Flag")))
                {
                    x.tell("");
                    x.tell("The door is locked. It looks like you will need to draw a pattern to unlock the door.");
                }
                else
                {
                    if(southPeoniesState) { x.tell("This is the field where you found the newspaper..."); return; }
                    
                    x.tell("");
                    x.tell("You will need to draw a pattern to unlock the door. The flag may be of use here.");
                    x.tell("[Door unlocked]");
                    x.giveGold(2); x.tell("[+2 gold]");
                    x.tell("");

                    x.tell("On the other side of the door lies a large green field.");
                    x.tell("In the centre is a single red spider lily, the glow emanating through the fields.");
                    x.tell("As you walk towards the lily, you notice something on the ground beside it.");
                    x.tell("'Car Collision Kills Alex Green at Age 32.'");
                    x.tell("");
                    x.giveItem(new Item("NewspaperZAM"));
                    x.giveGold(5); x.tell("[+5 gold]");
                    
                    southPeoniesState = true;
                }
                break;
            default:
                System.out.println("South choice error.");
                break;
        }
    }


    public void west(Visitor x) {

        x.tell("In front of you is a beautifully painted storage cupboard, with golden grooves that trace the design of red spider lillies.");
        x.tell("You open the cupboard to find a selection of gardening tools as well as a calligraphy set");
        
        x.tell("");
        String optionsW = "a) pick a gardening tool\nb) pick up the calligraphy set";
        char[] optW = {'a', 'b'};

        switch(x.getChoice(optionsW, optW))
        {
            case 'a':

                x.tell("");
                String tools = "c) watering can\nd) shovel\ne) sunflower seeds";
                char[] toolChoice = {'c','d','e'};
                switch(x.getChoice(tools, toolChoice))
                {  
                    case 'c':
                        if(westWateringCanState) { x.tell("You already have a watering can in your inventory..."); return; }
                        x.tell("");
                        x.tell("Looks like the garden owner knew what they were doing...");
                        x.giveItem(new Item("Watering can"));
                        
                        westWateringCanState = true;
                        break;
                    case 'd':
                        if(westShovelState) { x.tell("You already have a shovel in your inventory..."); return; }
                        x.tell("");
                        x.tell("The shovel seems to have a red 'X' marked on it. Seems dubious... perhaps it is meant to be used somewhere.");
                        x.giveItem(new Item("Shovel"));
                        x.tell("[You have obtained a shovel. This may be of use in this room or another room.]");
                        x.giveGold(5); x.tell("[+5 gold]");
                        
                        westShovelState = true;
                        break;
                    case 'e':
                        if(westSeedsState) { x.tell("You already have sunflower seeds in your inventory..."); return; }
                        x.tell("");
                        x.tell("The narrator of this room also like sunflowers, perfect match!");
                        x.giveItem(new Item("Sunflower seeds"));
                        
                        westSeedsState = true;
                        break;
                    default:
                        System.out.println("Tools choice error.");
                        break;
                }

                break;
            case 'b':
                if(westInkState) { x.tell("More ink got spilt! Who's gonna clean this mess??"); x.takeGold(2); x.tell("[-2 gold]"); return; }
                x.tell("");
                x.tell("*Gasp*\n You have spilt all the ink on the flowers blooming on the ground, what a mess!");
                x.takeGold(2); x.tell("[-2 gold]");
                
                westInkState = true;
                break;
            default:
                System.out.println("West choice error.");
                break;
        }
    }


    public void north(Visitor x) {

        x.tell("In front of you is something that looks like demolished parts of a pirate ship. There is a tattered flag as well as a treasure chest.");
        
        x.tell("");
        String optionsN = "a) pick up flag\nb) open treasure chest";
        char[] optN = {'a', 'b'};

        switch(x.getChoice(optionsN, optN))
        {
            case 'a':
                if(northFlagState) { x.tell("You already have a flag in your inventory..."); return; }
                x.tell("");
                x.tell("There seems to be a pattern on the flag, how good is your memory?");
                x.giveItem(new Item("Flag"));
                x.giveGold(2); x.tell("[+2 gold]");
                
                northFlagState = true;
                break;
            case 'b':
                if(northCerberusState) { x.tell("You've already opened the treasure chest..."); return; }
                if(!x.hasEqualItem(new Item("Key")))
                {
                    x.tell("");
                    x.tell("You will need a key to unlock the chest. The key is not in this room...");
                }
                else
                {
                    x.tell("");
                    x.tell("You have the key!!\n(You unlock the chest to find a mystical baby cerberus jump out the box.)");
                    x.tell("(The cerberus has text written on it's gold-plated collar: find me a companion.)");
                    x.giveItem(new Item("Baby Cerberus"));
                    
                    northCerberusState = true;
                }
                break;
            default:
                System.out.println("North choice error.");
                break;
        }
    }

    public void east(Visitor x) {

        x.tell("You find yourself in the corner room which looks as though it used to be used as an art room.");
        x.tell("The area consists of a painting on each of the 3 open walls. In the centre is a canvas on an easel, covered with a white cloak.");
        
        x.tell("");
        String optionsEA = "a) remove the cloak\nb) inspect the paintings";
        char[] optEA = {'a', 'b'};
        
        switch(x.getChoice(optionsEA, optEA))
        {
            case 'a':
                if(eastCloakState) { x.tell("You've already removed the cloak..."); return; }
                x.tell("");
                x.tell("You remove the cloak to reveal the painting of a storage cupboard, with golden grooves that trace the design of red spider lillies.");
                x.tell("The aura of the painting closely resembles the aura surrounding you currently...");
                
                eastCloakState = true;
                break;
                
            case 'b':
                x.tell("");
                x.tell("Each painting is of various flowers: lavender, red spider lily, snowdrop.");
                String optionsEflower = "a) approach the lavender\nb) approach the red spider lily\nc) approach the snowdrop";
                char[] optEflower = {'a', 'b', 'c'};
                
                switch(x.getChoice(optionsEflower, optEflower))
                {
                    case 'a':
                        x.tell("");
                        x.tell("What a nice flower~");
                        break;
                    case 'b':
                        if(eastLilyState) { x.tell("What a nice flower~"); return; }
                        x.tell("");
                        x.tell("You notice that the tile under the painting of the red spider lily is loose.\n You remove the tile.");
                        x.giveGold(10); x.tell("[+10 gold]");
                        x.tell("How lucky!");
                        
                        eastLilyState = true;
                        break;
                    case 'c':
                        x.tell("");
                        x.tell("What a nice flower~");
                        break;
                    default:
                        System.out.println("East flower error.");
                        break;
                }
                
                break;
            default:
                System.out.println("East choice error.");
                break;
        }
    }

}
