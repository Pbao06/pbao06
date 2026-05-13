// See https://aka.ms/new-console-template for more information
using System;
using System.Collections.Generic;
using System.Linq;

namespace _tdt_7
{
    class Program
    {
        static void Main()
        {
            // Func<int,int> square = x=> x*x;
            // Console.WriteLine(square(5));
            // // lamda kiemtra so chan 
            // Func<int,bool> iseven= n=> n%2==0;
            // Console.WriteLine(square(4));
            // Console.WriteLine(square(7));
            // int[] numbers={1,2,3,4,5,6,7,8,9};
            // // 
            // var oddnumber=numbers.Where(n=> n%2!=0);
            // Console.WriteLine(" so le : "+string.Join(" , ",oddnumber));
            // var evennumbers=numbers.Where(n=> n%2==0);
            // Console.WriteLine(" so chan : "+string.Join(" ,",evennumbers));
            // Func<int,int,int> add= (x1,x2)=>x1+x2;
            // Console.WriteLine(add(3,6));
            // Func<string,int> lenght=s => s.Length;
            // Console.WriteLine(lenght("Motherfucker"));
            list_student ls=new list_student();
            ls.list_enter();
            ls.output();
            double zz;
            Console.Write(" Nhap vao diem can loc: ");
            zz=double.Parse(Console.ReadLine());
            ls.locDiem();
            ls.sapxepdiemdesc();

            
        }
    }
    public class person
    {
        public string name{set;get;}
        private int _age;
        public int age{set;get;}
       public person(){}
        public person(string name,int age)
        {
            this.name=name;
            this.age=age;
        }
        public  void enter()
        {
            Console.Write(" Name: ");
            name=Console.ReadLine();
            int agetemp;
            bool check=false;
            while(true)
            {
                Console.Write(" Age: ");
                string input=Console.ReadLine();
                if(int.TryParse(input,out agetemp))
                {
                    // sài TryParse cần 1 biến trung gian 
                    age=agetemp;
                    check=true;
                    break;
                }
                else
                {
                    check=false;
                    Console.WriteLine(" Cannot read data Could You enter again?:");
                }
            }
           
        }
         public void release()
        {
            Console.Write(" Name: "+name);
            Console.Write(" Age: "+age);
        }
    }
    public class student:person
    {
        public double score{get;set;}
        // constructor mac dinh 
        public student(): base(){}
        public student(string name1 ,int age2,double score2):base(name1,age2)
        {
            this.score=score2;
        }
        public void enterstudent()
        {
            base.enter();
            double scoretemp;
            bool check=false;
            while(true)
            {
                Console.Write(" Diem : ");
                string diemm=Console.ReadLine();
                if(double.TryParse(diemm,out scoretemp))
                {
                    // sài TryParse cần 1 biến trung gian 
                    score=scoretemp;
                    check=true;
                    break;
                }
                else
                {
                    check=false;
                    Console.WriteLine(" Cannot read data Could You enter again?:");
                }
            }
        }
        public void releasestudent()
        {
            Console.WriteLine("\n\t====Information====");
            base.release();
             Console.Write(" Diem : "+score);
        }
    }
    public class list_student
    {
        List<student> ls_stu=new List<student>();
        public int n{set;get;}
        public void list_enter()
        {
            Console.Write(" Numbers of student: ");
            n=int.Parse(Console.ReadLine());
            for(int i=0;i<n;i++)
            {
                student x=new student();
                x.enterstudent();
                ls_stu.Add(x);
            }
        }
        public void output()
        {
            foreach(student m in ls_stu)
            {
                m.releasestudent();
                Console.WriteLine();
            }
        }
        public void locDiem(double diem)
        {
           ls_stu.Where(x=> x.score >=diem).ToList()
           .ForEach(x=> x.output());
        }
        public void sapxepdiemdesc()
        {
            var sortstudent=ls_stu.OrderByDescending(s=>s.score).ToList();
            foreach(var s in sortstudent)
            {
                Console.WriteLine($" {s.name} - Diem {s.score}");
            }
        }
    }
}
