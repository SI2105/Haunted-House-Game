package OOP.ec22612.MP.contributions;

class Room_ec22616 extends Room{
    public Direction visit(Visitor v, Direction direction){
        //variable declarations
        Item sword = new Item("sword");
        char[] options = {'f','r'};
        char[] direction_they_choose = {'n', 's', 'e', 'w'};
        boolean sword_picked_up = false;
        
        v.tell("There are multiple curses in the room");
        v.tell("There's also a sword in front of you on the floor");
        v.tell("Do you wish to fight  theses curses with a sword or do you wish to escape this room");
        
        char choice = v.getChoice("Enter 'f' to fight or 'r' to run if you're scared", options);
        
        if(choice == 'r'){
            v.tell("Which direction do you want to run away to");
            char direction_to_run = v.getChoice("Enter 'n' to run north, 's' to run south, 'e' to run east, 'w' to run west", direction_they_choose);
            switch(direction_to_run){
                case 'n':
                    return Direction.TO_NORTH;
                case 's':
                    return Direction.TO_SOUTH;
                case 'e':
                    return Direction.TO_EAST;
                case 'w':
                    return Direction.TO_WEST;
                default:
                    return Direction.opposite(direction);
            }
        } else{
            sword_picked_up = true;
            v.tell("You pick up a sword and get ready for battle");
            v.tell("You exorcise all the curses and leave nothing but blood behind, well done");
            v.tell("You may leave the room happily through the door up north");
            return Direction.TO_NORTH;
        }
    }
}
