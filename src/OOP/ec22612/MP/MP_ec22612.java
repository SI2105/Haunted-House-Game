package OOP.ec22612.MP;
import OOP.ec22612.MP.contributions.*;

import javax.swing.*;
import java.util.Random;

public class MP_ec22612 {

    public static void main(String[] args) {



        String[] sizes = {"small", "medium","big"};

        int sizeindex = JOptionPane.showOptionDialog(null,"How big would you like the Haunted House to be","Haunted House Size"
                ,JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,sizes
                ,sizes[0]);

        if (sizeindex== -1){
            sizeindex = 0;
            JOptionPane.showMessageDialog(null, "You did not select a size, the size: " + sizes[sizeindex] + " was chosen automatically");
        }

        GUI_House House = new GUI_House(sizes[sizeindex]);

        Visitor v = new GUIVisitor_ec22612();

        Direction d = House.visit(v,Direction.FROM_EAST);


    }

    public static int randomInt(int bound) {
        Random r = new Random();
        return r.nextInt(bound);
    }
}
