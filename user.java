import java.util.*;

public  class user {
    static boolean END_OF_MATRIX=false;
    static Scanner sc=new Scanner(System.in);
    static {System.out.println("enter the diminision");}
    static int n=sc.nextInt();
    static int sudoku[][]=new int[n][n];

    public static void print(){
        System.out.println("Solved");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean checker(int r,int c,int number){
        //row
        for(int j=0; j<n; j++) {
            if(sudoku[r][j] == number) {
                return false;
            }
        }
        
        //column
        for(int i=0; i<n; i++) {
            if(sudoku[i][c] == number) {
                return false;
            }
        }  
        //grid
            int x=(int)(Math.sqrt(n));
            int sr = x * (r/x);
            int sc = x * (c/x);     
            for(int i=sr; i<sr+x; i++) {
                for(int j=sc; j<sc+x; j++) {
                    if(sudoku[i][j]==number) {
                        return false;
                }
            }
        }
        return true;
    }

    public static void scan(int r,int c){
        if(r==n-1 && c==n){
            END_OF_MATRIX=true;
            return;
        }
        if(c==n){
            r=r+1;
            c=0;
        }
        if(sudoku[r][c]==0){
            for(int i=1;i<=n;i++){
                if(checker(r, c, i)){
                    sudoku[r][c]=i;
                    scan(r,c+1);
                    if(!END_OF_MATRIX){
                        sudoku[r][c]=0;
                    }
                }
            }
        }
        else
            scan(r,c+1);
    }
    
    public static void filler(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sudoku[i][j]=sc.nextInt();
            }
        }
    }
    public static void main(String args[]){  
        filler();
        scan(0,0);
        print();
    }
}