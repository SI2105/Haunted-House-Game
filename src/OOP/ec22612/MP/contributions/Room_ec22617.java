package OOP.ec22612.MP.contributions;

class Room_ec22617 extends Room {

    static class Choices {
        static class Choice {
            String description;
            Runnable runnable;
            public Choice(String description, Runnable runnable) {
                this.description = description;
                this.runnable = runnable;
            }
        }

        static class DescriptionAndChoices {
            String description;
            char[] arrayOfPossibleChoices;
        }

        java.util.ArrayList<Choice> choices;

        public Choices() {
            this.choices = new java.util.ArrayList<Choice>();
        }

        public void add(Choice choice) {
            this.choices.add(choice);
        }

        public Choice get(int i) {
            return this.choices.get(i);
        }

        public boolean remove(Choice choice) {
            return this.choices.remove(choice);
        }

        private boolean alreadyInArrayChar(char predicate, char[] array) {
            for (char c : array) {
                if (predicate == c) return true;
            }
            return false;
        }

        private char[] createCharArrayOfChoices() {
            char[] choicesCharArray = new char[this.choices.size()];

            for (int i = 0; i < choicesCharArray.length; i++) {
                Choice choice = this.choices.get(i);

                for (char c : choice.description.toCharArray()) {
                    if (!alreadyInArrayChar(c, choicesCharArray)) {
                        choicesCharArray[i] = c;
                        break;
                    }
                }

                if (choicesCharArray[i] == '\0') {
                    for (char c = 0; c < Character.MAX_VALUE; c++) { 
                        if (Character.isLetterOrDigit(c)) {
                            choicesCharArray[i] = c;
                        }
                    }
                }
            }

            return choicesCharArray;
        }

        // This is just so we can quickly create a menu of options
        public DescriptionAndChoices createMenu() {
            DescriptionAndChoices dac = new DescriptionAndChoices();
            char[] choicesCharArray = createCharArrayOfChoices();
            dac.description = "";
            dac.arrayOfPossibleChoices = createCharArrayOfChoices();

            StringBuilder descBuilder = new StringBuilder();
            for (int i = 0; i < choicesCharArray.length; i++) {
                descBuilder.append('[');
                descBuilder.append(choicesCharArray[i]);
                descBuilder.append(']');
                descBuilder.append(' ');
                descBuilder.append(this.choices.get(i).description);
                if (i != (choicesCharArray.length - 1)) descBuilder.append(System.lineSeparator());
            }
            dac.description = descBuilder.toString();

            return dac;
        }

        public void handleChoice(char choice) {
            char[] choicesCharArray = createCharArrayOfChoices();
            for (int i = 0; i < choicesCharArray.length; i++) {
                if (choice == choicesCharArray[i]) {
                    this.choices.get(i).runnable.run();
                    break;
                }
            }
        }
    }

    class DirectionAdapter {
        private Direction direction;
        public DirectionAdapter(Direction d) {
            this.direction = d;
        }

        public Direction getDirection() {
            return this.direction;
        }

        public void setDirection(Direction d) {
            this.direction = direction;
        }
    }

    final static Item storageBoxItem = new Item("Unloaded Storage Box Gun");
    final static Item paintingItem = new Item("Bullets");
    final static int paintingGoldAmount = 7;

    // Returns direction the visitor leaves towards.
    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        visitor.tell("You enter a dimly lit room, some dirty stained glass windows allow a few rays of light.");
        visitor.tell("You manage to make out a few objects, a storage box, seemingly a painting of an old rifle, as well as a large grey floor mat");

