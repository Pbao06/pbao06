public class Loop {
    public static void main(String [] args)
    {
        // practice loop and loop nested 
        int[][] warehouse = { // loop 2 chieu
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 7, 10, 11},
            {12, 13, 14}
        };
        // target find value = 7 -> break; father loop countinue
        // loop in father around 4 row , find in each that row i loop to find 7 
        for(int i=0;i<warehouse.length;i++)
        {
            for(int j=0;j<warehouse[i].length;j++)
            {
                if(warehouse[i][j]==7)
                {
                    System.out.println("found 7  ");
                    break; // to stop child loop
                }
            }
            
        }

        // exercices 2 : duong cheo x 
        int size=5;
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if( i==j || i+j==size-1)
                {
                    System.out.print(" 0 ");
                }
                else
                {
                    System.out.print(" * ");
                }
            }
            System.out.println("");
        }
    }
}