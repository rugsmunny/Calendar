import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.time.LocalDate;

import static java.awt.Color.*;

public class Calendar extends JFrame {

    Border emptyBorder = BorderFactory.createEmptyBorder();


    Calendar() {
        ImageIcon image = new ImageIcon("pillIcon.jpg");
        super.setIconImage(image.getImage());
        super.setTitle("Calendar");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(null);
        super.setSize(1416, 900);
        setBackgroundImage();
        super.setResizable(false);
        createCalenderLayout();
        super.setVisible(true);
    }

    void setBackgroundImage(){
        JLabel akiraBackDrop = new JLabel(new ImageIcon("akira3.jpg"));

        super.setContentPane(akiraBackDrop);
        super.getContentPane().setPreferredSize(new Dimension(1200, 800));

    }

    void createCalenderLayout() {
        final int weekdayValue = LocalDate.now().getDayOfWeek().getValue();
        for (int i = 1; i < 8; i++) {
            super.add(
                    addCalenderTextFieldAndButtons(
                    addCalenderNotePanels(
                    addCalenderDateAndWeekDay(
                            addCalenderPanelDay(i), i, weekdayValue)
                    )
            ));
        }

        //super.add(addCalendarFavouritesPanel());
        super.setVisible(true);
    }

    JPanel addCalenderPanelDay(int i) {
        JPanel dayPanel = new JPanel();
        dayPanel.setBorder(emptyBorder);

        dayPanel.setBackground(new Color(0,0,0,0));

        dayPanel.setLayout(new GridLayout(12, 7));
        dayPanel.setBounds(2+(i-1)*200,0,198, 860);
        dayPanel.setBorder(new MatteBorder(3,3,3,3,black));

        return dayPanel;
    }

    JPanel addCalenderDateAndWeekDay(JPanel dayPanel, int i, int weekdayValue) {
        JLabel spaceHolderLabel = new JLabel();
JLabel bikeIcon = new JLabel(new ImageIcon("explosion.jpg"));
//bikeIcon.setPreferredSize(new Dimension(180, 70));
//bikeIcon.setVisible(true);

        JLabel nameOfWeekDay = new JLabel(String.valueOf((
                LocalDate.now().getDayOfWeek())
                .minus(LocalDate.now().getDayOfWeek().getValue())
                .plus(i)), SwingConstants.CENTER);

        nameOfWeekDay.setOpaque(false);


        JLabel dateOfWeekDay = new JLabel(String.valueOf((
                LocalDate.now().
                        minusDays(
                                LocalDate.now().getDayOfWeek().getValue() - (i)))),
                SwingConstants.CENTER);
        nameOfWeekDay.setFont(new Font("Helvetica", Font.BOLD, 25));
        dateOfWeekDay.setFont(new Font("Helvetica", Font.ITALIC+Font.BOLD, 20));
        dateOfWeekDay.setOpaque(false);
        nameOfWeekDay.setBackground(new Color(0,0,0,0));
        dateOfWeekDay.setBackground(new Color(0,0,0,0));
        dayPanel.add(nameOfWeekDay);
        if (i == weekdayValue) {
            dayPanel.add(bikeIcon);
        }else dayPanel.add(spaceHolderLabel);
    if(i == 6){
        dateOfWeekDay.setForeground(WHITE);
    }
        dayPanel.add(dateOfWeekDay);


        return dayPanel;
    }

    JPanel addCalenderNotePanels(JPanel dayPanel) {
        for (int j = 0; j < 7; j++) {
            JLabel noteLabels = new JLabel();
            noteLabels.setBorder(emptyBorder);
            //JTextField textFieldPrintNote = new JTextField();
            //textFieldPrintNote.setBorder(emptyBorder);
            //textFieldPrintNote.setEditable(false);
noteLabels.setBackground(new Color(0,0,0,0));
//textFieldPrintNote.setBackground(new Color(0,0,0,0));
 //           dayPanel.add(textFieldPrintNote);
            dayPanel.add(noteLabels);
        }
        return dayPanel;
    }

