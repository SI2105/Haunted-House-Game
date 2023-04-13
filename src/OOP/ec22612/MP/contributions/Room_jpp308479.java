package OOP.ec22612.MP.contributions;

import java.util.Random;
class Room_jpp308479 extends Room {

private boolean lights_on;
private boolean trunk_emptied;
private boolean poltergeist_friendly;
public boolean Random(){
    Random r = new Random();
    int Al;
    int min=0;
    int max=1;


        Al=min+Math.abs(r.nextInt())%(max-min+1);
        if(Al==1){
           return true;
        }
        else{
            return false;
        }

}

Room_jpp308479()
{
    poltergeist_friendly=Random();
    lights_on=false;
    trunk_emptied=true;


}
static final Item MAP = new Item("Map");
static final Item MEGAKEY = new Item("Key");


     public Direction visit(Visitor v, Direction d) {
         v.tell("Welcome to Room_jpp308479");
         Direction new_direction;
         char[] choice = new char[]{'a', 'b', 'c' ,'d'};
         char[] choice1 = new char[]{'a', 'b'};
         v.tell("This room have 5 gold and item Key");
         if (d.equals(Direction.FROM_EAST)) {
             v.tell("You come from east");
             new_direction = Direction.TO_SOUTH;
         }
         else if (d.equals(Direction.FROM_SOUTH)) {
             v.tell("You come from South");
             new_direction = Direction.TO_NORTH;
         }
         else if (d.equals(Direction.FROM_NORTH)) {
             v.tell("You come from North");
             new_direction = Direction.TO_EAST;
             v.giveItem(MAP);
         }
         else if (d.equals(Direction.FROM_WEST)) {
             v.tell("You come from West ");
             v.giveItem(MEGAKEY);
             new_direction = Direction.TO_SOUTH;
         }
         else{
             new_direction= Direction.TO_NORTH;
         }

        v.tell("The room is very dark");
         
         char light = v.getChoice("Do you want to turn on the light? a-yes, b-no",choice1);
         switch (light){
             case'a':
                 v.tell("You turned on the light");
                 lights_on=true;
                 break;
             case'b':
                 v.tell("It's still dark in the room");
                 lights_on=false;
                 break;
             default:lights_on=false;

         }

         v.tell("Room have 3 different chests with gold");


         char selection = v.getChoice("Which chest you would like to open? chests a,b,c,d", choice);
         switch (selection) {
             case 'a':

                 v.tell("Yo found 1 gold!") ;
                 v.giveGold(1);
                 v.tell("This chest has extra gold for the visitors from the west");
                 if(v.hasIdenticalItem(MEGAKEY))
                 {
                     v.tell("You find extra gold !");
                     v.giveGold(4);
                 }
                 break;

         case 'b':
         if(!lights_on) {
             v.tell("You found 1 gold!");
             v.giveGold(1);
         }
         else{
             v.tell("You found 2 gold!");
             v.giveGold(2);
         }
         break;
         case 'c':
         v.tell("You found 5 gold!");
         v.giveGold(5);
         break;
             case 'd':
                 if(!poltergeist_friendly) {
                     v.tell("Angry poltergeist stole your gold");
                     v.tell("You lost 3 gold");
                     v.takeGold(3);
                 }
                 else {
                     v.tell("Friendly poltergeist give you 3 gold");
                     v.giveGold(3);
                 }
             default:
                 v.tell("Wrong choice");

     }
     v.tell("I hope you enjoy this room!!");
     return new_direction;
     }







        }
