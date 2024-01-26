package HauntedHouseGame.contributions;

import java.util.Random;

class Room_ec22743 extends Room {

    static final Item CANDLE = new Item("Candle");
    static final Item PAINTING = new Item("Old Painting");
    static final Item KNIFE = new Item("Knife");
    static final Item CHEST = new Item("Chest");
    static boolean junk=false;
    static boolean once=false;

    
    public Direction visit(Visitor v, Direction d) {
        v.tell("Welcome to my room ... You seem to notice that the room is quite dark. What do you wish to do first?");

        char[] options = {'a', 'b', 'c'}; //choices
        char choice = v.getChoice("Would you like to a) Try to find a source of light \n" + 
                                "b) Head straight ahead \n" +
                                "c) Move towards the edge", options);
        v.tell(" "); //for spacing in paragraphs
        
        switch(choice) {

            case 'a': //try find light source
                v.tell("You look in slightest source of light which is present at the corner of the room.");
                int chance;
                
                Random random = new Random();
                chance = random.nextInt(2); //5050 chance of encountering.

                if (chance==0) {
                    if (v.hasIdenticalItem(CANDLE)==false) {
                        v.tell("You managed to find a single lit candle. You pick it up and find a few coins of gold underneath.");
                        v.tell("You picked up the candle.");
                        v.giveItem(CANDLE);
                        v.giveGold(2);
                        v.tell("You managed to get 2 gold coins from picking up the candle!");
                        v.tell(" ");
                    }
                    else {
                        v.tell("You already have the candle!");  
                        v.tell(" ");
                    }
                }
                else {
                    if (junk==false){
                        v.tell("You managed to trip and get yourself covered in junk.");
                        v.tell("You lost 1 coin in the process.");
                        v.takeGold(1);
                        junk=true;
                        v.tell(" ");
                    }
                    else {
                        v.tell("You tripped enough already.");
                        v.tell(" ");
                    }
                }
                break;

            case 'b': //going straight ahead
                v.tell("You go straight ahead...");
                int chance2;

                Random random2 = new Random();
                chance2 = random2.nextInt(2); //5050 chance of encountering

                if (chance2==0) {
                    if (v.hasIdenticalItem(PAINTING)==false){
                        v.tell("You find an old painting of a pretty woman. You grab it.");
                        v.giveItem(PAINTING);
                        v.tell("The lady in the painting seems to have sensed you. She loves you!");
                        v.tell("You got 5 gold from the lady in the painting.");
                        v.giveGold(5);
                        v.tell(" ");
                    }
                    else if (once==false) {
                        if (v.hasIdenticalItem(KNIFE)==true){
                            v.tell("You use the knife to cut through the painting, you manage to find 10 gold!");
                            v.giveGold(10);
                            once=true;
                            v.tell(" ");
                        }
                    }
                    else {
                        v.tell("You have already explored this area.");
                        v.tell(" ");
                    }
                }
                    
                else {
                    if (v.hasIdenticalItem(KNIFE)==false) {
                        v.tell("You seem to have stepped on a knife! Be careful!!");
                        v.giveItem(KNIFE);
                        v.tell("Maybe you can use the knife somewhere...");
                        v.tell(" ");
                    }
                    else {
                        v.tell("You already have the knife! maybe you can do something with it...");
                        v.tell(" ");
                    }
                }
                break;

            case 'c': //sticking to edges
                v.tell("You stick to the edges of the room");
                int chance3;

                Random random3 = new Random();
                chance3 = random3.nextInt(5); //1/5 chance of encountering

                if (chance3==0) {
                    if (v.hasIdenticalItem(CHEST)==false) {
                        v.tell("Wow! This is a rare chance but you seemed to have found a chest whilst sticking to the sides!");
                        v.giveItem(CHEST);
                        v.giveGold(10);
                        v.tell("You managed to find 10 gold in the chest!");
                        v.tell(" ");
                    }
                    else {
                        v.tell("You already found the chest!");
                        v.tell(" ");
                    }
                }
                else {
                    v.tell("Nothing here, maybe try searching properly again...");
                    v.tell(" ");
                }
                break;
        }
        return d;

    }
}
