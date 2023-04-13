package OOP.ec22612.MP.contributions;

class Room_ec22981 extends Room {
     public final Item pickaxe = new Item("pickaxe");



          public final Item candle = new Item("candle");



          public final Item picture = new Item("picture");
      public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom){
          char choice = 'a';
         if(visitor.hasEqualItem(pickaxe)) {



             visitor.giveGold(10);



             visitor.tell("You've gained gold!");


             choice = visitor.getChoice("Choices for leaving the room", new char []{'s', 'w'});


             


             if(choice=='s') {


                 return Direction.TO_SOUTH;


             }


             else {


                 return Direction.TO_WEST;    


             }


         }


         else if(visitor.hasEqualItem(candle)){


             visitor.takeGold(3);


             visitor.tell("You've lost 3 gold!");


             choice = visitor.getChoice("Choices for leaving the room", new char []{'e', 'n'});


             


             if(choice=='e') {


                 return Direction.TO_EAST;



             }



             else {



                 return Direction.TO_NORTH;    



             }
         }


          else {


              choice = visitor.getChoice("Do you want to go to the next room?Choose - s(south), w(west), n(north) or e(east)", new char[]{'s', 'e', 'n', 'w'});



              visitor.tell("This room you got a picture, which you can use to see how to exit the house?");



              visitor.tell("Picture says that you should choose wisely!!!(It's a trick)");



              if(choice=='s') {



                  return Direction.TO_NORTH;



              }



              else if(choice=='w') {



                  return Direction.TO_EAST;    



              }



              else if(choice=='e') {
                  return Direction.TO_WEST;    
              }
              else if(choice=='n') {

                  return Direction.TO_SOUTH;    

              }



              else if(visitor.hasEqualItem(picture)) {
                  return Direction.opposite(directionVistorArrivesFrom);
              }

              else {
                   visitor.tell("You did not choose wisley, you are going in the direction you came from!");

                   return Direction.opposite(directionVistorArrivesFrom);
              }
          }
      }
 }
