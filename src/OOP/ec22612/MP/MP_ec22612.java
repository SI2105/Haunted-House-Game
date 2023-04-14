package OOP.ec22612.MP;
import OOP.ec22612.MP.contributions.*;

import javax.swing.*;

import java.util.Random;

public class MP_ec22612 {

    public static void main(String[] args) {

        String[] sizes = {"small", "medium","big","custom"};

        int sizeindex = JOptionPane.showOptionDialog(null,"How big would you like the Haunted House to be","Haunted House Size"
                ,JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,sizes
                ,sizes[0]);

        if (sizeindex== -1){
            sizeindex = 0;
            JOptionPane.showMessageDialog(null, "You did not select a size, the size: " + sizes[sizeindex] + " was chosen automatically");
        }

        GUI_House House;
        if (sizeindex != 3){
            House = new GUI_House(sizes[sizeindex]);
        }
        else {
            String Custom_Size_String = JOptionPane.showInputDialog("Please enter the custom room size");
            int Custom_Size;
            try{
                Custom_Size = Integer.parseInt(Custom_Size_String);
            }

            catch (Exception a){
                JOptionPane.showMessageDialog(null, "You didn't enter an integer so a custom size has been chose for you");
                Custom_Size = randomInt(36);
            }

            House = new GUI_House(Custom_Size);
        }



        GUIVisitor_ec22612 v = new GUIVisitor_ec22612();


        Direction d = House.visit(v,Direction.FROM_EAST);

        System.exit(0);

    }

    public static int randomInt(int bound) {
        Random r = new Random();
        return r.nextInt(bound);
    }
}
