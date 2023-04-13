package OOP.ec22612.MP.contributions;

import java.util.Random;
import java.util.Scanner;

class Room_ec22819 extends Room {
    Scanner scanner = new Scanner(System.in);

    // Items
    static final Item muffin = new Item("Muffin");
    static final Item toiletpaper = new Item("toiletpaper");
    static final Item gold = new Item("gold");

    // Variables
    String message = "Choose your options (a ,b ,c ,d)";
    char[] arrayOfPossibleChoices = {'a' , 'b', 'c', 'd'};
    char choice;
    String y_n;
    Item[] visitorStuff = new Item[5];

    /*Direction */
    public Direction visit(Visitor v, Direction VisitorArrivesFrom) {
        int counter = 3;
        v.tell("Hi, you have visited my room, find as many golds as you like!");

        choice = v.getChoice(message, arrayOfPossibleChoices);
        ifChoice(choice, v);

        y_n = inputString("Do you want to continue? (y/n)");
        while (quitLoop(y_n, counter)) {
            choice = v.getChoice(message, arrayOfPossibleChoices);
            ifChoice(choice, v);
            counter--;
        }

        System.out.println("You have exited my room");
        return Direction.opposite(VisitorArrivesFrom);
    }

    /* gives options through input */
    public void ifChoice (char choice, Visitor v ) {
        if(choice == 'a') {
            v.tell("Wrong place my friend, with that I'll take your gold.");
            v.takeGold(1);
        }
    
        else if (choice == 'b') {
            v.tell("looks like youhave found something, a MUFFIN");
            v.giveItem(muffin);
        }
    
        else if (choice == 'c') {
            v.tell("Do you need to pee?");
            v.giveItem(toiletpaper);
        }
    
        else if (choice == 'd') {
            v.tell("You have found 10 pieces of gold !!");
            v.giveGold(10);
        }
    
        else {
            v.tell("please input the right options!");
        }
    }

    /* Quits Loop - when answer is no */
    public boolean quitLoop(String y_n, int counter) {
        if (counter == 0) {
            return false;
        }

        else if(y_n.equals("Yes") | y_n.equals("YES") | y_n.equals("y")) {
            return true;
        }

        else if(y_n.equals("No") | y_n.equals("No") | y_n.equals("n")) {
            return false;
        }

        else {
            System.out.println("Please enter (y/n)");
            return true;
        }
    }

    // Gives Random Character - for searching 
    public char giveRandomChar(char[] arrayOfPossibleChoices) {
        Random random = new Random();
        int random_index = random.nextInt(arrayOfPossibleChoices.length);

        return arrayOfPossibleChoices[random_index];
    }

    // Input String
    public String inputString(String m) {
        Scanner scanner = new Scanner(System.in);
        String answer;

        System.out.println(m);
        answer = scanner.nextLine();
        return answer;
    }
}
