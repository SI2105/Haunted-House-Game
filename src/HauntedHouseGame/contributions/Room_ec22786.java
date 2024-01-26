package HauntedHouseGame.contributions;

import java.util.Scanner;

public class Room_ec22786 extends Room {

    boolean LightsOn;
    int gold;
    boolean haveChest;
    int candle;
    int candle_in_bag;
    boolean candleOn = false;
    Item key;

 

    public static Scanner sc(){return new Scanner(System.in);}


    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        key = new Item("key");
        boolean in = true;
        visitor.tell("You have now entered a room");
        if(!LightsOn){
            visitor.tell("This is a dark room without any lights");
        }else{
            visitor.tell("This is a room with the lights on");
        }
        if (gold > 0){
            visitor.tell("There are "+gold+" peices of gold on the floor");
        }else{
            visitor.tell("This is a room without any gold");
        }

        if(candle >0){
            visitor.tell("there is/are "+candle+" candle(s) on the table");
        }else{
            visitor.tell("there is no candle on the table");
        }

        String choice;
        char decision;
        if(!LightsOn) {
            choice = "What would you like to do ? (Blow or light the candle (c) , or pick up the gold (g) , " +
                    "or Open the chest if there is a chest (o)) or exit the room(e)";
            char[] options = {'c', 'g', 'o', 'e'};
            decision = visitor.getChoice(choice, options);
        }else{
            choice = "What would you like to do ? pick up the gold (g) if there are gold on the floor , " +
                "or Open the chest if there is a chest (o)) or exit the room(e)";
            char[] options = {'g', 'o', 'e'};
            decision = visitor.getChoice(choice, options);
        }
        while(in) {
            switch (decision) {
                case 'c':
                    System.out.println("would you like to blow (b) a candle or light (l) a candle");
                    char light = sc().nextLine().charAt(0);
                    if (candle_in_bag > 0 && light == 'l') {
                        visitor.tell("You have lighted a candle");
                        candle_in_bag -= 1;
                        candleOn = true;
                        break;
                    } else if (candle_in_bag > 0 && light == 'b' && !candleOn) {
                        visitor.tell("In order to blow a candle you should like a candle first");
                        break;
                    } else if (candle_in_bag > 0 && light == 'b') {
                        visitor.tell("You have blowed your candle");
                        candleOn = false;
                        break;
                    } else if (candle_in_bag == 0) {
                        visitor.tell("You dont have any candle in your bag.");
                        break;
                    }
                    break;

                case 'g':
                    if (gold > 0) {
                        int amount = Math.min(gold, 10);
                        int taken = visitor.takeGold(amount);
                        if (taken > 0) {
                            gold -= taken;
                            visitor.tell("You take " + taken + " pieces of gold.");
                        } else {
                            visitor.tell("You decide not to take any gold.");
                        }
                        break;
                    } else {
                        visitor.tell("There is no gold in the room.");
                        break;
                    }


                case 'o':
                    if (LightsOn) {
                        visitor.tell("You find a chest in the corner of the room.");
                        if (key != null && visitor.hasIdenticalItem(key)&& haveChest) {
                            visitor.tell("You use the key to unlock the chest.");
                            visitor.tell("You found a golden neckless");
                            visitor.giveItem(new Item("golden neckless"));
                            key = null;
                        } else {
                            visitor.tell("The chest is locked or there is no chest in the room");
                        }
                        break;
                    } else {
                        visitor.tell("You can't see anything in the dark.");
                        break;
                    }
                case 'e':
                    visitor.tell("You leave the room.");
                    
                    visitor.tell("which direction would you like to go?(n/e/s/w)");
                    char direc = sc().nextLine().charAt(0);
                    if (direc == 'n'){
                        return Direction.TO_NORTH;
                        
                    }else if(direc == 'e'){
                        return Direction.TO_EAST;
                    }else if (direc == 's'){
                        return Direction.TO_SOUTH;
                    }else if(direc == 'w'){
                        return Direction.TO_WEST;
                    }
                    in = false;


                default:
                    visitor.tell("That is not a valid choice.");

            }
        }
        //never be possible
        return null;


    }











}
