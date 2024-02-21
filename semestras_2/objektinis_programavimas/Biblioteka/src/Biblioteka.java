import Gui.GUI;
import Leidinys.DVD;
import Leidinys.Knyga;
import Test.Test;
import Threads.AutoSaveThread;
import Zmogus.Darbuotojas;
import Zmogus.Skaitytojas;

public class Biblioteka{

    public static void main(String[] args) {

        Lists lists = new Lists();
        lists.deserialize();

//        Test test = new Test(5, lists.getSkaitytojai(), lists.getDarbuotojai(), lists.getKnygos(), lists.getDvd());
//        test.beginTest();

//        GUI gui = new GUI();
//
//        int n = 5;
//        Test test1 = new Test(n);
//        test1.beginTest();

        AutoSaveThread autoSave = new AutoSaveThread(lists.getSkaitytojai(), lists.getDarbuotojai(), lists.getKnygos(), lists.getDvd());
        autoSave.run();
    }

}
