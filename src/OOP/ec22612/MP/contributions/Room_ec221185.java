package OOP.ec22612.MP.contributions;

class Room_ec221185 extends Room {
    public Direction visit(Visitor Kratos, Direction direction) 
    {
        final Item Axe = new Item("Leviathan Axe");
        Kratos.tell("You need two Gold g");
        Kratos.takeGold(2);
        String Quests = ("Would you like to a) Walk through Vanaheim b) Fight some aesir for gold  c) Go atop the cliffs of Jotunheim d) Go Hunt?");
        char[] Choices = {
            'a',
            'b',
            'c',
            'd'
        };

        char QuestChoice = Kratos.getChoice(Quests, Choices);

        if (QuestChoice == 'a') {
            Kratos.tell("To enter this magical realm you have to forfeit 2 gold mate");
            Kratos.takeGold(2);
        } else if (QuestChoice == 'b') {
            Kratos.tell("You have weakened odins forces take this chilly axe");
            Kratos.giveItem(Axe);
        } else if (QuestChoice == 'c') {
            Kratos.tell("take in the highest peak of all the nine realms and take the gold thats waiting for you");
            Kratos.takeGold(3);
        } else if (QuestChoice == 'd') {
            Kratos.tell("Youve shot down a mystical stag, enjoy your feast and sell the leftovers");
            Kratos.takeGold(4);
        }
        return Direction.opposite(direction);
    }
}
