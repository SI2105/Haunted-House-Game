package OOP.ec22612.MP.contributions;

class Room_ah21407 extends Room {
    
    static final Item MACGUFFIN = new Item("Key");
    
    private boolean chestOpen;
    private boolean cupboardOpen;
    private boolean sealBroken;
    private boolean ghostExorcised;

    public Room_ah21407() {
        chestOpen = false;
        cupboardOpen = false;
        sealBroken = false;
        ghostExorcised = false;
    }
        
    // Returns direction the visitor leaves towards.
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        
        boolean investigation = true;
        char choice;
        
        char[] yn = {'y', 'n'}; // Yes or No
        char[] abcd = {'a','b','c','d'};
        
        if(sealBroken & ghostExorcised) {
            visitor.tell("Ghost appears and states that if you wish safe passage, he demands 2 pieces of golden. Do you comply?");
            choice = visitor.getChoice("y) Yes | n) No", yn);
                if(choice=='y') {
                    visitor.takeGold(2);
                    visitor.tell("You give him the gold and he dissapears.");
                }
                else
                {
                    if(cupboardOpen) {
                        visitor.tell("The ghost tries to attack you but you dodge and run to cupboard. You grab the salt and dash it. The ghost screams in agony and evaporates. The ghost drops a key.");
                        visitor.giveItem(MACGUFFIN);
                        ghostExorcised = true;
                    }
                    else {
                        visitor.tell("You try fight back but it is meaningless. You despair as it has its way with you, robbing 5 pieces of gold. When you see a opening, you dash out the room.");
                        visitor.takeGold(5);
                        return Direction.opposite(directionVistorArrivesFrom);
                    }
                }
        }
        
        visitor.tell("It is a dimmly lit dusty room. You see a chest covered in cobwebs, a small cupboard and strange markings scattered across the room. You investigate. Do you:");
        
        int loop = 0;
        while(investigation==true & (loop<10)) { 
            loop++;
            choice = visitor.getChoice("a) Search chest | b) Open cupboard | c) Investigate strange markings | d) Leave room", abcd);
            
            if(choice=='a') {
                if(!chestOpen) {
                    visitor.tell("The chest is locked. You try your keys.");
                    if(visitor.hasIdenticalItem(MACGUFFIN)) {
                        visitor.tell("The key dropped by the ghost works! There is 10 pieces of gold!");
                        visitor.giveGold(10);
                        chestOpen = true;
                    }
                    else {
                        visitor.tell("Your keys don't work.");
                    }
                }
                else {
                    visitor.tell("The chest has already been looted.");
                }
            } else if(choice=='b') {
                visitor.tell("Inside the cupboard is very empty. There is only a single jar of salt with a label marked ghost busting. Too large to carry you leave it be.");
                cupboardOpen = true;
            } else if(choice=='c') {
                if(!sealBroken) {
                    visitor.tell("You look at the different markings and come across one that sends a shiver down your spine, giving you an eerie feeling. Do you investigate further?");
                    choice = visitor.getChoice("y) Yes | n) No", yn);
                    if(choice=='y') {
                        visitor.tell("You get closer and touch the marking. You get a static shock and suddenly the room starts shaking. A ghost appears. He says his seal has been broken. He threatens you, demanding a money sacrifice of a 2 piece of gold. Do you comply?");
                        sealBroken=true;
                        choice = visitor.getChoice("y) Yes | n) No", yn);
                        if(choice=='y') {
                            visitor.takeGold(2);
                            visitor.tell("You give him the gold and he dissapears.");
                        }
                        else
                        {
                            if(cupboardOpen) {
                                visitor.tell("The ghost tries to attack you but you dodge and run to cupboard. You grab the salt and dash it. The ghost screams in agony and evaporates. The ghost drops a key.");
                                visitor.giveItem(MACGUFFIN);
                                ghostExorcised = true;
                            }
                            else {
                                visitor.tell("You try fight back but it is meaningless. You despair as it has its way with you, robbing 5 pieces of gold. When you see a opening, you dash out the room.");
                                visitor.takeGold(5);
                                investigation = false;
                            }
                        }
                    }
                }
                else {
                    visitor.tell("The seal has been broken, releasing an avaricious ghost. It seems you have to pay a fee sacrifice every time you enter the room now.");
                }
            } else  {
                investigation = false;
            }
        }
        
        visitor.tell("You leave the room.");
        return Direction.opposite(directionVistorArrivesFrom);
        
    }
                
    
}
