public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

    
        int i;
        int sum=0;
        for (i=1; i<=10 ; i++){
            sum = sum + i ;
            System.out.println(i);
            if(i<=9){
                System.out.print("+");
            } else {
                System.out.print("=");
                System.out.print(sum);
            }
        }
    }
}
