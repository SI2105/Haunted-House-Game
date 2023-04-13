package OOP.ec22612.MP.contributions;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Room_ec21504 extends Room implements Visitor {
    static char[] choices = {'1', '2', '3', '4', '5', '6'};
    private int Gold;
    public boolean lightsOn;
    public ArrayList<Item> itemsInPossession = new ArrayList<Item>();
    public String name;
    public String description;

    public Room_ec21504() {
        lightsOn = true;
        Gold = 3;
        itemsInPossession = new ArrayList<Item>();
        name = "Grand Ballroom";
        description = "The ballroom is old and dusty, and it seemed that it isn't used anymore. A large piano stands in " +
                "the room, and it has a broken leg on one side of it. The room is very quiet. Dust floats in the air. The " +
                "floor is bare and has no carpet. On the walls, there are no pictures, but there are stains of paint and " +
                "smeared blood.\n";
    }

    boolean goldAmountValidityCheck(int numberofPieces, String state) {
        if (numberofPieces > 10) {
            System.out.println("Sorry, that is too much gold to " + state + ".");
            return false;
        }
        if (numberofPieces <= 0) {
            System.out.println("Sorry, that is invalid amount of gold to " + state + ".");
            return false;
        } else {
            return true;
        }
    }

    public void tell(String messageForVisitor) {
        System.out.print(messageForVisitor);
    }

    public char getChoice(String descriptionOfChoices, char[] arrayOfPossibleChoices) {
        System.out.println(descriptionOfChoices);
        char choice = ' ';
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (sc.hasNext()) {
                choice = sc.next().charAt(0);
                for (char c : arrayOfPossibleChoices) {
                    if (c == choice) {
                        return choice;
                    }
                }
            } else {
                System.out.println("Invalid Choice!");
            }
        }
    }

    public boolean giveItem(Item itemGivenToVisitor) {
        itemsInPossession.add(itemGivenToVisitor);
        System.out.println("You get a " + itemGivenToVisitor.name);
        return true;
    }

    public boolean hasIdenticalItem(Item itemToCheckFor) {
        for (int i = 0; i < itemsInPossession.size(); i++) {
            if (itemsInPossession.get(i) == itemToCheckFor) {
                return true;
            }
        }
        return false;
    }

    public boolean hasEqualItem(Item itemToCheckFor) {
        for (int i = 0; i < itemsInPossession.size(); i++) {
            if (itemsInPossession.get(i).equals(itemToCheckFor)) {
                return true;
            }
        }
        return false;
    }


    public void giveGold(int numberOfPiecesToGive) {
        Gold += numberOfPiecesToGive;
        System.out.println("You get " + numberOfPiecesToGive + " gold.");

        System.out.println("You now have " + Gold + " pieces of gold.");
    }

    public int takeGold(int numberOfPiecesToTake) {
        int piecesTaken = numberOfPiecesToTake;

        if (Gold-numberOfPiecesToTake < 0) {
            piecesTaken = numberOfPiecesToTake - Math.abs(Gold-numberOfPiecesToTake);
        }
        return piecesTaken;
    }

    public void introduceRoom(Visitor visitor) {
        visitor.tell("You are in the " + name + ".\n");
        visitor.tell(description);
    }

    public void toggleLight(Visitor visitor) {
        visitor.tell(((lightsOn) ? "You turn off the lights" : "You turn on the lights") + ".\n");
        lightsOn = !lightsOn;
    }

    public Direction visit(Visitor visitor, Direction d) {
        introduceRoom(visitor);
        visitor.tell("The lights are " + ((lightsOn) ? "on" : "off") + ".\n");
        visitor.tell("You have " + Gold + " pieces of gold.\n");

        boolean inRoom = true;
        while (inRoom) {
            char choice = visitor.getChoice("What do you want to do?\n1. Where am I?\n2. Toggle the lights\n3. Look for gold\n4. Leave gold\n5. Search the room for items\n6. Leave", choices);
            if (choice == '1') {
                introduceRoom(visitor);
            } else if (choice == '2') {
                toggleLight(visitor);
            } else if (choice == '3') {
                int goldToGive = new Random().nextInt(4);

                visitor.giveGold(goldToGive);

            } else if (choice == '4') {
                int toTake = visitor.takeGold(new Random().nextInt(4));

                Gold -= toTake;

                System.out.println("You have " + toTake + " pieces of gold taken.");
                System.out.println("You now have " + Gold + " pieces of gold.");


            } else if (choice == '5') {
                visitor.tell("You search the room for items.\n");

                if (new Random().nextBoolean()) {
                    visitor.tell("WOW! YOU JUST FOUND AN ITEM!\n");

                    String[] items = {"flashlight", "ring", "key", "lighter", "bloodied robe"};

                    String chosenItem = items[new Random().nextInt(items.length)];

                    visitor.tell("You have just found a " + chosenItem.toUpperCase() + "\n\n");

                    visitor.giveItem(new Item(chosenItem));
                    visitor.tell("\n");
                } else {
                    visitor.tell("You did not find anything in your search.\n");
                }

            } else if (choice == '6') {
                System.out.println("You decide to leave the '" + name + "'");
                inRoom = false;
            } else {
                System.out.println("INVALID SELECTION!");
            }
        }

        return Direction.opposite(d);
    }
}
