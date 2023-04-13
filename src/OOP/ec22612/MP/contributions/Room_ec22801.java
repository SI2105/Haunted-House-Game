package OOP.ec22612.MP.contributions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Room_ec22801 extends Room implements Visitor {

    private boolean lightsOn;
    private int gold;
    List<Item> myItemList = new ArrayList<Item>();
    private String name;
    private String description;

    //private static Scanner sc() {return new Scanner(System.in);}

    public Room_ec22801() {
        lightsOn = false;
        gold = 5;
        myItemList = new ArrayList<Item>();
        name = "Switchback Staircase";
        description = "This room features a strange, twisting staircase that appears to lead nowhere. It is made up of seven flights of stairs, each with only a few steps, and includes multiple turns and landings. Visitors who climb the staircase must constantly adjust their footing and direction, as the stairs seem to lead in a different direction with each turn. The Switchback Staircase is just one of the many confusing and enigmatic features of the Winchester Mystery House, which is renowned for its maze-like layout and many architectural oddities.";
    }

    //@Override
    public void tell(String messageForVisitor) {
        System.out.print(messageForVisitor);
    }

    @Override
    public char getChoice(String descriptionOfChoices, char[] arrayOfPossibleChoices) {
        System.out.println(descriptionOfChoices);
        char choice = ' ';
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (sc.hasNext()) {
                choice = sc.next().charAt(0);
                for (char c : arrayOfPossibleChoices) {
                    if (c == choice) {
                        //sc.close();
                        return choice;
                    }
                }
            } else {
                System.out.println("No such choice!");
            }
        }
    }

    //@Override
    public boolean giveItem(Item itemGivenToVisitor) {
        myItemList.add(itemGivenToVisitor);
        System.out.println("You give " + itemGivenToVisitor.name + " to the visitor.");
        return true;
    }

    //@Override
    public boolean hasIdenticalItem(Item itemToCheckFor) {
        for (Item i : myItemList) {
            if (i == itemToCheckFor) {
                return true;
            }
        }
        return false;
    }

    //@Override
    public boolean hasEqualItem(Item itemToCheckFor) {
        for (Item i : myItemList) {
            if (i.equals(itemToCheckFor)) {
                return true;
            }
        }
        return false;
    }

    //@Override
    public void giveGold(int numberOfPiecesToGive) {
        gold += numberOfPiecesToGive;
        System.out.println("You give " + numberOfPiecesToGive + " pieces of gold to the visitor.");
    }

    //@Override
    public int takeGold(int numberOfPiecesToTake) {
        if (gold >= numberOfPiecesToTake) {
            gold -= numberOfPiecesToTake;
            return numberOfPiecesToTake;
        } else {
            int temp = gold;
            gold = 0;
            return temp;
        }
    }

    //@Override
    public Direction visit(Visitor v, Direction d) {
        // Tell the visitor about the room and its state
        v.tell("You are in the '"+name+"'.\n");
        v.tell(description);
        if (lightsOn) {
            v.tell("The lights are on.");
            System.out.println("");
        } else {
            v.tell("The lights are off.");
            System.out.println("");
        }
        v.tell("You have " + gold + " pieces of gold.");
        System.out.println("\n");

        hasLeft: while (true) {
            // Ask the visitor to make a choice
            char[] choices = {'1', '2', '3', '4', '5'};
            char choice = v.getChoice("What do you want to do?\n1. Turn on the lights\n2. Turn off the lights\n3. Take gold\n4. Give gold out\n5. Leave", choices);
            // Handle the visitor's choice
            switch (choice) {
                case '1':
                    if (lightsOn) {
                        v.tell("The lights are already on.");
                        break;
                    } else {
                        lightsOn = true;
                        v.tell("You turn on the lights. ");
                        System.out.println("");
                        System.out.println("Another prize is coming! Let's see if you accepting it.");
                        String[] prize = {"A book", "A pen", "A pencil", "A cup", "A bottle", "A key", "A phone", "A watch", "A bag", "A wallet"};
                        int random = new Random().nextInt(10);
                        Item newPrize = new Item(prize[random]);
                        System.out.println("You get " + newPrize.name + ".");
                        char chars2[] = {'1', '2'};
                        char choice2 = v.getChoice("Do you want to accept it?\n1. Yes\n2. No", chars2);
                        switch (choice2) {
                            case '1':
                                if (hasEqualItem(newPrize)) {
                                    System.out.println("You already have " + newPrize.name + ".");
                                    break;
                                } else if (hasIdenticalItem(newPrize)) {
                                    System.out.println("You already have " + newPrize.name + ".");
                                    break;
                                } else {
                                    v.giveItem(newPrize);
                                    break;
                                }
                            case '2':
                                System.out.println("You don't accept it.");
                                break;
                            
                            default :
                                System.out.println("No such choice!");
                                break;
                        }
                        break;
                    }
                case '2':
                    if (!lightsOn) {
                        v.tell("The lights are already off.");
                        break;
                    } else {
                        lightsOn = false;
                        v.tell("You turn off the lights. ");
                        break;
                    }
                case '3':
                    int numberOfRandomGold = new Random().nextInt(10);
                    int amount = v.takeGold(numberOfRandomGold);
                    if (amount > 0) {
                        gold += amount;
                        v.tell("You take " + amount + " pieces of gold.");
                        break;
                    } else {
                        v.tell("They don't have enough gold to take.");
                        break;
                    }
                case '4':
                    if (gold > 0) {
                        v.giveGold(gold);
                        v.tell("You give " + gold + " pieces of gold to the visitor.");
                        gold = 0;
                        break;
                    } else {
                        v.tell("You don't have any gold to give.");
                        break;
                    }
                case '5':
                    System.out.println("You leave the '"+name+"'");
                    break hasLeft;
                
                default :
                    System.out.println("No such choice!");
                    break;
            }
        }

        // Return the direction in which the visitor leaves
        return Direction.opposite(d);
    }

    // Method to validate string input
    public static String validateString() {
        String newVal;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                newVal = sc.nextLine();
                // If else statement to verify whether a string is empty or not
                // It will only accept the value greater than 0
                if (newVal.length() > 0) {
                    break;
                } else {
                    // If the input is not greater than 0, it will ask the user to reenter the input
                    System.out.println("Invalid input. Please reenter: ");
                }
            } catch (Exception e) {
                // If the input is not an integer, it will ask the user to reenter the input
                System.out.println("Invalid input. Please reenter: ");
                sc.nextLine();
            }
        }
        return newVal;
    }

    /*public static void main(String[] args) {
        Room_ec22801 room = new Room_ec22801();
        // Initialise few more neighbours' room

        while (true) {
            char[] choices = {'1', '2', '3', '4', '5'};
            char choice = room.getChoice("Where do you want to go?\n1. Go to the North\n2. Go to the East\n3. Go to the West\n4. Go to the South\n5. Exit", choices);
    
            switch (choice) {
                case '1':
                    // Put the room to the north here
                    room.visit(room, Direction.FROM_NORTH);
                    break;
                case '2':
                    // Put the room to the east here
                    room.visit(room, Direction.FROM_EAST);
                    break;
                case '3':
                    // Put the room to the west here
                    room.visit(room, Direction.FROM_WEST);
                    break;
                case '4':
                    // Put the room to the south here
                    room.visit(room, Direction.FROM_SOUTH);
                    break;
                case '5':
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default : 
                    System.out.println("No such choice!");
                    break;
            }
        }
    }*/

}
