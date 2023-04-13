package OOP.ec22612.MP.contributions;

class Room_ec22836 extends Room
{
    public Direction visit(Visitor v, Direction d)
    {
        Item Model_Hotchkiss = new Item("Model Hotchkiss");
        
        char[] options = {'a', 'b'};
        char user_choice = 'q';
        
        v.tell("Welcome to the room of comedians!");
        v.tell("Listen to what they have to say!");
        v.tell("If you like, they get to live!");
        v.tell("If you don't, you get to end them with this!");
        v.tell("");
        
        v.giveItem(Model_Hotchkiss);
        
        v.tell("You have received a Model Hotchkiss");
        v.tell("");
        
        // Adam Sandler
        v.tell("First up is....... Adam Sandler");
        v.tell("");
        v.tell("Why did the tomato turn red? Because it saw the salad dressing!");
        v.tell("");
        
        user_choice = v.getChoice("a) I loved it!  b) Die Now!", options);
        
        if (user_choice == 'a')
        {
            System.out.println("Love you man! You are definetly invited to my next family barbecue!");
        }
        else if (user_choice == 'b')
        {
            v.tell("Bang!");
            v.tell("*Coughs out blood*");
            v.tell("Wish I could have been there to walk my baby girl down the aisle.......");
        }
        v.tell("");
        
        // Kevin Hart
        v.tell("Next up is....... Kevin Hart");
        v.tell("");
        v.tell("I'm trying to lose weight, but it's hard. Last week, I asked my trainer, Whats the best cardio to do? and he said, Running! So I tried running, but I felt like I was dying. I was like, This can't be right, my heart shouldn't be trying to escape my body like this. So then I tried cycling, but my butt started hurting after 5 minutes. I was like, What kind of sick joke is this? Finally, I decided to just do what I do best: eat a salad and then watch Netflix for 6 hours straight.");
        v.tell("");
        
        user_choice = v.getChoice("a) I loved it!  b) Die Now!", options);
        
        if (user_choice == 'a')
        {
            v.tell("Hey man, lets take a selfie. Phew! Dwyane, Im coming home!");
        }
        else if (user_choice == 'b')
        {
            v.tell("Bang!");
            v.tell("*Coughs out blood*");
            v.tell("I promised my momma that Id be next to her when she passes....... Guess I'll just meet her next in the clouds!");
        }
        v.tell("");
        
        // Jim Carrey
        v.tell("Next up is....... Jim Carrey");
        v.tell("");
        v.tell("Why did the chicken cross the road? To get to the other side... BUT WAIT! What if I told you that the chicken didn't actually want to cross the road? What if I told you that the chicken was actually running away from an evil group of squirrels who were plotting to take over the world? And what if I told you that the only way the chicken could escape was to cross the road and seek refuge in a nearby barn, where it could plot its revenge against the squirrels? See, you never know what's really going on in the mind of a chicken.");
        v.tell("");
        
        user_choice = v.getChoice("a) I loved it!  b) Die Now!", options);
        
        if (user_choice == 'a')
        {
            v.tell("Cant wait to be in Sonic The Hedgehog 3! Ill see you at the premiere.");
        }
        else if (user_choice == 'b')
        {
            v.tell("Bang!");
            v.tell("*Coughs out blood*");
            v.tell("The wife and kids are in the car.........and the keys are with me....");
        }
        v.tell("");
        
        // Ricky Gervais
        v.tell("Last but not least is....... Ricky Gervais");
        v.tell("");
        v.tell("I'm not a vegetarian because I love animals. I'm a vegetarian because I hate plants.");
        v.tell("");
        
        user_choice = v.getChoice("a) I loved it!  b) Die Now!", options);
        
        if (user_choice == 'a')
        {
            v.tell("Golden Globes 2024, a golden oppurtunity to bully them celebrities again!");
        }
        else if (user_choice == 'b')
        {
            v.tell("Bang!");
            v.tell("*Coughs out blood*");
            v.tell("Friends in the emergency room for alcohol poisoning. We could share a beer in our next life.........");
        }
        v.tell("");

        return d;
    }
}
