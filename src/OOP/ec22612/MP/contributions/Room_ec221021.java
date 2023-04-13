package OOP.ec22612.MP.contributions;

class Room_ec221021 extends Room{
    static final Item item = new Item("map");
    public Direction visit(Visitor V, Direction D)
    {

    // Returns direction the visitor leaves towards.
    boolean torch_state = false;
      V.tell("The room has different materials in different directions...");
           V.giveItem(item);
           char choices[] = {'y', 'n'};
          char choice = V.getChoice("Turn it on?", choices);

          if(choice == 'y'){ 
              torch_state = true;
          }
          else{           }
          
        char choice2 = V.getChoice("do you want gold?", choices);
        if(choice=='y'){
            V.giveGold(5);
        }
        else{ 
            V.takeGold(5);
            }

     


        return Direction.opposite(D);
    }
}
