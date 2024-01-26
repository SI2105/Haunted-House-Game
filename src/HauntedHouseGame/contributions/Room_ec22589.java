package HauntedHouseGame.contributions;

class Room_ec22589 extends Room{
    boolean mist = true;
       
    public Direction visit(Visitor v, Direction d){
        // v is the visitor, d is the direction they came from
        
        v.tell("You have entered the room. ");
        
        if (mist){
            v.tell("You are surrounded by dark mist. ");
            v.tell("The mist clears as you make your way towards the center of the room. ");
            mist = false;
        }
        else{
            // Already entered room
            v.tell("Remnants of some dark mist is present in the room but slowly fading away. ");
            v.tell("You make your way to the center of the room. ");
        }
        
        
        char[] choices = {'y', 'n'};
        
        Item Ring = new Item("Ring");
        
        if (d == Direction.FROM_NORTH || d == Direction.FROM_SOUTH){
            // If they come from the north or south a chest spawns in the center of the room containing gold or an item.
            v.tell("You see a golden chest in the center of the room");
           
            char choice = v.getChoice("Do you want to open it? (Y/N): ", choices);
            
            if (choice == 'y'){
                if (v.hasIdenticalItem(Ring) || v.hasEqualItem(Ring)){
                    // They already have the ring so they get gold instead.
                    v.tell("You have obtained some gold. ");
                    v.giveGold(5);
                }
                else{
                    // They are given a ring
                    v.tell("You have obtained a mysterious ring engraved with strange runes. ");
                    v.giveItem(Ring);
                }
            }
            else{
                v.tell("You have missed a great opportunity. ");
            }
                        
        }
        else{
            // A coffin spawns which contains a spirit that steals your coins.
            v.tell("A coffin giving off a light purple glow is in the center of the room");
            
            char choice = v.getChoice("Do you want to open it? (Y/N): ", choices);
            
            if (choice == 'y'){
                v.tell("The coffin opens with a loud creak and the escaping spirit encapsulates your body briefly.");
                
                int gold_taken = v.takeGold(5);
                v.tell("The spirit has stolen " + gold_taken + " gold. ");
            }
            else{
                v.tell("You made a wise choice. ");
            }
        
        }
        
        v.tell("You have left the room. ");
        return Direction.opposite(d);
        
    }
}
    
