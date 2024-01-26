package HauntedHouseGame.contributions;

class Room_ec22814 extends Room {
    
    boolean lights=false;
    boolean clean=false;
    boolean curtainsOpen=false;
    boolean trapdoorOpen=false;
    Item revolver = new Item("revolver");
    Item key = new Item("key");
    Item diary = new Item("diary");
        
    public Direction visit(Visitor visitor,Direction directionVistorArrivesFrom)
    {
        char[] choices = {'a','b','c','d'};
        
        visitor.tell("Welcome to my room, what do you see?");
        visitor.tell("a) The lights are off, the room is dirty and the curtains are closed");
        visitor.tell("b) The lights are on, the room is clean and the curtains are closed");
        visitor.tell("c) The lights are off, the room is clean and the curtains are closed");
        char choice = visitor.getChoice("d) Nothing",choices);
        
        if (choice=='a')
        {
            choicea(visitor);
        }
        else if (choice=='b')
        {
            lights=true;
            clean=true;
            choiceb(visitor);
        }
        else if (choice=='c')
        {
            clean=true;
            choicec(visitor);
        }

        visitor.tell("goodbye...");
        return Direction.opposite(directionVistorArrivesFrom);
    }
    
    
    void choicea(Visitor visitor)
    {
        char[] choicesa={'a','b'};
        char answer='b';
        char answer2;
        
        visitor.tell("You feel your pockets get heavier as you walk in and you realise you now have 2 gold!");
        visitor.giveGold(2);
        visitor.tell("Theres a little goblin sitting on the desk infront of you");
        
        if (!(visitor.hasIdenticalItem(revolver)))
        {
            answer=visitor.getChoice("He conviently offers you two pieces of gold for his revolver a)Accept b)Refuse",choicesa);
        }
        
        if (answer=='a')
        {
            visitor.takeGold(2);
            visitor.giveItem(revolver);
        }
        
        if (visitor.hasIdenticalItem(revolver))
        {
            answer=visitor.getChoice("Do you want to try rob the goblin...? a) Yes b) No",choicesa);
            if (answer=='a')
            {
                visitor.tell("The goblin instantly surrendders and hands you over 8 pieces of gold!");
                visitor.giveGold(8);
                answer2=visitor.getChoice("You turn around and the goblin pulls out a shotgun! a) Shoot b) run",choicesa);
                if (answer2=='a')
                {
                    visitor.tell("You turn around, pull out your revolver and pull the trigger...");
                    visitor.tell("But the revolver is empty...");
                    visitor.tell("The goblin forcefully takes 8 gold back and anymore it finds and you leave");
                    visitor.takeGold(10);
                }
                else
                {
                    visitor.tell("You start running out of the room and drop 4 pieces of gold on your way out");
                    visitor.takeGold(4);
                }
            }
            else
            {
                visitor.tell("The goblin decides to tip you two pieces of gold for being such a nice customer");
                visitor.giveGold(2);
                visitor.tell("You leave");
            }    
                    
        }
        else
        {
            visitor.tell("You leave the room as the goblin stares you down");
        }
            
    }
    
    void choiceb(Visitor visitor)
    {
        char[] choicesb={'a','b'};
        char answer=visitor.getChoice(" Theres a suspicious cupboard, do you want to open it?  a) yes b) no", choicesb);
        
        if (answer=='a')
        {
            visitor.tell("It seems a secret room has been revealed ");
            answer=visitor.getChoice("Theres five gold on the shelf infront of you, will you take it? a) yes b)no",choicesb); 
            if (answer=='a')
            {
                visitor.tell("You thief...");
                visitor.giveGold(5);
                visitor.tell("You leave the room");
            }
            else 
            {
                visitor.tell("You leave the gold but notice a key by your foot.");
                answer=visitor.getChoice("will you take it? a) yes b)no",choicesb); 
                if (answer=='a')
                {
                    visitor.giveItem(key);
                }
                visitor.tell("You leave the room");
            }
        }
        else
        {
            visitor.tell("You leave the room");
        }
    }
    
    void choicec(Visitor visitor)
    {
        trapdoorOpen=true;
        char[] choicesc={'a','b'};
        char answer=visitor.getChoice("Theres a trapdoor on the floor and it's already open, do you go down? a)yes b)no", choicesc);
        
        if (answer=='a')
        {
            answer=visitor.getChoice("Theres a basement down here, but it's empty, continue searching? a) yes b) no", choicesc); 
            if (answer=='a')
            {
                visitor.tell("You found 3 pieces of gold!");
                visitor.giveGold(3);
                visitor.tell("You leave the basement and the room");
            }
            else 
            {
                if (visitor.hasIdenticalItem(key))
                {
                    visitor.tell("You notice a keyhole in the desk, you put your key in");
                    visitor.tell("You found 10 gold and some kind of diary!");
                    visitor.giveGold(10);
                    visitor.giveItem(diary);
                }
                visitor.tell("You leave the basement and the room");
            }
        }
        else
        {
            visitor.tell("You leave the basement and the room");
        }
    }
                
        
}
