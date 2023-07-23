package VIEW;
import MODEL.Estudiante;
import CONTROLER.ProcesarEstudiantes;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class FormTestEstudiante extends javax.swing.JFrame {
    DefaultTableModel modelo;
    ProcesarEstudiantes procesarEstudiantes;
    public FormTestEstudiante() {
        initComponents();
        modelo = (DefaultTableModel) this.jTable1.getModel();
        procesarEstudiantes = new ProcesarEstudiantes(new ArrayList<>());
    }
    private void initComponents() {
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jButton1.setText("Conectar");
        jButton2.setText("Insertar");
        jButton3.setText("Eliminar");
        jButton4.setText("Actualizar");
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "ID", "Nombre", "Nota1", "Nota2", "Promedio", "Estado"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton4)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        cargarEstudiantes();
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String nombreEst = JOptionPane.showInputDialog(this, "Ingrese el nombre del estudiante:", "Ingresar nombre", JOptionPane.PLAIN_MESSAGE);
        String nota1Str = JOptionPane.showInputDialog(this, "Ingrese la nota 1:", "Ingresar nota 1", JOptionPane.PLAIN_MESSAGE);
        String nota2Str = JOptionPane.showInputDialog(this, "Ingrese la nota 2:", "Ingresar nota 2", JOptionPane.PLAIN_MESSAGE);
        try {
            double nota1 = Double.parseDouble(nota1Str);
            double nota2 = Double.parseDouble(nota2Str);
            Estudiante nuevoEstudiante = new Estudiante(nombreEst, nota1, nota2);
            procesarEstudiantes.insertarEstudiante(nuevoEstudiante);
            cargarEstudiantes();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Las notas deben ser valores numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            int idEstudiante = (int) jTable1.getValueAt(row, 0);
            procesarEstudiantes.eliminarEstudiante(idEstudiante);
            cargarEstudiantes();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un estudiante para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        // Botón "Actualizar" para actualizar un estudiante
        int row = jTable1.getSelectedRow();
        if (row != -1) {
            int idEstudiante = (int) jTable1.getValueAt(row, 0);
            String nombreEst = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre del estudiante:", "Actualizar nombre", JOptionPane.PLAIN_MESSAGE);
            String nota1Str = JOptionPane.showInputDialog(this, "Ingrese la nueva nota 1:", "Actualizar nota 1", JOptionPane.PLAIN_MESSAGE);
            String nota2Str = JOptionPane.showInputDialog(this, "Ingrese la nueva nota 2:", "Actualizar nota 2", JOptionPane.PLAIN_MESSAGE);
            try {
                double nota1 = Double.parseDouble(nota1Str);
                double nota2 = Double.parseDouble(nota2Str);
                double promedio = (nota1 + nota2) / 2;
                String estado = (promedio >= 7) ? "Aprobado" : "Reprobado";
                Estudiante estudianteActualizado = new Estudiante(idEstudiante, nombreEst, nota1, nota2, promedio, estado);
                procesarEstudiantes.actualizarEstudiante(estudianteActualizado);
                cargarEstudiantes();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Las notas deben ser valores numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un estudiante para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void cargarEstudiantes() {
        while (modelo.getRowCount() > 0)
            modelo.removeRow(0);
        ArrayList<Estudiante> lstEst = procesarEstudiantes.getLstEstudiantes();
        for (Estudiante est : lstEst)
            modelo.addRow(new Object[]{est.idEstudiante, est.nombreEst, est.nota1, est.nota2, est.promedio, est.estado});
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTestEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTestEstudiante().setVisible(true);
            }
        });
    }
}
