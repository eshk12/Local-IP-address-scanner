import java.util.Arrays;
import java.util.Objects;

public class ThreadFinder extends Thread {
    private int ThridOctave;
    private int FourthOctave;
    private String arr[];

    public ThreadFinder(int ThridOctave, int FourthOctave) {
        this.ThridOctave = ThridOctave;
        this.FourthOctave = FourthOctave;
    }

    @Override
    public void run() {
        HTTP_Request functions = new HTTP_Request();
        boolean serverStatus = false;
        String results = functions.isOnline("http://192.168." + ThridOctave + "." + FourthOctave);
        if (!results.equals("not-found"))
             System.out.println(results);
    }
}


