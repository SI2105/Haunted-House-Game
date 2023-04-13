package OOP.ec22612.MP.contributions;

class Room_ec22912 extends Room{
    
    int gold = 10;
    Item bottles = new Item("Bottles");
    
    public Direction visit( // Returns direction the visitor leaves towards.
    Visitor visitor,Direction directionVisitorArrivesFrom){
        
        visitor.tell("You are in the upstairs downstairs left to the right basement room. There are water bottles in the room.");
    
        String descriptioOfChoices = "You can choose to take a bottle(t), Fill water bottle(f),rob place(r) or fight owner for potential gold(m)";
        char[] arrayOfPossibleChoices = {'t','f','r','m'};
        
        char choice = visitor.getChoice( // Returns visitor's choice.
            descriptioOfChoices,arrayOfPossibleChoices);
        
        if(choice == 't'){
            visitor.tell("That would be 3 gold to your bottle.");
            visitor.giveItem(bottles);
            gold += visitor.takeGold(3);
        }
        
        else if(choice == 'f'){
            visitor.tell("That would be 1 gold to fill your bottle.");
             if(visitor.hasEqualItem(bottles)){
                 gold += visitor.takeGold(1);
             }
            else{
                visitor.tell("You need to buy a botte first.");
            }
            
        }

        else if(choice == 'e'){

            if(visitor.hasIdenticalItem(bottles) && gold >= 2){   
                visitor.tell("Oh no, someone robbed me and I did not notice.");
                 gold = gold - 2;
                 visitor.giveGold(2);
             }
            
            else if(visitor.hasIdenticalItem(bottles) && gold < 2){
                visitor.tell("I am already poor please don't rob me.");
            }
            
            else{
                visitor.tell("Why don't you have a water bottle, leave the premises.");
            }
        }
        
        else if(choice == 'm'){
            String fight = "You can win magically get 10 gold or lose 10 gold if you lose.";
            char[] fight_choices = {'W','L'};
            char winner = visitor.getChoice(fight,fight_choices);
            
            if(winner == 'W'){
                visitor.tell("Sorry boss I can only give you " + gold + " amount of gold.");
                visitor.giveGold(gold);
                gold = 0;
            }
            
            else if(winner == 'L'){
                visitor.tell("You lost");
                gold += visitor.takeGold(10);
            }        
        }
        
        
        return Direction.TO_SOUTH;
        
    }
}
