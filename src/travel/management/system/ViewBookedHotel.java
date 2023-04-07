package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener {
    
    JButton back;
    
    ViewBookedHotel(String username) {
        setBounds(450, 150, 870, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Heading
        
        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(40, 5, 500, 30);
        add(text);
        
        // Username
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(200, 50, 150, 25);
        add(labelusername);
        
        // Hotel Name
        
        JLabel lblhotelname = new JLabel("Hotel Name");
        lblhotelname.setBounds(30, 90, 150, 25);
        add(lblhotelname);
        
        JLabel labelhotelname = new JLabel();
        labelhotelname.setBounds(200, 90, 150, 25);
        add(labelhotelname);
        
        // Total Persons
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 130, 150, 25);
        add(lblpersons);
        
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(200, 130, 150, 25);
        add(labelpersons);
        
        // Total Days
        
        JLabel lbldays = new JLabel("Total Days");
        lbldays.setBounds(30, 170, 150, 25);
        add(lbldays);
        
        JLabel labeldays = new JLabel();
        labeldays.setBounds(200, 170, 150, 25);
        add(labeldays);
        
        // AC/Non-AC
        
        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(30, 210, 150, 25);
        add(lblac);
        
        JLabel labelac = new JLabel();
        labelac.setBounds(200, 210, 150, 25);
        add(labelac);
        
        // Food Included?
        
        JLabel lblfood = new JLabel("Food Included?");
        lblfood.setBounds(30, 250, 150, 25);
        add(lblfood);
        
        JLabel labelfood = new JLabel();
        labelfood.setBounds(200, 250, 150, 25);
        add(labelfood);
        
        // ID
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 290, 150, 25);
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(200, 290, 150, 25);
        add(labelid);
        
        // Number
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 330, 150, 25);
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(200, 330, 150, 25);
        add(labelnumber);
        
        // Phone
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 370, 150, 25);
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(200, 370, 150, 25);
        add(labelphone);
        
        // Total Cost
        
        JLabel lblprice = new JLabel("Total Cost");
        lblprice.setBounds(30, 410, 150, 25);
        add(lblprice);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(200, 410, 150, 25);
        add(labelprice);
        
        // Back Button
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(110, 460, 100, 25);
        back.addActionListener(this);
        add(back);
        
        // Add Image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(330, 50, 500, 400);
        add(image);
        
        try {
            Conn conn = new Conn();
            String query = "select * from bookhotel where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelhotelname.setText(rs.getString("name"));
                labelprice.setText(rs.getString("price"));
                labelpersons.setText(rs.getString("persons"));
                labelphone.setText(rs.getString("phone"));
                labelfood.setText(rs.getString("food"));
                labelac.setText(rs.getString("ac"));
                labeldays.setText(rs.getString("days"));
            }
        } catch (Exception e) {
            
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new ViewBookedHotel("pavan");
    }
}
