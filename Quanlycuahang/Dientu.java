package Quanlycuahang;

public class Dientu extends SanPham
{
      private int TimeBaoHanh; // năm
        public int GetBaoHanh()
        {
            return TimeBaoHanh;
        }
        public void setBaoHanh(int t)
        {
            this.TimeBaoHanh=t;
        }
        //constructor 
        public Dientu(String _id,String _name,double _price,int time)
        {
            super(_id,_name,_price); // truyền lên thg cha (constructor cha) 
            this.TimeBaoHanh=time;
        }
        @Override // tính đa hình
        public double Tinhgiaban()
        {
            // giá điện tử =gia goc + thuế VAT 10%
            double thue=getGiagoc()*10/100;
            return getGiagoc()+thue;
        }
        @Override
        public void HienthiThongTin()
        {
            System.out.println(" Id san pham:"+GetMasp());
            System.out.println(" Ten san pham:"+GetTensanpham());
            System.out.println(" Gia goc san pham:"+getGiagoc());
            System.out.println(" Thoi gian bao hanh:"+GetBaoHanh());
            System.out.println(" Tong tien san pham:"+Tinhgiaban());

        }
}
