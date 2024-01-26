package HauntedHouseGame.contributions;

import java.util.Scanner;

class Room_jpp319457 extends Room {
    
    public Direction visit(Visitor opponent, Direction from){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to go against the beast himself!!! y/n");
        char option = scanner.next().charAt(0);

        if (option == 'y')
        {
            System.out.println("LETSS GOO");
        }
        else if (option == 'n')
        {
            System.out.println("FUCK OFF");
        }
        else{
            System.out.println("Invalid option, YOU'RE BLOCKED");
        }

        return Direction.FROM_WEST;
        
    }
}
