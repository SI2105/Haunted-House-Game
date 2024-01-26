package HauntedHouseGame.contributions;

class Room_ec22955 extends Room {
    
    private String temp = "cold";
    private boolean matchFound = false;
    private int twigs = 0;

    
    //will run on visit to Room_ec22955
    public Direction visit(Visitor v, Direction d) {
        char choice;
        if (d.equals(Direction.FROM_SOUTH)||d.equals(Direction.FROM_WEST)||d.equals(Direction.FROM_EAST)) {
            v.tell("you have entered a " + temp + " room. you can see three trails of twigs leading off into the distance using a torch you found near the entrance");
            
            v.tell("there is one trail leading left (L), one right (R), and one going straight ahead (S)");
            
            choice = v.getChoice("which trail do you want to follow? enter the character as above ", new char[] {'L', 'S', 'R'});
            if (choice=='L') {
                twigs = twigs + 5;
                v.tell("after following this trail you picked up 5 twigs. you now have " + twigs + " in total.");
            }
            else if (choice=='S') {
                twigs = twigs + 10;
                v.tell("after following this trail you picked up 10 twigs. you now have " + twigs + " in total.");
            }
            else if (choice=='R') {
                twigs = twigs + 15;
                v.tell("after following this trail you picked up 15 twigs. you now have " + twigs + " in total.");
            }
            
            if (d.equals(Direction.FROM_SOUTH)) {
                d = Direction.TO_SOUTH;
            }
            else if (d.equals(Direction.FROM_WEST)) {
                d = Direction.TO_EAST;
            }
            else {
                d = Direction.TO_WEST;
            }
            
            if (twigs>=20 && matchFound==true && temp=="cold") {
                temp = "warm";
                matchFound = false;
                v.tell("you have enough twigs to start a fire using the match you found earlier! the room is a lot warmer now and you can finally see a bit better.");
                
                v.tell("in the distance you see something glinting left behind by a small figure scared away by the fire");
                choice = v.getChoice("go see the glinting item (G) or turn back to another entrance (B) ", new char[] {'G', 'B'});
                if (choice=='G') {
                    v.tell("you have found some pieces of gold! so lucky!");
                    v.giveGold(10);
                }
                else if (choice=='B') {
                    v.tell("you leave the room");
                }
            }
        }
        else  {
            v.tell("you have entered a " + temp + " room.");
            if (matchFound==false) {
                v.tell("you can see a match near where you stand and some pawprints leading off into the distance");
            
                choice = v.getChoice("do you want to pick up the match? Y/N ", new char[] {'Y', 'N'});
                if (choice=='Y') {
                    matchFound = true;
                    v.tell("you now have a match!");

                }
                else if (choice=='N') {
                    v.tell("you do not pick up the match..... maybe that was a bad idea");
                }
            }
            else {
                v.tell("you can see some pawprints leading off into the distance. you follow them and see a sleeping puppy");
                choice = v.getChoice("do you want to wake the puppy? (Y/N) ", new char[] {'Y', 'N'});
                if (choice=='Y') {
                    v.tell("the puppy wakes up but quickly snatches a pouch of gold coins you found before! you lose " + v.takeGold(5) + " pieces and watch as the puppy sprints away into the darkness......");
                    temp = "cold";
                }
                else if (choice=='N') {
                    v.tell("you leave the room");
                }
            }
        }
        Direction newd = Direction.opposite(d);
        return newd;
    }
}
