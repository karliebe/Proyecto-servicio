/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package programa;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USUARIO
 */
public class Pasantiab extends javax.swing.JPanel {

    /**
     * Creates new form Pasantiab
     */
    public Pasantiab() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        razontext = new javax.swing.JTextField();
        anteSave1 = new javax.swing.JButton();
        anteEdit1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        tutorCombo = new javax.swing.JComboBox<>();

        jLabel16.setText("Pasantias");

        jLabel24.setText("Titulo del proyecto");

        razontext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                razontextActionPerformed(evt);
            }
        });

        anteSave1.setText("Save");
        anteSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteSave1ActionPerformed(evt);
            }
        });

        anteEdit1.setText("Edit");
        anteEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteEdit1ActionPerformed(evt);
            }
        });

        jLabel26.setText("Tutor Académico");

        tutorCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jLabel16)
                .addGap(149, 149, 149))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(9, 9, 9)
                        .addComponent(tutorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(razontext, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(anteEdit1)
                        .addGap(60, 60, 60)
                        .addComponent(anteSave1)))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(razontext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(tutorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anteEdit1)
                    .addComponent(anteSave1))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void anteSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteSave1ActionPerformed
String cedula1 = Alumnosside.cedulaEst.getText();
String razonSocial = razontext.getText();
String tutorAcademico = tutorCombo.getSelectedItem().toString();
String cedulaEstudiante = Alumnosside.cedulaEst.getText();
String periodo = "Periodo"; // No está claro de dónde obtienes este valor

