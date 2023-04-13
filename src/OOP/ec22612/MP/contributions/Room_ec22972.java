package OOP.ec22612.MP.contributions;

class Room_ec22972 extends Room{
    public Direction visit(Visitor v, Direction d){
        boolean lightsOn = false;
        boolean openedSafe = false;
        boolean poltergeistFriendly = true;
        boolean doorOpened = false;

        final Item safeKey = new Item("Safe key");
        final Item doorKey = new Item("Door key");
        final Item flashlight = new Item("Flashlight");
        final Item goldenKnife = new Item("Golden knife");

        v.tell("You seemed to have somehow ended up at Winchester Mansion...");

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
            char lights = v.getChoice("Would you like to turn on the lights? y/n", new char[] {'y', 'n'});
            if(lights == 'y'){
                lightsOn = true;
                v.tell("You flipped the switch...");
                v.tell("The lights turned on...");
                v.tell("You found some gold on the floor!");
                v.giveGold(3);
            }
            else if(lights == 'n'){
                v.tell("The room is very dark...");
                v.tell("You ended up tripping over a mysterious object...");
                char pickUp = v.getChoice("Would you like to pick it up? y/n", new char[] {'y', 'n'});
                if(pickUp == 'y'){
                    v.tell("Congratulations! You idiotically found a flashlight! And some gold...");
                    v.giveGold(3);
                    if(v.giveItem(flashlight) == true){
                        v.tell("The flashlight turned on... and it almost blinds you...");
                        lightsOn = true;
                    }else{
                        v.tell("I forced you to turn on your flashlight!");
                        v.tell("The flashlight turned on... and it almost blinds you...");
                        lightsOn = true;
                    }
                }
                else if(pickUp == 'n'){
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

        char choice = v.getChoice("Would you like to a) look through books from the bookshelf b) Open this large chest c) Go to this small desk in the corner d) Go play the piano in the opposite corner", new char[] {'a', 'b', 'c', 'd'});

        if(choice == 'a'){
            v.tell("You open a book and found a golden key!");
            if(v.giveItem(doorKey) == true){
                v.giveGold(2);
            }else{}
            v.tell("Fortunately, when you took out the book, you found some gold!");
            v.giveGold(4);
            if(poltergeistFriendly == true){
                v.tell("Poltergeist was friendly and GIVES you some gold!");
                v.giveGold(6);
            }
        }
        else if (choice == 'b'){
            v.tell("Along the way to the chest, you found a safe key on the floor with some gold!");
            if(v.giveItem(safeKey) == true){
                v.giveGold(2);
            }else{}
            v.tell("You opened the chest and found a safe!");
            if(v.hasIdenticalItem(safeKey) == false){
                v.tell("You do not have the key to open this safe...");
            }
            if(openedSafe == true){
                v.tell("This safe has already been opened... There was nothing left inside");
            }
            else{
                if(v.hasIdenticalItem(safeKey) == true){
                    char open = v.getChoice("Open the safe? y/n", new char[] {'y', 'n'});
                    if(open == 'y'){
                        v.tell("You opened the safe and found some gold!");
                        v.giveGold(6);
                        openedSafe = true;
                        poltergeistFriendly = false;
                    }
                    else if (open == 'n'){
                        v.tell("Don't regret it!");
                        poltergeistFriendly = true;
                    }
                }
            }
            if(poltergeistFriendly == false){
                v.tell("Poltergeist was angry and STOLE some gold off you!");
                v.takeGold(3);
            }
        }
        else if (choice == 'c'){
            v.tell("You visit the small desk and decided to open the draw!");
            v.tell("You find a golden knife and some gold!");
            if(v.giveItem(goldenKnife) == true){
                v.giveGold(3);
                v.tell("You stop hearing occaisonal footsteps...");
                poltergeistFriendly = true;
            }else{}
        }
        else if (choice == 'd'){
            char play = v.getChoice("Would you like to play the piano? y/n", new char[] {'y', 'n'});
            if(play == 'y'){
                v.tell("You pressed some keys and the poltergeist is very proud of you! You played very well so you receive some gold!");
                v.giveGold(3);
                poltergeistFriendly = true;
            }
            else if(play == 'n'){
                v.tell("You did not play anything... The poltergeist got mad and took some gold from you!");
                v.takeGold(6);
                poltergeistFriendly = false;
            }
        }

        if(v.hasIdenticalItem(doorKey) == true){
            v.tell("You use the key to enter the next door! You found some gold along the way!");
            doorOpened = true;
            v.giveGold(10);
            return Direction.opposite(d);
        }

        if(poltergeistFriendly = false){
            v.tell("Poltergeist was very angry! You lose some gold!");
            v.takeGold(6);
        }
        
        v.tell("You see a poltergeist infront of you!");
        v.tell("You get scared and busted open the next door without a key!");
        doorOpened = true;
        v.tell("You dropped some gold along the way!");
        v.takeGold(6);

        return Direction.opposite(d);
    }
}
