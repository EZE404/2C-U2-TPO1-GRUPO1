/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.vista;

import java.util.List;
import javax.swing.JOptionPane;
import ulp.entidades.Alumno;
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
        Conexion conexion = new Conexion();
        Alumno alumno;
        AlumnoData alumno_data = new AlumnoData(conexion);
        MateriaData materia_data = new MateriaData(conexion);
        InscripcionesData ins_data = new InscripcionesData(conexion);
        List<Materia> materias;
        List<Materia> materiasNoIns;
        List<Materia> materiasIns;
        
    /**
     * Creates new form VistaInscripciones
     */
    public vistaInscripcion() {
        initComponents();
        this.cargarAlumnos();
        jrb_inscripcion.setSelected(false);
        jrb_no_inscriptas.setSelected(false);
       
    }
    public void cargarAlumnos(){
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
        jrb_inscripcion = new javax.swing.JRadioButton();
        jrb_no_inscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt_materia = new javax.swing.JTable();
        jb_inscribir = new javax.swing.JButton();
        jb_anular = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jb_salir = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Inscripcion");

        jLabel2.setText("Alumnos");

        jcb_alumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_alumnosActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_inscripcion);
        jrb_inscripcion.setText("Inscriptas");
        jrb_inscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_inscripcionActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrb_no_inscriptas);
        jrb_no_inscriptas.setText("No Inscriptas");
        jrb_no_inscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb_no_inscriptasActionPerformed(evt);
            }
        });

        jt_materia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Materia", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jt_materia.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jt_materia);

        jb_inscribir.setText("Inscribir");

        jb_anular.setText("Anula Inscripcion");

        jButton3.setText("jButton3");

        jb_salir.setText("Salir");
        jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salirActionPerformed(evt);
            }
        });

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
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jrb_inscripcion)
                                .addGap(58, 58, 58)
                                .addComponent(jrb_no_inscriptas))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jcb_alumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jb_inscribir)
                        .addGap(52, 52, 52)
                        .addComponent(jb_anular)
                        .addGap(49, 49, 49)
                        .addComponent(jButton3)))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jb_salir)
                .addGap(16, 16, 16))
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
                    .addComponent(jrb_inscripcion)
                    .addComponent(jrb_no_inscriptas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_inscribir)
                    .addComponent(jb_anular)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jb_salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jb_salirActionPerformed

    private void jcb_alumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_alumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_alumnosActionPerformed

    private void jrb_inscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_inscripcionActionPerformed
        this.borrarFilasTabla();    
        materias=null;   
            Alumno seleccionado=(Alumno)jcb_alumnos.getSelectedItem();
           if(seleccionado!=null){
                int id=seleccionado.getId_alumno();
                materias= ins_data.materias_alumno(id);
                for (int i = 0; i < materias.size(); i++) {
                jt_materia.setValueAt(materias.get(i).getId_materia(), i, 0);
                jt_materia.setValueAt(materias.get(i).getNombre_materia(), i, 1);
                }
        }
           else{
               JOptionPane.showMessageDialog(this, "El alumno no tiene materias");
           
           }
           jb_anular.setEnabled(true);
           jb_inscribir.setEnabled(false);
    }//GEN-LAST:event_jrb_inscripcionActionPerformed

    private void jrb_no_inscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_no_inscriptasActionPerformed
        this.borrarFilasTabla();
        materias=null;  
        materias=materia_data.obtener_materias();
        Alumno alu=(Alumno) jcb_alumnos.getSelectedItem();
        materiasIns=ins_data.materias_alumno(alu.getId_alumno());
        for (int i = 0; i < materiasIns.size(); i++) {
           for(int j=0; j<materias.size();j++){
                if((materiasIns.get(i).getId_materia()==materias.get(j).getId_materia())){
                   materias.remove(materiasIns.get(i));
                }
           }
        }
        for (int i = 0; i < materias.size(); i++) {
           jt_materia.setValueAt(materias.get(i).getId_materia(), i, 0);
           jt_materia.setValueAt(materias.get(i).getNombre_materia(), i, 1);
        }
            jb_anular.setEnabled(false);
           jb_inscribir.setEnabled(true);
    }//GEN-LAST:event_jrb_no_inscriptasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_anular;
    private javax.swing.JButton jb_inscribir;
    private javax.swing.JButton jb_salir;
    private javax.swing.JComboBox<Alumno> jcb_alumnos;
    private javax.swing.JRadioButton jrb_inscripcion;
    private javax.swing.JRadioButton jrb_no_inscriptas;
    private javax.swing.JTable jt_materia;
    // End of variables declaration//GEN-END:variables
public void borrarFilasTabla(){
//       int a=jt_materia.getRowCount()-1;
//       for(int i=a;i>=0;i--){
//           jt_materia.remove();
//       }
}
}