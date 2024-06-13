package test;

/**
 *
 * @author mutasim sadat khan
 */
public class LoginScreen extends javax.swing.JFrame {

    private String identity;
    private String password;

    public LoginScreen() {
        initComponents();
    }
    
    public LoginScreen(String identity, String password) {
        this.identity = identity;
        this.password = password;
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGradient1 = new panel.PanelGradient();
        jPasswordField2 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGradient1.setBackground(new java.awt.Color(62, 26, 87));
        panelGradient1.setColorGradient(new java.awt.Color(179, 43, 43));

        jPasswordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField2ActionPerformed(evt);
            }
        });
        panelGradient1.add(jPasswordField2);
        jPasswordField2.setBounds(420, 382, 420, 40);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        panelGradient1.add(jTextField1);
        jTextField1.setBounds(420, 310, 420, 40);

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Login");
        panelGradient1.add(jLabel1);
        jLabel1.setBounds(20, 30, 1260, 110);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Username :");
        panelGradient1.add(jLabel2);
        jLabel2.setBounds(270, 310, 130, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Password :");
        panelGradient1.add(jLabel3);
        jLabel3.setBounds(270, 380, 130, 32);

        jButton1.setBackground(new java.awt.Color(0, 102, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 0));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelGradient1.add(jButton1);
        jButton1.setBounds(570, 480, 120, 39);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, 1427, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField2ActionPerformed
        
    }//GEN-LAST:event_jPasswordField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        authenticate();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void authenticate() {
    String passwordValue = new String(jPasswordField2.getPassword());
    String identity2 = jTextField1.getText();
    
    if (this.password.equals(passwordValue) && this.identity.equals(identity2)) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyFrame2().setVisible(true);
            }
        });
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    private panel.PanelGradient panelGradient1;
    // End of variables declaration//GEN-END:variables
}
