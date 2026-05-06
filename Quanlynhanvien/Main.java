package Quanlynhanvien;
public class Main {
    public static void main(String[] args)
    {
        nhanvien nv1=new nhanvien(" Phan Gia "," Bao",544);
        nhanvien nv2=new nhanvien(" Nguyen Bao "," Thu",432);
        System.out.println("Luong cua ban Bao la :"+nv1.getluong());
        System.out.println("Luong cua ban Thu la :"+nv2.getluong());
        if(Lonhon(nv1,nv2))
        {
            System.out.println(" San pham nhan vien Bao > nhan vien Thu");
        }
        else
        {
             System.out.println(" San pham nhan vien Thu > nhan vien Bao");
        }

    }
    public static boolean Lonhon(nhanvien a ,nhanvien b)
    {
        if(a.get_sp() > b.get_sp())
        {
            return true;
        }
        return false;
    }
}
