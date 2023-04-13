package OOP.ec22612.MP;

import OOP.ec22612.MP.contributions.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIVisitor_ec22612 extends JFrame implements Visitor{

    private int gold;
    private ArrayList<Item> items;
    private int next;
    JPanel panel;
    JLabel label;

    JPanel Goldpanel;
    JLabel Goldlabel;
    JLabel GoldValue;

    JPanel Itempanel;
    JLabel Itemlabel;
    JTextArea Items_area;

    JPanel IOpanel;


    JPanel Output_panel;
    JLabel Output;
    JScrollPane ScrollOutput;
    JTextArea Outputarea;

    JPanel Input_panel;
    JLabel Input;
    JPanel Input_buttons;





    JPanel ExitPanel;


    JButton Exit_button;







    //GUI related variables




    GUIVisitor_ec22612(){

        items = new ArrayList<>();
        SetFrame(600,800);
        gold = 0;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        label = new JLabel("Welcome to the Haunted House");

        Goldpanel = new JPanel();
        Goldlabel = new JLabel("Your Gold: ");
        GoldValue = new JLabel(Integer.toString(gold));


        Goldpanel.setLayout(new FlowLayout());
        Goldpanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        Goldpanel.add(Goldlabel);
        Goldpanel.add(GoldValue);

        Itempanel = new JPanel();
        Itemlabel = new JLabel("You have the following items");
        Items_area = new JTextArea(" ");
        Items_area.setPreferredSize(new Dimension(200,300));
        JScrollPane scroll_Items_area = new JScrollPane(Items_area);

        Itempanel.setLayout(new FlowLayout());
        Itempanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        Itempanel.add(Itemlabel);
        Itempanel.add(scroll_Items_area);
        Exit_button = new JButton("Exit");

        ExitPanel = new JPanel();

        panel.add(label);

        IOpanel = new JPanel();

        Output_panel = new JPanel();
        Output = new JLabel("Output");
        ScrollOutput = new JScrollPane();
        Outputarea = new JTextArea();

        Input_panel = new JPanel();
        Input = new JLabel("Input");
        Input_buttons = new JPanel();

        panel.add(Goldpanel);
        panel.add(Itempanel);

        Exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        ExitPanel.add(Exit_button);


        IOpanel.setPreferredSize(new Dimension(1000,200));
        IOpanel.add(new JLabel("IO"));

        panel.add(IOpanel);

        panel.add(ExitPanel);






        //panel.setLayout();
        panel.setPreferredSize(new Dimension(200,400));
        getContentPane().add(panel);






    }

    public void SetFrame(int width,int height){
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        setTitle(getClass().getSimpleName());
                        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        setSize(width, height);
                        setLocationRelativeTo(null);
                        setVisible(true);


                    }
                }
        );


    }

    public void tell(String messageForVisitor) {
        setVisible(true);
        panel.setVisible(true);
       JOptionPane.showMessageDialog(IOpanel,messageForVisitor);



    }

    public char getChoice(String descriptioOfChoices, char[] arrayOfPossibleChoices) {
        Character[] possibleChoiceoObj = new Character[arrayOfPossibleChoices.length];

        for (int i = 0; i <arrayOfPossibleChoices.length; i++){
            possibleChoiceoObj[i] = Character.valueOf(arrayOfPossibleChoices[i]);
        }

       int index = JOptionPane.showOptionDialog(IOpanel,descriptioOfChoices,"Make a Choice"
       ,JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,possibleChoiceoObj
       ,possibleChoiceoObj[0]);

       if(index == -1){
           index = 0;
           JOptionPane.showMessageDialog(IOpanel,"Last option you didn't answer, the answer:  " + arrayOfPossibleChoices[index] +" was automatically selected for you"  );
       }


        return arrayOfPossibleChoices[index];
    }

    public boolean giveItem(Item itemGivenToVisitor) {

        int dialogButton = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog(IOpanel,"You are being offered " + itemGivenToVisitor, "Item Offer", dialogButton );

        if(dialogButton == JOptionPane.YES_OPTION){
            items.add(itemGivenToVisitor);
            update_items_area(itemGivenToVisitor);



            return true;
        }
        else{
            return false;

        }

    }

    public boolean hasIdenticalItem(Item itemToCheckFor) {
        for (Item item : items){
            if(itemToCheckFor == item ){
                return true;
            }
        }
        return false;
    }

    public boolean hasEqualItem(Item itemToCheckFor) {
        for (Item item : items){
            if(itemToCheckFor.equals(item) ){
                return true;
            }
        }
        return false;
    }

    public void giveGold(int numberOfPiecesToGive) {
        tell("You are given "+numberOfPiecesToGive+" gold pieces.");

        gold += numberOfPiecesToGive;

        update_gold();

    }

    public int takeGold(int numberOfPiecesToTake) {
        if(numberOfPiecesToTake<0){
            tell("This room tried to take negative number of gold!! ");
            return 0;
        }
        int t;
        if(numberOfPiecesToTake>gold){
            t = gold;
        }
        else {
            t = numberOfPiecesToTake;
        }

        tell("You will have "+ t + " gold taken away from you");
        gold -= t;
        update_gold();


        return t;
    }

    public void update_gold(){
        Goldpanel.setVisible(false);

        GoldValue.setText(Integer.toString(gold));
        Goldpanel.setVisible(true);

    }

    public void update_items_area(Item itemGivenToVisitor){
        String text = Items_area.getText();
        text += itemGivenToVisitor + "\n" ;

        Itempanel.setVisible(false);
        Items_area.setText(text);
        Itempanel.setVisible(true);
    }

}
