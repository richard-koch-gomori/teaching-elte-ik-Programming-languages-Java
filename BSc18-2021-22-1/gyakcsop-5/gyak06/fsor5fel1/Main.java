// 1 2 3 avg = 2
// 1 0 1

/*
class Main
{
    public static void main(String[] args)
    {
        //double[] array = new double[5];
        //array[0] = 1.3;

        double[] array = {1.3, 5.2, 7.7, -2.3, 23.45};
        //double[] array = {1, 2, 3, 4, 5};
        //System.out.println(array[0]);

        double sum = 0;
        for (int i = 0; i < 5; ++i)
        {
            sum += array[i];
        }
        double avg = sum / 5;

        double[] diff_from_avg = new double[5];
        for (int i = 0; i < 5; ++i)
        {
            diff_from_avg[i] = Math.abs(array[i] - avg);
        }

        int min_idx = 0;
        for (int i = 1; i < 5; ++i)
        {
            if (diff_from_avg[i] < diff_from_avg[min_idx])
            {
                min_idx = i;
            }
        }

        System.out.println("atlag: " + avg);
        System.out.println("legkevesbe eltero elem az atlagtol: " + array[min_idx]);

    }
}
*/

/*
class Main
{
    public static void main(String[] args)
    {
        //double[] array = new double[5];
        //array[0] = 1.3;

        double[] array = {1.3, 5.2, 7.7, -2.3, 23.45};
        //double[] array = {1, 2, 3, 4, 5};
        //System.out.println(array[0]);

        double sum = 0;
        for (int i = 0; i < 5; ++i)
        {
            sum += array[i];
        }
        double avg = sum / 5;

        int min_idx = 0;
        for (int i = 1; i < 5; ++i)
        {
            if (Math.abs(array[i] - avg) < Math.abs(array[min_idx] - avg))
            {
                min_idx = i;
            }
        }

        System.out.println("atlag: " + avg);
        System.out.println("legkevesbe eltero elem az atlagtol: " + array[min_idx]);

    }
}
*/

class Main
{
    public static void main(String[] args)
    {
        System.out.print("N = ");
        int N = Integer.parseInt(System.console().readLine());

        double[] array = new double[N]; // VLA

        double sum = 0;
        for (int i = 0; i < N; ++i)
        {
            array[i] = Double.parseDouble(System.console().readLine());
            sum += array[i];
        }
        double avg = sum / N;

        int min_idx = 0;
        for (int i = 1; i < N; ++i)
        {
            if (Math.abs(array[i] - avg) < Math.abs(array[min_idx] - avg))
            {
                min_idx = i;
            }
        }

        System.out.println("atlag: " + avg);
        System.out.println("legkevesbe eltero elem az atlagtol: " + array[min_idx]);

    }
}
