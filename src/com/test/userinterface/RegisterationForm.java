/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.userinterface;

import com.test.dao.DepartmentDAO;
import com.test.dao.StudentDAO;
import com.test.daoimpl.DepartmentDAOImp;
import com.test.daoimpl.StudentDAOImp;
import com.test.model.Student;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ahsan
 */
public class RegisterationForm extends javax.swing.JFrame {

    /**
     * Creates new form RegisterationForm
     */
    Object columnNames[] = {"id","Name", "Roll No", "Age", "Fee", "Email", "Gender", "Department", "City", "Address"}; 
    
    DefaultTableModel defaultTableModel = new DefaultTableModel(columnNames, 0);
    StudentDAO dao = null;
    
    
    public RegisterationForm() {
        initComponents();
        fillTable();
        buttonGroup1.add(maleRadio);
        buttonGroup1.add(femaleRadio);
        
        departmentCombo.addItem("          -------SELECT------");
        DepartmentDAO dd = new DepartmentDAOImp();
        List <String> x = dd.getAlldepartments();
        for(String e : x){
            departmentCombo.addItem(e);
        }
        
        cityCombo.addItem("          -------SELECT------");
        x = dao.getAllCities();
        for(String c : x){
            cityCombo.addItem(c);
        }
        this.getContentPane().setBackground( new Color(153,153,255) );
    }
    
