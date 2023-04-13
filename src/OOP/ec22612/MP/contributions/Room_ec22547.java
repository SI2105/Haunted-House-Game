package OOP.ec22612.MP.contributions;

class Room_ec22547 extends Room {
    
    public Direction visit(Visitor v, Direction d){
        Direction nextDirection = d;
        final Item plans = new Item("House Plans");
        final Item key = new Item("Key");
        final char[] options = {'a','b','c','d','r','t','x'};
        
        v.tell("The walls of this room are lined with stained glass windows and in the centre lies only a small table. \nOn the table, there is a small pile of gold and a note that reads: \n\"For the fare home\"");
        char ans = v.getChoice("Do you: (a) take the money? or (b) leave the gold alone?",options);
        if (ans == 'a'){
            v.giveGold(4);
            
            ans = v.getChoice("Underneath the table there is a gap in the floorboards. Do you want to (r) reach inside and search under the floorboards or (x) leave the room without searching",options);
            if (ans == 'r'){
                v.tell("You find an item [House Plans] but as you go to take it, some gold falls out of your pocket and into the hole.");
                v.giveItem(plans);
                v.takeGold(6);
                nextDirection = d.TO_NORTH;
            }
            else if (ans == 'x'){
                nextDirection = d.TO_EAST;
            }
        }
        else if (ans == 'b'){
            v.tell("Before you leave the room, you notice there is another message on the other side of the note, along with a name. \nThe note says: \n\"If you choose to say my name out loud, your reward will be even greater than those who have come before you.\"");
            ans = v.getChoice("Do you: (c) say the name? or (d) immediately continue into the next room?",options);
            if (ans == 'c'){
                v.tell("A large pile of gold and a small golden key appears by the door.");
                v.getChoice("Do you want to (t) take the items as you leave or (x) ignore them as you head for the exit?",options);
                if (ans == 't'){
                    v.giveGold(10);
                    v.giveItem(key);
                    nextDirection = nextDirection.opposite(d);
                }
                else if (ans == 'x'){
                    nextDirection = d;
                }
            }
            else if (ans == 'd'){                
                nextDirection = nextDirection.opposite(d);
            }
        }
        
        return nextDirection;
        
    }
}
