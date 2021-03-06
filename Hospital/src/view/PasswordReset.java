
package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.Logic;
import model.User;

/**
 *
 * @author Bozo
 */
public class PasswordReset extends javax.swing.JFrame {
private String userName;
    /**
     * Creates new form PasswordReset
     */
    public PasswordReset() {
    	setTitle("Password Reset");
        initComponents();
        newPassword.grabFocus();
    }
    
    protected void setUserName(String userName) {
        this.userName = userName;
    }

    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the
     * Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        newPasswordLabel = new javax.swing.JLabel();
        newPasswordLabel.setBounds(19, 78, 109, 15);
        newPasswordLabel.setToolTipText("");
        newPasswordLabel.setText("New Password:");
        verifyNewPasswordLabel = new javax.swing.JLabel();
        verifyNewPasswordLabel.setBounds(24, 135, 144, 15);
        verifyNewPasswordLabel.setText("Verify New Password:");
        verifyNewPasswordLabel.setToolTipText("");
        newPassword = new javax.swing.JPasswordField();
        newPassword.setBounds(186, 79, 205, 14);
        verifyNewPassword = new javax.swing.JPasswordField();
        verifyNewPassword.setBounds(186, 135, 205, 14);
        submit = new javax.swing.JButton();
        submit.setText("Submit");
        submit.setBounds(221, 236, 91, 30);
        back = new javax.swing.JButton();
        back.setText("Back");
        back.setBounds(87, 236, 85, 30);
        showPassword = new javax.swing.JCheckBox();
        showPassword.setBounds(135, 190, 248, 23);
        showPassword.setText("Show Password");
        languageComboBox = new javax.swing.JComboBox<>();
        languageComboBox.setVisible(false);
        languageComboBox.setBounds(125, 296, 117, 20);
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator1.setBounds(186, 93, 205, 10);
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator2.setBounds(186, 150, 205, 10);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jDesktopPane1.setBackground(new java.awt.Color(0,102,204));
        jDesktopPane1.setForeground(new java.awt.Color(102, 153, 255));
        jDesktopPane1.setMaximumSize(new java.awt.Dimension(430, 355));
        jDesktopPane1.setMinimumSize(new java.awt.Dimension(430, 355));

        newPasswordLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        newPasswordLabel.setForeground(new java.awt.Color(255, 255, 255));

        verifyNewPasswordLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        verifyNewPasswordLabel.setForeground(new java.awt.Color(255, 255, 255));

