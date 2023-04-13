package OOP.ec22612.MP.contributions;

import java.util.Random;
import java.util.Scanner;

class Room_ec22746 extends Room{
    
    Item rustedKey = new Item("Rusted Key");
    Item owlStatue = new Item("Golden Owl statue");
    boolean chestOpen = false;
    boolean doorway = false;
    
    public static boolean checkForNumbers(String word){
        char currentCharacter;
        int count = 0;
        boolean condition = false;
        boolean characterFound = false;
        
        while (condition == false) {
            currentCharacter = word.charAt(count);
            if (Character.isDigit(currentCharacter)) {
                characterFound = true;
                condition = true;
            } else if (count == word.length() - 1) {
                condition = true;
            } else {
                count++;
            }
        }
        return characterFound;
    }
    
    public char getChoice(String choice, char [] listOfOptions, Visitor v){
        Scanner reply = new Scanner(System.in);
        v.tell(choice);
        String option = reply.nextLine();
        
        while (option.length()>1){
            v.tell("[Please enter a single character from the list of options above:] ");
            option = reply.nextLine();
        }
        
        char chosenOption = option.charAt(0);
        boolean loop = true;
        
        while (loop == true){
            if (chosenOption == listOfOptions[0]){
                loop = false;
            }
            else if (chosenOption == listOfOptions[1]){
                loop = false;
            }
            else if (chosenOption == listOfOptions[2]){
                loop = false;
            }
            else if (chosenOption == listOfOptions[3]){
                loop = false;
            }
            else{
                v.tell("[Please enter from the list of options above:]");
                option = reply.nextLine();
                while (option.length()>1){
                    v.tell("[Please enter a single character from the list of options above:] ");
                    option = reply.nextLine();
                }
                chosenOption = option.charAt(0);
            }
        }
        return chosenOption;
    }
    
    public String YesOrNo(Visitor v){
        Scanner reply = new Scanner(System.in);
        String YorN = reply.nextLine();
        boolean loop = true;
        
        while (YorN.length()>1 || checkForNumbers(YorN) == true){
            v.tell("[Please enter either (y)es or (n)o:] ");
            YorN = reply.nextLine();
        }
        
        while (loop == true){
            if (YorN.equals("y")){
                loop = false;
            }
            else if (YorN.equals("n")){
                loop = false;
            }
            else{
                v.tell("[Enter y or n:]");
                YorN = reply.nextLine();
                while (YorN.length()>1 || checkForNumbers(YorN) == true){
                    v.tell("[Please enter either Y(Yes) or N(No):] ");
                    YorN = reply.nextLine();
                }
            }
        }
        return YorN;
    }
    
    public Direction visit(Visitor v, Direction d){
        v.tell("[You enter a room with an eerie atmosphere. Directly ahead of you in the middle of the room lies a wooden ornate chest that is " + (chestOpen ? "open" : "closed") + ", a worn , ruined cupboard to your right in the corner, and a faceless human statue immediately to your left wearing a satchel. The wall to your left appears to have a doorway " + (doorway ? "that is open.]" : "that is closed, seamlessly blending in with the wall. You can clearly see an outlign of one existing, as well as a small horizontal gap next to the outlign of the door, about as big as that of a coin. A rough engraving of the number 10 lies immediately above the gap.]"));
        char [] listOfDirections = {'n', 'e', 's', 'w'};
        char [] options = {'a', 'b', 'c', 'd'};
        for (int i=0; i<2; i++){
            char option = getChoice("[Would you like to: a) Check the chest, b) Check the cupboard, c) Check the mannequin, d) Check the outlined door to your left:] ", options, v);
            if (option == 'a'){
                if (chestOpen == true){
                    v.tell("[The chest appears to be empty...]");
                }
                else{
                    v.tell("[The chest appears to be locked. Do you attempt to open the chest? (y/n)]");
                    String open = YesOrNo(v);
                    if (open.equals("y")){
                        if (v.hasEqualItem(rustedKey) == true){
                            chestOpen = true;
                            v.tell("[You unlock the chest with the Rusted Key and you find before you a golden owl statue, with gleaming white pearl eyes. It appears to be in pristine condition.]");
                            v.giveItem(owlStatue);
                        }
                        else{
                            v.tell("[You do not have the key to open the chest]");
                        }
                    }
                }
            }
            else if (option == 'b'){
                int gold = (new Random()).nextInt(7);
                v.tell("[You notice a couple of rats scurrying out of a hole in the corner of the cupboard, carrying a foul stench along with them. You open the cupboard as cautiously as possible... and find " + gold + " gold coins!]");
                v.giveGold(gold);
            }
            else if (option == 'c'){
                v.tell("[You feel as though the statues's faceless face stares you down with every move you make, and as you rummage through the satchel, you find nothing of use, other than a note which reads 'Thank you...']");
                v.takeGold(4);
                v.tell("[Something has snatched out some coins from right under your nose...]");
            }
            else if (option == 'd'){
                if (doorway == true){
                    v.tell("[There is nothing of interest in this small little room, other than a few cobwebs here and there.]");
                }
                else{
                    v.tell("[You approach the outlined door, and you make the assumption that the slot requires 10 coins from you. Do you wish to test this theory out? (y/n)]");
                    String slot = YesOrNo(v);
                    if (slot.equals("y")){
                        v.takeGold(10);
                        v.tell("[The door opens itself, revealing before you a small room with a pedestal. Upon the pedestal lies a rusted key .]");
                        v.giveItem(rustedKey);
                        doorway = true;
                    }
                }
            }
        }
        char direction = getChoice("[Time is up! Where would you like to go? (n)orth, (e)ast, (s)outh or (w)est?] ", listOfDirections, v);
        if (direction == 'n'){
            return d.TO_NORTH;
        }
        else if (direction == 'e'){
            return d.TO_EAST;
        }
        else if (direction == 's'){
            return d.TO_SOUTH;
        }
        else if (direction == 'w'){
            return d.TO_WEST;
        }
        return d.UNDEFINED;
    }
}
