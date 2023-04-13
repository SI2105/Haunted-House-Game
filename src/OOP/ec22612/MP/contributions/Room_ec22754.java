package OOP.ec22612.MP.contributions;

class Room_ec22754 extends Room {
static final Item MACGUFFIN = new Item("Torch");

    // Returns direction the visitor leaves towards.
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
    boolean torch_state = false;
      visitor.tell("The room has different materials in different directions...");
           visitor.giveItem(MACGUFFIN);
           char choices[] = {'y', 'n'};
          char choice = visitor.getChoice("Turn it on?", choices);

          if(choice == 'y'){  torch_state = true;}
          else{           }
          
        char choice2 = visitor.getChoice("do you want gold?", choices);
        if(choice=='y'){visitor.giveGold(5);}
        else{ visitor.takeGold(5);}

     


        return Direction.opposite(directionVistorArrivesFrom);
    }
}
