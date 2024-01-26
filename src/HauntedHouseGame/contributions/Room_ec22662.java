package HauntedHouseGame.contributions;

class Room_ec22662 extends Room {
	
    static final Item Knowledge = new Item("Infinite Knowledge");
	
    public Direction visit(Visitor MC, Direction entryPoint)
    {
	MC.tell("The room you've entered is an artifacts room. There are many impressive displays " + 
		"but perhaps the most impressive is the large sphynx at the end of the room.");
	MC.tell("What would you like to do?");
        char [] options = {'a','b'};
        char decision = MC.getChoice("a) Take Closer Look at the Sphynx b) Leave", options);
	if (decision == 'a')
	{
		MC.tell("*Le Gasp!* The Sphynx comes alive");
		MC.tell("The Sphynx tells you he has a riddle for you. Should you accept the challenge there will be a reward " +
		       "but be warned! If you get it wrong, there will also be a consequence.");
		MC.tell("Will you take the challenge?");
		char [] option = {'y','n', 'Y', 'N'};
        	char choice = MC.getChoice("Y/N", option);
		
		if (choice == 'y' | choice == 'Y') {
			char MC_Guess = giveRiddle(MC);
			playGame(MC, MC_Guess);
		}
		else {
			MC.tell("You did not take the challenge. Maybe you'll gain some courage in the other rooms.");
		}
	}
        return Direction.opposite(entryPoint);                  
    }
	
    public char giveRiddle(Visitor MC)
    {
        MC.tell("The Riddle is: A painting and a sculpture cost £1500 in total. The painting costs £1000 more than the sculpture." +
		"How much does the sculpture cost?");
	char [] mca = {'a','b', 'c', 'd'};
        char answer = MC.getChoice("a)£400 b)£450 c)£250 d)£500", mca);
    	return answer;
    }

    public void playGame(Visitor MC, char c)
    {
	if (c == 'c')
	{
		MC.tell("You have answered correctly. The reward (should you choose to accept it) is the most powerful weapon of them all (supposedly): " +
			"Infinite Knowledge! And also 5 gold coins.");
		MC.giveGold(5);
		Boolean item = MC.giveItem(Knowledge);
	}
	else
	{
		MC.tell("Bzzt! You have guessed incorrectly and will have 5 gold coins taken from you aswell as a generational curse put upon you.");
		MC.takeGold(5);
	}
	return;
    }
}
