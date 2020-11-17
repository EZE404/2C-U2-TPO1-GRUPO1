/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.vista;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ulp.entidades.Alumno;
import ulp.modelo.AlumnoData;
import ulp.modelo.Conexion;
import ulp.modelo.InscripcionesData;
import ulp.modelo.MateriaData;

/**
 *
 * @author MArio
 */
public class AlumnoAlta extends javax.swing.JInternalFrame {
        Conexion conexion = new Conexion();
        Alumno alumno;
        AlumnoData alumno_data = new AlumnoData(conexion);
        MateriaData materia_data = new MateriaData(conexion);
        InscripcionesData ins_data = new InscripcionesData(conexion);
    /**
     * Creates new form AlumnoAlta
     */
    public void Limpiar(){
        jtf_nombre.setText("");
        jtf_apellido.setText("");
        jtf_dni.setText("");
        cajaFechaN.setDate(null);
        jcb_activo.setSelectedIndex(0);
        Timer timer = new Timer();
        TimerTask task=new TimerTask(){
        int tic=0;
        @Override
        public void run(){
         cajaSalida.setText("");
         setOpaque(false);
        }
    };
    timer.schedule(task,30000,5000000);
        cajaSalida.setText("");
        jtf_id.setText("");
    
    }
    public AlumnoAlta() {
        initComponents();
        conexion = new Conexion();
        alumno=new Alumno();
        alumno_data = new AlumnoData(conexion);
        materia_data = new MateriaData(conexion);
        ins_data = new InscripcionesData(conexion);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void delay(String mensaje, int a, int b ){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                cajaSalida.setText(mensaje);
            }
        };
        timer.schedule(task, a*1000 , b*20000);
    }
     public void limpiarJL(JLabel var, int a, int b ){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                var.setText(" ");
            }
        };
        timer.schedule(task, a*1000 , b*20000);
    }
    public void escribirEstados(){
        System.out.println("HAcer algo");
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cajaFechaN = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jcb_activo = new javax.swing.JComboBox<>();
        jtf_nombre = new javax.swing.JTextField();
        jtf_apellido = new javax.swing.JTextField();
        jtf_dni = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jb_guardar = new javax.swing.JButton();
        cajaSalida = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jb_salir = new javax.swing.JButton();
        jb_limpiar = new javax.swing.JButton();
        jtf_id = new javax.swing.JTextField();
        jl_aviso_nombre = new javax.swing.JLabel();
        jl_aviso_dni = new javax.swing.JLabel();
        jl_aviso_apellido = new javax.swing.JLabel();
        jl_aviso_activo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 3), new java.awt.Dimension(0, 3), new java.awt.Dimension(32767, 3));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 13), new java.awt.Dimension(0, 13), new java.awt.Dimension(32767, 13));

        setForeground(java.awt.Color.white);
        setEnabled(false);
        setOpaque(isOpaque());
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Alta Alumnos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Legajo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Nombre");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Apellido");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("DNI");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Fecha N.");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        cajaFechaN.setForeground(new java.awt.Color(60, 63, 65));
        cajaFechaN.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cajaFechaN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cajaFechaNKeyTyped(evt);
            }
        });
        getContentPane().add(cajaFechaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 110, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Activo");
        jLabel10.setToolTipText("");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 60, -1));

        jcb_activo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jcb_activo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "    ", "Si", "No" }));
        jcb_activo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_activoActionPerformed(evt);
            }
        });
        jcb_activo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcb_activoKeyTyped(evt);
            }
        });
        getContentPane().add(jcb_activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 65, 20));

        jtf_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nombreActionPerformed(evt);
            }
        });
        jtf_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_nombreKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 110, -1));

        jtf_apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_apellidoKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 110, -1));

        jtf_dni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_dniActionPerformed(evt);
            }
        });
        jtf_dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_dniKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 110, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 20, 48));

        jb_guardar.setText("Guardar");
        jb_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 150, 36));

        cajaSalida.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        cajaSalida.setForeground(new java.awt.Color(153, 0, 0));
        getContentPane().add(cajaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 342, 20));

        jLabel2.setText("Estado:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jb_salir.setText("Salir");
        jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salirActionPerformed(evt);
            }
        });
        getContentPane().add(jb_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, -1, -1));

        jb_limpiar.setText("Limpiar");
        jb_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(jb_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, -1, -1));

        jtf_id.setEnabled(false);
        jtf_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_idActionPerformed(evt);
            }
        });
        jtf_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf_idKeyTyped(evt);
            }
        });
        getContentPane().add(jtf_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 58, -1));

        jl_aviso_nombre.setForeground(new java.awt.Color(204, 0, 0));
        jl_aviso_nombre.setText(" ");
        jl_aviso_nombre.setToolTipText("");
        jl_aviso_nombre.setEnabled(false);
        jl_aviso_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jl_aviso_nombreKeyTyped(evt);
            }
        });
        getContentPane().add(jl_aviso_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 131, 110, -1));

        jl_aviso_dni.setForeground(new java.awt.Color(204, 0, 0));
        jl_aviso_dni.setText(" ");
        getContentPane().add(jl_aviso_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 229, 100, -1));

        jl_aviso_apellido.setForeground(new java.awt.Color(204, 0, 0));
        jl_aviso_apellido.setText(" ");
        getContentPane().add(jl_aviso_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 177, 120, -1));

        jl_aviso_activo.setText(" ");
        getContentPane().add(jl_aviso_activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 334, 71, -1));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 20, 48));
        getContentPane().add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 50, 40));
        getContentPane().add(filler2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 70, 20));

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcb_activoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_activoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_activoActionPerformed

    private void jb_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_guardarActionPerformed
        int cont=0;
        if("".equals(jtf_nombre.getText())){
            cont++;
            jtf_nombre.requestFocus();
        }
        if("".equals(jtf_apellido.getText())){
            cont++;
            jtf_apellido.requestFocus();
        }
        if("".equals(jtf_dni.getText())){
            cont++;
            jtf_dni.requestFocus();
        }
        if(cajaFechaN.getCalendar()==null){
            cont++;
            cajaFechaN.requestFocus();
        }
        if(cont==0&&(JOptionPane.YES_NO_OPTION==JOptionPane.showConfirmDialog(this, "Esta seguro que desea guardar", "Guaradar Alumno", JOptionPane.YES_NO_OPTION))){
        
            alumno=new Alumno();
            LocalDate hoy;
            hoy=LocalDateTime.ofInstant(cajaFechaN.getDate().toInstant(), ZoneId.systemDefault()).toLocalDate();
            alumno.setNombre(jtf_nombre.getText());
            alumno.setApellido(jtf_apellido.getText());
            alumno.setDni(jtf_dni.getText());
            alumno.setFecha_n(hoy);


            if ( jcb_activo.getSelectedItem().toString().equalsIgnoreCase("si")){
                    alumno.setActivo(true);
            }
            else{
                    alumno.setActivo(false);
            }
            alumno_data.guardar_alumno(alumno);
            jtf_id.setText(Integer.toString(alumno.getId_alumno()));
            System.out.println(alumno.getId_alumno());
            if(alumno.getId_alumno()==0){
                this.Limpiar();
                System.out.println("Ya existe el alumno");
                cajaSalida.setText("Ya existe el alumno");
                this.delay(" ", 3, 5);
            }else{
            cajaSalida.setText("Alumno guardado con Exito");
            this.delay(" ", 3, 5);
            this.Limpiar();
            }
        }
        else{
            cajaSalida.setText("Llene todos los campos Nombre, Apellido, DNI y FechaN ");
            //this.delay("Llene todos los campos Nombre, Apellido, DNI y FechaN ");
            this.delay(" ", 3, 5);
            //JOptionPane.showMessageDialog(this, "Deben estar los ca");
            
        }
       
        
    }//GEN-LAST:event_jb_guardarActionPerformed


    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jb_salirActionPerformed

    private void jb_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_limpiarActionPerformed
        this.Limpiar();
    }//GEN-LAST:event_jb_limpiarActionPerformed

    private void jtf_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_idActionPerformed

    private void jtf_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_nombreKeyTyped
          char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
            
        } else {
            evt.consume();
            jl_aviso_nombre.setText("Solo letras");
         }
 //////////////////////////////////////////////
       if(jtf_nombre.getText().trim().isEmpty()){
            jl_aviso_nombre.setText("Complete");
        }
