package HauntedHouseGame.contributions;

import java.util.Random;
import java.util.Scanner;
class Room_ec22434 extends Room {
    static final Item JackOLantern = new Item("JackOLantern");
    static final Item Flashlight = new Item("Flashlight");

    boolean Visibility = false;
    boolean Haunted = false;

    public Direction visit(Visitor visitor, Direction direction){
        Scanner scanner = new Scanner(System.in);

        visitor.tell("You enter a house.");
        visitor.tell("After walking into the main hall, you find four paths");

        
        visitor.tell("You must now make your next move, where do you want to go");
        String DirectionChoice =("a)North, b)South, c)West, d)East");
        DirectionChoice = scanner.nextLine();

        if (DirectionChoice == "a"){
            direction = Direction.TO_NORTH;
            visitor.tell("Upon entering the room, you found 5 gold!");
            visitor.giveGold(5);
            Random r1 = new Random();
            Visibility = r1.nextBoolean();
            Random r2 = new Random();
            Haunted = r2.nextBoolean();
            if (Visibility == false){
                visitor.tell("The room is too dark to see, what should you do");
                visitor.tell("You use your flashlight.");
                visitor.tell("The room is illuminated.");
            }
            if (Haunted == true){
                visitor.tell("A ghost reveals itself to you, the room is haunted");
                visitor.tell("You use your Jack-O-Lantern.");
                visitor.tell("The ghost has been scared away, you are now safe.");
            }
        }
        if (DirectionChoice == "b"){
            direction = Direction.TO_SOUTH;
            visitor.tell("Upon entering the room, you dropped 3 gold!");
            visitor.takeGold(3);
            Random r1 = new Random();
            Visibility = r1.nextBoolean();
            Random r2 = new Random();
            Haunted = r2.nextBoolean();
            if (Visibility == false){
                visitor.tell("The room is too dark to see, what should you do");
                visitor.tell("You use your flashlight.");
                visitor.tell("The room is illuminated.");
            }
            if (Haunted == true){
                visitor.tell("A ghost reveals itself to you, the room is haunted");
                visitor.tell("You use your Jack-O-Lantern.");
                visitor.tell("The ghost has been scared away, you are now safe.");
            }
        }
        if (DirectionChoice == "c"){
            direction = Direction.TO_WEST;
            visitor.tell("Upon entering the room, you found 8 gold!");
            visitor.giveGold(8);
            Random r1 = new Random();
            Visibility = r1.nextBoolean();
            Random r2 = new Random();
            Haunted = r2.nextBoolean();
            if (Visibility == false){
                visitor.tell("The room is too dark to see, what should you do");
                visitor.tell("You use your flashlight.");
                visitor.tell("The room is illuminated.");
            }
            if (Haunted == true){
                visitor.tell("A ghost reveals itself to you, the room is haunted");
                visitor.tell("You use your Jack-O-Lantern.");
                visitor.tell("The ghost has been scared away, you are now safe.");
            }
        }
        if (DirectionChoice == "d"){
            direction = Direction.TO_EAST;
            visitor.tell("Upon entering the room, you dropped 4 gold!");
            visitor.takeGold(4);
            Random r1 = new Random();
            Visibility = r1.nextBoolean();
            Random r2 = new Random();
            Haunted = r2.nextBoolean();
            if (Visibility == false){
                visitor.tell("The room is too dark to see, what should you do");
                visitor.tell("You use your flashlight.");
                visitor.tell("The room is illuminated.");
            }
            if (Haunted == true){
                visitor.tell("A ghost reveals itself to you, the room is haunted");
                visitor.tell("You use your Jack-O-Lantern.");
                visitor.tell("The ghost has been scared away, you are now safe.");
            }
        }
        return Direction.opposite(direction);
    }
}
