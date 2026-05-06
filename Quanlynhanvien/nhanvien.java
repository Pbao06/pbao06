package Quanlynhanvien;
public class nhanvien {
    private String _ho;
    private String _name;
    private int _sp;
    public String get_ho()
    {
        return _ho;
    }
    public void Set_ho()
    {
    }
     public String get_Name()
    {
        return _name;
    }
    public void Set_Name()
    {
        if(_name==null)
        {
            System.out.print(" Name can be null");
            return;
        }
    }
       public int get_sp()
    {
        return _sp;
    }
    public void Set_sp()
    {
       if(_sp<0)
       {    
        System.out.print("Product have to > 0 ");
        return;
       }
       if(_sp<0)
       {
        _sp=0;
       }
    }

    // construct no parameter 
    public nhanvien(){}
    public nhanvien(String ho, String ten,int sl_sp)
    {
        this._ho=ho;
        this._name=ten;
        this._sp=sl_sp;
    }
    public double getluong()
    {
        double price=0;
        if(_sp <200)
        {
            price=_sp*0.5;
        }
        else if(_sp  <400)
        {
            price=_sp*0.55;
        }
        else if(_sp < 600)
        {
            price= _sp*0.6;
        }
        else
        {
            price=_sp*0.65;
        }
        return price;
    }
    
}
