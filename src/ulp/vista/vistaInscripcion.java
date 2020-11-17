/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ulp.entidades.Alumno;
import ulp.entidades.Inscripcion;
import ulp.entidades.Materia;
import ulp.modelo.AlumnoData;
import ulp.modelo.Conexion;
import ulp.modelo.InscripcionesData;
import ulp.modelo.MateriaData;

/**
 *
 * @author MArio
 */
public class vistaInscripcion extends javax.swing.JInternalFrame {
        Conexion conexion;

        AlumnoData alumno_data;
        MateriaData materia_data;
        InscripcionesData ins_data;

        DefaultTableModel modelo;
    /**
     * Creates new form VistaInscripciones
     */
    public vistaInscripcion() {
        initComponents();
        try {
        conexion = new Conexion();
        
        alumno_data = new AlumnoData(conexion);
        materia_data = new MateriaData(conexion);
        ins_data = new InscripcionesData(conexion);
        
        cargarAlumnos();
        jcb_alumnos.setSelectedItem(null);
        modelo=new DefaultTableModel();
        armarCabeceraTabla();
        
        jb_anular.setEnabled(false);
        jb_inscribir.setEnabled(false);
                
        } catch (Exception e) {
        
        }   
    }
    
    private void cargarNoInscriptas(){
        Alumno alumno = (Alumno) jcb_alumnos.getSelectedItem();
        List<Materia> materias = ins_data.obtener_materias_alumno_nocursa(alumno.getId_alumno());
        this.borrarFilasTabla();
        for (Materia m:materias) {
        modelo.addRow(new Object[]{m.getId_materia(),m.getNombre_materia()});
        }
        jb_anular.setEnabled(false);
        jb_inscribir.setEnabled(true);
   }
    
    private void cargarInscriptas(){
        Alumno alumno = (Alumno) jcb_alumnos.getSelectedItem();
        List<Materia> materias = ins_data.materias_alumno(alumno.getId_alumno());
        this.borrarFilasTabla();    
        for (Materia m:materias) {
        modelo.addRow(new Object[]{m.getId_materia(),m.getNombre_materia()});
        }
        jb_anular.setEnabled(true);
        jb_inscribir.setEnabled(false);
   }
    private void armarCabeceraTabla(){
       ArrayList<Object> columnas=new ArrayList<>();   
       columnas.add("ID");
       columnas.add("Nombre");
       for(Object it:columnas){
           modelo.addColumn(it);
       }
       jt_materia.setModel(modelo);
}
    
    private void borrarFilasTabla(){
       int a=modelo.getRowCount()-1;
       for(int i=a;i>=0;i--){
           modelo.removeRow(i);
       }
}

