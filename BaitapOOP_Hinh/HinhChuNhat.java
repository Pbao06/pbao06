package BaitapOOP_Hinh;

public class HinhChuNhat extends Hinh 
{
    private double _chieudai;
    private double _chieurong;
    //get and set for this 
    public double Getdai()
    {
        return _chieudai;
    }
    public void Setdai(double dai)
    {
        this._chieudai=dai;
    }
    public double Getrong()
    {
        return _chieurong;
    }
    public void Setrong(double rong)
    {
        this._chieurong=rong;
    }

    // constructor  for child and father 
    public HinhChuNhat(String mau,double dai, double rong)
    {
        super(mau);
        // rule 1 -> parameter always right side ( left real data of oject)
        this._chieudai=dai;
        this._chieurong=rong;
    }
    @Override
    public void TinhDienTich()
    {
       double s= Getdai() * Getrong();
       System.out.println(" Dien tich:" + s);
    }
     @Override
    public void TinhChuVi()
    {
       double c= (Getdai() + Getrong())*2;
       System.out.println(" Chu vi:" + c);
    }
    @Override
    public void Getinfo()
    {
      TinhChuVi();
      TinhDienTich();
    } 
    

}
