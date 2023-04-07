package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {
    
    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookpackage, back;
    
    BookPackage(String username) {
        this.username = username;
        
        setBounds(450, 150, 870, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        // Heading
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        // Username
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 70, 120, 25);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(190, 70, 120, 25);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelusername);
        
        // Select Package
        
        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setBounds(30, 110, 120, 25);
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpackage);
        
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(190, 110, 120, 25);
        add(cpackage);
        
        // Total Persons
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 150, 120, 25);
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpersons);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(190, 150, 120, 25);
        add(tfpersons);
        
        // ID
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 190, 120, 25);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(190, 190, 120, 25);
        add(labelid);
        
        // Number
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 230, 120, 25);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(190, 230, 120, 25);
        add(labelnumber);
        
        // Phone
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 270, 120, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(190, 270, 120, 25);
        add(labelphone);
                
        // Total Price
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(30, 310, 120, 25);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(190, 310, 120, 25);
        add(labelprice);
        
        try {
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Check Price Button
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(30, 380, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        // Book Package Button
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(170, 380, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        // Back Button
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(310, 380, 120, 25);
        back.addActionListener(this);
        add(back);
        
        // Add Image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 50, 450, 300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")) {
                cost += 32000;
            } else if(pack.equals("Silver Package")) {
                cost += 24000;
            } else {
                cost += 12000;
            }
            
            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labelprice.setText("Rs " + cost);
        } else if (ae.getSource() == bookpackage) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new BookPackage("pavan");
    }
}
