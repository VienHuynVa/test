package Cau2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Cau2 extends JFrame implements ActionListener {
	private JPanel mainPanel, p1, p2, p3, p4, p5;
	private JRadioButton rbtHS, rbtSV, rbtKS;
	private JCheckBox cbDB, cbDS, cbNN;
	private ButtonGroup bg;
	private JLabel lb1, lb2;
	private JComboBox cbb;
	private String[] hocSinh = { "Phân ban", "Không phân ban" };
	private String[] sinhVien = { "Kỹ thuật", "Xã hội" };
	private String[] kySu = { "Cơ khí", "CNTT" };
	private String name = "";
	private String thuocTinh = "";
	private String docBao = "Đọc báo";
	private String docSach = "Đọc sách";
	private String ngheNhac = "Nghe nhạc";
	private String soThich = "";

	public Cau2() {
		// create
		add(mainPanel = createPanel(), BorderLayout.CENTER);
		add(p5 = new JPanel(new BorderLayout(0, 0)), BorderLayout.SOUTH);
		p5.add(lb2 = new JLabel(""));
		p5.setBackground(Color.white);
		p5.setLayout(new FlowLayout());
		p5.setPreferredSize(new Dimension(getWidth(), 30));
		// dislayJframe
		dislay();
	}

	private JPanel createPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		// row1
		mainPanel.add(p1 = new JPanel());
		p1.add(lb1 = new JLabel("Nghề nghiệp"));
		p1.add(cbb = new JComboBox(hocSinh));
		lb1.setPreferredSize(new Dimension(180, 20));
		cbb.setPreferredSize(new Dimension(180, 25));

		// row2
		mainPanel.add(p2 = new JPanel());
		p2.add(rbtHS = new JRadioButton("Học sinh"));
		p2.add(cbDB = new JCheckBox("Đọc báo"));
		rbtHS.setPreferredSize(new Dimension(180, 20));
		cbDB.setPreferredSize(new Dimension(180, 20));

		// row3
		mainPanel.add(p3 = new JPanel());
		p3.add(rbtSV = new JRadioButton("Sinh Viên"));
		p3.add(cbDS = new JCheckBox("Đọc sách"));
		rbtSV.setPreferredSize(new Dimension(180, 20));
		cbDS.setPreferredSize(new Dimension(180, 20));

		// row4
		mainPanel.add(p4 = new JPanel());
		p4.add(rbtKS = new JRadioButton("Kỹ sư"));
		p4.add(cbNN = new JCheckBox("Nghe nhạc"));
		rbtKS.setPreferredSize(new Dimension(180, 20));
		cbNN.setPreferredSize(new Dimension(180, 20));

		// button group
		bg = new ButtonGroup();
		bg.add(rbtHS);
		bg.add(rbtSV);
		bg.add(rbtKS);

		// addaction
		name = "Học sinh";
		thuocTinh = "Phân ban";
		rbtHS.setSelected(true);
		rbtHS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cbb.removeAllItems();
				cbb.addItem(hocSinh[0]);
				cbb.addItem(hocSinh[1]);
				cbb.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						thuocTinh = (String) cbb.getSelectedItem();
						lb2.setText(toSTring());
					}
				});
				name = "Học sinh";
				lb2.setText(toSTring());
			}
		});
		rbtSV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cbb.removeAllItems();
				cbb.addItem(sinhVien[0]);
				cbb.addItem(sinhVien[1]);
				thuocTinh = "Kỹ thuật";
				cbb.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						thuocTinh = (String) cbb.getSelectedItem();
						lb2.setText(toSTring());
					}
				});
				name = "Sinh viên";
				lb2.setText(toSTring());
			}
		});
		rbtKS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cbb.removeAllItems();
				cbb.addItem(kySu[0]);
				cbb.addItem(kySu[1]);
				thuocTinh = "Cơ khí";
				cbb.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						thuocTinh = (String) cbb.getSelectedItem();
						lb2.setText(toSTring());
					}
				});
				name = "Kỹ sư";
				lb2.setText(toSTring());
			}
		});
		cbDB.addActionListener(this);
		cbDS.addActionListener(this);
		cbNN.addActionListener(this);

		return mainPanel;
	}

	public String toSTring() {
		String result = "";
		result = name + " " + thuocTinh + " thích: " + soThich;
		return result;
	}

	private void dislay() {
		setTitle("Input Frame");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		Cau2 test = new Cau2();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (cbDB.isSelected()) {
			soThich = "Đọc báo";
		}
		if (cbDS.isSelected()) {
			soThich = "Đọc sách";
		}
		if (cbNN.isSelected()) {
			soThich = "Nghe nhạc";
		}
		if (cbNN.isSelected() && cbDS.isSelected()) {
			soThich = "Đọc sách, Nghe nhạc.";
		}
		if (cbDS.isSelected() && cbDB.isSelected()) {
			soThich = "Đọc báo, Đọc sách";
		}
		if (cbNN.isSelected() && cbDB.isSelected()) {
			soThich = "Đọc báo, Nghe nhạc";
		}
		if (cbNN.isSelected() && cbDS.isSelected() && cbDB.isSelected()) {
			soThich = "Đọc báo, Đọc sách, Nghe nhạc.";
		}
		lb2.setText(toSTring());
	}
}
