/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package busmanagement;

import busmanagement.employee.Employee;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.PhanCong;
import views.QLChuyen;
import views.QLTime;
import views.QLVe;
import views.Thongke;


/**
 *
 * @author Admin
 */
public class EmployeeManagement extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeManagment
     */
    static String infor;
    
    public EmployeeManagement() {
        initComponents();
        deleteButton.setEnabled(false);
        updateButton.setEnabled(false);
        displayEmpList();
        empmButton.requestFocus();
        
    }
    
    private boolean isLetters(String s) {
      if (s == null) {
         return false;
      }
      int len = s.length();
      for (int i = 0; i < len; i++) {
         // checks whether the character is not a letter
         // if it is not a letter ,it will return false
         if ((Character.isLetter(s.charAt(i)) == false) ) {
            return false;
         }
      }
      return true;
   }
    
    private boolean isDigits(String s)
    {
        if(s== null)
        {
            return false;
        }
        try{
            Float.parseFloat(s);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
        
    }
    
    public boolean validVNName(String name)
    {
        Pattern pattern;
        final String namePattern = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s|_]+$";
        
        pattern = Pattern.compile(namePattern);
        return pattern.matcher(name).matches();
    }
   
    public Connection establishCon()
    {
        
        try{
            String connectionUrl
            = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=BusManagement;"
            + "encrypt=true;trustServerCertificate=true";
            //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl, "sa", "viet1234");
            return con;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Employee> getEmployeeList(){
        ArrayList<Employee> emps = new ArrayList<>();
        try {
            String connectionUrl
            = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=BusManagement;"
            + "encrypt=true;trustServerCertificate=true";
            //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl, "sa", "viet1234");
            String empQueryAll = "SELECT * FROM EMPLOYEE";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(empQueryAll);
            while(rs.next())
            {
                Employee emp = new Employee(rs.getInt("emp_id"), rs.getString("f_name"), rs.getString("l_name"), rs.getString("address"), rs.getString("position"), rs.getDate("birth_date"), rs.getDate("start_working_date"), rs.getString("sex"), rs.getDouble("salary"), rs.getString("identity_num"));
                emps.add(emp);
                
            }
            st.close();
            con.close();
        }
         catch (Exception e){
             e.printStackTrace();
         }
        return emps;
    
    }
    public void displayEmpList()
    {
        ArrayList<Employee> emps = getEmployeeList();
        DefaultTableModel model = (DefaultTableModel)empTable.getModel();
       
        Object [] rows = new Object[10];
        for(int i=0; i<emps.size(); i++)
        {
            
            rows[0] = emps.get(i).getEmpId();
            rows[1] = emps.get(i).getfName();
          
            rows[2] = emps.get(i).getlName();
            rows[3] = emps.get(i).getBirthdate();
            rows[4] = emps.get(i).getAdress();
            rows[5] = emps.get(i).getSex();
            rows[6] = emps.get(i).getStartWorkingDate();
            rows[7] = emps.get(i).getPosition();
            rows[8] = emps.get(i).getSalary();
            rows[9] = emps.get(i).getIdentityNum();
            model.addRow(rows);
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

        jPanel1 = new javax.swing.JPanel();
        inforPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        inforText = new javax.swing.JTextPane();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        accButton = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        empmButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lNameText = new javax.swing.JTextField();
        fNameText = new javax.swing.JTextField();
        bMonthCombo = new javax.swing.JComboBox<>();
        addressText = new javax.swing.JTextField();
        sexCombo = new javax.swing.JComboBox<>();
        swMonthCombo = new javax.swing.JComboBox<>();
        posCombo = new javax.swing.JComboBox<>();
        salaryText = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        bdayText = new javax.swing.JTextField();
        bYearText = new javax.swing.JTextField();
        swDayText = new javax.swing.JTextField();
        swYearText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        identityNumText = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("EmpFrame"); // NOI18N
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(256, 720));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thông tin người dùng");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        inforText.setEditable(false);
        inforText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        inforText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inforText.setText("this is some random text");
        inforText.setAutoscrolls(false);
        inforText.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        inforText.setEnabled(false);
        jScrollPane2.setViewportView(inforText);

        jButton6.setText("Phân công");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setText("Quản lý chuyến xe");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setText("Thống kê");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton5.setText("Đăng xuất");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        accButton.setText("Quản lý tài khoản");
        accButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accButtonActionPerformed(evt);
            }
        });

        jButton11.setText("Quản lý vé");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        empmButton.setText("Quản lý nhân viên");
        empmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empmButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Quản lý xe bus");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Quản lý tuyến xe");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inforPanelLayout = new javax.swing.GroupLayout(inforPanel);
        inforPanel.setLayout(inforPanelLayout);
        inforPanelLayout.setHorizontalGroup(
            inforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inforPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(inforPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(empmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        inforPanelLayout.setVerticalGroup(
            inforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inforPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(empmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(accButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(inforPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(inforPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(983, 720));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        empTable.setAutoCreateRowSorter(true);
        empTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên", "Họ & đệm", "Ngày sinh", "Địa chỉ", "Giới tính", "Ngày làm việc", "Chức vụ", "Lương(vnd)", "CMND"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        empTable.setShowGrid(true);
        empTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(empTable);
        if (empTable.getColumnModel().getColumnCount() > 0) {
            empTable.getColumnModel().getColumn(0).setPreferredWidth(10);
            empTable.getColumnModel().getColumn(1).setPreferredWidth(30);
            empTable.getColumnModel().getColumn(2).setPreferredWidth(30);
            empTable.getColumnModel().getColumn(3).setPreferredWidth(20);
            empTable.getColumnModel().getColumn(4).setPreferredWidth(170);
            empTable.getColumnModel().getColumn(5).setPreferredWidth(15);
            empTable.getColumnModel().getColumn(6).setPreferredWidth(20);
            empTable.getColumnModel().getColumn(7).setPreferredWidth(30);
            empTable.getColumnModel().getColumn(8).setPreferredWidth(40);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Họ & đệm: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày/ tháng/ năm sinh:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Địa chỉ:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Giới tính:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Ngày bắt đầu làm việc:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Chức vụ:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Lương:");

        lNameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lNameTextActionPerformed(evt);
            }
        });

        bMonthCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn tháng", "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));

        addressText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextActionPerformed(evt);
            }
        });

        sexCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn giới tính--", "Nam", "Nữ", "Khác" }));
        sexCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexComboActionPerformed(evt);
            }
        });

        swMonthCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn tháng", "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" }));

        posCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn chức vụ--", "Admin", "Tài xế", "Phụ xe" }));

        addButton.setText("Thêm");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Xóa");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Sửa");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        bdayText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdayTextActionPerformed(evt);
            }
        });

        jLabel10.setText("Ngày");

        jLabel11.setText("Tháng ");

        jLabel12.setText("Năm");

        jLabel13.setText("Ngày");

        jLabel14.setText("Tháng ");

        jLabel15.setText("Năm");

        identityNumText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identityNumTextActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("CMND hoặc CCCD:");

        jButton1.setText("Đặt lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Quản lý nhân viên");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(fNameText, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lNameText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(45, 45, 45))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bdayText, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bMonthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(bYearText, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 12, Short.MAX_VALUE))))
                        .addGap(5, 5, 5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(158, 158, 158)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(salaryText, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(53, 53, 53)
                                                .addComponent(jLabel14))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(swDayText, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(25, 25, 25)
                                                .addComponent(swMonthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(swYearText, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sexCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(192, 192, 192))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(identityNumText, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(posCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(399, 399, 399)
                        .addComponent(jLabel17))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(381, 381, 381)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(posCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(identityNumText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bdayText, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bMonthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bYearText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(swDayText, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(swMonthCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(swYearText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void empmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empmButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empmButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = empTable.getSelectedRow();
        DefaultTableModel model =(DefaultTableModel) empTable.getModel();
        if(selectedRow >=0)
        {
            String lName, fName, address, idNum, salary, pos, sex;
            lName = lNameText.getText().trim();
            fName = fNameText.getText().trim();
            idNum = identityNumText.getText().trim();
            address = addressText.getText().trim();
       if(fNameText.getText().equals("") ||lNameText.equals("")||addressText.getText().equals("")||posCombo.getSelectedItem().toString().equals("")||salaryText.getText().equals("")||sexCombo.getSelectedItem().toString().equals("")||bdayText.getText().equals("")||bMonthCombo.getSelectedItem().toString().equals("")||bYearText.getText().equals("")||swDayText.getText().equals("")||swMonthCombo.getSelectedItem().toString().equals("")||swYearText.getText().equals(""))
       {
           
           JOptionPane.showMessageDialog(this, "Vui lòng điển vào tất cả các trường");
           return;
       }
            
        if(!isDigits(salaryText.getText()))
        {
            JOptionPane.showMessageDialog(this, "Lương chỉ được nhập số");
            return;
        }
            
            salary = salaryText.getText().trim();
            pos = posCombo.getSelectedItem().toString();
            
            sex = sexCombo.getSelectedItem().toString();
            if(sex.equals("Nam"))
            {
                sex = "m";
            }
            else if(sex.equals("Nữ"))
            {
                sex = "f";
            }
            else
            {
                sex = "o";
            }
                          // viec con lai gan gia tri vao bien, viet truy van va update table
            LocalDate bDate, swDate;
            int bDay, bMonth, bYear;
            int swDay, swMonth, swYear;
            
            
            switch (bMonthCombo.getSelectedItem().toString())
        {
            case "Tháng 1":
                bMonth = 1;
                break;
            case "Tháng 2":
                bMonth = 2;
                break;
            case "Tháng 3":
                bMonth = 3;
                break;
            case "Tháng 4":
                bMonth = 4;
                break;
            case "Tháng 5":
                bMonth = 5;
                break;
            case "Tháng 6":
                bMonth = 6;
                break;
            case "Tháng 7":
                bMonth = 7;
                break;
            case "Tháng 8":
                bMonth = 8;
                break;
            case "Tháng 9":
                bMonth = 9;
                break;
            case "Tháng 10":
                bMonth = 10;
                break;
            case "Tháng 11":
                bMonth = 11;
                break;
            case "Tháng 12":
                bMonth = 12;
                break;
            default: 
                bMonth = 0;
                       
        }
            if(!isDigits(bYearText.getText()))
        {
            JOptionPane.showMessageDialog(this, "Năm sinh chỉ được nhập số năm từ "+Integer.toString((LocalDate.now().getYear()-60)) +" đến " + Integer.toString((LocalDate.now().getYear()-18)));
            return;
        }
        else if(isDigits(bYearText.getText()))
        {
            if(Integer.parseInt(bYearText.getText()) < LocalDate.now().getYear()-60 || Integer.parseInt(bYearText.getText()) > LocalDate.now().getYear()-18)
            {
                JOptionPane.showMessageDialog(this, "Năm sinh chỉ được nhập số năm từ "+Integer.toString((LocalDate.now().getYear()-60)) +" đến " + Integer.toString((LocalDate.now().getYear()-18)));
                return;                
            }
             
        }
        
        bYear = Integer.parseInt(bYearText.getText().trim());
        
        
        if(!isDigits(swYearText.getText()))
        {
            JOptionPane.showMessageDialog(this, "Năm bắt đầu làm việc chỉ được nhập \"số\" năm từ "+Integer.toString(bYear + 18) +" đến " + Integer.toString(LocalDate.now().getYear()));
            return;
        }
        else if(isDigits(swYearText.getText()))
        {
            if(Integer.parseInt(swYearText.getText()) < (bYear+18) || Integer.parseInt(swYearText.getText()) > LocalDate.now().getYear())
            {
                System.out.println("run");
                JOptionPane.showMessageDialog(this, "Năm bắt đầu làm việc chỉ được nhập \"số\" năm từ "+Integer.toString(bYear + 18) +" đến " + Integer.toString(LocalDate.now().getYear()));
                return;                
            }
             
        }
        swYear = Integer.parseInt(swYearText.getText().trim());
            
            
            switch (swMonthCombo.getSelectedItem().toString())
       {
            case "Tháng 1":
                swMonth = 1;
                break;
            case "Tháng 2":
                swMonth = 2;
                break;
            case "Tháng 3":
                swMonth = 3;
                break;
            case "Tháng 4":
                swMonth = 4;
                break;
            case "Tháng 5":
                swMonth = 5;
                break;
            case "Tháng 6":
                swMonth = 6;
                break;
            case "Tháng 7":
                swMonth = 7;
                break;
            case "Tháng 8":
                swMonth = 8;
                break;
            case "Tháng 9":
                swMonth = 9;
                break;
            case "Tháng 10":
                swMonth = 10;
                break;
            case "Tháng 11":
                swMonth = 11;
                break;
            case "Tháng 12":
                swMonth = 12;
                break;
            default: 
                swMonth = 0;
                       
        }
            
            YearMonth my = null;
        if(bMonth !=0)
        {
            my = YearMonth.of(bYear, bMonth);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tháng sinh");
            return;
        }
        
        
        
        if(!isDigits(bdayText.getText()))
        {
           JOptionPane.showMessageDialog(this, "Ngày sinh chỉ được nhập số");
           return;
        }
        else if(isDigits(bdayText.getText()))
        {
//            System.out.println("run");
            bDay =Integer.parseInt(bdayText.getText().trim());
//            System.out.println(bDay);
            System.out.println(my.lengthOfMonth());
            if(bDay < 1 || bDay >my.lengthOfMonth())
            {
//                System.out.println("run2");
                JOptionPane.showMessageDialog(this, "Ngày sinh hợp lệ trong tháng từ 1-"+Integer.toString(my.lengthOfMonth()));
                return;
            }
            
                
        }
        
        
        bDay = Integer.parseInt(bdayText.getText().trim());
        
        
          YearMonth my2 = null;
         if(swMonth !=0)
        {
            my2 = YearMonth.of(swYear, swMonth);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tháng bắt đầu làm việc");
            return;
        }
         
          if(!isDigits(swDayText.getText()))
        {
           JOptionPane.showMessageDialog(this, "Ngày bắt đầu làm việc chỉ được nhập số");
           return;
        }
        else if(isDigits(swDayText.getText()))
        {
//            System.out.println("run");
            swDay =Integer.parseInt(swDayText.getText().trim());
//            System.out.println(bDay);
            System.out.println(my2.lengthOfMonth());
            if(swDay < 1 || swDay >my2.lengthOfMonth())
            {
//                System.out.println("run2");
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu làm việc hợp lệ trong tháng từ 1-"+Integer.toString(my2.lengthOfMonth()));
                return;
            }
            
                
        }
          
          swDay = Integer.parseInt(swDayText.getText().trim());
            if(pos.equals("--Chọn chức vụ--"))
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chức vụ");
            return;
        }
        else if(sex == "0")
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính");
            return;
        }
        else if(bMonth == 0)
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tháng sinh");
            return;
        }
        else if(swMonth ==0)
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tháng bắt đầu làm việc");
            return;
        }
        else if(!validVNName(lName))
        {
            System.out.println(validVNName(lName));
            JOptionPane.showMessageDialog(this, "Họ & tên chỉ được nhập ký tự");
            return;
        }
        else if(!validVNName(fName))
        {
            
            JOptionPane.showMessageDialog(this, "Tên chỉ được nhập ký tự");
            return;
        }
        else if(!isDigits(idNum))
        {
            JOptionPane.showMessageDialog(this, "Số CMND/CCCD chỉ được nhập số và độ dài phải từ 9-12 ký tự");
            return;
        }
        else if(isDigits(idNum))
        {
            if(idNum.length()<9 || idNum.length() >12)
            {
                JOptionPane.showMessageDialog(this, "Số CMND/CCCD chỉ được nhập số và độ dài phải từ 9-12 ký tự");
                return;
            }
        }
        
            
            bDate = LocalDate.of(bYear, bMonth, bDay);
            swDate = LocalDate.of(swYear, swMonth, swDay);
            
            model.setValueAt(lName, selectedRow, 2);
            model.setValueAt(fName, selectedRow, 1);
            model.setValueAt(address, selectedRow, 4);
            model.setValueAt(idNum, selectedRow, 9);
            model.setValueAt(salary, selectedRow, 8);
            model.setValueAt(pos, selectedRow, 7);
            model.setValueAt(sex, selectedRow, 5);
            model.setValueAt(bDate, selectedRow, 3);
            model.setValueAt(swDate, selectedRow, 6);
            Connection con = establishCon();
            Statement st;
            String id = empTable.getModel().getValueAt(selectedRow, 0).toString();
            try{
                String updateSql = "UPDATE EMPLOYEE "+
                        "SET f_name=N'"+fName+"', "+ "l_name=N'"+lName+"', "+ "birth_date='"+bDate+"', "+"address=N'"+address+"', "+"sex= '"+sex+"', "+ "start_working_date= '"+swDate+"', "+"salary=" +salary+", "+"identity_num= "+idNum +", "+"position=N'"+pos+"' "
                        +"WHERE emp_id ="+id;
                st = con.createStatement();
                st.executeUpdate(updateSql);
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                
            updateButton.setEnabled(false);
            deleteButton.setEnabled(false);
            empTable.getSelectionModel().clearSelection();
            lNameText.setText("");
            fNameText.setText("");
            addressText.setText("");
            identityNumText.setText("");
            salaryText.setText("");
            bdayText.setText("");
            bYearText.setText("");
            swDayText.setText("");
            swYearText.setText("");
            bMonthCombo.setSelectedItem("Chọn tháng");
            swMonthCombo.setSelectedItem("Chọn tháng");
            sexCombo.setSelectedItem("--Chọn giới tính--");
            posCombo.setSelectedItem("--Chọn chức vụ--");
            addButton.setEnabled(true);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void addressTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTextActionPerformed

    private void lNameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lNameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lNameTextActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        
       if(fNameText.getText().equals("") ||lNameText.equals("")||addressText.getText().equals("")||posCombo.getSelectedItem().toString().equals("")||salaryText.getText().equals("")||sexCombo.getSelectedItem().toString().equals("")||bdayText.getText().equals("")||bMonthCombo.getSelectedItem().toString().equals("")||bYearText.getText().equals("")||swDayText.getText().equals("")||swMonthCombo.getSelectedItem().toString().equals("")||swYearText.getText().equals(""))
       {
           JOptionPane.showMessageDialog(this, "Vui lòng điển vào tất cả các trường");
       }
       else
       {
           String lName, fName, address, sex, pos, identityNum;
        double salary;
        int bDay=0, swDay, bYear, swYear;
        int bMonth, swMonth;
        Employee emp;
        LocalDate bDate, swDate;
        lName = lNameText.getText().trim();
        fName = fNameText.getText().trim();
        address = addressText.getText().trim();
        identityNum = identityNumText.getText().trim();
        pos = posCombo.getSelectedItem().toString();
        
        
          if(!isDigits(salaryText.getText()))
        {
            JOptionPane.showMessageDialog(this, "Lương chỉ được nhập số");
            return;
        }
        
        salary = Double.parseDouble(salaryText.getText().trim());
        
        

        
        if(!isDigits(bYearText.getText()))
        {
            JOptionPane.showMessageDialog(this, "Năm sinh chỉ được nhập số năm từ "+Integer.toString((LocalDate.now().getYear()-60)) +" đến " + Integer.toString((LocalDate.now().getYear()-18)));
            return;
        }
        else if(isDigits(bYearText.getText()))
        {
            if(Integer.parseInt(bYearText.getText()) < LocalDate.now().getYear()-60 || Integer.parseInt(bYearText.getText()) > LocalDate.now().getYear()-18)
            {
                JOptionPane.showMessageDialog(this, "Năm sinh chỉ được nhập số năm từ "+Integer.toString((LocalDate.now().getYear()-60)) +" đến " + Integer.toString((LocalDate.now().getYear()-18)));
                return;                
            }
             
        }
        
        bYear = Integer.parseInt(bYearText.getText().trim());
        
        
        if(!isDigits(swYearText.getText()))
        {
            JOptionPane.showMessageDialog(this, "Năm bắt đầu làm việc chỉ được nhập \"số\" năm từ "+Integer.toString(bYear + 18) +" đến " + Integer.toString(LocalDate.now().getYear()));
            return;
        }
        else if(isDigits(swYearText.getText()))
        {
            if(Integer.parseInt(swYearText.getText()) < (bYear+18) || Integer.parseInt(swYearText.getText()) > LocalDate.now().getYear())
            {
                System.out.println("run");
                JOptionPane.showMessageDialog(this, "Năm bắt đầu làm việc chỉ được nhập \"số\" năm từ "+Integer.toString(bYear + 18) +" đến " + Integer.toString(LocalDate.now().getYear()));
                return;                
            }
             
        }
        swYear = Integer.parseInt(swYearText.getText().trim());
        
        switch(sexCombo.getSelectedItem().toString())
        {
            case "Nam":
                sex = "m";
                break;
            case "Nữ":
                sex = "f";
                break;
            case "Khác":
                sex = "o";
                break;
            default:
                sex = "0";
        }
        
        switch (bMonthCombo.getSelectedItem().toString())
        {
            case "Tháng 1":
                bMonth = 1;
                break;
            case "Tháng 2":
                bMonth = 2;
                break;
            case "Tháng 3":
                bMonth = 3;
                break;
            case "Tháng 4":
                bMonth = 4;
                break;
            case "Tháng 5":
                bMonth = 5;
                break;
            case "Tháng 6":
                bMonth = 6;
                break;
            case "Tháng 7":
                bMonth = 7;
                break;
            case "Tháng 8":
                bMonth = 8;
                break;
            case "Tháng 9":
                bMonth = 9;
                break;
            case "Tháng 10":
                bMonth = 10;
                break;
            case "Tháng 11":
                bMonth = 11;
                break;
            case "Tháng 12":
                bMonth = 12;
                break;
            default: 
                bMonth = 0;
                       
        }
        switch (swMonthCombo.getSelectedItem().toString())
       {
            case "Tháng 1":
                swMonth = 1;
                break;
            case "Tháng 2":
                swMonth = 2;
                break;
            case "Tháng 3":
                swMonth = 3;
                break;
            case "Tháng 4":
                swMonth = 4;
                break;
            case "Tháng 5":
                swMonth = 5;
                break;
            case "Tháng 6":
                swMonth = 6;
                break;
            case "Tháng 7":
                swMonth = 7;
                break;
            case "Tháng 8":
                swMonth = 8;
                break;
            case "Tháng 9":
                swMonth = 9;
                break;
            case "Tháng 10":
                swMonth = 10;
                break;
            case "Tháng 11":
                swMonth = 11;
                break;
            case "Tháng 12":
                swMonth = 12;
                break;
            default: 
                swMonth = 0;
                       
        }
        YearMonth my = null;
        if(bMonth !=0)
        {
            my = YearMonth.of(bYear, bMonth);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tháng sinh");
            return;
        }
        
        
        
        if(!isDigits(bdayText.getText().trim()))
        {
           JOptionPane.showMessageDialog(this, "Ngày sinh chỉ được nhập số");
           return;
        }
        else if(isDigits(bdayText.getText().trim()))
        {
//            System.out.println("run");
            bDay =Integer.parseInt(bdayText.getText());
//            System.out.println(bDay);
         //   System.out.println(my.lengthOfMonth());
            if(bDay < 1 || bDay >my.lengthOfMonth())
            {
//                System.out.println("run2");
                JOptionPane.showMessageDialog(this, "Ngày sinh hợp lệ trong tháng từ 1-"+Integer.toString(my.lengthOfMonth()));
                return;
            }
            
                
        }
        
        
        bDay = Integer.parseInt(bdayText.getText().trim());
        
        
          YearMonth my2 = null;
         if(swMonth !=0)
        {
            my2 = YearMonth.of(swYear, swMonth);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tháng bắt đầu làm việc");
            return;
        }
         
          if(!isDigits(swDayText.getText()))
        {
           JOptionPane.showMessageDialog(this, "Ngày bắt đầu làm việc chỉ được nhập số");
           return;
        }
        else if(isDigits(swDayText.getText()))
        {
//            System.out.println("run");
            swDay =Integer.parseInt(swDayText.getText().trim());
//            System.out.println(bDay);
            System.out.println(my2.lengthOfMonth());
            if(swDay < 1 || swDay >my2.lengthOfMonth())
            {
//                System.out.println("run2");
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu làm việc hợp lệ trong tháng từ 1-"+Integer.toString(my2.lengthOfMonth()));
                return;
            }
            
                
        }
          
          swDay = Integer.parseInt(swDayText.getText().trim());
        
        if(pos.equals("--Chọn chức vụ--"))
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chức vụ");
            return;
        }
        else if(sex == "0")
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính");
            return;
        }
        else if(bMonth == 0)
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tháng sinh");
            return;
        }
        else if(swMonth ==0)
        {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tháng bắt đầu làm việc");
            return;
        }
        else if(!validVNName(lName))
        {
            System.out.println(validVNName(lName) + "here");
            JOptionPane.showMessageDialog(this, "Họ & tên chỉ được nhập ký tự");
            return;
        }
        else if(!validVNName(fName))
        {
            JOptionPane.showMessageDialog(this, "Tên chỉ được nhập ký tự");
            return;
        }
        else if(!isDigits(identityNum))
        {
            JOptionPane.showMessageDialog(this, "Số CMND/CCCD chỉ được nhập số và độ dài phải từ 9-12 ký tự");
            return;
        }
        else if(isDigits(identityNum))
        {
            if(identityNum.length()<9 || identityNum.length() >12)
            {
                JOptionPane.showMessageDialog(this, "Số CMND/CCCD chỉ được nhập số và độ dài phải từ 9-12 ký tự");
                return;
            }
        }
        
      
       
        
              bDate = LocalDate.of(bYear, bMonth, bDay);
        swDate = LocalDate.of(swYear, swMonth, swDay);
           Connection con =null;
           Statement st = null;
           try {
              String connectionUrl
            = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=BusManagement;"
            + "encrypt=true;trustServerCertificate=true";
            //String url = "jdbc:sqlserver:MYPC-FROM-2019\\SERVER1;databaseName=BusManagement2;integratedSecurity=true";
            
            ResultSet rs;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl, "sa", "viet1234");
            String sqlAddEmp = "EXEC addEmp @f_name=N'"+fName+"', "+"@l_name=N'"+lName+"', "+"@birth_date='"+bDate+"', "+"@address=N'"+address+"', "+ "@sex='"+sex+"', "+"@sw_date='"+ swDate+"', "+"@pos=N'"+pos+"', "+ "@salary='"+salary+"', " +"@identity_num='"+identityNum+"'";
            
            String checkUniqueKey = "SELECT * FROM EMPLOYEE WHERE identity_num= "+identityNum;
            
            st = con.createStatement();
            rs = st.executeQuery(checkUniqueKey);
            if(rs.next())
            {
                JOptionPane.showMessageDialog(this, "Số CMND/CCCD bị trùng với người khác trong hệ thống");
                return;
            }
            
            st = con.createStatement();
            st.executeUpdate(sqlAddEmp);
            
            ArrayList<Employee> emps = getEmployeeList();
        DefaultTableModel model = (DefaultTableModel)empTable.getModel();
       
        Object [] rows = new Object[10];
    
            
            rows[0] = emps.get(emps.size()-1).getEmpId();
            rows[1] = emps.get(emps.size()-1).getfName();
          
            rows[2] = emps.get(emps.size()-1).getlName();
            rows[3] = emps.get(emps.size()-1).getBirthdate();
            rows[4] = emps.get(emps.size()-1).getAdress();
            rows[5] = emps.get(emps.size()-1).getSex();
            rows[6] = emps.get(emps.size()-1).getStartWorkingDate();
            rows[7] = emps.get(emps.size()-1).getPosition();
            rows[8] = emps.get(emps.size()-1).getSalary();
            rows[9] = emps.get(emps.size()-1).getIdentityNum();
            model.addRow(rows);
            
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            st.close();
            con.close();
            lNameText.setText("");
            fNameText.setText("");
            addressText.setText("");
            salaryText.setText("");
            bdayText.setText("");
            swDayText.setText("");
            bYearText.setText("");
            swYearText.setText("");
            identityNumText.setText("");
            bMonthCombo.setSelectedItem("Chọn tháng");
            swMonthCombo.setSelectedItem("Chọn tháng");
            sexCombo.setSelectedItem("--Chọn giới tính--");
            posCombo.setSelectedItem("--Chọn chức vụ--");
        }catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("error");
        }
        finally{
               if(st !=null)
               {
                   try{
                       st.close();
                   }
                   catch (Exception e)
                   {
                       e.printStackTrace();
                   }
               }
               
              if(con !=null)
               {
                   try{
                       con.close();
                   }
                   catch (Exception e)
                   {
                       e.printStackTrace();
                   }
               }
               
               
           }
     
        }
        
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void accButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accButtonActionPerformed
        // TODO add your handling code here:
                AccountManagement acc = new AccountManagement();
                acc.setVisible(true);
                acc.setLocationRelativeTo(null);
               // System.out.println(this.infor);
               acc.setInfor(this.infor);
               
               this.dispose();
                
    }//GEN-LAST:event_accButtonActionPerformed

    private void bdayTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdayTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bdayTextActionPerformed

    private void identityNumTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identityNumTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_identityNumTextActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        
        int row = empTable.getSelectedRow();
        String cell = empTable.getModel().getValueAt(row, 0).toString();
        String deleteQuery = "DELETE FROM EMPLOYEE WHERE emp_id= "+cell;
        String checkQueryInTableWork = "SELECT * FROM WORK WHERE emp_id= "+ cell;
        String checkQueryInTableAccount = "SELECT * FROM ACCOUNT WHERE emp_id= "+ cell;
        String deleteQueryInBusEmp = "DELETE FROM BUS_EMP WHERE emp_id= "+ cell;
        ResultSet rs;
        int result= JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa?");
        if(result==0)
        {
            try {
              String connectionUrl
            = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=BusManagement;"
            + "encrypt=true;trustServerCertificate=true";
            //String url = "jdbc:sqlserver:MYPC-FROM-2019\\SERVER1;databaseName=BusManagement2;integratedSecurity=true";
            Statement st;
            //ResultSet rs;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl, "sa", "viet1234");
            
            st = con.createStatement();
            rs = st.executeQuery(checkQueryInTableWork);
            while(rs.next())
            {
                System.out.println("this run");
                String workYear = rs.getString("work_day").split("-")[0];
                System.out.println(workYear);
                if(Integer.parseInt(workYear) == LocalDate.now().getYear())
                {
                    System.out.println("run in if st");
                    JOptionPane.showMessageDialog(this, "Không được xóa nhân viên này có hồ sơ làm việc trong năm nay");
                    deleteButton.setEnabled(false);
            updateButton.setEnabled(false);
            addButton.setEnabled(true);
             empTable.getSelectionModel().clearSelection();
            lNameText.setText("");
            fNameText.setText("");
            addressText.setText("");
            identityNumText.setText("");
            salaryText.setText("");
            bdayText.setText("");
            bYearText.setText("");
            swDayText.setText("");
            swYearText.setText("");
            bMonthCombo.setSelectedItem("Chọn tháng");
            swMonthCombo.setSelectedItem("Chọn tháng");
            sexCombo.setSelectedItem("--Chọn giới tính--");
            posCombo.setSelectedItem("--Chọn chức vụ--");
                    return;
                }
            }
            
//            st = con.createStatement();
//            rs = st.executeQuery(checkQueryInTableAccount);
//            if(rs.next())
//            {
//                JOptionPane.showMessageDialog(this, "Phải xóa tài khoản của nhân viên này trước!");
//                return;
//            }
            
//            st = con.createStatement();
//            st.executeUpdate(deleteQueryInBusEmp);
            
            
            
            st = con.createStatement();
            st.executeUpdate(deleteQuery);
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            DefaultTableModel dm = (DefaultTableModel)empTable.getModel();
            dm.removeRow(row);
            st.close();
            con.close();
            deleteButton.setEnabled(false);
            updateButton.setEnabled(false);
            addButton.setEnabled(true);
             empTable.getSelectionModel().clearSelection();
            lNameText.setText("");
            fNameText.setText("");
            addressText.setText("");
            identityNumText.setText("");
            salaryText.setText("");
            bdayText.setText("");
            bYearText.setText("");
            swDayText.setText("");
            swYearText.setText("");
            bMonthCombo.setSelectedItem("Chọn tháng");
            swMonthCombo.setSelectedItem("Chọn tháng");
            sexCombo.setSelectedItem("--Chọn giới tính--");
            posCombo.setSelectedItem("--Chọn chức vụ--");
            
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
        }
        else{
            deleteButton.setEnabled(false);
            updateButton.setEnabled(false);
            addButton.setEnabled(true);
             empTable.getSelectionModel().clearSelection();
            lNameText.setText("");
            fNameText.setText("");
            addressText.setText("");
            identityNumText.setText("");
            salaryText.setText("");
            bdayText.setText("");
            bYearText.setText("");
            swDayText.setText("");
            swYearText.setText("");
            bMonthCombo.setSelectedItem("Chọn tháng");
            swMonthCombo.setSelectedItem("Chọn tháng");
            sexCombo.setSelectedItem("--Chọn giới tính--");
            posCombo.setSelectedItem("--Chọn chức vụ--");
        }
         
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void empTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empTableMouseClicked
        // TODO add your handling code here:
        addButton.setEnabled(false);
        int selectedRow = empTable.getSelectedRow();
        DefaultTableModel dfModel = (DefaultTableModel) empTable.getModel();
        lNameText.setText(dfModel.getValueAt(selectedRow, 2).toString());
        fNameText.setText(dfModel.getValueAt(selectedRow, 1).toString());
        addressText.setText(dfModel.getValueAt(selectedRow, 4).toString());
        identityNumText.setText(dfModel.getValueAt(selectedRow, 9).toString());
        salaryText.setText(dfModel.getValueAt(selectedRow, 8).toString());
        String bDate = dfModel.getValueAt(selectedRow, 3).toString();
        String[] bDateDecompose = bDate.split("-");
        bdayText.setText(bDateDecompose[2]);
        bYearText.setText(bDateDecompose[0]);
        
        String swDate = dfModel.getValueAt(selectedRow, 6).toString();
        String[] swDateDecompose = swDate.split("-");
        
        swDayText.setText(swDateDecompose[2]);
        
        swYearText.setText(swDateDecompose[0]);
        
        switch (bDateDecompose[1])
        {
            case "01":
                bDateDecompose[1] = "Tháng 1";
                break;
            case "02":
                bDateDecompose[1] = "Tháng 2";
                break;
            case "03":
                bDateDecompose[1] = "Tháng 3";
                break;
            case "04":
                bDateDecompose[1] = "Tháng 4";
                break;
            case "05":
                bDateDecompose[1] = "Tháng 5";
                break;
            case "06":
                bDateDecompose[1] = "Tháng 6";
                break;
            case "07":
                bDateDecompose[1] = "Tháng 7";
                break;
             case "08":
                bDateDecompose[1] = "Tháng 8";
                break;
            case "09":
                bDateDecompose[1] = "Tháng 9";
                break;
            case "10":
                bDateDecompose[1] = "Tháng 10";
                break;
            case "11":
                bDateDecompose[1] = "Tháng 11";
                break;
            case "12":
                bDateDecompose[1] = "Tháng 12";
                break;
            default: 
                bDateDecompose[1] = "Chọn tháng";
                       
        }
        switch (swDateDecompose[1])
        {
            case "01":
                swDateDecompose[1] = "Tháng 1";
                break;
            case "02":
                swDateDecompose[1] = "Tháng 2";
                break;
            case "03":
                swDateDecompose[1] = "Tháng 3";
                break;
            case "04":
                swDateDecompose[1] = "Tháng 4";
                break;
            case "05":
                swDateDecompose[1] = "Tháng 5";
                break;
            case "06":
                swDateDecompose[1] = "Tháng 6";
                break;
            case "07":
                swDateDecompose[1] = "Tháng 7";
                break;
             case "08":
                swDateDecompose[1] = "Tháng 8";
                break;
            case "09":
                swDateDecompose[1] = "Tháng 9";
                break;
            case "10":
                swDateDecompose[1] = "Tháng 10";
                break;
            case "11":
                swDateDecompose[1] = "Tháng 11";
                break;
            case "12":
                swDateDecompose[1] = "Tháng 12";
                break;
            default: 
                swDateDecompose[1] = "Chọn tháng";
                       
        }
        
        bMonthCombo.setSelectedItem(bDateDecompose[1]);
        swMonthCombo.setSelectedItem(swDateDecompose[1]);
        String sexValue = dfModel.getValueAt(selectedRow, 5).toString();
        if(sexValue.equals("m"))
        {
            sexValue = "Nam";
        }
        else if(sexValue.equals("f"))
        {
            sexValue = "Nữ";
        }
        else
            sexValue = "Khác";
        
        sexCombo.setSelectedItem(sexValue);
        posCombo.setSelectedItem(dfModel.getValueAt(selectedRow, 7).toString());
        
        deleteButton.setEnabled(true);
        updateButton.setEnabled(true);
        
    }//GEN-LAST:event_empTableMouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        addButton.setEnabled(true);
         empTable.getSelectionModel().clearSelection();
            lNameText.setText("");
            fNameText.setText("");
            addressText.setText("");
            identityNumText.setText("");
            salaryText.setText("");
            bdayText.setText("");
            bYearText.setText("");
            swDayText.setText("");
            swYearText.setText("");
            bMonthCombo.setSelectedItem("Chọn tháng");
            swMonthCombo.setSelectedItem("Chọn tháng");
            sexCombo.setSelectedItem("--Chọn giới tính--");
            posCombo.setSelectedItem("--Chọn chức vụ--");
            deleteButton.setEnabled(false);
            updateButton.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sexComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexComboActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            BusManagement bus = new BusManagement();
                bus.setVisible(true);
                bus.setLocationRelativeTo(null);
                //System.out.println(this.infor);
               bus.setInfor(this.infor);
              // System.out.println(bus.infor);
               this.dispose();
               
                
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
          Login log = new Login();
                log.setVisible(true);
                log.setLocationRelativeTo(null);
                //System.out.println(this.infor);
               
              // System.out.println(bus.infor);
               this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
           QLVe tick = new QLVe();
                tick.setVisible(true);
                tick.setLocationRelativeTo(null);
               // System.out.println(this.infor);
               tick.setInfor(this.infor);
               this.dispose();
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        QLChuyen route = new QLChuyen();
                route.setVisible(true);
                route.setLocationRelativeTo(null);
               // System.out.println(this.infor);
               route.setInfor(this.infor);
               this.dispose();
         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
               QLTime time = new QLTime();
                time.setVisible(true);
                time.setLocationRelativeTo(null);
               // System.out.println(this.infor);
               time.setInfor(this.infor);
               this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
         PhanCong work = new PhanCong();
                work.setVisible(true);
                work.setLocationRelativeTo(null);
               // System.out.println(this.infor);
               work.setInfor(this.infor);
               this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
         Statistic st = new Statistic();
                st.setVisible(true);
                st.setLocationRelativeTo(null);
               // System.out.println(this.infor);
               st.setInfor(this.infor);
               this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed
//    private void updateEmpTable()
//    {
//        String sql = "SELECT * FROM EMPLOYEE";
//        try{
//            Statement st = establishCon().createStatement();
//            
//            ResultSet rs = st.executeQuery(sql);
//            empTable.setModel(DbUtils.resultSetToTableModel(rs));
//            
//        }catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//        
//    }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EmployeeManagement empm = new EmployeeManagement();
                empm.setVisible(true);
                empm.setLocationRelativeTo(null);
            }
        });
    }
    
    public void setInfor(String infor)
    {
        this.infor = infor;
        this.inforText.setText(infor);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accButton;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addressText;
    private javax.swing.JComboBox<String> bMonthCombo;
    private javax.swing.JTextField bYearText;
    private javax.swing.JTextField bdayText;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTable empTable;
    private javax.swing.JButton empmButton;
    private javax.swing.JTextField fNameText;
    private javax.swing.JTextField identityNumText;
    private javax.swing.JPanel inforPanel;
    private javax.swing.JTextPane inforText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lNameText;
    private javax.swing.JComboBox<String> posCombo;
    private javax.swing.JTextField salaryText;
    private javax.swing.JComboBox<String> sexCombo;
    private javax.swing.JTextField swDayText;
    private javax.swing.JComboBox<String> swMonthCombo;
    private javax.swing.JTextField swYearText;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
