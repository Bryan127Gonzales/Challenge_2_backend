/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Conexion;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;
/**
 *
 * @author Bryan
 */
public class Reserva extends javax.swing.JFrame {
    private String user;
    
    //Connection conectar2=con.Conectar();
    
    public Reserva(String user) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.user=user;
        txtusername.setText(user);
        cargarDatosUsuario(user);
        
    }
 
    private void cargarDatosUsuario(String username) {
        Conexion con=new Conexion();
        Connection conectar=con.Conectar();
        
        PreparedStatement pst = null;
        ResultSet resultSet = null;

        try {
            // Establece la conexión con la base de datos
            //connection = DriverManager.getConnection("jdbc:mysql://localhost/hotel", "usuario", "contraseña");

            // Consulta para obtener el nombre y apellidos del usuario
            String query = "SELECT nombre, apellidos FROM usuario WHERE username = ?";
            pst = conectar.prepareStatement(query);
            pst.setString(1, username);
            resultSet = pst.executeQuery();

            if (resultSet.next()) {
                // Llena los campos de nombre y apellidos con los datos del usuario
                txtnombre.setText(resultSet.getString("nombre"));
                txtapellidos.setText(resultSet.getString("apellidos"));
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos del usuario");
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (pst != null) pst.close();
                if (conectar != null) conectar.close();
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        txtimporte = new javax.swing.JTextField();
        cbformapago = new javax.swing.JComboBox<>();
        btnguardar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jdfechaingreso = new com.toedter.calendar.JDateChooser();
        jdfechasalida = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        btnvolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Sistema de Reservas");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellidos:");

        jLabel4.setText("Check in:");

        jLabel5.setText("Check out:");

        jLabel6.setText("Valor de la reserva($):");

        jLabel7.setText("Forma de pago:");

        txtnombre.setEditable(false);
        txtnombre.setEnabled(false);

        txtapellidos.setEditable(false);
        txtapellidos.setEnabled(false);

        txtimporte.setEnabled(false);

        cbformapago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta de Crédito", "Tarjeta de Débito" }));

        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/registrar.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jLabel8.setText("UserName:");

        txtusername.setEditable(false);
        txtusername.setEnabled(false);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/reservacuarto.jpg"))); // NOI18N

        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/volver.png"))); // NOI18N
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnguardar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtimporte, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbformapago, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel8))
                            .addGap(21, 21, 21)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtapellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jdfechaingreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jdfechasalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jdfechaingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jdfechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtimporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbformapago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar)
                    .addComponent(btnvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public String getFecha(JDateChooser jd){
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        if(jd.getDate()!=null){
            return formato.format(jd.getDate());
        }
        return null;
    }
    
    private double calcularImporte() {
        // Obtiene las fechas de ingreso y salida seleccionadas
        Date fechaIngreso = jdfechaingreso.getDate();
        Date fechaSalida = jdfechasalida.getDate();

        // Verifica que ambas fechas estén seleccionadas
        if (fechaIngreso != null && fechaSalida != null) {
            // Calcula la diferencia en milisegundos entre las fechas
            long diferencia = fechaSalida.getTime() - fechaIngreso.getTime();

            // Calcula la cantidad de días
            int dias = (int) (diferencia / (1000 * 60 * 60 * 24));

            // Calcula el importe multiplicando los días por la tasa diaria
            double tasaDiaria = 20.0; // Cambia esto si la tasa diaria no es fija
            return dias * tasaDiaria;
        } else {
            // Si alguna de las fechas no está seleccionada, retorna 0.0 
            return 0.0;
        }
    }

    public void AgregarReserva(){
        Conexion con=new Conexion();
        Connection conectar=con.Conectar();
        PreparedStatement pst = null;
        int confirmar;
        String fechaingreso=getFecha(jdfechaingreso);
        String fechasalida=getFecha(jdfechasalida);
        Double importe=calcularImporte();
        txtimporte.setText(String.valueOf(importe));
        confirmar=JOptionPane.showConfirmDialog(null, "El importe es:"+importe+" $\nDesea continuar?");
        if(confirmar==0){
                String  SQL="Insert into reserva (username,fecha_ingreso,fecha_salida,valor,Forma_pago) values(?,?,?,?,?)";
                try {
                    pst=conectar.prepareStatement(SQL);
                    pst.setString(1,txtusername.getText());
                    pst.setString(2,fechaingreso);
                    pst.setString(3,fechasalida);
                    pst.setDouble(4,importe);
                    pst.setString(5,cbformapago.getSelectedItem().toString());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Registro exitoso");
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Error de registro \n"+e.getMessage());
                }finally {
                    try {
                        
                        if (pst != null) pst.close();
                        if (conectar != null) conectar.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        }else{
            JOptionPane.showMessageDialog(null, "No se guardo la reserva");
        }
        
    }
    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        AgregarReserva();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        Menu m=new Menu(user);
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnvolverActionPerformed
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox<String> cbformapago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private com.toedter.calendar.JDateChooser jdfechaingreso;
    private com.toedter.calendar.JDateChooser jdfechasalida;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextField txtimporte;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
