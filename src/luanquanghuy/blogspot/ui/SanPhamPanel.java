package luanquanghuy.blogspot.ui;

import luanquanghuy.blogspot.io.FileFactory;
import luanquanghuy.blogspot.io.SerializeFileFactory;
import luanquanghuy.blogspot.module.SanPham;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SanPhamPanel {
    private JPanel panel1;
    private JTable tableSanPham;
    private DefaultTableModel tableModelSanPham;
    private JTextField txtSanPham;
    private JTextField txtSoLuong;
    private JTextField txtGia;
    private JButton xuấtButton;
    private JButton nhậpButton;
    private JButton thêmSảnPhẩmButton;
    private JButton xóaButton;
    private JButton sửaButton;

    List<SanPham> database = new ArrayList<>();

    public SanPhamPanel() {

        tableSanPham.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = tableSanPham.getSelectedRow();
                String ten = tableSanPham.getValueAt(row, 0).toString();
                int soLuong = Integer.parseInt(tableSanPham.getValueAt(row, 1).toString());
                int gia = Integer.parseInt(tableSanPham.getValueAt(row, 2).toString());
                txtSanPham.setText(ten);
                txtSoLuong.setText( soLuong + "");
                txtGia.setText(gia+"");
            }
        });
        thêmSảnPhẩmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<String> vector = new Vector<>();
                vector.add(txtSanPham.getText());
                vector.add(txtSoLuong.getText()+"");
                vector.add(txtGia.getText()+"");
                tableModelSanPham.addRow(vector);
                SanPham sp = new SanPham();
                sp.setTenSanPham(txtSanPham.getText());
                sp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
                sp.setGia(Integer.parseInt(txtGia.getText()));
                database.add(sp);
                for (int i=0; i<database.size(); i++ ){
                    System.out.print("Save");
                    System.out.println(database.get(i).getTenSanPham());
                }
            }
        });
        sửaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtSanPham.setEditable(true);
                int row = tableSanPham.getSelectedRow();
                tableSanPham.setValueAt(txtSanPham.getText(), row, 0);
                tableSanPham.setValueAt(txtSoLuong.getText(), row, 1);
                tableSanPham.setValueAt(txtGia.getText(), row, 2);
            }
        });
        xóaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ten = tableSanPham.getValueAt(tableSanPham.getSelectedRow(), 0).toString();
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn xóa "+ten+"?");
                // confirm = 0: yes
                // confirm = -1: no
                // confim = 1: X
                if ( confirm == 0) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công sản phẩm \n" + ten);
                    tableModelSanPham.removeRow(tableSanPham.getSelectedRow());
                }
            }
        });
    }
    public void showDataOnJTable(){
        tableModelSanPham.setRowCount(0);
        for (int i=0; i<database.size(); i++){
            SanPham sanPham = database.get(i);
            Vector<String> vector = new Vector<>();
            vector.add(sanPham.getTenSanPham());
            vector.add(sanPham.getSoLuong()+"");
            vector.add(sanPham.getGia()+"");
            tableModelSanPham.addRow(vector);
        }
    }

    private void createUIComponents() {
        tableModelSanPham = new DefaultTableModel();
        tableModelSanPham.addColumn("Tên sản phẩm");
        tableModelSanPham.addColumn("Số lượng");
        tableModelSanPham.addColumn("Giá tiền");
        tableSanPham = new JTable(tableModelSanPham);
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
