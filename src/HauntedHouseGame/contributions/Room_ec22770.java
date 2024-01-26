package HauntedHouseGame.contributions;

public class Room_ec22770 extends Room{

    static boolean ItemHasBeenFound = false;

    static final Item Lever = new Item("Lever_ec22695");
    static final Item Key = new Item("Key_ec22770");
    static Boolean HasChestBeenOpen = false;
    public Direction visit( Visitor visitor, Direction directionVistorArrivesFrom)
    {

        //Introduces the room and gives the user option on where it would like to search
        visitor.tell("You have found the abondened libary room. At its peak it housed creativity, knowledge and ideas but now it holds the dust of books and the cobwebs of spiders. Despie this the the lever which is the key you need for your quest lies within the pile of dust beside the tree.");

        char[] options = {'a','b','c','d'};
        char[] descion = {'y','n'};

        char choice = visitor.getChoice("Which part of the room would you like to visit a) The Bookshelf b) The Dead Plant c) The desk d) The glowing chest beside the reception ", options);


        //User must acquire lever from ec22695
        //if statement for user selecting options
        if (choice == 'b')
        {

            if(ItemHasBeenFound == false)
            {
                visitor.tell("You now have the lever which unlocks a secret in another room. But which room?");
                visitor.giveItem(Lever);
                ItemHasBeenFound = true;
            }
            //if statement for if they have the lever or not
            else if (visitor.hasEqualItem(Lever)){
                visitor.tell("You already found the Lever from a previous visit");
            }
            else{
                visitor.tell("You discovered the lever from your previous visit.");
                visitor.giveItem(Lever);
            }
        }

        else if (choice == 'c')
        {
            char choice2 = visitor.getChoice("You explore the desk and notice a journel with a bright red cover that stands out. Would you like to see what secrets the journel has to tell ? (y/n)", descion);


            if (choice2=='y')
            {
                visitor.tell("You flick through the pages of the journel which has been covered in dust and realise someone has written a message on the opening page. It says: Lights shows you clear what appears in plain sight. But acts as a shadow for the secrets that submerge themselves in the darkness of night. ");
            }

            else{
                visitor.tell("Was that a wise decision or was it just foolishness.");
            }

        }

        else if (choice == 'd'){
            visitor.tell("I'm guessing finding the key is not your main objecective. Oh well just don't be greedy and make sure your worthy or you might be in for a treat.");
            char choice3 = visitor.getChoice("With that warning being said would you like to open the chest? (y/n)", descion);

            if (choice3=='y')
            {
                if(HasChestBeenOpen ==false)
                {   
                     //if statement if the user has found the key from ec22695 room
                    if(visitor.hasEqualItem(Key))
                    {
                        visitor.tell("Wow you actually have the key ! I thought the key did not exist. Here is your reward then from the chest which should give what you need for your next quest.");
                        visitor.giveGold(10);
                        HasChestBeenOpen = true;
                    }
                    else
                    {
                        visitor.tell("It seems you dont have the key to open the chest, come back later when you're at your best. (When you found the item!)");
                    }
        
                }
                else
                {
                    visitor.tell("Don't be too gready the chest has been opened up already! (Ain't no infinite money glitch here mate). Because of that you will pay a cost. I did warn you.");
                    visitor.takeGold(5);
                }
            }

            else{
                visitor.tell("Did you miss out on treasure or not? Either way the descion has been made and it's too late. MUAHAHAHAH!");
            }
        }

        else{
            visitor.tell("You chose the wrong place for the key maybe next on your next visit you might be lucky.");
        }


        return directionVistorArrivesFrom;
    }
}
