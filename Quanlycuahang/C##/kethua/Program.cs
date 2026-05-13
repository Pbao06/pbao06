// See https://aka.ms/new-console-template for more information
using System;
class Program()
{
    static void Main()
    {
        List<int> a=new();
        a.Add(100);
        a.Add(430);
        a.Add(50);
        Console.WriteLine(a[0]);
        Console.WriteLine(a.Count);
        a.Insert(0,23);
        foreach(int x in a) // a la tung phan tu trong list a 
        {
            Console.WriteLine(x);
        }
        // List <int> b=new();
        // Console.Write(" Nhap so luong phan tu trong mang:");
        // int n=int.Parse(Console.ReadLine());
        // for(int i=0;i<n;i++)
        // {
        //     Console.Write($" Nhap phan tu thu {i}:");
        //     int x=int.Parse(Console.ReadLine());
        //     b.Add(x);
        // }
        // Console.WriteLine(" EVEN NUMBERS IN LIST : ");
        // foreach(int bb in b)
        // {
        //         Console.WriteLine(bb);
        // }
        // b.RemoveAt(0,1);
        
    }
}