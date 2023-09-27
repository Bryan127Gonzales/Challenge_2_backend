/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Conexion;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Bryan
 */
public class Mostrar extends javax.swing.JFrame {
private  String user;


    /**
     * Creates new form Mostrar
     * @param user
     */
    public Mostrar(String user) {
        initComponents();
        this.user=user;
        this.setLocationRelativeTo(null);
        mostrarReservas("reserva",user);
        mostrarHuesped("usuario");
          
    }
    private void mostrarReservas(String tabla,String user){
        Conexion con=new Conexion();
        Connection conectar=con.Conectar();
        
        String sql="Select * from "+tabla+" where username='"+user+"'";
        Statement st=null;
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("UserName");
        model.addColumn("Ingreso");
        model.addColumn("Salida");
        model.addColumn("Importe");
        model.addColumn("Forma de pago");
        jTablaReservas.setModel(model);
        
        String [] datos =new String[6];
        try{
            st=conectar.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                model.addRow(datos);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error: "+e.toString());
        }finally{
            try {
                        
                        if (st != null) st.close();
                        if (conectar != null) conectar.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
        }
    }
    
    private void mostrarHuesped(String tabla){
        Conexion con=new Conexion();
        Connection conectar=con.Conectar();
        String sql="Select nombre,apellidos,nacionalidad,sexo from "+tabla;
        Statement st=null;
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Nacionalidad");
        model.addColumn("Sexo");
        
        jTablaUser.setModel(model);
        
        String [] datos =new String[4];
        try{
            st=conectar.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                model.addRow(datos);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error: "+e.toString());
        }finally{
            try {
                        
                        if (st != null) st.close();
                        if (conectar != null) conectar.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
        }
    }
    private boolean actualizarReserva(String idReserva, int columna, Object nuevoValor) {
        Conexion con=new Conexion();
        try {
                Connection conexion = con.Conectar(); // Conecta a la base de datos
                String columnaActualizar = "";  //Nombre de la columna a actualizar en la base de datos
                String nuevoValorString = nuevoValor.toString(); // Convertir el nuevo valor a String

                // Determinar la columna a actualizar en la base de datos según el número de columna del JTable
                switch (columna) {
                    case 1:
                        //columnaActualizar = "userName"; No se deberia editar el username en este formulario
                        return false;
                    case 2:
                        columnaActualizar = "fecha_ingreso";
                        break;
                    case 3:
                        columnaActualizar = "fecha_salida";
                        break;
                    case 4:
                        columnaActualizar = "valor";
                        break;
                    case 5:
                        columnaActualizar = "Forma_pago";
                        break;
                    default:
                        // La columna no es válida
                        return false;
                }

                // Sentencia SQL para actualizar la reserva en la base de datos
                String sql = "UPDATE reserva SET " + columnaActualizar + " = ? WHERE idreserva = ?";

                PreparedStatement pstmt = conexion.prepareStatement(sql);
                pstmt.setString(1, nuevoValorString); // Establecer el nuevo valor en la sentencia SQL
                pstmt.setString(2, idReserva); // Establecer el ID de la reserva en la sentencia SQL

                int filasActualizadas = pstmt.executeUpdate(); // Ejecutar la actualización en la base de datos

                pstmt.close();
                conexion.close();

                // Verificar si la actualización se realizó con éxito
                return filasActualizadas > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        
    }
    private boolean eliminarReserva(String idReserva) {
        Conexion con=new Conexion();
        try {
            Connection conexion = con.Conectar(); // Conectar a la base de datos

            // Sentencia SQL para eliminar la reserva de la base de datos
            String sql = "DELETE FROM reserva WHERE idreserva = ?";

            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, idReserva); // Establecer el ID de la reserva a eliminar en la sentencia SQL

            int filasEliminadas = pstmt.executeUpdate(); // Ejecutar la eliminación en la base de datos

            pstmt.close();
            conexion.close();

            // Verificar si la eliminación se realizó con éxito
            return filasEliminadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    private void buscarHuesped(String nombre){
        Conexion con=new Conexion();
        Connection conectar=con.Conectar();
        
        String sql="Select nombre,apellidos,nacionalidad,sexo from usuario where nombre='"+nombre+"'";
        Statement st=null;
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Nacionalidad");
        model.addColumn("Sexo");
        jTablaUser.setModel(model);
        
        String [] datos =new String[4];
        try{
            st=conectar.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                model.addRow(datos);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error: "+e.toString());
        }finally{
            try {
                        
                        if (st != null) st.close();
                        if (conectar != null) conectar.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
        }
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panelprincipal = new javax.swing.JTabbedPane();
        PanelReserva = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaReservas = new javax.swing.JTable();
        btneditar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        PanelUsuario = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaUser = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnvolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panelprincipal.setBackground(new java.awt.Color(0, 0, 0));
        Panelprincipal.setForeground(new java.awt.Color(255, 255, 255));

        PanelReserva.setBackground(new java.awt.Color(0, 0, 0));

        jTablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablaReservas);

        btneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/editar.png"))); // NOI18N
        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/eliminar.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelReservaLayout = new javax.swing.GroupLayout(PanelReserva);
        PanelReserva.setLayout(PanelReservaLayout);
        PanelReservaLayout.setHorizontalGroup(
            PanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReservaLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(PanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelReservaLayout.createSequentialGroup()
                        .addComponent(btneditar)
                        .addGap(28, 28, 28)
                        .addComponent(btneliminar)
                        .addGap(229, 229, 229))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelReservaLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1011, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
        );
        PanelReservaLayout.setVerticalGroup(
            PanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelReservaLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(PanelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneditar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        Panelprincipal.addTab("Reservas", PanelReserva);

        PanelUsuario.setBackground(new java.awt.Color(0, 0, 0));

        jTablaUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTablaUser);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelUsuarioLayout = new javax.swing.GroupLayout(PanelUsuario);
        PanelUsuario.setLayout(PanelUsuarioLayout);
        PanelUsuarioLayout.setHorizontalGroup(
            PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnbuscar)
                .addGap(34, 34, 34))
            .addGroup(PanelUsuarioLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        PanelUsuarioLayout.setVerticalGroup(
            PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelUsuarioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(PanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        Panelprincipal.addTab("Huespedes", PanelUsuario);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("SISTEMA DE BUSQUEDA");

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
            .addComponent(Panelprincipal)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(374, 374, 374))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addComponent(Panelprincipal)
                .addGap(42, 42, 42)
                .addComponent(btnvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        int filaSeleccionada = jTablaReservas.getSelectedRow();
        int columnaSeleccionada = jTablaReservas.getSelectedColumn();

        if (filaSeleccionada != -1 && columnaSeleccionada != -1) {
            // Habilitar la edición de la celda seleccionada
            jTablaReservas.editCellAt(filaSeleccionada, columnaSeleccionada);
            DefaultTableModel model = (DefaultTableModel) jTablaReservas.getModel();
            String idReserva = model.getValueAt(filaSeleccionada, 0).toString(); // Supongamos que el ID de reserva está en la primera columna
            Object nuevoValor = model.getValueAt(filaSeleccionada, columnaSeleccionada);

            if (actualizarReserva(idReserva, columnaSeleccionada, nuevoValor)) {
                JOptionPane.showMessageDialog(null, "Reserva actualizada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar la reserva");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una celda para editar");
        }
    }//GEN-LAST:event_btneditarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
      int filaSeleccionada = jTablaReservas.getSelectedRow();

        if (filaSeleccionada != -1) {
            DefaultTableModel model = (DefaultTableModel) jTablaReservas.getModel();
            String idReserva = model.getValueAt(filaSeleccionada, 0).toString(); // Supongamos que el ID de reserva está en la primera columna

            if (eliminarReserva(idReserva)) {
                JOptionPane.showMessageDialog(null, "Reserva eliminada correctamente");
                // Actualiza la tabla después de eliminar la reserva si es necesario
                mostrarReservas("reserva", user);
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar la reserva");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar");
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        Menu m=new Menu(user);
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnvolverActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        String nombre=txtnombre.getText();
        buscarHuesped(nombre);
    }//GEN-LAST:event_btnbuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelReserva;
    private javax.swing.JPanel PanelUsuario;
    private javax.swing.JTabbedPane Panelprincipal;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablaReservas;
    public javax.swing.JTable jTablaUser;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
