package HauntedHouseGame.contributions;

class Room_ec22866 extends Room {

     static final Item CORD = new Item("Cord");
     static final Item KEY = new Item("Key");
     static final Item BAT = new Item("Bat");

     public Direction visit(Visitor visitor, Direction direction) {
         visitor.tell("The door opens slowly. The room has a wadrobe, a beaten up shelf and some old beds.");

         char[] options = { '1', '2', '3' };
         char choices = visitor.getChoice("Please select one 1) Look through the wadrobe  2) Search the shelf) Search under the bed",options);
         int coins = 0;

         if (choices == '1') {
             visitor.tell("You open the wadrobe and an ancient bat is sitting at the bottom. A few gold coins are sitting alongside it too.");
             visitor.giveItem(BAT);
             visitor.giveGold(3);
             coins = coins + 3;
         }

         if (choices == '2') {
             if (coins > 0) {
                 visitor.tell("As you search the shelf, a bat appears out of nowhere. You jump and fall to the floor. The coins fall from your hand and one of them falls through the cracks of the floor.");
                 visitor.takeGold(1);
                 coins = coins - 1;
             }

             if (visitor.hasEqualItem(BAT)) {
                 visitor.tell("Out of anger, you smash the shelf with a bat and due to the impact a key falls from the top of the shelf.");
                 visitor.giveItem(KEY);
             }

         }
         if (choices == '3') {
             visitor.tell("You start searching under the bed and more coins start to appear.");
             visitor.giveGold(2);
             coins = coins + 2;
         }
         return direction;
     }
 }

