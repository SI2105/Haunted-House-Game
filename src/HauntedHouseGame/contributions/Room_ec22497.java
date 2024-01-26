package HauntedHouseGame.contributions;

import java.util.Random;
  
class Room_ec22497 extends Room {

    final static Item [] items = {new Item("Cobwebs"), new Item("Hammer"), new Item("Lighter"), new Item("Health Potion")};
    final int luckyPickCost = 5;
    static boolean visited = false;
    public Direction visit(Visitor visitor, Direction whereVisitorFrom) {
        if(!visited)
        {
            visitor.tell("Welcome to the mystery box room! The light is on and the walls are beautifully designed with golden layered wallpaper.");
            visitor.tell("You can open the box one time and get a mystery item. Open at your own risk!");
            char choice = visitor.getChoice("Would you like to... a. attempt the mystery box (cost 5 gold) or b. leave?",new char[]{'a', 'b'});

            if(choice == 'a') {
                visitor.tell("Welcome to the mystery box!");
                visitor.tell("It will cost " + luckyPickCost + ".");
                visitor.takeGold(luckyPickCost);

                Random r = new Random();
                int random = r.nextInt(items.length);
                Item luckyPick = items[random];

                visitor.giveItem(luckyPick);
                visitor.tell("You got a " + items[random] + "!");

                visitor.tell("Thank you for visiting!");
                visited = true;

                visitor.tell("You now leave the room where you came in from.");
                return Direction.opposite(whereVisitorFrom);
            }
            if(choice == 'b') { 
                return Direction.opposite(whereVisitorFrom);
            }
        }
        return Direction.opposite(whereVisitorFrom);
    }
    
}
