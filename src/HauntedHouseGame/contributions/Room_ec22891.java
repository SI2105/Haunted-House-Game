package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22891 extends Room {

    static boolean lightsOn = true;
    static boolean chestOpen = false;
    static Item key = new Item("Key");
    static boolean torchTaken = false;
    static Item torch = new Item("Torch");

    private void switchLightsOption(Visitor visitor){
        String lightsCondition = lightsOn ? "on" : "off";
        visitor.tell("The lights are currently " + lightsCondition);
        char choice = visitor.getChoice("Pick a choice\n a) flip light switch\n b) do nothing", new char[]{'a', 'b'});

        switch(choice){
            case 'a':
            lightsOn = !lightsOn;
            lightsCondition = lightsOn ? "on" : "off";
            visitor.tell("The lights are now switched " + lightsCondition + ".");
            break;

            default:
                break;
        }
    }

    private void searchTable(Visitor visitor){
        if(visitor.hasIdenticalItem(key) || chestOpen){
            visitor.tell("After searching the table, all you are able to find are documents and photographs of the family.");
            return;
        }

        Random random = new Random();
        if(random.nextInt(2) == 0){
            visitor.giveItem(key);
            visitor.tell("You manage to find a small key underneath some papers that appears to match the padlock on the chest.");
            visitor.tell("You wander over to the chest, insert the key, turn the key and... the chest opens.");
            int amountOfGold = random.nextInt(3) + 2;
            visitor.tell("You open the chest and count a total of " + amountOfGold + " gold pieces");
            visitor.giveGold(amountOfGold);
            chestOpen = true;
        } else {
            visitor.tell("After searching everywhere you could think of, you are still unable to find the key.");
            visitor.tell("Perhaps it was never in this room to begin with.");
        }
    }

    private void searchDrawers(Visitor visitor){
        int goldTaken = visitor.takeGold(1);
        visitor.tell("As you are walking over to the drawers, a plank of wood beneath you gives way and you trip.");
        if(goldTaken == 0) visitor.tell("dropping a piece of gold from your pocket. It falls between the floorboards into the darkness below.");
        visitor.tell("You immediately get back on your feet and walk very carefully towards the drawers.");
        visitor.tell("You search the drawers wading through the piles of clothes.");

        if(visitor.hasIdenticalItem(torch) || torchTaken){
            visitor.tell("Unfortunately, you find nothing else but clothes in the drawers.");
        } else {
            visitor.tell("Hidden underneath the clothes you spot a torch. You take it with you in case you need to see in the dark.");
            visitor.giveItem(torch);
            torchTaken = true;
        }
    }

    public Direction visit(Visitor visitor, Direction arrivalDirection){

	    String lightsCondition = lightsOn ? "well-lit" : "dark";
        visitor.tell("As you enter the " + lightsCondition + " bedroom, you notice the floral wallpaper and the intricate chandelier hanging from the ceiling.");
        visitor.tell("To your right, you see the four-poster bed with a canopy with a beautifully carved wooden headboard.");

        if(!chestOpen){
            visitor.tell("As you move further into the room, a glowing chest catches your attention. Upon further inspection you see a padlock\nconnected across its latch");
            visitor.tell("Perhaps the key is somewhere in this room.");
        }

        char choice = visitor.getChoice("What area of the room would you like to explore?\n a) The table\n b) The drawers\n c) I'm not looking to explore the room", new char[]{'a', 'b', 'c'});

        switch(choice){
            case 'a':
                searchTable(visitor);
                break;

            case 'b':
                searchDrawers(visitor);
		        break;

            default:
                visitor.tell("Very well, as you wish.");
        }

        switchLightsOption(visitor);
        visitor.tell("You decide to leave the room.");
        return Direction.opposite(arrivalDirection);
    }
}
