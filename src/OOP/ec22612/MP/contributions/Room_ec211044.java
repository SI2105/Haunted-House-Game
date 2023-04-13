package OOP.ec22612.MP.contributions;

class Room_ec211044 extends Room{

    public Direction visit(Visitor visitor, Direction direction){
        Item item = new Item("sexy panties");
        boolean lighton = false;
        char[] directionChoice = new char[] {'e', 's', 'w', 'n'};
        char[] yesOrno = new char[]{'y','n'};
        char choice = visitor.getChoice("Hi,I lost my panties in this darkened room, can you help me to find it?(y|n)",yesOrno );
        if(choice =='y'){
            visitor.tell("thank you!");
            char go = visitor.getChoice("Which direction do you want to go (east(e), south(s), west(w), north(n))",directionChoice);
            if(go == 'e'){
                visitor.tell("It's a wall here, there's nothing");
                return Direction.TO_EAST;
            }
            else if(go =='w'){
                visitor.tell("Here are some gold coins");
                visitor.giveGold(4);
                return Direction.TO_WEST;
            }
            else if(go =='n'){
                visitor.tell("You step on a switch");
                char switchLight = visitor.getChoice("Do you want to turn the light on?", yesOrno );
                if (switchLight == 'y'){
                    visitor.tell("My pants appear, it's right next to you");
                    visitor.giveItem(item);
                }
                else{
                    visitor.tell("I feel like we're missing out on something");
                }
                
                return Direction.TO_NORTH;
                    
            }
            else if(go =='s'){
                visitor.tell("Although that's the direction we're coming from, it doesn't matter");
                return Direction.TO_SOUTH;
            }    
        }
        else{
            visitor.tell("OK, goodbye");
            return Direction.opposite(direction);
        }
        
        if (visitor.hasIdenticalItem(item)){
            visitor.tell("Thank you so much, I will give you some gold coins!");
            visitor.giveGold(5);
                
        }
        return Direction.opposite(direction);
    }
}
