package OOP.ec22612.MP.contributions;

class Room_ec22712 extends Room{

  Item magic = new Item("Magic Wand");
  Item light = new Item("Flash Light");
    
  public Direction visit(Visitor v, Direction d){

    char[] arrayOfPossibleChoices = {'a', 'b'};
    v.tell("Welcome to the haunted house. Strange things happen here");
    char x = v.getChoice("You can either.../n a) open the door/n b) go upstairs", arrayOfPossibleChoices);


    if (x == 'a'){


      v.giveItem(magic);
      v.giveGold(8);

      v.tell("The Magic Wand is in your hands");
      v.tell("You are in a room with many stories and horrors, there is no such thing as light in here, use the wand as a           guide");
        d = Direction.TO_SOUTH;
      
    }


    else if (x == 'b'){

      v.giveItem(light);
      v.giveGold(4);

      v.tell("Ooooo A flash light, you can see where you are going");
      v.tell("But where are you going?");
      v.tell("There are many floors, maybe more than you can count...");
      d = Direction.TO_EAST;

    }


    else{
        
      v.takeGold(5);
      d = Direction.opposite(d);
        
    }
      
      return d;
      

  }
}
