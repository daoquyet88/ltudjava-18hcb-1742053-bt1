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
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class DangKyWindow extends javax.swing.JPanel {

    /**
     * Creates new form DangKyWindow
     */
    String lineAll;
    String lopHoc="";
    String maMH="";
    public DangKyWindow() throws IOException {
        initComponents();
       load();
        //loadcb1();
    }
    public void loadcb1(String p) throws FileNotFoundException, IOException{
        
         DefaultComboBoxModel model=new DefaultComboBoxModel();
      
         File fileDir = new File(p);
			
		BufferedReader br = new BufferedReader(
		   new InputStreamReader(
                      new FileInputStream(fileDir), "UTF8"));
        
        String []dataSV;
        String line = br.readLine();
        line = br.readLine();
          while(line != null){
              dataSV=line.split(",");
               model.addElement(new MonHoc(dataSV[1],dataSV[2]));
               //cbDSMH.addItem(dataSV[2].toString());
              line =br.readLine();
          }
        br.close();
        //fr.close();

        cbDSMH.setModel(model);
    }
    public void load() throws IOException{
         String file="D:File CSV\\dslop.csv";
         docFileLH(file);
         File f=new File(file);
        String nameFile=f.getName();
        lbThongBao.setText("Thông Tin Môn Học Lớp : "+nameFile);
    }
    public void docFileLH(String p) throws FileNotFoundException, IOException{
       
         File fileDir = new File(p);
			
		BufferedReader br = new BufferedReader(
		   new InputStreamReader(
                      new FileInputStream(fileDir), "UTF8"));        
        String []dataSV;
        String line = br.readLine();      
          
        line = br.readLine();
          while(line != null){
              dataSV=line.split(",");
              cbLop.addItem(dataSV[0]);
              line =br.readLine();
          }
        br.close();
        //fr.close();
        
    }
     public void docFile(String p) throws FileNotFoundException, IOException{
        DefaultTableModel dtm=new DefaultTableModel();      
        
        File fileDir = new File(p);
			
		BufferedReader br = new BufferedReader(
		   new InputStreamReader(
                      new FileInputStream(fileDir), "UTF8"));
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
        //fr.close();
         this.tbMonHoc.setModel(dtm);
        this.tbMonHoc.repaint();
        this.tbMonHoc.revalidate();
    }
     public void docFileDSMH(String p) throws FileNotFoundException, IOException{
   
         cbDSMH.removeAllItems();
        File fileDir = new File(p);
			
		BufferedReader br = new BufferedReader(
		   new InputStreamReader(
                      new FileInputStream(fileDir), "UTF8"));
        String []dataSV;
        String line = br.readLine();
        line = br.readLine();
          while(line != null){
              dataSV=line.split(",");
               //dtm.addRow(new Object[]{dataSV[0],dataSV[1],dataSV[2],dataSV[3],dataSV[4]});
               cbDSMH.addItem(dataSV[2].toString());
              line =br.readLine();
          }
        br.close();
        //fr.close();
//         this.tbMonHoc.setModel(dtm);
//        this.tbMonHoc.repaint();
//        this.tbMonHoc.revalidate();
    }
     public void ghiFile(String p) throws FileNotFoundException, IOException{
        try{
          File file=new File(p);
          FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
          BufferedWriter bw = new BufferedWriter(fw);
          int stt=tbMonHoc.getRowCount();
          stt++;          
          
          String mssv=txtMSSV.getText();
          String hoTen=txtHoTen.getText();
          String gioiTinh="";
          if(rdNam.isSelected())
          {
              gioiTinh="Nam";
          }
          else{
               gioiTinh="Nu";
          }
          JOptionPane.showMessageDialog(cbLop,gioiTinh);
          String cmnd=txtCMND.getText();          
          bw.write(stt+","+mssv+","+hoTen+","+gioiTinh+","+cmnd); 
           bw.newLine();
          bw.close();
          fw.close();
         JOptionPane.showMessageDialog(this,"Thêm Sinh Viên Thành Công");  
            docFile(p);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        lbThongBao = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtMSSV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        btnThemSV = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbLop = new javax.swing.JComboBox();
        cbDSMH = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMonHoc = new javax.swing.JTable();
        btnHuyMH = new javax.swing.JButton();

        setLayout(null);

        lbThongBao.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbThongBao.setText("Quản Lý Đăng Ký Môn Học");
        add(lbThongBao);
        lbThongBao.setBounds(250, 10, 550, 22);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel4.setText("MSSV");

        jLabel5.setText("Họ tên");

        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });

        jLabel6.setText("Giới Tính");

        buttonGroup1.add(rdNam);
        rdNam.setText("Nam");
        rdNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdNu);
        rdNu.setText("Nư");

        jLabel7.setText("CMND");

        btnThemSV.setText("Thêm");
        btnThemSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSVActionPerformed(evt);
            }
        });

        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnThemSV, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(30, 30, 30)
                        .addComponent(rdNam)
                        .addGap(18, 18, 18)
                        .addComponent(rdNu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTimKiem)
                            .addComponent(jLabel4)
                            .addComponent(txtMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rdNam)
                            .addComponent(rdNu))
                        .addGap(18, 18, 18)
                        .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addComponent(jLabel7))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemSV, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1);
        jPanel1.setBounds(10, 60, 310, 420);

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Lớp");

        jLabel3.setText("Môn Học");

        cbLop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLopItemStateChanged(evt);
            }
        });

        cbDSMH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDSMHItemStateChanged(evt);
            }
        });

        tbMonHoc.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbMonHoc);

        btnHuyMH.setBackground(new java.awt.Color(255, 102, 102));
        btnHuyMH.setText("Huỷ Môn");
        btnHuyMH.setToolTipText("Chọn Vào Dòng Sinh Viên  Cần Huỷ Môn Học . ");
        btnHuyMH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyMHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(38, 38, 38)
                        .addComponent(cbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(57, 57, 57)
                        .addComponent(cbDSMH, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnHuyMH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(cbLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDSMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHuyMH)
                .addContainerGap())
        );

        add(jPanel2);
        jPanel2.setBounds(340, 80, 640, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void rdNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdNamActionPerformed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void cbLopItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLopItemStateChanged
        String file="D:File CSV\\";
        String nameLop=cbLop.getSelectedItem().toString();
        lopHoc=nameLop;
        String nameDSMH=nameLop+"_TKB.csv";
        file=file+nameDSMH;
        //JOptionPane.showMessageDialog(cbLop,file);
        if(nameDSMH!=null){
            try {
                loadcb1(file);
            } catch (IOException ex) {
                Logger.getLogger(DangKyWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cbLopItemStateChanged

    private void cbDSMHItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDSMHItemStateChanged

    }//GEN-LAST:event_cbDSMHItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ma=((MonHoc)cbDSMH.getSelectedItem()).getMaMH();
        String name=cbLop.getSelectedItem().toString();
        String file="D:\\File CSV\\"+name+"_"+ma+".csv";
        lineAll=file;
        //JOptionPane.showMessageDialog(cbLop,file);
        try {
            docFile(file);
        } catch (IOException ex) {
            Logger.getLogger(DangKyWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String  mssv=txtMSSV.getText();
        String maLop=mssv.substring(0,2)+"hcb";
        String file="D:File CSV\\"+maLop+".csv";
       // JOptionPane.showMessageDialog(cbLop,file);
          
        FileReader fr=null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DangKyWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = new BufferedReader(fr);
        String []dataSV;
        String line="";
        try {
            line = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(DangKyWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
         while(line != null){
              dataSV=line.split(",");
             // String mas=dataSV[1].toString();
               if(dataSV[1].toString().equals(mssv)){
                   txtHoTen.setText(dataSV[2].toString());
                   txtCMND.setText(dataSV[4].toString());
                   if(dataSV[3].toString().equals("Nam")){
                       //rdNam.isSelected();
                       rdNam.setSelected(true);
                       
                   }
                   else{
                       //rdNu.isSelected();
                       rdNu.setSelected(true);
                   }
                   break;
               }
            try {
                line =br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(DangKyWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        try {
            br.close();
             fr.close();
        } catch (IOException ex) {
            Logger.getLogger(DangKyWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         
        
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnHuyMHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyMHActionPerformed
       String stt = this.tbMonHoc.getValueAt(this.tbMonHoc.getSelectedRow(),0).toString();
       String mssv = this.tbMonHoc.getValueAt(this.tbMonHoc.getSelectedRow(),1).toString();
       String hoTen = this.tbMonHoc.getValueAt(this.tbMonHoc.getSelectedRow(),2).toString();
       String gt = this.tbMonHoc.getValueAt(this.tbMonHoc.getSelectedRow(),3).toString();
       String cmnd= this.tbMonHoc.getValueAt(this.tbMonHoc.getSelectedRow(),4).toString();
       String dongHuy=stt+","+mssv+","+hoTen+","+gt+","+cmnd;
       JOptionPane.showMessageDialog(cbLop,dongHuy);
       String p=lineAll;
         String dataSV[];
         try{
            ArrayList<String> ar=new ArrayList<String>();
            FileReader fr = new FileReader(p);
            BufferedReader br = new BufferedReader(fr);
            String  line = br.readLine();
            
              while(line != null){
                  ar.add(line);
                  line =br.readLine();
              }

//            for(String s : ar){
//                System.out.println("kq"+s);
//            }
            br.close();
            fr.close();

            FileWriter fw = new FileWriter(p);
            BufferedWriter bw = new BufferedWriter(fw);  
            for(String s : ar){
                if(s.equals(dongHuy))
                {
                     JOptionPane.showMessageDialog(cbLop,dongHuy);
                }
                else{
                    bw.write(s);
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();
         }
         catch(Exception e){
             
         }
        try {
            docFile(p);
        } catch (IOException ex) {
            Logger.getLogger(DangKyWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHuyMHActionPerformed

    private void btnThemSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSVActionPerformed
        try {
            ghiFile(lineAll);
        } catch (IOException ex) {
            Logger.getLogger(DangKyWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnThemSVActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        txtHoTen.setText("");
        txtCMND.setText("");
        txtMSSV.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyMH;
    private javax.swing.JButton btnThemSV;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbDSMH;
    private javax.swing.JComboBox cbLop;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tbMonHoc;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMSSV;
    // End of variables declaration//GEN-END:variables
}
