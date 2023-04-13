package OOP.ec22612.MP.contributions;

class Room_ec22464 extends Room {

    static final Item weapon = new Item("weapon");

    public Direction visit(Visitor v, Direction d) {

        v.tell("Do you wish to enter?");
        char[] options = { 'y', 'n' };
        char choice = v.getChoice("Choose 'y' for yes and 'n' for no.", options);
        char no = 'n';
        if (choice == no) {
            v.tell("You aren't ready now so come back another time.");

            return Direction.opposite(d);
        }

        else {
            v.tell("You have now entered the room.");
        }

        v.tell("Do you see the weapon on the wall?");
        v.tell("Do you want to take this weapon and face the dangers of the room?");
        choice = v.getChoice("Choose 'y' for yes and 'n' for no.", options);

        if (choice == no) {
            v.tell("Return the same way you came.");

            return Direction.opposite(d);
        }

        else {
            char head = 'h';
            char torso = 't';
            char legs = 'l';
            char[] attackOptions = { 'h', 't', 'l' };
            v.giveItem(weapon);
            v.tell("A ghost has appeared where will you attack with your weapon?");
            choice = v.getChoice("Choose 'h' to attack the head, 't' to attack the torso or 'l' to attack the legs.", attackOptions);

            if (choice == head) {
                v.tell("Well done you chose the attack that destroys the ghost.");
                v.tell("You shall be rewarded with 5 gold for your good work.");
                v.giveGold(5);
            }

            else if (choice == torso) {
                v.tell("You didn't destroy the ghost but you damaged it and so it wont return for a while.");
                v.tell("You shall be rewarded with 3 gold for you effort.");
                v.giveGold(3);
            }

            else if (choice == legs) {
                v.tell("You idiot, ghosts don't have legs!");
                v.tell("You didn't hit the ghost because it has no legs and it got away.");
                v.tell("Your attack missed so you damaged the wall and will pay 2 gold for it.");
                int pay = v.takeGold(2);
                if (pay != 2) {
                    v.tell("You don't have the gold?!");
                    v.tell("You better come back later and give it to me or I will come looking for you.");
                }
            }
        }
        return d;
        
    }
}