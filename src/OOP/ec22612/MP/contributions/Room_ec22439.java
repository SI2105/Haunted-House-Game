package OOP.ec22612.MP.contributions;

class Room_ec22439 extends Room
{
    
    public Direction visit(Visitor v, Direction d)
    {
        System.out.println("Welcome to the Trophy Room!");
        
        char[] itemChoices = {'T', 'S', 'N'};
        char choice = v.getChoice("Which item do you want?", itemChoices);

        Item item;
        if (choice == 'T') {
            item = new Item("Treasure");
        } else if (choice == 'S') {
            item = new Item("Sword");
        } else {
            item = new Item("Nothing");
        }

        if (v.hasIdenticalItem(item)) {
            System.out.println("You already have this item!");
        } else if (v.hasEqualItem(item)) {
            System.out.println("You already have an item with the same name!");
        } else {
            boolean itemAccepted = v.giveItem(item);
            if (itemAccepted) {
                System.out.println("Item accepted!");
            } else {
                System.out.println("Item rejected!");
            }
        }
        
        return d.opposite(d);
    }
}

