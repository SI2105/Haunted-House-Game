package OOP.ec22612.MP.contributions;

class Room_ec22507 extends Room {
    public Direction visit(Visitor vPerson, Direction dIntoRoom) {
        final Item Spear = new Item("Spear Of Leonidas");
        vPerson.tell("Cost of admission to this fine establishment is two gold pieces.");
        vPerson.takeGold(2);
        String routes = ("Would you like to a) Take a stroll around the garden b) Engage in glorious combat to win a reward  c) Go to the roof or d) Go to amigos?");
        char[] options = {'a', 'b', 'c', 'd'};

        char choice = vPerson.getChoice(routes, options);

        if(choice == 'a') {
            vPerson.tell("To enter this magnificent garden you must need two gold pieces.");
            vPerson.takeGold(2);
        }

        else if(choice == 'b') {
            vPerson.tell("You are victorious in the arena, a great victory requires a great reward.");
            vPerson.giveItem(Spear);
        }

        else if(choice == 'c') {
            vPerson.tell("To take in the beautiful sights of the country-side requires three gold pieces.");
            vPerson.takeGold(3);
        }

        else if(choice == 'd') {
            vPerson.tell("This luxurious cuisine comes at a high cost, enjoy your meal.");
            vPerson.takeGold(4);
        }
        return Direction.opposite(dIntoRoom);
    }
}
