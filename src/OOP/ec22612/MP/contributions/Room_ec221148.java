package OOP.ec22612.MP.contributions;

import java.util.Random;

class Room_ec221148 extends Room {

    private boolean lights = false;
    private boolean creature = true;
    private boolean angry = false;
    private boolean lost = false;
    private Item RingOfNecromancy = new Item("Ring of Necromancy");

    public Direction visit(Visitor adventurer, Direction directionFrom) {

        Direction exit = directionFrom;
        adventurer.tell("Welcome, brave adventurer, to the Chamber Of Shadows.");
        adventurer.tell("Simply type 'N' to go North, 'E' to go East, 'S' to go South or 'W' to go West.");

        if (directionFrom == Direction.FROM_NORTH) {
            adventurer.tell("You have arrived from the north.");
        } else if (directionFrom == Direction.FROM_EAST) {
            adventurer.tell("You have arrived from the east.");
        } else if (directionFrom == Direction.FROM_SOUTH) {
            adventurer.tell("You have arrived from the south.");
        } else if (directionFrom == Direction.FROM_WEST) {
            adventurer.tell("You have arrived from the west.");
        }

        if (!lights) {
            adventurer.tell("The room is in complete darkness. You stumble around untill you come accross a brazier.");
            char lightChoice = adventurer.getChoice("Would you like to do? (A)Light the brazier or (B)Continue stumbling around in the dark and look for something else or try using N, E, S or W", new char[] { 'N', 'E', 'S', 'W', 'A', 'B' });

            if (lightChoice == 'N' || lightChoice == 'E' || lightChoice == 'S' || lightChoice == 'W') {
                adventurer.tell("You try to leave through the correct door, but you are disorientated and can't see anything to you leave through a random door.");
                exit = randomDoor(exit, adventurer);
                lost = true;
            } else if (lightChoice == 'A') {
                lights = true;
                adventurer.tell("You light the brazier and the room is dimly iluminated. You look around and see...nothing.");
                adventurer.tell("The room contains 4 doors, like every other room you have been in so far, but here is nothing else. No chest, no bed, no wardrobe.");
                adventurer.tell("However, as you look around, a droplet of water hits your hair. As you glance up, you see a humanoid figure clinging to the ceiling, spiderlike.");
                adventurer.tell("You make eye contact with the being as it start crawling around, making its way to the floor. You stand frozen.");
                adventurer.tell("When the figure is on the floor, the light now iluminates the figure and you can make out more features.");
                adventurer.tell("It is a young girl with long, dark hair covering her face. She moves in a jerky, unnatural manner, as if controlled by some otherworldly force. As she moves towards you, the girl's hair begins to part, revealing her twisted, contorted features. Her eyes are dark, hollow voids, and her skin is a sickly, pale white. Her mouth hangs open in a silent scream, revealing sharp, blackened teeth that seem to gnash in agony. The longer you stare at her, the more you feel her malevolent gaze piercing through the screen, reaching out to pull you into her world of terror and despair. You know that once you've seen her, you can never unsee her, and you are doomed to a fate worse than death.");
                adventurer.tell("You finally manage to utter the word 'Who are you? Why are you here?'");
                int rand1 = getRandomNumberInRange(1, 2);
                if (rand1 == 1) {
                    adventurer.tell("The Girl: I am trapped here. You are the only one who can help me.");
                } else {
                    adventurer.tell("The Girl: I am an avenging spirit. You have angered me, and now you will pay.");
                }
                char conv1 = adventurer.getChoice("(A)Defiant Response: I'm not afraid of you. I've faced worse.\n (B)Curious Response: How did you end up like this? Is there anything I can do to help you?\n (C)Apologetic Response: I'm sorry if I did something to upset you. Please, let me make it right.", new char[] {'A', 'B', 'C'});
                if (conv1 == 'A') {
                    adventurer.tell("Threatening Response: Your bravery will be your undoing. You cannot escape your fate.");
                    char conv2 = adventurer.getChoice("(A)Fight the girl or (B)Run away", new char[] {'A', 'B'});
                    if (conv2 == 'A') {
                        int rand2 = getRandomNumberInRange(1, 2);
                        if (rand2 == 1) {
                            adventurer.tell("You have decided to fight the creature, but as you charge towards her you slip. She darts out of the way as you fall and then attacks. You loose 5 gold and she throws you out of a random door.");
                            adventurer.tell("The Girl: You think you can defeat me? You are nothing.");
                            adventurer.takeGold(5);
                            creature = true;
                            angry = true;
                        } else if (rand2 == 2) {
                            adventurer.tell("You charge at the creature and after a hard fought battle, you take her down. Once defeater, the girl disapparates and leaves behind a ring. You pick it up and also gain 5 gold.");
                            adventurer.giveGold(5);
                            adventurer.tell("When you put the Ring Of Necromancy on, you feel a freat power surge through you.");
                            adventurer.giveItem(RingOfNecromancy);
                            angry = false;
                            creature = false;
                            lost = true;
                        }
                    } else if (conv2 == 'B') {
                        adventurer.tell("As you try to run away, the creature chases you. In a desperate hurry, you leave through the closet door.");
                        exit = randomDoor(exit, adventurer);
                    }
                } else if (conv1 == 'B') {
                    adventurer.tell("The Girl: Please, find my remains and give me a proper burial. Only then can I rest.");
                    adventurer.tell("Adventurer: I'll do everything in my power to help you find peace.");
                    adventurer.tell("The Girl: Thank you. You are the first to offer me any help.");
                } else if (conv1 == 'C') {
                    adventurer.tell("The Girl: There is a darkness that consumes everything. You are not immune to it.");
                    adventurer.tell("Adventurer: Why should I believe you? How do I know you're not just trying to trick me?");
                    adventurer.tell("The Girl: Be careful what you wish for. The truth can be a dangerous thing.");
                }

            } else if (lightChoice == 'B') {
                adventurer.tell("You keep stumbling around but find nothing. After 10 minutes, you decide to leave through the closet door.");
                exit = randomDoor(exit, adventurer);
                lost = true;
            }

            if (!lost) {
                char choice = adventurer.getChoice("Which door do you use to leave. (Using 'N', 'E', 'S', 'W')", new char[] { 'N', 'E', 'S', 'W'});
                if (choice == 'N') {
                    adventurer.tell("You have left through the North door.");
                    exit = Direction.TO_NORTH;
                } else if (choice == 'E') {
                    adventurer.tell("You have left through the East door.");
                    exit = Direction.TO_EAST;
                } else if (choice == 'S') {
                    adventurer.tell("You have left through the South door.");
                    exit = Direction.TO_SOUTH;
                } else if (choice == 'W'){
                    adventurer.tell("You have left through the West door.");
                    exit = Direction.TO_WEST;
                }
            }
        } else {
            adventurer.tell("Welcome back to the Chamber Of Shadows.");
            if (creature) {
                if (angry) {
                    adventurer.tell("The creature is still angry and attack you on site. However, you are now ready and are able to defeat her.");
                    adventurer.tell("You charge at the creature and after a hard fought battle, you take her down. Once defeater, the girl disapparates and leaves behind a ring. You pick it up and also gain 5 gold.");
                    adventurer.giveGold(5);
                    adventurer.tell("When you put the Ring Of Necromancy on, you feel a freat power surge through you.");
                    adventurer.giveItem(RingOfNecromancy);
                    angry = false;
                    creature = false;
                }
            }
            char choice = adventurer.getChoice("You have already completed this room, feel free to leave. (Using 'N', 'E', 'S', 'W')", new char[] { 'N', 'E', 'S', 'W'});
            if (choice == 'N') {
                adventurer.tell("You have left through the North door.");
                exit = Direction.TO_NORTH;
            } else if (choice == 'E') {
                adventurer.tell("You have left through the East door.");
                exit = Direction.TO_EAST;
            } else if (choice == 'S') {
                adventurer.tell("You have left through the South door.");
                exit = Direction.TO_SOUTH;
            } else if (choice == 'W'){
                adventurer.tell("You have left through the West door.");
                exit = Direction.TO_WEST;
            }
        }
        return exit;
    }

    
    public static int getRandomNumberInRange (int min, int max) {

        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static Direction randomDoor (Direction exit, Visitor adventurer) {
        int randomNumber = getRandomNumberInRange(1, 4);
        if (randomNumber == 1) {
            adventurer.tell("You have left through the North door.");
            exit = Direction.TO_NORTH;
        } else if (randomNumber == 2) {
            adventurer.tell("You have left through the East door.");
            exit = Direction.TO_EAST;
        } else if (randomNumber == 3) {
            adventurer.tell("You have left through the South door.");
            exit = Direction.TO_SOUTH;
        } else {
            adventurer.tell("You have left through the West door.");
            exit = Direction.TO_WEST;
        }
        return exit;
    }
}
