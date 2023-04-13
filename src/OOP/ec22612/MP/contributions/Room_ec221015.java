package OOP.ec22612.MP.contributions;

class Room_ec221015 extends Room {

    static final Item keys = new Item("keys");
    
    public Direction visit (Visitor v, Direction d) {
        
        String where = "";
        boolean lightsOn = false;
        boolean cabinetLocked = true;
        boolean survivorRescued = false;
        char[] choices = {'a','b'};
        char[] multipleChoices = {'a','b','c'};
        Direction exit = Direction.UNDEFINED;
        char choice = ' ';
        
        if (d == Direction.FROM_SOUTH){
            where = "Southern";
        } 
        else if (d == Direction.FROM_WEST){
            where = "Western";
        }
        else if (d == Direction.FROM_NORTH){
            where = "Northern";
        }
        else if (d == Direction.FROM_EAST){
            where = "Eastern";
        }
        
        if (d==Direction.FROM_NORTH) {
            v.tell("you scurry into the room slamming the door shut behind you!");
            v.tell("Unfortunately, you have just entered the haunted masterbedroom");
            v.tell("The lights begin to flicker ...");
        }
        
        else if (d==Direction.FROM_EAST) {
            v.tell("you enter the masterbedrooms ensuite.");
            v.tell("you begin to hear rapid breathing and strange noises...");
            v.tell("do you");
            choice = v.getChoice("a - explore the strange noises or b - run off in the opposite direction",choices);
            
            if (choice == 'a') {
                v.tell("you walk towards the mysterious sound coming from the corner of the room. Each step you take the noise becomes clearer and louder ...");
                v.tell("in the corner of the room was another visitor");
                v.tell("you form an alliance and build the courage to walk into the masterbedroom together.");
                survivorRescued = true;
            }
            
            else if (choice == 'b') {
                v.tell("you rush out of the bathroom, and hurry into the masterbedroom.");
                v.tell("thud, dink .. clank.");
                v.tell("with all that rushing, your bag got caught on something and ripped opening causing two coins to drop ...");
                v.takeGold(2);
            }
        }
        
        else {
            v.tell("you rush into the room.");
            v.tell("the lights are off however, luckily the light switches are right next to you.");
            v.tell("you turn the lights on and begin searching the room");
            v.tell("right infront of you is a wallet containing two gold coins");
            v.giveGold(2);
            lightsOn = true;
        }
        
        if(lightsOn == false) {
            if(survivorRescued == true) {
                v.tell("luckily, the survivor is well equipped and has a lantern in their backpack, you use it to discover the cabinet in front of you!");
                v.tell("the cabinet drawers appear to be locked, if only you had a key that could open them.");
                v.tell("the survivor also managed to pick up some keys in one of the rooms that they visited some time ago ...");
                v.tell("the survivor hands the keys over to you");
                v.giveItem(keys);
                v.tell("you open the cabinet to find that it is filled with gold coins");
                v.tell("you and the survivor split the coins, 10 each");
                v.giveGold(10);
            }
            else if(survivorRescued == false) {
                v.tell("you bump into the wall causing a painting to drop ...");
                v.tell("mysterious noises begin to play");
                v.tell("to pay for your mistake, you are charged - 2 gold coins");
                v.takeGold(2);
            }
        }
        else if(lightsOn == true) {
            v.tell("you discover a cabinet in front of you");
            v.tell("the cabinet drawers appear to be locked, if only you had a key that could open them.");
        }
            
        if (survivorRescued == false) {
            v.tell("you begin to hear the strange noises from earlier again.");
            v.tell("you run towards the exit and leave !");
        }
        else {
            v.tell("you and the survivor can choose which exit to take.");
        }
            
            
        if (survivorRescued == false) {
            exit = d.TO_EAST;
        }
            
        else {
            
            choice = v.getChoice("a - North  b - South  c - West",multipleChoices);
            if (choice == 'a') {
                exit = Direction.TO_NORTH;
            } 
            else if (choice == 'b'){
                exit = Direction.TO_SOUTH;
            } 
            else if (choice == 'c'){
                exit = Direction.TO_WEST;
            }  
        }
            
            
        return exit;
        
    }                      
}
    
