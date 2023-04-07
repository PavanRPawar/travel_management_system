package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteDetails extends JFrame implements ActionListener {
    
    JButton back;
    String username;
    
    DeleteDetails(String username) {
        this.username = username;
        setBounds(450, 150, 870, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Username
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 30, 150, 25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 30, 150, 25);
        add(labelusername);
        
        // ID
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 70, 150, 25);
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220, 70, 150, 25);
        add(labelid);
        
        // Number
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 110, 150, 25);
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 110, 150, 25);
        add(labelnumber);
        
        // Name
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 150, 150, 25);
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(220, 150, 150, 25);
        add(labelname);
        
        // Gender
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 190, 150, 25);
        add(lblgender);
        
        JLabel labelgender = new JLabel();
        labelgender.setBounds(220, 190, 150, 25);
        add(labelgender);
        
        // Country
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(500, 30, 150, 25);
        add(lblcountry);
        
        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(690, 30, 150, 25);
        add(labelcountry);
        
        // Address
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(500, 70, 150, 25);
        add(lbladdress);
        
        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(690, 70, 150, 25);
        add(labeladdress);
        
        // Email
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(500, 110, 150, 25);
        add(lblemail);
        
        JLabel labelemail = new JLabel();
        labelemail.setBounds(690, 110, 150, 25);
        add(labelemail);
        
        // Phone
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(500, 150, 150, 25);
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(690, 150, 150, 25);
        add(labelphone);
        
        // Delete Button
        
        back = new JButton("Delete");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 260, 100, 25);
        back.addActionListener(this);
        add(back);
        
        // Add Image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 310, 600, 200);
        add(image);
        
        // Add Duplicate Image
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600, 310, 600, 200);
        add(image2);
        
        try {
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelemail.setText(rs.getString("email"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            Conn c = new Conn();
            c.s.executeUpdate("delete from account where username = '"+username+"'");
            c.s.executeUpdate("delete from customer where username = '"+username+"'");
            c.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
            c.s.executeUpdate("delete from bookhotel where username = '"+username+"'");
            
            JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
            
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new DeleteDetails("pavan");
    }
}