    JPanel addCalenderTextFieldAndButtons(JPanel dayPanel) {
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
       /* JTextField textFieldTakeNote = new JTextField();
        textFieldTakeNote.setHorizontalAlignment(JTextField.CENTER);
        textFieldTakeNote.setBorder(emptyBorder);

        textFieldTakeNote.setBorder(new MatteBorder(3,0,0,0, black));
        textFieldTakeNote.setText("Add an event");

        JButton addButton = new JButton("Add");
        addButton.setBackground(new Color(0,0,0,0));
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(new Color(0,0,0,0));

        addButton.setBorder(emptyBorder);

        deleteButton.setBorder(emptyBorder);
        textFieldAction(textFieldTakeNote);
        dayPanel.add(textFieldTakeNote);
        dayPanel.add(addButton);
        dayPanel.add(deleteButton);

        addButtonEventListener(dayPanel, addButton);
        deleteButtonEventListener(dayPanel, deleteButton);*/
dayPanel.add(label1);
dayPanel.add(label2);

        return dayPanel;
    }

    JPanel addCalendarFavouritesPanel(){
        JPanel favouritesPanel = new JPanel();
        favouritesPanel.add(comboBoxButton());
        favouritesPanel.add(comboBoxFavouritesTF());
        favouritesPanel.add(setComboBoxFav());
        favouritesPanel.setLayout(null);
        favouritesPanel.setBounds(40,710,550,40);
        favouritesPanel.setBorder(BorderFactory.createLineBorder(BLACK));
        favouritesButtonAction(comboBoxButton(),comboBoxFavouritesTF(),setComboBoxFav());
        return favouritesPanel;
    }

    JButton comboBoxButton(){
        JButton favouritesBtn = new JButton("Favoriter");
        favouritesBtn.setBorder(emptyBorder);
        //favouritesBtn.setVisible(true);
        favouritesBtn.setBounds(20,10, 100, 20);

        return favouritesBtn;
    }

    JTextField comboBoxFavouritesTF(){
        JTextField favouritesTF = new JTextField();
        favouritesTF.setBorder(emptyBorder);
        favouritesTF.setBounds(130,10, 200, 20);
        //favouritesTF.setVisible(true);
        return favouritesTF;
    }

    JComboBox setComboBoxFav(){
        JComboBox<String> favourites = new JComboBox<>();
        favourites.setBounds(340, 10,200,20);
        //favourites.setVisible(true);
        favourites.setBackground(WHITE);
        return favourites;
    }

    void favouritesButtonAction(JButton b, JTextField tF, JComboBox aL){
        b.addActionListener(e -> {
            if (tF.getText().length() > 0){
                aL.addItem(tF.getText());
                tF.setText("");

            }
        });

    }

    private void addButtonEventListener(JPanel dayPanel, JButton button) {

        button.addActionListener(e -> {
            for (Component label : dayPanel.getComponents()) {
                if (label instanceof JTextField && ((JTextField) label).getText().equalsIgnoreCase("")) {
                    ((JTextField) label).setText(tempPlaceHolder);
                    tempPlaceHolder = "";

                    break;
                }
            }
        });
    }

    private void deleteButtonEventListener(JPanel dayPanel, JButton button) {
        button.addActionListener(e -> {
            for (Component label : dayPanel.getComponents()) {
                if (label instanceof JTextField && ((JTextField) label).getText().length() > 0 &&
                        !((JTextField) label).getText().equalsIgnoreCase("Add an event")) {
                    ((JTextField) label).setText("");
                    break;
                }
            }
        });
    }

    boolean bFocusIndicated = false;
    String tempPlaceHolder;
    void textFieldAction(JTextField noteTf) {
        noteTf.addFocusListener(new FocusAdapter() {

            public void focusGained(FocusEvent e) {
                if(!bFocusIndicated) {
                    noteTf.setText("");
                    bFocusIndicated = true;

                }
            }

            public void focusLost(FocusEvent e) {
                tempPlaceHolder = noteTf.getText();
                bFocusIndicated = false;
                noteTf.setText("Add an event");
                noteTf.revalidate();
            }


        });

    }
}
