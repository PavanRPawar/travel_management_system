package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    
    String username;
    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, checkpackage, bookpackage, viewpackage, viewhotels, destinations, bookhotel, viewbookedhotel, payments, calculators, notepad, about, deletePersonalDetails;
    
    Dashboard(String username) {
        this.username = username;
//        setBounds(0, 0, 1600, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        // Panel 1st
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 50);
        add(p1);
        
        // Add Image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 50, 50);
        p1.add(icon);
        
        // Dashboard Heading
        
        JLabel heading  = new JLabel("Dashboard");
        heading.setBounds(80, 5, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);
        
        // Panel 2nd
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 50, 300, 900);
        add(p2);
        
        // Add Personal Details Button
        
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 0, 300, 45);
        addPersonalDetails.setBackground(new Color(0, 0, 102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addPersonalDetails.setMargin(new Insets(0, 0, 0, 60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        // Update Personal Details Button
        
        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 45, 300, 45);
        updatePersonalDetails.setBackground(new Color(0, 0, 102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatePersonalDetails.setMargin(new Insets(0, 0, 0, 30));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);
        
        // View Personal Details Button
        
        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0, 90, 300, 45);
        viewPersonalDetails.setBackground(new Color(0, 0, 102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPersonalDetails.setMargin(new Insets(0, 0, 0, 130));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        
        // Delete Personal Details Button
        
        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 135, 300, 45);
        deletePersonalDetails.setBackground(new Color(0, 0, 102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deletePersonalDetails.setMargin(new Insets(0, 0, 0, 40));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);
        
        // Check Package Button
        
        checkpackage = new JButton("Check Package");
        checkpackage.setBounds(0, 180, 300, 45);
        checkpackage.setBackground(new Color(0, 0, 102));
        checkpackage.setForeground(Color.WHITE);
        checkpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkpackage.setMargin(new Insets(0, 0, 0, 110));
        checkpackage.addActionListener(this);
        p2.add(checkpackage);
        
        // Book Package Button
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(0, 225, 300, 45);
        bookpackage.setBackground(new Color(0, 0, 102));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookpackage.setMargin(new Insets(0, 0, 0, 120));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);
        
        // View Package Button
        
        viewpackage = new JButton("View Package");
        viewpackage.setBounds(0, 270, 300, 45);
        viewpackage.setBackground(new Color(0, 0, 102));
        viewpackage.setForeground(Color.WHITE);
        viewpackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewpackage.setMargin(new Insets(0, 0, 0, 120));
        viewpackage.addActionListener(this);
        p2.add(viewpackage);
        
        // View Hotels Button
        
        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0, 315, 300, 45);
        viewhotels.setBackground(new Color(0, 0, 102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewhotels.setMargin(new Insets(0, 0, 0, 130));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);
        
        // Book Hotel Button
        
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(0, 360, 300, 45);
        bookhotel.setBackground(new Color(0, 0, 102));
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookhotel.setMargin(new Insets(0, 0, 0, 140));
        bookhotel.addActionListener(this);
        p2.add(bookhotel);
        
        // View Booked Hotel Button
        
        viewbookedhotel = new JButton("View Booked Hotel");
        viewbookedhotel.setBounds(0, 405, 300, 45);
        viewbookedhotel.setBackground(new Color(0, 0, 102));
        viewbookedhotel.setForeground(Color.WHITE);
        viewbookedhotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewbookedhotel.setMargin(new Insets(0, 0, 0, 70));
        viewbookedhotel.addActionListener(this);
        p2.add(viewbookedhotel);
        
        // Destinations Button
        
        destinations = new JButton("Destinations");
        destinations.setBounds(0, 450, 300, 45);
        destinations.setBackground(new Color(0, 0, 102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        destinations.setMargin(new Insets(0, 0, 0, 125));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        // Payments Button
        
        payments = new JButton("Payments");
        payments.setBounds(0, 495, 300, 45);
        payments.setBackground(new Color(0, 0, 102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma", Font.PLAIN, 20));
        payments.setMargin(new Insets(0, 0, 0, 150));
        payments.addActionListener(this);
        p2.add(payments);
        
        // Calculators Button
        
        calculators = new JButton("Calculators");
        calculators.setBounds(0, 540, 300, 45);
        calculators.setBackground(new Color(0, 0, 102));
        calculators.setForeground(Color.WHITE);
        calculators.setFont(new Font("Tahoma", Font.PLAIN, 20));
        calculators.setMargin(new Insets(0, 0, 0, 145));
        calculators.addActionListener(this);
        p2.add(calculators);
        
        // Notepad Button
        
        notepad = new JButton("Notepad");
        notepad.setBounds(0, 585, 300, 45);
        notepad.setBackground(new Color(0, 0, 102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        notepad.setMargin(new Insets(0, 0, 0, 155));
        notepad.addActionListener(this);
        p2.add(notepad);
        
        // About Button
        
        about = new JButton("About");
        about.setBounds(0, 630, 300, 45);
        about.setBackground(new Color(0, 0, 102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma", Font.PLAIN, 20));
        about.setMargin(new Insets(0, 0, 0, 175));
        about.addActionListener(this);
        p2.add(about);
        
        // Add Image
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);
        
        // Heading
        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(400, 50, 1200,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN, 50));
        image.add(text);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == addPersonalDetails) {
            new AddCustomer(username);
        } else if(ae.getSource() == viewPersonalDetails) {
            new ViewCustomer(username);
        } else if(ae.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username);
        } else if(ae.getSource() == checkpackage) {
            new CheckPackage();
        } else if(ae.getSource() == bookpackage) {
            new BookPackage(username);
        } else if(ae.getSource() == viewpackage) {
            new ViewPackage(username);
        } else if(ae.getSource() == viewhotels) {
            new CheckHotels();
        } else if(ae.getSource() == destinations) {
            new Destinations();
        } else if(ae.getSource() == bookhotel) {
            new BookHotel(username);
        } else if(ae.getSource() == viewbookedhotel) {
            new ViewBookedHotel(username);
        } else if(ae.getSource() == payments) {
            new Payment();
        } else if(ae.getSource() == calculators) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == about) {
            new About();
        } else if(ae.getSource() == deletePersonalDetails) {
            new DeleteDetails(username);
        }
    }
    
    public static void main(String[] args) {
        new Dashboard("");
    }
}
