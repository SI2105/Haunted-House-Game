package HauntedHouseGame.contributions;

import java.util.Scanner;


class Room_ec22510 extends Room{
    Boolean art_room = true;
    Boolean closet = true;
    Boolean Basketball_taken = false;
    Scanner key = new Scanner(System.in);
    
    static final Item French_painting = new Item("French painting");
    static final Item Justins_Basketball = new Item("Justin's Basketball");
        
    public Direction visit(Visitor v, Direction d){ 
        if ((art_room == false) & (closet == false) & (Basketball_taken == true)){
            
            v.tell("unfortunately there is nothing for the taking at the moment.");
        }
        else{
            
            if(Basketball_taken == false)
            {
                v.tell("It seems like my friend Justin shot his basketball into my window");
                char[] op = {'y','n'};
                char choice = v.getChoice("would u mind taking it back to his room? (y) or (n)",op);
                switch (choice)
                {
                    case 'y':
                        v.tell("Thanks mane here's some gold for your troubles");
                        v.giveItem(Justins_Basketball);
                        v.giveGold(8);
                        Basketball_taken = true;
                        break;
                    case 'n':
                        v.tell(":^(");
                        break;
                }
            }
            if(art_room ==true){
                char[] menu = {'y','n'};
                char choose = v.getChoice("would you like to take a painting? (y) or (n)",menu);
                switch(choose){
                    case 'y':
                        v.tell("here you go. i'm sure it will be worth more the longer you keep it.");
                        v.giveItem(French_painting);
                        art_room =false;
                        break;
                    case 'n':
                        v.tell("ur loss mane");
                        break;
                }
            }  
       
            
        }
        
        return Direction.opposite(d);
    }
}