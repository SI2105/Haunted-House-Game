package OOP.ec22612.MP.contributions;

class Room_ec22804 extends Room {

  static final Item MACGUFFIN = new Item("Key");
  static final Item Plant = new Item("Key");
  static final Item Seed = new Item("Key");
  static final Item Knife = new Item("Key");
    
  char option[]={'1','2'};
  boolean light=false;
  boolean jacket=false;
  
  public Direction visit (Visitor v, Direction d) {
      v.tell("Room entered! This room holds a variety of objects hidden in the dark.");
      Direction direction = Direction.opposite(d);
      v.tell("You have come from this direction: "+ d);

      if(! v.hasEqualItem(MACGUFFIN)){
          v.tell("Take Macguffin!");
          if (v.giveItem(MACGUFFIN)){
              v.tell("Mcguffin taken!");
          }
          else{
              v.tell("Mcguffin not accepted!");
          }
      }
      else{
          v.tell("Turn light on!");
          light=true;
      }
  
  
   
   if (v.hasIdenticalItem(MACGUFFIN)){
       v.tell("You have Macguffin");
       jacket=true;
       v.tell("Wear the jacket!");
   }
    else{
       v.tell("You don't have Macguffin");
       v.tell("Take the Knife!");
        v.tell("Take gold!");
      v.giveGold(10);
  
       if (v.giveItem(Knife)){
             v.tell("Knife taken!");
       }
        else{
             v.tell("Knife not accepted!");
        }
   
  }   
      
      char choice =v.getChoice("There is a plant and seeds in the room, would you like to take Option 1: Plant or Option 2: Seed?",option);
      if (choice=='1'){
      v.tell("Take the plant!");
          if (v.giveItem(Plant)){
              v.tell("Plant taken!");}
          else{
              v.tell("Plant not accepted!");
              
          }}
    
      else if (choice=='2'){
          v.tell("Take the Seed!");
          if (v.giveItem(Seed)){
              v.tell("Seed taken!");}
          else{
              v.tell("Seed not accepted!");
          
      }
    }
    return (direction);
  }
}