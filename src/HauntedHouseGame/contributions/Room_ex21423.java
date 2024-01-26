package HauntedHouseGame.contributions;

class Room_ex21423 extends Room {
    
    public final Item bible = new Item("Bible");
    public final Item roids = new Item("Anabolic Steroids");
    public final Item glowStick = new Item("Glow Stick");
    public final Item lace = new Item("Shoe Lace");
    public static boolean looted = false;
    
    public int checkIfCanAfford(Visitor v, int price){
        if (v.takeGold(price) == price) return 1;
        else return 0;
        
    }
    public void shop(Visitor v){
        v.tell("If you want to buy something buy it quick I have time to only sell one thing so choose wisely, they're coming for me");
        char[] menu = {'a','b','c','d'};
        char choice =  v.getChoice("Purchase a) Anabolic steroids (10 gold) b) A glow stick (5 gold) c) A shoe lace (1 gold) d) Turn around and leave", menu);
        switch (choice){
            case 'a':
                if (checkIfCanAfford(v,10) == 1){
                     if (v.hasEqualItem(roids) || v.hasIdenticalItem(roids)) v.tell(" Looks like you already have this ");
                     else{ v.giveItem(roids); v.tell("Enjoy your steroids");}
                }
                else v.tell("Why waste my time when you don't have the gold");
            case 'b':
                if (checkIfCanAfford(v,5) == 1){
                     if (v.hasEqualItem(glowStick) || v.hasIdenticalItem(glowStick)) v.tell(" Looks like you already have this ");
                     else{ v.giveItem(glowStick); v.tell("Enjoy your glowstick");}
                }
                else v.tell("Why waste my time when you don't have the gold");
            case 'c':
                if (checkIfCanAfford(v,1) == 1){
                     if (v.hasEqualItem(lace) || v.hasIdenticalItem(lace)) v.tell(" Looks like you already have this ");
                     else{ v.giveItem(lace); v.tell("ok...");}
                }
                else v.tell("Why waste my time when you don't have the gold");
        }
        v.tell("The seller leaves, you should too");
    }

    public Direction visit(Visitor visitor,Direction directionVistorArrivesFrom){
        char visitorChoice;
        if (looted){
            visitor.tell(" You have already been here the boxes are gone ");
            visitorChoice = 'c';
        }
        else{
        visitor.tell(" This room has two boxes, one red and one blue, however you can only open one of them ");
        char[] firstChoices = {'a','b','c'};
        visitorChoice = visitor.getChoice(" Do you want to a) Open red box b) Open blue box c) Leave", firstChoices);
        }
        switch (visitorChoice) {
            case 'a':
                visitor.tell("There was a bible in the red box and a single piece of gold");
                visitor.giveGold(1);
                if (visitor.hasEqualItem(bible) || visitor.hasIdenticalItem(bible)) visitor.tell(" Looks like you already have one ");
                else{ visitor.giveItem(bible); }
                looted = true;
                break;
            case 'b':
                visitor.tell(" 5 kids jump out the box and take 10 of your gold ");
                visitor.takeGold(10);
                looted = true;
                break;
        }
        char[] yesOrNo = {'y','n'};
        visitorChoice = visitor.getChoice("Before you leave you see a merchant arrive into the room do you approach him? [y/n]", yesOrNo);
        if (visitorChoice == 'y') shop(visitor);
        char[] directionChoices = {'a','b','c','d'};
        char leaving = visitor.getChoice(" Leave via a) North b) East c) South d) West ", directionChoices);
        switch (leaving) {
            case 'a':
                return Direction.TO_NORTH;
            case 'b':
                return Direction.TO_EAST;
            case 'c':
                return Direction.TO_SOUTH;
            case 'd':
                return Direction.TO_WEST;
                }     
        
        return null;
    }
    
}
