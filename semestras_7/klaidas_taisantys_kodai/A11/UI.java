import java.util.Scanner;

public class UI {
    public void init() {
        Scanner scanner = new Scanner(System.in);
        Matrix matrix = new Matrix();

        System.out.println("Įveskite koduojamo vektoriaus ilgį (kodo dimensiją):");
        int k = scanner.nextInt();
        scanner.nextLine();

        int n;
        do {
            System.out.println("Įveskite kodo ilgį:");
            n = scanner.nextInt();
            scanner.nextLine();
            if (n < k) {
                System.out.println("Kodo ilgis turi būti lygus arba didesnis už kodo dimensiją.");
            }
        } while (n < k);

        int[][] g;
        System.out.println("Jei norite įvesi generuojančią matricą, įveskite simbolį \"y\":");
        String genSelection = scanner.nextLine();
        if(genSelection.equals("y")){
            g = matrix.createMatrix(k, n, scanner);
        } else {
            g = matrix.generateMatrix(k, n);
        }

        System.out.println("Pasirinkite programos darbo scenarijų įvesdami numerį:\n" +
                "1. Vektoriaus kodavimas\n" +
                "2. Teksto kodavimas\n" +
                "3. Paveikslėlio kodavimas\n" +
                "0. Išeiti iš programos\n");

        String scenarioSelection = scanner.nextLine();
        switch (scenarioSelection){
            case "1":
                scenario1(n, k, g);
                break;
            case "2":
                break;
            case "3":
                break;
            case "0":
                System.exit(0);
        }
    }

    private void scenario1(int n, int k, int[][] g){
        Scanner scanner = new Scanner(System.in);
        LinearCode linearCode = new LinearCode(n, k, g);

        Matrix matrix = new Matrix();

        int[] m;
        do {
            System.out.println("Įveskite " + k + " bitų ilgio vektorių:");
            String bitString = scanner.nextLine();
            if (k != bitString.length() || !bitString.matches("[01]+")) {
                System.out.println("Neteisingai įvestas vektorius. Prašome įvesti " + k + " bitų ilgio vektorių, kuris susideda tik iš 0 ir 1.");
            } else {
                m = new int[bitString.length()];
                for (int i = 0; i < bitString.length(); i++) {
                    m[i] = bitString.charAt(i) == '1' ? 1 : 0;
                }
                break;
            }
        } while (true);

        double p;
        do {
            System.out.println("Įveskite paklaidos tikimybę (0-1), dešimtainė pozicija skiriama kableliu: ");
            p = scanner.nextDouble();
            scanner.nextLine();
            if (p < 0 || p > 1) {
                System.out.println("Neteisinga įvestis. Prašome įvesti skaičių tarp 0 ir 1.");
            }
        } while (p < 0 || p > 1);

        Channel channel = new Channel(p);

        int[] c = linearCode.encode(m); // užkoduota žinutė
        int[] r = channel.transmit(c); //žinutė išėjusi iš kanalo

        do {
            System.out.println("Ar norite pakeisti vektorių gautą iš kanalo? Jei ne, tiesiog paspauskite 'Enter'. Jei taip, įveskite naują reikšmę:");
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                if (input.length() == r.length && input.matches("[01]+")) {
                    r = input.chars().map(ch -> ch - '0').toArray();
                    break;
                } else {
                    System.out.println("Neteisinga įvestis. Prašome įvesti " + r.length + " bitų ilgio vektorių, kuris susideda tik iš 0 ir 1.");
                }
            } else {
                break;
            }
        } while (true);

        int[] returnedM = linearCode.decode(r); //dekoduojama žinutė
        System.out.println("Dekoduotas vektorius: ");
        matrix.printVector(returnedM);
    }

}
