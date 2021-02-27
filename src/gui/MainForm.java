/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.google.gson.Gson;
import conexion.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author dianacastro
 */
public class MainForm extends javax.swing.JFrame implements GUIObserver {
        Gson datosJson;
        private final Cliente clienteServer;
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        datosJson= new Gson();
        this.setLocationRelativeTo(null);
        this.setTitle("Sistema Maestro");

        this.clienteServer = new Cliente(this);
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

        jLabel1 = new javax.swing.JLabel();
        txtMaestro = new javax.swing.JTextField();
        txtMateria = new javax.swing.JTextField();
        txtAlumno = new javax.swing.JTextField();
        txtCalificacion = new javax.swing.JTextField();
        lblMaestro = new javax.swing.JLabel();
        lblMateria = new javax.swing.JLabel();
        lblAlumno = new javax.swing.JLabel();
        lblCalificacion = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        lblEncabezado = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(425, 370));
        setMinimumSize(new java.awt.Dimension(425, 370));
        setPreferredSize(new java.awt.Dimension(425, 370));
        setSize(new java.awt.Dimension(425, 370));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setText("Sistema Maestro");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));
        getContentPane().add(txtMaestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 140, -1));
        getContentPane().add(txtMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 140, -1));

        txtAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlumnoActionPerformed(evt);
            }
        });
        getContentPane().add(txtAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 140, -1));
        getContentPane().add(txtCalificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 140, -1));

        lblMaestro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblMaestro.setText("Nombre");
        lblMaestro.setToolTipText("");
        getContentPane().add(lblMaestro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        lblMateria.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblMateria.setText("Materia");
        getContentPane().add(lblMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        lblAlumno.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblAlumno.setText("Alumno");
        getContentPane().add(lblAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, 20));

        lblCalificacion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblCalificacion.setText("Calificación");
        getContentPane().add(lblCalificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, -1, 20));

        btnEnviar.setBackground(new java.awt.Color(255, 204, 0));
        btnEnviar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));

        lblEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FED148.jpeg"))); // NOI18N
        getContentPane().add(lblEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 60));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blanco.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlumnoActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
       //String datosString=txtMaestro.getText()+txtMateria.getText()+txtAlumno.getText()+txtCalificacion.getText();
       String json = "{ \"maestro\": \""+txtMaestro.getText()+"\","+
               "\"materia\": \""+txtMateria.getText()+"\","+
               "\"alumno\": \""+txtAlumno.getText()+"\","
               + " \"calificacion\": \""+txtCalificacion.getText()+"\" }";
       this.btnEnviar.setEnabled(false);
       //this.datosJson.toJson((Object)datosString);
       //aquí se le manda a enviar
       this.clienteServer.enviar(json);
    }//GEN-LAST:event_btnEnviarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAlumno;
    private javax.swing.JLabel lblCalificacion;
    private javax.swing.JLabel lblEncabezado;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblMaestro;
    private javax.swing.JLabel lblMateria;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextField txtCalificacion;
    private javax.swing.JTextField txtMaestro;
    private javax.swing.JTextField txtMateria;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(String contenido) {
        this.btnEnviar.setEnabled(true);
        JOptionPane.showMessageDialog(this,"Enviado");
    }
}
