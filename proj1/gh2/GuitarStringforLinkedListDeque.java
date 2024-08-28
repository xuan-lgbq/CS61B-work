package gh2;

import deque.LinkedListDeque;

public class GuitarStringforLinkedListDeque{
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor
    private int capacity;
    private LinkedListDeque<Double> bufferList;

    public GuitarStringforLinkedListDeque(double frequnency) {
        capacity = (int) Math.round(SR / frequnency);
        bufferList = new LinkedListDeque<>();
        for (int i = 0; i < capacity; i++) {
            bufferList.addFirst(0.0);
        }
    }

    /* Create a guitar string of the given frequency.  */
    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluckforLinkedList() {
        // TODO: Dequeue everything in buffer, and replace with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //
        //       Make sure that your random numbers are different from each
        //       other. This does not mean that you need to check that the numbers
        //       are different from each other. It means you should repeatedly call
        //       Math.random() - 0.5 to generate new random numbers for each array index.
        for (int i = 0; i < capacity; i += 1) {
            double r = Math.random() - 0.5;
            bufferList.addLast(r);
            bufferList.removeFirst();
        }
    }

    public void ticforLinkedList() {
        //TODO: Dequeue the front sample and enqueue a new sample that is
        // the average of the two multiplied by the DECAY factor.
        //**Do not call StdAudio.play().**
        if (bufferList.isEmpty()) {
            return;
        }
        double first = bufferList.removeFirst();
        Double second = bufferList.get(0);
        //Double is a pack series while double is data type, using Double can compare with the empty point (null) to avoid the NullPointException
        if (second == null) {
            return;
        }
        bufferList.addLast(DECAY * ((first + second) / 2));
    }

    /* Return the double at the front of the buffer. */
    public double sampleforLinkedList() {
        // TODO: Return the correct thing.
        return bufferList.get(0);
    }
}
