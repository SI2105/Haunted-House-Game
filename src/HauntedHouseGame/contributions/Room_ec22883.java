package HauntedHouseGame.contributions;

class Room_ec22883 extends Room
{
    Item gun = new Item("Winchester");
    
    public Direction visit( // Returns direction the visitor leaves towards.
    Visitor vis,
    Direction dir)
    {
        vis.tell("Howdy Ho, stranger! I am an arms dealer!");
        char[] choices = {'a', 'b', 'c', 'd'};
        
        
        char choice = vis.getChoice("What do you want to do (print a character): a) sell a gun b) buy a gun", choices);
        
        switch(choice){
        case 'a':
            vis.tell("I am looking for - Winchester. Just plain Winchester. If you have it, I can give you 7 coins.");
            if (vis.hasIdenticalItem(gun))
            {
                vis.tell("Wow, you've got exact thing I am looking for. I will pay you 8, 1 as a tip");
                vis.giveGold(8);
            }
            else if (vis.hasEqualItem(gun))
            {
                vis.tell("A fine, nice Winchester! Get your 7 coins");
                vis.giveGold(7);
            }
            else
            {
                vis.tell("Nah, that's not the thing I am looking for! Get out of here!");
                return dir;
            }
            break;
        case 'b':
            vis.tell("Winchester costs 9. First money, then Winchester!");
            if (vis.takeGold(9)>=9)
            {
                vis.giveItem(gun);
                vis.tell("It was nice to do some business with ya! See you later");
            }
            else 
            {
                vis.tell("That's not 9 coins in my eyes! Get outta here, while I won't shoot you!");
                return dir;
            }
            break;
        }
        vis.tell("Come back later!");
        return Direction.opposite(dir);

    }   
    
}