        Choices choices = new Choices();
        choices.add(new Choices.Choice("Open storage box", new Runnable(){
                    @Override
                    public void run() {
                        if (visitor.hasIdenticalItem(storageBoxItem)) {
                            visitor.tell("You see that the storage box is already open.");
                            visitor.tell("\"Maybe you took something from here before?\", you wonder");
                            visitor.tell("Someone's behind you, you turn to find no-one, a chill runs down your spine");
                            visitor.tell("\"It might be best to leave quickly\", you find yourself thinking");
                        } else {
                            visitor.tell("You walk up to the storage box: its wood looks old, it seems there's cracks appearing; a peek of the hinges reveals they haven't moved in a while.");
                            visitor.tell("You reach forward and then attempt to wrench it open");
                            visitor.tell("Initially, it seems the old rusty hinges wouldn't budge, but you give it a good tug, and it pops open");
                            visitor.giveItem(storageBoxItem);
                            visitor.tell("You pickup the item inside, its not until you pull it out of the box you realise that its a gun");
                            visitor.tell("The initial surprise winds down as you find it unloaded");
                            visitor.tell("You find the sense that its not a good idea to hang around for too long...");
                        }
                    }
        }));
        choices.add(new Choices.Choice("Examine painting", new Runnable(){
                    @Override
                    public void run() {
                        if (visitor.hasIdenticalItem(paintingItem)) {
                            visitor.tell("You find the paintings familiar, then it hits you.");
                            visitor.tell("You've seen the painting before, the fractures in the decrepit painting, the musty smell of the old paint");
                            visitor.tell("Someone's behind you, you turn to find no-one, a chill runs down your spine");
                            visitor.tell("\"It might be best to leave quickly\", you find yourself thinking");
                        } else {
                            visitor.tell("You step towards the painting");
                            visitor.tell("Looking closely, you can see the cracks in the old canvas.");
                            visitor.tell("While your close to the painting you feel a slight draft on your face");
                            visitor.tell("You pull the painting off the wall to find a cubby hole, whith a box and a few coins sitting next to it");
                            visitor.giveGold(paintingGoldAmount);
                            visitor.giveItem(paintingItem);
                            visitor.tell("It seems there was " + paintingGoldAmount + " coin" + ((paintingGoldAmount > 1)? "s": ""));
                            visitor.tell("Upon closer inspection, the box looks like it has some bullets, maybe it could load a gun...");
                            visitor.tell("You get the impression that you shouldn't hang around here for too long...");
                        }
            }
        }));
        choices.add(new Choices.Choice("Examine floor mat", new Runnable() {
                    @Override
                    public void run() {
                        visitor.tell("It's a dusty old floor mat");
                        visitor.tell("You drop it back to the floor, a plume of dust rises up");
                        visitor.tell("You don't want to hang around too long with all this dust here");
                        visitor.tell("You should leave before you die of a coughing fit...");
                    }
        }));

        Choices.DescriptionAndChoices dac = choices.createMenu();
        char choice = visitor.getChoice(dac.description, dac.arrayOfPossibleChoices);
        choices.handleChoice(choice);

        Choices directionChoices = new Choices();
        DirectionAdapter directionToLeaveAdapted = new DirectionAdapter(directionVistorArrivesFrom);
        directionChoices.add(new Choices.Choice("Leave " + directionToString(directionVistorArrivesFrom), new Runnable() {
                    @Override
                    public void run() {
                        directionToLeaveAdapted.setDirection(directionVistorArrivesFrom);
                    }
        }));
        directionChoices.add(new Choices.Choice("Leave " + directionToString(Direction.opposite(directionVistorArrivesFrom)), new Runnable() {
                    @Override
                    public void run() {
                        directionToLeaveAdapted.setDirection(Direction.opposite(directionVistorArrivesFrom));
                    }
        }));
        Choices.DescriptionAndChoices dacDirection = directionChoices.createMenu();
        char directionChoice = visitor.getChoice(dacDirection.description, dacDirection.arrayOfPossibleChoices);
        directionChoices.handleChoice(directionChoice);

        return directionToLeaveAdapted.getDirection();
    }

    private static String directionToString(Direction direction) {
        if (direction == Direction.FROM_SOUTH) return "South";
        else if (direction == Direction.FROM_WEST) return "West";
        else if (direction == Direction.FROM_NORTH) return "North";
        else if (direction == Direction.FROM_EAST) return "East";
        else return "Unknown direction";
    }
}
