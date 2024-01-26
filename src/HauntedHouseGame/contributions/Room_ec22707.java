package HauntedHouseGame.contributions;

//comment for a4b
class Room_ec22707 extends Room{
    static final Item deadCrow = new Item("Dead crow");

    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
         boolean windowOpen = true;
         char[] possibleChoices = {'y', 'n'};
         visitor.tell("Welcome to Laplus's Den");
         visitor.tell("Laplus doesn't seem to be home. \nA putrid smell runs through your nose \nYou look around and find her companion, a crow, lying dead on the floor. \nYou feel a sense of unease.");
         char itemPickup = visitor.getChoice("Would you like to pick up the crow? (y/n)", possibleChoices);
         if (itemPickup=='y'){
            visitor.giveItem(deadCrow);
            visitor.giveGold(3);
            visitor.tell("You pick up the crow and notice that your pockets have gotten heavier...");
         } else if (itemPickup=='n'){
            visitor.tell("You have a bad feeling about the crow and decide to leave it alone but you feel like you have missed out on something");
         }
         return Direction.opposite(directionVistorArrivesFrom);
    }
}