    public void fillTable(){
        
       DefaultTableModel dt = (DefaultTableModel) defaultTableModel;
       dt.setRowCount(0);
        
        dao = new StudentDAOImp();
        
        List <Student> stdList = dao.getAllStudent();
        
        //Object row = new Object[defaultTableModel.getColumnCount()];
        
        for(Student std : stdList){
            
           Object[] row = {std.getId(),std.getName(), std.getRollNo(), std.getAge(), std.getFee(), std.getEmail(), std.getGender(), std.getDepartment(),std.getCity(), std.getAddress()};
           defaultTableModel.addRow(row);
        }
        
        studentTable.setModel(defaultTableModel);
        studentTable.getColumnModel().getColumn(0).setWidth(0);
        studentTable.getColumnModel().getColumn(0).setMaxWidth(0);
        studentTable.getColumnModel().getColumn(0).setMinWidth(0);
        studentTable.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    boolean isValidData(){
    
        if(nameField.getText().trim().isEmpty()){
            
            JOptionPane.showMessageDialog(this, "No Name!");
        }
        else if(rollNoField.getText().trim().isEmpty()){
            
            JOptionPane.showMessageDialog(this, "No Roll No!");
        }
        else if(ageSpinner.getValue().toString().trim().isEmpty()){
            
            JOptionPane.showMessageDialog(this, "No Age!");
        }
        else if(feeSpinner.getValue().toString().trim().isEmpty()){
            
            JOptionPane.showMessageDialog(this, "No Fee!");
        }
        else if(emailField.getText().trim().isEmpty()){
            
            JOptionPane.showMessageDialog(this, "No Email!");
        }
        else if(!(maleRadio.isSelected() || femaleRadio.isSelected())){
            
            JOptionPane.showMessageDialog(this, "No Gender!");
        }
        else if(departmentCombo.getSelectedItem().toString().equals(departmentCombo.getItemAt(0))){
            
            JOptionPane.showMessageDialog(this, "No Department!");
        } 
        
        else if(cityCombo.getSelectedItem().toString().equals(cityCombo.getItemAt(0))){
            
            JOptionPane.showMessageDialog(this, "No City!");
        } 
        
        else if(addressArea.getText().trim().isEmpty()){
            
            JOptionPane.showMessageDialog(this, "No Address!");
        }
        else{
            return true;
        }
        return false;
    }

    Student getAllUserData(){
    
        Student s = new Student();
        
        s.setName(nameField.getText().trim());
        s.setRollNo(rollNoField.getText().trim());
        s.setAge(Integer.valueOf(ageSpinner.getValue().toString()));
        s.setFee(Integer.valueOf(feeSpinner.getValue().toString()));
        
        s.setEmail(emailField.getText().trim());
        
        if(maleRadio.isSelected()){
            s.setGender(maleRadio.getText());
        }
        else{
            s.setGender(femaleRadio.getText());
        }
        
        s.setDepartment(departmentCombo.getSelectedItem().toString().trim());
        
        s.setCity(cityCombo.getSelectedItem().toString().trim());
        
        s.setAddress(addressArea.getText().trim());
        
        System.out.println(s.getAge());
        System.out.println(s.getFee());
        System.out.println(s.getDepartment());
        
        return s;
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
        headLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        rollNoLbl = new javax.swing.JLabel();
        ageLbl = new javax.swing.JLabel();
        feeLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        emailLbl = new javax.swing.JLabel();
        addressLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        rollNoField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        addressArea = new javax.swing.JTextArea();
        ageSpinner = new javax.swing.JSpinner();
        feeSpinner = new javax.swing.JSpinner();
        maleRadio = new javax.swing.JRadioButton();
        femaleRadio = new javax.swing.JRadioButton();
        departmentCombo = new javax.swing.JComboBox<>();
        cityCombo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setResizable(false);

        headLbl.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        headLbl.setText("Registeration Form");

        nameLbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        nameLbl.setText("Name");

        rollNoLbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rollNoLbl.setText("Roll No");

        ageLbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ageLbl.setText("Age");

        feeLbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        feeLbl.setText("Fee");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("City");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Gender");

        emailLbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        emailLbl.setText("Email");

        addressLbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        addressLbl.setText("Address");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Department");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameFieldKeyTyped(evt);
            }
        });

        rollNoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollNoFieldActionPerformed(evt);
            }
        });
        rollNoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rollNoFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rollNoFieldKeyTyped(evt);
            }
        });

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        emailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailFieldKeyTyped(evt);
            }
        });

        addressArea.setColumns(10);
        addressArea.setRows(5);
        jScrollPane2.setViewportView(addressArea);

        ageSpinner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ageSpinnerFocusGained(evt);
            }
        });
        ageSpinner.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ageSpinnerKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ageSpinnerKeyTyped(evt);
            }
        });

        feeSpinner.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                feeSpinnerKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                feeSpinnerKeyTyped(evt);
            }
        });

        maleRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        maleRadio.setText("Male");

        femaleRadio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        femaleRadio.setText(" Female");

        studentTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        studentTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        studentTable.setModel(new javax.swing.table.DefaultTableModel(
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
        studentTable.setGridColor(new java.awt.Color(0, 0, 0));
        studentTable.setRowHeight(25);
        studentTable.setSelectionBackground(new java.awt.Color(204, 204, 0));
        studentTable.setSelectionForeground(new java.awt.Color(102, 0, 255));
        studentTable.setShowGrid(true);
        studentTable.getTableHeader().setReorderingAllowed(false);
        studentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentTable);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("UPDATE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        jLabel4.setText("Student Table");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLbl)
                    .addComponent(rollNoLbl)
                    .addComponent(emailLbl)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(ageLbl)
                    .addComponent(feeLbl)
                    .addComponent(jLabel2)
                    .addComponent(addressLbl))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cityCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(departmentCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(maleRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(femaleRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(emailField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(feeSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ageSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rollNoField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97))))
            .addGroup(layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(headLbl)
                .addContainerGap(356, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(headLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nameLbl)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rollNoLbl)
                                    .addComponent(rollNoField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ageLbl)
                                    .addComponent(ageSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(feeLbl)
                                    .addComponent(feeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(emailLbl)
                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(femaleRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(maleRadio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(departmentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cityCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addressLbl)
                        .addGap(50, 50, 50))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        if(isValidData()){
            
            Student s = getAllUserData();
            dao.addStudent(s);
            fillTable();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void studentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTableMouseClicked
        // TODO add your handling code here:
        setValues();
    }//GEN-LAST:event_studentTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int rowIndex = studentTable.getSelectedRow();
        int studentId = 0;
        
        if(rowIndex != -1){
            
            studentId = Integer.parseInt(studentTable.getValueAt(rowIndex, 0).toString());
            dao.deleteStudent(studentId);
            fillTable();
        }
        else {
            
            JOptionPane.showMessageDialog(this, "Please Select Row First!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        int rowIndex = studentTable.getSelectedRow();
        
        if(rowIndex != -1){
            
            Student s = getAllUserData();
            s.setId(Integer.parseInt(studentTable.getValueAt(rowIndex, 0).toString()));
            dao.updateStudent(s);
            fillTable();
        }
        else {
            
            JOptionPane.showMessageDialog(this, "Please Select Row First!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_nameFieldKeyReleased

    private void rollNoFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rollNoFieldKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rollNoFieldKeyReleased

    private void ageSpinnerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ageSpinnerKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ageSpinnerKeyReleased

    private void feeSpinnerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_feeSpinnerKeyReleased
        // TODO add your handling code here:        
    }//GEN-LAST:event_feeSpinnerKeyReleased

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void emailFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailFieldKeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        
        if(!(Character.isLetter(c) || Character.isISOControl(c))){
        
            evt.consume();
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "Only Numbers Letters!");
        }
    }//GEN-LAST:event_emailFieldKeyReleased

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
        rollNoField.requestFocusInWindow();
       
    }//GEN-LAST:event_nameFieldActionPerformed

    private void nameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyTyped
        
        char c = evt.getKeyChar();
        System.out.println(c + "h");
        if(!(Character.isLetter(c) || Character.isISOControl(c))|| Character.isWhitespace(c) || Character.isSpaceChar(c)){
        
            evt.consume();
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "Only Numbers and Letters!");
        }
    }//GEN-LAST:event_nameFieldKeyTyped

    private void rollNoFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rollNoFieldKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        
        if(!(Character.isLetter(c) || Character.isDigit(c)|| Character.isISOControl(c) || Character.isSpaceChar(c))){
        
            evt.consume();
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "Not Allowed!");
        }
    }//GEN-LAST:event_rollNoFieldKeyTyped

    private void ageSpinnerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ageSpinnerKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        
        if(!(Character.isDigit(c) || Character.isISOControl(c) || Character.isSpaceChar(c))){
        
            evt.consume();
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "Only Number!");
        }
        
        System.out.println("asdas");
    }//GEN-LAST:event_ageSpinnerKeyTyped

    private void feeSpinnerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_feeSpinnerKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        
        if(!(Character.isLetter(c) || Character.isISOControl(c) || Character.isSpaceChar(c))){
        
            evt.consume();
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "Only Numbers Letters!");
        }
    }//GEN-LAST:event_feeSpinnerKeyTyped

    private void emailFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailFieldKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        
        if(!(Character.isLetterOrDigit(c) || Character.isISOControl(c))){
        
            evt.consume();
            getToolkit().beep();
            JOptionPane.showMessageDialog(this, "Only Numbers and Letters!");
        }
    }//GEN-LAST:event_emailFieldKeyTyped

    private void ageSpinnerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ageSpinnerFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_ageSpinnerFocusGained

    private void rollNoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollNoFieldActionPerformed
        // TODO add your handling code here:
        ageSpinner.requestFocusInWindow();
    }//GEN-LAST:event_rollNoFieldActionPerformed

    void setValues() {

        int i = 0;
        
        if (studentTable.getSelectedRow() != -1) {
            
            i = studentTable.getSelectedRow();
            nameField.setText(studentTable.getValueAt(i, 1).toString());
            rollNoField.setText(studentTable.getValueAt(i, 2).toString());
            ageSpinner.setValue(Integer.valueOf(studentTable.getValueAt(i, 3).toString()));
            feeSpinner.setValue(Integer.valueOf(studentTable.getValueAt(i, 4).toString()));
            emailField.setText(studentTable.getValueAt(i, 5).toString());

            if (studentTable.getValueAt(i, 6).toString().equalsIgnoreCase("Male")) {
               
                maleRadio.setSelected(true);
            } else {
                femaleRadio.setSelected(true);
                
            }

            departmentCombo.setSelectedItem(studentTable.getValueAt(i, 7).toString());
            cityCombo.setSelectedItem(studentTable.getValueAt(i, 8).toString());
            addressArea.setText(studentTable.getValueAt(i, 9).toString());

        }
    }
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
            java.util.logging.Logger.getLogger(RegisterationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressArea;
    private javax.swing.JLabel addressLbl;
    private javax.swing.JLabel ageLbl;
    private javax.swing.JSpinner ageSpinner;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cityCombo;
    private javax.swing.JComboBox<String> departmentCombo;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JLabel feeLbl;
    private javax.swing.JSpinner feeSpinner;
    private javax.swing.JRadioButton femaleRadio;
    private javax.swing.JLabel headLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton maleRadio;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField rollNoField;
    private javax.swing.JLabel rollNoLbl;
    private javax.swing.JTable studentTable;
    // End of variables declaration//GEN-END:variables
}
