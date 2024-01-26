package HauntedHouseGame.contributions;//changes

class Room_ec22546 extends Room {
    
    static final Item smile = new Item("Smile");
    static final Item hairDye = new Item("Hair Dye");
    static final Item facePaint = new Item("Face Paint");
    
    public Direction visit (Visitor visitor, Direction arriving) {
        
        visitor.tell("You have entered the Joker's dress up chamber."); 
        
        char [] options = {'Y', 'N'};
        
        String QPart1 = "Would you like ";
        String QPart2 = "? [Please enter Y or N]";
        
        
        // First Task
        String first = QPart1 + "a smile" + QPart2;
        
        char firstChoice = visitor.getChoice(first, options);
        
        boolean firstPicked = false;
        while (firstPicked = false)
        {
            if (firstChoice == 'Y') 
            {
                visitor.tell("Excellent choice!");
                visitor.giveItem(smile);
                visitor.giveGold(10);
                firstPicked = true;
            }
            
            else
            {
                visitor.tell("No smile?! Why So Serious? Try Again.");
            }
        }
        
        
        //Second Task
        String second = QPart1 + "hair dye" + QPart2;
        
        char secondChoice = visitor.getChoice(second, options);
        
        boolean secondPicked = false;
        while (secondPicked = false)
        {
            if (secondChoice == 'Y')
            {
                visitor.tell("Amazing!");
                visitor.giveItem(hairDye);
                visitor.giveGold(10);
                secondPicked = true;
            }
            
            else
            {
                visitor.tell("No hair dye?! Why So Serious? Try Again.");
            }
        }
        
        
        //Third Task
        String third = QPart1 + "face paint" + QPart2;
        
        char thirdChoice = visitor.getChoice(third, options);
        
        boolean thirdPicked = false;
        while (thirdPicked = false)
        {
            if (thirdChoice == 'Y')
            {
                visitor.tell("Incredible!");
                visitor.giveItem(facePaint);
                visitor.giveGold(10);
                thirdPicked = true;
            }
            
            else
            {
                visitor.tell("No face paint?! Why So Serious? Try Again.");
            }
        }
        
        
        //End of Tasks
        
        visitor.tell("Now you're ready!");
        visitor.takeGold(30);
        visitor.tell("You didn't really think I'd reward you for making the RIGHT choice... did you?\r\nHA\r\nHA\r\nHA!");
        
        return Direction.opposite(arriving);
    }
}
