/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import ulp.entidades.Alumno;
import ulp.entidades.Inscripcion;
import ulp.entidades.Materia;
import ulp.modelo.Conexion;
import ulp.modelo.*;

/**
 *
 * @author MArio
 */
public class ConsultaAlumnosPorMateria extends javax.swing.JInternalFrame {
    private Conexion conexion;
    private MateriaData md;
    private AlumnoData ad;
    private InscripcionesData id;
    private DefaultTableModel modelo;
    /**
     * Creates new form ConsultaAlumnosPorMateria
     */
    public ConsultaAlumnosPorMateria() {
        initComponents();
        try {
            conexion = new Conexion();
            md = new MateriaData(conexion);
            ad = new AlumnoData(conexion);
            id = new InscripcionesData(conexion);
            modelo = new DefaultTableModel();
            
            armarCabeceraTabla();
            cargarComboBoxMaterias();
            //jcb_materias.setSelectedIndex(0);
            //cargarTablaAlumnos();
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void armarCabeceraTabla() {
        ArrayList<Object> columnas = new ArrayList<>();
        columnas.add("ID");
        columnas.add("Nombre");
        columnas.add("Apellido");
        columnas.add("DNI");
        columnas.add("Fecha Nacimiento");
        columnas.add("Activo");
        columnas.add("Nota");
        
        for (Object it : columnas) {
            modelo.addColumn(it);
        }
        jt_alumnos.setModel(modelo);
    }

    private void borrarFilasTabla() {
        int a = modelo.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    private void cargarComboBoxMaterias() {
        List<Materia> materias = md.obtener_materias();
        for (Materia item: materias) {
            jcb_materias.addItem(item);
        }
        
    }
    
    private void cargarTablaAlumnos() {
        Materia materia = (Materia) jcb_materias.getSelectedItem();
        //List<Alumno> alumnos = id.alumnos_en_materia(materia.getId_materia());
        List<Inscripcion> inscripciones = id.inscripciones_en_materia(materia);
        String si = "Sí";
        String no = "No";
        this.borrarFilasTabla();
        for (Inscripcion a: inscripciones) {
            if(a.getAlumno().isActivo()) {
            modelo.addRow(new Object[]{a.getAlumno().getId_alumno(),a.getAlumno().getNombre(),a.getAlumno().getApellido(),a.getAlumno().getDni(),a.getAlumno().getFecha_n(),si,a.getCalificacion()});
            } else {
            modelo.addRow(new Object[]{a.getAlumno().getId_alumno(),a.getAlumno().getNombre(),a.getAlumno().getApellido(),a.getAlumno().getDni(),a.getAlumno().getFecha_n(),no,a.getCalificacion()});
            }
        
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbg_buscar_materia = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_alumnos = new javax.swing.JTable();
        jcb_materias = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jt_alumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jt_alumnos.setToolTipText("");
        jScrollPane1.setViewportView(jt_alumnos);

        jcb_materias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_materiasActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccionar materia");

        jButton1.setText("ACTUALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SALIR");
        jButton2.setMaximumSize(new java.awt.Dimension(95, 23));
        jButton2.setMinimumSize(new java.awt.Dimension(95, 23));
        jButton2.setPreferredSize(new java.awt.Dimension(95, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("CONSULTA ALUMNOS EN MATERIAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcb_materias, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcb_materias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jcb_materiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_materiasActionPerformed
        // TODO add your handling code here:
        Materia materia = (Materia) jcb_materias.getSelectedItem();
        if (materia != null) {
            cargarTablaAlumnos();
        }
    }//GEN-LAST:event_jcb_materiasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.cargarTablaAlumnos();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup jbg_buscar_materia;
    private javax.swing.JComboBox<Materia> jcb_materias;
    private javax.swing.JTable jt_alumnos;
    // End of variables declaration//GEN-END:variables
}
