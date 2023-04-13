package OOP.ec22612.MP.contributions;

class Room_ec22945 extends Room{
//private Direction d;
static final Item knife = new Item("knife");
static final Item silver = new Item("silver");    

public Direction visit(Visitor vis, Direction dir){
    vis.tell("Welcome to Mateusz's scary room!");
    char[] choices = {'N','S','W','E'};
    char userchoice =vis.getChoice(("Select the direction you are about to follow! (N for north, S for south, W for west, E for east!"), choices);
    if (userchoice == 'N'){
          vis.tell("You have managed to turn the lights on, quest completed!");
          vis.giveGold(3);
          dir = Direction.TO_NORTH;
    }
        
        
    else if(userchoice == 'S'){
            vis.tell("A strange man forces you to buy a knife for 1 gold, he claims it's for protection.");
            vis.giveItem(knife);
            vis.tell("You now have the knife on you!");
            vis.takeGold(1);
            dir = Direction.TO_SOUTH;
        }
    
    
     else if(userchoice == 'W') {
            vis.tell("You stumble upon a chest!");
            vis.tell("Opening the chest.....");
            vis.tell("Well done, you find 5 gold!");
            vis.giveGold(5);
            dir = Direction.TO_WEST;
        }
            
    
    else if(userchoice == 'E'){
            vis.tell("You find pure silver");
            vis.tell("You manage to trade it for another 2 gold!");
            vis.giveGold(2);
            dir = Direction.TO_EAST;
       }
    
    else
    {
    }
      return dir;
    }
}
