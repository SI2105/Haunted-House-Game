package OOP.ec22612.MP.contributions;

class Room_ec22925 extends Room{
    boolean visited;

    public Direction visit(Visitor vs, Direction directionComing){
        char visitorChoice;
        final Item id = new Item("ID Card");
        final Item sharpener = new Item("Pencil Sharpener");
        final Item sock = new Item("Dirty Old Sock");
        boolean gotNewItem = false;
        Item newItem = null;
        
        printRoom(vs);
        vs.tell("The state of the room is:");

        if(visited){
            vs.tell("visited");
        }
        else{
            vs.tell("not visited");
        }

        visitorChoice = vs.getChoice("Interact: (X), (Y), (Z), (C), (P)", new char[]{'x', 'y', 'z', 'c', 'p'});
        
        switch(visitorChoice)
        {
            case 'x':
                vs.tell("You found an ID!");
                visited = true;
                gotNewItem = true;
                newItem = id;
                break;
            case 'y':
                vs.tell("This is locked! You just lost 3 gold.");
                visited = true;
                vs.takeGold(3);
                break;
            case 'z':
                vs.tell("That's a fancy pencil sharpener!");
                visited = true;
                gotNewItem = true;
                newItem = sharpener;
                break;
            case 'c':
                vs.tell("You played a game of solitaire and won 2 gold!");
                visited = true;
                vs.giveGold(2);
                break;
            case 'p':
                vs.tell("You found a dirty old sock.");
                visited = true;
                gotNewItem = true;
                newItem = sock;
                break;
            default:
                vs.tell("That's invalid input");
                visited = false;
                break;
        }
        
        if(gotNewItem == true)
        {
            if(vs.hasIdenticalItem(newItem) || vs.hasEqualItem(newItem))
            {
                vs.tell("Unfortunately you have a similar item already so you will not be granted this one!");
            }
            else
            {
                vs.giveItem(newItem);
            }
        }
        
        Direction dirrectionLeaving = Direction.opposite(directionComing);
        return dirrectionLeaving;
    }
    
    public void printRoom(Visitor vs){
        vs.tell("__ _____ ____ _____ ______ _______ _____ ______ ______ ______ ___");
        vs.tell("__]_____]____]_____]______]_______]_____]______]______]______]___]");
        vs.tell("             _                       _______  |||\"||;;|.||##||=|||");
        vs.tell("  _                           _     |   *  3| |||-|| =|-||==||+|||");
        vs.tell("  ____________       _              |       | |||_||__|_||__||_|||");
        vs.tell("|`.   --__     `.        _______    |       | ||================||");
        vs.tell("|  `._____________`.  .'|.-----.|   _ ======| ||| | -|&|^^|!!|-|||");
        vs.tell("|   | .-----------.| |  ||     ||  (o))   _ | ||| |**|=|+-|##|=|||");
        vs.tell("|   | |  .-------.|| |  ||  C  ||  /||   / \\`._|  .-.|_|__|__|_|||");
        vs.tell("|   | |  |    X  |||_`..|'_____'| //||___\\_/.'\\| (( ))==========||");
        vs.tell("|   | |`.|  ==== ||| | `---------(o)||         \\  /-'-=|+|.-|-'|||");
        vs.tell("|`. | |`.|_______|||/|______________||__.--._ (o)/|=|;:|-|&&|&&|||");
        vs.tell("|  `|_|===========||_|                 (____)-.'(o)_|__|_|__|__|||");
        vs.tell("|   | |  .-------.||                           `._\\=============||");
        vs.tell("|   | |  |    Y  |||                             `.     |       ||");
        vs.tell("|   | |`.|  ==== |||`._____________________________`.  o|o  P   ||");
        vs.tell("|`. | |`.|_______||| |._.----------------.__.-------.|__|_______||");
        vs.tell("|  `|_|===========|| || '----------------'  | .---. ||  __");
        vs.tell("|   | |  .-------.|| ||               |     |_______||.'\\.'.");
        vs.tell("|   | |  |    Z  ||| || ______________|     | .---. ||'.__.'");
        vs.tell("|   | |`.|  ==== ||| ||                `.   |_______|||  _ |");
        vs.tell(" `. | |`.|_______||| ||                  `. | .---. |||_  ||");
        vs.tell("   `|_|===========||`||                    `|_______|||____|");
        vs.tell("                       `.                    `.");
        vs.tell("                         `.____________________`.");   
    }
}
