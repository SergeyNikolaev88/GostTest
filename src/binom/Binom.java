package binom;

public class Binom {
    public static long binomialCoefficient(int n, int r) {
        long t = 1;

        int m = n - r; // r = Math.max(r, n - r);
        if (r < m) {
            r = m;
        }

        for (int i = n, j = 1; i > r; i--, j++) {
            t = t * i / j;
        }

        return t;
    }

    public static void main(String[] args) {
        System.out.println(binomialCoefficient(52, 5)); // 2598960

        System.out.println(binomialCoefficient(49, 6)); // 13983816
    }
}
