package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22452 extends Room {
    public Direction visit (Visitor v, Direction d_entered) {
        Item bullets = new Item("Bullets");
        Item gun = new Item("Gun");
        Item dirty_shoe = new Item("Dirty Shoe");
        
        if (d_entered == Direction.FROM_NORTH) {
            v.tell("Neato! You found 10 gold on your way here");
            v.giveGold(10);
        } else if (d_entered == Direction.FROM_EAST) {
            v.tell("Oh no! You tripped over a curb and lost 2 gold!");
            v.takeGold(2);
        } else if (d_entered == Direction.FROM_SOUTH) {
            v.tell("You stepped on poo");
            v.tell("sucks to be u lmao");
            v.giveItem(dirty_shoe);
        } else {
            v.tell("Sepehr Shamloo blinds you with his Amogus gif and steals 10 gold!");
            v.takeGold(10);
        }
        
        v.tell("This room is stocked to the brink with weapons and ammunition. Smells like gunpowder and corroded metal.");
        char choice = v.getChoice("(a) Stock up on ammunition | (b) Take a gun", new char[]{'a', 'b'});
        
        if (choice == 'a') {
            v.giveItem(bullets);
            v.tell("You received 100 bullets.");
        } else if (choice == 'b') {
            v.giveItem(gun);
            v.tell("You received 1 gun.");
        } else {
            v.tell("Invalid choice - now you get nothing! Maybe some better decision making next time? Bozo.");
        }
        
        choice = v.getChoice("(N) Go North | (E) Go East | (S) Go South | (W) Go West", new char[]{'N', 'E', 'S', 'W'});
        if (choice == 'N') {
            v.tell("To the shadow realm Jimbo!");
            return Direction.TO_NORTH;
        } else if (choice == 'E') {
            v.tell("To the shadow realm Jimbo!");
            return Direction.TO_EAST;
        } else if (choice == 'S') {
            v.tell("To the shadow realm Jimbo!");
            return Direction.TO_SOUTH;
        } else if (choice == 'W') {
            v.tell("To the shadow realm Jimbo!");
            return Direction.TO_WEST;
        } else {
            v.tell("Huh? No idea what that means bruv, but to the shadow realm you go!");
        }
        Direction[] directions = {Direction.TO_NORTH, Direction.TO_EAST,  Direction.TO_SOUTH, Direction.TO_WEST};
        Random rand = new Random();
        int random_int = rand.nextInt(3);
        
        return directions[random_int];
    }
    public static void main(String[] args) {    
    }
}