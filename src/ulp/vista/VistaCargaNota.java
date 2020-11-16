/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulp.vista;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
 * @author Genaro
 */
public class VistaCargaNota extends javax.swing.JInternalFrame {

    private Conexion conexion;
    private MateriaData materia_Data;
    private AlumnoData alumno_data;
    private InscripcionesData inscripcion_data;
    private DefaultTableModel modelo;       //Para la tabla

    /**
     * Creates new form FormularioCargaNotas
     */
    public VistaCargaNota() {
        initComponents();
        conexion = new Conexion();
        materia_Data = new MateriaData(conexion);
        alumno_data = new AlumnoData(conexion);
        inscripcion_data = new InscripcionesData(conexion);
        modelo = new DefaultTableModel();     //Instancio un nuevo modelo
        

        this.jchb_porId.setSelected(true);
        this.jl_ingreseDni.setVisible(false);
        this.jl_IngreseId.setLocation(new Point(20, 3));
        this.jl_IngreseId.setLocation(new Point(20, 3));
        this.jl_ingreseDni.setLocation(new Point(20, 3));
        this.jtf_ingreseValor.setLocation(new Point(20, 3));
        jcb_alumno.setEnabled(false);
        jcb_materias.setEnabled(false);
        jButton_guardar.setEnabled(false);
        jFormattedTextField_nota.setEditable(false);
        jl_nombreAlumno.setVisible(true);

        armaCabeceraTabla();
        borraFilasTabla();
       

    }

    public void armaCabeceraTabla() {

        //Titulos de Columnas
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("Id Inscripcion");
        columnas.add("Id Materia");
        columnas.add("Nombre Materia");
        columnas.add("Nota");

        for (Object it : columnas) {

            modelo.addColumn(it);
        }
        jTable_cargaNotas.setModel(modelo);
    }

    public void borraFilasTabla() {

        int a = jTable_cargaNotas.getRowCount() - 1;

        for (int i = a; i >= 0; i--) {

            modelo.removeRow(i);
        }
    }

//  
    public void cargarMateriasxAlumno() {

        Alumno alumno= null;
        int numero = 0;
        
        alumno= alumno_data.buscar_alumno(Integer.parseInt(jl_idAlumno.getText()));
        
        System.out.println(alumno);

        if (alumno != null) {
            jcb_materias.setEnabled(true);
            jcb_materias.removeAllItems();
            
               try {
                    numero = Integer.parseInt(jtf_ingreseValor.getText());
                } catch (NumberFormatException e) {
                    System.out.println("No se puede convertir a numero");
                }

                List<Materia> materias = inscripcion_data.materias_alumno(numero);
                materias.forEach((item) -> {
                    jcb_materias.addItem(item);
                 });
            
        } 
    }
    public void cargarAlumnos() {

        jcb_alumno.removeAllItems();
//        jcb_alumno.setSelectedItem(new Object[]{" "});
        List<Alumno> alumnos = alumno_data.ver_alumnos_activos();
        alumnos.forEach((item) -> {
            jcb_alumno.addItem(item);
        });
////        jcb_alumno.setSelectedItem(null);
    }
    
