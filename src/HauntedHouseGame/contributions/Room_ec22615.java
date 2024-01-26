package HauntedHouseGame.contributions;

class Room_ec22615 extends Room {
  static final Item vase = new Item("vase");
  static final Item kettle = new Item("kettle");
  static final Item paintings = new Item("paintings");
  static final Item potion = new Item("potion");

  // Visit method
  public Direction visit(Visitor v, Direction d) {

    String choices = ("You have 3 choices: a) explore the room, b) look inside the wardrobe or c) surprise. Choose your fate...");
    // New array to hold the choices the user has in this room.
    char[] choicesOptions = new char[3];
    // Assigning each index of the choices array the character to choose
    choicesOptions[0] = 'a';
    choicesOptions[1] = 'b';
    choicesOptions[2] = 'c';
    
    // Greeting the user in to the room.
    v.tell("Welcome to the Orange(hint) Bedroom.");
    char userChoice = v.getChoice(choices, choicesOptions);
    // if user chooses to explore the room
    if (userChoice == 'a') {
      v.tell("This visit will cost you 2 pieces of gold.");
      v.takeGold(2);

      v.tell("Here you will find a flower vase, a China Kettle and 2 paintings. Choose one to take as a souvenir.");
      String souvenirChoices = ("a) vase, b) kettle, c) paintings");

      // getting the user's choice of souvenir
      char userSouvenirChoice = v.getChoice(souvenirChoices, choicesOptions);
      if (userSouvenirChoice == 'a') {
        v.giveItem(vase);
      } else if (userSouvenirChoice == 'b') {
        v.giveItem(kettle);
      } else if (userSouvenirChoice == 'c') {
        v.giveItem(paintings);
      }
    }
    // if the user chooses to explore the wardrobe
    else if (userChoice == 'b') {
      v.tell(
          "Here you find a briefcase, opening it up you discover many different items. Some catch your attention, in particular a potion bottle.");
      String potionChoices = "a) Drink it, b) take it to investigate or c) close the briefcase.";
      char userPotionChoice = v.getChoice(potionChoices, choicesOptions);
      if (userPotionChoice == 'a') {
        v.tell("You have gained a superpower and gained 50 gold pieces.");
        v.giveGold(50);
      }
      else if (userPotionChoice == 'b') {
        v.giveItem(potion);
      }
      else if (userPotionChoice == 'c') {
        return d.TO_NORTH;
      }
    }
    else if (userChoice == 'c') {
      v.tell("Unlucky, you have lost 3 pieces of gold, better luck next time.");
      v.takeGold(3);
    }
    return d.opposite(d);
  }
}
