import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
//ivestis per komandine eilute, kad galetum gauti apribojima random skaiciui

    public class NumberGuesser {
        public static void guessMethod(int randomNum)
        {
            String guess = new String();

            int guessI;
            String pagalbinisTekstas = new String();
            int state = 0;

            UIManager.put("OptionPane.cancelButtonText", "Atšaukti");
            UIManager.put("OptionPane.okButtonText", "Spėti");
            final JDialog dialog = new JDialog();
            dialog.setAlwaysOnTop(true);
            guess = JOptionPane.showInputDialog(
                    dialog,
                    "Spėkite skaičių",
                    "Skaičiaus Spėjimas",
                    JOptionPane.QUESTION_MESSAGE
            );

            try{
                if (guess == null) {return;}
                guessI = Integer.parseInt(guess);

                if (guessI == randomNum) {
                    pagalbinisTekstas = "Spėjimas teisingas!";
                    state = 1;
                } else if (guessI > randomNum) {
                    pagalbinisTekstas = "Skaičius, kurį sugalvojote yra per didelis.";
                } else if (guessI < randomNum) {
                    pagalbinisTekstas = "Skaičius, kurį sugalvojote yra per mažas.";
                }

                UIManager.put("OptionPane.okButtonText", "Gerai");
                JOptionPane.showMessageDialog(
                        null,
                        pagalbinisTekstas,
                        "Pagalba",
                        JOptionPane.WARNING_MESSAGE
                );
            } catch (Exception e) {
                UIManager.put("OptionPane.okButtonText", "Gerai");
                JOptionPane.showMessageDialog(
                        null,
                        "Įveskite sveikąji skaičių",
                        "Klaida",
                        JOptionPane.WARNING_MESSAGE
                );
            }

            if (state == 0) {
                guessMethod(randomNum);
            } else if (state == 1) {
                return ;
            }
    }

    public static void guessUtil(int randomNum)
    {
        String[] args = new String[0];
        guessMethod(randomNum);

        Object[] options = {"Taip", "Ne"};
        int n = JOptionPane.showOptionDialog(
                null,
                "Ar norite žaisti dar kartą?",
                "Skaičiaus Spėjimas",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]
        );

        if (n == 0) {
            main(args);
        } else if (n == 1) {
            System.exit(0);
        }
    }

    public static int riba()
    {
        String ribaS = new String();
        int ribaI = 0;

        while (true) {
            try {
                System.out.println("Įveskite maksimalų generuojamą skaičių: ");
                Scanner input = new Scanner(System.in);
                ribaS = input.nextLine();
                ribaI = Integer.parseInt(ribaS);

                break;

            } catch (Exception e) {
                System.out.println("Įveskite sveikąjį skaičių.");
            }
        }

        return ribaI;
    }

    public static void main(String[] args)
    {
        int riba = 0;
        try {
            riba = Integer.parseInt(args[0]);
        }
        catch (Exception e) {
            String[] ribaS;

            System.out.println("Įveskite sveikąjį skaičių.\n");
            Scanner input = new Scanner(System.in);
            ribaS = new String[]{input.nextLine()};
            main(ribaS);
        }

        //riba = riba();

        System.out.println("Generuojamo skaičiaus riba: " + riba);

        Random randomizer = new Random();
        int randomNum;

        randomNum = randomizer.nextInt(riba);
        System.out.println("Atsakymas: " + randomNum);

        guessUtil(randomNum);
    }

}
