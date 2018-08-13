package MenuIS;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Keyur Khadka, Darshana Karki, Avaya Baniya
 */
public class MenuInfo implements ActionListener {
    
    //Variable Declaration for GUI Components
    
    private JFrame frame;
    private JTextField txtGameId;
    private JTextField txtGameName;
    private JTextField txtPrice;
    private JTextField txtSearchPrice;
   
    private JLabel lblGameName;
    private JLabel lblGameId;
    private JLabel lblPrice;
    private JLabel lblGenre;
    private JLabel lblPlatform;
    private JLabel lblRating;
    private JLabel lblStar;
    
    private ButtonGroup btnGroupGenre;
    
    private JButton btnAdd;
    private JButton btnClear;
    private JButton btnClearTable;
    private JButton btnSearchPrice;
    private JButton btnSearchGenre;
    private JButton[] btnRating;
    
    private JPanel panelAdd;
    private JPanel panelDisplay;
    private JPanel panelPlatform;
    
    private JScrollPane jScrollPane;
    
    private JComboBox <String> comboSearchGenre;
    private JComboBox <String> comboGenre;
    
    private JTable tableGame;
    private DefaultTableModel model;
    
    private JRadioButton radPlayStation;
    private JRadioButton radXBox;
    private JRadioButton radPC;
    
    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuHelp;
    private JMenuItem itemOpenFile;
    private JMenuItem itemExit;
    
    private ArrayList <Games> list;
    
    String rating = "";
    
    public MenuInfo() throws IOException
    {
        guiComponents();
        list = new ArrayList <> ();
    }
    
    public void guiComponents() throws FileNotFoundException, IOException
    {   
        //Creating JFrame
        frame = new JFrame("Gaming Information System");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.decode("#363837"));

        //Adding JMenuBar to JFrame
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        //Adding JMenu to JMenuBar
        menuFile = new JMenu(); 
        menuFile.setText("File");
        menuBar.add(menuFile);

        //Adding JMenuItem to JMenu
        itemOpenFile = new JMenuItem();
        itemOpenFile.setText("Open File");
        itemOpenFile.addActionListener(this);
        menuFile.add(itemOpenFile);

        //Adding JMenuItem to JMenu
        itemExit = new JMenuItem();
        itemExit.setText("Exit");
        itemExit.addActionListener(this);
        menuFile.add(itemExit);

