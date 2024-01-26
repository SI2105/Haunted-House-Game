package HauntedHouseGame.contributions;

import java.util.Random;
    
    class Room_ec22982 extends Room
    {
        //This is a letter they find in the room
        static final Item Letter = new Item("Letter");
        
        //condition variables so that an event only happens once in the room
        
        static boolean firstvisit = true;
        static boolean isTheShelfInSight = false;
        static boolean isThereAChair = false;
        static boolean isTheLightBulbWorking = false;
        static boolean isTheDeskOpen = false;
        
        public Direction visit(Visitor visitor, Direction into_the_room)
        {
            if(isTheShelfInSight == true && isTheLightBulbWorking == true && isTheDeskOpen == true)
            {
                visitor.tell("Someone has already been in the room.");
                visitor.tell("Please leave the room immediately!");
            }
            
            //first visit into the room
            else if(firstvisit == true)
            {
                visitor.tell("Welcome to Winchester Mystery House.");
                visitor.tell("We are delighted to have you!");
                visitor.tell("Would you like to: ");
                
                char [] menu = {'a', 'b', 'c'};
                char option = visitor.getChoice("(a) exit the room (b) have a seat at the desk (c) take a walk around the room and see what is in it", menu);
                
                //checks the different choices input
                switch(option)
                {
                    case 'a':
                        visitor.tell("Goodbye");
                        break;
                        
                    case 'b':
                        visitor.tell("Please take a seat on the chair.");
                        break;
                        
                    case 'c':
                        visitor.tell("You notice that the lightbulb isn't working so it is quite difficult to see what is in the room clearly.");
                        FixTheLight(visitor);
                        break;
                }
                
                firstvisit = false;
            }
            
            //re-entry into the room
            else if(firstvisit == false)
            {
            //diffent messages depending on the state of the room 
                if(isTheShelfInSight == false)
                {
                    visitor.tell("You re-enter the room and notice the a wooden structure in the corner of the room.");
                    
                    if(isTheDeskOpen == false)
                    {
                        int number = (new Random ()).nextInt(2);
                        
                        if(number == 0)
                        {
                            FixTheLight(visitor);
                        }
                        else 
                        {
                            OpenTheDesk(visitor);
                        }
                    }
                    else
                    {
                        FixTheLight(visitor);
                    }
                }
                else
                {
                    visitor.tell("You trip on a wire as the room is really dark.");
                    
                    if(isTheDeskOpen == false)
                    {
                        OpenTheDesk(visitor);
                    }
                    
                    if(isTheLightBulbWorking == false)
                    {
                        WalkToShelf(visitor);
                    }
                }
            }
            
            return Direction.opposite(into_the_room);
            
        }
        
        //method that prompts you to fix the light 
        void FixTheLight(Visitor visitor)
        {
            char [] menu = {'Y', 'N'};
            char option = visitor.getChoice("Would you like to fix the lightbulb? (Y) or (N). The light might help you see better around the room.", menu);
            
            if (option == 'Y')
            {
                visitor.tell("You fix the the lightbulb and turn the light on.");
                visitor.tell("You notice the the sack of gold in the desk.");
            }
            
            else
            {
                visitor.tell("The room remains dark and you struggle to navigate around the room.");
            }
            
        }
        
        //method that prompts the user to walk to the shelf and check what is on it 
        void WalkToShelf(Visitor visitor)
        {
            if(visitor.hasEqualItem(new Item("A letter from the owner of Winchester House")))
            {
                visitor.tell("You have found a letter from Lord Winchester on the shelf.");
                visitor.tell("The letter states that there is gold hidden in the room for you to win if you find it");
                int gold = 1 + (new Random()).nextInt(10);
                visitor.giveGold(gold);
                isTheLightBulbWorking = true;
            }
            else 
            {
                visitor.tell("To see what items are on the shelf you need to fix the lightbulb.");
            }
            
        }
        
        //method that prompts the user to check the contents of the bag in the drawer
        void OpenTheDesk(Visitor visitor)
        {
            visitor.tell("You see a bag in the drawer behind the box of lightbulbs");
            char [] menu = {'Y', 'N'};
            char option = visitor.getChoice("Would you like to check the contents of the bag?", menu);
            
            if(option == 'Y')
            {
                visitor.tell("The bag has 10 pieces of gold in it and a letter from Lord Winchester with instructions on it.");
                visitor.giveGold(7);
                visitor.giveItem(Letter);
                isTheDeskOpen = true;
            }
            else 
            {
                visitor.tell("You close the desk and walk towards the door with a lingering thought of what the bag contained. I guess you'll never know.");
            }
        }
    }
