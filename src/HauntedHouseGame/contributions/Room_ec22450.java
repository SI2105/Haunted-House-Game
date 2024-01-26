package HauntedHouseGame.contributions;

import java.util.Random;
class Room_ec22450 extends Room
{
    boolean lightsOn;
    boolean curtainsOpen;
    boolean tvOn;
    boolean tidy;
    public Room_ec22450()
    {
       this.lightsOn=false;
       this.curtainsOpen=false;
       this.tvOn=false;
       this.tidy=true;
    }
    public Direction visit(Visitor guest,Direction origin)
    {
        final int amountToPay=5;
        int additionalFees=0;
        guest.tell("Welcome to your new room! Enjoy relaxing on the comfortable sofa next to the pleasant fireplace.");
        guest.tell("There is a TV,a desk,a bed, and an amazing view of the vast surroundings.");
        if(tidy==true)
        {
            guest.tell("Since you're the first visitor here,you'll find this room in an immaculate state.");
        }
        else
        {
            guest.tell("Unfortunately, the guest that stayed here before you didn't leave the place in a good state.");
            guest.tell("Therefore I will give you a discount of 1 gold piece.");
            additionalFees-=1;
        }
        if(curtainsOpen==false)
        {
           guest.tell("Go on, open the curtains and enjoy the views of the horizon.");
           char[] choiceArray={'C','N'};
           if(guest.getChoice("Press C to open the curtains, or N to refuse.",choiceArray)=='C')
           {
               this.curtainsOpen=true;
               guest.tell("Good job! The curtains are now open.");
               guest.tell("On the windowsill behind the curtains you'll find 2 pieces of gold. Please take it.");
               guest.giveGold(2);
           }
           else
           {
              guest.tell("In the cupboard beside the curtains there is some free chocolate. Please help yourself.");
              Item chocolate=new Item("Chocolate");
              guest.giveItem(chocolate);
           }
        }
        if(curtainsOpen==false && lightsOn==false)
        {
            guest.tell("As you didn't open the curtains,its a bit gloomy in here! Turn the lights on.");
            char[] choiceArray2={'L','N'};
            if(guest.getChoice("Press L to turn the lights on, or N to refuse.",choiceArray2)=='L')
            {
                this.lightsOn=true;
                guest.tell("Good work;it look a little brighter in here now.");
            }
        }
        guest.tell("Feel free to turn the television on.");
        char[] choiceArray3={'T','N'};
        if(guest.getChoice("Press T if you want to watch TV, or N to refuse.",choiceArray3)=='T')
        {
            this.tvOn=true;
            if(guest.hasEqualItem(new Item("Remote")))
            {
                guest.tell("I can see that you are holding the remote in your hand. Turn the TV on and relax for the rest of the evening!");
            }
            else
            {
                guest.tell("Pick up the remote from the table and relax for the rest of the evening!");
            }
        }
        if(this.tvOn==true)
        {
            guest.tell("Before you leave,please switch the TV off.");
            char[] choiceArray4={'O','N'};
            if(guest.getChoice("Press O if you want to turn the TV off, or N to leave it as it is.",choiceArray4)=='O')
            {
                tvOn=false;
                guest.tell("The TV is now off.");
            }
        }
        if(this.lightsOn==true)
        {
            guest.tell("Please also turn the lights off to save electricity.");
            char[] choiceArray5={'O','N'};
            if(guest.getChoice("Press O if you want to turn the lights off, or N to leave it as it is.",choiceArray5)=='O')
            {
                lightsOn=false;
                guest.tell("The lights are now off. The room is cloaked in darkness");
            }
        }
        if(this.lightsOn==true && this.tvOn==true)
        {
             guest.tell("You have left both the lights on and the TV on!");
             guest.tell("For that reason, you will have to pay an additional fee of 1 gold piece.");
             additionalFees+=1;
             tidy=false;
        }
        guest.tell("Thank you for visiting! The total amount to pay is "+(amountToPay+additionalFees)+" pieces of gold.");
        final int amountToTake=5;
        int amountTaken=guest.takeGold(5);
        if(amountTaken==amountToTake)
        {
            guest.tell("Thank you for paying the full amount of money.");
            guest.tell("As a gesture of goodwill, I will give you one gold piece.");
            guest.giveGold(1);
            Random randomStream=new Random();
            int randomNumber=randomStream.nextInt(3);
            if(randomNumber==0)
            {
                guest.tell("I will now be sending you north.");
                return Direction.TO_NORTH;

            }
            else if(randomNumber==1)
            {
                guest.tell("I will now be sending you west.");
                return Direction.TO_WEST;
            }
            else
            {
                guest.tell("I will now be sending you east.");
                return Direction.TO_EAST;
            }
        }
        else
        {
            guest.tell("Unfortunately you have failed to pay the right amount. Please exit the room immediately.");
            guest.tell("Therefore,I will send you south.");
            return Direction.TO_SOUTH;
        }
    }
}
