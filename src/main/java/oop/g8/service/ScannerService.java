package oop.g8.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class ScannerService {

	private Scanner scn = new Scanner(System.in);;

	public int getInputNum(int max) {
		int num;
		while (true) {
			try {
				num = scn.nextInt();
				if (num <= 0 || num > max)
					throw new Exception();
			} catch (Exception e) {
				System.out.print("Không hợp lệ, mời nhập lại: ");

				continue;
			}
			scn.nextLine();
			return num;
		}
	}

	public String getInputStr() {
		String str;
		while (true) {
			try {
				str = scn.nextLine();
			} catch (Exception e) {
				System.out.print("Không hợp lệ, mời nhập lại: ");
				continue;
			}

			return str;
		}
	}
}
