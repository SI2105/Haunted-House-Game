package HauntedHouseGame.contributions;

public class Room_ec22646 extends Room {

    static final Item key = new Item ("Key");
    static final Item locket = new Item ("Locket");
    static Boolean PresentedItem = false;
    static Boolean quizStatus = false;

    public Direction visit (Visitor visitor, Direction d){

        visitor.tell("Welcome to Saver. Your task is to save Harry Styles." +
                             "There is a portal inside the room. To gain access to it you must find the key and locket that are hidden inside the room." +
                             "The key is used to open the portal and the locket is used to get back" +
                             "The portal will take you to the cliff where Harry is about to fall." + 
                             "Your task is to save Harry." +
                             "Best of Luck!" );

        char[] arrayOfPossibleChoices = {'a', 'b', 'c'};
        char choice = visitor.getChoice("You have to start by searching the room to find the key" + 
                           "You have three options of where to search (a) Narnia book in the bookshelf, (b) Under the blue rug, (c) Under the bed {a, b, c}", arrayOfPossibleChoices);
        
        if (choice == 'a') {

            if(PresentedItem == false){
                visitor.giveItem(key);
                visitor.giveItem(locket);
                PresentedItem = true;
            }
        else if(visitor.hasEqualItem(key)== false){

            visitor.tell("You found the key so you can now open the portal and go to Harry.");
            visitor.giveItem(key);
        }
        else if(visitor.hasEqualItem(locket)== false){
            visitor.tell("You found the locket so you can go back to the room.");
            visitor.giveItem(locket);
        }
    else {
        visitor.tell("The items were not in that location. Please try again");
    }
   
    if(quizStatus == false) {

        char[] quiz = {'y', 'n'};
        char quizChoice = visitor.getChoice("If you take the quiz you can earn some gold and buy yourself and Harry a dinner. For every correct answer you get 5 gold coins. Do you want to attempt? (y/n)", quiz);
    
    if (quizChoice == 'y'){

        char questionOne = visitor.getChoice("What is Harry's full name? a) Harold Emmett Styles, b) Harry Ethan Styles, c) Harry Edward Styles", arrayOfPossibleChoices);
   
        if (questionOne == 'c') 
        {
            visitor.tell("Correct!");
            visitor.giveGold(5);
        }
        else 
        {
            visitor.tell("Incorrect!");
        }

        char questionTwo = visitor.getChoice("What day was he born? a) February 1st 1994, b) May 16th 1995, c) December 26th 1995", arrayOfPossibleChoices);
   
        if (questionTwo == 'a') 
        {
            visitor.tell("Correct!");
            visitor.giveGold(5);
        }
        else 
        {
            visitor.tell("Incorrect!");
        }

        char questionThree = visitor.getChoice("What song was his first solo release to? a) Sign of the Times, b) Watermelon Sugar, c) Golden", arrayOfPossibleChoices);

        if (questionThree == 'b') 
        {
            visitor.tell("Correct!");
            visitor.giveGold(5);
        }
        else 
        {
            visitor.tell("Incorrect!");
        }
   
        char questionFour = visitor.getChoice("What was the name of Harry's band before 1D? a) White Eskimo, b) Purple Clouds, c) Hot Vs. Cold", arrayOfPossibleChoices);
   
        if (questionFour == 'a') 
        {
            visitor.tell("Correct!");
            visitor.giveGold(5);
        }
        else 
        {
            visitor.tell("Incorrect!");
        }
   
        char questionFive = visitor.getChoice("What was the name of the bakery where Harry worked? a) Magnolia Bakery, b) St. Phillips Bakery, c) W. Mandeville Bakery", arrayOfPossibleChoices);
   
        if (questionFive == 'c') 
        {
            visitor.tell("Correct!");
            visitor.giveGold(5);
        }
        else 
        {
            visitor.tell("Incorrect!");
        }

        char questionSix = visitor.getChoice("What was Harry planning to study before the X Factor? a) History, b) Law, c) English Lit.", arrayOfPossibleChoices);
   
        if (questionSix == 'b') 
        {
            visitor.tell("Correct!");
            visitor.giveGold(5);
        }
        else 
        {
            visitor.tell("Incorrect!");
        }

        char questionSeven = visitor.getChoice("which of these movies is Harry's all time favourite movie? a) The Last Song, b) Batman Begins, c) Love Actually.", arrayOfPossibleChoices);
   
        if (questionSeven == 'c') 
        {
            visitor.tell("Correct!");
            visitor.giveGold(5);
        }
        else 
        {
            visitor.tell("Incorrect!");
        }
    quizStatus = true;
    }
    
    else {
        visitor.tell("So no bonding time for you?");
    } 
    
}


        }
        return d;
    }
}
