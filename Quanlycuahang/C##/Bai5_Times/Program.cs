// See https://aka.ms/new-console-template for more information
using System;
namespace bai_5_times
{
    class Program
    {
        static void Main()
        {
            times t=new times();
            t.enter();
            t.release();
        }
    }
    public class times
    {
        public times(){}
        private int _hour;
        public int hour
        {
            get{return _hour;}
            set
            {
                if(value >24 || value <0)
                {
                    Console.WriteLine(" hour need to set around 1 and 24");
                    _hour=0;
                }
                else
                {
                    _hour=value;
                }
            }
        }
        private int _minutes;
        public int minutes
        {
            get
            {
                return _minutes;
            }
            set
            {
                if(value < 0 || value > 59)
                {
                    Console.WriteLine(" Minutes need to set around 1 and 59");
                    _minutes=0;
                }
                else _minutes=value;
            }
        }
        private int _second;
        public int second
        {
            get{return _second;}
            set
            {
                if(value < 0 || value > 59)
                {
                    Console.WriteLine(" Second need to set around 1 and 59");
                    _second=0;
                }
                else _second=value;
            }
        }
        //
        public void enter()
        {
            Console.Write(" enter time(h,m,s):  ");
            hour=int.Parse(Console.ReadLine());
            minutes=int.Parse(Console.ReadLine());
            second=int.Parse(Console.ReadLine());
        }
        public void release()
        {
            if(hour > 12 )
            {
                //fix mention AM and PM        
                Console.WriteLine($" Times:  {hour}: {minutes}:{second} PM");
            }
            else
            Console.WriteLine($" Times:  {hour}: {minutes}:{second} AM");
        }

    }
}