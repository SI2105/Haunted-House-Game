package HauntedHouseGame.contributions;// Main framework class for A4.

class Room_ec22709 extends Room {
    static final Item book = new Item("Book");
    static final Item staff = new Item("Staff");
    static final Item basketball = new Item("Basketball");
    static final Item watch = new Item("Watch");

    public Direction visit(Visitor v, Direction d) {
        v.tell("Welcome to ec22709's room in the house");
        v.tell("Pay 1 gold enter");
        v.takeGold(1);

        String navigationOption = ("What would you like to do in my room? a) Look around, b) Take a seat on the chair, c) Open the cupboard");
        char[] options = {'a', 'b', 'c'};
        char userOptions = v.getChoice(navigationOption, options);

        if (userOptions == 'a') {
            v.tell("You're looking around my room let me know if you find anything interesting");
            String itemOptions = ("You found some things in my room... Which one would you like to take? a) Book, b) Basketball, c) Watch");
            char userItemOptions = v.getChoice(itemOptions, options);

            if (userItemOptions == 'a') {
                v.giveItem(book);
            } else if (userItemOptions == 'b') {
                v.giveItem(basketball);
            } else if (userItemOptions == 'c') {
                v.giveItem(watch);
            }
        } else if (userOptions == 'b') {
            v.tell("You took a seat in the chair. That will cost you another peice of gold");
            v.giveGold(1);
        } else if (userOptions == 'c') {
            v.tell("Hey, is that my staff? You shouldn't go through my things!");
            v.giveItem(staff);
        }

        return d.opposite(d);
    }
    
}
