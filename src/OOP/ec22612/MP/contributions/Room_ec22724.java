package OOP.ec22612.MP.contributions;

import java.util.Scanner;

class Room_ec22724 extends Room{

    public static void main (String[] args){}

    public static String inputstring(String msg) {
        Scanner scanner = new Scanner(System.in);
        String response;
        response = scanner.nextLine();
        return response;

    }

    Item key = new Item("key");
    Item lock_pick = new Item("lock pick");
    Item singed_photo = new Item("burnt photograph");
    Item antique_letter = new Item("antique letter");
    Item lantern = new Item("unlit lantern");
    Item lit_lantern = new Item("lit lantern");
    char[] choices = {
        'a',
        'b',
        'c',
        'd'
    };
    char[] Y_N = {
        'Y',
        'N'
    };

    public Direction visit(Visitor visitors, Direction directions) {
        String choice;
        boolean lamp_lit = false;
        boolean lamp = false;
        boolean escape_key = false;
        visitors.tell("You've woken up in an unfamiliar location, from the looks of it the lights don't work. The exit behind you is locked... The corridor in front of you appears endless");
        visitors.tell("Upon further inspection you find an unlit lantern and a piece of gold on the floor.");
        visitors.tell("You pick up the ingot of gold");
        visitors.giveGold(1);
        choice = inputstring("Do you: \na) Light the lantern and take it \nb) Take the unlit lantern \nc) Light the lantern and leave it \nd) Leave the lantern");

        if (choice.equals("a")) {
            visitors.giveItem(lit_lantern);
            lamp_lit = true;
            visitors.tell("You've picked up the lit lantern.");
        } else if (choice.equals("b")) {
            visitors.giveItem(lantern);
            lamp = true;
            visitors.tell("You've picked up the lantern.");
        } else if (choice.equals("c")) {
            visitors.tell("You've chosen to light the lamp and leave it there...");
        } else {
            visitors.tell("You've chosen to ignore the lamp...");
        }
        int trys = 0;
        int max_trys = 5;

        while (!escape_key && trys < max_trys) {

            char a = visitors.getChoice("Do you: \n a) Investigate the drawer in the west room. \n b) Investigate the kitchen south of where you are. \n c) Investigate the master bedroom on the 2nd floor \n d) leave", choices);
            if (a == 'a') {
                visitors.tell("You've looked inside the drawer and you've found 2 pieces of gold!");
                visitors.giveGold(2);
            } else if (a == 'b') {
                visitors.tell("You've searched the kitchen, but you hear something scurrying around, it pounces at you stealing 1 piece of gold.");
                visitors.takeGold(1);
                visitors.tell("You chase it around and trip over something, upon closer inspection it seems to be a key. \nYoupick it up.");
                visitors.giveItem(key);
            } else if (a == 'c') {
                if (visitors.hasIdenticalItem(lit_lantern)) {
                    visitors.tell("With your lit up lantern you can see the master bedroom with ease and you find a lock pick there.");
                    visitors.giveItem(lock_pick);
                } else {
                    visitors.tell("You need a lit up lantern to explore here");
                }
            } else if (a == 'd') {
                visitors.tell("You attempt to leave the location");
                if (visitors.hasEqualItem(key)) {
                    visitors.tell("You have the key");
                    char response2 = visitors.getChoice("Do you want to leave the house? Y or N", Y_N);
                    if (response2 == 'Y') {
                        escape_key = true;
                    }
                } else if (visitors.hasEqualItem(lock_pick)) {
                    visitors.tell("You have the lock pick");
                    char response2 = visitors.getChoice("Do you want to leave the house? Y or N", Y_N);
                    if (response2 == 'Y') {
                        escape_key = true;
                    }
                }
            }
            trys++;
        }
        if (escape_key) {
            return directions.opposite(directions);
        }
         else {
            visitors.tell("you've failed to find and escape within " + max_trys + "trys, do better next time.");
            return directions;
        }


    }



}
