/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BangDiemWindow extends javax.swing.JPanel {

    /**
     * Creates new form BangDiemWindow
     */
    String path="";
    String lineAll;
    double hon5=0;
    double kem5;
    double tongHS=0;
    public BangDiemWindow() throws IOException {
        initComponents();
        load();
        pnPhanTram.setVisible(false);
    }
    public void load() throws IOException{
        String file="C:\\Users\\Admin\\Desktop\\File CSV\\18hcb_CTT001_KQ.csv";
        path=file;
        lineAll=file;
        File f=new File(file);
        String nameFile=f.getName();
        lbThongBao.setText("Quản Lý Bảng Điểm Sinh Viên: "+nameFile);
        docFile(file);
        String lh="C:\\Users\\Admin\\Desktop\\File CSV\\dslop.csv";
        docFileLH(lh);
        
    }
    public void docFile(String p) throws FileNotFoundException, IOException{
        hon5=0;
        kem5=0;
        tongHS=0;
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
              //thong ke
              tongHS++;
              if(Float.parseFloat(dataSV[6])>=5){
                  hon5++;
              }
              else{
                  kem5++;
              }
               dtm.addRow(new Object[]{dataSV[0],dataSV[1],dataSV[2],dataSV[3],dataSV[4],dataSV[5],dataSV[6]});
              line =br.readLine();
          }
        br.close();
        fr.close();
        this.tbBangDiem.setModel(dtm);
        this.tbBangDiem.repaint();
        this.tbBangDiem.revalidate();
    }
    public void docFileDSMH(String p) throws FileNotFoundException, IOException{
   
        cbDSMH.removeAllItems();
        FileReader fr = new FileReader(p);
        BufferedReader br = new BufferedReader(fr);
        
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
        fr.close();
//         this.tbMonHoc.setModel(dtm);
//        this.tbMonHoc.repaint();
//        this.tbMonHoc.revalidate();
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbThongBao = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbDuongDan = new javax.swing.JLabel();
        cbMonHoc = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbLop = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cbDSMH = new javax.swing.JComboBox();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBangDiem = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        pnPhanTram = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbdau = new javax.swing.JLabel();
        lbrot = new javax.swing.JLabel();
        lbdaupt = new javax.swing.JLabel();
        lbrotpt = new javax.swing.JLabel();

        setLayout(null);

        lbThongBao.setText("Quản Lý Bảng Điểm Sinh Viên");
        add(lbThongBao);
        lbThongBao.setBounds(260, 10, 420, 28);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Chọn File Điểm Cần Import");

        jButton1.setText("File Import");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbDuongDan.setText("URL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbDuongDan, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDuongDan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        add(jPanel1);
        jPanel1.setBounds(10, 65, 278, 380);

        jLabel2.setText("Lớp");

        cbLop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLopItemStateChanged(evt);
            }
        });

        jLabel3.setText("Môn Học");

        btnTimKiem.setBackground(new java.awt.Color(255, 102, 102));
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tbBangDiem.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbBangDiem);

        javax.swing.GroupLayout cbMonHocLayout = new javax.swing.GroupLayout(cbMonHoc);
        cbMonHoc.setLayout(cbMonHocLayout);
        cbMonHocLayout.setHorizontalGroup(
            cbMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cbMonHocLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(cbMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cbMonHocLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbLop, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addComponent(cbDSMH, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cbMonHocLayout.setVerticalGroup(
            cbMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cbMonHocLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(cbMonHocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbLop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbDSMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(cbMonHoc);
        cbMonHoc.setBounds(302, 46, 703, 399);

        jButton2.setText("Sửa Điểm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(428, 463, 89, 30);

        jButton3.setText("Thống Kê");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(593, 463, 87, 30);

        pnPhanTram.setBackground(new java.awt.Color(255, 204, 255));

        jLabel4.setText("Đậu :");

        jLabel5.setText("Rớt :");

        lbdau.setText("jLabel6");

        lbrot.setText("jLabel6");

        lbdaupt.setText("jLabel6");

        lbrotpt.setText("jLabel6");

        javax.swing.GroupLayout pnPhanTramLayout = new javax.swing.GroupLayout(pnPhanTram);
        pnPhanTram.setLayout(pnPhanTramLayout);
        pnPhanTramLayout.setHorizontalGroup(
            pnPhanTramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPhanTramLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnPhanTramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(37, 37, 37)
                .addGroup(pnPhanTramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnPhanTramLayout.createSequentialGroup()
                        .addComponent(lbrot)
                        .addGap(18, 18, 18)
                        .addComponent(lbrotpt))
                    .addGroup(pnPhanTramLayout.createSequentialGroup()
                        .addComponent(lbdau)
                        .addGap(18, 18, 18)
                        .addComponent(lbdaupt)))
                .addGap(0, 57, Short.MAX_VALUE))
        );
        pnPhanTramLayout.setVerticalGroup(
            pnPhanTramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnPhanTramLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnPhanTramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnPhanTramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbdau)
                        .addComponent(lbdaupt)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(pnPhanTramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbrot)
                    .addComponent(lbrotpt)))
        );

        add(pnPhanTram);
        pnPhanTram.setBounds(720, 440, 250, 80);
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
            lineAll=path;
            //lbImg.setIcon(ResizeImage(path,null));
            lbDuongDan.setText(path);
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
        try {
            docFile(path);
        } catch (IOException ex) {
            Logger.getLogger(BangDiemWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public void loadcb1(String p) throws FileNotFoundException, IOException{
        
         DefaultComboBoxModel model=new DefaultComboBoxModel();
      
        FileReader fr = new FileReader(p);
        BufferedReader br = new BufferedReader(fr);
        
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
        fr.close();

        cbDSMH.setModel(model);
    }
    private void cbLopItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLopItemStateChanged
       String file="C:\\Users\\Admin\\Desktop\\File CSV\\";
        String nameLop=cbLop.getSelectedItem().toString();
        //lopHoc=nameLop;
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

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
         String ma=((MonHoc)cbDSMH.getSelectedItem()).getMaMH();
        String name=cbLop.getSelectedItem().toString();
        String file="C:\\Users\\Admin\\Desktop\\File CSV\\"+name+"_"+ma+"_KQ.csv";
        lineAll=file;
       JOptionPane.showMessageDialog(cbLop,file);
        try {
            docFile(file);
        } catch (IOException ex) {
            Logger.getLogger(DangKyWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try{          
        String stt=tbBangDiem.getValueAt(tbBangDiem.getSelectedRow(),0).toString();
        String mssv=tbBangDiem.getValueAt(tbBangDiem.getSelectedRow(),1).toString();
        String ht=tbBangDiem.getValueAt(tbBangDiem.getSelectedRow(),2).toString();
        String gk=tbBangDiem.getValueAt(tbBangDiem.getSelectedRow(),3).toString();
        String ck=tbBangDiem.getValueAt(tbBangDiem.getSelectedRow(),4).toString();
        String dk=tbBangDiem.getValueAt(tbBangDiem.getSelectedRow(),5).toString();
        String td=tbBangDiem.getValueAt(tbBangDiem.getSelectedRow(),6).toString();
       String l=lineAll;
        SuaDiemFrame sdf=new SuaDiemFrame(stt, mssv, ht, gk, ck, dk, td,l);
        sdf.show(true);
        }
       catch(Exception e){
           JOptionPane.showMessageDialog(cbLop,"Chon dong Sinh Vien Can Sua");
       }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        pnPhanTram.setVisible(true);
        lbdau.setText(String.valueOf(hon5));
        lbrot.setText(String.valueOf(kem5));
        double kq1=(hon5/tongHS)*100;
        double kq2=(kem5/tongHS)*100;
        lbdaupt.setText(String.valueOf(kq1)+"%");
        lbrotpt.setText(String.valueOf(kq2)+"%");
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox cbDSMH;
    private javax.swing.JComboBox cbLop;
    private javax.swing.JPanel cbMonHoc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDuongDan;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JLabel lbdau;
    private javax.swing.JLabel lbdaupt;
    private javax.swing.JLabel lbrot;
    private javax.swing.JLabel lbrotpt;
    private javax.swing.JPanel pnPhanTram;
    private javax.swing.JTable tbBangDiem;
    // End of variables declaration//GEN-END:variables
}
