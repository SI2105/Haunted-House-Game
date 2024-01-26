package HauntedHouseGame.contributions;

public class Room_ec221193 extends Room {
    
    static boolean lightsOn = true;
    static boolean doorOpen = false;
    static boolean roomClean = false;
    static boolean smeelsNice = false;
    static boolean isHaunted = true;


    public Direction visit(Visitor person, Direction direction){

        final char [] yes_no_options = {'y', 'n'};
        final char [] abcd_options = {'a','b','c','d'};
        
        int visitor_gold_coins = 0;
        Item key = new Item("Key");
        person.tell("Welcome to the room ec221193 of the Winchester Mystery House! And thank you for your visit. During your visit, you will be able to collect gold coins. For the moment you have none.");

        if (lightsOn) {
            char lights_descision = person.getChoice("As you can see, the lights are on, would you like to turn them off? (Enter y for yes and n for no)", yes_no_options);
            if (lights_descision == 'y'){
                lightsOn = false;
                person.tell("I see you like to take risks, let's turn them off then, here is 5 gold coins for your courage");
                person.giveGold(5);
                visitor_gold_coins += 5;
            }
        }
        if (doorOpen){
            person.tell("I will now proceed to close the door!");
            doorOpen = false;
            
        }

        char action = person.getChoice("What would you like to do now? You have 4 choices, and will be helped by a candle: (a) search the cupboard, (b) search the closet, (c) search in the trunk, (d) search the desk", abcd_options);


        switch (action){
            case 'a':
                person.tell("Great job, you found 10 gold coins in the cupboard.");
                person.giveGold(10);
                visitor_gold_coins += 1;
                break;
            case 'b':
                person.tell("Unlucky, there isn't anything in the closet.");
                break;
            
            case 'c':
                person.tell("Wow, you found a key in the trunk, let me hand it to you.");
                person.giveItem(key);
                break;
            case 'd':
                person.tell("Impressive, you found 15 gold coins laying on the desk.");
                person.giveGold(15);
                visitor_gold_coins += 15;
            default:
                person.tell("You didn't make a valid choice, missed your opportunity!");
            }
        
        char newDirection = person.getChoice("Where do you wish to go now? (a) North, (b) East, (c) South, (d) West", abcd_options);
        
        switch (newDirection){
            case 'a':
                direction = Direction.TO_NORTH;
                break;
            case 'b':
                direction = Direction.TO_EAST;
                break;
            case 'c':
                direction = Direction.TO_SOUTH;
                break;
            case 'd':
                direction = Direction.TO_WEST;
                break;
            default:
                direction = Direction.TO_NORTH;
            }
    
        person.tell("Good Luck to you and thank you for visiting room ec221193 of the Winchester Mystery House, you have gathered a whopping "+ visitor_gold_coins + ", hope to see you soon!");

        return direction;
    }

}
