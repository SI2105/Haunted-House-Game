package OOP.ec22612.MP.contributions;

//ec22425
class Room_ec22425 extends Room
{
    private boolean lightsOn;
    private boolean chestEmpty;
    private boolean ghostHappy;

    public Room_ec22425()
    {
        lightsOn = false;
        chestEmpty = false;
        ghostHappy = false;
    }

    public Direction visit(Visitor v, Direction d){

        v.tell("You have entered the Room of ec22425");

        if(lightsOn)
        {
            v.tell("You enter a dimly lit room and you see a rugged box in the corner");
        }
        else
        {
            v.tell("You enter a dark room, but a clasp glistens in the corner");
        }

        if (chestEmpty)
        {
            v.tell("The chest is empty.");
        }
        else
        {
            v.tell("The chest is full.");
        }

        if (ghostHappy)
        {
            v.tell("The ghost is peaceful.");
        }
        else
        {
            v.tell("The ghost is angry.");
        }

        char[] choices = {'A', 'B', 'C'};
        char firstChoice = 'A';
        firstChoice = v.getChoice("What would you like to do?", choices);

        if (firstChoice=='A')
        {
            lightsOn = !lightsOn;
            if (lightsOn) {
                v.tell("You flip the light switch on.");
            } else {
                v.tell("You flip the light switch off.");
            }
        }
        else if (firstChoice=='B')
        {
            if (chestEmpty) {
                v.tell("The chest is empty.");
            } else {
                v.tell("You open the trunk and find 5 pieces of gold!");
                v.giveGold(5);
                chestEmpty = true;
            }
        } else if (firstChoice=='C') {
            if (ghostHappy)
            {
                v.tell("You talk to the Ghost and he gives you some gold!");
                v.giveGold(3);
            }
            else {
                v.tell("You anger the Ghost even more, he steals some gold from you!");
                v.takeGold(1);
            }
        }

        char[] exitChoices = {'A', 'B', 'C', 'D'};
        char secondChoice = 'A';
        secondChoice =  v.getChoice("Which door would you like to leave through?", exitChoices);

        if (secondChoice=='A')
        {
            d = Direction.TO_NORTH;
        }
        else if (secondChoice=='B')
        {
            d = Direction.TO_EAST;
        }
        else if (secondChoice=='C')
        {
            d = Direction.TO_SOUTH;
        }
        else if (secondChoice=='D')
        {
            d = Direction.TO_WEST;
        }
        return d;
    }

}
