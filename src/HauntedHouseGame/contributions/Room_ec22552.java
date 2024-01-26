package HauntedHouseGame.contributions;

class Room_ec22552 extends Room{
    public Direction visit(Visitor v, Direction d){

        char[] yesNo = {'Y', 'N'};
        char[] options = {'a', 'b', 'c'};

        boolean lightsOn = false;
        boolean openedSafe = false;
        boolean poltergeistFriendly = true;
        boolean doorOpened = false;

        final Item pieceofplastic = new Item("Piece of Plastic");
        final Item doorKey = new Item("Door Key");
        final Item flashlight = new Item("Flashlight");
        final Item goldenKnife = new Item("Golden Knife");

        v.tell("You seem to have somehow ended up at Winchester Mansion...");

        if(d == Direction.FROM_NORTH){
            v.tell("You have entered from the north door.");
        }
        else if (d == Direction.FROM_EAST){
            v.tell("You have entered from the east door.");
        }
        else if (d == Direction.FROM_SOUTH){
            v.tell("You have entered from the south door.");
        }
        else if (d == Direction.FROM_WEST){
            v.tell("You have entered from the west door.");
        }

        v.tell("You are in a small room, stood by what seems to be a bookshelf...");
        v.tell("You hear occaisonal footsteps...");

        if(lightsOn == false){
            v.tell("The room is very dark...");
            v.tell("You somehow found the lightswitch!");
            char lights = v.getChoice("Would you like to turn on the lights? Y/N", yesNo);
            if(lights == 'y'){
                lightsOn = true;
                v.tell("You flipped the switch...");
                v.tell("The lights turned on...");
                v.tell("You found some gold on the floor!");
                v.giveGold(3);
            }
            else{
                v.tell("The room is very dark...");
                v.tell("You ended up tripping over a mysterious object...");
                char pickUp = v.getChoice("Would you like to pick it up? Y/N", yesNo);
                if(pickUp == 'y'){
                    v.giveItem(flashlight);
                    v.tell("Congratulations! You idiotically found a flashlight! And some gold...");
                    v.giveGold(3);
                    char use = v.getChoice("Use the flashlight? Y/N", yesNo);
                    if(use == 'y'){
                        v.tell("The flashlight stays off... silly goose...");
                        lightsOn = false;
                    }
                    else{
                        v.tell("I forced you to turn on your flashlight!");
                        v.tell("The flashlight turned on... and it almost blinds you...");
                        lightsOn = true;
                    }
                }
                else{
                    v.tell("The lights magically turned on...");
                    lightsOn = true;
                    poltergeistFriendly = false;
                }
            }
        }
        else{
            v.tell("The room is very well bright...");
        }

        v.tell("*CREAK*");
        v.tell("You have realised the door shut behind you...");
        v.tell("You tried opening it and it refused to budge...");
        v.tell("Poltergeist: You must find the key to escape to enter the next room...");
        v.tell("It is now time to explore this place!");

        char choice = v.getChoice("Would you like to a) look through books from the bookshelf b) Open this large chest c) Go to the small desk in the corner", options);

        if(choice == 'a'){
            v.tell("You open a book and found a golden key!");
            v.giveItem(doorKey);
            v.tell("Fortunately, when you took out the book, you found some gold!");
            v.giveGold(6);
            if(poltergeistFriendly = true){
                v.tell("Poltergeist was friendly and GIVES you some gold!");
                v.giveGold(5);
            }
        }
        else if (choice == 'b'){
            v.tell("Along the way to the chest, you found a piece of plastic that you don't know what to do with on the floor with some gold!");
            v.giveItem(pieceofplastic);
            v.tell("You fiddled with the plastic and mended it to stick it in the keyhole of the safe real hard!");
            if(openedSafe == true){
                v.tell("This safe has already been opened... There was nothing left inside");
            }
            else{
                char open = v.getChoice("Open the safe? Y/N", yesNo);
                if(open == 'y'){
                    v.tell("You managed to open the safe with apparently not so useless piece of plastic and found some gold!");
                    v.giveGold(6);
                    openedSafe = true;
                }
                else{
                    v.tell("Don't regret it!");
                }
            }
            if(poltergeistFriendly == false){
                v.tell("Poltergeist was angry and STOLE some gold off you!");
                v.takeGold(5);
            }
        }
        else if (choice == 'c'){
            v.tell("You visit the small desk and decided to open the draw!");
            v.tell("You find a golden knife and some gold!");
            v.giveItem(goldenKnife);
            v.giveGold(4);
            v.tell("You stop hearing occaisonal footsteps...");
            poltergeistFriendly = true;
        }

        if(v.hasEqualItem(doorKey)){
            v.tell("You use the key to enter the next door! You found some gold along the way!");
            doorOpened = true;
            v.giveGold(15);
            return Direction.opposite(d);
        }

        v.tell("You see a poltergeist infront of you!");
        v.tell("You get scared and bust open the next door without a key!");
        doorOpened = true;
        v.tell("You dropped some gold along the way!");
        v.takeGold(3);

        return Direction.opposite(d);
    }
}
