package HauntedHouseGame.contributions;

import java.util.Random;
import java.util.Scanner;

class Room_ec22703 extends Room {

    // list of items that can be given
    static final Item clothes = new Item("pile of clothes");

    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {

        boolean temp = true, cross = true;
        String temp_ans = "";
        int number1 = 0, number2 = 0;
        Random num = new Random();

        try (Scanner scan = new Scanner(System.in)) {
            visitor.tell("Hello, you are in room ec22703");
            visitor.tell("The room is in a mess, it is your job to TRY and clean it! (hopefully nothing BAD happens)");

            String descriptionOfChoices = "Here are your choices" + "\n a: pick up clothes" + "\n b: organise the desk"
                    + "\n c: charge phone" + "\n d: check temperature";
            char[] arrayOfPossibleChoices = { 'a', 'b', 'c', 'd' };

            char choice = visitor.getChoice(descriptionOfChoices, arrayOfPossibleChoices);

            if (choice == 'a') {
                visitor.tell("You have vision of the clothes...");
                visitor.tell("BOOOOM...you have teleported to the clothes");
                visitor.tell("now they are in your hand :D");
                visitor.giveItem(clothes);
                number1 = num.nextInt(10);
                number2 = num.nextInt(10);

                if (number1 == number2) { // this is for the randomisation of giving a cross to the lucky player
                    cross = true;
                }
                if (number1 != number2) {
                    cross = false;
                }
            }

            if (choice == 'b') {
                visitor.tell("You walk towards the desk");
                visitor.tell("You begin to start sorting and organising the desk to make it looks more clean");
                visitor.giveGold(2);
                visitor.tell("Heres a little something to say thank you");
            }

            if (choice == 'c') {
                visitor.tell("Great...you charged it but also walked through this pile of rubbish");
                visitor.takeGold(1);
                visitor.tell("someone or some thing has taken away some of your gold!");
            }

            // this is a horror game reference from phasmaphobia for context
            if (choice == 'd') {
                visitor.tell("You check the themometer and see...but its broken" + "\n do you feel hot or cold?");
                temp_ans = scan.nextLine();
            } else if (temp_ans.equalsIgnoreCase("hot")) {
                temp = true;
            } else if (temp_ans.equalsIgnoreCase("cold")) {
                temp = false;
            }

            if (temp) {
                visitor.tell("I guess there is no paranormal activity for now...");
            } else {
                visitor.tell("maybe leave right now");
            }

            if (visitor.hasIdenticalItem(clothes) || (visitor.hasEqualItem(clothes))) {
                visitor.giveGold(1);
            } else {
                visitor.takeGold(1);
            }

            if (cross) {
                visitor.tell(
                        "Somehow you managed to find a cross with holy water. You have infinite immunity to the devil.");
            } else {
                visitor.tell(
                        "unfortunatly your actions of cleaning have not changed the devils mind. Be wary of your future path...");
            }
        }
        return directionVistorArrivesFrom.opposite(directionVistorArrivesFrom);
    }
}
