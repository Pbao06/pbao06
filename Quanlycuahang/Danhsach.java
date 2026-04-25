package Quanlycuahang;

import java.util.ArrayList;

public class Danhsach {
    ArrayList<SanPham> ds=new ArrayList<>();
        public void Add_Products()
        {
            ds.add(new Dientu("0#F11","laptop Models 2027",2670000,2));
            ds.add(new Dientu("0#F12","Ban phim co gia re ",499000,2));
        }
        public void output_list()
        {
                for(SanPham sp : ds)
                {
                    sp.HienthiThongTin();
                }
        }
}
