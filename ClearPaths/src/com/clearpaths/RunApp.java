package com.clearpaths;
import java.io.File;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class RunApp {

	public static void main(String[] args) {
		new RunApp();
	}
		
	public RunApp() {
		go();
	}

	void go() {
		final String hdd = "C:"; // ������� ���������� ���������� (GUI)
		String pathDir1 = "C:\\VIDEO\\PM\\Video\\Record\\"; // ������� ���������� ���������� (GUI)
		String pathDir2 = "C:\\VIDEO\\ZAL\\Video\\Record\\";
		// C:\VIDEO\ZAL\Video\Record //������� ���������� ���������� (GUI)

		File f = new File(hdd);

		long freeSpace_GB = f.getFreeSpace() / 1073741824;
		long totalSpace_GB = f.getTotalSpace() / 1073741824;
		long freeSpaceControl = 50; // ������� ���������� ���������� (GUI)

		// System.out.println("getAbsolutePath(): "+f.getAbsolutePath());
	//	System.out.println("getFreeSpace(): " + freeSpace_GB);
	//	System.out.println("getTotalSpace(): " + totalSpace_GB);
		// System.out.println("getUsableSpace(): "+f.getUsableSpace());

		if (freeSpace_GB < freeSpaceControl) {
			// need run clear VIDEO
			// System.out.println("�� ����� < 50 ��");
			JOptionPane.showMessageDialog(null,
					"�� ����� " + hdd + " ������ "+freeSpaceControl+" ��! (" + freeSpace_GB + " ��). �������� ������� �����");

			// ���� ��������� ������� �����

			// Settings sets = new Settings();

			// �������� ������� ���� � ���� �� ������� ���� ������� �����

			Date today = new Date(); // ������� ����
			Calendar calMinus5 = Calendar.getInstance();
			calMinus5.add(Calendar.DATE, -5);
			Date dateMinus5 = calMinus5.getTime();

			// *******************************************************************************
			File dir1 = new File(pathDir1); // "C:\\VIDEO\\PM\\Video\\Record\\"
			if ((dir1.exists()) && (dir1.isDirectory())) {

				// ����� ���� �� ����������� �����
				// �������� �����, � ������� ���� ����������� < -5 ���� �� ������� ���� �
				// ������� ��
				for (File f1 : dir1.listFiles()) {
					long lastModify = f1.lastModified();
					if (lastModify < dateMinus5.getTime()) {
						// ����������� �����
						recursiveDelete(f1);
					}
				}
			}

			File dir2 = new File(pathDir2); // "C:\\VIDEO\\ZAL\\Video\\Record"
			if ((dir2.exists()) && (dir2.isDirectory())) {

				// ����� ���� �� ����������� �����
				// �������� �����, � ������� ���� ����������� < -5 ���� �� ������� ���� �
				// ������� ��
				for (File f2 : dir2.listFiles()) {
					long lastModify = f2.lastModified();
					if (lastModify < dateMinus5.getTime()) {
						// ����������� �����
						recursiveDelete(f2);
					}
				}
			}			

			// *******************************************************************************

		}
	}

	void recursiveDelete(File file) {
		// �� ����� ������������ �����
		if (!file.exists()) {
			return;
		}

		// ���� ��� �����, �� ���� ������ ���� ����� � �������� ����������� ��������
		// �����, ��� ��� ����
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				// ����������� �����
				recursiveDelete(f);
			}
		}
		// �������� ����� delete() ��� �������� ������ � ������(!) �����
		 file.delete(); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//System.out.println("��������� ���� ��� �����: " + file.getAbsolutePath());
	}
}
