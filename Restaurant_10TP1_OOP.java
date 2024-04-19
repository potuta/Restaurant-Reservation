import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Restaurant_10TP1_OOP {
    public static void main(String[] args) {
        new ReservationForm();
    }
}

class ReservationForm {

    private JFrame mainFrame = new JFrame("Dinolicious");
    private JLabel restaurantLogo = new JLabel();
    private JLabel labelArr[] = new JLabel[5];
    private JTextField[] textFieldArr = new JTextField[3];
    private JButton[] buttonArr = new JButton[2];
    private JPanel[] panelArr = new JPanel[10];
    private JPanel[] inPanelArr = new JPanel[5];
    private JPanel[] inPanelArr2 = new JPanel[5];
    private JComboBox[] comboBox = new JComboBox[5];

    public static ArrayList<String> reservationFormArr = new ArrayList<>();

    public ReservationForm() {
        Display();
    }

    public void Display() {
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(700, 400);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        //creating the panels
        panelArr[0] = createPanel(mainFrame.getWidth()/2, mainFrame.getHeight());
        panelArr[0].setLayout(new BorderLayout());

        panelArr[1] = createPanel(panelArr[0].getPreferredSize().width-340, mainFrame.getHeight());
        panelArr[1].setLayout(new BorderLayout());

        panelArr[2] = createPanel(panelArr[0].getPreferredSize().width, mainFrame.getHeight());
        panelArr[2].setLayout(new GridLayout(5, 0));

        panelArr[3] = createPanel(panelArr[0].getPreferredSize().width-100, mainFrame.getHeight());
        panelArr[3].setLayout(new GridLayout(5, 0));

        panelArr[0].add(panelArr[1], BorderLayout.WEST);
        panelArr[0].add(panelArr[2], BorderLayout.CENTER);
        panelArr[0].add(panelArr[3], BorderLayout.EAST);
        
        panelArr[4] = createPanel(mainFrame.getWidth()/2, mainFrame.getHeight());
        panelArr[4].setLayout(new BorderLayout());
        
        panelArr[5] = createPanel(mainFrame.getWidth(), mainFrame.getHeight()/10);
        panelArr[5].setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));
        
        for (int i = 0; i <= 4; i++){
            inPanelArr[i] = createPanel(panelArr[2].getWidth(), panelArr[2].getWidth());
            
            panelArr[2].add(inPanelArr[i]);
        }
        
        for (int i = 0; i <= 2; i++){
            inPanelArr2[i] = createPanel(panelArr[2].getWidth(), panelArr[2].getWidth());
            
            panelArr[3].add(inPanelArr2[i]);
        }
        
        inPanelArr2[3] = createPanel(panelArr[2].getWidth(), panelArr[2].getWidth());
        inPanelArr2[4] = createPanel(panelArr[2].getWidth(), panelArr[2].getWidth());

        // creating the labels
        labelArr[0] = createLabel("Name: ");
        labelArr[1] = createLabel("Email: ");
        labelArr[2] = createLabel("Contact No: ");
        labelArr[3] = createLabel("Date: ");
        labelArr[4] = createLabel("Time: ");   
        
        // creating the text fields
        textFieldArr[0] = createTextField(17);
        textFieldArr[1] = createTextField(17);
        textFieldArr[2] = createTextField(17);
        
        // creating the combo boxes
        comboBox[0] = createComboBox("Day");
        for (int i = 1; i <= 31; i++){
            comboBox[0].addItem(i);
        }

        comboBox[1] = createComboBox("Month");
        String[] monthsArr = new String[] {"January", "February", "March", 
                                            "April", "May", "June", 
                                            "July", "August", "September", 
                                            "October", "November", "December"};
        for (int i = 0; i < 12; i++){
            comboBox[1].addItem(monthsArr[i]);
        }
        
        comboBox[2] = createComboBox("Year");
        String[] yearsArr = new String[] {"2024", "2025"};
        for (int i = 0; i < 2; i++){
            comboBox[2].addItem(yearsArr[i]);
        }

        comboBox[3] = createComboBox("1:00");
        comboBox[3].setPreferredSize(new Dimension(100, comboBox[3].getPreferredSize().height));
        String[] timeArr = new String[] {"2:00", "3:00", "4:00", 
                                        "5:00", "6:00", "7:00", "8:00", 
                                        "9:00", "10:00", "11:00", "12:00",};
        for (int i = 0; i < 11; i++){
            comboBox[3].addItem(timeArr[i]);
        }

        comboBox[4] = createComboBox("AM");
        comboBox[4].addItem("PM");
        comboBox[4].setPreferredSize(new Dimension(70, comboBox[3].getPreferredSize().height));

        // creating the buttons
        buttonArr[0] = new JButton("Cancel");
        buttonArr[0].setFocusable(false);
        buttonArr[0].addActionListener(new EventCancelButton());

        buttonArr[1] = new JButton("Next");
        buttonArr[1].setFocusable(false);
        buttonArr[1].addActionListener(new EventNextButton());

        // adding buttons to panel
        panelArr[5].add(buttonArr[0]);
        panelArr[5].add(buttonArr[1]);

        // adding combo boxes to panel
        inPanelArr2[3].add(comboBox[0]);
        inPanelArr2[3].add(comboBox[1]);
        inPanelArr2[3].add(comboBox[2]);

        panelArr[3].add(inPanelArr2[3]);

        inPanelArr2[4].add(comboBox[3]);
        inPanelArr2[4].add(comboBox[4]);

        panelArr[3].add(inPanelArr2[4]);
        
        // adding labels to panel
        for (int i = 0; i <= 4; i++){
            inPanelArr[i].add(labelArr[i]);
        }
        
        // adding text fields to panel
        for (int i = 0; i < 3; i++){
            inPanelArr2[i].add(textFieldArr[i]);
        }
        
        // adding image to panel
        ImageIcon logoPath = new ImageIcon(new ImageIcon("assets\\dinolicious.png").getImage().getScaledInstance(380, 340, Image.SCALE_DEFAULT));
        restaurantLogo.setIcon(logoPath);
        restaurantLogo.setIcon(logoPath);
        panelArr[4].add(restaurantLogo, BorderLayout.CENTER);
        mainFrame.setIconImage(logoPath.getImage());

        // adding panels to frame
        mainFrame.add(panelArr[0], BorderLayout.WEST);
        mainFrame.add(panelArr[4], BorderLayout.EAST);
        mainFrame.add(panelArr[5], BorderLayout.SOUTH);

        mainFrame.revalidate();
        mainFrame.validate();
        mainFrame.repaint();
    }

    public class EventCancelButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 3; i++){
                textFieldArr[i].setText(" ");
            }
            for (int i = 0; i < 5; i++){
                comboBox[i].setSelectedIndex(0);
            }
        }
    }

    public class EventNextButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (textFieldArr[0].getText().length() == 0 || textFieldArr[1].getText().length() == 0 || textFieldArr[2].getText().length() == 0 || 
            comboBox[0].getSelectedIndex() == 0 || comboBox[1].getSelectedIndex() == 0 | comboBox[2].getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Please enter complete details");
            } 
            else {
                // adding reservation information to array list
                for (int i = 0; i < 3; i++){
                    reservationFormArr.add(textFieldArr[i].getText());
                }
                
                for (int i = 0; i < 5; i++){
                    reservationFormArr.add(comboBox[i].getSelectedItem().toString());
                }

                mainFrame.dispose();
                new TableReservation();
            }
        }
    }
    
    private JLabel createLabel(String text) {
        JLabel label = new JLabel();
        label.setText(text);
        label.setFont(new Font("SANS-SERIF", Font.BOLD, 12));
        return label;
    }
    
    private JTextField createTextField(int columns) {
        JTextField textField = new JTextField();
        textField.setColumns(columns);
        return textField;
    }
    
    private JPanel createPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
        panel.setBackground(new Color(244, 221, 194));
        return panel;
    }

    private JComboBox createComboBox(String name) {
        JComboBox comboBox = new JComboBox();
        comboBox.addItem(name);
        return comboBox;
    }
}

