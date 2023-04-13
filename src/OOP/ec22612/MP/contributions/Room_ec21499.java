package OOP.ec22612.MP.contributions;

class Room_ec21499 extends Room {

    Item plotDevice = new Item("key");
    boolean mapCollected = false;

    public Direction visit (Visitor guest, Direction orientation) {
        System.out.println("Welcome to the Mystery House.");

        if(guest.hasIdenticalItem(plotDevice))
        {
            System.out.println("You already have the key. Why are you still here?");
            System.out.println("You have 5 Gold");
            guest.giveGold(5);
        }
        else{
            System.out.println("You will continue now.");
            if (orientation == Direction.FROM_NORTH) {
                System.out.println("You arrived from the North.");
            }
            else if (orientation == Direction.FROM_SOUTH) {
                System.out.println("You arrived from the South.");
            }
            else if (orientation == Direction.FROM_EAST) {
                System.out.println("You arrived from the East.");
            }
            else if (orientation == Direction.FROM_WEST) {
                System.out.println("You arrived from the West.");
            }
            else{
                System.out.println("Are you in the right place?");
            }
            System.out.println("The room is dark and you only have a torch. Let's explore.");
            System.out.println("You find an old chest and decide to open it. It's full of stuff: a map, a knife, a key and a letter");

            char [] choices = {'a','b','c','d'};

            System.out.println("(a) Pick up the map");
            System.out.println("(b) Pick up the knife");
            System.out.println("(c) Pick up the key");
            System.out.println("(d) Pick up the letter");
            char options = guest.getChoice("What will you do? ", choices);

            if(options=='a')
            {
                System.out.println("You know have a map of the house. But it looks like it a piece has been ripped off.");
                mapCollected =true;
                System.out.println("You have now gained 3 gold");
                guest.giveGold(3);
            }
            else if (options=='b')
            {
                System.out.println("Why would you pick up the knife? ");
                System.out.println("This knife was used in a murder. Scary.");
                System.out.println("You have now lost 1 gold");
                guest.takeGold(1);

            }
            else if (options=='c')
            {
                System.out.println("You picked up the key, keep it safe!");
                System.out.println("You can use it to leave the main door... wherever that is.");
                System.out.println("You have now gained 5 gold");
                guest.giveGold(5);


            }
            else if (options=='d')
            {
                System.out.println("You opened the letter to read it.");
                System.out.println("In it, you find the story of the house and a missing piece of a map. You can use this to successfully leave");
                System.out.println("You have now gained 7 gold");
                guest.giveGold(7);
            }
        }

        System.out.println("You finally decide that you've done enough exploring. Time to go!");
        System.out.println("Thank you for visiting The Room");
        return Direction.opposite(orientation);

    }
}
