package OOP.ec22612.MP.contributions;

import java.util.Scanner;

abstract public class Room_ec221166 extends Room {

    public String scanStr(String message) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(message);
            String answer = scanner.nextLine();

            return answer;
        }                          

    }

    public Direction visit(Visitor v, Direction direction) {

        String directionChoice = scanStr("Choose a direction: W, A, S, D");

        switch(directionChoice.toLowerCase()) {

            case("w"):
                return Direction.TO_NORTH;

            case("a"):
                return Direction.TO_WEST;

            case("s"):
                return Direction.TO_SOUTH;

            case("d"):
                return Direction.TO_EAST;

            default:
            return direction;

        }

    }
}
