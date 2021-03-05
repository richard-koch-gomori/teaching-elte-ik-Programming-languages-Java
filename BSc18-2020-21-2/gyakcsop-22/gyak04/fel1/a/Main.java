

class Main
{
    public static void main(String[] args)
    {
        double[] array = {1.3, 5.2, 7.7, -2.3, 23.45};

        double sum = 0;
        for (int i = 0; i < 5; ++i)
        {
            sum += array[i];
        }
        double avg = sum / 5;

        System.out.println("avg = " + avg);

        double[] diff = {0, 0, 0, 0, 0};
        for (int i = 0; i < 5; ++i)
        {
            diff[i] = Math.abs(avg - array[i]);
        }

        int min_idx = 0;
        for (int i = 1; i < 5; ++i)
        {
            if (diff[i] < diff[min_idx])
            {
                min_idx = i;
            }
        }

        System.out.println("idx = " + min_idx + ", array[idx] = " + array[min_idx]);
    }
}

