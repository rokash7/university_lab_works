import java.util.Arrays;

public class LinearCode {
    private int n;
    private int k;
    private int[][] g;
    Matrix matrix = new Matrix();

    public LinearCode(int n, int k, int[][] g) {
        this.n = n;
        this.k = k;
        this.g = g;
    }

    public int[] encode(int[] m) {
        // Metodui paduodama žinutė, ji yra užkoduojama (dauginama su generuojančia matrica G).
        int[] c = matrix.multiplyVectorMatrix(m, g);

        System.out.println("Užkoduotas vektorius C:");
        for(int i : c){
            System.out.print(i);
        }
        System.out.println();

        return c;
    }

    public int[] decode(int[] r) {
        // Metodui paduodama žinutė r gauta iš kanalo, naudojami papildomi veiksmai jai dekoduoti.
        int[][] h = createControlMatrix();
        int [][][] cosetLeaderSyndrome = createCosetLeaderSyndrome(h);
        Object[][] syndromeWeight = createSyndromeWeightTable(cosetLeaderSyndrome);
        int[] rMod = stepByStep(r, h, syndromeWeight); // Čia vykdomas dekodavimo algoritmas.
        System.out.println("Gautas rezultatas: ");
        matrix.printVector(rMod);
        System.out.println();
        return backToM(rMod); //r verčiama į m.
    }

    public int[][] createControlMatrix() {
        // Sukuriama kontrolinė matrica H (A(transponuota) | I).
        int k = this.g.length;
        int n = this.g[0].length;

        // Imama G matrica ir atskiriama į vienetinė matricą I ir dešiniau esančią matricą A.
        int[][] i = new int[k][k];
        int[][] a = new int[k][n - k];
        for (int row = 0; row < k; row++) {
            System.arraycopy(this.g[row], 0, i[row], 0, k);
            System.arraycopy(this.g[row], k, a[row], 0, n - k);
        }

        // Matrica A transponuojama.
        int[][] aTransposed = new int[n - k][k];
        for (int row = 0; row < n - k; row++) {
            for (int col = 0; col < k; col++) {
                aTransposed[row][col] = a[col][row];
            }
        }

        // Generuojama vienetinė matrica dydžo (n - k) * (n - k).
        int[][] iNew = new int[n - k][n - k];
        for (int row = 0; row < n - k; row++) {
            iNew[row][row] = 1;
        }

        // Matrica A(transponuota) "sulipdoma" su vienetine matrica I.
        int[][] h = new int[n - k][n];
        for (int row = 0; row < n - k; row++) {
            System.arraycopy(aTransposed[row], 0, h[row], 0, k);
            System.arraycopy(iNew[row], 0, h[row], k, n - k);
        }

        return h;
    }

    public int[][][] createCosetLeaderSyndrome(int[][] h) {
        // Metodui paduodama kontrolinė matrica H. Kuriama klasės lyderių ir jų atitinkančių sindromų lentelė.
        int rows = (int) Math.pow(2, n - k); //nustatoma kad lentelėje bus 2^(n-k) eilučių, kadangi toks yra galimų sindromų skaičius.
        int[][][] table = new int[rows][2][];

        int index = 0;
        for (int weight = 0; weight <= n && index < rows; weight++) {
            for (int i = 0; i < Math.pow(2, n) && index < rows; i++) {
                // Sugeneruojamas mažiausias klasės lyderis. Bitai stumiami į dešinę, todėl pradedame nuo 0(n kartų) ir dešinėje pridedame po vieną bitą.
                int[] cosetLeader = new int[n];
                for (int j = 0; j < n; j++) {
                    cosetLeader[j] = (i >> (n - j - 1)) & 1;
                }

                // tikrinama, ar gautas klasės lyderis yra mažiausio įmanomo svorio, jei ne, iš naujo sukame ciklą ir bandome naują klasės lyderį.
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += cosetLeader[j];
                }
                if (sum != weight) {
                    continue;
                }

                // Klasės lyderis transponuojamas.
                int[][] cosetLeaderTransposed = new int[n][1];
                for (int j = 0; j < n; j++) {
                    cosetLeaderTransposed[j][0] = cosetLeader[j];
                }

                // Skaičiuojamas sindromas
                int[] syndrome = matrix.multiplyMatrixVector(h, cosetLeaderTransposed);

                // Tikrinama, ar sindromas unikalus.
                boolean isUnique = true;
                for (int j = 0; j < index; j++) {
                    if (Arrays.equals(table[j][1], syndrome)) {
                        isUnique = false;
                        break;
                    }
                }

                // Jei sindromas unikalus, porą įdedame į lentelę.
                if (isUnique) {
                    table[index][0] = cosetLeader;
                    table[index][1] = syndrome;
                    index++;
                }
            }
        }

