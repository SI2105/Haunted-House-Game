package HauntedHouseGame.contributions;

class Room_ec22649 extends Room {
    
    public boolean lightOn = false;
    
    public Direction visit(Visitor v, Direction from){
        v.tell("Welcome to the Hidden Room. As a little treat for discovering this location, take 3 gold coins.");
        v.giveGold(3);
        v.tell("What would you like to do?");
        
        String options = "a) Open the chest b) Look around c) Sleep, d) Tidy up my bed";
        char[] choices = {'a', 'b', 'c', 'd'};
        Item limitedPlush = new Item("Limited Edition Plushie");
        
        if(v.getChoice(options, choices) == 'a'){
            v.tell("You've opened a chest but unfortunately it had barely anything in it.");
            v.giveGold(2);
        } else if (v.getChoice(options, choices) == 'b'){
            v.tell("There's really nothing to see apart from the 4 white walls, the ceiling and the floor. But there is a bed.");
            v.giveGold(5);
        } else if (v.getChoice(options, choices) == 'c'){
            v.tell("You've taken a nap in a strangers room. How brave.");
        } else if (v.getChoice(options, choices) == 'd'){
            lightOn = true;
            v.tell("They will surely be grateful you are willing to clean for them. You stumbled upon their Limited Edition plushie and decided to take it for yourself!");
            v.giveItem(limitedPlush);
        }
        char [] directions = {'n','e','s','w'};
        char choice = v.getChoice("Since you are done with this room, which direction do you wish to go next? (choose 'n' for north, 'e' for east etc.)",directions);

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
