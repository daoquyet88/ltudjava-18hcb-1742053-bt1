/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class DSSinhVienWindow extends javax.swing.JPanel {

      String path;
    /**
     * Creates new form ThoiKhoaBieuWindow
     */
    public DSSinhVienWindow() throws IOException {
        initComponents();
        load();
    }
    public void load() throws IOException{
        String file="C:\\Users\\Admin\\Desktop\\File CSV\\17hcb.csv";
        path=file;
        File f=new File(file);
        String nameFile=f.getName();
        lbThongBao.setText("Thông Tin Danh Sách Sinh Viên Lớp : "+nameFile);
        docFile(file);
        String lh="C:\\Users\\Admin\\Desktop\\File CSV\\dslop.csv";
        docFileLH(lh);
    }
     public void docFileLH(String p) throws FileNotFoundException, IOException{
       
        FileReader fr = new FileReader(p);
        BufferedReader br = new BufferedReader(fr);        
        String []dataSV;
        String line = br.readLine();      
          
        line = br.readLine();
          while(line != null){
              dataSV=line.split(",");
              cbLop.addItem(dataSV[0]);
              line =br.readLine();
          }
        br.close();
        fr.close();
        
    }
    public void docFile(String p) throws FileNotFoundException, IOException{
        DefaultTableModel dtm=new DefaultTableModel();       
         
        FileReader fr = new FileReader(p);
        BufferedReader br = new BufferedReader(fr);
        String [] NameSV;
        String []dataSV;
        String line = br.readLine();
        NameSV=line.split(",");
        for(int i=0;i<NameSV.length;i++){
            dtm.addColumn(String.valueOf(NameSV[i]));
        }         
        line = br.readLine();
          while(line != null){
              dataSV=line.split(",");
               dtm.addRow(new Object[]{dataSV[0],dataSV[1],dataSV[2],dataSV[3],dataSV[4]});
              line =br.readLine();
          }
        br.close();
        fr.close();
         this.tbSinhVien.setModel(dtm);
        this.tbSinhVien.repaint();
        this.tbSinhVien.revalidate();
    }
     public void ghiFile(String p) throws FileNotFoundException, IOException{
        try{
          File file=new File(p);
          FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
          BufferedWriter bw = new BufferedWriter(fw);
          int stt=tbSinhVien.getRowCount();
          stt++;
          String mssv=txtMSSV.getText();
          String hoTen=txtHoTen.getText();
          String gioiTinh=txtGioiTinh.getText();
          String cmnd=txtCMND.getText(); 
          bw.newLine();
          bw.write(stt+","+mssv+","+hoTen+","+gioiTinh+","+cmnd);             
          bw.close();
         JOptionPane.showMessageDialog(this,"Thêm Sinh Viên Thành Công");                 
         }catch(Exception e){
          JOptionPane.showMessageDialog(this,"Thêm Thất Bại"+e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbSinhVien = new javax.swing.JTable();
        lbThongBao = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbPath = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMSSV = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtGioiTinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        btnThemSV = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbLop = new javax.swing.JComboBox();

        setLayout(null);

        tbSinhVien.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbSinhVien);

        add(jScrollPane1);
        jScrollPane1.setBounds(359, 143, 603, 291);

        lbThongBao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbThongBao.setText("Thông Tin Danh Sách Sinh Viên ");
        add(lbThongBao);
        lbThongBao.setBounds(395, 43, 288, 22);

        jButton1.setText("Import Danh Sách");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(12, 13, 147, 25);

        lbPath.setText("Đường Đẫn");
        add(lbPath);
        lbPath.setBounds(221, 17, 65, 16);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Thêm Sinh Viên Vào Lớp Học ");
        add(jLabel1);
        jLabel1.setBounds(60, 56, 237, 20);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("MSSV");

        jLabel3.setText("Họ Tên ");

        jLabel4.setText("Giới Tính");

        jLabel5.setText("CMND");

        btnThemSV.setText("OK");
        btnThemSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSVActionPerformed(evt);
            }
        });

        jButton3.setText("Reset");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(54, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnThemSV, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        add(jPanel1);
        jPanel1.setBounds(12, 104, 329, 330);

        jLabel6.setText("Chọn Lớp ");
        add(jLabel6);
        jLabel6.setBounds(376, 107, 70, 16);

        cbLop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLopItemStateChanged(evt);
            }
        });
        add(cbLop);
        cbLop.setBounds(490, 100, 196, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        JFileChooser file =new JFileChooser();
       file.setCurrentDirectory(new File(System.getProperty("user.home")));
       
       // FileNameExtensionFilter fileter=new FileNameExtensionFilter("*.images","jpg","png");
        //file.addChoosableFileFilter(fileter);
        int result=file.showSaveDialog(this);
        if(result==JFileChooser.APPROVE_OPTION)
        {
            File selectedFile=file.getSelectedFile();
            path=selectedFile.getAbsolutePath();
            //lbImg.setIcon(ResizeImage(path,null));
            lbPath.setText(path);
        }
        else{
            System.out.println("NO file select");
        }
        
        try {
            // TODO add your handling code here:
            docFile(path);
        } catch (IOException ex) {
            Logger.getLogger(DSSinhVienWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        File f=new File(path);
        String nameFile=f.getName();
        lbThongBao.setText("Thông Tin Danh Sách Sinh Viên Lớp : "+nameFile);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnThemSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSVActionPerformed
         tbSinhVien.getRowCount();
        try {
              ghiFile(path);
          } catch (IOException ex) {
              Logger.getLogger(DSSinhVienWindow.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              docFile(path);
          } catch (IOException ex) {
              Logger.getLogger(DSSinhVienWindow.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_btnThemSVActionPerformed

    private void cbLopItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLopItemStateChanged
       String name=cbLop.getSelectedItem().toString();
        String file="C:\\Users\\Admin\\Desktop\\File CSV\\"+name+".csv";

       // JOptionPane.showMessageDialog(cbLop,file);
        try {
            docFile(file);
        } catch (IOException ex) {
            Logger.getLogger(DangKyWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbLopItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemSV;
    private javax.swing.JComboBox cbLop;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbPath;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JTable tbSinhVien;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMSSV;
    // End of variables declaration//GEN-END:variables
}