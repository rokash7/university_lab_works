import java.util.Random;

public class Channel {
    private double pe;
    private Random random;

    public Channel(double pe) {
        this.pe = pe;
        this.random = new Random();
    }

    public int[] transmit(int[] c) {
        int changes = 0;
        System.out.println("Vektorius gautas iš kanalo:");
        for (int i = 0; i < c.length; i++) {
            if (random.nextDouble() < pe) {
                c[i] = c[i] == 0 ? 1 : 0;
                changes++;
                System.out.print("[" + c[i] + "]");
            } else {
                System.out.print(c[i]);
            }
        }
        System.out.println();
        System.out.println("Klaidų skaičius: " + changes);
        return c;
    }

}
