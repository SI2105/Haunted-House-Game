package OOP.ec22612.MP.contributions;

class Room_ec22899 extends Room
{
    
    Boolean CupboardEmpty = false;
    Boolean TelevisionOn = false;
    
    public Direction visit(Visitor visitor, Direction directionArrived)
    {   
        if (TelevisionOn == false)
        {
            String message = "There is a cupboard in front of me with a lit candle to its left. There is also an old style television with the remote to my left. The room is dark.";
            visitor.tell(message);
        }
        
        else
        {
            String message = "There is a cupboard in front of me with a lit candle to its left. There is also an old style television with the remote to my left. There is a strange creature in the corner of the room";
            visitor.tell(message);
        }
        
        
        if (TelevisionOn == true && CupboardEmpty == true)
        {
            String choiceDescription = "A. Leave the room";
            char[] choicesArray = {'A'};
            char user_choice = visitor.getChoice(choiceDescription,choicesArray);

            if (user_choice == 'A')
            {
                return directionArrived.opposite(directionArrived);

            }

        }
        
        String choiceDescription = "A. Open the cupboard B. Turn on the television C. Leave the room";
        char[] choicesArray = {'A','B','C'};

        char user_choice = visitor.getChoice(choiceDescription,choicesArray);
    
        
        if (user_choice == 'A')
        {
            if (CupboardEmpty == false)
            {
            visitor.tell("You have acquired 3 Gold pieces");
            visitor.giveGold(3);
            
            CupboardEmpty = true;
            
            }
            else
            {
                visitor.tell("Cupboard is empty");
            }
            
            String choiceDescriptionOne = "A. Turn on the television B. Leave the room";
            char[] choicesArrayOne = {'A','B'};
            
            char user_choiceOne = visitor.getChoice(choiceDescriptionOne,choicesArrayOne);
            
            if (user_choiceOne == 'A')
            {
                if (TelevisionOn = false)
                {
                    TelevisionOn = true;
                    visitor.tell("The television is fuzzing. I can see a strange creature in the corner of the room now. I should probably leave");
                    
                    String choiceDescriptionTwo = "A. Leave the room";
                    char[] choicesArrayTwo = {'A'};
                    
                    char user_choiceTwo = visitor.getChoice(choiceDescriptionTwo,choicesArrayTwo);
                    
                    if (user_choice == 'A')
                    {
                        return directionArrived.opposite(directionArrived);

                    }
                
                }
            }
            
            else
            {
                return directionArrived.opposite(directionArrived);
            }

        }
        
        else if (user_choice == 'B')
        {
        
            TelevisionOn = true;
            visitor.tell("The television is fuzzing. I can see a strange creature in the corner of the room now. I should probably leave");

            String choiceDescriptionThree = "A. Leave the room";
            char[] choicesArrayThree = {'A'};
            char user_choiceThree = visitor.getChoice(choiceDescriptionThree,choicesArrayThree);

            if (user_choice == 'A')
            {
                return directionArrived.opposite(directionArrived);

            }
        }
        
        else
        {
            return directionArrived.opposite(directionArrived);
        }
        
        return directionArrived.opposite(directionArrived);
        
        
    }
}
