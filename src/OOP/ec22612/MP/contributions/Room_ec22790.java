package OOP.ec22612.MP.contributions;

class Room_ec22790 extends Room {
    static final Item apple = new Item("Apple");
    static final Item book = new Item("Book");
    static final Item shield = new Item("Shield");
    static final Item coal = new Item("Coal");
    
    public Direction visit(Visitor visitor, Direction visitorDirection){
        char [] options = {'1', '2', '3', '4'};
        visitor.tell("Creature: Hello traveller, you looking lost here.");
        visitor.tell("Creature: This is my shop, but usually nobody comes around :( .");
        visitor.tell("Creature: I know you wanna get something from my store so I'm gonna give you 4 options.");
        
        char choice = visitor.getChoice("Select from the following(1-4) - 1. Book (2 gold) get at North | 2. Golden Apple (1 gold) get at South| 3. Choice from me(free) get at West| 4. Shield (3 gold) get at East", options);
        
        if (choice == '1') {
            visitor.takeGold(2);
            visitor.giveItem(book);
            visitorDirection = Direction.TO_NORTH;
            visitor.tell("Creature: Here's a book about the meaning of life hopefully you understand it.");
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
            visitor.takeGold(3);
            visitor.giveItem(shield);
            visitorDirection = Direction.TO_EAST;
            visitor.tell("Creature: This shield will protect you against any damage.");
        }
        
        else {
            visitor.tell("I don't know who you think you are talking to. This yellow items are now mine!");
            visitor.takeGold(5);
            visitorDirection = Direction.opposite(visitorDirection);
        }
        
        return visitorDirection;
        
            
    }
    
}
