package OOP.ec22612.MP.contributions;

public class Room_ec22837 extends Room{
    Item key = new Item("key");
    Item torch = new Item("torch");
    char[] yes_no_choice = {'Y', 'N'};
    char[] multiple_choice = {'a', 'b', 'c', 'd'};
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        visitor.tell("welcome to the winchester mystery house");
        visitor.tell("you are in a dark room with cobwebs in every corner");
        if(directionVistorArrivesFrom == Direction.FROM_NORTH){
            visitor.tell("you entered from the north door");
        }
        else if(directionVistorArrivesFrom == Direction.FROM_SOUTH){
            visitor.tell("you entered from the south door");
        }
        else if(directionVistorArrivesFrom == Direction.FROM_EAST){
            visitor.tell("you entered from the east door");
        }
        else if(directionVistorArrivesFrom == Direction.FROM_WEST){
            visitor.tell("you entered from the west door");
        }
        visitor.tell("the door locked behind you");
        visitor.tell("you need to find the key to the next door in this room");
        char choice1 = visitor.getChoice("there is a torch on a table in the middle of the room, will you take it?(Y/N)", yes_no_choice);
        if(choice1 == 'Y'){
            visitor.giveItem(torch);
        }
        boolean found = false;
        while(!found){
            char choice2 = visitor.getChoice("there are 4 areas you can approach, choose one(a, b, c or d). \na)there is a drawer in the northeast of the room \nb)there is a chest in the southeast of the room \nc)there is an unusually dark spot in the southwest of the room \nd)theres also the northwest corner with nothing much", multiple_choice);
            if(choice2 == 'a'){
                visitor.tell("you searched the drawers and found 2 gold coins");
                visitor.giveGold(2);
            }
            else if(choice2 == 'b'){
                visitor.tell("you open the chest and a ghost pops up. you get shook and drop 2 coins but you also find the key");
                visitor.takeGold(2);
                visitor.giveItem(key);
            }
            else if(choice2 == 'c'){
                if(visitor.hasIdenticalItem(torch)){
                    visitor.tell("you have a torch so you can see the dark spot clearly. You found 4 pieces of gold!");
                    visitor.giveGold(4);
                }
                else{
                    visitor.tell("you dont have a torch so you cant see the dark spot. there's nothing to do here");
                }
            }
            else if(choice2 == 'd'){
                visitor.tell("there's nothing here");
            }
            else{
                visitor.tell("choose a, b, c or d");
            }
            if(visitor.hasEqualItem(key)){
                char choice3 = visitor.getChoice("you have the key do you want to leave?(Y/N)", yes_no_choice);
                if(choice3 == 'Y'){
                    found = true;
                }
            }
        }
        return directionVistorArrivesFrom.opposite(directionVistorArrivesFrom);
    }
    
}
