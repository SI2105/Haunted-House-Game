package OOP.ec22612.MP.contributions;

class Room_ec22764 extends Room
{
    static final Item Flashlight = new Item("Flashlight_ec22764");
    // Initialising variables
    public static boolean BookShelfOpen = false;
    public static boolean CabinetDrawOpen = false;
    public static boolean FlashlightFound = false;
    public static boolean FirstTimeEntering = true; 

    public Direction visit(Visitor visitor, Direction direction) 
    {
         
        // If user has completed all the tasks
        if(BookShelfOpen == true && CabinetDrawOpen == true)
        {
            visitor.tell("You have entered an abandoned library.");
            visitor.tell("It has been trashed, you will find nothing in here.");
        }
        
        
        // If it's the user's first time entering the room
        else if(FirstTimeEntering == true)
        { 
            visitor.tell("You scan the room but everything looks dusty and damaged.");
            visitor.tell("In front of you, there's a bookshelf filled with books but a red book capturing your eye.");
            visitor.tell("To the left of the room, there's a short cabinet of draws.");
            char [] option = {'a', 'b', 'c'};
            char choice = visitor.getChoice("Do you a) leave the library b) inspect the bookshelf c) inspect the cabinet?", option);
        
            while(choice == 'a' || choice =='b' || choice == 'c')
            {
                if(String.valueOf(choice).contains("a"))
                {
                    visitor.tell("You have decided to leave the library.");
                    break;
                }
        
                else if(String.valueOf(choice).contains("b"))
                {
                    visitor.tell("As you inspect the bookshelf, a spider jumps out of nowhere and you almost fall. You decide to come back later.");
                    break;
                }
                
                else if(String.valueOf(choice).contains("c"))
                {
                    visitor.tell("As you inspect the cabinet, you look at how damaged it is with dents all around.");
                    OpenDraw(visitor);
                    break;
                }
                
                else
                {
                    visitor.tell("Select either a, b or c");
                    choice = choice;
                }
                
                FirstTimeEntering = false;
            }
        }       
        // If user re-enters the room for the second time
        else if(FirstTimeEntering == false)
        {
            if (FlashlightFound == false)
            {
                visitor.tell("You re-enter the library and walk towards the cabinet on the left.");
            
                // Makes them interact with the cabinet
                if(CabinetDrawOpen == false)
                {
                    OpenDraw(visitor);
                }      
            }
            
            else
            {
                visitor.tell("All of a sudden, the lights in the library turn off.");
                
                if(BookShelfOpen == false)
                {
                    RedBook(visitor);
                }
                
            }
            
        }
          
        
        return Direction.opposite(direction);
    }

    
    private static void OpenDraw(Visitor visitor)
    {
        visitor.tell("You look at the cabinet and realise the draws have not been opened.");
        char[] option2 = {'Y', 'N'};
        char choice = visitor.getChoice("Would you like to open the draws? Y or N", option2);
                          
        if(choice == 'Y')
        {
            visitor.tell("You find a flashlight and three pieces of gold. This will come in handy later.");
            visitor.giveGold(3);
            visitor.giveItem(Flashlight);
            FlashlightFound = true;
            CabinetDrawOpen = true;
        }
                          
        else
        {
            visitor.tell("The draws remain unopened. However, you have a gut feeling you should've opened it.");
        }

    }
        
    
    private static void RedBook(Visitor visitor)
    {
        visitor.tell("You open the red book and find it has a keylock inside.");
        
        if(visitor.hasEqualItem(new Item("Key_ec22770")))
        {
            visitor.tell("You found a key from a previous room that may reveal what's in the red book.");
            visitor.tell("You use the key you found and unlock it, finding 5 pieces of gold!");
            visitor.giveGold(5);
            BookShelfOpen = true;
        }
        
        else
        {
            visitor.tell("To reveal what may lie in the red book, find a key in another room.");
            visitor.tell("You decide to return back once you have acquired the necessary key.");
        }
        
    }
    
}

