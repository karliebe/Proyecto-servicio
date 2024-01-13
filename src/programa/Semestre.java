/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package programa;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mahmu
 */
public class Semestre extends javax.swing.JPanel {

    /**
     * Creates new form Semestre
     */
    String peri = "2023-2CR";

    public Semestre() {
        initComponents();
        conexion objConexion = new conexion();
        ResultSet rst = objConexion.consultaRegistros("SELECT COUNT(*) AS count, periodo FROM Periodos");
        try {
            if (rst.next()) {
                int rowCount = rst.getInt("count");
                if (rowCount == 0) {
                    peri = rst.getString("periodo");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Semestre.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println(peri);
        jLabel7.setText(jLabel7.getText()+" " + peri);
        
        ResultSet rs = objConexion.consultaRegistros("SELECT COUNT(*) FROM trabajo_grado");
        try {
            if (rs.next()) {
                int rowCount = rs.getInt(1);
                jLabel2.setText(jLabel2.getText() + " " + rowCount);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Semestre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         ResultSet rsp = objConexion.consultaRegistros("SELECT COUNT(*) FROM Pasantia");
        try {
            if (rsp.next()) {
                int rowCount = rsp.getInt(1);
                jLabel3.setText(jLabel3.getText() + " " + rowCount);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Semestre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        ResultSet rsd = objConexion.consultaRegistros("SELECT COUNT(*) FROM Diseno");
//        try {
//            if (rsd.next()) {
//                int rowCount = rsd.getInt(1);
//                jLabel4.setText(jLabel4.getText() + " " + rowCount);
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Semestre.class.getName()).log(Level.SEVERE, null, ex);
//        }

        ResultSet rsea = objConexion.consultaRegistros("SELECT COUNT(*) FROM estudiantes WHERE estado = '" + true + "'");
        try {
            if (rsea.next()) {
                int rowCount = rsea.getInt(1);
                jLabel5.setText(jLabel5.getText() + " " + rowCount);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Semestre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet rser = objConexion.consultaRegistros("SELECT COUNT(*) FROM estudiantes WHERE estado = '" + false + "'");
        try {
            if (rser.next()) {
                int rowCount = rser.getInt(1);
                jLabel6.setText(jLabel6.getText() + " " + rowCount);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Semestre.class.getName()).log(Level.SEVERE, null, ex);
        }
        objConexion.cerrarConexion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Culminacion de semestre");

        jLabel2.setText("Trabajo de grado registrados: ");

        jLabel3.setText("Pasantias registradas: ");

        jLabel4.setText("Diseños registrados:");

        jLabel5.setText("Estudiantes aprobados:");

        jLabel6.setText("Estudiantes reprobados:");

        jLabel7.setText("Periodo actual:");

        jButton1.setText("Culminar semestre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(31, 31, 31)
                .addComponent(jButton1)
                .addContainerGap(98, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(null, "Esta opción es irreversible y procedera con la culminación del semestre.\nEsta seguro que desea continuar?", "Confirmar",
                JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            System.out.println("Aceptr pulsado");
            // Crear un nombre de archivo único para guardar la base de datos
            String rutaCarpeta = "Historial de semestres";
            String nombreArchivo = peri + ".s3db";

            // Crear el archivo de destino en la carpeta "Historial semestres"
            File archivoDestino = new File(rutaCarpeta, nombreArchivo);

            // Guardar la base de datos en el archivo de destino
            guardarBaseDeDatos(archivoDestino);

        } else if (result == JOptionPane.CANCEL_OPTION) {
            System.out.println("Cancelar pulsado");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void guardarBaseDeDatos(File archivo) {
        // Aquí implementarás el código para guardar la base de datos en el archivo.
        // Puedes utilizar la biblioteca de tu elección para hacer copias de seguridad de la base de datos.
        // Por ejemplo, si estás utilizando SQLite, puedes copiar el archivo de la base de datos en el archivo seleccionado.
        // Asegúrate de manejar las excepciones adecuadamente.

        // Ejemplo para copiar la base de datos a un archivo de destino
        File baseDeDatos = new File("database.s3db");
        try {
            Files.copy(baseDeDatos.toPath(), archivo.toPath());
            JOptionPane.showMessageDialog(this, "Base de Datos guardada exitosamente en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar la Base de Datos");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