        //Adding JMenu to JMenuBar
        menuHelp = new JMenu("Help");
        menuHelp.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                try 
                {
                    Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + 
                            Thread.currentThread().getContextClassLoader().getResource("resources/help.txt"));
                    
                } 
                catch (IOException ex)
                {
                    JOptionPane.showMessageDialog(frame, "Cannot open file", "Error Opening File", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });
        menuBar.add(menuHelp);

        //Initializing JPanel for Game Input
        panelAdd = new JPanel();
        panelAdd.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#A2CE45"), 2, true), 
                "Game Input", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 18), Color.decode("#ffe0b2")));
        panelAdd.setLayout(null); 
        panelAdd.setBounds(10, 20, 760, 250);
        panelAdd.setOpaque(false);
        frame.add(panelAdd);

        //Initializing JLabel Game ID
        lblGameId = new JLabel();
        lblGameId.setFont(new Font("Tahoma", 0, 18));
        lblGameId.setText("Game ID");
        lblGameId.setBounds(20, 30, 80, 30);
        lblGameId.setForeground(Color.decode("#8ffcff"));
        panelAdd.add(lblGameId);

        //Initializing JTextField for Game ID
        txtGameId = new JTextField();
        txtGameId.setBounds(150, 30, 190, 30);
        txtGameId.setBackground(Color.decode("#d8d8d8"));
        txtGameId.setFont(new Font("Tahoma", 0, 18));
        panelAdd.add(txtGameId);

        //Initializing JLabel Game Name
        lblGameName = new JLabel();
        lblGameName.setFont(new Font("Tahoma", 0, 18));
        lblGameName.setText("Game Name");
        panelAdd.add(lblGameName);
        lblGameName.setBounds(20, 90, 100, 30);
        lblGameName.setForeground(Color.decode("#8ffcff"));

        //Initializing JTextField for Game Name
        txtGameName = new JTextField();
        txtGameName.setBounds(150, 90, 190, 30);
        txtGameName.setBackground(Color.decode("#d8d8d8"));
        txtGameName.setFont(new Font("Tahoma", 0, 18));
        panelAdd.add(txtGameName);

        //Initializing JLabel Price
        lblPrice = new JLabel();
        lblPrice.setFont(new Font("Tahoma", 0, 18));
        lblPrice.setText("Price");
        panelAdd.add(lblPrice);
        lblPrice.setBounds(20, 150, 80, 30);
        lblPrice.setForeground(Color.decode("#8ffcff"));

        //Initializing JTextField for Price
        txtPrice = new JTextField();
        txtPrice.setBounds(150, 150, 190, 30);
        txtPrice.setBackground(Color.decode("#d8d8d8"));
        txtPrice.setFont(new Font("Tahoma", 0, 18));
        panelAdd.add(txtPrice);

        //Initializing JLabel for Genre
        lblGenre = new JLabel();
        lblGenre.setFont(new Font("Tahoma", 0, 18));
        lblGenre.setText("Genre");
        panelAdd.add(lblGenre);
        lblGenre.setBounds(420, 30, 80, 30);
        lblGenre.setForeground(Color.decode("#8ffcff"));
        
        panelPlatform = new JPanel();
        panelPlatform.setBorder(BorderFactory.createTitledBorder(""));
        panelPlatform.setLayout(null);
        panelPlatform.setBounds(510, 90, 240, 38);
        panelAdd.add(panelPlatform);

        //Initializing JComboBox for Genre
        comboGenre = new JComboBox();
        DefaultComboBoxModel comboModelAdd = new DefaultComboBoxModel<>
                                            (new String[] { "Sports", "Racing", "Action", "Strategy", "Simulation" });
        comboGenre.setFont(new Font("Tahoma", 0, 18));
        comboGenre.setModel(comboModelAdd);
        comboGenre.setBounds(510, 30, 240, 30);
        panelAdd.add(comboGenre);

        //Initializing JLabel for Platform
        lblPlatform = new JLabel();
        lblPlatform.setFont(new Font("Tahoma", 0, 18));
        lblPlatform.setText("Platform");
        panelAdd.add(lblPlatform);
        lblPlatform.setBounds(420, 90, 80, 30);
        lblPlatform.setForeground(Color.decode("#8ffcff"));
        
        //Initializing JLabel for Rating
        lblRating = new JLabel();
        lblRating.setFont(new Font("Tahoma", 0, 18));
        lblRating.setText("Rating");
        panelAdd.add(lblRating);
        lblRating.setBounds(420, 150, 70, 30);
        lblRating.setForeground(Color.decode("#8ffcff"));

        //Initializing ButtonGroup to hold multiple JRadioButton for Genre
        btnGroupGenre = new ButtonGroup();

        //Initializing JRadioButton for PlayStation
        radPlayStation = new JRadioButton();
        radPlayStation.setFont(new Font("Tahoma", 0, 14));
        radPlayStation.setText("PlayStation");
        radPlayStation.setBounds(8, 10, 95, 25);
        radPlayStation.setSelected(true);
        btnGroupGenre.add(radPlayStation);
        panelPlatform.add(radPlayStation);

        //Initializing JRadioButton for XBox
        radXBox = new JRadioButton();
        radXBox.setFont(new Font("Tahoma", 0, 14));
        radXBox.setText("XBox");
        radXBox.setBounds(110, 10, 57, 25);
        btnGroupGenre.add(radXBox);
        panelPlatform.add(radXBox);

        //Initializing JRadioButton for PC
        radPC = new JRadioButton();
        radPC.setFont(new Font("Tahoma", 0, 14));
        radPC.setText("PC");
        radPC.setBounds(180, 10, 50, 23);
        btnGroupGenre.add(radPC);
        panelPlatform.add(radPC);
        
        //Initializing ButtonGroup for Ratings
        btnRating = new JButton[5];
        //Adding star to 5 JButtons
        int x = 0;
        InputStream im = this.getClass().getClassLoader().getResourceAsStream("resources/star.png");
        Image img1 = ImageIO.read(im);
        for (int i = 0; i < 5; i++)
        {
            btnRating[i] = new JButton();
            btnRating[i].setBounds(510 + x, 150, 40, 32);
            btnRating[i].setIcon(new ImageIcon(img1));
            btnRating[i].addActionListener(this);
            panelAdd.add(btnRating[i]);
            x = x + 50;
        }

        //Initializing JButton to Add game details
        btnAdd = new JButton();
        btnAdd.setFont(new Font("Tahoma", 0, 16));
        btnAdd.setText("Add");
        btnAdd.setBounds(560, 210, 90, 29);
        btnAdd.setBackground(Color.decode("#d4e2f9"));
        btnAdd.addActionListener(this);
        panelAdd.add(btnAdd);

        //Initializing JButton to Clear game details
        btnClear = new JButton();
        btnClear.setFont(new Font("Tahoma", 0, 16));
        btnClear.setText("Clear");
        btnClear.setBounds(660, 210, 90, 29);
        btnClear.setBackground(Color.decode("#d4e2f9"));
        btnClear.addActionListener(this);
        panelAdd.add(btnClear);

        //Initializing JPanel for Game Details 
        panelDisplay = new JPanel();
        panelDisplay.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#A2CE45"), 2, true),
                "Game Details", TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", 0, 18), Color.decode("#ffe0b2")));
        panelDisplay.setLayout(null);
        panelDisplay.setBounds(10, 300, 760, 350);
        panelDisplay.setOpaque(false);
        frame.add(panelDisplay);

        //Initializing JButton to Clear Table
        btnClearTable = new JButton();
        btnClearTable.setFont(new Font("Tahoma", 0, 16));
        btnClearTable.setText("Clear Table");
        btnClearTable.setBounds(620, 305, 130, 30);
        btnClearTable.setBackground(Color.decode("#d4e2f9"));
        btnClearTable.addActionListener(this);
        panelDisplay.add(btnClearTable);

        //Initializing JTextField for Search by price
        txtSearchPrice = new JTextField();
        txtSearchPrice.setBounds(490, 30, 160, 30);
        txtSearchPrice.setBackground(Color.decode("#d8d8d8"));
        txtSearchPrice.setFont(new Font("Tahoma", 0, 18));
        panelDisplay.add(txtSearchPrice);
        
        //Setting a hint text Price in the textfield with gray color and removing the text when textfield is clicked
        txtSearchPrice.setText("Enter Price Here");
        txtSearchPrice.setFont(new Font("Tahoma", Font.ITALIC, 14));
        txtSearchPrice.setForeground(Color.GRAY);
        txtSearchPrice.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) //when textfield is pressed, the text disappears
            { 
                txtSearchPrice.setText(""); 
                txtSearchPrice.setFont(new Font("Tahoma", 0, 18));
                txtSearchPrice.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {   //when textfield is released, the text reappears
                
                if(txtSearchPrice.getText().equals(""))
                {
                    txtSearchPrice.setFont(new Font("Tahoma", Font.ITALIC, 14));
                    txtSearchPrice.setText("Enter Price Here");
                    txtSearchPrice.setForeground(Color.GRAY);
                }
                
            }
        });

        //Initializing JButton for Searching by price
        btnSearchPrice = new JButton();
        btnSearchPrice.setFont(new Font("Tahoma", 0, 16));
        btnSearchPrice.setText("Search");
        btnSearchPrice.setBounds(660, 30, 90, 30);
        btnSearchPrice.setBackground(Color.decode("#d4e2f9"));
        btnSearchPrice.addActionListener(this);
        panelDisplay.add(btnSearchPrice);

        //Initializing JComboBox for searching games by genre
        comboSearchGenre = new JComboBox();
        DefaultComboBoxModel comboModelSearch = new DefaultComboBoxModel<>
                                                (new String[] { "Sports", "Racing", "Action", "Strategy", "Simulation" });
        comboSearchGenre.setModel(comboModelSearch);
        comboSearchGenre.setFont(new Font("Tahoma", 0, 18));
        comboSearchGenre.setBounds(10, 30, 120, 30);
        panelDisplay.add(comboSearchGenre);

        //Initializing JButton to View Available Games from the JTable
        btnSearchGenre = new JButton();
        btnSearchGenre.setFont(new Font("Tahoma", 0, 16));
        btnSearchGenre.setText("View Available Games");
        btnSearchGenre.setBounds(140, 30, 190, 30);
        btnSearchGenre.setBackground(Color.decode("#d4e2f9"));
        btnSearchGenre.addActionListener(this);
        panelDisplay.add(btnSearchGenre);

        //Initializing JTable
        tableGame = new JTable();
        tableGame.setModel(new DefaultTableModel(
             new Object [][] {},
             new String [] {
                 "Game ID", "Game Name", "Genre", "Platform", "Price", "Rating"
             }
         ));
        tableGame.setRowHeight(30);
        tableGame.setFont(new Font("Tahoma", 0, 16));
        tableGame.setOpaque(false);
        tableGame.getTableHeader().setFont(new Font("Tahoma", 0, 16));
        tableGame.getTableHeader().setReorderingAllowed(false);
        tableGame.getTableHeader().setResizingAllowed(false);
        panelDisplay.add(tableGame);

        //Initializing JScrollPane for JTable
        jScrollPane = new JScrollPane(tableGame);
        panelDisplay.add(jScrollPane);
        jScrollPane.setBounds(10, 75, 740, 220);
        jScrollPane.getViewport().setOpaque(false);
        jScrollPane.setOpaque(false);
        
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("resources/lightgreen.png"));
        JLabel backgroundImage = new JLabel();
        backgroundImage.setIcon(icon);

        backgroundImage.setBounds(130, 5, 650, 650); //background image
        backgroundImage.setOpaque(false);
        frame.add(backgroundImage);
        
        ImageIcon frameIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/gamelogo.png"));
        frame.setIconImage(frameIcon.getImage());
       
        frame.setSize(795, 720);
        frame.setVisible(true);
       
    }
    
    public static void main(String[] args) throws IOException 
    {
        new MenuInfo();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        for (int i = 0; i < 5 ; i++)
        {
            if (e.getSource() == btnRating[i] )
            {
                lblStar = new JLabel();
                switch (i)
                {
                    case 0:
                        rating = "1 star";
                        lblStar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/1star.jpg")));
                        break;
                    case 1:
                        rating = "2 star";
                        lblStar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/2star.jpg")));
                        break;
                    case 2:
                        rating = "3 star";
                        lblStar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/3star.jpg")));
                        break; 
                    case 3:
                        rating = "4 star";
                        lblStar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/4star.jpg")));
                        break;
                    case 4:
                        rating = "5 star";
                        lblStar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/5star.jpg")));
                        break;
                    default:
                        break;
                }
                
                //rating = String.valueOf(i+1)+" Stars";//rating value stored to show in table
                for (int j = 0; j < 5; j++)//looping 5 times to manage color of each button
                {  
                    if (j <= i) 
                    {
                        btnRating[j].setBackground(Color.decode("#FFD700"));
                    }
                    else
                    {
                        btnRating[j].setBackground(UIManager.getColor("control"));
                    }
                }
            }
        }
        if (e.getSource() == btnAdd) {
           addToTable();
        } else if (e.getSource() == btnClear) {
           clearFromTxt();
        } else if (e.getSource() == btnSearchPrice) {
           searchPrice();
        } else if (e.getSource() == btnSearchGenre) {
            searchGenre();
        } else if (e.getSource() == itemOpenFile) {
            openFile();
        } else if(e.getSource() == itemExit) {
            exit();
        } else if (e.getSource() == btnClearTable) {
            clearTable();
        }   
    }
    //adds value only one time
    public void addToTable() 
    {
        try {
            String gameId = txtGameId.getText();
            String gameName = txtGameName.getText();
            double price = Double.parseDouble(txtPrice.getText());
            String genre = (String) comboGenre.getSelectedItem();
            String platform = radPlayStation.getText();
            if(radXBox.isSelected())
            {
                platform = radXBox.getText();
            } 
            else if(radPC.isSelected())
            {
                platform = radPC.getText();
            }
            int rowCount = tableGame.getRowCount();
            int nextRow = 0;
            boolean sameIdFlag = false;
            String s;
            do{
                if(rowCount == 0) // if there is no row, nothing will be executed
                {
                    break;
                }
                s = (String) tableGame.getValueAt(nextRow, 0); //get value of row
                nextRow++;                                     //increase row by 1
                if (gameId.equals(s))                           //same game id error check
                {
                    sameIdFlag = true;                          //if game id is same, sameIdFlag is true else it remains false
                }
            }while (nextRow<rowCount);                  
            
            
            if( !gameId.isEmpty() && !gameName.isEmpty() && price > 0) //condition will execute if gameId, name and price are not empty
            {
                if (!sameIdFlag) //condition will execute if sameIdFlag is not true
                {
                    if(!rating.isEmpty()) 
                    {
                        model=(DefaultTableModel) tableGame.getModel();
                        tableGame.getColumn("Rating").setCellRenderer(new LabelRenderer());
                        model.addRow(new Object[]
                        {gameId,gameName,genre,platform,String.valueOf(price),lblStar});
                        
                        Games game = new Games(gameId, gameName, platform, genre, price, rating);
                        list.add(game); //Adding value in the table to a list as object of Games class
                        clearFromTxt();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(frame, "Please rate the game", 
                                "Game Rating Not Found", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else 
                {
                    JOptionPane.showMessageDialog(frame, "The ID is already in use. Enter a unique ID", 
                            "Same ID Error", JOptionPane.ERROR_MESSAGE); 
                    txtGameId.setText("");
                }     
            }
            else
            {
                 JOptionPane.showMessageDialog(frame, "Text Field is empty. Enter valid data", 
                         "Empty Field Error", JOptionPane.WARNING_MESSAGE);
            }   
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(frame, "Please enter valid data", 
                    "Error", JOptionPane.WARNING_MESSAGE);
        }     
    }
    
    //Clear text from textfields and reset radio buttons and combo box
    public void clearFromTxt()
    {
        txtGameId.setText("");
        txtGameName.setText("");
        txtPrice.setText("");
        radPlayStation.setSelected(true);
        comboGenre.setSelectedIndex(0);
        rating="";
        for (int j = 0; j < 5; j++) 
        {
             btnRating[j].setBackground(UIManager.getColor("control"));
        }
    }
    
    //Sorting list for price
    public static ArrayList <Games> sort (ArrayList <Games> a)
    {
 
        for(int i = 0 ; i < a.size()-1 ; i++)
        {
            int min = i;
            for(int j = i+1; j < a.size(); j++) 
            {
                
                if( a.get(j).getPrice() < a.get(min).getPrice())
                {
                    min = j;
                }
            }
            //swaping values
            Games temp = a.get(i);
            a.set(i,a.get(min));
            a.set(min, temp);
        }
        return a;
    }
    
    //method for binary Search which returns a game object
    public Games binarySearch(ArrayList <Games> a, int low, int high, double searchValue)
    {
        if(low <= high)
        {
            int mid = (low + high)/2;
            if (a.get(mid).getPrice() == searchValue)
            {
                return a.get(mid) ;
            }
            else if(a.get(mid).getPrice() < searchValue)
            {
                return binarySearch(a, mid + 1, high, searchValue);
            }
            else if (a.get(mid).getPrice() > searchValue)
            {
                return binarySearch(a,low, mid - 1, searchValue);
            }
            
        }
        return new Games("", "", "", "", -1, "");
    }
    
    public void searchPrice()
    {
        try {
            Games searchedValue = binarySearch(sort(list), 0 , list.size(), Double.parseDouble(txtSearchPrice.getText()));
            if(searchedValue.getPrice() == -1)
            {
                JOptionPane.showMessageDialog(frame, "Entered price is invalid", 
                        "Searched Value Not Found", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                String name = searchedValue.getGameName();
                String price = String.valueOf(searchedValue.getPrice());
                JOptionPane.showMessageDialog(frame, "Game: " + name + "\nPrice: " + price , 
                        "Game found", JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(frame, "Enter value to search game", 
                    "Price Field Empty", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void searchGenre()
    {
        ArrayList <Games> liGames = new ArrayList<>();
        String searchedGenre = (String)comboSearchGenre.getSelectedItem();
        for (Games g : list)
        {
            if(g.getGenre().equals(searchedGenre))
            {
                liGames.add(g);
            }
        }
        
        if (liGames.isEmpty())
        {
            JOptionPane.showMessageDialog(frame, "Games for " + searchedGenre + " Genre not found" , 
                    "Games Not Avilable", JOptionPane.INFORMATION_MESSAGE);
        } 
        else 
        {
            
            JFrame frameGenre = new JFrame(searchedGenre + " Games List");
            frameGenre.setLayout(null);
            frameGenre.getContentPane().setBackground(Color.decode("#363837"));
            ImageIcon frameIcon = new ImageIcon(getClass().getClassLoader().getResource("resources/gamelogo.png"));
            frameGenre.setIconImage(frameIcon.getImage());
            
            JLabel lableTitle;
            if(liGames.size() == 1) {
                lableTitle = new JLabel(liGames.size()+ " Game Found");
            } else {
                lableTitle = new JLabel(liGames.size()+ " Games Found");
            }
            
            lableTitle.setBounds(10, 10, 250, 25);
            lableTitle.setFont(new Font("Tahoma", 0, 18));
            lableTitle.setForeground(Color.decode("#8ffcff"));
            
            frameGenre.add(lableTitle);
            
            JTable tblGenre = new JTable();
            tblGenre.setModel(new DefaultTableModel(
             new Object [][] {},
             new String [] {
                 "Game ID", "Game Name", "Platform","Price"
             }
            ));
            tblGenre.setRowHeight(20);
            tblGenre.setFont(new Font("Tahoma", 0, 14));
            tblGenre.getTableHeader().setFont(new Font("Tahoma", 0, 14));
            tblGenre.getTableHeader().setReorderingAllowed(false);
            tblGenre.getTableHeader().setResizingAllowed(false);
            
            frameGenre.add(tblGenre);

            JScrollPane jScrollPaneGenre = new JScrollPane(tblGenre);
            frameGenre.add(jScrollPaneGenre);
            jScrollPaneGenre.setBounds(10, 45, 400, 140);

            frameGenre.setSize(440, 250);
            frameGenre.setLocationRelativeTo(frame);
            frameGenre.setVisible(true);
            
            DefaultTableModel m;
            
            for (Games l : liGames)
            {
                m = (DefaultTableModel) tblGenre.getModel();
                m.addRow(new Object[]
                        {l.getGameId(), l.getGameName(),l.getPlatform(), l.getPrice()});
            }
        }
    }
    
    //Method to Open a file on click of open file
    public void openFile(){
        try 
        {
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + 
                            Thread.currentThread().getContextClassLoader().getResource("resources/open.txt"));
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(frame, "Error");
        }
    
    }
    
    //method to exit from the frame
    public void exit()
    {
        System.exit(0);
    }
    
    //method to clear the table
    public void clearTable()
    {
        if (tableGame.getRowCount() != 0)
        {
            model.setRowCount(0);
            list.clear();
        }
        
    }
    
    class LabelRenderer implements TableCellRenderer{
       @Override
        public Component getTableCellRendererComponent(JTable tableGame, 
                Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return (Component) value;
        }
    }  
    
}


