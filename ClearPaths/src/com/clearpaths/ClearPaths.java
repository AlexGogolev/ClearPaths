package com.clearpaths;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.io.File;

public class ClearPaths {

	private JFrame frmClearPaths;
	private JTextField txtMinSpace;
	private JTextField txtCountDays;
	private JTable table;
	private JComboBox<String> comboBoxDisks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClearPaths window = new ClearPaths();
					window.frmClearPaths.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClearPaths() {
		initialize();
		initalizeSomeValue();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClearPaths = new JFrame();
		frmClearPaths.setTitle("\u041D\u0430\u0441\u0442\u0440\u043E\u0439\u043A\u0430 Clear Paths");
		frmClearPaths.setBounds(100, 100, 436, 331);
		frmClearPaths.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClearPaths.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u0414\u0438\u0441\u043A:");
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		label.setBounds(10, 11, 50, 14);
		frmClearPaths.getContentPane().add(label);
		
		comboBoxDisks = new JComboBox();
		comboBoxDisks.setBounds(229, 11, 86, 20);
		frmClearPaths.getContentPane().add(comboBoxDisks);
		
		JLabel label_1 = new JLabel("\u041C\u0438\u043D. \u043E\u0431\u044A\u0435\u043C \u0434\u0438\u0441\u043A\u0430 (\u0413\u0431):");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_1.setBounds(10, 36, 190, 14);
		frmClearPaths.getContentPane().add(label_1);
		
		txtMinSpace = new JTextField();
		txtMinSpace.setBounds(229, 36, 86, 20);
		frmClearPaths.getContentPane().add(txtMinSpace);
		txtMinSpace.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u0423\u0434\u0430\u043B\u0438\u0442\u044C \u0444\u0430\u0439\u043B\u044B \u0438 \u043F\u0430\u043F\u043A\u0438 \u0434\u043E (\u0434\u043D\u0435\u0439):");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 61, 209, 14);
		frmClearPaths.getContentPane().add(lblNewLabel);
		
		txtCountDays = new JTextField();
		txtCountDays.setBounds(229, 61, 86, 20);
		frmClearPaths.getContentPane().add(txtCountDays);
		txtCountDays.setColumns(10);
		
		JLabel label_2 = new JLabel("\u041E\u0447\u0438\u0449\u0430\u0435\u043C\u044B\u0435 \u043F\u0430\u043F\u043A\u0438:");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_2.setBounds(10, 86, 133, 14);
		frmClearPaths.getContentPane().add(label_2);
		
		JButton btnAdd = new JButton("+");
		btnAdd.setBounds(369, 114, 41, 23);
		frmClearPaths.getContentPane().add(btnAdd);
		
		JButton btnDel = new JButton("-");
		btnDel.setBounds(369, 142, 41, 23);
		frmClearPaths.getContentPane().add(btnDel);
		
		table = new JTable();
		table.setFont(new Font("Dialog", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		table.setBounds(10, 111, 348, 82);
		frmClearPaths.getContentPane().add(table);
		
		JLabel label_3 = new JLabel("\u0421\u043E\u0441\u0442\u043E\u044F\u043D\u0438\u0435 \u0441\u043B\u0443\u0436\u0431\u044B:");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 12));
		label_3.setBounds(10, 201, 123, 16);
		frmClearPaths.getContentPane().add(label_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1.setBounds(132, 201, 226, 16);
		frmClearPaths.getContentPane().add(lblNewLabel_1);
		
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnStart.setBounds(109, 221, 98, 26);
		frmClearPaths.getContentPane().add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnStop.setBounds(217, 221, 98, 26);
		frmClearPaths.getContentPane().add(btnStop);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnApply.setBounds(161, 256, 98, 26);
		frmClearPaths.getContentPane().add(btnApply);
	}
	
	private void initalizeSomeValue() {
		
		File[] roots = File.listRoots();
		for (File file: roots) {
		    System.out.println(file.getAbsolutePath());
		    String name = file.getPath();
		    comboBoxDisks.addItem(name);
		}
		
		
	}
}
