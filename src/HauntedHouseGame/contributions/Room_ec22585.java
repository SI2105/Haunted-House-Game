package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22585 extends Room {
    boolean lights = true;
    boolean ghost = false;

    public Direction visit(Visitor visiting_user, Direction direction_entered) {
        // To get the second word and tell the user where they entered from...
        // Splits the string "heading XXX" to an array containing "heading" and "XXX"
        String[] ax = direction_entered.toString().split(" ");
        visiting_user.tell("You have entered from: " + ax[1]);
        Random rand = new Random();

        visiting_user.tell("You are in room ec22585");
        visiting_user.tell("\nThe state of the room is as follows:" +
                            "\nLights are on: " + lights +
                            "\nGhost is happy: " + ghost +
                            "\nThere are many treasures to find!\n");
        // In case they don't pick:
        Direction to_go = Direction.TO_WEST;
        char choice;

        if (lights) {
            visiting_user.tell("As the light is currently on, you can have a search for some treasures!");
            char[] choices = {'b', 'w', 'c'};
            choice = visiting_user.getChoice("Which area of the room do you want to search first? (b=bed, w=wardrobe, c=chest)", choices);
            if (choice=='b') {
                visiting_user.tell("You have chosen to search the bed");
                int random_number = (rand.nextInt(5)) + 1;

                visiting_user.tell("Its already been looted quite a bit, but you stil find " + random_number + " gold");
                visiting_user.giveGold(random_number);
            }

            else if (choice=='w') {
                int random_number = (rand.nextInt(5)) + 1;
                visiting_user.tell("You have chosen to search the wardrobe");
                visiting_user.tell("You are able to find " + random_number + " gold");
                visiting_user.giveGold(random_number);
            }

            else if (choice=='c') {
                int random_number = (rand.nextInt(4)) + 1;
                visiting_user.tell("You have chosen to search the chest");

                if (random_number == 1) {
                    visiting_user.tell("You can't see any gold but you find a map, the map tells you to go: north");
                    to_go = Direction.TO_NORTH;
                }
                else if (random_number == 2) {
                    visiting_user.tell("You can't see any gold but you find a map, the map tells you to go: east");
                    to_go = Direction.TO_EAST;
                }
                else if (random_number == 3) {
                    visiting_user.tell("You can't see any gold but you find a map, the map tells you to go: south");
                    to_go = Direction.TO_SOUTH;
                }
                else {
                    visiting_user.tell("You can't see any gold but you find a map, the map tells you to go: west");
                }                
            }

            else {
                visiting_user.tell("You dont search anything in the room");
            }
        }

        else {
            visiting_user.tell("As the light is currently off, you are less likely to find treasures but maybe their are some hidden rooms...");
            char[] choices = {'b', 'w', 'c'};
            choice = visiting_user.getChoice("Which area of the room do you want to search first? (b=bed, w=wardrobe, c=chest)", choices);
            if (choice=='b') {
                visiting_user.tell("You have chosen to search the bed");
                int random_number = (rand.nextInt(5)) + 1;

                visiting_user.tell("Its already been looted quite a bit, you still find " + random_number + " gold");
                visiting_user.giveGold(random_number);
            }

            else if (choice=='w') {
                visiting_user.tell("Since the lights are off you cant immediately see anything in the wardrobe");
                visiting_user.tell("You scavenge a bit and accidentally press a button...");
                enterDungeon(visiting_user, "wardrobe");
                visiting_user.tell("You managed to escape and quickly exit the room");
            }

            else if(choice=='c') {
                visiting_user.tell("You dont know how to open the chest, maybe its best to try again later");
            }

            visiting_user.tell("The ghost appears and spooks you, he shouts GO WEST");
            visiting_user.tell("You quickly hurry out of the west door");
        }


        char[] choices = {'y', 'n'};
        if (lights) {
            choice = visiting_user.getChoice("As you are departing would you like to switch off the lights? (y/n)", choices);
        }
        else {
            choice = visiting_user.getChoice("As you are departing would you like to switch on the lights? (y/n)", choices);
        }

        if (choice == 'y') {
            lights = !lights;
        }

        String[] ax2 = to_go.toString().split(" ");
        visiting_user.tell("You are next going: " + ax2[1]);

        return to_go;
    }

    private void enterDungeon(Visitor visiting_user, String area) {
        visiting_user.tell("You enter a hidden room inside the " + area);
        char choice;
        visiting_user.tell("The ghost spooks you and tells you that you must answer some trick questions");

        visiting_user.tell("The first riddle appears...\n");
        char[] choices = {'1', '2', '3'};
        visiting_user.tell("You're in 4th place right now in a race. " +
                                        "What place will you be in when you pass the person in 3rd place?");
        choice = visiting_user.getChoice("1 = 1st place, 2 = 2nd place, 3 = 3rd place", choices);
        if (choice == '3') {
            visiting_user.tell("\nCorrect, good work!");
            visiting_user.tell("The door in front opens and The next riddle quickly appears...\n");
            visiting_user.tell("A farmer has 17 goats. All of them but 8 die. How many goats are alive?");
            char[] choices2 = {'8', '9', '0'};
            choice = visiting_user.getChoice("8, 9 or 0", choices2);
            if (choice == '8') {
                visiting_user.tell("\nCorrect, good work!");
                visiting_user.tell("The final door opens and you find: ");
                Item banana = new Item("banana");
                visiting_user.giveItem(banana);
                visiting_user.tell("A mysterious banana...");
                visiting_user.tell("The door behind you starts closing and you quickly squeeze through");
            }
            else {
                visiting_user.tell("\nIncorrect...");
                visiting_user.tell("The room is unhappy and you hear the ghost coming...");
                return;
            }
        }
        else {
            visiting_user.tell("\nIncorrect...");
            visiting_user.tell("The room is unhappy and you hear the ghost coming...");
            return;
        }
    }
}