// Verifica que los campos no estén vacíos
if (!razonSocial.isEmpty() && !tutorAcademico.isEmpty() && !cedulaEstudiante.isEmpty()) {
    String updateSql = String.format("UPDATE Pasantia SET"
            + " razon_social = '%s',"
            + " tutor_academico = '%s',"
            + " periodo = '%s'"
            + " WHERE cedula_estudiante = '%s'",
            razonSocial,
            tutorAcademico,
            periodo,
            cedulaEstudiante);

        conexion habana = new conexion();

        String find = String.format("SELECT COUNT(*) FROM estudiantes Where Cedula = '" + cedula1 + "'");
        ResultSet rs = habana.consultaRegistros(find);

        try {
            if (rs.next()) {
                int cantidad = rs.getInt(1);
                if (cantidad > 0) {

                    try {
                        String consultaPasantia = "SELECT id_pasantia FROM estudiantes WHERE Cedula = '" + cedula1 + "'";
                        ResultSet rsPasantia = habana.consultaRegistros(consultaPasantia);
                        int idPasantia = rsPasantia.getInt("id_pasantia");

                        if (idPasantia != 0) {

                            // Aquí tienes el valor de id_pasantia para el estudiante con la cédula especificada
                            JOptionPane.showMessageDialog(null, "El estudiante " + cedula1 + " ya tiene una pasantia asignada.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {

                            String consultatrabajo = "SELECT id_trabajo FROM estudiantes WHERE Cedula = '" + cedula1 + "'";
                            ResultSet rstrabajo = habana.consultaRegistros(consultatrabajo);
                            int idtrabajo = rstrabajo.getInt("id_trabajo");

                            try {
                                if (idtrabajo != 0) {

                                    JOptionPane.showMessageDialog(null, "El estudiante " + cedula1 + " ya tiene un trabajo de grado asignado.", "Error", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    // El estudiante no tiene una pasantía asignada
                                    String addSql = String.format("INSERT INTO Pasantia (razon_social, tutor_academico, cedula_estudiante, periodo) VALUES"
                                        + "('%s', '%s', '%s', '%s')",
                                        razontext.getText(), tutorCombo.getSelectedItem(), Alumnosside.cedulaEst.getText(), "Periodo");

                                    habana.ejecutarSentenciaSQl(addSql);
                                    
                                    

                                    // Obtener el último valor autoincremental de la tabla
                                    String getLastIdSql = "SELECT last_insert_rowid()";
                                    ResultSet lastIdResultSet = habana.consultaRegistros(getLastIdSql);
                                    
                                   

                                    if (lastIdResultSet.next()) {
                                        int idGenerado = lastIdResultSet.getInt(1);
                                        // Actualizar la tabla estudiantes con el ID generado
                                        String updateEstudiantesSql = String.format("UPDATE estudiantes SET id_pasantia = %d WHERE Cedula = '%s'", idGenerado, cedula1);
                                        habana.ejecutarSentenciaSQl(updateEstudiantesSql);

                                    }
                                    
                                     String sql2 = "SELECT num_est, periodo, Escuela FROM estudiantes WHERE Cedula = '" + Alumnosside.cedulaEst.getText() + "'";
                
                                    ResultSet rsC = habana.consultaRegistros(sql2);

                // Obtener los valores de las columnas y guardarlos en variables
                String num_est = rsC.getString("num_est");
                String periodoC = rsC.getString("periodo");
                String escuela = rsC.getString("Escuela");

                switch (escuela) {
                    case "Computación":

                        escuela = "C";
                        break;
                    case "Industrial":
                        escuela = "I";
                        break;
                    case "Civil":
                        escuela = "L";
                        break;
                    case "Electrónica":
                        escuela = "Et";
                        break;
                    case "Telecomunicaciones":
                        escuela = "T";
                        break;
                    case "Mecánica":
                        escuela = "N";
                        break;
                    case "Arquitectura":
                        escuela = "Q";
                        break;
                    default:
                    // código que se ejecuta si no se cumple ninguna de las opciones anteriores
                }

                String cod = "FI-" + escuela + "-" + num_est + "-" + periodoC + "-" + "PS";

                String sql3 = String.format("UPDATE estudiantes SET codigo = '%s', tipo = 'Pasantia' WHERE Cedula = '%s'", cod, Alumnosside.cedulaEst.getText());

                habana.ejecutarSentenciaSQl(sql3);
                                }
                            } catch (SQLException ex) {

                            }
                        }
                    } catch (SQLException ex) {

                    }
                } else {

                    JOptionPane.showMessageDialog(null, "El estudiante " + cedula1 + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(null, "El estudiante " + cedula1 + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            // Manejar excepciones de SQL
            e.printStackTrace();
        }
        habana.cerrarConexion();
}else {
    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos antes de actualizar.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
   

}
    }//GEN-LAST:event_anteSave1ActionPerformed

    private void anteEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteEdit1ActionPerformed
       conexion habana = new conexion();
String razonSocial = razontext.getText();
String tutorAcademico = tutorCombo.getSelectedItem().toString();
String cedulaEstudiante = Alumnosside.cedulaEst.getText();
String periodo = "Periodo"; // No está claro de dónde obtienes este valor

// Verifica que los campos no estén vacíos
if (!razonSocial.isEmpty() && !tutorAcademico.isEmpty() && !cedulaEstudiante.isEmpty()) {
    String updateSql = String.format("UPDATE Pasantia SET razon_social = '%s', tutor_academico = '%s', periodo = '%s' WHERE cedula_estudiante = '%s'",
            razonSocial, tutorAcademico, periodo, cedulaEstudiante);

    try {
        habana.ejecutarSentenciaSQl(updateSql);
        JOptionPane.showMessageDialog(null, "La pasantía del estudiante con cédula " + cedulaEstudiante + " ha sido editada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        habana.cerrarConexion();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar la pasantía: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            habana.cerrarConexion();

    }
} else {
    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos antes de actualizar.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
        habana.cerrarConexion();

}

    }//GEN-LAST:event_anteEdit1ActionPerformed

    private void razontextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_razontextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_razontextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anteEdit1;
    private javax.swing.JButton anteSave1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JTextField razontext;
    private javax.swing.JComboBox<String> tutorCombo;
    // End of variables declaration//GEN-END:variables
}
