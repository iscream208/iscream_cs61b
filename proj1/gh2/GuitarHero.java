package gh2;

import deque.ArrayDeque;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;
import org.eclipse.jetty.util.UrlEncoded;

public class GuitarHero {
    public static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static ArrayDeque<GuitarString> notes=new ArrayDeque<>();
    public static void main(String[] args) {

        /* create two guitar strings, for concert A and C */
        for(int i=0;i<37;i++){
            notes.addLast(new GuitarString((double)440*Math.pow(2,(i-24)/12)));
            System.out.println((double)440*Math.pow(2,(i-24)/12));
        }

        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if(keyboard.indexOf(key)!=-1){
                    notes.get(keyboard.indexOf(key)).pluck();
                }

            }

            /* compute the superposition of samples */
            double sample=0;
            for(int i=0;i<37;i++){
                sample+=notes.get(i).sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
                for(int i=0;i<37;i++){
                    notes.get(i).tic();
                }
        }
    }
}
