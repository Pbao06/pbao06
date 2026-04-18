package Quanly;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ten: ");
		String a=sc.nextLine();
		System.out.println(" NHap vao nam sinh cua ban: ");
		int ns=sc.nextInt();
		int kq=2026-ns;
		
		sc.close();
		
		System.out.println(a);
		System.out.println(" Tuoi cua ban la : "+ kq);

	}
	
}
