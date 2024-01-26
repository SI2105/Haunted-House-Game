package HauntedHouseGame.contributions;

class Room_ec22860 extends Room {

    Item plotDevice = new Item("key");
    boolean mapCollected = false;

    public Direction visit (Visitor guest, Direction orientation) {
        guest.tell("Welcome to the Winchester Mystery House.");

        if(guest.hasIdenticalItem(plotDevice))
        {
            guest.tell("You already have the key. Why are you still here?");
            guest.tell("You have 5 Gold");
            guest.giveGold(5);
        }
        else{
            guest.tell("You will continue now.");
            if (orientation == Direction.FROM_NORTH) {
                guest.tell("You arrived from the North.");
            }
            else if (orientation == Direction.FROM_SOUTH) {
                guest.tell("You arrived from the South.");
            }
            else if (orientation == Direction.FROM_EAST) {
                guest.tell("You arrived from the East.");
            }
            else if (orientation == Direction.FROM_WEST) {
                guest.tell("You arrived from the West.");
            }
            else{
                guest.tell("Are you in the right place?");
            }
            guest.tell("The room is dark and you only have a torch. Let's explore.");
            guest.tell("You find an old chest and decide to open it. It's full of stuff: a map, a knife, a key and a letter");

            char [] choices = {'a','b','c','d'};

            guest.tell("(a) Pick up the map");
            guest.tell("(b) Pick up the knife");
            guest.tell("(c) Pick up the key");
            guest.tell("(d) Pick up the letter");
            char options = guest.getChoice("What will you do? ", choices);

            if(options=='a')
            {
                guest.tell("You know have a map of the house. But it looks like it a piece has been ripped off.");
                mapCollected =true;
                guest.tell("You have now gained 3 gold");
                guest.giveGold(3);
            }
            else if (options=='b')
            {
                guest.tell("Why would you pick up the knife? ");
                guest.tell("This knife was used in a murder. Scary.");
                guest.tell("You have now lost 2 gold");
                guest.takeGold(2);

            }
            else if (options=='c')
            {
                guest.tell("You picked up the key, keep it safe!");
                guest.tell("You can use it to leave the main door... wherever that is.");
                guest.tell("You have now gained 5 gold");
                guest.giveGold(5);


            }
            else if (options=='d')
            {
                guest.tell("You opened the letter to read it.");
                guest.tell("In it, you find the story of the house and a missing piece of a map. You can use this to successfully leave");
                guest.tell("You have now gained 7 gold");
                guest.giveGold(7);
            }
        }

        guest.tell("You finally decide that you've done enough exploring. Time to go!");
        guest.tell("Have a good one!");

        return Direction.opposite(orientation);

    }


}
