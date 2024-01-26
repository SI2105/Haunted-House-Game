package HauntedHouseGame.contributions;

import java.util.Scanner;

class Room_ec22914 extends Room
{
    public void print(String message)
    {
        System.out.println(message);
    }

    public static String inputString(String message)
    {
        String answer;
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        answer = scanner.nextLine();
        scanner.close();  
        
        return answer;
    }

    public void openchest(Visitor visitor)
    {
        String question = "What is 2 + 2";
        String answer = "4";
        String user_answer = inputString(question);
        if(answer.equals(user_answer))
        {
            visitor.giveGold(5);
            print("Congrats, you got 5 gold!");
        }
        else
        {
            visitor.takeGold(5);
            print("Unlucky, you lost 5 gold :(");
        }

        return;
    }

    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom)
    {
        String intro = "You encounter a hidden chest at the end of the room";
        String choice = "Do you choose to open the chest?";
        print(intro + "\n" + choice);
        String options = "Yes(y)\nNo(n)";
        char yes_or_no [] = {'y','n'};
        char open = visitor.getChoice(options, yes_or_no);
        
        if (open == 'y');
        {
            openchest(visitor);
        }
        
        return Direction.FROM_NORTH;
    }
}