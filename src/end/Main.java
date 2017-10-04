
package end;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class Main implements ActionListener {
    JFrame jme;
    JTable table;
    DefaultTableModel dTable;
    JLabel lbPage, lbPageDev;
    JButton btpre2, btpre1, btnext1,btnext2;
    JButton btadd;
    long count = 0, soTrang, trang = 1;
    
    Connection cnn = null;
        String url = "jdbc:mysql://localhost:3306/SV";    //datebase name
        String username = "root";
        String password = "";
    
    
    public Main(){
        jme = new JFrame();
        jme.setSize(500, 500);
        jme.setLayout(null);
        
        table = new JTable();
        
    //    TableColumn column = new TableColumn();
    //    column.setHeaderValue("Email");
        
        dTable = new DefaultTableModel();
        dTable.addColumn("ID");
        dTable.addColumn("Name");
        dTable.addColumn("Email");
        dTable.addColumn("Phone");
        dTable.addColumn("Address");
        dTable.addColumn("Birthday");
        
        
        StudentModel stuModel = new StudentModel();
        ArrayList<Student> list;
        try {
            list = stuModel.getList();
            for ( Student student : list){
            Object[] str = new Object[]{student.getID(), student.getName(), student.getEmail(), student.getPhone(), student.getAddress(), student.getBirthday()};
            dTable.addRow(str);
            count++;
        }
        } catch (ClassNotFoundException ex) {
            System.out.println("error");
        }
        
        table.setModel(dTable);
        JScrollPane scr = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scr.setSize(500, 200);
        
        //phan trang
        btpre2 = new JButton(" << ");
        btpre2.setBounds(20, 210, 60, 30);
        
        btpre1 = new JButton(" < ");
        btpre1.setBounds(80, 210, 60, 30);
        btpre1.addActionListener(new Pre1());
        
        
        lbPage = new JLabel();
        lbPage.setBounds(155, 210, 25, 30);
        
        btnext1 = new JButton(" > ");
        btnext1.setBounds(180, 210, 60, 30);
        btnext1.addActionListener(new Next1());
        
        btnext2 = new JButton(" >> ");
        btnext2.setBounds(240, 210, 60, 30);
        
        lbPageDev = new JLabel();
        lbPageDev.setBounds(300, 210, 40, 30);
        
        btadd = new JButton("Add new");
        btadd.setBounds(50, 250, 120, 30);
        btadd.addActionListener(new AddSV());
        
        jme.add(btnext1);
    //    jme.add(btnext2);
        jme.add(btpre1);
    //    jme.add(btpre2);
        jme.add(lbPage);
        jme.add(lbPageDev);
        
        jme.add(btadd);
        
        jme.add(scr);
        jme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jme.setVisible(true);
        
    }
    
    
    public static void main(String[] args) {
        Main m1 = new Main();
        m1.countDB();
    }
    
    public void countDB () {
        System.out.println(count);
        
        if(count%5 == 0){
            soTrang = count/5;
        }else{
            soTrang = count/5 +1;
        }
        
        lbPageDev.setText("1 / " + soTrang);
        lbPage.setText("1");
    
}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    class Pre1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(trang > 1){
                trang --;
                loadData(trang);
                lbPage.setText("" + trang );
                lbPageDev.setText( trang + "/" + soTrang);
            }
        }
        
    }
    
    class Next1 implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(trang < soTrang){
                trang ++;
                loadData(trang);
                lbPage.setText("" + trang );
                lbPageDev.setText( trang + "/" + soTrang);
            }
        }
        
    }
    
    public void loadData( long trang ){
        // chua viet duoc
            }
            
    class AddSV implements ActionListener{
                
        @Override
        public void actionPerformed(ActionEvent e) { 
            Add add1 = new Add();
        //    Login log1 = new Login();
        }
                
    }   

}
