// See https://aka.ms/new-console-template for more information
using System;
namespace hinhchunhat
{
    class Program
    {
        static void Main()
        {
            rectangle rec=new rectangle{dai=10, rong=5};
            rectangle rec2=new rectangle();
            rec2.enter();
            Console.WriteLine("\t == THONG TIN RECTANGLE 1 === ");
            rec2.release();
            rec2.change_size(rec,1);
            Console.WriteLine("\t == thong tin sau khi cap nhat lai Size:");
            rec2.release();
        }
    }
    public class rectangle
    {
        private int _dai;
        public int dai
        {
            get{return _dai;}
            set
            {
                _dai=value >0 ? value : 0;
            }
        }
        // phuong thuc hanh vi  
        private int _rong;
        public int rong
        {
            get{return _rong;}
            set
            {
                _rong=value >0 ? value :0;
            }
        }
        public rectangle(){}
        public rectangle(int aa,int bb)
        {
            this.dai=aa;
            this.rong=bb;
        }
        public double perimeter()
        {
            return 2* (dai*rong);
        }
        public double dientich()
        {
            return dai*rong;
        }
        public double duongcheo()
        {
            // cong thuc tinh duong cheo la can  a^2+b^2
            return Math.Sqrt(dai*dai + rong*rong);
        }
        public void enter()
        {
            Console.Write(" Nhap vao chieu dai rectangle: ");
            dai=int.Parse(Console.ReadLine());
             Console.Write(" Nhap vao chieu rong rectangle: ");
            rong=int.Parse(Console.ReadLine());
        }
        public void release()
        {
            Console.WriteLine(" Chieu dai rectangle: "+dai);
             Console.WriteLine(" Chieu rong rectangle: "+rong);
            Console.WriteLine(" Chu vi rectangle: "+perimeter());
            Console.WriteLine(" dientich rectangle: "+dientich());
            Console.WriteLine(" duong cheo rectangle: "+duongcheo());
        }
        // method overflow ghi de nap chong 
        public void changesize(int tx,int ty,int kieu)
        {
            if(kieu==1)
            {
                dai+=tx;
                rong+=ty;
            }
            else if(kieu==0)
            {
                dai-=tx;
                rong-=ty;
            }
        }

        public void change_size(rectangle a,int kieu)
        {
            if(kieu==1)
            {
                dai+=a.dai;
                rong+=a.rong;
            }
            else if(kieu==0)
            {
                dai-=a.dai;
                rong-=a.rong;
            }
        }
    
    }
}
