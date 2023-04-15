package OOP.ec22612.MP;

import OOP.ec22612.MP.contributions.*;
import jdk.jfr.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GUIVisitor_ec22612 extends JFrame implements Visitor{

    static enum Semaphore {WAITING,HALT,SEND};
    static enum IO {INPUT, OUTPUT}

    private int gold;
    private ArrayList<Item> items;
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

    JButton NextOutput;

    JPanel Input_panel;
    JLabel Input;
    JPanel Input_buttons;

    int Input_Index;





    JPanel ExitPanel;


    JButton Exit_button;


    Semaphore OutputSemaphore;

    Semaphore InputSemaphore;


    IO IOcheck;







    //GUI related variables




    GUIVisitor_ec22612(){

        items = new ArrayList<>();
        SetFrame(600,800);
        gold = 0;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        label = new JLabel("Welcome to the Haunted House");
        label.setFont(new Font(Font.SERIF,Font.BOLD,30));

        Goldpanel = new JPanel();
        Goldlabel = new JLabel("Your Gold: ");
        GoldValue = new JLabel(Integer.toString(gold));

        Goldlabel.setFont(new Font(Font.SERIF,Font.BOLD,25));
        GoldValue.setFont(new Font(Font.SERIF,Font.BOLD,25));


        Goldpanel.setLayout(new FlowLayout());
        Goldpanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        Goldpanel.add(Goldlabel);
        Goldpanel.add(GoldValue);

        Itempanel = new JPanel();
        Itemlabel = new JLabel("You have the following items");
        Items_area = new JTextArea(" ");
        Items_area.setPreferredSize(new Dimension(200,300));
        JScrollPane scroll_Items_area = new JScrollPane(Items_area);

        Itempanel.setLayout(new BoxLayout(Itempanel, BoxLayout.Y_AXIS));

        Itempanel.add(Itemlabel);
        Itempanel.add(scroll_Items_area);



        IOpanel = new JPanel();
        IOpanel.setLayout(new BoxLayout(IOpanel, BoxLayout.Y_AXIS));

        Output_panel = new JPanel();
        Output = new JLabel("Output");
        Output_panel.setLayout(new BoxLayout(Output_panel, BoxLayout.Y_AXIS));

        Outputarea = new JTextArea();
        Outputarea.setFont(new Font("Serif",Font.PLAIN,20));
        Outputarea.setLineWrap(true);
        ScrollOutput = new JScrollPane(Outputarea);
        NextOutput = new JButton("Next");

        Output_panel.add(Output);
        Output_panel.add(ScrollOutput);
        Output_panel.add(NextOutput);
        OutputSemaphore = Semaphore.WAITING;

        NextOutput.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        OutputSemaphore = Semaphore.WAITING;
                        JScrollBar vertical = ScrollOutput.getVerticalScrollBar();
                        vertical.setValue( vertical.getMaximum() );
                    }
                }
        );

        Input_panel = new JPanel();
        Input = new JLabel("Input");
        Input_buttons = new JPanel();
        Input_panel.setLayout(new BoxLayout(Input_panel, BoxLayout.Y_AXIS));
        Input_panel.setVisible(false);
        Input_panel.add(Input);
        Input_panel.add(Input_buttons);
        Input_Index = 0;
        InputSemaphore = Semaphore.WAITING;

        Exit_button = new JButton("Exit");

        ExitPanel = new JPanel();

        panel.add(label);



        panel.add(Goldpanel);
        panel.add(Itempanel);

        Exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });

        ExitPanel.add(Exit_button);


        IOpanel.setPreferredSize(new Dimension(1000,200));
        IOpanel.add(new JLabel("IO"));


        IOpanel.add(Output_panel);
        IOpanel.add(Input_panel);
        panel.add(IOpanel);

        panel.add(ExitPanel);

        IOcheck = IO.OUTPUT;






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
        IOcheck = IO.OUTPUT;
        setVisible(true);
        panel.setVisible(true);

        while (OutputSemaphore == Semaphore.WAITING){
            Outputarea.append(messageForVisitor + "\n" );
            OutputSemaphore = Semaphore.HALT;
        }

        while(OutputSemaphore == Semaphore.HALT){
            Output_panel.repaint();
        }




    }

    class InputActionListener implements ActionListener{

        int index;

        InputActionListener(int index){
            this.index = index;

        }
        @Override
        public void actionPerformed(ActionEvent e) {
           Input_Index = index;
           InputSemaphore = Semaphore.SEND;
        }


    }

    public char getChoice(String descriptioOfChoices, char[] arrayOfPossibleChoices) {

        tell(descriptioOfChoices);
        NextOutput.doClick();
        NextOutput.setEnabled(false);

        Input_panel.setVisible(true);
        for (int i = 0; i<arrayOfPossibleChoices.length; i++){

            JButton new_button = new JButton(String.valueOf(arrayOfPossibleChoices[i]));

            new_button.addActionListener(new InputActionListener(i));
            Input_buttons.add(new_button);
            Input_panel.revalidate();

        }

        while (InputSemaphore != Semaphore.SEND){
            Input_panel.repaint();
        }

        InputSemaphore = Semaphore.WAITING;

        Input_buttons.removeAll();
        NextOutput.setEnabled(true);
        Input_panel.setVisible(false);



        return arrayOfPossibleChoices[Input_Index];
    }

    public boolean giveItem(Item itemGivenToVisitor) {


         char choice = getChoice("You are being offered " + itemGivenToVisitor + "\n Want to pick it up?",new char []{'y','n'});

        if(choice == 'y'){
            items.add(itemGivenToVisitor);
            update_items_area(itemGivenToVisitor);
            JLabel new_item_label = new JLabel(itemGivenToVisitor + "Has been added to your inventory");
            new_item_label.setFont(new Font("Serif", Font.BOLD,18));
            Itempanel.add(new_item_label);

            Timer timer = new Timer(4000, event -> {
                Itempanel.remove(new_item_label);
                Itempanel.revalidate();
                Itempanel.repaint();
            });
            timer.setRepeats(false);
            timer.start();
            Itempanel.revalidate();
            return true;
        }
        else {
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

        JLabel givegoldlabel = new JLabel("+" + numberOfPiecesToGive);
        givegoldlabel.setFont(new Font("Serif",Font.BOLD,18));
        givegoldlabel.setForeground(new Color(197, 179, 88));
        Goldpanel.add(givegoldlabel);

        Timer timer = new Timer(4000, event -> {
            Goldpanel.remove(givegoldlabel);
            Goldpanel.revalidate();
            Goldpanel.repaint();
        });
        timer.setRepeats(false);
        timer.start();
        Goldpanel.revalidate();

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

        JLabel takegoldlabel = new JLabel("-" + t);
        takegoldlabel.setFont(new Font("Serif",Font.BOLD,18));

        takegoldlabel.setForeground(new Color(255,0,0));
        Goldpanel.add(takegoldlabel);

        Timer timer = new Timer(4000, event -> {
            Goldpanel.remove(takegoldlabel);
            Goldpanel.revalidate();
            Goldpanel.repaint();
        });
        timer.setRepeats(false);
        timer.start();
        Goldpanel.revalidate();
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
