package HauntedHouseGame.contributions;

class Room_ec22880 extends Room{


    public Direction visit(Visitor v, Direction d){
        
        final Item ROPE = new Item("Rope");
        
        char [] arrayOfPossibleChoices = {'a','b'};
        
        String Choices = "a) pick up an item b) Leave" ;
        
        v.tell("Welcome visitor, what would you like to do");
        
        char choice = v.getChoice( // Returns visitor's choice.
                   Choices,
                   arrayOfPossibleChoices);

     
        if (choice == 'a'){
            ChoiceA(d,v,ROPE);
            return Direction.opposite(d);
        }

        else{
            return Direction.opposite(d);
        }

        
    }

    public void ChoiceA(Direction d, Visitor v, Item item){
    v.tell("Where would you like to go");
    char DirectionChoice = v.getChoice(
    "N (north), S (south), E (east), W (west)", new char [] {'N','S','E'});
    char [] Choice = {'O', 'L'};
    int GOLD = 0;

    if (DirectionChoice == 'N'){
        v.tell("You have found a chest.");
        char chestChoice = v.getChoice(
            "Would you like to open the chest (O) or leave (L)", 
        Choice);
 
        if (chestChoice == 'O'){
            v.tell("Well... Looks like... You found... Nothing!!!");
        }

        if (chestChoice == 'L'){
            return;
        }

    }

    if (DirectionChoice == 'S'){
        return;
    }

    if (DirectionChoice == 'E'){

        v.tell("You found a drawer.");
        char DrawerChoice = v.getChoice(
            "Would you like to open the drawer (O) or leave (L)", 
        Choice);

        if (DrawerChoice == 'O'){
            v.tell("Well... Looks like... You found... GOLD!!! Congratulations");
            GOLD = GOLD + 5;
            v.giveGold(GOLD);
            
        }

    }

    if (DirectionChoice == 'W'){
        v.tell("Well... Looks like... You found... Nothing!!!");
        v.tell("Just kidding. You found some rope. Won't help much.");
        v.tell("Better than nothing I suppose");

        if (v.hasEqualItem(item) || v.hasIdenticalItem(item)){
            v.tell("Well seems you already have this rope.");
            v.tell("Take some gold as a reward");
            GOLD = GOLD + 3;
        }
        else{
            v.giveItem(item);
        }

    }
            
        

    }

}
