package HauntedHouseGame.contributions;

class Room_ec22638 extends Room {
    public Direction visit(Visitor v,Direction d)
    {
      v.tell("welcome to the room.The state of the room is that the lights are switched off,there are stained and broken glasses with spider webs on it,the trunks are emptied and there are mouldings on the ceiling. There are four ways in which you can enter the room(North,South,East,West).");
      Direction enddirection=d.opposite(d);
      Item I1=new Item("Broom");
      Item I2=new Item("jewelery");
      Item I3=new Item("tape");
      Item I4=new Item("torch");
      char [] ar={'c','f'};
     
       v.tell("You have to clear the spiderwebs on the window.");
        if(v.giveItem(I1) && v.giveItem(I3))
          {
        v.tell("The items given to you are broom and tape");
         }
        else
          {
           System.out.println("item not accepted");
          }

        
 
             return Direction.opposite(d);
             }

 }
