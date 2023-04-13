package OOP.ec22612.MP.contributions;

import java.util.Random;

public class Room_jpp301711 extends Room{
    int roomGold;

    public Room_jpp301711() {
        this.roomGold = 10;
    }

    public Direction visit (Visitor V, Direction D){
        V.tell("Welcome to the portals room!");
        Random ran = new Random();
        V.tell("In front of you are 5 portals, one takes you out of the room" +
         " with 5 gold coins, and the remaining other portals takes you back inside this room"+ 
         " it takes one golden coin to play, oh! each time you play the winning portal is changed, choose carefully!");
        char choice = V.getChoice("Want to play?", new char[]{'y','n'});
        while (choice == 'y'){
            int winningPortal = ran.nextInt(5)+1;
            int paid = V.takeGold(1);
            roomGold += 1;
            if (paid < 0){
                V.tell("You do not have enough coins!");
                return Direction.opposite(D);
            } else {
                char chosenPortal = V.getChoice("Choose a portal", new char[]{'1','2','3','4','5'});
                int numchosenPortal = Character.getNumericValue(chosenPortal);
                if (numchosenPortal != winningPortal){
                    choice = V.getChoice("You lost. Wanna play again?", new char[]{'y','n'});
                } else {
                    V.giveGold(5);
                    roomGold -= 5;
                    V.tell("Congratulations you won!");
                    return Direction.opposite(D);
                }
            }
        }
        return Direction.opposite(D);
    }
}
