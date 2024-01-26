package HauntedHouseGame.contributions;

import java.util.Scanner;

class Room_cb21793 extends Room
{

Item item = new Item("water");

public Direction visit(Visitor v,Direction d)
{// This method is called when the player enters the room.
    System.out.println("You are in a room with a door to the north and a door to the east.");
    System.out.println("There is a bucket of water in the room.");
    System.out.println("What do you want to do?");
    System.out.println("1. Go north");
    System.out.println("2. Go east");
    System.out.println("3. Pick up the bucket");
    System.out.println("4. Quit");
    System.out.print("Enter your choice: ");
    Scanner scanner = new Scanner(System.in);
    int choice = scanner.nextInt();

    if (choice == 1)
{
    v.tell("You go north and find a bed.");   
}
    else if (choice == 2)
{
    v.tell("You go east and find a door.");
}
    else if (choice == 3)
{
            if (v.hasIdenticalItem(item))
{
                System.out.println("You already have the bucket.");
}
            else
{
                System.out.println("You pick up the bucket.");
                v.giveItem(item);
}
}
    else if (choice == 4)
{
            System.out.println("Thanks for playing!");
            System.exit(0);
}
    else
{
            System.out.println("Invalid choice.");
}
    return d;
}
}
