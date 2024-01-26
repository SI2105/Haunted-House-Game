package HauntedHouseGame.contributions;

import java.util.Random;
class Room_ec22496 extends Room {
    public Direction visit(Visitor visitor, Direction direction) {
        visitor.tell("hi you are in amys room now");
        visitor.tell("litch so scared that i cant even tell you whats going on omg we have 2 leave Rn");
        visitor.tell("where do you want to go now lol");
        char[] nesw = {'n','e','s','w'};
        char ans = ' ';    
        ans = visitor.getChoice("type n for north, s for south, e for east, or w for west", nesw);
        if (ans=='n') {
            giveortake(visitor);
            return Direction.TO_NORTH;
        }
        else if (ans=='s') {
            giveortake(visitor);
            return Direction.TO_SOUTH;
        }
        else if (ans=='e') {
            giveortake(visitor);
            return Direction.TO_EAST;
        }
        else if (ans=='w') {
            giveortake(visitor);
            return Direction.TO_WEST;
        }
        else {
            visitor.tell("fate has decided that you go from whence you came");
            giveortake(visitor);
            return Direction.opposite(direction);
        }
    }
    
    void giveortake (Visitor visitor) {
        Random r = new Random();
        int numberofcoins = r.nextInt(9)+2; // 9 = 0 to 8 , so +2 = 2 to 10
        visitor.tell("wowwww you just found " + numberofcoins + " coins on your way out.");
        visitor.tell("you can either a) keep the coins b) donate to the bnf or c) leave with nothing");
        char ans = ' ';
        char[] aorb = {'a','b','c'};
        ans = visitor.getChoice("type a or b or c", aorb);
        if (ans=='a') {
            visitor.tell("you have gained " +numberofcoins+ "coins.");
            visitor.giveGold(numberofcoins);
        }
        else if (ans=='b') {
            visitor.tell("thank you for your kind donation of "+numberofcoins+" coins.");
            visitor.takeGold(numberofcoins);
        }
        else {
            visitor.tell("why would you choose this lol peak still anyways u leave empty handed");
        }
        return; 
    }
}
