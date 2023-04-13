package OOP.ec22612.MP.contributions;

import java.util.Random;

// Do not put this in here - it is already part of the repo! 
//abstract class Room implements Visitable { }

public class Room_ec211045 extends Room{
    int Gold;

    public Room_ec211045() {
        this.Gold = 10;
    }

    public Direction visit (Visitor vis, Direction dir){
        vis.tell("Hey there, welcome to the spinning room!");
        Random ran = new Random();
        vis.tell("In front of you is a spinning wheel, the outcomes are:\n"+
        "1- 8 golds\n2- surprise item\n3- -4 golds\n4- 0 golds\n5- Riddle");
        char choice = vis.getChoice("Want to spin(s) or leave(l)?", new char[]{'s','l'});
        if (choice == 's'){
            vis.tell("The sppinning has begun.. cross your fingers!");
            int spinResult = ran.nextInt(5)+1;
            if (spinResult == 1){
                vis.tell("Congratulations you won 8 gold coins");
                vis.giveGold(8);
                Gold -= 8;
            } else if (spinResult == 2){
                vis.tell("Congratulations you won an enchanted axe");
                if (vis.hasEqualItem(new Item("enchanted axe"))){
                    vis.tell("Oops you already have this item, here's 3 gold coins instead");
                    vis.giveGold(3);
                    Gold -= 3;
                } else {
                    vis.giveItem(new Item("enchanted axe"));
                }              
            } else if (spinResult == 3){
                vis.tell("Haha you lost 4 gold coins! i'm getting richer thank you!");
                vis.takeGold(4);
                Gold += 4;
            } else if (spinResult == 4){
                vis.tell("It's a tie! that 'suits' you haha.");
            } else {
                char riddleChoice = vis.getChoice("Hmm you landed on a riddle, which number is closer to sqrt(122)?\n1-11\n2-11.5", new char[]{'1','2'});
                if (riddleChoice == '1'){
                    vis.tell("Congrats! you solved the riddle here's 2 gold coins");
                    vis.giveGold(2);
                    Gold -= 2;
                } else {
                    vis.tell("No luck i'll take 2 coins from you!");
                    vis.takeGold(2);
                    Gold += 2;
                }
            }
            return Direction.opposite(dir);
        } else {
            vis.tell("Well thank you for coming");
            return Direction.opposite(dir);
        }
    }
}
