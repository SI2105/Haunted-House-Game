package HauntedHouseGame.contributions;

//New Room
class Room_ec22843 extends Room {


    public Direction visit(Visitor v, Direction d){
        final Item goldenKey = new Item("Key");

        v.tell("Welcome to the terrible room of ec22843.");

        char[] choices = {'A','B','C'};
        char vChoice = v.getChoice("Which room do you want to enter? A) The Orange Bedroom? B) Up the staircase? C) To the Pipe Organ?", choices);

        if(vChoice == 'A'){
            v.tell("Intresting Choice... Not where I wanted you but there is a gold coin in here");
            v.giveGold(1);
        }
        else if (vChoice == 'B') {
            v.tell("WRONG!!.. Never Choose the stairs");
	    v.takeGold(5);
        }
        else if (vChoice == 'C') {
            v.tell("Exactly where I wanted you!");
            v.giveItem(goldenKey);
            v.giveGold(10);
        }

        v.tell("Next question...");

        char[] yesOrNo = {'Y','N'};
        char[] direc = {'S','N','W','E'};
        char vAns = v.getChoice("Do you like having control over the next step?(Y/N)?",yesOrNo);

        if (vAns == 'Y') {
            v.tell("Of course you do! Who doesn't?");
            char direcChoose = v.getChoice("Which direction do you want to go? (S,N,W,E)?",direc);

            if (direcChoose == 'S') {
                v.tell("So you want to go to South..");
                v.tell("Well I want you to go North.. Bye");
                return Direction.TO_NORTH;
            }
            else if (direcChoose == 'N') {
                v.tell("So you want to go to the North..");
                v.tell("I LOVE the North here is some gold and lets go.");
                v.giveGold(5);
                return Direction.TO_NORTH;
            }
            else if (direcChoose == 'W') {
                v.tell("So you want to go to the West..");
                v.tell("Well I'm going to let you go..");
                return Direction.TO_WEST;
            }
            else if (direcChoose == 'E') {
                v.tell("So you want to go to the East..");
                v.tell("The East is dangerous lets go South");
                return Direction.TO_SOUTH;
            }
            else {
                v.tell("None of them? Okey...");
                return Direction.opposite(d);
            }
        }
        else {
            v.tell("You are a strange strange person. Who dosen't like control");
            v.tell("Well oh well... See you on another side");
            return Direction.opposite(d);
        }

    }
    
	
}

