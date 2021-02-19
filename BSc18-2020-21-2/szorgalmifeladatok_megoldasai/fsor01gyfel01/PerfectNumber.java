class PerfectNumber {
    public static void main(String[] args){
        if (args.length == 1){
            int n = Integer.parseInt(args[0]);
            int temp = 0;
            for(int i=1; i<=n/2; i++){
                if(n%i == 0){
                    temp += i;
                }
            }
            if (temp == n) {
                System.out.println("A szám tökéletes.");
            } 
            else {
                System.out.println("A szám nem tökéletes.");
            }
        } else {
            System.err.println("Hibás paraméterezés!");
            System.exit(0);
        }
    }
}
