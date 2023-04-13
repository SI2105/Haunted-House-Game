package OOP.ec22612.MP.contributions;

class Room_ec22934 extends Room{

  final Item LAMP = new Item("lamp");
  final Item JEWELLERY= new Item("jewellery box");
    
  public Direction visit (Visitor v, Direction d) {
      char [] choices={'1','2','3'};
      v.tell("you are in the bedroom, find the valuable lamp and jewellery box");
      
      char options = v.getChoice( "would you like to (1)look on the table or(2) in the closet, enter the corresponding number,but of course it will cost you so then (3) don't take any valuables",choices);
      
      if(options == 1){
          v.takeGold(2);
          v.giveItem(LAMP);
          v.tell("you've got the lamp but lost 2 gold pieces");
          d= Direction.TO_NORTH;
      }
      else if(options == 2){
          v.takeGold(3);
          v.giveItem(JEWELLERY);
          v.tell("you've got the jewellery box but lost 3 gold pieces");
          d = Direction.TO_WEST;
      }
      else{
          v.takeGold(1);
          v.giveItem(JEWELLERY);
          v.tell("I see you were too frightened, that'll cost you 1 gold piece, now leave where you came from");
          d = Direction.opposite(d);
          
      }
      
          
      return d;
      
  }
      
      
}