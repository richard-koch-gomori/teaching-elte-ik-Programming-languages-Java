

class Fel6
{
    public static void main(String[] args)
    {
        System.out.print("Enter min: ");
        String min_str = System.console().readLine();

        // Integer.parseInt(str): az str sztringen egész számmá alakítja
        int min = Integer.parseInt(min_str);
        System.out.print("Enter max: ");
        String max_str = System.console().readLine();
        int max = Integer.parseInt(max_str);

        for (int i = min; i <= max; ++i)
        {
            System.out.println(i/2.0);
        }
    }
}