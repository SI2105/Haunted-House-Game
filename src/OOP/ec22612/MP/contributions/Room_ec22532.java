package OOP.ec22612.MP.contributions;

import java.util.Random;
class Room_ec22532 extends Room{ 
 
// Returns direction the visitor leaves towards, Interaction method
     public Direction visit( Visitor visitor, Direction directionVistorArrivesFrom){
         
         reward(visitor, askChoice(visitor));
         
         return directionVistorArrivesFrom;}
    
    //Your code can tell the visitor things by calling its tell(String) method; the string you pass will be shown to the user. You should first tell the visitor about the room and the state it is in. This may depend on the direction the visitor arrives from and/or on the state of your room's instance variables.
    
    public void welcome(Visitor visitor, Direction directionVisitorArrivesFrom){
        visitor.tell("Welcome to the ec22532 room");
        visitor.tell("You have come from the " + directionVisitorArrivesFrom + "direction.");
    }
    
//Your room can ask the visitor to make a choice by calling the visitor's getChoice(String,char[]) method and then tell the visitor the consequences of that choice. For example, a visitor may be able to blow out or light candles, look inside a cupboard, etc.
//If you like, you can give the visitor an Item object via the giveItem(Item). You can also check if the visitor is carrying a particular item by calling hasIdenticalItem(Item) or hasEqualItem(Item). You should not give more than one item per visit.
        
    public int askChoice(Visitor visitor){
        //depending on the users choice they will get a better or worse chance for an item
        char[] heroes = {'I','H','T','A','S'};
        char choice = visitor.getChoice("Choose your favourite marvel superhero. \n (I) Iron Man,(H) The Incredible Hulk,(T) Thor,(A) Captain America: The First Avenger,(S) Spider-Man",heroes);
        
        if (choice == 'A' | choice == 'T'){
            visitor.tell("Washed");
            return 10;}
        else if (choice == 'H' | choice == 'I'){
            visitor.tell("Mid");
            return 6;}
        else if (choice == 'S'){
            visitor.tell("GOAT");
            return 3;}
        else{return 0;}
    }
    

//If you like, depending on the visitor's choices, your room can give pieces of gold to the visitor via the giveGold method and/or take pieces via the takeGold method. The latter returns the amount of gold actually taken, as sometimes the visitor will simply not have the amount your room tries to take. You should not give or take more than 10 pieces.
    
    public void reward(Visitor visitor, int Chance){
        //create items
        Item fish = new Item("fish");
        
        //roll a dice of sides int Chance and give the item a corresponding item
        
        visitor.tell("Based on your choice, you have a 1 in " + Chance + " chance of getting some Gold.");
        visitor.tell("Rolling the dice...");
        int rolled = Dice(Chance);
        if (rolled == 1){
            visitor.giveGold(1);
            visitor.tell("You gained one gold.");
        }
        else if (rolled == 2 |rolled == 4 | rolled == 6|rolled == 8|rolled == 10){
            visitor.giveItem(fish);
            visitor.tell("You gained one fish.");
        }
        else{
            visitor.takeGold(1);
            visitor.tell("You lost one gold.");
        };
        
        return;
        
    }
    
    public int Dice(int sides){
        Random rand = new Random();
        int roll = rand.nextInt(sides + 1);
        return (roll + 1);
    }
    
    
    
//After one or several interactions, your visit method should return the direction in which the visitor leaves the room.
    
    
    public Direction goodbye(Visitor visitor, Direction directionVisitorArrivesFrom){
        visitor.tell("Welcome to the ec22532 room");
        visitor.tell("Leave in the" + directionVisitorArrivesFrom.opposite(directionVisitorArrivesFrom) + "direction.");
        return directionVisitorArrivesFrom.opposite(directionVisitorArrivesFrom);
    }
    
}
    

































