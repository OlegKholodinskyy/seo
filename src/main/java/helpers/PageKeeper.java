package helpers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oleg on 26.11.2020.
 */
public class PageKeeper {

    private static  PageKeeper instance;
    Map<String, String> pages = new HashMap<String, String>();

    private PageKeeper() {
    }

    public static PageKeeper getInstance(){
        if (instance == null){
            instance = new PageKeeper();
        }
        return instance;
    }


    public Map<String, String> getPages() {
        return pages;
    }

    public void addPageToMap(String name, String title) {
        pages.put(name, title);
    }

    public void remotePageFromMap(String name) {
        pages.remove(name);
    }


}
