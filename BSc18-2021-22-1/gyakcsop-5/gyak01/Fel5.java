

class Fel5
{
    public static void main(String[] args)
    {
        /*
        System.out.print("db: ");
        String dbs = System.console().readLine();
        int db = Integer.parseInt(dbs);
        int idx;
        for (idx = 1; idx <= db; ++idx)
        {
            System.out.println("idx: " + idx/2.0);
        }

        System.out.println("Kiirtam " + (idx-1) + " szamot");
        */

        System.out.print("db: ");
        String dbs = System.console().readLine();
        int db = Integer.parseInt(dbs);
        for (int idx = 1; idx <= db; ++idx)
        {
            System.out.println("idx: " + idx/2.0);
        }

        System.out.println("Kiirtam " + dbs + " szamot");
    }
}
