package HauntedHouseGame.contributions;

class Room_ec22825 extends Room{
    
      // Boolean statements determine the state of the objects in the room ( in this case, affirming the title of the boolean)
       private boolean lightsOn = true;
       private boolean roomClean = true;
       private boolean windowsOpen = true;
       private Item torch = new Item("torch");
       private int Gold = 10;


        public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom)
        {
            visitor.tell("The State of My Room is \n lights on: " + lightsOn + " \n room clean: " + roomClean + " \n windows open: " + windowsOpen);
            
            if(!visitor.hasIdenticalItem(torch))
            {
                visitor.giveItem(torch);
                Gold += visitor.takeGold(3);  //Giving the user 3 Gold coins if they have the same item
            }
            
            String options = "Do you want to: a)Keep the lights on  b)Turn of the lights";
            char opt[] = {'a' , 'b'};
            char choice = visitor.getChoice(options , opt);
            switch (choice)
            {
                case 'a': lightsOn = true;
                break;
                
                case 'b': lightsOn = false;
                break; 
            }
           return Direction.opposite(directionVisitorArrivesFrom);  //returning the opposite direction the user has come from
        }
    }
