package HauntedHouseGame.contributions;

class Room_ec22559 extends Room {
    public boolean lightOn = false;
    
    public Direction visit(Visitor v, Direction from){
        v.tell("Welcome to my gaming room!! Have 2 gold on me!");
        v.giveGold(2);
        v.tell("What would you like to do?");
        
        String options = "a) Play games on the epic PC, b) look at my bookshelf, c) sit on the bed, d) reorganise my room";
        char[] choices = {'a', 'b', 'c', 'd'};
        char choice = v.getChoice(options, choices);
        Item keyFob = new Item("Lamborghini Urus Keyfob");
        
        if(choice == 'a'){
            v.tell("You reached champion rank on rocket league. I hope you are proud of yourself!");
            v.takeGold(1);
        } else if (choice == 'b'){
            v.tell("A reader lives a thousand lives before he dies . . . The man who never reads lives only one. You earned 5 gold!");
            v.giveGold(5);
        } else if (choice == 'c'){
            v.tell("You fell asleep");
        } else if (choice == 'd'){
            lightOn = true;
            v.tell("You found my Lamborghini Urus Keyfob! Hope you like the car!");
            v.giveItem(keyFob);
        }
        
        char [] directions = {'n','e','s','w'};
        choice = v.getChoice("In which direction do you wish to go, choose 'n' for north, 'e' for east, 's' for south or 'w' for west.",directions);

         if (choice == 'n'){
             return Direction.TO_NORTH;
         }else if (choice == 'e'){
             return Direction.TO_EAST;
         }else if (choice == 's'){
             return Direction.TO_SOUTH;
         }else{
             return Direction.TO_WEST;
         }
    }
}
