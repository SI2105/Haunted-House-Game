package HauntedHouseGame.contributions;

class Room_jpp317487 extends Room{
  public Direction visit(Visitor visitor, Direction directionVisitorArrivesFrom){
    visitor.tell("You find yourself in a mysteriously long, dimly lit hallway of the Winchester Mystery House, a chill runs down your spine. The air is heavy with a sense of foreboding and the walls seem to close in on themselves. The creaking of the floorboards, the faint sounds of laughter echoing off the walls, and the occasional gust of wind make them question what secrets this haunted hallway holds. With a deep breath and a quick prayer, you decide to advance, determined to unlock the secrets of this place.");
    char[] directionList = {'a', 'b'};
    char[] arrayOfPossibleChoices = {'a', 'b'};
    char choice = visitor.getChoice("Continue bravely onward through the spooky hallway? [a] or return back to safety [b]?", directionList);
    if(choice == 'a'){
      visitor.tell("As you move further down the hallway, a sudden chill runs by the air and a ghostly figure appears at the end of the hallway. The figure is returning a glare with an icy gaze, seemingly waiting for you to make a decision. You stands frozen, uncertain of what to do.");
      choice = visitor.getChoice("a) Try to calm the spirit and inch closer to it.      b) BOOOKIT AND RUN!", arrayOfPossibleChoices);
      if (choice == 'a'){
        visitor.tell("you sense that the ghostly figure does not seem to appreciate the ever so grander disturbance as you slowly walk forward knees sprung, you hear a ghastly and telegraphic clicking followed by a voice from just behind your head:" + '\u0022' + "turn back now, if you continue down this hallway, you will never find your way out" + '\u0022');
        choice = visitor.getChoice("a) BOOK IT AND RUN properly this time!      b) Try to calm the spirit.", arrayOfPossibleChoices);
        if (choice == 'a'){
          visitor.tell("You run back not looking back though the hallway unsure if it's the same one you even walked into.");
          visitor.tell("You head back south");
          return directionVisitorArrivesFrom;
        }
        else{
          visitor.tell("As soon as you mentally muster up the courage to speak and bring the spirit to an understanding it smiles and slowly hazes away from your view and as if it were a mirage it disappears the moment you lose focus on it.");
        }
      }
      else{
        visitor.tell("You run back not looking back though the hallway unsure if it's the same one you even walked into.");
        visitor.tell("You head back south");
        return directionVisitorArrivesFrom;
      }
      visitor.tell("You simply advance forward as the hallway begins to feel more welcoming, maybe the ghost wansnt real and you were just nervous hahaha. hopefully.");
      return Direction.TO_NORTH;
    }
    else if(choice == 'b'){
      visitor.tell("You head back south");
      return directionVisitorArrivesFrom;
    }
    else{
      visitor.tell("You head back south");
      return directionVisitorArrivesFrom;
    }
  }
}
