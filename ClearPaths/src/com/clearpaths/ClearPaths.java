package com.clearpaths;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ClearPaths {

	private JFrame frmClearPaths;
	private JTextField txtFieldMinSpace;
	private JTextField txtCountDays;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClearPaths = new JFrame();
		frmClearPaths.setTitle("\u041D\u0430\u0441\u0442\u0440\u043E\u0439\u043A\u0430 Clear Paths");
		frmClearPaths.setBounds(100, 100, 450, 300);
		frmClearPaths.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClearPaths.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u0414\u0438\u0441\u043A:");
		label.setBounds(10, 11, 29, 14);
		frmClearPaths.getContentPane().add(label);
		
		JComboBox comboBoxDisks = new JComboBox();
		comboBoxDisks.setBounds(193, 8, 72, 20);
		frmClearPaths.getContentPane().add(comboBoxDisks);
		
		JLabel label_1 = new JLabel("\u041C\u0438\u043D. \u043E\u0431\u044A\u0435\u043C \u0434\u0438\u0441\u043A\u0430 (\u0413\u0431):");
		label_1.setBounds(10, 36, 127, 14);
		frmClearPaths.getContentPane().add(label_1);
		
		txtFieldMinSpace = new JTextField();
		txtFieldMinSpace.setBounds(193, 33, 86, 20);
		frmClearPaths.getContentPane().add(txtFieldMinSpace);
		txtFieldMinSpace.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u0423\u0434\u0430\u043B\u0438\u0442\u044C \u0444\u0430\u0439\u043B\u044B \u0438 \u043F\u0430\u043F\u043A\u0438 \u0434\u043E (\u0434\u043D\u0435\u0439):");
		lblNewLabel.setBounds(10, 61, 190, 14);
		frmClearPaths.getContentPane().add(lblNewLabel);
		
		txtCountDays = new JTextField();
		txtCountDays.setBounds(193, 58, 86, 20);
		frmClearPaths.getContentPane().add(txtCountDays);
		txtCountDays.setColumns(10);
	}
}
