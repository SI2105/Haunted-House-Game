package HauntedHouseGame.contributions;

class Room_ec22443 extends Room
{
    private boolean lightsOff = true;
    private boolean chest1open = false;
    private boolean chest2open = false;
    private boolean chest3open = false;
    private boolean chest4open = false;
    private boolean deskOpen = false;
    private Direction directionVistorArrivesFrom;
    private boolean bedDone=false;

    

    public Direction InRoom(Visitor Visitor,Direction directionVistorArrivesFrom) 
    {
        //visitor is told about the room your in and some thinngs that can be interacted with
        Visitor.tell(" You are now in your room keep your eyes openned and look for keys as there are locked chests everywere!");
        Visitor.tell("have fun with this room");

        if(directionVistorArrivesFrom == Direction.FROM_SOUTH)
        {
            Visitor.tell("You walk in this direction and find a key");
            char choice1 = Visitor.getChoice("keep key?",new char[]{'y','n'});
            
            //if the user enters y then they will be able to interact with a locked chest
            if(choice1 ==  'y')
            {
                chest1open= true;
                char choice2 = Visitor.getChoice("you can see a locked chest, try to open it? (y/n)",new char[]{'y','n'});
                if(choice2 == 'y')
                {
                    chest1open=true;
                    int gotGold = Visitor.takeGold(1);
                    Visitor.tell("you found gold!");
                    
                }
                else{
                    Visitor.tell("you left a chest, you missed out on some gold.");
                }
            }

            else{
                Visitor.tell("You chose to leave the key and now encouner a chest, unlucky for you it is locked; you get no gold!");
            }

            
        }

        //if from east
        else if(directionVistorArrivesFrom == Direction.FROM_EAST){

            Visitor.tell("you encounter the bed and it is a mess.");
            char choice3=Visitor.getChoice("do the bed?(y/n)",new char[]{'y','n'});

            if(choice3=='y')
            {
                
                Visitor.tell("you encounter a key and decide to keep it.");
                char choice4 = Visitor.getChoice("you then encounter a chest under the bed, would you like to open it?(y/n)", new char[]{'y','n'});
                if(choice4 == 'y')
                {
                    chest2open=true;
                    int gotGold = Visitor.takeGold(3);
                    Visitor.tell("you open the chest and found gold!");
                }
                else{
                    Visitor.tell("you missed  missed out on some gold");
                    
                }
            }
            else{
                Visitor.tell("you missed a chest and thus missed out on some gold");
            }
        }
        //if from north
        else if(directionVistorArrivesFrom == Direction.FROM_NORTH){
            Visitor.tell("you encounter the light switch.");
            char choice5=Visitor.getChoice("turn on the light?(y/n)",new char[]{'y','n'});

            if(choice5 =='y')
            {
                Visitor.tell("you encounter a key and decide to keep it.");
                char choice6 = Visitor.getChoice("you then encounter a chest around the switch, would you like to open it?(y/n)", new char[]{'y','n'});
                if(choice6 == 'y')
                {
                    chest3open=true;
                    int gotGold = Visitor.takeGold(3);
                    Visitor.tell("you open the chest and found gold!");
                }
                else{
                    Visitor.tell("you missed  missed out on some gold");
                    
                }
            }
            else{
                Visitor.tell("you missed a chest and thus missed out on some gold");
            }
        
       
        }
        //if from west
        else if(directionVistorArrivesFrom == Direction.FROM_WEST){

            Visitor.tell("you encounter the light switch.");
            char choiceNorth=Visitor.getChoice("turn on the light?(y/n)",new char[]{'y','n'});

            if(choiceNorth =='y')
            {
                lightsOff=false;
                Visitor.tell("you encounter a key and decide to keep it.");
                char choice3 = Visitor.getChoice("you then encounter a chest around the switch, would you like to open it?(y/n)", new char[]{'y','n'});
                if(choiceNorth == 'y')
                {
                    chest4open=true;
                    int gotGold = Visitor.takeGold(3);
                    Visitor.tell("you open the chest and found gold!");
                }
                else{
                    Visitor.tell("you missed  missed out on some gold");
                    
                }
            }
            else{
                Visitor.tell("you missed a chest and thus missed out on some gold");
            }

           
        
            

        } 
        else{
                Visitor.tell("you have not chosen a valid direction to move to");
            }
            
        return directionVistorArrivesFrom;
    }



    @Override
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }}
    
