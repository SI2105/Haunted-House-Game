package OOP.ec22612.MP.contributions;

class Room_ec22902 extends Room {
    //Create Some Items, Declare & Initalise Item Array
    static final Item Hammer = new Item("Hammer");
    static final Item safeKey = new Item ("safeKey");
    static final Item Knife = new Item ("Knife");
    char[] Selection = {'a','b','c'};

    // Initialise Some Room Characteristics
    boolean lightsOn = false;
    boolean lockedSafe = true;

    public Direction visit(Visitor visitor, Direction direction){
        Direction endDirection = Direction.opposite(direction);
        
        //tells user about the room
        visitor.tell("You have entered a creepy room");
        if (lightsOn = false){visitor.tell("The Lights Are Off");}
        visitor.tell("Oh no! Looks like 2 gold has gone missing");
        visitor.takeGold(2);

        String Picker = ("What do you wanna do? \na)Creep Around The Room \nb)Fix The Lights \nc) Open the rusty Case");

        char userOption = visitor.getChoice(Picker, Selection);

        //option A
        if (userOption == 'a'){
            visitor.tell("Someones Feeling Brave, I wonder What You'll Come Across");
            visitor.tell("Looks Like Theres A Pile Of Items, But You Only Have Space For One Item");
            Picker = ("a) A Hammer, Who Knows When That Could Come In Handy \nb) A Key, Must be For that Safe In the Corner \nc) A Knife, Really Who Left This Here??");
            visitor.tell("So What Do You Want To Take?");

            char userItemChoice = visitor.getChoice(Picker, Selection);
            if (userItemChoice == 'a'){visitor.giveItem(Hammer);}
            else if (userItemChoice == 'b')
            {
                visitor.giveItem(safeKey);
                visitor.tell("Do You Want To Open The Safe? It'll Cost You A Gold");
                Picker = ("a) Open the Safe\nb)Dont Open the Safe \nc)Try Opening without the Key");
                char userSafeChoice = visitor.getChoice(Picker, Selection);
                if (userSafeChoice == 'a')
                {
                    visitor.takeGold(1);
                    visitor.tell("You Found 4 Gold!");
                    visitor.giveGold(4);
                }
                else if (userSafeChoice == 'b')
                {
                    visitor.tell("Safe Choice");
                }
                else if (userSafeChoice == 'c')
                {
                    visitor.tell("You Found 4 Gold");
                    visitor.giveGold(4);
                }
                
            }
            else if (userItemChoice == 'c'){visitor.giveItem(Knife);}
            else{visitor.tell("Looks Like a,b or c is too hard for you, too bad!");}
        }
        //option B
        else if (userOption == 'b'){
            visitor.tell("You Fixed The Lights! ");
            visitor.tell("Looks Like Something is shimmering in the light");
            visitor.tell("You found Some Gold On The Floor");
            lightsOn = true;
            visitor.giveGold(2);
        }

        //option C 
        else if (userOption == 'c'){
            visitor.tell("This Old Case Is Hard To Open");
            visitor.tell("But Looks Like Its Worth It You Found 8 Gold!");
            visitor.giveGold(5);
        }
        else{
            visitor.tell("Unknown Choice");}

        return endDirection;
    }
    
}
