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
        Alumno alumno;
        AlumnoData alumno_data;
        MateriaData materia_data;
        InscripcionesData ins_data;
        List<Materia> materias;
        List<Materia> materiasNoIns;
        List<Materia> materiasIns;
        DefaultTableModel modelo;
        
    /**
     * Creates new form VistaInscripciones
     */
    public vistaInscripcion() {
        initComponents();
        
        jb_anular.setEnabled(false);
        jb_inscribir.setEnabled(false);
        try {
        //Array instancias
        conexion = new Conexion();
        modelo=new DefaultTableModel();
        alumno_data = new AlumnoData(conexion);
        materia_data = new MateriaData(conexion);
        ins_data = new InscripcionesData(conexion);
        //Instancias Arrays
        materias=new ArrayList<>();
        materiasNoIns=new ArrayList<>();
        this.cargarAlumnos(); 
        this.armarCabeceraTabla();
        jcb_alumnos.setSelectedItem(null);
        } catch (Exception e) {
        }
        
       
    }
    private void cargarNoInscriptas(){
        this.borrarFilasTabla();    
        Alumno seleccionado=(Alumno)jcb_alumnos.getSelectedItem();
        materiasNoIns=materia_data.obtener_materias_alumno_nocursa(seleccionado.getId_alumno());
        for (Materia m:materiasNoIns) {
        modelo.addRow(new Object[]{m.getId_materia(),m.getNombre_materia()});
        }
   }
    private void cargarInscriptas(){
        this.borrarFilasTabla();    
        Alumno seleccionado=(Alumno)jcb_alumnos.getSelectedItem();
        materias= ins_data.materias_alumno(seleccionado.getId_alumno());
        for (Materia m:materias) {
        modelo.addRow(new Object[]{m.getId_materia(),m.getNombre_materia()});
        }
   }
    private void armarCabeceraTabla(){
       ArrayList<Object> columnas=new ArrayList<Object>();   
       columnas.add("ID");
       columnas.add("Nombre");
       for(Object it:columnas){
           modelo.addColumn(it);
       }
       jt_materia.setModel(modelo);
}
    
    public void borrarFilasTabla(){
       int a=jt_materia.getRowCount()-1;
       for(int i=a;i>=0;i--){
           modelo.removeRow(i);
       }
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
        jrb_inscriptas = new javax.swing.JRadioButton();
        jrb_no_inscriptas = new javax.swing.JRadioButton();
        jb_inscribir = new javax.swing.JButton();
        jb_anular = new javax.swing.JButton();
        jb_salir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
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
                "ID", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jt_materia);

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
                                .addComponent(jrb_inscriptas)
                                .addGap(58, 58, 58)
                                .addComponent(jrb_no_inscriptas))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jcb_alumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jb_inscribir)
                .addGap(52, 52, 52)
                .addComponent(jb_anular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_salir)
                .addGap(77, 77, 77))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_inscribir)
                    .addComponent(jb_anular)
                    .addComponent(jb_salir))
                .addContainerGap(70, Short.MAX_VALUE))
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

    private void jrb_inscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_inscriptasActionPerformed
         Alumno seleccionado=(Alumno)jcb_alumnos.getSelectedItem();
        if(seleccionado!=null){
                this.cargarInscriptas();
        }
           else{
               JOptionPane.showMessageDialog(this, "No ha alumno seleccionado");
           
           }
           jb_anular.setEnabled(true);
           jb_inscribir.setEnabled(false);
    }//GEN-LAST:event_jrb_inscriptasActionPerformed

    private void jrb_no_inscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb_no_inscriptasActionPerformed
        Alumno seleccionado=(Alumno) jcb_alumnos.getSelectedItem();
        if(seleccionado!=null){
                this.cargarNoInscriptas();
        }
        else{
            JOptionPane.showMessageDialog(this, "No ha alumno seleccionado");
        }
            jb_anular.setEnabled(false);
           jb_inscribir.setEnabled(true);
    }//GEN-LAST:event_jrb_no_inscriptasActionPerformed

    private void jb_anularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_anularActionPerformed
        
    }//GEN-LAST:event_jb_anularActionPerformed

    private void jb_inscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_inscribirActionPerformed
         Alumno alu=(Alumno) jcb_alumnos.getSelectedItem();
         int filaSleccionada=jt_materia.getSelectedRow();
         
         if(filaSleccionada!=-1){
             Alumno a=(Alumno)jcb_alumnos.getSelectedItem();
             if (alu!=null){
             int idMateria=(Integer) modelo.getValueAt(filaSleccionada,0);
             String nombreMateria=(String)modelo.getValueAt(filaSleccionada,1);
             
             Materia m=new Materia(idMateria, nombreMateria);
             Inscripcion inscripcion=new Inscripcion (a,m);
             ins_data.inscribir_alumno(inscripcion);
             this.borrarFilasTabla();
             
             }
             else{
                JOptionPane.showMessageDialog(this, "No ha alumno seleccionado");

             }
         }
         this.repaint();
//         jrb_no_inscriptas.setSelected(false);
//         jrb_inscriptas.setSelected(false);
//         this.cargarNoInscriptas();
    }//GEN-LAST:event_jb_inscribirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_anular;
    private javax.swing.JButton jb_inscribir;
    private javax.swing.JButton jb_salir;
    private javax.swing.JComboBox<Alumno> jcb_alumnos;
    private javax.swing.JRadioButton jrb_inscriptas;
    private javax.swing.JRadioButton jrb_no_inscriptas;
    private javax.swing.JTable jt_materia;
    // End of variables declaration//GEN-END:variables

}
