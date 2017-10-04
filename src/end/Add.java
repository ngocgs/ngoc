
package end;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import end.Student;
import java.awt.Component;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Add implements  ActionListener{
    
    JFrame jme;
    JLabel lbID, lbName, lbEmail, lbPhone, lbAddress, lbBirthday, lblmessage;
    JTextField txID, txName, txAddress, txEmail;
    JFormattedTextField txPhone, txBirthday;
    JButton btReset, btAdd;
    
    Connection cnn = null;
        String url = "jdbc:mysql://localhost:3306/SV";    //datebase name
        String username = "root";
        String password = "";
    
    
    public Add(){
        jme = new JFrame("Add");
        jme.setSize(500, 500);
        jme.setLayout(null);
        
        //
        lblmessage = new JLabel();
        lblmessage.setBounds(10, 10, 300, 50);
        
        // name
        lbName = new JLabel("Name");
        lbName.setBounds(30, 100, 100, 30);
        txName = new JTextField();
        txName.setBounds(130, 100, 180, 40);
        
        // email
        lbEmail = new JLabel("Email");
        lbEmail.setBounds(30, 150, 100, 30);
        
        txEmail = new JTextField();
        txEmail.setBounds(130, 150, 180, 40);
        
        // phone
        lbPhone = new JLabel("Phone");
        lbPhone.setBounds(30, 200, 100, 30);
        
        try {
            MaskFormatter mfp = new MaskFormatter("####   ###   ###");
            mfp.setPlaceholderCharacter(' ');
            txPhone = new JFormattedTextField( mfp );
            txPhone.setBounds(130, 200, 180, 40);
        } catch (Exception e) {
        }
        
        // Address
        lbAddress = new JLabel("Address");
        lbAddress.setBounds(30, 250, 100, 30);
        
        txAddress = new JTextField();
        txAddress.setBounds(130, 250, 180, 40);
        
        // birthday
        lbBirthday = new JLabel("Birthday");
        lbBirthday.setBounds(30, 300, 100, 30);
        
        try {
            MaskFormatter mfbd = new MaskFormatter("##  -  ##  -  ####");
            mfbd.setPlaceholderCharacter(' ');
            txBirthday = new JFormattedTextField( mfbd );
            txBirthday.setBounds(130, 300, 180, 40);
        } catch (Exception e) {
        }
        
        
        // button reset
        btReset = new JButton("Reset");
        btReset.setBounds(100, 380, 100, 40);
        btReset.addActionListener(new ResetAll());
        
        // button add
        btAdd = new JButton("Add");
        btAdd.setBounds(250, 380, 100, 40);
        btAdd.addActionListener(new AddSt());
        
        jme.add(lbName);
        jme.add(txName);
        jme.add(lbEmail);
        jme.add(txEmail);
        jme.add(lbPhone);
        jme.add(txPhone);
        jme.add(txAddress);
        jme.add(lbAddress);
        jme.add(lbBirthday);
        jme.add(txBirthday);
        jme.add(btReset);
        jme.add(btAdd);
        
        //
        jme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jme.setVisible(true);
    }
    
    //public static void main(String[] args) {
    //    new Add();
    //}

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    private static class FormHandle {

        public FormHandle() {
        }
    }
    
    class ResetAll implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            txName.setText("");
            txAddress.setText("");
            txBirthday.setText("");
            txPhone.setText("");
            txEmail.setText("");
            
        }
        
    }
    
    class AddSt implements ActionListener{

        private Component root;

        @Override
        public void actionPerformed(ActionEvent e) {
            // xuli log in
            String name = txName.getText();
            String email = txEmail.getText();
            String phone = txPhone.getText();
            String address = txAddress.getText();
            String birthday = txBirthday.getText();
            
            if(name.isEmpty() || email.isEmpty() ||
                    phone.isEmpty()|| address.isEmpty() || birthday.isEmpty() ){
                JOptionPane.showMessageDialog(root, "ban da nhap thieu thong tin, hay nhap lai");
            }
            else{
                Student st = null;
                StudentModel stm = new StudentModel();
                
                stm.insert(st);
                new ResetAll();
            }
            }

        }
    

    
    
}