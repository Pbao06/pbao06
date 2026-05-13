// See https://aka.ms/new-console-template for more information
using System;
class Program
{
    public static void Main()
    {
        listbook list=new listbook();
        list.inputlist();
        list.outputlist();
        list.thongketinhtrang();
        list.theloainhieunhat();
    }
    public class book
    {
        public string masach;
        public string tieude;
        public string tacgia;
        public int namxb;
        public double gia;
        public string tinhtrang;
        public string theloai;
        public book()
        {
        }
        public void input()
        {
            Console.WriteLine("\t\n====BOOK====");
            Console.Write(" Ma sach:");
            masach=Console.ReadLine();
            Console.Write(" Tieu de sach: ");
            tieude=Console.ReadLine();
             Console.Write(" The loai sach: ");
            theloai=Console.ReadLine();
            Console.Write(" Ten tac gia: ");
            tacgia=Console.ReadLine();
            Console.Write(" Nam xuat ban: ");
            namxb=int.Parse(Console.ReadLine());
            Console.Write(" Gia Tien: ");
            gia=double.Parse(Console.ReadLine()); 
            string[] valid ={"con","het","mat"};
            do
            {
                Console.WriteLine(" Tinh trang(con,het,mat): ");
                tinhtrang=Console.ReadLine().ToLower(); // tolower là chuyển về chữ thường dù nhập cc gì đi nữa 
                if(!valid.Contains(tinhtrang))
                {
                    Console.WriteLine(" Chi nhap ('con,het,mat'). ");
                }
                
            } while(!valid.Contains(tinhtrang));
        }
        public void output()
        {
            Console.WriteLine("\t\n====BOOK====");
            Console.WriteLine(" Ma sach:"+masach);
            Console.WriteLine(" Tieu de sach: "+ tieude);
             Console.WriteLine(" the loai sach: "+ theloai);
            Console.WriteLine(" Ten tac gia: "+tacgia);
            Console.WriteLine(" Nam xuat ban "+namxb);
            Console.WriteLine(" Gia tien: "+gia+" vn/dong.");
            Console.WriteLine(" Tinh trang: "+tinhtrang);
        }
    }
    public class listbook
        {
            public int soluong{set;get;}
           public book [] arr;
           public void inputlist()
            {
                Console.Write(" Nhap vao so luong sach:");
                soluong=int.Parse(Console.ReadLine());
                arr=new book[soluong];
                for(int i=0;i<soluong;i++)
                {
                    Console.Write($" \nSach {i+1}:",i);
                    arr[i]=new book();
                    arr[i].input();
                }
            }
            public void outputlist()
            {
                for(int i=0;i<soluong;i++)
                {
                    arr[i].output();
                }
            }
        public void themcuoimoi()// thêm cuối mới 
        {
            soluong++;
            book[] newarr= new book[soluong];
            // copy phần tử cũ qua mảng mới 
            for(int i=0;i<soluong-1;i++)
            {
                newarr[i]=arr[i]; // was copy 
            }
            newarr[soluong-1]=new book();
            newarr[soluong-1].input();
            arr=newarr;
            Console.WriteLine(" METHOD WAS ADDED SUCCESS");
        }
        public void suathongtin()
        {
             Console.WriteLine(" MA SACH CAN SUA THONG TIN: ");
            string id=Console.ReadLine();
            bool found=false;
            for(int i=0;i<soluong;i++)
            {
                if(arr[i].masach==id)
                {
                    // cap nhat lai thong tin moi 
                    arr[i]=new book();
                    Console.WriteLine("\n\t== NHAP LAI THONG TIN "+arr[i].masach+" ====");
                    arr[i].input();
                    found=true;
                    break;
                }
            }
            if(!found)
            {
                Console.WriteLine(" NOT FOUND MA SACH ");
            }
        }
        public void xoathongtin()
        {
            string id_2;
            Console.WriteLine(" Nhap ma so sach can xoa :");
            id_2=Console.ReadLine();
            bool found=false;
            for(int i=0;i<soluong;i++)
            {
                if(arr[i].masach==id_2)
                {
                    for(int j=i;j<soluong-1;j++)
                    {
                        arr[j]=arr[j+1];
                        found=true;
                    }
                    soluong--;

                }
            }
            if(found)
            {
                Console.WriteLine(" Da xoa Thanh cong sach "+id_2);
            }
        }
        public void timtheotieude()
        {
            Console.Write(" Nhap vao tieu de can tim :");
            string title=Console.ReadLine();
            bool found=false;
            for(int i=0;i<soluong;i++)
            {
                if(arr[i].tieude==title)
                {
                    found=true;
                    Console.WriteLine(" SACH VOI TIEU DE BAN CAN TIM LA : ");
                    arr[i].output();
                    break;
                }
            }
        }
        public void timtheotacgia()
        {
            Console.Write(" Nhap vao tac gia can tim :");
            string author=Console.ReadLine();
            bool found=false;
            for(int i=0;i<soluong;i++)
            {
                if(arr[i].tacgia==author)
                {
                    found=true;
                    Console.WriteLine(" SACH VOI TAC GIA  BAN CAN TIM LA : ");
                    arr[i].output();
                    break;
                }
            }
        }
        public void theonamxb()
        {
            Console.WriteLine(" Nhap tu nam a den nam b: ");
            int a=int.Parse(Console.ReadLine());
            int b=int.Parse(Console.ReadLine());
            bool found=false;
            for(int i=0;i<soluong;i++)
            {
                if(arr[i].namxb >= a && arr[i].namxb <= b)
                {
                    found=true;
                    Console.WriteLine(" CACH LOAI SACH CO TU "+a+" den "+b+" la: ");
                    arr[i].output();
                    break;
                }
            }
            if(!found)
            {
                Console.WriteLine(" Khong tim thay sach trong khoang time do ");
            }
        }
        public void thongketinhtrang()
        {
            int dem1=0;
            int dem2=0;
            int dem3=0;
            for(int i=0;i<soluong;i++)
            {
                if(arr[i].tinhtrang=="con")
                {
                    dem1++;
                }
                else if(arr[i].tinhtrang=="mat")
                {
                    dem2++;
                }
                else
                {
                    dem3++;
                }
            }
            Console.WriteLine(" SO LUONG SACH CON :"+dem1);
             Console.WriteLine(" SO LUONG SACH MAT :"+dem2);
              Console.WriteLine(" SO LUONG SACH HET :"+dem3);
        }
        public void theloainhieunhat()
        {
            string loaimax="";
            int maxcount=0;
            for(int i=0;i<soluong;i++)
            {
                int count=0;
                for(int j=0;j<soluong;j++)
                {
                    if(arr[j].theloai==arr[i].theloai)
                    {
                        count++;
                    }
                }
                if(count>maxcount)
                {
                    maxcount=count;
                    loaimax=arr[i].theloai;
                }
            }
            Console.WriteLine(" So the loai nhieu nhat la :"+loaimax+" voi "+maxcount+ " lan");
        }
        }
}