        newPassword.setBackground(new java.awt.Color(0, 102, 204));
        newPassword.setForeground(new java.awt.Color(255, 255, 255));
        newPassword.setBorder(null);
        newPassword.setCaretColor(new java.awt.Color(255, 255, 255));
        UIManager.put("ToolTip.background", Color.WHITE);
        newPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPasswordActionPerformed(evt);
            }
        });

        verifyNewPassword.setBackground(new java.awt.Color(0, 102, 204));
        verifyNewPassword.setForeground(new java.awt.Color(255, 255, 255));
        verifyNewPassword.setBorder(null);
        verifyNewPassword.setCaretColor(new java.awt.Color(255, 255, 255));
        verifyNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyNewPasswordActionPerformed(evt);
            }
        });

        submit.setBackground(new java.awt.Color(240,248,255));
        submit.setForeground(Color.DARK_GRAY);
        submit.setEnabled(false);
        DocumentListener docListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                emptyFields(newPassword,verifyNewPassword,submit);
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                emptyFields(newPassword,verifyNewPassword,submit);
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                emptyFields(newPassword,verifyNewPassword,submit);
            }
        };
        newPassword.getDocument().addDocumentListener(docListener);
        verifyNewPassword.getDocument().addDocumentListener(docListener);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        submit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                submitKeyPressed(evt);
            }
        });

        back.setBackground(new java.awt.Color(240, 248, 255));
        back.setForeground(Color.DARK_GRAY);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        back.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                backKeyPressed(evt);
            }
        });

        showPassword.setBackground(new java.awt.Color(0,102,204));
        showPassword.setForeground(new java.awt.Color(255, 255, 255));
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordActionPerformed(evt);
            }
        });

        languageComboBox.setBackground(new java.awt.Color(2, 35, 66));
        languageComboBox.setForeground(new java.awt.Color(255, 255, 255));
        languageComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose a language", "English"}));
        languageComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageComboBoxActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(newPasswordLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(verifyNewPasswordLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(newPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(verifyNewPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(submit, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(back, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(showPassword, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(languageComboBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jSeparator2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1.setLayout(null);
        jDesktopPane1.add(languageComboBox);
        jDesktopPane1.add(back);
        jDesktopPane1.add(submit);
        jDesktopPane1.add(showPassword);
        jDesktopPane1.add(newPasswordLabel);
        jDesktopPane1.add(verifyNewPasswordLabel);
        jDesktopPane1.add(jSeparator1);
        jDesktopPane1.add(newPassword);
        jDesktopPane1.add(verifyNewPassword);
        jDesktopPane1.add(jSeparator2);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void backActionPerformed(java.awt.event.ActionEvent evt) {                                     
         LoginScreen(languageComboBox);
         PasswordResetToLoginScreen(this);
    }                                    

    private void backKeyPressed(java.awt.event.KeyEvent evt) {                                
         int key=evt.getKeyCode();
          ActionEvent ae = new ActionEvent(evt.getSource(), evt.getID(), evt.paramString());
          if(key==KeyEvent.VK_ENTER)        
          backActionPerformed(ae);
        back.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
    }                               

    private void showPasswordActionPerformed(java.awt.event.ActionEvent evt) {                                             
        Font font= new Font("Tahoma", Font.PLAIN, 13);
         newPassword.setFont(font);
         verifyNewPassword.setFont(font);
        if (showPassword.isSelected())
        {
            newPassword.setEchoChar('\u0000');
            verifyNewPassword.setEchoChar('\u0000');
        }
        else
        {
            
            newPassword.setEchoChar('\u25cf');
            verifyNewPassword.setEchoChar('\u25cf');

        }
    }                                            

    private void submitKeyPressed(java.awt.event.KeyEvent evt) {                                  
        int key=evt.getKeyCode();
          ActionEvent ae = new ActionEvent(evt.getSource(), evt.getID(), evt.paramString());
          if(key==KeyEvent.VK_ENTER)        
          submitActionPerformed(ae);
        submit.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
    }                                 

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {                                       
        boolean bool;
        if (!newPassword.getText().equals(verifyNewPassword.getText()))
           PasswordsNotMatching(languageComboBox);
       else
       {
         bool=NewPassSave(userName,newPassword.getText(),languageComboBox);
         if (bool==true)
          {
           LoginScreen(languageComboBox);
           PasswordResetToLoginScreen(this);
          }
       }
       
       
    }                                      

    private void newPasswordActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if (submit.isEnabled())
        submitActionPerformed(evt);
    }                                           

    private void verifyNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {                                                  
       if (submit.isEnabled())
        submitActionPerformed(evt);
    }                                                 

    private void languageComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                 

    }                                                                            

    private void emptyFields(JTextField newPassword, JPasswordField verifyNewPassword, JButton submit){
             if (newPassword.getText().length()<4  || verifyNewPassword.getPassword().length<4 ){
                submit.setEnabled(false);
                 submit.setBackground(new Color(2,51,99));
             }
                 else{
                submit.setEnabled(true);
                submit.setBackground(new Color(240, 248, 255)); 
                submit.setForeground(Color.black);
                 }
    }
   
    
    public void PasswordResetToLoginScreen(PasswordReset pr)
    {
        pr.dispose();
    }
    
    public void PasswordsNotMatching(JComboBox<String> language)
    {
        if (language.getSelectedItem().equals("English") || language.getSelectedItem().equals("Choose a language"))
        JOptionPane.showMessageDialog(null, "Password doesn't match!");  
    }
    
    public boolean NewPassSave(String username,String password,JComboBox language)
    {
        boolean bool;
        User user=Logic.getInstance().getUserDetailsForReset(username);
        Logic.getInstance().UpdateUser(user.getUsername(), password, user.getDisplayFirstName(), user.getDisplayLastName(), user.getType(), user.getSecretQuestion(), user.getSecretAnswer());
            SaveNewPasswordMessage(language);
            return true;
    }
    
    public void SaveNewPasswordMessage(JComboBox language)
    {
        Toolkit.getDefaultToolkit().beep();
        if (language.getSelectedItem().equals("English") || language.getSelectedItem().equals("Choose a language"))
        JOptionPane.showMessageDialog(null, "Password has changed successfully!");    
    }

    public void SaveNewPasswordFailedMessage(JComboBox language)
    {
        Toolkit.getDefaultToolkit().beep();
        if (language.getSelectedItem().equals("English") || language.getSelectedItem().equals("Choose a language"))
        JOptionPane.showMessageDialog(null, "Password was not changed, please try again!");
    }
    
    public void LoginScreen(JComboBox<String> language){
    	  LoginScreen log=new LoginScreen();
    	  log.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    	  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	  log.setSize(screenSize.width,screenSize.height);
    	  log.pack();
    	  log.setVisible( true );
    	  log.languageComboBox.setSelectedItem(language.getSelectedItem());
    	 }

    // Variables declaration - do not modify                     
    private javax.swing.JButton back;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    protected javax.swing.JComboBox<String> languageComboBox;
    private javax.swing.JPasswordField newPassword;
    private javax.swing.JLabel newPasswordLabel;
    private javax.swing.JCheckBox showPassword;
    private javax.swing.JButton submit;
    private javax.swing.JPasswordField verifyNewPassword;
    private javax.swing.JLabel verifyNewPasswordLabel;
    // End of variables declaration                   
}
