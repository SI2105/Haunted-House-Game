package OOP.ec22612.MP.contributions;

class Room_ec22791 extends Room {
    
    static final Item book= new Item("book"); // new book item
    static final Item box= new Item("box"); // new box item

    public Direction visit(Visitor visitor, Direction directionVisitor){

        visitor.tell("You have entered Aurora's room."); // Description of room and what to do in the room. It's about luck in this room.
        visitor.tell("This room is empty with only a few items where you may find gold coins hidden within. BUT, be aware that this gold can be snatched off of you.");
        visitor.tell("If you manage to gain gold coins then you can keep exploring the room until you have gained 10 coins. If you do not find coins or lose your coins then you will forcefully exit the room.");
        
        char [] choices = {'a', 'b'}; //the different choices 
        char [] finalChoices= {'x', 'y'};

        if (directionVisitor== Direction.FROM_NORTH){ //entering from the north 
            visitor.tell("You have arrived from the north entrance.");
            char choiceNorth= visitor.getChoice("You can either explore: a) The old dusty piano | b) the melting candle.", choices);

            if (choiceNorth== 'a'){ // if you choose the piano then you gain no gold and go right back out of the room 
                visitor.tell("You are now exploring the old piano.");
                visitor.tell("You have not found any gold...Maybe next time.");
                return Direction.TO_NORTH;
            }
            else if (choiceNorth== 'b'){ // if you choose the candle then you get 5 coins and keep exploring
                visitor.tell("The candle is lit and the wax is melting.");
                visitor.tell("You have found 5 gold coins!!! They are yours now and let's keep exploring.");
                visitor.giveGold(5);
            }
        }
        else if (directionVisitor== Direction.FROM_EAST){ // entering from the east 
            visitor.tell("You have arrived from the east entrance.");
            char choiceEast= visitor.getChoice("You can either explore: a) The wardrobe | b) A treasure chest ", choices); 

            if (choiceEast== 'a'){ // this choice allows you to gain 5 coins 
                visitor.tell("Congratulations, you did not fall for the trap! You have gained 5 gold coins!");
                visitor.giveGold(5);
            }
            else if (choiceEast== 'b'){ // this choice is a trap and you exit the room. 
                visitor.tell("You have fallen on the trap. There is no treasure in this treasure chest. Try harder next time.");
                return Direction.TO_EAST;
            }
        } 
        else if (directionVisitor== Direction.FROM_SOUTH){ // entering from the south 
            visitor.tell("You have arrived from the south entrance.");
            char choiceSouth= visitor.getChoice("You can either explore: a) A pack of chweing gums | b) a suitcase ", choices); 

            if (choiceSouth== 'a'){ // you win 5 gold coins
                visitor.tell("As you open the pack, you see 5 gold coins, congratulations.");
                visitor.giveGold(5);
            }
            else if (choiceSouth== 'b'){ // you exit immediately due to the ghost
                visitor.tell("You have found 5 gold coins in the suitcase.");
                visitor.giveGold(5);
                visitor.tell("But unfortunately, this suitcase belongs to the room ghost and he will not let you take them, so you lose your 5 coins.");
                visitor.takeGold(5);
                return Direction.TO_SOUTH;
            }
        } 
        else if (directionVisitor== Direction.FROM_WEST){ // The special entrance/exit therefore you directly gain 5 coins
            visitor.tell("You have arrived from the west entrance.");
            visitor.tell("This is the special entrance therefore you gain 5 gold coins directly and you can keep searching the room.");
            visitor.giveGold(5);
        } 

        visitor.tell("Welcome to the final step of your search. If you are here, it means you currently have 5 gold coins and need 5 more to exit from the WEST direction succesfully (the special exit");
        visitor.tell("You will have 2 crucial choices and only one of them will lead you to the right exit.");
        visitor.tell("You have 2 finally items to explore, both similar. One item is a thick old book and the other is a mystery carboard box with 'DO NOT OPEN' written on top.");
        char decision= visitor.getChoice("Would you like to explore the book or the box? ( please enter 'x' or 'y') ", finalChoices); // Last exploring step, 2 choices with a trap. 

        if (decision == 'x'){ // if you choose the book then you believe you have won but the genie steals your gold yet you keep the book as a gift.
            visitor.tell("You have chosen the book. As you open the book you notice 5 gold coins.");
            visitor.tell("You grab the coins and you have won!");
            visitor.giveGold(5);
            visitor.tell("BUT, a genie pops out of the book, turn off the lights in the room and steals all your 10 coins... You return from the direction you came in but you get to the book.");
            visitor.takeGold(10);
            visitor.giveItem(book);
            return directionVisitor;
        }
        else if( decision == 'y'){ // if you choose the box then you win then you win the 5 extra gold coins needed, keeo the box and exit from the West!
            visitor.tell("You have chosen the box.");
            visitor.tell("And you have won the 5 gold coins. You have 10 coins in total and you get to exit from the special exit and get to keep the box! Well done!!");
            visitor.giveItem(box);
            return Direction.TO_WEST;
        }   

        return directionVisitor;
    }

}
