// There is an island in pacific ocean and it receives heavy rainfall
// every year. houses in island are in connected blocks.here 1 denotes houses
// and 0 denotes empty space
// 0 1 0 0 1 1          1               1   1
// 0 1 0 0 1 0  ===>>   1       and     1
// 0 1 1 0 1 0          1 1             1

//two houses said to be connected if they are neighbours to each other
//neighbour means they r adjacent to each other
//if thunder strikes that region then all the houses in that region gets destroyed.
//whole island is mapped by a M by N matrix of )

//example:
//  input:
//  6   6
//  2
// 0 1 0 0 1 0
// 0 1 1 0 1 0
// 0 1 1 0 1 0
// 0 0 0 0 0 0
// 1 1 1 1 1 1
// 0 0 1 1 0 0

//output:
// 13 3


import java.util.*;
public class findConnectedCells {
    int[][] matrix;
    findConnectedCells(int[][] asd){
        matrix=asd;
    }
    void method(int n){
        ArrayList<Integer> al= new ArrayList<Integer>();
            int total = 0;
            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix[i].length; j++){
                    if(matrix[i][j] == 1){
                        total ++;
                        int count=0;
                        al.add(lands(matrix,i,j,count));
                    }
                }
            }
            Collections.sort(al);
            int sum=0;
            for (int i=al.size()-1;i>al.size()-n-1;i--){

                sum+=al.get(i);
            }
            System.out.print(sum+" "+total);
    }
     static int lands(int[][] matrix, int x, int y,int count) {            
        try {
            if (matrix[x][y] == 1) {
                count++;
                matrix[x][y] = 0;
                count=lands(matrix, x + 1, y,count);
                count=lands(matrix, x, y + 1,count);
                count=lands(matrix, x - 1, y,count);
                count=lands(matrix, x, y - 1,count);
            }
            
        } 
        catch (ArrayIndexOutOfBoundsException e) {
        }
        return count;
    }
 
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str=sc.nextLine();
        String[] arr=str.split(" ");
        int thunders=sc.nextInt();
        int[][] ads=new int[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])];
        for (int i=0;i<Integer.parseInt(arr[0]);i++ ) {
            for (int j=0;j<Integer.parseInt(arr[1]);j++ ) {
                ads[i][j]=sc.nextInt();
            }            
        }

        findConnectedCells obj= new findConnectedCells(ads);
        obj.method(thunders);
    }
}
        
























































