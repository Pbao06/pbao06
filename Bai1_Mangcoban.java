import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Bai1_Mangcoban
{
    public static void main(String [] args)
    {
        try
        {
            // bai tap nhap mang xuat mang xu ly mang
            Scanner sc = new Scanner(System.in);
             int[]a = new int[100];
        
            System.out.print("Nhập n: ");
            int n = sc.nextInt(); // n được khai báo tại đây
            Nhapmang(a,n,sc);
            Xuatmang(a,n);
            
            Demk(a,n,10,sc);
            Tongmang(a, n);
            LonnhatBenhat(a, n);
            Quicksort(a,n,0,n-1);
            System.out.println(" Mang sau khi quicksort tang dan: ");
            Xuatmang(a, n);
            Selectionsort_giam(a, n);
            System.out.println(" Mang sau khi giam dan:");
            Xuatmang(a, n);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void Nhapmang(int[]a,int n,Scanner sc)
    {
            for(int i=0;i<n;i++)
            {
                System.out.print("Nhap vao phan tu ["+i+"]=");
                a[i]=sc.nextInt();
            }
    }
    public static void Xuatmang(int[]a,int n)
    {
        for(int i=0;i<n;i++)
            {
                System.out.println(" " + a[i]);
            }
    }
    // neu k dc nhap tu ban phim ton tai trong mang thi check xem k bao nhieu lan 
    public static void Demk(int[]a,int n,int k,Scanner sc)
    {
        System.out.println(" Nhap vao phan tu ban muon xem no co bao nhieu lan trong mang:");
        k=sc.nextInt();
        boolean found=false;
        int dem=0;
        for(int i=0;i<n;i++)
        {
            if(a[i]==k)
            {
                dem++;
                found=true;
            }
        }
        if(!found)
        {
            System.out.println("Khong tim thay k trong mang!");
            return;
        }
        else
        {
            System.out.println(" Gia tri "+k+" xuat hien "+dem+" trong mang.");
        }
    }
    public static void Tongmang(int[]a,int n)
    {
        int tong=0;
        for(int i=0;i<n;i++)
        {
            tong+=a[i];
        }
        System.out.println(" Tong gia tri mang la:"+tong);
    }
    public static void LonnhatBenhat(int[]a,int n)
    {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
           if(a[i]>max)
           {
            max=a[i];
           }
           if(a[i]<min)
           {
            min=a[i];
           }
        }
        System.out.println("So lon nhat trong mang la :"+max);
        System.out.println("So lon be trong mang la :"+min);
    }
    // sắp xếp tăng dần giảm dânf 
    public static void swap(int i,int j)
    {
        int temp=i;
        i=j;
        j=temp;
    }
    public static void Quicksort(int []a,int n,int left,int right)
    {
        if (left >= right) return; // Điều kiện dừng đệ quy
        // lấy vị trí mid;
        int l=left;
        int r=right;
        int mid=(left+right)/2;
        int pivot=a[mid];
        while(l<r)
        {
            while(a[l]<pivot) l++;
            while(a[r]>pivot) r--;
            if(l<=r) // đk khi 2 thg  chưa vượt qua nhau 
            {
                int temp = a[l];
                a[l] = a[r];
                a[r] = temp;
                l++;
                r--;
            } 
        }
        // gọi đệ quy vì lúc này trái = left -> r, phải là l-> right
        if(left < r) Quicksort(a, n, left, r);
        if(l < right) Quicksort(a, n, l, right);
    }
    public static void Selectionsort_giam(int[]a,int n)
    {
        for(int i=0;i<n;i++)
        {
            int max=i;
            for(int j=i+1;j<n;j++)
            {
                if(a[j]>a[max])
                {
                    max=j;
                }
            }
            if(i!=max)
            {
                int temp=a[i];
                a[i]=a[max];
                a[max]=temp;
            }
        }
    }
}