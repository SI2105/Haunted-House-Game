package HauntedHouseGame.contributions;

class Room_ec22828 extends Room{
    

    public Direction visit(Visitor v, Direction d){
  
        //this is used becuase people may have differnet house placement
         if (d == Direction.FROM_NORTH) {
            v.tell("You have arrived from the North Entrance.");
        }else if (d == Direction.FROM_EAST) {
            v.tell("You have arrived from the East Entrance.");
        }else if (d == Direction.FROM_SOUTH) {
            v.tell("You have arrived from the South Entrance.");
        }else if (d == Direction.FROM_WEST) {
            v.tell("You have arrived from the West Entrance.");
        }else{
            v.tell("You have teleported inside the house.");
        }
        
        
        
        Item key = new Item("key");  //item created for room
        boolean holdsKey = false;
        
        
        char[] choices = {'a', 'b', 'c'};
        char[] chestChoices = {'y', 'n'};
        char[] roomChoices = {'a', 'b'};
        char choice = v.getChoice("You enter tbe room, There are some gold pieces and a key on a desk. 'a, to take gold, 'b' to take key or 'c' to do nothing  " , choices);
        
        if (choice == 'a'){
                v.giveGold(10);
                v.tell("You get 10 gold peices!");
        }
                
            else if(choice == 'b'){
                holdsKey = v.giveItem(key);
                char choiceChest = v.getChoice("You picked the key, a chest appears. would you like to open? (y/n)", chestChoices);
                
                if (choiceChest == 'y'){v.giveGold(20); v.tell("You recieved 20 gold pieces!");} 
                else{v.tell("The chest disappears!");} 
            }
                
            else{
                v.tell("The gold and key disapear!");
            }
        
        
                char roomChoice = v.getChoice("Would you like to leave the room (press a)? or look at a beautiful painting (press b)?", roomChoices); 
        while (roomChoice != 'a'){
         v.tell("Wow, this is a beautiful painting!");
            roomChoice = v.getChoice("Leave or stay to look at painting? (a or b)", roomChoices);
            
        }
        return d;
    }

}
