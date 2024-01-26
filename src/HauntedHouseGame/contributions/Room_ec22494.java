package HauntedHouseGame.contributions;

//A4
//A4 again
//A4 once again
class Room_ec22494 extends Room {
    Item canvas = new Item("Canvas");
    Item cement = new Item("Cement");
    Item poo = new Item("Poo");
    Item red_bucket = new Item("Red bucket");
    
    public Direction visit(Visitor v, Direction d) {
        v.tell("Howdy, there's a snake in my boot! Take 5 gold coins for no reason.");
        v.giveGold(5);
        char[] waysToGo = {'F','B','R','L'};
        char choice = v.getChoice("Which way would you like to COME. Forwards backwards or sideways (F,B,R or L)", waysToGo);
        
        if (choice == 'F') {
            v.tell("You spot a wild sonic the hedgehog eating a juicy pair of socks. Take 5 gold coins for your trauma");
            v.giveGold(5);
            if (v.giveItem(canvas)) {
                v.tell("Here take this blank canvas and bomboard it with news articles such as the Jamie Carragher glastonburry bustup");
            }
            return Direction.TO_NORTH;
        }
        
        if (choice == 'R') {
            v.tell("Well done, we are very proud of you, you have taken the RIGHT path, am I RIGHT? lol, Don't worry, you're all RIGHT hahahahaha");
            char[] one_or_nine = {'1','9'};
            char coins = v.getChoice("Because I'm so funny I am going to reward you. Would you like 1 gold coin or 9 gold coins (1 or 9)", one_or_nine);
            if (coins == '1') {
                v.giveGold(3);
            } else {
                v.giveGold(10);
            }
            if (v.giveItem(red_bucket)) {
                v.tell("Take this red bucket wherever you go. One day, it may just save your life");
            }
            return Direction.TO_EAST;
        }
        
        if (choice == 'B') {
            v.tell("You receive thunderous backshots from Shrek! He charges you 3 gold coins for that amazing experience.");
            v.takeGold(3);
            if (v.giveItem(cement)) {
                v.tell("Shrek gifts you some fresh cement. He attained this cement from an evening meal at 2 in the afternoon with Inspector Goole");
            }
            return Direction.TO_SOUTH;
        }
        
        if (choice == 'L') {
            v.tell("You get robbed by Santa claus, ice bear from we bare bears, and Darwin Nunez");
            v.takeGold(5);
            if (v.giveItem(poo)) {
                v.tell("You poo yourself and the thoughtful thieves very kindly allow you to keep it.");
            }
            return Direction.TO_WEST;
        }
        
        return d;
    }
}
