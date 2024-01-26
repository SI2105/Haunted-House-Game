package HauntedHouseGame.contributions;

class Room_ec22973 extends Room{

      private Item Chest= new Item("Chest");
      private Item Sword= new Item("Sword");
      private Item Shield= new Item("Shield");
      private int Gold= 40;

      public Direction visit(Visitor visitor, Direction directionFrom)
      {
        visitor.tell("Greetings! Welcome to my room. You will need to choose 1 from 3 options to survive out there. Choose wisely!");


          String Question= "Do you want a) Open a chest that it inside is uncertain. b) Grab a sword and shield to protect yourself. or c) Have some gold to sustain your survival.";
          char options[] = {'a', 'b', 'c'};
          char choice = visitor.getChoice(Question, options);

        if(choice == 'a')
        {
          visitor.giveItem(Chest);
        }

        else if(choice == 'b')
        {
          visitor.giveItem(Sword);
          visitor.giveItem(Shield);
        }

        else if(choice == 'c')
        {
          Gold += visitor.takeGold(10);
        }
        return directionFrom;
      }
}

