package HauntedHouseGame.contributions;

class Room_ec22975 extends Room {
static final Item MCGUFFIN = new Item("Light");

    // Returns direction the visitor leaves towards.
    public Direction visit(Visitor visitor, Direction directionvistorarrivesfrom) {
    boolean Light_state = false;
      visitor.tell("The room has different materials in different directions...");
           visitor.giveItem(MCGUFFIN);
           char choiceyn[] = {'y', 'n'};
          char choice = visitor.getChoice("Turn it on?", choiceyn);

          if(choice == 'y'){  Light_state = true;}
          else{}

        char choice2 = visitor.getChoice("do you want gold?", choiceyn);
        if(choice=='y'){visitor.giveGold(1);}
        else{}




        return Direction.opposite(directionvistorarrivesfrom);
    }
}