        return table;
    }

    public Object[][] createSyndromeWeightTable(int[][][] cosetLeaderSyndrome) {
        // Metodui paduodama klasės lyderių ir jų atitinkančių sindromų lentelė. Metodas ima sindromą, suskaičiuoja atitinkamą svorį bei išjaugoja abu šiuos duomenis lentelėje.
        int rows = cosetLeaderSyndrome.length;
        Object[][] table = new Object[rows][2];

        for (int i = 0; i < rows; i++) {
            // Imame sindromą ir dedame į lentelę.
            table[i][0] = cosetLeaderSyndrome[i][1];

            // Apskaičiuojame atitinkamo klasės lyderio svorį.
            int weight = 0;
            for (int j = 0; j < cosetLeaderSyndrome[i][0].length; j++) {
                weight += cosetLeaderSyndrome[i][0][j];
            }
            table[i][1] = weight;
        }

        return table;
    }

    public int[] stepByStep(int[] r, int[][] h, Object[][] syndromeWeight) {
        // Metodas gauna iš kanalo gautą žinutę r, kontrolinę matricą H ir sindromų bei atitinkamų svorių lentelę.
        // Metodas atlieka 5 žingsnių grandininį dekodavimo algoritmą
        int i = 0; // 1. Imami r elementai po vieną.
        while (i < r.length) {
            // 2.1 Skaičiuojama H*r(transponuotas)
            int[][] rTransposed = matrix.vectorToMatrix(r);
            int[] hr = matrix.multiplyMatrixVector(h, rTransposed);

            // 2.2 Gaunamas 2.1 dalyje gauto sindromo svoris
            int w = getWeight(syndromeWeight, hr);

            // 3. Jei 2.2 gautas svoris lygus 0: dekodavimo algoritmo pabaiga, grąžinamas r.
            if (w == 0) {
                return r;
            }

            // 4.1 r + e(i), suma transponuojama ir dauginama su H.
            int[] rei = matrix.addVectors(r, e(i));
            int[][] reiTransposed = matrix.vectorToMatrix(rei);
            int[] hrei = matrix.multiplyMatrixVector(h, reiTransposed);

            // 4.2 Jei H * ((r+e(i)transponuotas) svoris mažesnis nei w (w yra H * r(transponuotas) svoris), r = r + e(i).
            if (getWeight(syndromeWeight, hrei) < w) {
                r = rei;
            }

            // 5. i=i+1, keliaujam į 2. žingsnį.
            i++;
        }
        return r;
    }

    private int[] e(int i) {
        // Generuojamas n ilgio vektorius iš 0, išskyrus i poziciją, joje įrašomas 1.
        int[] e = new int[n];
        for (int j = 0; j < n; j++) {
            e[j] = 0;
        }
        e[i] = 1;
        return e;
    }

    public int getWeight(Object[][] syndromeWeight, int[] syndrome) {
        // Metodas gauna sindromų bei atitinkamų svorių lentelę bei sindromą.
        // Metodas grąžina grandininio dekodavimo 2 ir 4 žingsniuose naudojamus svorius pagal apskaičiuotą sindromą.
        for (int i = 0; i < syndromeWeight.length; i++) {
            // Lyginame turimą sindromą su sindromais lentelėje.
            if (Arrays.equals(syndrome, (int[]) syndromeWeight[i][0])) {
                // Kai rastas atitinkantis sindromas, paimame atitinkamą svorį
                return (int) syndromeWeight[i][1];
            }
        }
        // jei sindromas nerastas:
        System.out.println("! Klaida gaunant svorį iš sindromų & svorių porų lentelės !");
        return -1;
    }

    public int[] backToM(int[] rMod) {
        // Metodas gauna dekoduotą n ilgio žinutę r, verčia ją į k ilgio vektorių.
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = rMod[i];
        }
        return result;
    }

}
