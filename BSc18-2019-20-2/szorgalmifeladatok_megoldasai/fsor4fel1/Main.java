import basics.Matrix;

public class Main {
    public static void main(String[] args) {
        double[][] arr = {{1, 3, -5}, {0, 0, 1}, {4, -2, -2}, {5, 7, 0}};
        Matrix m = new Matrix(arr);
        System.out.println("M = " + System.lineSeparator() + m);
        System.out.println("M transpose = " + System.lineSeparator() + m.transpose());

        Matrix m2 = Matrix.identity(7);
        System.out.println("id = " + System.lineSeparator() + m2);

        double[][] arr2 = {{3, 1, -5}, {0, 1, 1}, {4, -2, -2}, {5, 7, 0}};
        Matrix m3 = new Matrix(arr2);
        System.out.println("M = " + System.lineSeparator() + m);
        System.out.println("M3 = " + System.lineSeparator() + m3);
        System.out.println("M + M3 = " + System.lineSeparator() + m.plus(m3));
    }
}