///////////////////////////////////////        
        if(Character.isSpaceChar(c)||jtf_nombre.getText().isEmpty()){
            jl_aviso_nombre.setText("Complete");
        }
        this.limpiarJL(jl_aviso_nombre, 3, 2);
    }//GEN-LAST:event_jtf_nombreKeyTyped

    private void jtf_dniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_dniKeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();  // ignorar el evento de teclado
            jl_aviso_dni.setText("Solo numeros");
        }
        if(!(jtf_dni.getText().length()<8)){
            evt.consume();
            jl_aviso_dni.setText("Solo 8 digitos");
        }
        
       
        this.limpiarJL(jl_aviso_dni, 3, 2);
       
    }//GEN-LAST:event_jtf_dniKeyTyped

    private void jtf_apellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_apellidoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c) == false) {
        } else {
            evt.consume();
            jl_aviso_apellido.setText("Solo letras");
        }
       this.delay(" ", 3, 3);
       this.limpiarJL(jl_aviso_apellido, 3, 2);

    }//GEN-LAST:event_jtf_apellidoKeyTyped

    private void jtf_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_idKeyTyped
        char caracter = evt.getKeyChar();
// Verificar si la tecla pulsada no es un digito
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
            evt.consume();  // ignorar el evento de teclado
        }

    }//GEN-LAST:event_jtf_idKeyTyped

    private void jcb_activoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_activoKeyTyped
         if(jcb_activo.getSelectedIndex()==0){
            jl_aviso_activo.setText("Seleccione opcion");
        }
        this.limpiarJL(jl_aviso_nombre, 3, 2);
    }//GEN-LAST:event_jcb_activoKeyTyped

    private void jtf_dniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_dniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_dniActionPerformed

    private void jtf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nombreActionPerformed
        
    }//GEN-LAST:event_jtf_nombreActionPerformed

    private void jl_aviso_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jl_aviso_nombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jl_aviso_nombreKeyTyped

    private void cajaFechaNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cajaFechaNKeyTyped
  

    }//GEN-LAST:event_cajaFechaNKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup buttonGroup1;
    public com.toedter.calendar.JDateChooser cajaFechaN;
    public javax.swing.JLabel cajaSalida;
    public javax.swing.Box.Filler filler1;
    public javax.swing.Box.Filler filler2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JSeparator jSeparator2;
    public javax.swing.JSeparator jSeparator3;
    public javax.swing.JButton jb_guardar;
    public javax.swing.JButton jb_limpiar;
    public javax.swing.JButton jb_salir;
    public javax.swing.JComboBox<String> jcb_activo;
    public javax.swing.JLabel jl_aviso_activo;
    public javax.swing.JLabel jl_aviso_apellido;
    public javax.swing.JLabel jl_aviso_dni;
    public javax.swing.JLabel jl_aviso_nombre;
    public javax.swing.JTextField jtf_apellido;
    public javax.swing.JTextField jtf_dni;
    public javax.swing.JTextField jtf_id;
    public javax.swing.JTextField jtf_nombre;
    // End of variables declaration//GEN-END:variables
}
