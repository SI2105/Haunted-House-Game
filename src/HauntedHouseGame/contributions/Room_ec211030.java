package HauntedHouseGame.contributions;

public class Room_ec211030 extends Room{
    int goldAmount;

    public Room_ec211030() {
        this.goldAmount = 10;
    }
    
    static final Item[] items ={new Item("Spider-web motif"),
                                    new Item("Stained glass with daisies"),
                                    new Item("Stained glass windows")};
    static final int[] prices = {10,7,5};

    public Direction visit (Visitor player, Direction enteringDirection){
        player.tell("Welcome to our glass shop!");
        char choice = player.getChoice("Here's our products: \n"+
        "1- " + items[0].name + ", price: " + prices[0]
        +"\n2- " + items[1].name + ", price: " + prices[1]
        +"\n3- " + items[2].name + ", price: " + prices[2]
        +"\n4- Exit", new char[] {'1','2','3','4'});
        int numChoice = Character.getNumericValue(choice);
        while(numChoice!=4){
            if (numChoice < 4){
                if(player.hasIdenticalItem(items[numChoice-1])){
                    player.tell("You already have this item.");
                }
                else{
                    int paid = player.takeGold(prices[numChoice-1]);
                    if (paid < prices[numChoice]){
                        player.tell("You don't have enough coins!");
                    } else {
                        player.giveItem(items[numChoice-1]);
                        goldAmount += prices[numChoice];
                    }
                }
            }
        }
        player.tell("Thank you for visiting our Shop!");
        return Direction.opposite(enteringDirection);
    }
}
