package OOP.ec22612.MP.contributions;

import java.util.Scanner;

public class Room_ec22772 extends Room {
    
    final static Item onion = new Item("Onion");
    final static Item katana = new Item("Katana");
    boolean savedShrek = false;
    boolean cheffedUp = false;

    public String scanStr(String message) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(message);
            String answer = scanner.nextLine();

            return answer;
        }                          
    }

    // visit method
    public Direction visit(Visitor newVisitor, Direction visDirection) {

        final char[] yOrN = {'y', 'n'};

        if(visDirection.equals(Direction.FROM_NORTH)) {

            tell("Shrek: Welcome to Shrek's Swa...");
            tell("AAHHHHHHH!!!!");
            tell("Shrek: PLEASE HELP ME KIND PERSON I AM BEING ATTACKED BY ROADMEN IN MY OWN SWAMP!!!");
            tell("Shrek: IF ONLY YOU HAD SOMETHING TO FEND THEM OFF WITH!!!!");

            if(newVisitor.hasIdenticalItem(katana)) {

                char machChoice = newVisitor.getChoice("Will you use your katana: Y or N?", yOrN);

                if(charToLowStr(machChoice).equals("y")) {

                    tell("* You saved Shrek from the band of criminals that assaulted him excellence *");
                    savedShrek = true;
                    tell("Shrek: Thank you so much for that, buddy!");
                    tell("Shrek: Just for your corageous efforts today I want to give you a very special item!");
                    tell("Shrek: It is none other than my beloved onion, this item is a very magical force so use it wisely!");

                    newVisitor.giveItem(onion);

                    tell("Shrek: Alright, where were we... Ah yes, let me start over.");
                }
            }

            else {

                tell("* The masked assailants decapitate Shrek and toss his head into a giant leather bag *");
                tell("Scoundral 1: Hey! We have a witness!");
                tell("Scoundral 2: We can't let him get away, get him!");
                tell("* You get knocked out and when you awaken you notice all of your gold is missing *");
                cheffedUp = true;

                newVisitor.takeGold(Integer.MAX_VALUE);
            }
        }

        if(!cheffedUp) {
            tell("Shrek: Welcome to Shrek's Swamp!");
            tell("Shrek: Shrek is feeling extra nice today so he will give you a free 5 gold!");

            final String shrekGoldOffer = ("Shrek: Will you accept Shrek's offering? Y or N");

            char shrekGold = newVisitor.getChoice(shrekGoldOffer, yOrN);

            if(charToLowStr(shrekGold).equals("y")) {

                newVisitor.giveGold(5);
            }

            else {

                tell("Shrek: Well, that's a shame...");
                tell("* Shrek leaves you alone and you notice a brown wooden chest in the bushes next to his outpost *");

                char chestChoice = newVisitor.getChoice("Will you go to the chest before he realises? Y or N", yOrN);

                if(charToLowStr(chestChoice).equals("y")) {
                    tell("Well done, you have earned 50 gold.");
                    newVisitor.giveGold(50);
                }

                else {
                    tell("Shrek catches you salivating at his prized belongings and slaps you to Pluto.");
                    return Direction.TO_NORTH;
                }
            }
        }

        final String dirMessage = ("Choose a direction: W, A, S, D");
        final char[] dirArr = {'w', 'a', 's', 'd'};

        char directionChoice = newVisitor.getChoice(dirMessage, dirArr);
        Direction userDirChoice = directionToGo(directionChoice, visDirection);

        return userDirChoice;
    }

    public Direction directionToGo(char userChoice, Direction comingFrom) {

        switch(charToLowStr(userChoice)) {

            case("w"):
                return Direction.TO_NORTH;

            case("a"):
                return Direction.TO_WEST;

            case("s"):
                return Direction.TO_SOUTH;

            case("d"):
                return Direction.TO_EAST;

            default:
                return comingFrom;

        }
    }

    public String charToLowStr(char c) {

        return Character.toString(c).toLowerCase();
    }
    
    public void tell(String m) {
        System.out.println(m);
        try {
            Thread.sleep(1200);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
