package OOP.ec22612.MP.contributions;

import java.util.Random;

class Room_ec22858 extends Room {

  static final Item QuailEgg = new Item("Quail Egg");
  static final Item Bananas = new Item("Bananas");

  int eggsInStorage;

  Room_ec22858() {
    eggsInStorage = 1;
  }

  // when visitor visits room
  public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {

    // introduce visitor
    visitor.tell(
        "Welcome to my egg emporium. I am a ghost. We are in the haunted kitchen. I have " + eggsInStorage
            + " eggs in the cupboard. Feel free to make yourself an omelette.");
    visitor.tell("Making the mother of all omelettes here Jack. Can't fret over every egg. - Senator Armstrong.");

    // get option from user
    char[] choiceArray = { 'e', 'o', 'g' };
    char choice = visitor.getChoice(
        "Select an option. If you would like an egg, type 'e', but I only have 1 egg. If you ask for more I will smite you for your greed. If you want to offer your items to me, type 'o' and I will judge your inventory. If you would like to try your luck and gamble your gold against me in a game of Blackjack, type 'g'.",
        choiceArray);

    // do options
    if (choice == 'e') {
      eggsInStorage = eggInteraction(visitor, eggsInStorage);
    } else if (choice == 'o') {
      boolean goodInventory = offerItems(visitor);
      if (goodInventory) {
        visitor.tell("Your inventory has been searched and found worthy. You will receive 10 gold.");
        visitor.giveGold(10);
      } else {
        visitor.tell("I abhor your offering. I will cast you northbound for your crime.");
        return Direction.TO_NORTH;
      }
    } else if (choice == 'g') {
      boolean win = gambling(visitor);
      if (win) {
        visitor.tell("You Win. Congratulations.");
        visitor.giveGold(10);
      } else {
        visitor.tell("You Lose. Oh well.");
        visitor.takeGold(10);
        visitor.tell("You will go back the way you came.");
        return Direction.opposite(directionVistorArrivesFrom);
      }
    } else {
      visitor.tell("I'm not sure what you would like to do. You can leave.");
    }

    Direction visitorLeavingDirection = askWhereToLeave(visitor, directionVistorArrivesFrom);
    return visitorLeavingDirection;
  }

  // if visitor wants an egg
  private int eggInteraction(Visitor visitor, int eggsInStorage) {
    int newEggsInStorage = eggsInStorage;

    if (eggsInStorage > 0) {
      visitor.tell("You have received an egg.");
      visitor.giveItem(QuailEgg);
      newEggsInStorage = newEggsInStorage - 1;
    } else {
      visitor.tell("Your hubris has overtaken you. I will take up to 10 gold from you.");
      visitor.takeGold(10);
    }

    return newEggsInStorage;
  }

  // visitor shows items to ghost
  private boolean offerItems(Visitor visitor) {
    boolean goodInventory = false;

    if (visitor.hasEqualItem(QuailEgg) || visitor.hasIdenticalItem(QuailEgg) || visitor.hasEqualItem(Bananas)) {
      goodInventory = true;
    }

    return goodInventory;
  }

  // visitor wants to gamble
  private boolean gambling(Visitor visitor) {
    PlayerHand playerHand = new PlayerHand();
    PlayerHand houseHand = new PlayerHand();

    visitor.tell("Let's play blackjack.");

    playerHand.newCard();
    playerHand.newCard();

    visitor.tell("You have a " + playerHand.read(0) + " and a " + playerHand.read(1));

    boolean anotherCard = true;
    while (anotherCard) {
      char[] choiceArray = { 'y', 'n' };
      char choice = visitor.getChoice("Would you like another card? (y/n)", choiceArray);

      if (choice == 'y') {
        anotherCard = true;
        Card newestCard = playerHand.newCard();
        visitor.tell("You have received a " + Card.readCard(newestCard));
      } else if (choice == 'n') {
        anotherCard = false;
      } else {
        visitor.tell("I'm not sure what you want. I'll stop giving you cards.");
        anotherCard = false;
      }
    }

    houseHand.newCard();
    houseHand.newCard();

    while (houseHand.sum() < 15) {
      houseHand.newCard();
    }

    visitor.tell("The house's hand has a total of " + houseHand.sum());
    visitor.tell("Your hand has a total of " + playerHand.sum());

    boolean isWinner;
    if (playerHand.over21()) {
      isWinner = false;
      if (houseHand.over21()) {
        isWinner = true;
      }
    } else {
      if (houseHand.over21()) {
        isWinner = true;
      }
      if (playerHand.sum() > houseHand.sum()) {
        isWinner = true;
      } else {
        isWinner = false;
      }
    }

    return isWinner;
  }

  // ask visitor how to leave
  private Direction askWhereToLeave(Visitor visitor, Direction directionVisitorArrivesFrom) {
    char[] choiceArray = { 'a', 'b', 'c', 'd' };
    char choice = visitor.getChoice(
        "You have 4 options to leave the room. Type 'a' to leave through the window. Type 'b' to leave through a gap in the wall. Type 'c' to leave through the dumbwaiter. Type 'd' to leave through door.",
        choiceArray);

    Direction leavingDirection = Direction.TO_NORTH;
    if (choice == 'a') {
      leavingDirection = Direction.TO_NORTH;
    } else if (choice == 'b') {
      leavingDirection = Direction.TO_SOUTH;
    } else if (choice == 'c') {
      leavingDirection = Direction.TO_EAST;
    } else if (choice == 'd') {
      leavingDirection = Direction.TO_WEST;
    } else {
      visitor.tell("I'm not sure where you would like to go. I'll bring you back to where you came from.");
      leavingDirection = Direction.opposite(directionVisitorArrivesFrom);
    }

    return leavingDirection;
  }
}

// class for player hands
class PlayerHand {
  Card[] hand;

  PlayerHand() {
    hand = new Card[0];
  }

  public Card newCard() {
    Card[] tempHand = new Card[hand.length + 1];

    for (int i = 0; i < hand.length; i++) {
      tempHand[i] = hand[i];
    }

    Card newestCard = new Card();
    tempHand[tempHand.length - 1] = newestCard;

    hand = tempHand;

    return newestCard;
  }

  public Card get(int index) {
    return hand[index];
  }

  public String read(int index) {
    String cardName = get(index).number + " of " + get(index).suit;
    return cardName;
  }

  public int sum() {
    int sum = 0;
    for (Card c : hand) {
      sum = sum + c.number;
    }
    return sum;
  }

  public boolean over21() {
    int sum = sum();
    if (sum > 21) {
      return true;
    } else {
      return false;
    }
  }
}

// class for cards in player hands
class Card {
  int number;
  String suit;

  Card() {
    Random random = new Random();
    String[] suits = { "Spades", "Clubs", "Hearts", "Diamonds" };

    number = random.nextInt(10) + 1;
    suit = suits[random.nextInt(suits.length)];
  }

  public static String readCard(Card card) {
    return card.number + " of " + card.suit;
  }
}
