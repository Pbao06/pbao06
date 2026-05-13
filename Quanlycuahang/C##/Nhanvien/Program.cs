// See https://aka.ms/new-console-template for more information
using System;
class Program
{
    static void Main()
    {
        Listemployee ls_nv=new Listemployee();
        ls_nv.listin();
        ls_nv.listout();
    }
    public class employee
    {
        public string id{set;get;}
        public string name{set;get;}
        private int _days;
        public int days
        {
            get{return _days;}
            set
            {
                if(value < 0)
                {
                    Console.WriteLine(" DU LIEU SAI ");
                    _days=0;
                }
                else _days=value;
            }
        }
        public char loai
        {
            get
            {
                if(days>=26)
                {
                    return 'A';
                }
                else if(days>=22)
                {
                    return 'B';
                }
                else
                {
                    return 'C';
                }
            }   
        }
        public static float luong=200000f;
        // khoi tao 
        public employee()
        {
            id=name="";
            days=0; 
        }
        //cons tham so 
        public employee(string id,string name ,int Days)
        {
            this.id=id;
            this.name=name;
            this.days=Days;
        }
        public employee(employee a)
        {
            this.id=a.id;
            this.name=a.name;
            this.days=a.days;
        }
        ~employee()
        {
            
        }
        public  void inputinfo()
        {
            Console.Write(" student id: ");
            id=Console.ReadLine();
            Console.Write(" Name:");
            name=Console.ReadLine();
            Console.Write(" Numbers of days working : ");
            days=int.Parse(Console.ReadLine());
        }
        public void xuat()
        {
            Console.WriteLine("\n\t====Student====");
            Console.WriteLine(" student id: "+id);
            Console.WriteLine(" Name:"+name);
            Console.WriteLine(" Numbers of days working : "+days);
            Console.WriteLine(" Rank : "+loai);
            Console.WriteLine(" Salary of employee : "+tinhluong());
        }
        public float tinhluong()
        {
            float salary;
            if(loai=='A')
            {
                salary=days*luong*1.05f;
            }
            else if( loai=='B')
            {
                salary=days*luong*1.02f;
            }
            else
            {
                salary=days*luong;
            }
            return salary;
        }
    }
    public class Listemployee
    {
        List<employee> ds_nhanvien=new List<employee>();
        public int n{set;get;}
        public void listin()
        {
            Console.Write(" Numbers of element in list: ");
            n=int.Parse(Console.ReadLine());
            for(int i=0;i<n;i++)
            {
                Console.WriteLine($" a[{i}]:");
                employee x=new employee();
                x.inputinfo();
                ds_nhanvien.Add(x);
            }
        }
        public void listout()
        {
            foreach(employee e in ds_nhanvien)
            {
                // moi phan tu la 1 nhan vien 
                e.xuat();
            }
        }
    }
}
