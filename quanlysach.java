import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class quanlysach

{

    public static void main(String[]args )
    {
        Scanner sc=new Scanner(System.in);
        HashMap<String,Integer> Books=new HashMap<>();
        System.out.println(" Nhap vao so luong book co trong ds:");
        int n=sc.nextInt();
        sc.nextLine(); // Chống trôi lệnh sau khi nhập số
        for(int i=0;i<n;i++)
        {
            System.out.println("Nhap vao sach thu"+i+":");
            System.out.print(" + Nhap vao ten sach:");
            String name=sc.nextLine();
            System.out.println(" + Nhap vao ma sach:");
            int id=sc.nextInt();
            Books.put(name,id);
        }
        int count=1;
        for(Map.Entry<String,Integer> entry :Books.entrySet()) // gom vao tung entry (key,value)
        {
            System.out.println("Sach thu "+count+" la:"+" Name:"+entry.getKey()+" Id: "+entry.getValue());
            count++;
        }
        // sửa xóa tìm kiếm 
        Update(Books,sc);
        Delete(Books, sc);
        Search(Books,sc);

    }
    public static void Update(HashMap<String,Integer> books,Scanner sc)
    {
        // nhập vào tên or key or name 
        System.out.println(" Nhap vao ten sach ban muon sua:");
        String editname=sc.nextLine();
        if(books.containsKey(editname))
        {
            System.out.print(" Nhap lai id moi:");
            int newid=sc.nextInt();
            sc.nextLine();
            books.replace(editname, newid);
            System.out.println(" Update thanh cong");
        }
        else
        {
            System.out.print(" Khong tim thay ten sach");
        }
    }
    public static void Delete(HashMap<String,Integer> books,Scanner sc)
    {
        System.out.println(" Nhap vao ten sach muon xoa");
        String editname=sc.nextLine();
        if(books.containsKey(editname))
        {
            books.remove(editname);
        }
        else
        {
            System.out.println(" Khong tim thay sach de xoa ");
        }
    }
    public static void Search(HashMap<String,Integer> books,Scanner sc)
    {
        System.out.println(" Nhap vao ten sach can tim trong mang:");
        String search_name=sc.nextLine();
        if(books.containsKey(search_name))
        {
            System.out.print(" Sach co ton tai");
        }
        else
        {
            System.out.print(" Khong co trong ds");
        }


    }
}