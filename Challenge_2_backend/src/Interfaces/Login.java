/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Conexion;
import Principal.principal;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    /*public Connection Conectar (){
        String basedatos="hotel";
        String userbd="root";
        String passwordbd="";
        Connection con=null;
        try{
            con = DriverManager. getConnection ("jdbc:mysql://localhost/"+basedatos,userbd,passwordbd);
        } catch (SQLException e) {
            System.err.print (e.toString () ) ;
            JOptionPane. showMessageDialog (this,"Ocurzio un error inesperado. \nFavor comun    icarse con el administrador.");
        }
        return con;
    }*/
    public void ingresar(){
        Connection con=null;
        Conexion conectar=new Conexion();
        PreparedStatement pst=null;
        ResultSet rs=null;
        String User=txtuser.getText();
        String Pass=String.valueOf(txtpassword.getPassword());
        if(User.equals("") || Pass.equals("")){
            JOptionPane.showMessageDialog(this,"Hay uno o varios campos vacios.Favor de llenarlos");
        }else{
            try {
                String tablabd="usuario";
                String campouser="username";
                String campopass="password";
                con=conectar.Conectar();
                pst=con.prepareStatement("Select "+campouser+", "+campopass+" from "+tablabd+" where "+campouser+"='"+User+"' and "+campopass+"='"+Pass+"'");
                rs= pst.executeQuery();
                if(rs.next()){
                    this.dispose();
                    String user = rs.getString(campouser);
                    new Menu(user).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(this,"Credenciales incorrectas.Vuelve a intentarlo de nuevo.");
                }
            } catch (SQLException e) {
                    System.err.print(e.toString());
                    JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado.\nFavor comunicarse con el administrador.");
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        btnlogin = new javax.swing.JButton();
        btnagregar_user = new javax.swing.JButton();
        lbsalir = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0,80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/user.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contraseña");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/hotel_login.png"))); // NOI18N

        btnlogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/ingresar_icon.png"))); // NOI18N
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });

        btnagregar_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/agregar-usuario.png"))); // NOI18N
        btnagregar_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregar_userActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnagregar_user)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(txtuser, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(txtpassword))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(64, 64, 64))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnagregar_user, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(btnlogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(53, 53, 53))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 700, 460));

        lbsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/salir.png"))); // NOI18N
        lbsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbsalirMouseClicked(evt);
            }
        });
        getContentPane().add(lbsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 490, 70, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbsalirMouseClicked
        principal p=new principal();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbsalirMouseClicked

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
       ingresar();
        
    }//GEN-LAST:event_btnloginActionPerformed

    private void btnagregar_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregar_userActionPerformed
        RegistroUser registro=new RegistroUser();
        registro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnagregar_userActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar_user;
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbsalir;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
