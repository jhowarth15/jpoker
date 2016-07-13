package jpoker;

public class Hand {

	private Card[] cards;
	private int[] value;
	
	Hand (Deck d)
	{
		value = new int[6];
		cards = new Card[5];
		
		//Draw 5 cards.
		for (int x=0; x<5; x++)
		{
			cards[x] = d.drawFromDeck();
		}
		
		int[] ranks = new int[14];
		int[] orderedRanks = new int[5];
		boolean flush=true, straight=false;
		int sameCards=1, sameCards2=1;
		int largeGroupRank=0, smallGroupRank=0;
		int index = 0;
		int topStraightValue = 0;
		
		for (int x=0; x<=13; x++)
		{
			ranks[x]=0;
		}
		//For each card drawn, increment ranks[] according to the ranks drawn.
		for (int x=0; x<=4; x++)
		{
			ranks[ cards[x].getRank()] ++;
		}
		//Check for flush
		for (int x=0; x<4; x++)
		{
			if ( cards[x].getSuit() != cards[x+1].getSuit() )
			{
				flush=false;
			}
		}
		
		//Find big group and small group
		for (int x=13; x>=1; x--)
		{
			if (ranks[x] > sameCards)
			{
				if (sameCards != 1)
				{
					sameCards2 = sameCards;
					smallGroupRank = largeGroupRank;
				}
				
				sameCards = ranks[x];
				largeGroupRank = x;
				
			} else if (ranks[x] > sameCards2)
			{
				sameCards2 = ranks[x];
				smallGroupRank = x;
			}
		}
		
		
	}
}
