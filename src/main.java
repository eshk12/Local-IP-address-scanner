import java.io.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        System.out.println("OctoPrint LAN IP Finder.\n");
        System.out.println("Please enter which octave you want to scan: ");
        Scanner r = new Scanner(System.in);
        int octave = r.nextInt();
        if(octave < 1 || octave > 255){
            throw new IOException("Octave should be between 0-255");
        }
        int k = 255;
        ThreadFinder[] threadFinders = new ThreadFinder[k+1];
        for(int i=1;i<=k;i++){
            threadFinders[i] = new ThreadFinder(octave,i);
            threadFinders[i].start();
        }

    }
}
