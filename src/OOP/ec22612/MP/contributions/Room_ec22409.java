package OOP.ec22612.MP.contributions;

class Room_ec22409 extends Room
{
    public Direction visit (Visitor v, Direction d)
    {
        //This set of code will go through 2 possible different interactions, they will have a between 3 options and then another choice of 3 options again.
        Item rubberD = new Item("Rubber Ducky");
        String decisions = "a) Shuffle around under the bed, b) Tear down a poster, c) Do 20 star jumps";
        char[] visitors_choice = {'a', 'b', 'c'};
    
        v.tell("Welcome visitor! You have entered my dangerous room of various bits and bobs");
        v.tell("I wish you the best, but tread carefully as not all looks as it seems");
        char players_choice = v.getChoice(decisions, visitors_choice); 
        
        if(players_choice == 'a')
        {
            v.tell("You shuffle through the bed vigorously");
            v.tell("You wake up the goblin rat and he tries to steal 7 coins from you!");
            int money_taken = v.takeGold(7);
            if (money_taken == 7)
            {
                v.tell("The rat manages to take all 7 coins!");
            }
            else{
                v.tell("The goblin rat takes "+money_taken+" from you! Oh No!"); 
            }
        }
        else if(players_choice == 'b')
         {
             v.tell("You tear down the magnificent poster like a complete monster!");
             v.tell("All that awaited you was a tiny triceretops pushing a rubber ducky towards you as if it wants you to have it");
             v.tell("You take the rubber ducky with great honour and promise to treasure in the name of little triceretops");
             v.giveItem(rubberD);
         }
         
         else if(players_choice == 'c')
         {
             v.tell("You foolishly decide to do 20 whole entire star jumps in the middle of the room for no reason");
             v.tell("Somehow a leprechaun caught sight of you during the act");
             v.tell("and luckily he had decided to shower you in 7 entire gold coins, Be proud!");
             v.giveGold(7);
         }

        decisions = "a) Stare into the crystal ball, b) Blow up bouncy castle?? , c) Pet the dog ";
        players_choice = v.getChoice(decisions, visitors_choice); 
        
        if(players_choice == 'a')
        {
            v.tell("You stare into the ball!");
            v.tell("As you get lost in fond memories you feel your pockets get lighter");
            int money_taken = v.takeGold(2);
            if (money_taken == 2)
            {
                v.tell("You lost 2 entire coins!");
            }
            else{
                v.tell("You lost "+money_taken); 
            }
        }
        else if(players_choice == 'b')
         {
             v.tell("You blow up the bouncy castle quickly!");
             v.tell("Its full of air and beautiful, you feel proud!");
             v.tell("And look! Some gnomes are even enjoying the bounciness of the castle!");
         }

         else if(players_choice == 'c')
         {
             v.tell("You walk close to the dog to pet it");
             v.tell("You pet the dog several times");
             v.tell("It was thankful for the pets and gave you 3 coins!");
             v.giveGold(3);
         }

        v.tell("Which exit would you like to take to leave this god forsaken room");
        String path_exit = "a) North, b) West c) Back from whence you came";
        char[] end_decisions = {'a', 'b', 'c'};
        players_choice = v.getChoice(path_exit , end_decisions);
        
          
        if(players_choice == 'a')
        {
            v.tell("See you North!");
            return Direction.TO_NORTH;
        }
        else if(players_choice == 'b')
        {
            v.tell("See you West!");
            return Direction.TO_WEST;
        }
        else if(players_choice == 'c')
        {
            v.tell("Back you go then");
            return Direction.opposite(d);
        }

        return Direction.opposite(d);
    }
}
