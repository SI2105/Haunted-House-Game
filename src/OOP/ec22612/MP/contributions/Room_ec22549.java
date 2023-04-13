package OOP.ec22612.MP.contributions;

class Room_ec22549 extends Room {
    
    private boolean hasTorch = false;
    
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        Direction exitDirection = directionVistorArrivesFrom.opposite(directionVistorArrivesFrom);
        final String EXIT_MESSAGE = "You have now left ec22549's room!";
        
        visitor.tell("You are in ec22549's Dark Room.");
        visitor.tell("You have 3 options:");
        
        char[] options = {'a', 'b', 'c'};
        char optionChosen = visitor.getChoice("\na) Return where you came from.\nb) Run across the room into another room.\nc) Find a torch.", options);
        
        if (optionChosen == 'c') {
            findTorch(visitor);
            
            if (hasTorch) {
                dealWithGold(visitor);
            }
            
            exitDirection = dealWithExit(visitor, directionVistorArrivesFrom);
        }
        
        else if (optionChosen == 'b') {
            exitDirection = directionVistorArrivesFrom;
        }
        
        visitor.tell(EXIT_MESSAGE);
        return exitDirection;
    }
    
    void findTorch(Visitor visitor) {
        Item torch = new Item("Torch");
        if (visitor.giveItem(torch) == true) {
            visitor.tell("You have now acquired a torch! The room is not so dark anymore.");
            hasTorch = true;
        }
        
        return;
    }
    
    Direction dealWithExit(Visitor visitor, Direction directionVistorArrivesFrom) {
        visitor.tell("You now have only 2 options.");
        
        char[] options = {'a', 'b'};
        char optionChosen = visitor.getChoice("\na) Return where you came from.\nb) Run across the room into another room.", options);
        
        if (optionChosen == 'a') {
            return directionVistorArrivesFrom.opposite(directionVistorArrivesFrom);
        }
        
        return directionVistorArrivesFrom;
    }
    
    void dealWithGold(Visitor visitor) {
        visitor.tell("You see a shiny object on a table. Would you like to pick it up.");
        
        char[] options = {'a', 'b'};
        char optionChosen = visitor.getChoice("\na) Pick up shiny object.\nb) Leave the shiny object on the table.", options);
        
        if (optionChosen == 'a') {
            visitor.tell("You have now acquired 5 pieces of gold!");
            visitor.giveGold(5);
        }
        
        return;
    }
    
}