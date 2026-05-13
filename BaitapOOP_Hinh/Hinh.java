package BaitapOOP_Hinh;

abstract class Hinh {
    private String _color;
    // set and get 
    public String Getcolor()
    {
        return _color;
    }
    public void Setcolor(String color)
    {
        this._color=color;
    }
    // constructor 
    public Hinh(){};
    // like above but add parameter (cons)
    public Hinh(String mau)
    {
        _color=mau;
    }
    // truu tuong method 
    public abstract void  TinhDienTich();
    public abstract void TinhChuVi();
    public abstract void  Getinfo(); 
}
