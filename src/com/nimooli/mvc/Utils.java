package com.nimooli.mvc;

import com.nimooli.mvc.model.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nima Ghafoori on 5/9/14.
 */
public class Utils {

    public static final URL MOUSE_IMAGE_URL = Utils.class.getResource("resources/mouse.png");
    public static final URL MOUSE_TRAPPED_URL = Utils.class.getResource("resources/mouse_trapped.png");
    public static final URL CAT_IMAGE_URL = Utils.class.getResource("resources/cat.png");
    public static final URL CAT_TRAPPED_URL = Utils.class.getResource("resources/cat_trapped.png");
    public static final URL CHEESE_IMAGE_URL = Utils.class.getResource("resources/cheese.png");
    public static final URL TRAP_IMAGE_URL = Utils.class.getResource("resources/trap.png");
    public static final URL MOVABLE_IMAGE_URL = Utils.class.getResource("resources/movable.png");
    public static final URL UNMOVABLE_IMAGE_URL = Utils.class.getResource("resources/unmovable.png");
    public static final URL EMPTY_IMAGE_URL = Utils.class.getResource("resources/empty.png");

    /**
     * Loads a configuration file and parses its configuration.
     * If parsing goes without error, a Config object is created
     *
     * @throws java.lang.Exception        If file doesn't exist or is a directory.
     * @throws java.lang.RuntimeException If file does not contain valid configuration.
     */
    public static Config getElementsFromFile(String filePath) throws Exception {

        Config config = null;
        File file;
        FileInputStream fis = null;
        BufferedReader reader = null;
        int maxLineLngth; // The first line in input file determines the maximum length of a row
        List<Element> elementsFromConfig = new ArrayList<Element>();


        try {
            file = new File(filePath);

            if (!file.exists() || file.isDirectory()) {
                throw new Exception("File " + filePath + " does not exist or is a directory");

            } else {
                if (!file.canRead()) {
                    throw new Exception("File " + filePath + " can't be read. Do you have sufficient permission?");
                }
            }

            // Read the file character by character and parse it
            fis = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(fis));

            String line = reader.readLine();
            maxLineLngth = line.length();

            if (maxLineLngth == 0) {
                throw new Exception("File " + filePath + " contains an empty row.");
            }

            while (line != null) {
                for (char c : line.toCharArray()) {
                    Element e;
                    if (c == ' ') {
                        e = getElementFromChar('e');
                    } else {
                        e = getElementFromChar(c);
                    }
                    elementsFromConfig.add(e);
                }
                line = reader.readLine();
            }

            config = new Config(elementsFromConfig, maxLineLngth);


        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            try {

                if (reader != null)
                    reader.close();

                if (fis != null)
                    fis.close();

            } catch (IOException e) {
            }
        }

        return config;
    }


    /**
     * @param c Character representing an element
     * @return an Element for valid c or null otherwise
     * <p/>
     * Possible characters:
     * c - cat
     * m - mouse
     * x - unmovable block
     * b - movable block
     * t - trap
     * h - cheese
     * e - empty
     */
    private static Element getElementFromChar(char c) {

        Element element = null;
        c = Character.toLowerCase(c);

        switch (c) {
            case 'c':
                element = new Cat();
                break;
            case 'm':
                element = new Mouse();
                break;
            case 'x':
                element = new ConstantBlock();
                break;
            case 'b':
                element = new MovableBlock();
                break;
            case 't':
                element = new Trap();
                break;
            case 'h':
                element = new Cheese();
                break;
            case 'e':
                element = new Empty();
                break;
            case 'u':
                element = new ConstantBlock();
                break;
        }

        return element;
    }

}
