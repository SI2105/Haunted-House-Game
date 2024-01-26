package HauntedHouseGame.contributions;

class Room_ec22592 extends Room {

    public Direction visit(Visitor visitor, Direction direction){

        visitor.tell("Welcome to the Winchester Mystery House.");
        visitor.tell("Hello Visitor...you seem to have entered the room from the " + direction + " entrance.");
        visitor.tell("The aim of this quest is to acquire a total of 5 Gold, which are found based on your decisions. If you dont acquire the required number of Gold, then you fail the quest");
        
        char [] choices = {'a', 'b'};

        if (direction== Direction.FROM_NORTH){
            visitor.tell("You have arrived from the north entrance.");
            char choice = visitor.getChoice("As you entered from the North entrance, you have two options, a) Look in the cubboard   (b) look under the carpet", choices);
            
            if (choice== 'a'){
                visitor.tell("Congratulations you checked the right place, and found the 5 coins...therefore you passed this quest!");
                visitor.giveGold(5);
            }
            
            else if (choice== 'b'){
                visitor.tell("Unfortunately, you checked the wrong area of the room and didnt manage to find the required coins in time, therefore you failed this quest.");
            }
            
        }
        
        else if (direction== Direction.FROM_SOUTH){
            visitor.tell("You have arrived from the South entrance.");
            Item Puzzle = new Item("Puzzle piece");
            
            visitor.tell("As you entered from the south entrance, you noticed a puzzle piece on the floor and you picked it up and placed it among the rest of the puzzle.");
            visitor.tell("Congratulations for finding the puzzle piece you obtained 5 Gold, straight from the entrance");
            visitor.giveGold(5);
            
            char choice= visitor.getChoice("You still have two options however, a) Look behind the pillar  (b) look above the fan", choices); 

            if (choice== 'a'){
                
                visitor.tell("Unfortunately this was a trap, and you got startled, causing you to drop and lose the 5 coins you began with. Therefore this means you fail this quest.");
                visitor.takeGold(5);
            }
            else if (choice== 'b')
            {
                visitor.tell("You didnt find any coins, however you already acquired 5 from the start therefore you pass the quest.");
            }
        }
        
        else if (direction== Direction.FROM_EAST)
        {
            char choice= visitor.getChoice("As you have entered through the East Entrance, you have two options, a) Check the tresure Box (b) Check the trash bin.", choices); 
            
            if (choice== 'a')
            {
                visitor.tell("You open the tresure box and notice alot of silver coins stored in the box...");
                visitor.tell("Unforunately these are not Gold coins, therefore you collected zero Gold coins.");
                visitor.tell("This means that you failed the Quest!");
                visitor.tell("The east entrance was made to make you bound to fail, so dont feel bad.");
            }
            else if (choice== 'b')
            {
                visitor.tell("You opened the trash bin and what did you see...");
                visitor.tell("Unfortunately, just trash :( .");
                visitor.tell("This means that you failed the Quest!");
                visitor.tell("The east entrance was made to make you bound to fail, so dont feel bad.");
            }
        } 
        else if (direction== Direction.FROM_WEST)
        {
            char choice= visitor.getChoice("As you have entered through the West Entrance, you have two options, a) Check below the window  (b)Check in the sand-pit.", choices);
            
            if (choice== 'a')
            {
                visitor.tell("WOW, there seems to be 5 Golden coins here which you can pick up");
                visitor.tell("Congratulations you passed the quest.");
                visitor.tell("This is a secret, but whichever option you picked at the West Enterance, would have resulted in you passing the quest.");
                visitor.giveGold(5);
            }
            else if (choice== 'b')
            {
                visitor.tell("WOW, there seems to be 5 Golden coins here which you can pick up");
                visitor.tell("Congratulations you passed the quest.");
                visitor.tell("This is a secret, but whichever option you picked at the West Enterance, would have resulted in you passing the quest.");
                visitor.giveGold(5);
            }
        }
        
        visitor.tell("Well you have reached the exit of the Mystery House...");
        visitor.tell("Even if you lost or won the quest today, I hope you had a blast :) ");
        
        return direction;
        
    }
    
}
