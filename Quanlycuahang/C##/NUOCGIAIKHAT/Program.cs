// See https://aka.ms/new-console-template for more information
using System;
using System.Net.Http.Headers;
using System.Collections.Generic;

namespace bai3
{
    class Program
    {
        static void Main()
        {
            drinklist dl=new drinklist();
            dl.enterList();
            dl.releaselist();
        }
    }
    public class giaikhat
        {
            // tính đóng gói
            private string _tenhang;
            public string tenhang
            {
                get{return _tenhang;}
                set{_tenhang=value;}
            }
            private string _donvitinh;
            public string donvitinh
            {
                get{return _donvitinh;}
                set
                {
                    if(value !="ket" && value!="chai" && value!="thung" &&  value!="lon")
                    {
                        Console.WriteLine(" don vi phai nam trong KET ,THUNG,LON,CHAI");
                        _donvitinh="ket";
                    }
                    else _donvitinh=value;
                }
            }
            int sl;
            public int soluong
            {
                get{return sl;}
                set
                {
                    if(value<0)
                    {
                        Console.WriteLine(" sai du lieu ");
                        sl=0;
                    }
                    else sl=value;
                }
            }
            float _dongia;
            public float dongia
            {
                get{return _dongia;}
                set{if(value <0)
                    {
                        Console.WriteLine(" Can > 0");
                        _dongia=0;
                    }
                    else _dongia=value;
                }
            }
         public float thanhtien
    {
        get
        {
            switch (donvitinh)
            {
                case "ket":
                case "thung":
                    return soluong * dongia;
                case "chai":
                    return soluong * (dongia / 20);
                case "lon":
                    return soluong * (dongia / 24);
                default:
                    return soluong * dongia;
            }
        }
    }
    public float thue
    {
        get { return thanhtien * 0.1f; } // 10% VAT
    }
      public float tongtien
    {
        get { return thanhtien + thue; }
    }
    public void nhapthongtin()
        {
            Console.WriteLine(" TEN NUOC: ");
            tenhang=Console.ReadLine();
            Console.WriteLine(" Don vi tinh(-ket -thung -chai -lon): ");
            donvitinh=Console.ReadLine();
            Console.WriteLine(" So luong mua: ");
            soluong=int.Parse(Console.ReadLine());
            Console.WriteLine(" Gia san pham : ");
            dongia=float.Parse(Console.ReadLine());
        }
        public void xuatthongtin()
        {
            Console.WriteLine(" TEN NUOC: "+tenhang);
            Console.WriteLine(" Don vi tinh(-ket -thung -chai -lon): "+donvitinh);
            Console.WriteLine(" So luong mua: "+soluong);
            Console.WriteLine(" Gia san pham : "+dongia);
            Console.WriteLine(" Thanh tien: "+thanhtien +" vn/dong");
            Console.WriteLine(" Tong tien + thue 10%: "+tongtien+" vn/dong");
        }
    }
     public class drinklist
        {
            public List<giaikhat> dr=new List<giaikhat>();
            public int n{ set; get;}
            public void enterList()
            {
                Console.Write(" NUMBERS OF DRINKS: ");
                n=int.Parse(Console.ReadLine());
                for(int i=0;i<n;i++)
                {
                    Console.WriteLine("\t\n=== Drink===");
                    giaikhat nc=new giaikhat();
                    nc.nhapthongtin();
                    dr.Add(nc);
                }
            }
            public void releaselist()
            {
                foreach(giaikhat k in dr)
                {
                    k.xuatthongtin();
                }
            }
        }


}
