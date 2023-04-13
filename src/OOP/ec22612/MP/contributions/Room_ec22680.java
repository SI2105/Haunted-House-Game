package OOP.ec22612.MP.contributions;

class Room_ec22680 extends Room {
    public Direction visit(Visitor visitor, Direction directionvisitorcomesfrom) {

        final Item MVP = new Item("MVP");

        visitor.tell("Welcome to the ec22680 Room.");

        // Use double quotes for string literals
        
        String routes = ("Who is your favourite Basketball player. \n (L) Larry Bird, (M) Michael Jordan, (S) Shaquille O'Neal, (K) Kobe Bryant, (J) Lebron James, (C) Stephen Curry");
    char[] Basketballplayers = {'L', 'M', 'S', 'K', 'J', 'C'};

    char choice = visitor.getChoice(routes, Basketballplayers);
        
         if(choice == 'L'){
            visitor.tell("Mid");
        }

        else if(choice == 'M'){
            visitor.giveItem(MVP);
        }

        else if(choice == 'S'){
            visitor.tell("Good but not MVP");
        }

        else if(choice == 'K'){
            visitor.tell("Not Quite");
        }

        else if(choice == 'J'){
            visitor.tell("Almost");
        }

        else if(choice == 'C'){
            visitor.tell("Not quite");
        }

        return Direction.opposite(directionvisitorcomesfrom);
    }
} 

