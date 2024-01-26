package HauntedHouseGame.contributions;

class Room_ec221006 extends Room{
    static final Item CasketKey = new Item("Casket Key");
    static final Item IdiotMedal = new Item("Idiot Medal (Reads: I am an idiot.)");
    static final Item RottenTomatoes = new Item("Basket of Rotten Tomatoes (Exclusively for losers!)");
    
    public Direction visit(Visitor visitor, Direction from){
        boolean r = visitor.hasIdenticalItem(CasketKey);
        if(!r){
            visitor.tell("Welcome weary traveller!");
            visitor.tell("This Room is inspired by Shakespeare's Merchant of Venice.");
            visitor.tell("Your choice may decide your fate.......Choose wisely.");
            visitor.tell("There are three caskets before you: Gold, Silver and Lead. Something engraved on each as:");
            visitor.tell("Gold: Who chooseth me shall gain what many men desire.");
            visitor.tell("Silver: Who chooseth me shall get as much as he deserves.");
            visitor.tell("Lead: Who chooseth me must give and hazard all he hath.");

            char[] choices = {'g', 's', 'l'};
            char choice = visitor.getChoice("Choose....you only get one choice.(g/s/l)", choices);

            if(visitor.giveItem(CasketKey)){
                if(choice == 'g'){
                    visitor.tell("All that glitters is not gold. Many a man his life hath sold, But my outside to behold. Fare you well. Your suit is cold.");
                    visitor.giveItem(IdiotMedal);
                    visitor.takeGold(10);
                }
                else if(choice == 's'){
                    visitor.tell("The fire seven times tried this, Seven times tried that judgment is, That did never choose amiss. Some   there be that shadows kiss. Such have but a shadow’s bliss.");
                    visitor.giveItem(RottenTomatoes);
                    visitor.takeGold(10);
                }
                else{
                    visitor.tell("You that choose not by the view, Chance as fair and choose as true! Since this fortune falls to you, Be content and seek no new.");
                    visitor.giveGold(10);
                }
            }
        }
        else
        {
            visitor.tell("This Room is inspired by Shakespeare's Merchant of Venice.");
            visitor.tell("You have already been here......You are allowed only a single chance.");
            visitor.tell("Farewell Once Again.");
        }
        
        
        char[] choices = {'n', 'e', 'w', 's'};
        char choice = visitor.getChoice("Which way would you like to leave?(n/e/w/s)", choices);
        
        if(choice == 'n')
        {
            return Direction.TO_NORTH; 
        }
        else if(choice == 'e')
        {
            return Direction.TO_EAST;
        }
        else if(choice == 'w')
        {
            return Direction.TO_WEST;
        }
        else if(choice == 's')
        {
            return Direction.TO_SOUTH;
        }
        else
        {
            return from;
        } 
    }
}
