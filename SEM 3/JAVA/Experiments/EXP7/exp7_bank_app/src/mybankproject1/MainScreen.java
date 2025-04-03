package mybankproject1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Vector;

public class MainScreen extends JFrame {
    private JTextField txtcuid, txtname, txtamount, txtbalance, txtdate;
    private JTextArea jTextArea1;
    private JList<String> lsttype;
    private JTable jTable1;
    private JButton cmdview, cmdviewall, jButton1, addCustomer;

    public MainScreen() {
        setTitle("Bank Management System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Initialize and add labels and text fields

        JLabel lblCustId = new JLabel("Customer ID:");
        lblCustId.setBounds(10, 10, 100, 25);
        add(lblCustId);

        txtcuid = new JTextField();
        txtcuid.setBounds(120, 10, 150, 25);
        add(txtcuid);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(10, 50, 100, 25);
        add(lblName);

        txtname = new JTextField();
        txtname.setBounds(120, 50, 150, 25);
        add(txtname);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(10, 90, 100, 25);
        add(lblAddress);

        jTextArea1 = new JTextArea();
        jTextArea1.setBounds(120, 90, 150, 60);
        add(jTextArea1);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setBounds(10, 160, 100, 25);
        add(lblDate);

        txtdate = new JTextField();
        txtdate.setBounds(120, 160, 150, 25);
        add(txtdate);

        JLabel lblAmount = new JLabel("Amount:");
        lblAmount.setBounds(10, 200, 100, 25);
        add(lblAmount);

        txtamount = new JTextField();
        txtamount.setBounds(120, 200, 150, 25);
        add(txtamount);

        JLabel lblBalance = new JLabel("Balance:");
        lblBalance.setBounds(10, 240, 100, 25);
        add(lblBalance);

        txtbalance = new JTextField();
        txtbalance.setBounds(120, 240, 150, 25);
        add(txtbalance);

        JLabel lblType = new JLabel("Type:");
        lblType.setBounds(10, 280, 100, 25);
        add(lblType);

        String[] types = {"Savings", "Current"};
        lsttype = new JList<>(types);
        lsttype.setBounds(120, 280, 150, 50);
        add(lsttype);

        cmdview = new JButton("View Customer");
        cmdview.setBounds(300, 10, 150, 30);
        add(cmdview);

        cmdviewall = new JButton("View All");
        cmdviewall.setBounds(300, 50, 150, 30);
        add(cmdviewall);

        jButton1 = new JButton("Clear");
        jButton1.setBounds(300, 90, 150, 30);
        add(jButton1);

        addCustomer = new JButton("Add Customer");
        addCustomer.setBounds(300, 130, 150, 30);
        add(addCustomer);

        jTable1 = new JTable();
        JScrollPane scrollPane = new JScrollPane(jTable1);
        scrollPane.setBounds(10, 350, 760, 200);
        add(scrollPane);

        cmdview.addActionListener(this::cmdviewActionPerformed);
        cmdviewall.addActionListener(this::cmdviewallActionPerformed);
        jButton1.addActionListener(this::jButton1ActionPerformed);
        addCustomer.addActionListener(this::addCustomerActionPerformed);
    }


    private void cmdviewActionPerformed(ActionEvent evt) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/yamin", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from bank where custid=" + txtcuid.getText());

            DefaultTableModel dm = new DefaultTableModel(0, 0);
            String[] header = new String[]{"CustId", "Name", "Address", "Date", "Type", "Amount", "Balance"};
            dm.setColumnIdentifiers(header);
            jTable1.setModel(dm);

            while (rs.next()) {
                Vector<Object> data = new Vector<>();
                data.add(rs.getInt(1));
                data.add(rs.getString(2));
                data.add(rs.getString(3));
                data.add(rs.getString(4));
                data.add(rs.getString(5));
                data.add(rs.getDouble(6));
                data.add(rs.getDouble(7));
                dm.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cmdviewallActionPerformed(ActionEvent evt) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/yamin",
                    "root",
                    "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from bank");

            DefaultTableModel dm = new DefaultTableModel(0, 0);
            String[] header = new String[]{"CustId", "Name", "Address", "Date", "Type", "Amount", "Balance"};
            dm.setColumnIdentifiers(header);
            jTable1.setModel(dm);

            while (rs.next()) {
                Vector<Object> data = new Vector<>();
                data.add(rs.getInt(1));
                data.add(rs.getString(2));
                data.add(rs.getString(3));
                data.add(rs.getString(4));
                data.add(rs.getString(5));
                data.add(rs.getDouble(6));
                data.add(rs.getDouble(7));
                dm.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        txtcuid.setText("");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    }

    private void addCustomerActionPerformed(ActionEvent evt) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/yamin",
                    "root", "");
            PreparedStatement ps = con.prepareStatement("INSERT INTO bank (name, address, date, type, amount, balance) VALUES (?, ?, ?, ?, ?, ?)");

            if (txtname.getText().isEmpty() || jTextArea1.getText().isEmpty() || txtdate.getText().isEmpty() ||
                    lsttype.getSelectedValue() == null || txtamount.getText().isEmpty() || txtbalance.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                return;
            }

            ps.setString(1, txtname.getText());
            ps.setString(2, jTextArea1.getText());
            ps.setString(3, txtdate.getText());
            ps.setString(4, lsttype.getSelectedValue());
            ps.setDouble(5, Double.parseDouble(txtamount.getText()));
            ps.setDouble(6, Double.parseDouble(txtbalance.getText()));

            ps.executeUpdate();

            txtname.setText("");
            jTextArea1.setText("");
            txtdate.setText("");
            txtamount.setText("");
            txtbalance.setText("");
            lsttype.clearSelection();

            JOptionPane.showMessageDialog(null, "Customer added successfully!");

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input in numeric fields.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainScreen().setVisible(true);
        });
    }
}
