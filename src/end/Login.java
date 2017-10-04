
package end;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login implements ActionListener{
    JFrame jme;
    JLabel lbUser, lbPass;
    JTextField txUser;
    JPasswordField txPass;
    JButton btAdd;
    JLabel lblTotalMessage,lblAccountMessage,lblPasswordMessage;
    
    public Login(){
        jme = new JFrame("Login");
        jme.setSize(500, 500);
        jme.setLayout(null);
        //
        lbUser = new JLabel("Tai khoan ");
        lbUser.setBounds(30, 50, 80, 30);
        txUser = new JTextField();
        txUser.setBounds(110, 50, 200, 30);
        //
        lbPass = new JLabel("Passord");
        lbPass.setBounds(30, 100, 80, 30);
        txPass = new JPasswordField();
        txPass.setBounds(110, 100, 200, 30);
        //
        btAdd = new JButton("Add");
        btAdd.setBounds(180, 150, 100, 40);
        btAdd.addActionListener(new AddHandle());
        //
        lblTotalMessage = new JLabel();
        lblAccountMessage = new JLabel();
        lblPasswordMessage = new JLabel();
        
        lblTotalMessage.setBounds(50, 10 , 300, 40);
        lblAccountMessage.setBounds(360, 50, 150, 40);
        lblPasswordMessage.setBounds(360, 110, 150, 40);
        //
        
        jme.add(lbUser);
        jme.add(txUser);
        jme.add(lbPass);
        jme.add(txPass);
        jme.add(btAdd);
        jme.add(lblTotalMessage);
        jme.add(lblAccountMessage);
        jme.add(lblPasswordMessage);
        
        jme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jme.setVisible(true);
    }
    
        @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    class AddHandle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            //xu li log in
            String account = txUser.getText();
            String password = new String(txPass.getPassword());
            
            // Gọi đến hàm validateForm() của class FormHandle để validate dữ liệu.
            // Trong trường hợp không tồn tại lỗi thì hashmap trả về rỗng. Trong trường hợp,
            // hashmap có giá trị thì hiển thị thông báo.
            HashMap<String, String> errors = new FormHandle().validateLogin(account, password);
            if (errors.isEmpty()) {
                resetMessage();
                // Gọi đến tầng model để xử lý, hoặc lưu thông tin.
                
                
                
                
                
                
            } else {
                showError(errors);
            }

        }
    }

    private void resetMessage() {
            lblTotalMessage.setText("");
            lblAccountMessage.setText("");
            lblPasswordMessage.setText("");
    }
    
    private void showError(HashMap<String, String> errors) {
            lblTotalMessage.setForeground(Color.red);
            lblTotalMessage.setText("* Vui lòng sửa các lỗi bên dưới và submit lại form.");
         if (errors.containsKey("txtAccount")) {
            lblAccountMessage.setForeground(Color.red);
            lblAccountMessage.setText(errors.get("txtAccount"));
        } else {
            lblAccountMessage.setForeground(Color.green);
            lblAccountMessage.setText("Hợp lệ.");
        }
        if (errors.containsKey("txtPassword")) {
            lblPasswordMessage.setForeground(Color.red);
            lblPasswordMessage.setText(errors.get("txtPassword"));
        } else {
            lblPasswordMessage.setForeground(Color.green);
            lblPasswordMessage.setText("Hợp lệ.");
        }
        }
    
    public class FormHandle {
    public HashMap<String, String> validateLogin(String account, String password) {
        HashMap<String, String> errors = new HashMap<>();
        if (account.isEmpty()) {
            errors.put("txtAccount", "* Vui lòng nhập thông tin account.");
        }
        if (password.isEmpty()) {
            errors.put("txtPassword", "* Password quá ngắn.");
        }
        return errors;
    }
}
    public static void main(String[] args) {
        new Login();
    }
}
