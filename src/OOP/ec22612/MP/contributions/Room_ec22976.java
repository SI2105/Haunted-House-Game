package OOP.ec22612.MP.contributions;

class Room_ec22976 extends Room {
    public Direction visit (Visitor v, Direction d) {
        
        final Item goldenApple = new Item ("Golden Apple");
        final Item divineRapier = new Item ("Divine Rapier");
        final Item shamballaMap = new Item ("Shamballa Map");
        final Item magicMirror = new Item ("Magic Mirror");

        v.tell("Hello Player One, I hav surprise for you. Enter my house and you will get it depend on your direction.");

        char choice = v.getChoice ("So, which direction will you choose?", new char[]{'N', 'S', 'W', 'E'});

        if (choice == 'N' ){
            v.tell("You get Golden Apple");
            v.giveItem(goldenApple);
        }
        else if (choice == 'N'){
            v.tell("You get Divine Rapier");
            v.giveItem(divineRapier);
        }
        else if (choice == 'W'){
            v.tell("You get Shamballa Map");
            v.giveItem(shamballaMap);
        }
        else if (choice == 'E'){
            v.tell("You get Magic Mirror");
            v.giveItem(magicMirror);
        }
        else {
            v.tell("You're wrong");
            v.takeGold(10);
        }
        
        return Direction.opposite(d);
    }

}
