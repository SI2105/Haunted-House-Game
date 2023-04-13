package OOP.ec22612.MP.contributions;

class Room_ec22572 extends Room {

    public Direction visit(Visitor visitor, Direction Direction_came_from ){
            // Items in my room
    Item lamp = new Item("lamp");
    Item book = new Item("book");
    Item laptop = new Item("laptop");
    Item flowers = new Item("flowers");
    Item cup = new Item("cup");
    // visitors original location in room
    String v_location = "door";
    Direction directionVistorArrivesFrom = Direction_came_from;
    // options
    char choice_1 = 'z';
    char choice_2 = 'z';
    char choice_3 = 'z';
    char choice_4 = 'z';

    visitor.tell("Welcome to my Room!");visitor.tell("Would you like to walk inside my room a little more?");
    char[] options_for_1={'a','b','c'};choice_1=visitor.getChoice("Select a) to walk a bit further into the room, select b) to stay where you are, select c) to leave my room",options_for_1);

    if(choice_1 =='a')
    {
        v_location = "centre of room";
        visitor.tell("Hey! welcome to the middle of my room, it is very spacious look around.");
        visitor.tell(
                "If you find anything you want to take please do, but choose carefully you are only allowed to take one item!");
        visitor.tell("Due to me being a lovely room owner I have decided to gift you 5 gold pieces!");
        visitor.giveGold(5);
    }else if(choice_1 == 'b')
    {
        visitor.tell(
                "oooo so you have decided to stay at near the front of the room, look around to see if you find anything you fancy! However, choose carefully you are allowed to take one item!");
        visitor.tell(
                "As you are not so interested in going in further into my room... I shall take some gold from you!");
        visitor.takeGold(3);
    }else if(choice_1== 'c')
    {
        visitor.tell("SO YOU HAVE DECIDED TO LEAVE MY DOMAIN WITHOUT PASSING THROUGH");
        visitor.tell("I WILL BE TAKING AWAY YOUR HARD EARNED GOLD");
        visitor.takeGold(4);
        visit(visitor, directionVistorArrivesFrom);
    }

    if(v_location.equals("centre of room"))
    {
        visitor.tell("The decor of my room is very pretty don't you like it?");
        visitor.tell("There are some items around");
        char[] options_for_2 = { 'a', 'b', 'c', 'd'};
        choice_2 = visitor.getChoice("Select a) to pick up a book, Select b) to pick up a laptop, Select c) to pick up flowers, Select d) to not pick up anything", options_for_2);
    }else if(v_location.equals("door"))
    {
        visitor.tell("The decor of my room at the entrance isn't greate there's only one Item here");
        char[] options_for_3 = { 'a', 'b', 'c'};
        choice_3 = visitor.getChoice("Select a) to pick up a lamp, Select b) to pick up a cup, Select c) to not pick up anything", options_for_3);
    }
    
    if(choice_2 == 'a'){
        visitor.tell("You have taken the book!, I will reward you with 3 gold for taking an item");
        visitor.giveItem(book);
        visitor.giveGold(3);
    }else if(choice_2 == 'b'){
        visitor.tell("You have taken the laptop!, I will reward you with 3 gold for taking an item");
        visitor.giveItem(laptop);
        visitor.giveGold(3);
    }else if(choice_2 == 'c'){
        visitor.tell("You have taken the flowers!, I will reward you with 3 gold for taking an item");
        visitor.giveItem(flowers);
        visitor.giveGold(3);
    }else if(choice_2 == 'd'){
        visitor.tell("You have not taken anything :( I will be taking away 3 of your gold!");
        visitor.takeGold(3);
    }

    if(choice_3 == 'a'){
        visitor.tell("You have taken the Lamp!, I will reward you with 3 gold for taking an item");
        visitor.giveItem(lamp);
        visitor.giveGold(3);
    }else if(choice_3 == 'b'){
        visitor.tell("You have taken the cup!, I will reward you with 3 gold for taking an item");
        visitor.giveItem(cup);
        visitor.giveGold(3);
    }else if(choice_3 == 'c'){
        visitor.tell("You have not taken anything :( I will be taking away 3 of your gold!");
        visitor.takeGold(3);

    }

    visitor.tell("It is now time to leave my room make your decision on where you would like to go");

    char[] options_for_4 = {'a','b','c','d'};
    choice_4 = visitor.getChoice("Select a) to advance north, select b) to advance south, select c) to advance east, select d) to advance west",options_for_4);

    visitor.tell("Thank you for visiting my room!");
    if(choice_4 == 'a'){
        directionVistorArrivesFrom = Direction.TO_NORTH;
        return directionVistorArrivesFrom;
    }else if(choice_4 == 'b'){
        directionVistorArrivesFrom = Direction.TO_SOUTH;
        return directionVistorArrivesFrom;
    }else if(choice_4 == 'c'){
        directionVistorArrivesFrom = Direction.TO_EAST;
        return directionVistorArrivesFrom;
    }else if(choice_4 == 'd'){
        directionVistorArrivesFrom = Direction.TO_WEST;
        return directionVistorArrivesFrom;
    }else{
        directionVistorArrivesFrom = Direction.UNDEFINED;
        return directionVistorArrivesFrom;
    }
    }

}
