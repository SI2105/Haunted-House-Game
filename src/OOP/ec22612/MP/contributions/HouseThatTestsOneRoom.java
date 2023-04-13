package OOP.ec22612.MP.contributions;

import java.util.Random;
import java.util.Scanner;

class HouseThatTestsOneRoom extends House {
    
    Visitable objectToVisit;
    String contributor;
    
    HouseThatTestsOneRoom(Room r, String c) { objectToVisit = r; contributor = c;}
    
    public Direction visit(Visitor v, Direction d) {
        
        v.tell("Test House: You have entered a Test House containing one Room contributed by " + 
               contributor+".");
        
        while(true) {
            switch (v.getChoice("Test House: Do you want to " +
                                "(l)eave the Test House or enter the Room from the " +
                                "(S)outh " +
                                "(W)est " +
                                "(N)orth or " +
                                "(E)ast?",
                                new char[] {'l', 'L', 's', 'S', 'w', 'W', 'n', 'N', 'e', 'E', 'q'})) {
                case 'd': break; // Leave d as it is.
                case 's':
                case 'S': d = Direction.FROM_SOUTH; break;
                case 'w':
                case 'W': d = Direction.FROM_WEST; break;
                case 'n':
                case 'N': d = Direction.FROM_NORTH; break;
                case 'e':
                case 'E': d = Direction.FROM_EAST; break;
                case 'l':
              case 'L':
              case 'q': return d; // Return from visiting Test House.
                default: v.tell("This cannot happen - ring the Pope!");
            }
            objectToVisit.visit(v, d);
            v.tell("Test House: You just left the Room contributed by "+contributor+" "+d+".");
        } 
    }
    
    
    
    public static void main(String[] a) {
               
        Room r;
        String c;
        System.out.println("Creating Test House containing one Room.");
        
        System.out.println("Choose room at random or pick by username (r/u)?");
        if ((new Scanner(System.in)).nextLine().charAt(0)=='u') {
            System.out.print("Enter username of Room contributor: ");
            while(true) { 
                c = (new Scanner(System.in)).nextLine();
                r = Contributions.newRoomByUsername(c);
              if (r != null) break;
                System.out.print("Not recognised. Try again: ");
            }
        } else {
            String[] u = Contributions.getRoomUsernames();
            c = u[(new Random()).nextInt(u.length)];
            r = Contributions.newRoomByUsername(c);
        }
        
        House h = new HouseThatTestsOneRoom(r,c);
        Visitor v = new IOVisitor(System.out, System.in);
        h.visit(v, Direction.UNDEFINED);        
    }
}
                             