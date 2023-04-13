package OOP.ec22612.MP.contributions;

class Room_ec221156 extends Room {

    static final Item key = new Item("Key");
    static final Item map = new Item("Map");
    static Boolean PresentedItem = false;
    static Boolean firstvisit = false;
    static Boolean quizStatus = false;
    


    public Direction visit (Visitor visitor, Direction d) {

        visitor.tell("Welcome to the cistern below Queen Mary University of London. There is a hidden door somehwere in the cistern. There is a student trapped behind the door (Zahid Rahman) and it is your job to save him. There is a map and key you must find to be able to locate and unlock the door. You must hurry! Zahid's life depends on it!");

        visitor.tell("The map and the key are in a box in the room somewhere. Search it to find the items you need");

        char[] options = {'a', 'b', 'c'};

        char choice = visitor.getChoice("Which part of the room do you want to search (a) Zahid's bag (b) The drawers by the bed (c) The Bookshelf", options);
        
        if (choice == 'a') 
        {
            if(PresentedItem == false)
            {
                visitor.giveItem(key);
                visitor.giveItem(map);
                PresentedItem = true;
            }
            else if(visitor.hasEqualItem(key) == false)
            {
                visitor.tell("You found the key so take it. Zahid is waiting!");
                visitor.giveItem(key);
            }
            else if(visitor.hasEqualItem(map) == false)
            {
                visitor.tell("You found the map so take it. Zahid is waiting!");
                visitor.giveItem(map);
            }
        }
        else {
            visitor.tell("The box was not in the location. Please try again in your next visit");
        }

        if (firstvisit == true && quizStatus == false) {
            char[] quiz = {'y', 'n'};
            char quizChoice = visitor.getChoice("You have the opportunity to earn some gold! Take a quiz about Zahid and earn 2 gold coins for every correct answer. Would you like to take the quiz to earn up to 10 gold coins? (y/n)", quiz);

            if (quizChoice == 'y') 
            {
                char qOne = visitor.getChoice("What is Zahid's favourite feature on the Macbook Pro? (a) The keyboard (b) The touchbar (c) The weight", options);
                if (qOne == 'b') 
                {
                    visitor.tell("Correct!");
                    visitor.giveGold(2);
                }
                else 
                {
                    visitor.tell("Incorrect!");
                }

                char qTwo = visitor.getChoice("What is Zahid's favourite movie? (a) Avengers: Endgame (b) Interstellar (c) Bodyguard", options);
                if (qTwo == 'c')
                {
                    visitor.tell("Correct!");
                    visitor.giveGold(2);
                }
                else 
                {
                    visitor.tell("Incorrect!");
                }

                char qThree = visitor.getChoice("What is Zahid's worst module? (a) Object-Oriented Programming (b) Procedural Programming (c) Automata and Formal Languages", options);
                if (qThree == 'a')
                {
                    visitor.tell("Correct!");
                    visitor.giveGold(2);
                }
                else 
                {
                    visitor.tell("Incorrect!");
                }

                char qFour = visitor.getChoice("Who is Zahid's bestfriend? (a) Amal (b) Aylin (c) Harvy", options);
                if (qFour == 'b')
                {
                    visitor.tell("Correct!");
                    visitor.giveGold(2);
                }
                else 
                {
                    visitor.tell("It is blasphemy that you got this question wrong... I am taking gold away from you..");
                    visitor.takeGold(2);
                }

                char qFive = visitor.getChoice("Who is Zahid's boyfriend? (a) Amal (b) Harvy (c) Ifaz", options);
                if (qFive == 'b')
                {
                    visitor.tell("Correct!");
                    visitor.giveGold(2);
                }
                else 
                {
                    visitor.tell("It is blasphemy that you got this question wrong... They have a daughter together... I am taking gold away from you");
                    visitor.takeGold(2);
                }
                quizStatus = true;
            }
            else {
                visitor.tell("Boo! I guess you can take the quiz in your next visit");
            }
        }

        firstvisit = true;
        return d; 
    }
}