    public void mostrarInscripciones(Alumno elAlumno){
        if(elAlumno !=null){
        Inscripcion laInscripcion;
        Materia seleccionada;
        seleccionada = (Materia)jcb_materias.getSelectedItem();
        //laInscripcion = (Inscripcion) inscripcion_data.inscripcionesAlumno(elAlumno);  
        System.out.println("llego");
        ArrayList listaRegistros = (ArrayList)inscripcion_data.inscripcionesAlumno(elAlumno);
        for (Iterator it = listaRegistros.iterator(); it.hasNext();) {
            Inscripcion i = (Inscripcion) it.next();
            modelo.addRow(new Object[]{i.getId_inscripcion(), i.getMateria().getId_materia(), i.getMateria().getNombre_materia(), i.getCalificacion()});
            System.out.println("entro");
        }
//        cargarMateriasxAlumno();
        jcb_materias.requestFocus();
        
        }
        
            
            
        
//        if (jcb_materias.getItemCount() > 0) {
//
//            jcb_materias.setSelectedIndex(0);
//
//            seleccionada = (Materia) jcb_materias.getSelectedItem();
//
//            laInscripcion = inscripcion_data.inscripcion_alumno_materia(elAlumno, seleccionada);
//            if (laInscripcion != null) {
//
//                System.out.println(laInscripcion);
//                jl_numeroInscr.setText(String.valueOf(laInscripcion.getId_inscripcion()));
//                modelo.addRow(new Object[]{laInscripcion.getId_inscripcion(), seleccionada.getId_materia(), seleccionada.getNombre_materia(), laInscripcion.getCalificacion()});
//                jFormattedTextField_nota.setEditable(true);
//                jFormattedTextField_nota.requestFocus();
//                escribirEstados("Ingrese la nota para cargar o actualizar");
//            }
//        } else {
//            escribirEstados("No hay inscripciones para mostrar");
//        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jl_titulo = new javax.swing.JLabel();
        jButton_salir = new javax.swing.JButton();
        jButton_guardar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_cargaNotas = new javax.swing.JTable();
        javax.swing.JButton jButton_limpiar = new javax.swing.JButton();
        jl_estadosYMensajes = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jl_numeroInscr = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jl_buscarAlumno = new javax.swing.JLabel();
        jlIngreseApellido = new javax.swing.JLabel();
        jl_IngreseId = new javax.swing.JLabel();
        jl_ingreseDni = new javax.swing.JLabel();
        jl_PorCombobox = new javax.swing.JLabel();
        jtf_ingreseValor = new javax.swing.JTextField();
        jcb_alumno = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jchb_porId = new javax.swing.JCheckBox();
        jchb_porDni = new javax.swing.JCheckBox();
        jchb_porCombo = new javax.swing.JCheckBox();
        jButton_buscar = new javax.swing.JButton();
        jL_buscarMateria = new javax.swing.JLabel();
        jcb_materias = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel_nota = new javax.swing.JLabel();
        jFormattedTextField_nota = new javax.swing.JFormattedTextField();
        jl_nombreAlumno = new javax.swing.JLabel();
        jl_idAlumno = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setResizable(false);
        setTitle("Carga de Notas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_titulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jl_titulo.setText("Carga de Notas de Alumno");
        getContentPane().add(jl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 23, -1, -1));

        jButton_salir.setText("Salir");
        jButton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_salirActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 611, -1, -1));

        jButton_guardar.setText("Guardar Nota");
        jButton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 611, -1, -1));

        jTable_cargaNotas.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTable_cargaNotas.setAutoscrolls(false);
        jTable_cargaNotas.setEnabled(false);
        jTable_cargaNotas.setRowHeight(30);
        jScrollPane2.setViewportView(jTable_cargaNotas);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 428, 592, 176));

        jButton_limpiar.setText("Limpiar");
        jButton_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 611, -1, -1));

        jl_estadosYMensajes.setText("Estados y mensajes");
        getContentPane().add(jl_estadosYMensajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 644, 419, -1));

        jLabel3.setText("Estado:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 644, -1, -1));

        jl_numeroInscr.setText("Numero");
        getContentPane().add(jl_numeroInscr, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 404, 47, -1));

        jLabel1.setText("Id Inscripcion:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 404, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jl_buscarAlumno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jl_buscarAlumno.setText("Buscar Alumno");

        jlIngreseApellido.setLabelFor(jtf_ingreseValor);
        jlIngreseApellido.setText("Ingrese ");

        jl_IngreseId.setLabelFor(jtf_ingreseValor);
        jl_IngreseId.setText("ID:");

        jl_ingreseDni.setLabelFor(jtf_ingreseValor);
        jl_ingreseDni.setText(" DNI:");

        jl_PorCombobox.setLabelFor(jtf_ingreseValor);
        jl_PorCombobox.setText("Por ComboBox");

        jtf_ingreseValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtf_ingreseValor.setNextFocusableComponent(jcb_materias);
        jtf_ingreseValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtf_ingreseValorFocusLost(evt);
            }
        });
        jtf_ingreseValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_ingreseValorActionPerformed(evt);
            }
        });

        jcb_alumno.setNextFocusableComponent(jButton_buscar);
        jcb_alumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcb_alumnoItemStateChanged(evt);
            }
        });
        jcb_alumno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jcb_alumnoFocusLost(evt);
            }
        });
        jcb_alumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcb_alumnoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jcb_alumnoMouseEntered(evt);
            }
        });
        jcb_alumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_alumnoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jchb_porId);
        jchb_porId.setText("Por Id");
        jchb_porId.setFocusable(false);
        jchb_porId.setNextFocusableComponent(jtf_ingreseValor);
        jchb_porId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchb_porIdActionPerformed(evt);
            }
        });

        buttonGroup1.add(jchb_porDni);
        jchb_porDni.setText("Por Dni");
        jchb_porDni.setFocusable(false);
        jchb_porDni.setNextFocusableComponent(jtf_ingreseValor);
        jchb_porDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchb_porDniActionPerformed(evt);
            }
        });

        buttonGroup1.add(jchb_porCombo);
        jchb_porCombo.setText("Por Combo");
        jchb_porCombo.setFocusable(false);
        jchb_porCombo.setNextFocusableComponent(jchb_porCombo);
        jchb_porCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchb_porComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jchb_porId)
                    .addComponent(jchb_porDni)
                    .addComponent(jchb_porCombo))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jchb_porId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jchb_porDni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jchb_porCombo)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jButton_buscar.setText("Buscar");
        jButton_buscar.setNextFocusableComponent(jFormattedTextField_nota);
        jButton_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_ingreseValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jlIngreseApellido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jl_IngreseId)
                                        .addGap(0, 0, 0)
                                        .addComponent(jl_ingreseDni))
                                    .addComponent(jl_buscarAlumno))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jl_PorCombobox)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jcb_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jl_buscarAlumno)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_IngreseId)
                            .addComponent(jl_ingreseDni)
                            .addComponent(jlIngreseApellido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_ingreseValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addComponent(jl_PorCombobox)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcb_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 59, 475, -1));

        jL_buscarMateria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jL_buscarMateria.setText("Elegir Materia");
        getContentPane().add(jL_buscarMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 381, -1, -1));

        jcb_materias.setNextFocusableComponent(jButton_buscar);
        jcb_materias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcb_materiasItemStateChanged(evt);
            }
        });
        jcb_materias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_materiasActionPerformed(evt);
            }
        });
        getContentPane().add(jcb_materias, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 379, 122, -1));

        jLabel_nota.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_nota.setText("Nota:");

        jFormattedTextField_nota.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##,##"))));
        jFormattedTextField_nota.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jFormattedTextField_nota.setNextFocusableComponent(jButton_guardar);
        jFormattedTextField_nota.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField_notaFocusLost(evt);
            }
        });
        jFormattedTextField_nota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField_notaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedTextField_nota)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_nota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFormattedTextField_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 220, -1, -1));

        jl_nombreAlumno.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jl_nombreAlumno.setText("Nombre");
        jl_nombreAlumno.setToolTipText("");
        jl_nombreAlumno.setFocusable(false);
        jl_nombreAlumno.setRequestFocusEnabled(false);
        getContentPane().add(jl_nombreAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 332, -1, -1));

        jl_idAlumno.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jl_idAlumno.setText("ID");
        getContentPane().add(jl_idAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 332, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jchb_porDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchb_porDniActionPerformed
        // TODO add your handling code here:
        this.jl_IngreseId.setVisible(false);
        this.jl_ingreseDni.setVisible(true);
        jtf_ingreseValor.setEnabled(true);
        jcb_alumno.setEnabled(false);
        this.escribirEstados("Ha elegido buscar por Dni, ingrese un numero valido");

    }//GEN-LAST:event_jchb_porDniActionPerformed

    private void jButton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_salirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton_salirActionPerformed

    private void jchb_porIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchb_porIdActionPerformed
        // TODO add your handling code here:
        this.jl_ingreseDni.setVisible(false);
        this.jl_IngreseId.setVisible(true);
        jtf_ingreseValor.setEnabled(true);
        jcb_alumno.setEnabled(false);
        this.escribirEstados("Ha elegido buscar por Id, ingrese un numero valido");
        limpiar();

    }//GEN-LAST:event_jchb_porIdActionPerformed

    private void jcb_materiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_materiasActionPerformed
        // TODO add your handling code here:
        Alumno alumno= null;
        try{
            alumno = ((Alumno) alumno_data.buscar_alumno(Integer.parseInt(jl_idAlumno.getText())) );
          } catch (NumberFormatException e){
              System.out.println("No se puede convertir a numero");
          }
        
        mostrarInscripciones(alumno);
    }//GEN-LAST:event_jcb_materiasActionPerformed

    private void jButton_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_buscarActionPerformed
        // TODO add your handling code here:

        if (true) {
            borraFilasTabla();      //Borra los datos de la tabla
            Alumno elAlumno = null;

            if (jchb_porId.isSelected()) {
                try {
                    elAlumno = alumno_data.buscar_alumno(Integer.parseInt(jtf_ingreseValor.getText()));
                } catch (NumberFormatException e) {
                    System.out.println("No se puede convertir a numero");
                }

            }
            if (jchb_porDni.isSelected()) {
                elAlumno = alumno_data.buscar_alumno(jtf_ingreseValor.getText());

            }
            if (jchb_porCombo.isSelected()) {
                elAlumno = (Alumno) jcb_alumno.getSelectedItem();

            }
            if (elAlumno != null) {
                jl_nombreAlumno.setText(elAlumno.getApellido() + " " + elAlumno.getNombre());
                jl_idAlumno.setText(String.valueOf(elAlumno.getId_alumno()));
                jl_nombreAlumno.setVisible(true);
                mostrarInscripciones(elAlumno);
            } else {
                escribirEstados("No existe ese alumno");
            }
        }
    }//GEN-LAST:event_jButton_buscarActionPerformed

    private void jButton_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_limpiarActionPerformed
        // TODO add your handling code here:
        Alumno alumno=null;
        limpiar();
    }//GEN-LAST:event_jButton_limpiarActionPerformed

    private void jButton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardarActionPerformed
        // TODO add your handling code here:
        //              
        if(!jl_numeroInscr.getText().equals(" ")){
            try{
            inscripcion_data.registrar_nota(Integer.parseInt(jl_numeroInscr.getText()), Double.parseDouble(jFormattedTextField_nota.getText()));
          } catch (NumberFormatException e){
              System.out.println("No se puede convertir a numero");
          }
            
            
            System.out.println("ingreso la nota");
            System.out.println(Double.parseDouble(jFormattedTextField_nota.getText()));
            
            modelo.setValueAt(jFormattedTextField_nota.getText(), 0, 3);
            JOptionPane.showMessageDialog(this, "No se pudo guardar la nota");
        }
    }//GEN-LAST:event_jButton_guardarActionPerformed

    private void jtf_ingreseValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_ingreseValorActionPerformed
        // TODO add your handling code here:
//        
    }//GEN-LAST:event_jtf_ingreseValorActionPerformed

    private void jcb_materiasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb_materiasItemStateChanged
        // TODO add your handling code here:
  
    }//GEN-LAST:event_jcb_materiasItemStateChanged

    private void jFormattedTextField_notaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField_notaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField_notaActionPerformed

    private void jtf_ingreseValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtf_ingreseValorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_ingreseValorFocusLost

    private void jFormattedTextField_notaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField_notaFocusLost
        // TODO add your handling code here:
        jButton_guardar.setEnabled(true);
    }//GEN-LAST:event_jFormattedTextField_notaFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jchb_porComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchb_porComboActionPerformed
        // TODO add your handling code here:
        this.jl_ingreseDni.setVisible(false);
        this.jl_IngreseId.setVisible(false);
        this.jtf_ingreseValor.setEnabled(false);
        jcb_alumno.setEnabled(true);
        escribirEstados("Ha elegido buscar por ComboBox, Eliga un alumna de la lista desplegable");
        jl_PorCombobox.setVisible(true);
        this.borraFilasTabla();
        jtf_ingreseValor.setText(" ");
        jtf_ingreseValor.setEnabled(false);
        jFormattedTextField_nota.setText(" ");
        cargarAlumnos();
        jcb_alumno.requestFocus();
    }//GEN-LAST:event_jchb_porComboActionPerformed

    private void jcb_alumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_alumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_alumnoActionPerformed

    private void jcb_alumnoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcb_alumnoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_alumnoMouseEntered

    private void jcb_alumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcb_alumnoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_alumnoMouseClicked

    private void jcb_alumnoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jcb_alumnoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_alumnoFocusLost

    private void jcb_alumnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb_alumnoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_alumnoItemStateChanged

    public void limpiar() {
        
        jtf_ingreseValor.setText("");
        jtf_ingreseValor.setText("");
        jFormattedTextField_nota.setText("");
        jcb_materias.setSelectedItem(null);
        jcb_alumno.setSelectedItem(null);
        jcb_materias.setEnabled(false);
        jl_idAlumno.setText("");
        jl_nombreAlumno.setText("");
        borraFilasTabla();
               
        hacerFoco();
    }

    public void escribirEstados(String estado) {
        jl_estadosYMensajes.setText(estado);
//        int delay = 5000; // miliseg
//        ActionListener taskPerformer = (ActionEvent evt) -> {
//            jl_estadosYMensajes.setVisible(false);
//        };
//
//
//        Timer timer = new Timer (delay,taskPerformer );
//        timer.setRepeats(false);
//        timer.start();
//        

    }

    public void hacerFoco() {
        jtf_ingreseValor.requestFocus();
    }

