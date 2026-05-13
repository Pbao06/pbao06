// See https://aka.ms/new-console-template for more information
using System;
using System.Collections.Generic;
namespace _sinhvien
{
    class Program
    {
        static void Main()
        {
            listsv ls=new listsv();
            ls.enterlist();
            ls.releaselist();
            double diem;
            Console.Write(" Nhap vao check dk < diem can xoa: ");
            diem=double.Parse(Console.ReadLine());
            ls.Removegpa(diem);
            ls.releaselist();
            Console.WriteLine();
            ls.whereSelect();
            ls.truyvantim();
            //List<string> names=ls.Getnames();
            // Console.WriteLine("\n\t=== Sau khi get name ===="); 
            // foreach(var name in names)
            // {
            //     Console.WriteLine(name);
            // }
            // List<double> Diem=ls.Getdiems();
            //  Console.WriteLine("\n\t=== Sau khi get Diem ===="); 
            // foreach(double gg in Diem)
            // {
            //     Console.WriteLine(gg);
            // }
            // List<string> idd=ls.Getid();
            //  Console.WriteLine("\n\t=== Sau khi get Diem ===="); 
            // foreach(var t1 in idd)
            // {
            //     Console.WriteLine(t1);
            // }
            // ls.showthongtin();
        }
    }
    public class sinhvien
    {
        public string id;
        public double gpa;
        public string name;
        public sinhvien()
        {
            
        }
        public sinhvien(string id,string name,double gpa)
        {
            this.id=id;
            this.name=name;
            this.gpa=gpa;
        }
        public void enter()
        {
            Console.Write(" Id sv : ");
            id=Console.ReadLine();
            Console.Write(" Name sv : ");
            name=Console.ReadLine();
            Console.Write(" Gpa sv : ");
            gpa=double.Parse(Console.ReadLine());
        }
         public void release()
        {
            Console.WriteLine("\n\t====ThongTin===");
            Console.Write(" Id sv : "+id);
            Console.Write(" Name sv : "+name);
            Console.Write(" Gpa sv : "+gpa);
        }
    }
    public class listsv
    {
        public int n;
        List<sinhvien> ds=new List<sinhvien>();
        public void enterlist()
        {
            Console.Write(" NUmbers of student: ");
            n=int.Parse(Console.ReadLine());
            for(int i=0;i<n;i++)
            {
                Console.WriteLine($" Sinh vien thu a[{i}]:");
                sinhvien x= new sinhvien();
                x.enter();
                ds.Add(x);
            }
        }
        public void releaselist()
        {
            foreach(sinhvien v in ds)
            {
                v.release();
            }
        }
        public void tontai(string ma )
        {
            bool tontai=ds.Exists(x=> x.id==ma);
             Console.WriteLine(tontai ? "Co ton tai" : "Khong ton tai");
        }
        public void Removegpa(double diem)
        {
            
            ds.RemoveAll(x=> x.gpa< diem); 
            Console.WriteLine("\n== Da xoa nhung ban Gpa < "+diem); 
        }
        public void Find(string ma)
        {
            sinhvien sv=ds.Find(x=> x.id==ma);
            if (sv != null)
         {
            Console.WriteLine($"Tim thay: {sv.id} - {sv.name}");
        }
        else
        {
            Console.WriteLine("Khong tim thay sinh vien");
        }
        }
        public void loctheodiem(double diem)
        {
            ds.Where(x=> x.gpa>=diem).ToList()
            .ForEach(x=>x.release());
        }
        public List<string> Getnames()
        {
            return ds.Select(s=> s.name).ToList();
        }
        public List<double> Getdiems()
        {
            return ds.Select(s=> s.gpa).ToList();
        }
        public List<string> Getid()
        {
            return ds.Select(s=> s.id).ToList();
        }
        public void showthongtin()
        {
           var info=ds.Select(s=> new
           {
               s.name,s.gpa
           }).ToList();
           foreach(var i in info)
            {
                Console.WriteLine($"{i.name} - {i.gpa}");
            }
        }
        public void whereSelect()
        {
            var info=ds.Where(s=> s.gpa >=5)
            .Select(s=> new { s.name,s.id,s.gpa}).ToList();
            foreach(var fg in info)
            {
               Console.WriteLine($"ID: {fg.id} | Name: {fg.name} | GPA: {fg.gpa}");
            }
        }
        public void truyvantim()
        {
            var tt=ds.
            Where(s=> s.name.Contains("Bao"))
            .Select(s=> new {s.id , s.name,s.gpa}).ToList();
            foreach(var th in tt)
            {
                Console.WriteLine($"ID: {fg.id} | Name: {fg.name} | GPA: {fg.gpa}");
            }

        }
    }
}
