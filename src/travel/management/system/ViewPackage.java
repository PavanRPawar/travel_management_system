package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener {
    
    JButton back;
    
    ViewPackage(String username) {
        setBounds(450, 150, 870, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Heading
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(40, 10, 300, 30);
        add(text);
        
        // Username
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 80, 150, 25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(200, 80, 150, 25);
        add(labelusername);
        
        // Package
        
        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(30, 120, 150, 25);
        add(lblpackage);
        
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(200, 120, 150, 25);
        add(labelpackage);
        
        // Total Persons
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 160, 150, 25);
        add(lblpersons);
        
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(200, 160, 150, 25);
        add(labelpersons);
        
        // ID
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 200, 150, 25);
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(200, 200, 150, 25);
        add(labelid);
        
        // Number
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 240, 150, 25);
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(200, 240, 150, 25);
        add(labelnumber);
        
        // Phone
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 280, 150, 25);
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(200, 280, 150, 25);
        add(labelphone);
        
        // Price
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(30, 320, 150, 25);
        add(lblprice);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(200, 320, 150, 25);
        add(labelprice);
        
        // Back Button
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(110, 390, 100, 25);
        back.addActionListener(this);
        add(back);
        
        // Add Image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(320, 20, 500, 400);
        add(image);
        
        try {
            Conn conn = new Conn();
            String query = "select * from bookpackage where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));
                labelpersons.setText(rs.getString("persons"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new ViewPackage("pavan");
    }
}
