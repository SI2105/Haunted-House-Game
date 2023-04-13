package OOP.ec22612.MP.contributions;

class Room_ec22664 extends Room{
    static final Item food = new Item("Food");
    static final Item coat = new Item("Coat");
    static final Item carKeys = new Item("Car Keys");
    
    public Direction visit(Visitor visitor, Direction direction){
      char[] yORn = {'y', 'n'};  
      char[] placesToLook = {'c', 'd', 'r'};
      boolean lookCupboard = false;
      boolean lookDesk = false;
      boolean lookRoom = false;
      boolean first = true;
        if(first == true){
            visitor.tell("Welcome to abandoned building 22664. There is glass covering the floor from the windows being shattered by the recent explosions.");
            visitor.tell("Apart from the glass the entrance room seems largely untouched since the evacuations.");
            char ans = visitor.getChoice("Where would you like to look first for items to take? In the cupboard(c), behind the reception desk(d) or in the room by the stairs(r)? (c/d/r)", placesToLook);
            if (ans == 'c'){
                searchCupboard(visitor);
                direction = Direction.TO_EAST;
                lookCupboard = true;
            }
            else if (ans == 'd'){
                searchDesk(visitor);
                direction = Direction.TO_NORTH;
                lookDesk = true;
            }
            else if (ans == 'r'){
                searchRoom(visitor, yORn);
                direction = Direction.TO_EAST;
                lookRoom = true;
            }
            else{
                visitor.tell("You have not inputed one of c/d/r. Please input one of the allowed values.");
            }
        }
        else if((lookCupboard == false && lookDesk == false)||(lookCupboard == false && lookRoom == false)||(lookRoom == false && lookDesk == false)){
                visitor.tell("You have entered the abandoned building 22664. Last time you missed out on valuable items lets see if you find them this time.");
                visitor.tell("As you are entering repeatedly you will have to pay. 1 piece of gold.");
                visitor.takeGold(1);
                visitor.tell("Other people have taken up refuge in this building. You will have to creep around them. They are sleeping around the desk you will be unable to go near that."); 
                char ans = visitor.getChoice("Where would you like to look for items to take? Maybe you want to try somewhere new. You can look in the cupboard(c) or in the room by the stairs(r)? (c/r)", placesToLook);
                if (ans == 'c'){
                    searchCupboard(visitor);
                    direction = Direction.TO_SOUTH;
                    lookCupboard = true;
                }
                else if (ans == 'r'){
                    searchRoom(visitor, yORn);
                    direction = Direction.TO_WEST;
                    lookRoom = true;
                }
                else{
                    visitor.tell("You have not inputed one of c/r. Please input one of the allowed values.");
                }
        }
        else{
            if(lookCupboard == true && lookDesk == true && lookRoom == true){
            visitor.tell("You have entered the abandoned building 22664. Beware of what is lurking in the shadows.");
            visitor.tell("Someone has already passed through here... There is nothing for you to find.");
            visitor.tell("As you are entering repeatedly you will have to pay. 3 piece of gold.");
            visitor.takeGold(3);
            }
        }
        visitor.tell("You are exciting the abandoned building 22664. Good luck with your search. Here is 3 gold for your survival.");
        visitor.giveGold(3);
        return direction;
    }
    
    public void searchCupboard(Visitor visitor){
        if(!visitor.hasIdenticalItem(coat)){
            visitor.tell("You've found a thick winter coat hung up on the door. This will be good for the winter weather.");
            visitor.tell("You manage to find 2 pieces of gold on the floor too.");
            visitor.giveGold(2);
            visitor.giveItem(coat);
        }
        else{
            visitor.tell("There were people hiding in the cupboard now you've lost 2 pieces of gold.");
            visitor.takeGold(2);
        }
    }
   
    public void searchDesk(Visitor visitor){
        if(!visitor.hasIdenticalItem(carKeys)){
            visitor.tell("You've found a set of car keys on the desk this will make travelling around a lot easier.");
            visitor.tell("They must belong to the car sat on the curb outside.");
            visitor.giveItem(carKeys);
        }
        else{
            visitor.tell("You couldn't find anything useful to take here.");
        }
    }
    
    public void searchRoom(Visitor visitor, char[] yORn){
        if(!visitor.hasIdenticalItem(food)){
            char choice = visitor.getChoice("You've uncovered a room full of food. Would you like to stock up? (y/n)", yORn);
            if(choice == 'y'){
                visitor.giveItem(food);
                visitor.tell("You have packed as much food as possible and have manage to find 2 pieces of gold on the floor too.");
                visitor.giveGold(2);
            }
            else{
                visitor.tell("You move on and leave the food.");
            }
        }
        else{
            visitor.tell("There was nothing to find here. Good Luck.");
        }
    }
}
