/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
        String lh = "D:\\File CSV\\dslop.csv";
        try {
            
            docFileLH(lh);
        } catch (Exception e) {
        }
        //docFileLH(lh);
    }
     public void docFileLH(String p) throws FileNotFoundException, IOException{
        cbLop.removeAllItems();
        FileReader fr=new FileReader(p);
        BufferedReader br=new  BufferedReader(fr);
         String line = br.readLine();
         line = br.readLine();
         while (line != null) {
             cbLop.addItem(line);
             line = br.readLine();
         }
         br.close();
         fr.close();
    }
    public void docFile(String p) throws FileNotFoundException, IOException{
        DefaultTableModel dtm = new DefaultTableModel();

        File fileDir = new File(p);

        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileDir), "UTF8"));
        String[] NameSV;
        String[] dataSV;
        String line = br.readLine();
        NameSV = line.split(",");
        for (int i = 0; i < NameSV.length; i++) {
            dtm.addColumn(String.valueOf(NameSV[i]));
        }
        line = br.readLine();
        while (line != null) {
            dataSV = line.split(",");
            dtm.addRow(new Object[]{dataSV[0], dataSV[1], dataSV[2], dataSV[3], dataSV[4]});
            line = br.readLine();
        }
        br.close();
        //fr.close();
        this.tbSinhVien.setModel(dtm);
        this.tbSinhVien.repaint();
        this.tbSinhVien.revalidate();
    }
    public void ghiFileLopHoc(String p,String tenLop){
        try {
           File fileDir = new File(p);
            if (!fileDir.exists()) {
                fileDir.createNewFile();
                BufferedWriter bx = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(fileDir), "UTF8"));
                bx.write("Tên Lớp");
                bx.newLine();
                bx.close();
            }                    // ghi vao cuoi noi dung 
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(fileDir.getAbsoluteFile(), true), "UTF8"));

            bw.write(tenLop);
            bw.newLine();
            bw.close();
        } catch (Exception e) {
        }

    }
     public void ghiFile(String p) throws FileNotFoundException, IOException{
         
         if(txtHoTen.getText().equals("")||txtCMND.getText().equals("")||txtMSSV.getText().equals("")){
             JOptionPane.showMessageDialog(cbLop,"Nhập Đầy Đủ Thông Tin");
         }else{
             
        try{
          File fileDir = new File(p);
			
		          BufferedWriter bw = new BufferedWriter(
		   new OutputStreamWriter(
                      new FileOutputStream(fileDir.getAbsoluteFile(),true), "UTF8"));
          int stt=tbSinhVien.getRowCount();
          stt++;
          String mssv=txtMSSV.getText();
          String hoTen=txtHoTen.getText();
          String gioiTinh="";
          if(rdNam.isEnabled()){
              gioiTinh="Nam";
          }
          else{
              gioiTinh="Nư";
          }
          
          String cmnd=txtCMND.getText();           
          bw.write(stt+","+mssv+","+hoTen+","+gioiTinh+","+cmnd);   
          bw.newLine();
          bw.close();
         JOptionPane.showMessageDialog(this,"Thêm Sinh Viên Thành Công");                 
         }catch(Exception e){
          JOptionPane.showMessageDialog(this,"Thêm Thất Bại"+e);
      }
        }
    }
     public static void copyFile(Path source, Path destination) throws IOException {
		Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
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
        tbSinhVien = new javax.swing.JTable();
        lbThongBao = new javax.swing.JLabel();
        btnLine = new javax.swing.JButton();
        lbPath = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMSSV = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        btnThemSV = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
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
        lbThongBao.setBounds(395, 43, 450, 22);

        btnLine.setText("Import Danh Sách");
        btnLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineActionPerformed(evt);
            }
        });
        add(btnLine);
        btnLine.setBounds(12, 13, 147, 25);

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

        buttonGroup1.add(rdNam);
        rdNam.setText("Nam");

        buttonGroup1.add(rdNu);
        rdNu.setText("Nữ");

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
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdNam)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdNu))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnThemSV, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(39, Short.MAX_VALUE))))
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
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdNam)
                    .addComponent(rdNu))
                .addGap(35, 35, 35)
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

    private void btnLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineActionPerformed
       
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
        String []data;
        String fileGoc="D:\\File CSV\\";
        File f=new File(path);
        String name=f.getName();
        data=name.split("\\.");
        String fileName=f.getName();
        String fileKT=fileGoc+fileName;
        File fKT=new  File(fileKT);
        if(fKT.exists()){
            JOptionPane.showMessageDialog(cbLop,"File Da ton tai");
        }
        else{
            
            Path source = Paths.get(path);
 
		// Destination file.
		Path destination = Paths.get(fileKT);
		
		try {
			copyFile(source, destination);
		} catch (IOException e) {
			System.out.println("Lỗi Khi copy File");
			e.printStackTrace();
		}
            
            ghiFileLopHoc("D:\\File CSV\\dslop.csv",data[0]);
            docFile(fileKT);
            JOptionPane.showMessageDialog(cbLop,"import Thành Công");
            load();
        }
            
            
        } catch (IOException ex) {
            Logger.getLogger(DSSinhVienWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        // thu muc goc
        
        //lbThongBao.setText("Thông Tin Danh Sách Sinh Viên Lớp : "+nameFile);
    }//GEN-LAST:event_btnLineActionPerformed

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
        
        if(cbLop.getSelectedItem()!=null){
                       try {
            String name = cbLop.getSelectedItem().toString();
            String file = "D:\\File CSV\\" + name + ".csv";
            path=file;
            //JOptionPane.showMessageDialog(cbLop, name);
            docFile(file);
        } catch (IOException ex) {
   
        }
        }
       
    }//GEN-LAST:event_cbLopItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLine;
    private javax.swing.JButton btnThemSV;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbLop;
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
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tbSinhVien;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMSSV;
    // End of variables declaration//GEN-END:variables
}
