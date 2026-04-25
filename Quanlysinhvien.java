import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Quanlysinhvien {
    public static class sinhvien
 {
    int id;
    String name;
    double dtb;
}
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);

        ArrayList<sinhvien> ds_sv= new ArrayList<>();
        while(true)
        {
            System.out.println(" 1. add student");
            System.out.println(" 2. Output list student");
            System.out.println(" 3. Fix name student");
            System.out.println(" 4. Delete any student got name");
            System.out.println(" 5. Find student got name 'An'.");
            System.out.println(" 6. Sort list student.");
            System.out.println(" 6. output count student.");
            System.out.print(" Nhap vao lua chon cua ban:");
            int chon=sc.nextInt();
            switch(chon)
            {
                case 1: 
                sinhvien a=new sinhvien();
                Themthongtin(a, sc);
                ds_sv.add(a);
                break;
                case 2:
                    System.out.print(" Danh sach sinh vien:");
                    for(sinhvien x: ds_sv)
                    {
                        Xuatthongtin(x);
                    }
                break;
                case 3:// sửa sinh viên 
                System.out.print("Nhap vao id sinh vien can sua:");
                int _id=sc.nextInt();
                boolean found=false;
                for(int i=0;i<ds_sv.size();i++)
                {
                    if( ds_sv.get(i).id==_id)
                    {
                        sinhvien svmoi=new sinhvien();
                        Themthongtin(svmoi,sc);
                        ds_sv.set(i,svmoi); // ghi đè thông tin vào đúng vị trí
                        found=true;
                        System.out.println("Đã ghi đè thành công!");
                    }
                }
                if(!found)
                {
                    System.out.println("Khong tim thay sinh vien");
                }
                break;
                case 4:  // xóa sinhvien với tên bất k
                Random rd=new Random();
                int index=rd.nextInt(ds_sv.size());
                System.out.println(" Da xoa 1 sinh vien thanh cong");
                break;
                case 5: 
                System.out.println(" Nhap vao ten muon xoa:");
                String _name=sc.nextLine();
                ds_sv.removeIf(s-> s.name== _name);
                System.out.println(" Xoa thanh cong");
                break;
                case 6: // sort theo điểm
                for(int i=0;i<ds_sv.size();i++)
                {
                    int min=i;
                    for(int j=i+1;j<ds_sv.size();j++)
                    {
                        if(ds_sv.get(j).dtb < ds_sv.get(min).dtb)
                        {
                            min=j;
                        }
                    }
                    if(i!=min)
                    {
                        sinhvien c= new sinhvien();
                         c=ds_sv.get(i);
                        ds_sv.set(i,ds_sv.get(min));
                        ds_sv.set(min,c);
                    }
                }
            }
        }
    }
    public static void Themthongtin(sinhvien a, Scanner sc)
    {
        System.out.print(" Nhap id:");
        a.id=sc.nextInt();
        sc.nextLine(); // 
        System.out.print(" Nhap name:");
        a.name=sc.nextLine();
        System.out.print(" Nhap Diem trung binh:");
        a.dtb=sc.nextDouble();
    }
    public static void Xuatthongtin(sinhvien a)
    {
        System.out.println(" id: "+a.id);
        System.out.println(" name:"+a.name);
        System.out.println(" Diem trung binh:"+a.dtb);
    }
}
