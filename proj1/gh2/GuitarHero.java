package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    int i;
    public void main(String[] args) {
        GuitarString[] strings = new GuitarString[keyboard.length()];
        for (int j = 0; j < keyboard.length(); j++) {
            double frequency = 440 * Math.pow(2.0, (j - 24) / 12);
            strings[j] = new GuitarString(frequency);
        }
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                if (keyboard.contains(Character.toString(key))) ;
                i = keyboard.indexOf(key);
                strings[i].pluck();
            }

            double sample = 0.0;
            for (int j = 0; j < keyboard.length(); j++) {
                sample += strings[j].sample();
            }
            StdAudio.play(sample);
            for (int p = 0; p < keyboard.length(); p++) {
                strings[p].tic();
            }
        }
    }
}

