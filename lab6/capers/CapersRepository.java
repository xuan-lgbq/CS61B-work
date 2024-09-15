package capers;

import java.io.File;
import java.io.IOException;

import static capers.Utils.*;

/** A repository for Capers 
 * @author TODO
 * The structure of a Capers Repository is as follows:
 *
 * .capers/ -- top level folder for all persistent data in your lab12 folder
 *    - dogs/ -- folder containing all of the persistent data for dogs
 *    - story -- file containing the current story
 *
 * TODO: change the above structure if you do something different.
 */
public class CapersRepository {
    /** Current Working Directory. */
    static final File CWD = new File(System.getProperty("user.dir"));

    static final File CAPERS_FOLDER = join(CWD,"metadata"); // TODO Hint: look at the `join`
    //      function in Utils
    static final File STORY_LIFE=join(CAPERS_FOLDER,"story");
    static final File DOG_FOLDER = join(CAPERS_FOLDER, "Dogs");
    /**
     * Does required filesystem operations to allow for persistence.
     * (creates any necessary folders or files)
     * Remember: recommended structure (you do not have to follow):
     *
     * .capers/ -- top level folder for all persistent data in your lab12 folder
     *    - dogs/ -- folder containing all of the persistent data for dogs
     *    - story -- file containing the current story
     */
    public static void setupPersistence() {
        // TODO
        if (!CAPERS_FOLDER.exists()) {
            CAPERS_FOLDER.mkdirs();
        }

        if (!DOG_FOLDER.exists()) {
            DOG_FOLDER.mkdirs();
        }
        if (!STORY_LIFE.exists()) {
            try {
                STORY_LIFE.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Appends the first non-command argument in args
     * to a file called `story` in the .capers directory.
     * @param text String of the text to be appended to the story
     */
    public static void writeStory(String text) {
        // TODO
        if(STORY_LIFE.length()==0){
            writeContents(STORY_LIFE,text);
            System.out.println(text);
        }
        else {
            String existingText = readContentsAsString(STORY_LIFE);
            text = existingText + "\n" + text;
            writeContents(STORY_LIFE, text);
            System.out.println(text);
        }
    }

    /**
     * Creates and persistently saves a dog using the first
     * three non-command arguments of args (name, breed, age).
     * Also prints out the dog's information using toString().
     */
    public static void makeDog(String name, String breed, int age) {
        // TODO
        Dog g=new Dog(name,breed,age);
        g.saveDog();
        System.out.println(g.toString());
    }
    /**
     * Advances a dog's age persistently and prints out a celebratory message.
     * Also prints out the dog's information using toString().
     * Chooses dog to advance based on the first non-command argument of args.
     * @param name String name of the Dog whose birthday we're celebrating.
     */
    public static void celebrateBirthday(String name) {
        // TODO
        Dog a=Dog.fromFile(name);
        if(a!=null) {
            a.haveBirthday();
            a.saveDog();
        }
    }
}