class TableReservation extends JFrame {
    private JLabel tableLabel = new JLabel("Pick your table");

    public TableReservation() {
        setTitle("Dinolicious");
        getContentPane().setBackground(new java.awt.Color(222, 184, 135));
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(tableLabel);
        topPanel.setBackground(new java.awt.Color(222, 184, 135));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 3, 40, 40));
        centerPanel.setBackground(new java.awt.Color(222, 184, 135));

        JButton b1 = createTableButton("Table 1");
        JButton b2 = createTableButton("Table 2");
        JButton b3 = createTableButton("Table 3");
        JButton b4 = createTableButton("Table 4");
        JButton b5 = createTableButton("Table 5");
        JButton b6 = createTableButton("Table 6");

        centerPanel.add(b1);
        centerPanel.add(b2);
        centerPanel.add(b3);
        centerPanel.add(b4);
        centerPanel.add(b5);
        centerPanel.add(b6);

        JPanel panel = createPanel();
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);

        add(panel);

        setSize(830, 450);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JButton createTableButton(String tableName) {
        JButton button = new JButton(tableName);
        button.setBorder(null);
        button.setBackground(Color.white);
        button.setPreferredSize(new Dimension(150,100));
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Reservation Complete" 
                + "\nName: " + ReservationForm.reservationFormArr.get(0)
                + "\nEmail: " + ReservationForm.reservationFormArr.get(1)
                + "\nContact No: " + ReservationForm.reservationFormArr.get(2)
                + "\nDate: " + ReservationForm.reservationFormArr.get(3) + ", " +ReservationForm.reservationFormArr.get(4) + ", " +ReservationForm.reservationFormArr.get(5) 
                + "\nTime: " + ReservationForm.reservationFormArr.get(6) + ", " + ReservationForm.reservationFormArr.get(7) 
                + "\nTable: " + button.getText()
                );
                System.exit(0);
            }
        });
        return button;
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        return panel;
    }
}