import java.util.Random;
import java.util.Scanner;

public class Matrix {
    public int[][] createMatrix(int k, int n, Scanner in){
        int i, j;
        try {
            int first[][] = new int[k][n];

            System.out.println("Įveskite matricos elementus, po kiekvieno elemento spauskite ENTER");
            for (i = 0; i < k; i++)
                for (j = 0; j < n; j++)
                    first[i][j] = in.nextInt();

            System.out.println("Generuojanti matrica G:");
            printMatrix(first);

            in.nextLine();
            return first;
        }
        catch (Exception e) {
            System.out.println("Klaida");
            return null;
        }
    }

    public void printVector(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] generateMatrix(int k, int n) { // Generuojama matrica (I | A).
        Random rand = new Random();
        int[][] matrix = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (j < k) {
                    matrix[i][j] = (i == j) ? 1 : 0;
                } else {
                    matrix[i][j] = rand.nextInt(2);
                }
            }
        }

        printMatrix(matrix);
        return matrix;
    }

    public static int[] multiplyVectorMatrix(int[] m, int[][] g) {
        int[] c = new int[g[0].length]; //c yra n ilgio (g stulpeliu sk)
        for (int i = 0; i < g[0].length; i++) { //ciklas kiekvienam g stulpeliui
            for (int j = 0; j < m.length; j++) { //ciklas kiekvienam m simboliui
                c[i] ^= m[j] * g[j][i];  // XOR sudėčiai
            }
        }
        return c;
    }

    public static int[] multiplyMatrixVector(int[][] h, int[][] rTransposed) { //analogiška multiplyVectorMatrix, naudojama kai vektoriaus = matrica 1 stulpelio; k eilučių; sindromui skaičiuoti
        int[] result = new int[h.length];
        for (int i = 0; i < h.length; i++) {
            for (int j = 0; j < rTransposed.length; j++) {
                result[i] ^= h[i][j] * rTransposed[j][0];
            }
        }
        return result;
    }

    public int[][] vectorToMatrix(int[] vector) {
        int[][] matrix = new int[vector.length][1];
        for (int i = 0; i < vector.length; i++) {
            matrix[i][0] = vector[i];
        }
        return matrix;
    }

    public int[] matrixToVector(int[][] matrix) {
        int[] vector = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            vector[i] = matrix[i][0];
        }
        return vector;
    }

    public int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public int[] addVectors(int[] vector1, int[] vector2) {
        int length = vector1.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = (vector1[i] + vector2[i]) % 2;
        }

        return result;
    }


    public int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException("Netinkami matrcų dydžiai.");
        }

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

}
