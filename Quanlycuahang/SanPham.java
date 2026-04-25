package Quanlycuahang;

public abstract class SanPham {
    private String Masp;
        private String Tensanpham;
        private double Giagoc;
        public SanPham()
        {
            //constructor mặc định
        }
        public SanPham(String _id,String _name,double _Gia)
        {
            this.Masp=_id;
            this.Tensanpham=_name;
            this.Giagoc=_Gia;
        }

        //  TÍNH ĐÓNG GÓI truy cập thông qua Get và set
        public String GetMasp()
        {
            return Masp;
        }
        public void setMasp(String id)
        {
            this.Masp=id;
        }
        // ten 
        public String GetTensanpham()
        {
            return Tensanpham;
        }
        public void setTensanpham(String name)
        {
            this.Tensanpham=name;
        }
        // Gia goc
        public double getGiagoc()
        {
            return Giagoc;
        }
        public void setGiagoc(double price)
        {
            if(price<0)
            {
                System.out.println(" Gia goc khong duoc < 0");
            }
            else
            {
                 this.Giagoc=price;
            }
        }
        public abstract double Tinhgiaban();
        public void HienthiThongTin()
        {
            System.out.println(" Id san pham:"+GetMasp());
            System.out.println(" Ten san pham:"+GetTensanpham());
            System.out.println(" Gia goc san pham:"+getGiagoc());
        }
}
