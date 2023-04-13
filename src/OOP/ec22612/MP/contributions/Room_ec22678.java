package OOP.ec22612.MP.contributions;

class Room_ec22678 extends Room {

    static final Item flashlight = new Item("Flashlight");
    boolean lightOn = false;

    public Direction visit(Visitor v, Direction d){
        if(!lightOn){
            v.tell("You enter a room that is dark as the night.");
        } else{
            v.tell("You enter a room which is dully lit");
        }

        if(v.hasIdenticalItem(flashlight)){
            v.tell("You illuminate the room with your flashlight and look around to see old furniture");
            v.tell("However, upon further inspection you notice that the room has minimal dust and fingerprints along certain furniture");
            v.tell("You start to wonder if you are truly alone");

        } else{
            v.tell("You walk through a dully lit room only to stumble trippingo over multiple pieces of furniture and inevitably fall down");
            v.tell("As you hit the floor with a loud thud, a light illuminates  half of the room seemingly from the floor");
            v.tell("Hesitantly, you walk over towards the light to find a flashlight");
            v.giveItem(flashlight);

        }
        char[] choice = {'a','b','c', 'd'};

        v.tell("a) Inspect clock");
        v.tell("b) Examine room");
        v.tell("c) Find light switch");
        v.tell("d) Leave the room");

        char userChoice = v.getChoice("What do you decide to do?", choice);

        if(userChoice == 'a'){
            v.tell("You walk over to the clock and notice this is not your ordinary clock");
            v.tell("This clock is a pendulum clock is still swinging");
            v.tell("As you continue to inspect the clock you see a drawer near the bottom of it");
            v.tell("As you open it, you see 3 gold and take it");
            v.giveGold(4);
            v.tell("As you take the money, you feel as though you are being watched and panick starts to set in, and you take your hastly leave");

        } else if(userChoice == 'b'){
            v.tell("As you walk around pointing your flashlight, you notice that the wallpaper is starting to peel");
            v.tell("While your walking, you notice that this place is probably centuries old.");
            v.tell("As that thought comes acroos your head, you trip over a rolled up mat and some gold slips out");
            v.takeGold(3);
            v.tell("As you try to look for the gold you lost you notice that all the gold has conveniently slipped between the floorboards");
            v.tell("Frustrated you leave the room");

        } else if(userChoice == 'c'){
            if(!lightOn){
                v.tell("You look around with your flashlight and spot that there is a lightbulb");
                v.tell("You inspect the room some more and notice that there is a light switch on the other end of the room");
                v.tell("You manage to make your way to the otherside of the room and press the lightswitch");
                v.tell("As you press the lightswitch, you feel as though someone is looking at you with not the best intentions.");
                v.tell("You glance around and its just you.");
                v.tell("Uneasy, you leave the room");

            } else{
                v.tell("You find the light switch and turn the light off to mark this room as searched");
                v.tell("You then take your leave");

            }
        }
        return Direction.opposite(d);

    }
}