    private void cargarAlumnos(){
        List<Alumno> alumnos=alumno_data.ver_alumnos();
        for(Alumno item: alumnos){
            jcb_alumnos.addItem(item);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcb_alumnos = new javax.swing.JComboBox<>();
        jrb_inscriptas = new javax.swing.JRadioButton();
        jrb_no_inscriptas = new javax.swing.JRadioButton();
        jb_inscribir = new javax.swing.JButton();
        jb_anular = new javax.swing.JButton();
        jb_salir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_materia = new javax.swing.JTable();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Inscripcion");

        jLabel2.setText("Alumnos");

        jcb_alumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_alumnosActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_inscriptas);
        jrb_inscriptas.setText("Inscriptas");
        jrb_inscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_inscriptasActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_no_inscriptas);
        jrb_no_inscriptas.setText("No Inscriptas");
        jrb_no_inscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_no_inscriptasActionPerformed(evt);
            }
        });

        jb_inscribir.setText("Inscribir");
        jb_inscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_inscribirActionPerformed(evt);
            }
        });

        jb_anular.setText("Anula Inscripcion");
        jb_anular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_anularActionPerformed(evt);
            }
        });

        jb_salir.setText("Salir");
        jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salirActionPerformed(evt);
            }
        });

        jt_materia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jt_materia);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jb_inscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jb_anular, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jb_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jrb_inscriptas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jrb_no_inscriptas))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jcb_alumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcb_alumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrb_inscriptas)
                    .addComponent(jrb_no_inscriptas))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_inscribir)
                    .addComponent(jb_anular)
                    .addComponent(jb_salir))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jb_salirActionPerformed

    private void jcb_alumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_alumnosActionPerformed

    }//GEN-LAST:event_jcb_alumnosActionPerformed

    private void jrb_inscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_inscriptasActionPerformed
        Alumno seleccionado = (Alumno) jcb_alumnos.getSelectedItem();
        if (seleccionado != null) {
            this.cargarInscriptas();
            
        } else {
            JOptionPane.showMessageDialog(this, "No hay alumno seleccionado");
            jrb_inscriptas.setSelected(false);
        }
        
    }//GEN-LAST:event_jrb_inscriptasActionPerformed

    private void jrb_no_inscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_no_inscriptasActionPerformed
        Alumno seleccionado = (Alumno) jcb_alumnos.getSelectedItem();
        if (seleccionado != null) {
            this.cargarNoInscriptas();
            
        } else {
            JOptionPane.showMessageDialog(this, "No hay alumno seleccionado");
            jrb_no_inscriptas.setSelected(false);
        }
        
    }//GEN-LAST:event_jrb_no_inscriptasActionPerformed

    private void jb_anularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_anularActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea anular inscripción?", "Anular inscripción", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (respuesta == 0) {
            Alumno a = (Alumno) jcb_alumnos.getSelectedItem();
            int filaSleccionada = jt_materia.getSelectedRow();
            if (filaSleccionada != -1) {
                int id_materia = (Integer) modelo.getValueAt(filaSleccionada, 0);
                if (a != null) {
                    int id_alumno = a.getId_alumno();
                    ins_data.desinscribir_alumno(id_alumno, id_materia);
                    jrb_inscriptas.setSelected(true);
                    this.cargarInscriptas();

                } else {
                    JOptionPane.showMessageDialog(this, "No hay alumno seleccionado");
                    buttonGroup1.clearSelection();
                    this.borrarFilasTabla();
                    jcb_alumnos.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "No hay materia seleccionada");
                jrb_inscriptas.setSelected(true);
                this.cargarInscriptas();
                jb_anular.setSelected(false);
                jt_materia.requestFocus();
            }
        }
    }//GEN-LAST:event_jb_anularActionPerformed

    private void jb_inscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_inscribirActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea inscribir?", "Inscribir alumno", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (respuesta == 0) {
            Inscripcion inscripcion;
            Materia m;
            Alumno a = (Alumno) jcb_alumnos.getSelectedItem();
            int filaSleccionada = jt_materia.getSelectedRow();

            if (filaSleccionada != -1) {
                int idMateria = (Integer) modelo.getValueAt(filaSleccionada, 0);
                m = materia_data.buscar_materia(idMateria);
                if (a != null) {
                    inscripcion = new Inscripcion(a, m);
                    ins_data.inscribir_alumno(inscripcion);
                    System.out.println("el id de alumno cuando va a inscribir es " + a.getId_alumno());
                    jrb_no_inscriptas.setSelected(true);
                    this.cargarNoInscriptas();
                } else {
                    JOptionPane.showMessageDialog(this, "No hay alumno seleccionado");
                    buttonGroup1.clearSelection();
                    this.borrarFilasTabla();
                    jcb_alumnos.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "No hay materia seleccionada");
                jrb_no_inscriptas.setSelected(true);
                this.cargarNoInscriptas();
                jb_inscribir.setSelected(false);
                jt_materia.requestFocus();
            }
        }
    }//GEN-LAST:event_jb_inscribirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_anular;
    private javax.swing.JButton jb_inscribir;
    private javax.swing.JButton jb_salir;
    private javax.swing.JComboBox<Alumno> jcb_alumnos;
    private javax.swing.JRadioButton jrb_inscriptas;
    private javax.swing.JRadioButton jrb_no_inscriptas;
    private javax.swing.JTable jt_materia;
    // End of variables declaration//GEN-END:variables

}