//    public boolean chekaDatosIngresados(){
//        boolean esValido = false;
//        if((jtf_ingreseValor.getText().isEmpty()) && ((jcb_materias.getSelectedObjects())==null)){
////          if(true){
//            
//            esValido = false;
//                    
//           if (jtf_ingreseValor.getText().isEmpty()){
//                escribirEstados("Falta ingresar el argumento para la busqueda. Ingrese un id o dni de acuerdo a su seleccion");
//                jtf_ingreseValor.requestFocus();
//           } 
//           else if (jcb_materias.getSelectedObjects() == null){
//                escribirEstados("Eliga una materia. ");
//                jcb_materias.requestFocus();
//           } else {
//               escribirEstados("Eliga una materia y un alumno. ");
//                jtf_ingreseValor.requestFocus();
//               
//           }
//           } 
//        else 
//        {
//           esValido=true;
//        }
//        
//        
//        return esValido;
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_guardar;
    private javax.swing.JButton jButton_salir;
    private javax.swing.JFormattedTextField jFormattedTextField_nota;
    private javax.swing.JLabel jL_buscarMateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_nota;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public javax.swing.JTable jTable_cargaNotas;
    private javax.swing.JComboBox<Alumno> jcb_alumno;
    private javax.swing.JComboBox<Materia> jcb_materias;
    private javax.swing.JCheckBox jchb_porCombo;
    private javax.swing.JCheckBox jchb_porDni;
    private javax.swing.JCheckBox jchb_porId;
    private javax.swing.JLabel jlIngreseApellido;
    private javax.swing.JLabel jl_IngreseId;
    private javax.swing.JLabel jl_PorCombobox;
    private javax.swing.JLabel jl_buscarAlumno;
    private javax.swing.JLabel jl_estadosYMensajes;
    private javax.swing.JLabel jl_idAlumno;
    private javax.swing.JLabel jl_ingreseDni;
    private javax.swing.JLabel jl_nombreAlumno;
    private javax.swing.JLabel jl_numeroInscr;
    private javax.swing.JLabel jl_titulo;
    private javax.swing.JTextField jtf_ingreseValor;
    // End of variables declaration//GEN-END:variables
}
