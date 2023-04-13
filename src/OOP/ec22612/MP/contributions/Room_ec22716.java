package OOP.ec22612.MP.contributions;

// abstract class Room implements Visitable { }
class Room_ec22716 extends Room {

static final Item shark = new Item("shark");
static final Item hairbrush = new Item("hairbrush");
static final Item poisonedcake = new Item("poisoned cake");
static final Item enchantedmirror = new Item("enchanted mirror");

    
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        // Display a welcome message to the visitor
        visitor.tell("Welcome!!This is Room_ec22716");
        visitor.tell("In this room there are the following items to choose from to purchase:a shark,a hairbrush,poisonedcake and an enchanted mirror");
        visitor.tell("For every good item you find you will be rewarded with gold, for every bad item you choose you will lose gold.");
        visitor.tell("Choose wisely only one item can be selected at time....");
        
        // Ask the visitor to make a choice
        char[] options = {'N', 'E', 'S', 'W'};
        String optionsdescription = "Select one of the following: N, S, E, W";
        char choice = visitor.getChoice(optionsdescription, options);
            
        // Interact with the visitor based on their choice
         if (choice == 'N') {
            visitor.tell("You chose to go North.");
             if (visitor.hasIdenticalItem(shark) == true) {
                visitor.tell("You can't pick an item twice!");
            } 
                visitor.giveItem(shark);
                visitor.takeGold(2);
                visitor.tell("Oh, no!You have selected the bad item: shark. You have lost 2 gold pieces.");
            }
        else if (choice == 'E') {
            visitor.tell("You chose to go East.");
            if (visitor.hasIdenticalItem(hairbrush) == true) {
                visitor.tell("You can't pick an item twice!");
            } 
                visitor.giveItem(hairbrush);
                visitor.giveGold(4);
                visitor.tell("Hooray!You have selected the good item: hairbrush. You have gained 4 gold pieces.");
            }
            
        else if (choice == 'S') {  
            visitor.tell("You chose to go South.");
            if (visitor.hasIdenticalItem(poisonedcake) == true) {
                visitor.tell("You can't pick an item twice!");
            } 
                visitor.giveItem(poisonedcake);
                visitor.takeGold(7);
                visitor.tell("Oh, no!You have selected the bad item: poisoned cake. You have lost 7 gold pieces.");
            }
         else if (choice == 'W') {    
            visitor.tell("You chose to go West.");
            if (visitor.hasIdenticalItem(enchantedmirror) == true) {
                visitor.tell("You can't pick an item twice!");
            } 
                visitor.giveItem(enchantedmirror);
                visitor.giveGold(8);
                visitor.tell("Hooray!You have selected the good item: enchanted mirror. You have gained 8 gold pieces.");
            }
        else {
            visitor.tell("Invalid choice.");
        }
        
        // Return the direction in which the visitor leaves
        if (choice == 'N') {
            return Direction.TO_NORTH;
        } else if (choice == 'E') {
            return Direction.TO_EAST;
        } else if (choice == 'S') {
            return Direction.TO_SOUTH;
        } else if (choice == 'W') {
            return Direction.TO_WEST;
        } else {
            return Direction.UNDEFINED;
        }
        
    }
}

