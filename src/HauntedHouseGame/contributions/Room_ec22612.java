package HauntedHouseGame.contributions;

class Room_ec22612 extends Room{
    
    boolean isLooted = false;
    
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom){

        
        Direction directionVisitorLeavesTo;
        
        if (isLooted == true){
            visitor.tell("This room has been looted");
        }
        
        else{
            
            visitor.tell("This room has not been looted, will you find treasure?");
            
        }
        char choice = visitor.getChoice("Pick where you want to go \n a)Archway b)The Dam c) Wizard Lair d) The Dungeon?",new char []{'a','b','c','d'});
        if (choice == 'a'){
            
            directionVisitorLeavesTo = Direction.TO_NORTH;
            visitor.tell("You Chose Archway");
            visitor.giveItem(new Item("Key"));
            if(isLooted == false){
                visitor.giveGold(2);
                isLooted = true;
            }
            
        }


        
        else if (choice == 'b'){
            
            directionVisitorLeavesTo = Direction.TO_SOUTH;
            visitor.tell("You Chose The Dam ");
            
            if(isLooted == false){
                visitor.giveGold(5);
                isLooted = true;
            }
            
            
        }
        
        else if (choice == 'c'){
            
            directionVisitorLeavesTo = Direction.TO_EAST;
            visitor.tell("You Chose Wizard Lair");
            visitor.giveItem(new Item("Wand"));
        }
        
        else if (choice == 'd'){
            
            directionVisitorLeavesTo = Direction.TO_WEST;
            visitor.tell("You Chose The Dungeon");
            visitor.takeGold(5);
            visitor.tell("Your GOLD HAS BEEN ROBBED.");
            
        }

        else {
            directionVisitorLeavesTo = Direction.opposite(directionVistorArrivesFrom);

        }

        
        return directionVisitorLeavesTo;
        
    }
}