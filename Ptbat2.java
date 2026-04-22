package Quanly;

import java.util.Scanner;

public class Ptbat2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// ax binh + bx + c =0
		System.out.println(" Nhap vao he so A : ");
		double a= sc.nextDouble();
		System.out.println(" Nhap vao he so B: ");
		double b= sc.nextDouble();
		System.out.println(" Nhap vao he so C: ");
		double c= sc.nextDouble();
		if(a==0) // pt => bật 1 
		{
			if(b==0)
			{
				double x=-c/b;
				if(c==0)
				{
					System.out.println(" Pt vo so  ngiem");
				}
				else
				{
					System.out.println(" Pt vo nghiem");
				}
				System.out.println(" nghiem pt : " + x);

			}
			
		}
		else
		{
			double delta=b*b-4*a*c;
			if(delta <0)
			{
				System.out.println(" Phuong trinh vo so nghiem ");
			}
			else if( delta ==0)
			{
				double x=-b/2*a;
			}
			else
			{
				double x1 = (-b + Math.sqrt(delta)) / (2 * a);
				double x2 = (-b - Math.sqrt(delta)) / (2 * a);
				System.out.println(" nghiem x1 la :  " + x1 + " nghiem x2 la "+ x2);
			}
		}
	}

}
