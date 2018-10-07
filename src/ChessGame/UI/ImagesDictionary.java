package ChessGame.UI;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;

/**
 * Hash map that contains all the images needed for the program.
 */
public class ImagesDictionary {

    //region Fields:
    /**
     * Map contains the String path of the image and the image.
     */
    private Map<SourceURL, Image> dictionary;

    //endregion Fields:

    //region Constructor
    public ImagesDictionary() {
        this.dictionary = new HashMap<>();
    }

    //endregion Constructor

    /**
     * The function returns an image according to the key.
     *
     * @param key - input SourceURL represents the path of the image
     * @return
     */
    public Image getImage(SourceURL key) {
        if (key != null) {
            return dictionary.get(key);
        } else {
            return null;
        }
    }

    /**
     * The function add image to the dictionary.
     *
     * @param newImageSource - new SourceURL path to add to the dictionary
     */
    public void addImage(SourceURL newImageSource) {

        if (newImageSource != null) {
            //insert the new image only if it's a valid 'URLResources' enum
            Image toAdd = new Image("file:" + newImageSource.toString(),40,40,true,true);
            this.dictionary.put(newImageSource, toAdd);
        }
    }

    /**
     * The function initializes the Hash map with all the images
     */
    public void initImages() {
        SourceURL[] allSources = SourceURL.values();
        for (int i = 0; i < allSources.length; i++) {
            this.addImage(allSources[i]);
        }

    }
}
