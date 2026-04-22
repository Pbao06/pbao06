import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
public class Hello
{
	public static void main(String [] args)
	{
		while(true)
		{
			Scanner sc = new Scanner(System.in);
        Random rd = new Random();
		int so=rd.nextInt(100)+1; // ham doan so random
		boolean win=false;
		int luotchoi=7;
		System.out.print("Game nay doan so 1 -> 100 !");
		System.out.print("Doan sai 7 lan la cook nhe: ");
		while(luotchoi>0)
		{
			try
			{
				System.out.print(" Nhap vao de doan so tu 1 den 100:");
			int doan=sc.nextInt();
			if(doan==so)
			{
				System.out.print(" Kinh dey! , trung roi");
				win=true;
				break;
			}
			else if(doan >so)
			{
				System.out.print(" So bi mat nho hon so nay: goi y ");
			}
			else if(doan < so)
			{
				System.out.print("So bi mat > so nay!: goi y");
			}
			luotchoi--;
			}
			catch(InputMismatchException e)
			{
				System.out.println(" Sai roi");
				break;
			}
		}
		if(!win)
		{
			System.out.print(" Ngu qua co the doan cung ko xong!");
			System.out.print(" So bi mat la : " + so);
		}
		Scanner sc2=new Scanner(System.in);
		System.out.print(" Ban co muon choi tiep khong neu khong thi nhan N con neu Choi tiep thi Nhan bat ki ki tu:");
		String choitiep=sc2.nextLine();
		if(choitiep.equals("N"))
		{
			break;
		}
		}
	}
}
