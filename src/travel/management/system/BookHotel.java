package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {
    
    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    String username;
    JLabel labelusername, labelnumber, labelid, labelphone, labelprice;
    JButton checkprice, bookhotel, back;
    
    BookHotel(String username) {
        this.username = username;
        
        setBounds(450, 150, 870, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        // Heading
        
        JLabel text = new JLabel("BOOK HOTEL");
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
        
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setBounds(30, 110, 120, 25);
        lblpackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpackage);
        
        chotel = new Choice();
        chotel.setBounds(190, 110, 120, 25);
        add(chotel);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Total Persons
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 150, 120, 25);
        lblpersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpersons);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(190, 150, 120, 25);
        add(tfpersons);
        
        // No. of Days
        
        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setBounds(30, 190, 120, 25);
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldays);
        
        tfdays = new JTextField("1");
        tfdays.setBounds(190, 190, 120, 25);
        add(tfdays);
        
        // AC / Non AC
        
        JLabel lblac = new JLabel("AC / Non AC");
        lblac.setBounds(30, 230, 120, 25);
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non AC");
        cac.setBounds(190, 230, 120, 25);
        add(cac);
        
        // Food Included
        
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(30, 270, 120, 25);
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfood);
        
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(190, 270, 120, 25);
        add(cfood);
        
        // ID
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 310, 120, 25);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(190, 310, 120, 25);
        add(labelid);
        
        // Number
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 350, 120, 25);
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(190, 350, 120, 25);
        add(labelnumber);
        
        // Phone
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 390, 120, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(190, 390, 120, 25);
        add(labelphone);
                
        // Total Price
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(30, 430, 120, 25);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(190, 430, 120, 25);
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
        checkprice.setBounds(30, 470, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        // Book Hotel Button
        
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBounds(170, 470, 120, 25);
        bookhotel.addActionListener(this);
        add(bookhotel);
        
        // Back Button
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(310, 470, 120, 25);
        back.addActionListener(this);
        add(back);
        
        // Add Image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 100, 450, 300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"'");
                while(rs.next()) {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    
                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());
                    
                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();
                    
                    if (persons * days > 0) {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labelprice.setText("Rs " +total);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }           
        } else if (ae.getSource() == bookhotel) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new BookHotel("pavan");
    }
}
