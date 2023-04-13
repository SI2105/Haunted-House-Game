package OOP.ec22612.MP.contributions;/*
explanation of the room:
the room will give the user 5 gold a vintage watch (if the user doe not have a "watch" item with them)
and it return's the user to the opposite end from whichever direction they came from.
To get the item, you need to keep sitting on the chair five times, at that point a figure will appear and give you the gold and item
*/

class Room_ec22524 extends Room
{
    void pr (String a){
        System.out.println(a);
    }

    public Direction visit (Visitor visitor, Direction directionVistorArrivesFrom)
    {
        try {
            char choiceOptions = 'a';

            boolean chairState = false;
            int satNumber = 0;
            boolean done=false;

            visitor.tell("You walk in and see a very dark room with a single chair.");

            boolean leave = false;
            while (!leave) {

                if (!chairState) {
                    choiceOptions = visitor.getChoice("Your choices right now: a. Asses Your Situation, b. Sit in the Chair, c. Leave to next room", new char[]{'a', 'b', 'c'});
                } else {
                    choiceOptions = visitor.getChoice("Your choices right now: a. Asses Your Situation, b. Continue sitting in the Chair, c. Get Up d. Move on to next room", new char[]{'a', 'b', 'c', 'd'});
                }

                // option methods
                if (choiceOptions == 'a') {
                    if (!chairState) {
                        visitor.tell("You are standing in the room.");
                    }
                    if (chairState) {
                        visitor.tell("You are sitting in the chair.");
                    }
                }
                else if (choiceOptions == 'b') {
                    chairState = true;
                    visitor.tell("You are now sitting in the chair.");
                    satNumber++;
                }
                else if (choiceOptions == 'c' && chairState) {
                    chairState = false;
                    visitor.tell("You have gotten up from the chair.");
                }
                else if (choiceOptions == 'c' && !chairState) {
                    leave = true;
                }
                else if (choiceOptions == 'd' && !chairState) {
                    visitor.tell("You have exited the house.");
                    leave = true;
                }
                else if (choiceOptions == 'd' && chairState) {
                    leave = true;
                }
                else {
                    visitor.tell("Not an option.");
                }


                if (satNumber == 5 && !done) {
                    visitor.tell("A ghostly figure emerges from the shadow. It wishes to reward you for your bravery for sitting in that chair for so long. It gives you a 5 gold. ");
                    visitor.giveGold(5);
                    if (!visitor.hasEqualItem(new Item("Watch"))) {
                        visitor.giveItem(new Item("A Vintage Watch"));
                    }
                    done=true;
                    visitor.tell("'Move on, brave one.', the dark figure advises you.");
                }
            }
        }

        catch (Exception e) {
            System.out.println("Something went wrong.");
        }
        System.out.println("\n");
        return Direction.opposite(directionVistorArrivesFrom);
    }
}
