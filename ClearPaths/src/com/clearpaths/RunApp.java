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
		final String hdd = "C:"; // сделать выбираемым параметром (GUI)
		String pathDir1 = "C:\\VIDEO\\PM\\Video\\Record\\"; // сделать выбираемым параметром (GUI)
		String pathDir2 = "C:\\VIDEO\\ZAL\\Video\\Record\\";
		// C:\VIDEO\ZAL\Video\Record //сделать выбираемым параметром (GUI)

		File f = new File(hdd);

		long freeSpace_GB = f.getFreeSpace() / 1073741824;
		long totalSpace_GB = f.getTotalSpace() / 1073741824;
		long freeSpaceControl = 50; // сделать выбираемым параметром (GUI)

		// System.out.println("getAbsolutePath(): "+f.getAbsolutePath());
	//	System.out.println("getFreeSpace(): " + freeSpace_GB);
	//	System.out.println("getTotalSpace(): " + totalSpace_GB);
		// System.out.println("getUsableSpace(): "+f.getUsableSpace());

		if (freeSpace_GB < freeSpaceControl) {
			// need run clear VIDEO
			// System.out.println("на диске < 50 Гб");
			JOptionPane.showMessageDialog(null,
					"На диске " + hdd + " меньше "+freeSpaceControl+" Гб! (" + freeSpace_GB + " Гб). Запущена очистка диска");

			// надо запускать очистку папок

			// Settings sets = new Settings();

			// получаем текущую дату и дату до которой надо удалить папки

			Date today = new Date(); // текущая дата
			Calendar calMinus5 = Calendar.getInstance();
			calMinus5.add(Calendar.DATE, -5);
			Date dateMinus5 = calMinus5.getTime();

			// *******************************************************************************
			File dir1 = new File(pathDir1); // "C:\\VIDEO\\PM\\Video\\Record\\"
			if ((dir1.exists()) && (dir1.isDirectory())) {

				// далее цикл по содержимому папки
				// отбираем папки, у которых дата модификации < -5 дней от текущей даты и
				// удаляем их
				for (File f1 : dir1.listFiles()) {
					long lastModify = f1.lastModified();
					if (lastModify < dateMinus5.getTime()) {
						// рекурсивный вызов
						recursiveDelete(f1);
					}
				}
			}

			File dir2 = new File(pathDir2); // "C:\\VIDEO\\ZAL\\Video\\Record"
			if ((dir2.exists()) && (dir2.isDirectory())) {

				// далее цикл по содержимому папки
				// отбираем папки, у которых дата модификации < -5 дней от текущей даты и
				// удаляем их
				for (File f2 : dir2.listFiles()) {
					long lastModify = f2.lastModified();
					if (lastModify < dateMinus5.getTime()) {
						// рекурсивный вызов
						recursiveDelete(f2);
					}
				}
			}			

			// *******************************************************************************

		}
	}

	void recursiveDelete(File file) {
		// до конца рекурсивного цикла
		if (!file.exists()) {
			return;
		}

		// если это папка, то идем внутрь этой папки и вызываем рекурсивное удаление
		// всего, что там есть
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				// рекурсивный вызов
				recursiveDelete(f);
			}
		}
		// вызываем метод delete() для удаления файлов и пустых(!) папок
		 file.delete(); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//System.out.println("Удаленный файл или папка: " + file.getAbsolutePath());
	}
}
