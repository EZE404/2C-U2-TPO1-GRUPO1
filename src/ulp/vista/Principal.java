/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.vista;

import java.awt.Dimension;

/**
 *
 * @author MArio
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
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

        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        escritorio = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_archivo = new javax.swing.JMenu();
        item_salir = new javax.swing.JMenuItem();
        menu_alumnos = new javax.swing.JMenu();
        item_formulario_alunno = new javax.swing.JMenuItem();
        jmi_baja_alumno = new javax.swing.JMenuItem();
        jmi_actualizar_alumno = new javax.swing.JMenuItem();
        menu_materias = new javax.swing.JMenu();
        item_formulario_materia = new javax.swing.JMenuItem();
        jmi_baja_materia = new javax.swing.JMenuItem();
        jmi_actualizar_materia = new javax.swing.JMenuItem();
        menu_inscripcion = new javax.swing.JMenu();
        jmi_manejo_inscripcion = new javax.swing.JMenuItem();
        menu_cargar_notas = new javax.swing.JMenu();
        jmi_manipulacion_notas = new javax.swing.JMenuItem();
        menu_consultas = new javax.swing.JMenu();
        jmi_listado_alumno = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setSize(new java.awt.Dimension(1080, 720));

        escritorio.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(0, 51, 51));
        jMenuBar1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        menu_archivo.setText("Archivo");
        menu_archivo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        item_salir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        item_salir.setText("Salir");
        item_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_salirActionPerformed(evt);
            }
        });
        menu_archivo.add(item_salir);

        jMenuBar1.add(menu_archivo);

        menu_alumnos.setText("Alumnos");
        menu_alumnos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        menu_alumnos.setHideActionText(true);

        item_formulario_alunno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        item_formulario_alunno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        item_formulario_alunno.setText("Alta Alumno");
        item_formulario_alunno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_formulario_alunnoActionPerformed(evt);
            }
        });
        menu_alumnos.add(item_formulario_alunno);

        jmi_baja_alumno.setText("Baja Alumno");
        jmi_baja_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_baja_alumnoActionPerformed(evt);
            }
        });
        menu_alumnos.add(jmi_baja_alumno);

        jmi_actualizar_alumno.setText("Modificar Alumno");
        jmi_actualizar_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_actualizar_alumnoActionPerformed(evt);
            }
        });
        menu_alumnos.add(jmi_actualizar_alumno);

        jMenuBar1.add(menu_alumnos);

        menu_materias.setText("Materias");
        menu_materias.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        item_formulario_materia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        item_formulario_materia.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        item_formulario_materia.setText("Alta Materias");
        item_formulario_materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_formulario_materiaActionPerformed(evt);
            }
        });
        menu_materias.add(item_formulario_materia);

        jmi_baja_materia.setText("Baja Materia");
        jmi_baja_materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_baja_materiaActionPerformed(evt);
            }
        });
        menu_materias.add(jmi_baja_materia);

        jmi_actualizar_materia.setText("Modificar Materia");
        jmi_actualizar_materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_actualizar_materiaActionPerformed(evt);
            }
        });
        menu_materias.add(jmi_actualizar_materia);

        jMenuBar1.add(menu_materias);

        menu_inscripcion.setText("Inscipciones");
        menu_inscripcion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jmi_manejo_inscripcion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmi_manejo_inscripcion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jmi_manejo_inscripcion.setText("Manejo de Inscripciones");
        jmi_manejo_inscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_manejo_inscripcionActionPerformed(evt);
            }
        });
        menu_inscripcion.add(jmi_manejo_inscripcion);

        jMenuBar1.add(menu_inscripcion);

        menu_cargar_notas.setText("Carga de Notas");
        menu_cargar_notas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jmi_manipulacion_notas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmi_manipulacion_notas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jmi_manipulacion_notas.setText("Manipulacion de Notas");
        jmi_manipulacion_notas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_manipulacion_notasActionPerformed(evt);
            }
        });
        menu_cargar_notas.add(jmi_manipulacion_notas);

        jMenuBar1.add(menu_cargar_notas);

        menu_consultas.setText("Consultas");
        menu_consultas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jmi_listado_alumno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmi_listado_alumno.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jmi_listado_alumno.setText("Listado de Alumnos x Materia");
        jmi_listado_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_listado_alumnoActionPerformed(evt);
            }
        });
        menu_consultas.add(jmi_listado_alumno);

        jMenuBar1.add(menu_consultas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void item_formulario_materiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_formulario_materiaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        MateriaAlta vm=new MateriaAlta();
        vm.setVisible(true);
        escritorio.add(vm);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = vm.getSize();
        vm.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        vm.show();
    }//GEN-LAST:event_item_formulario_materiaActionPerformed

    private void item_formulario_alunnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_formulario_alunnoActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        AlumnoAlta vas=new AlumnoAlta();
        vas.setVisible(true);
        escritorio.add(vas);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = vas.getSize();
        vas.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        vas.show();
    }//GEN-LAST:event_item_formulario_alunnoActionPerformed

    private void jmi_listado_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_listado_alumnoActionPerformed
//        escritorio.removeAll();
//        escritorio.repaint();
//        vistaConsulta vc=new vistaConsulta();
//        vc.setVisible(true);
//        escritorio.add(vc);
//        Dimension desktopSize = escritorio.getSize();
//        Dimension FrameSize = vc.getSize();
//        vc.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
//        vc.show();
    }//GEN-LAST:event_jmi_listado_alumnoActionPerformed

    private void jmi_manejo_inscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_manejo_inscripcionActionPerformed
//        escritorio.removeAll();
//        escritorio.repaint();
//        VistaInscripcion vi=new VistaInscripcion();
//        vi.setVisible(true);
//        escritorio.add(vi);
//        Dimension desktopSize = escritorio.getSize();
//        Dimension FrameSize = vi.getSize();
//        vi.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
//        vi.show();
    }//GEN-LAST:event_jmi_manejo_inscripcionActionPerformed

    private void jmi_manipulacion_notasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_manipulacion_notasActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaCargaNota vcn=new VistaCargaNota();
        vcn.setVisible(true);
        escritorio.add(vcn);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = vcn.getSize();
        vcn.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        vcn.show();
        vcn.hacerFoco();
    }//GEN-LAST:event_jmi_manipulacion_notasActionPerformed

    private void item_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_salirActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_item_salirActionPerformed

    private void jmi_actualizar_materiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_actualizar_materiaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        MateriaActualizar vas=new MateriaActualizar();
        vas.setVisible(true);
        escritorio.add(vas);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = vas.getSize();
        vas.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        vas.show();
    }//GEN-LAST:event_jmi_actualizar_materiaActionPerformed

    private void jmi_baja_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_baja_alumnoActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        AlumnoBaja vas=new AlumnoBaja();
        vas.setVisible(true);
        escritorio.add(vas);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = vas.getSize();
        vas.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        vas.show();
    }//GEN-LAST:event_jmi_baja_alumnoActionPerformed

    private void jmi_actualizar_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_actualizar_alumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmi_actualizar_alumnoActionPerformed

    private void jmi_baja_materiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_baja_materiaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        MateriaBaja vas=new MateriaBaja();
        vas.setVisible(true);
        escritorio.add(vas);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = vas.getSize();
        vas.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        vas.show();
    }//GEN-LAST:event_jmi_baja_materiaActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel escritorio;
    private javax.swing.JMenuItem item_formulario_alunno;
    private javax.swing.JMenuItem item_formulario_materia;
    private javax.swing.JMenuItem item_salir;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jmi_actualizar_alumno;
    private javax.swing.JMenuItem jmi_actualizar_materia;
    private javax.swing.JMenuItem jmi_baja_alumno;
    private javax.swing.JMenuItem jmi_baja_materia;
    private javax.swing.JMenuItem jmi_listado_alumno;
    private javax.swing.JMenuItem jmi_manejo_inscripcion;
    private javax.swing.JMenuItem jmi_manipulacion_notas;
    private javax.swing.JMenu menu_alumnos;
    private javax.swing.JMenu menu_archivo;
    private javax.swing.JMenu menu_cargar_notas;
    private javax.swing.JMenu menu_consultas;
    private javax.swing.JMenu menu_inscripcion;
    private javax.swing.JMenu menu_materias;
    // End of variables declaration//GEN-END:variables
}
