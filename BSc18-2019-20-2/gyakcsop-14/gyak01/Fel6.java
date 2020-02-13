

class Fel6 {
    public static void main(String[] args) {
        System.out.print("Enter a: ");

        // Integer.parseInt(str): az str sztringen egész számmá alakítja
        int a = Integer.parseInt(System.console().readLine());
        System.out.print("Enter b: ");
        int b = Integer.parseInt(System.console().readLine());
        for(int i = a; i <= b; i++)
        {
            System.out.println(i/2.0);
        }
    }
}
