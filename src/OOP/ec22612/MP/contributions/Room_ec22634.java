package OOP.ec22612.MP.contributions;

class Room_ec22634 extends Room {

  private Item mystery_box = new Item("Toolkit");

  public Direction visit(Visitor visitor, Direction arrivalDirection) {
    char takeRisk_options[] = {'a' , 'b', 'c'};
    char box_options [] = {'1' , '2', '3', '4'};
      
    Direction exitDirection = arrivalDirection;
    visitor.tell("There are four safes in front of you. One contains riches, one contains debt that must be paid, one is empty and the last contains a mysterious object that could either bring great fortune or unforeseen consequences.");
    char takeRisk = visitor.getChoice("Do you want to a) take the risk or b) leave the room... think & choose wisely.", takeRisk_options );

    if (takeRisk == 'a') {
      char safeChosen = visitor.getChoice("Do you want to choose safe 1, 2, 3, or 4?", box_options );

      if (safeChosen == '1') {
        visitor.tell("You have chosen the mystery box. This toolkit should help you on your journey.");
        visitor.giveItem(mystery_box);
        exitDirection = Direction.TO_WEST;
      } else if (safeChosen == '2') {
        visitor.tell("You must now pay the debt of 25 coins. Go back to the direction you came from, perhaps you'll have better luck there.");
        visitor.takeGold(25);
        exitDirection = arrivalDirection;
      } else if (safeChosen == '3') {
        visitor.tell("Congrats! You have opened the box that has 75 gold coins. You are now rich.");
        visitor.giveGold(75);
        exitDirection = Direction.TO_EAST;
      } else if (safeChosen == '4') {
        visitor.tell("This box was empty.");
        exitDirection = Direction.TO_SOUTH;
      } else {
        visitor.tell("Invalid choice. Get out. NOW!");
      }
    }

    return exitDirection;
  }
}
