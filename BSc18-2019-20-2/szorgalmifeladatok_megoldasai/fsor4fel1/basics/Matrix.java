package basics;

import java.util.Locale;

public class Matrix {
    private int M;     // a mátrix sorainak száma
    private int N;     // a mátrix oszlopainak száma
    private double[][] data; // a mátrix komponenseinek többdimenziós tömbje

    // M x N dimenziós nullmátrixot hoz létre
    public Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        data = new double[M][N];
    }

    // M x N dimenziós mátrixot hoz létre M x N dimenziós tömbből
    public Matrix(double[][] data) {
        M = data.length;
        N = data[0].length;
        this.data = new double[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                    this.data[i][j] = data[i][j];
    }

    // N x N dimenziós egységmátrixot hoz létre 
    public static Matrix identity(int N) {
        Matrix I = new Matrix(N, N);
        for (int i = 0; i < N; i++)
            I.data[i][i] = 1;
        return I;
    }

    // mátrix transzponáltja
    public Matrix transpose() {
        Matrix A = new Matrix(N, M);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.data[j][i] = data[i][j];
        return A;
    }

    // két mátrix összegének kiszámítása
    public Matrix plus(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Nem egyezik meg a két mátrix dimenziója!");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] + B.data[i][j];
        return C;
    }

    // két mátrix különbségének kiszámítása
    public Matrix minus(Matrix B) {
        Matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Nem egyezik meg a két mátrix dimenziója!");
        Matrix C = new Matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] - B.data[i][j];
        return C;
    }

    // mátrix sztringként történő ábrázolása
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\n");
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                    s.append(String.format(Locale.ENGLISH, "%10.2f", data[i][j]));
                    //s.append(data[i][j]);
                    if (j < N-1) s.append(" ");
            }
            s.append("\n");
        }
        return s.toString();    
    }
}