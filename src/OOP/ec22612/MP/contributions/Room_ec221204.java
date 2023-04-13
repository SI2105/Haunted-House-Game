package OOP.ec22612.MP.contributions;

class Room_ec221204 extends Room{
    public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom){
        visitor.tell("Hey, Stranger, you are in the Winchester gym and I am the Boss of The gym ");

        char choice = visitor.getChoice("Would you like to see if you can outwrestle the Boss of the Gym", new char[]{'y', 'n'});

        if(choice == 'y'){
            System.out.println("You lost, weakling");

        }

        else if(choice == 'n'){
            System.out.println("Hoi Hoi Hoi, My name is Vansama, I am a 4 time Boss of The Gym");
        }

        visitor.tell("get Some gold, Stranger");
        visitor.giveGold(3);
        
        visitor.tell("Nope, I changed my mind, no gold for you");
        visitor.takeGold(3);

        return Direction.TO_NORTH;





    }
}
