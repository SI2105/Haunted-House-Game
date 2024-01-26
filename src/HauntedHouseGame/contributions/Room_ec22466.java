package HauntedHouseGame.contributions;

class Room_ec22466 extends Room {
    static final Item apple = new Item("Apple");
    static final Item map = new Item("Map");
    static final Item coal = new Item("Coal");
 
  public Direction visit(Visitor visitor, Direction visitorDirection){
        char [] options = {'1', '2', '3', '4'};
        visitor.tell("Creature: Hello traveller, you looking lost here.");
        visitor.tell("Creature: This is my shop, but usually nobody comes around :( .");
        visitor.tell("Creature: I know you wanna get something from my store so I'm gonna give you 4 options.");

        char choice = visitor.getChoice("Select from the following(1-4) - 1.Take a map of the forest (2 gold)| 2. Golden Apple (1 gold) get at South| 3. Choice from me(free) get at West| 4. Sell me your coat, it's freezing!", options);

        if (choice == '1') {
            visitor.takeGold(2);
            visitor.giveItem(map);
            visitor.tell("Creature: Here is a map of the forest, use it to navigate yourself around the forest");
        }

        else if (choice == '2') {
            visitor.takeGold(1);
            visitor.giveItem(apple);
            visitorDirection = Direction.TO_SOUTH;
            visitor.tell("Creature: This apple will heal you if your critical moments.");
        }

        else if (choice == '3') {
            visitor.giveItem(coal);
            visitorDirection = Direction.TO_WEST;
            visitor.tell("Creature: Sorry someone told you weren't good this year. You deserve the coal");
        }

        else if (choice == '4') {
            visitor.tell("Thanks for the jacket, this should keep me warm in the cold, take 6 pieces of gold");
            visitor.giveGold(6);
        }

        else {
            visitor.tell("Are you trying to steal from my shop, okay now I will steal from you!");
            visitor.takeGold(3);
            visitorDirection = Direction.opposite(visitorDirection);
        }

        return visitorDirection;


    }

}
