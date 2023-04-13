package OOP.ec22612.MP.contributions;

public class Room_ex21247 extends Room{

    static final Item PS= new Item("Tps4");
    static final Item NOTAPS = new Item("contoller");

    public Direction visit(Visitor visitor, Direction TheWayUserArrivedFrom)
    {

        visitor.tell("Welcome to this Room");

        visitor.tell("To your right, you see three sets of candles gently lit, its flames swaying gently to the breeze of winds from the open window");

        visitor.tell("To your left, you see a cupboard, crafted with the utmost care from a skilled craftsman, the edges have been smoothed down and its peak just about reaches the ceiling of this room");

        char [] choices = {'L', 'R'};


        visitor.tell("Which way will you choose to go: Right[R] or Left[L]");



// checks for visit
        char choice = visitor.getChoice("Go Right[R] to blow the candles or go Left [L] to search the cupboard", choices);

        if (choice == 'L'){
            visitor.tell("You go left and you open the cupboard to find a shiny yellow sphere inside. You pick it up ");
            //visitor.tell("You found the ancient divine Tennis Ball!!!! ");
            visitor.giveItem(PS);

        }
        else{
            visitor.tell("You go right, you see the candles. You take a quick breath and blow out the candles hoping something would happen");
            visitor.tell("After having blown the candles");
            visitor.giveItem(NOTAPS);
        }
        if(visitor.hasEqualItem(PS))
        {

            visitor.tell("Congratulations!! You have found the ancient relic that holds divine powers");

        }
        else if (!(visitor.hasEqualItem(PS)))
        {

            visitor.tell("You have not found the divine ancient relic");
            visitor.tell("Instead you have found a broken lightbulb");
        }
        return TheWayUserArrivedFrom;

    }
}
