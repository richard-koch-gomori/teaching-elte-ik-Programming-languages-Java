

class Main
{
    public static void main(String[] args)
    {
        System.out.print("N = ");
        int N = Integer.parseInt(System.console().readLine());

        double[] array = new double[N]; // a heap-en foglal egy N méretű double-öket tartalmazó tömböt

        for (int i = 0; i < array.length; ++i) // array.length a tömb max elemeinek száma (hossza)
        {
            System.out.print("Enter " + i + "th item = ");
            array[i] = Double.parseDouble(System.console().readLine());
        }

        double sum = 0;
        for (int i = 0; i < array.length; ++i)
        {
            sum += array[i];
        }
        double avg = sum / array.length;

        System.out.println("avg = " + avg);

        double[] diff = new double[N];
        for (int i = 0; i < array.length; ++i)
        {
            diff[i] = Math.abs(avg - array[i]);
        }

        int min_idx = 0;
        for (int i = 1; i < array.length; ++i)
        {
            if (diff[i] < diff[min_idx])
            {
                min_idx = i;
            }
        }

        System.out.println("idx = " + min_idx + ", array[idx] = " + array[min_idx]);
    }
}

