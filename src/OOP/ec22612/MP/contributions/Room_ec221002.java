package OOP.ec22612.MP.contributions;

class Room_ec221002 extends Room {
    
    public Direction visit(Visitor visitor, Direction direction){
        String arrivfrom = "start";
        String leavingto = "end";
        
        Direction leavingDirection = direction.opposite(direction);
        if(leavingDirection == Direction.FROM_EAST){
            leavingto="East";
        }
        else if(leavingDirection == Direction.FROM_NORTH) {
            leavingto="North";
        }
        
        else if(leavingDirection == Direction.FROM_SOUTH) {
            leavingto= "South";
        }
        
        else if(leavingDirection == Direction.FROM_WEST) {
            leavingto = "West";
        }

        
        if(direction == Direction.FROM_EAST) {
            arrivfrom="East";
        }
        else if(direction == Direction.FROM_NORTH) {
            arrivfrom="North";
        }
        
        else if(direction == Direction.FROM_SOUTH) {
            arrivfrom= "South";
        }
        
        else if(direction == Direction.FROM_WEST) {
            arrivfrom = "West";
        }
        visitor.tell("you are stuck in this lab full of chemicals which will dissolve you soon");
        visitor.tell("get your self gold that help you break the lock ");
        visitor.tell("to break the lock you need 10gold, you currently have 5  ");
        
        
        
        
        visitor.tell("You arrived in  walter's lab from " + arrivfrom);

        visitor.tell("O) open ");
        visitor.tell("B) Break");
        visitor.tell("G) Get");
        visitor.tell("U) use");
        
        char [] answer = {'y', 'n'};
        char  [] choices  = {'O' , 'B' , 'G', 'U'};
        char input = visitor.getChoice("You can choose between ", choices);
         if (input=='O') {
                visitor.tell("You look around the room and find a key! then only you can leave");
                 char input2 = visitor.getChoice("do you want to get a key first Yes/No ?", answer);
                 if(input2== 'y'){
                     visitor.tell("key found! now you can proceed to exit ");
                     visitor.tell("door opened!!!!");
                     leavingDirection = direction.opposite(direction);
                     visitor.tell("Your leaving direction is " + leavingto);
             
                 }   else {
                     visitor.tell("not found you are now Trapped in walters lab and should die soon");
                 }
             
             
            } else if (input=='B') {
                visitor.tell("You tried to pick the lock, but it's too difficult.");
                 visitor.tell("You arrived in  walter's lab from " + arrivfrom);
             
                 
                 
            } else if (input=='G') {
               visitor.tell("key for door found!");
               visitor.tell("you ");
             leavingDirection = direction.opposite(direction);
                     visitor.tell("Your leaving direction is " + leavingto);
            
            } else if (input=='U') {
               visitor.tell("do you want to use your 5 golds and change room with no chemicals ");
                char input3 = visitor.getChoice("do you want to use your gold  Yes/No ?", answer);
                 if(input3== 'y'){
                     visitor.tell("done! now you can proceed to exit ");
                     visitor.tell("door opened!!!!");
                     leavingDirection = direction.opposite(direction);
                     visitor.tell("Your leaving direction is " + leavingto);
                 } else {
                     visitor.tell("not found you are now Trapped in walters lab and should die soon");
                 } 
             
             
            } else {
                visitor.tell("Invalid choice. sorry death is the only exit now.");
             
            }
        

        return leavingDirection;
    }
  
}
