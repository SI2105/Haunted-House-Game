package HauntedHouseGame.contributions;

public class Room_ec22627 extends Room
{
	private boolean bVisited = false ;
	static final Item[] Items = {new Item("Love Winchester Mystery House Glass") , 
			new Item("Spirits are Calling Coaster Set") , 
			new Item("Winchester Mystery House Souvernir Book")} ;
	static final int[] iPrices = {999 , 1299 , 2199} ;

	void tell(String szMessage)
	{
		System.out.println(szMessage) ;
	}
 
	public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom) 
	{
		char chChoice = '\0' ;
		int iChoice = 0 ;
		int iTaken = 0 ;
		if(!bVisited)
		{
			tell("Welcome to the Mercantile gift shop!");
		}
		else
		{
			tell("Welcome back");
		}

		do
		{
			chChoice = visitor.getChoice("What would you like to buy?"
					+ "\n1) " + Items[0].name 
					+ "\n2) " + Items[1].name
					+ "\n3) " + Items[2].name
					+ "\n4) Leave" , new char[]{'1','2','3','4'}) ;
			iChoice = Character.getNumericValue(chChoice) ;
			if(iChoice < 4)
			{
				if(visitor.hasIdenticalItem(Items[iChoice-1]))
				{
					tell("Sorry, one of each item per customer.") ;
				}
				else
				{
					iTaken = visitor.takeGold(iPrices[iChoice - 1]) ;

					if(iTaken < iPrices[iChoice - 1])
					{
						tell("Sorry, that is not enough gold for the " + Items[iChoice - 1].name) ;
						visitor.giveGold(iTaken) ;
					}
					else
					{
						visitor.giveItem(Items[iChoice - 1]) ;
					}
				}
			}
		}while(chChoice != '4');

		tell("Thank you for visiting! Goodbye") ;
		if(directionVisitorArrivesFrom != Direction.FROM_WEST)
		{
			return Direction.TO_EAST ;
		}
		return Direction.TO_NORTH ;
	}
}
