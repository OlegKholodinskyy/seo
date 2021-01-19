package helpers;

import javax.swing.text.Style;
import java.util.*;

/**
 * Created by oleg on 30.11.2020.
 */
public final class LinkHolder {

    private static LinkHolder instance;

    private LinkHolder() {
        buildMap();
    }


    public static LinkHolder getInstance() {
        if (instance == null) {
            instance = new LinkHolder();
        }
        return instance;
    }


    Map<String, String[][]> results = new HashMap<String, String[][]>();

    public void buildMap() {

        results.put("доставка цветов", new String[][]{jasminVarna, flowers, mfl});
        results.put("шампунь", new String[][]{bioport, dushka, hotline, bonvivant});
        results.put("газелькин", new String[][]{della, dresskot, sharmexcursions});
        results.put("клининговая компания", new String[][]{forline, chisto, bestCleaning});
        results.put("форекс", new String[][]{canlimarket});
        results.put("ремонт квартир москва", new String[][]{www0200200v, sknebo, svoiservice, petkostroy});
        results.put("доставка цветов и букетов", new String[][]{caramellu, sunrose});
        results.put("ремонт под ключ", new String[][]{yaskravaliniya});
        results.put("расчетный счет", new String[][]{pandacash, artzvit});
        results.put("нарколог в москве", new String[][]{medcm, narkohelp, rehabclinic});
        results.put("быстрая доставка еды москва", new String [][]{russkoepodvorie, sushifast});
    }


    String[] sushifast = {
            "www.sushifast.ru",
            "sushifast.ru/menu/",
            "sushifast.ru/delivery/",
            "sushifast.ru/feedback/",
            "sushifast.ru/action/",
            "instagram.com/sushifast_nekrasovka/"
    };

    String[] russkoepodvorie = {
            "www.russkoepodvorie.com",
            "/banketnye-zaly-v-moskve/",
            "instagram.com/russkoepodvorie_moscow/",
            "facebook.com/RusskoePodvorie/",
            "/catalog/category/dostavka/",
            "facebook.com/RusskoePodvorie/"
    };

    String[] petkostroy = {
            "www.petko-stroy.com",
            "./о-нас",
            "./портфолио",
            "./контакты",
            "static.wixstatic.com/media",
            "./о-нас"
    };

    String [] svoiservice = {
            "www.svoi-service.ru",
            "/landing/kuxni-landing",
            "/landing/balkon",
            "/vakansii",
            "/vopros-otvet",
            "/kontakti",
            "/o-kompanii",
            "/landing/bath-landing"
    };

    String[] rehabclinic = {
            "www.rehabclinic.ru",
            "fotogalereya",
            "spetsialisty",
            "kontakty",
            "virtualnaya-ekskursiya",
            "modal-callback"
    };

    String[] narkohelp = {
            "www.narkohelp.com/",
            "psihiatriya",
            "reabilitatsiya/",
            "lechenie-narkomanii-2",
            "tseny",
            "o-klinike"
    };


    String[] medcm = {
            "www.medcm.ru",
            "usl",
            "spec",
            "photo",
            "lic",
            "contacts",
            "polit.pdf"
    };

    String[] artzvit = {
            "www.art-zvit.com.ua",
            "vidguky",
            "akcii",
            "docs.art-zvit.com.ua",
            "contacts",
            "spivpratsia",
            "instance-sert",
            "eds/",
            "aca-masterkey"
    };

    String[] pandacash = {
            "www.pandacash.com.ua/",
            "кредитные-карты",
            "потребительский-кредит",
            "акции_промокоды",
            "моментальные-онлайн-кредиты",
            "кредитные-карты"
    };


    String[] yaskravaliniya = {
            "www.yaskrava-liniya.com.ua/",
            "o-nas/",
            "blog/",
            "nashi-raboty/",
            "osveshhenie/",
            "katalog/",
            "servisy/",
            "dileram/",
            "goroda/"
    };

    String[] sunrose = {
            "www.sunrose.com.ua",
            "flowers",
            "icon-menu-compositions",
            "gifts",
            "occasion",
            "deals",
            "foto",
            "faq"
    };


    String[] caramellu = {
            "www.caramellu.com.ua",
            "izolon",
            "info",
            "contacts",
            "tychinki",
            "tsvety",
            "gotovye-izdeliya"
    };


    String[] sknebo = {
            "www.sknebo.ru",
            "#about",
            "vakansii",
            "testimonials",
            "news",
            "#about"};

    String[] bonvivant = {
            "www.bonvivant.ua/",
            "https://bonvivant.ua/body/",
            "https://bonvivant.ua/men/",
            "https://bonvivant.ua/kids/",
            "https://bonvivant.ua/beauty-box/",
            "https://bonvivant.ua/brands/",
            "contact-us/",
            "https://bonvivant.ua/hair/"
    };

    String[] dushka = {
            "www.dushka.ua",
            "www.dushka.ua/catalog/filters",
            "www.dushka.ua/news",
            "www.dushka.ua/shipping-and-payment",
            "www.dushka.ua/contacts",
            "www.dushka.ua/news"
    };


    String[] sharmexcursions = {
            "www.sharm-excursions.net",
            "sharm-excursions.net/ekskursii/",
            "www.sharm-excursions.net/kruizy",
            "www.sharm-excursions.net/bronirovanie",
            "www.sharm-excursions.net/dopolnitelnaia-informatsiia",
            "#individual"
    };


    String[] hotline = {
            "www.hotline.ua",
            "/reviews/",
            "/page/user_agreement/#rules",
            "/feedback/",
            "/help/",
            "/loyalty/",
            "/page/user_agreement/",
            "/about/sales/"
    };


    String[] www0200200v = {
            "www.0200200.ru/",
            "new.htm",
            "black.htm",
            "video.htm",
            "new/Раменское.php",
            "new/Люберцы.php",
            "new/Щербинка.php"
    };


    String[] canlimarket = {
            "www.canli-market.org",
            "https://www.facebook.com/AMarketsRu",
            "https://twitter.com/amarkets_ru",
            "http://www.youtube.com/c/AMarkets/",
            "https://www.instagram.com/amarkets_rus/",
            "https://telegram.me/Amarkets"
    };


    String[] bestCleaning = {
            "www.best-cleaning.te.ua/",
            "#contact",
            "#form",
            "#poslugi",
            "work",
            "#contact"
    };


    String[] forline = {
            "www.forline.ua/",
            "https://forline.ua/ru/korporativnye-resheniya/",
            "https://forline.ua/ru/novosti-i-aktsii/",
            "https://forline.ua/ru/stati/",
            "https://forline.ua/ru/kontakty/",
            "https://forline.ua/ru/uslugi/klining/ekspress-uborka/",
            "https://forline.ua/ru/uslugi/klining/kompleksnaya-uborka/",
            "https://forline.ua/ru/uslugi/klining/generalnaya-uborka-pomeshhenij-ofisov-domov-kvartir-skladov/",
            "https://forline.ua/ru/uslugi/klining/himchistka-myagkoj-mebeli/",
            "https://forline.ua/ru/uslugi/autstaffing/",
            "/ru/istoriya/",
            "/ru/vakansii/",
            "/ru/sotsialnaya-otvetstvennost/"
    };


    String[] chisto = {
            "www.chisto.ua/",
            "/services.html",
            "/about.html",
            "/blog.html",
            "/dyson.html",
            "/about.html"
    };


    String[] dresskot = {
            "www.dresskot.com.ua",
            "https://dresskot.com.ua/odejda",
            "https://dresskot.com.ua/aksessuary-sumki-ochki-sharfy",
            "https://dresskot.com.ua/obuv",
            "/index.php?route=product/manufacturer",
            "http://dresskot.com.ua/index.php?route=product/special",
            "https://dresskot.com.ua/odejda/shorty",
            "https://dresskot.com.ua/odejda/sportivnaya-odezhda",
            "https://dresskot.com.ua/odejda/kurtki-i-palto"
    };


    String[] della = {
            "www.della",
            "/currency/",
            "/prices/",
            "//della.com.ua/contact_us/",
            "/price/local/",
            "/price/international/",
            "/distance/",
            "//della.com.ua/sitemap/"
    };


    String[] bioport = {
            "www.bioport.com.ua/",
            "https://bioport.com.ua/product-category/volossya/",
            "https://bioport.com.ua/contacts/",
            "https://bioport.com.ua/privacy-policy/",
            "bioport.com.ua/product-category/brendy/",
            "bioport.com.ua/product-category/fitnes/",
            "bioport.com.ua/product-category/aparaty/",
            "bioport.com.ua/d-map/"};


    String[] mfl = {
            "www.mfl.com.ua/",
            "usloviya-uk",
            "oplata-uk",
            "o-nas-uk",
            "serdca-iz-cvetov-uk",
            "korziny-cvetov-uk",
            "fruktovye-korziny",
            "podarki",
            "cart",
            "terms-conditions"};


    String[] jasminVarna = {
            "www.jasmin-varna.com/",
            "buketi",
            "buketi-svatba",
            "contacts",
            "za-nas",
            "buketi-za-8-mart",
            "buketi-za-svvalentin",
            "products",
            "products"};

    String[] flowers = {
            "www.flowers.ua/",
            "new",
            "bouquets_of_tulips",
            "tsvety-lyubimoy",
            "delivery",
            "cvety_v_korobke",
            "guestbook",
            "komnatnye-rasteniya",
            "korziny-tsvetov"
    };


    public String getRandomKey() {
        Set<String> keys = results.keySet();
        //convert HashSet to an array
        String[] arrayStrings = keys.toArray(new String[keys.size()]);
        Random random = new Random();
//this will generate a random number between 0 and HashSet.size - 1
        int randomNumber = random.nextInt(keys.size());
//get the element at random number index from the array
        String randomElement = arrayStrings[randomNumber];
        return randomElement;
    }

    public String getRandomResulrSite(String randonLink) {

        String[][] str = results.get(randonLink);

        Random random = new Random();
//this will generate a random number between 0 and HashSet.size - 1
        int randomNumber = random.nextInt(str.length);
        String[] randomElementInArrayPresentation = str[randomNumber];
        String res = randomElementInArrayPresentation[0];


        System.out.println("Random element: " + res);


        return res;
    }

    public String[][] getValue(String randomKey) {
        return results.get(randomKey);
    }

    public String[] getlinks(String randomKey, String key) {

        String[][] arr = results.get(randomKey);
        for (String[] lnk : arr) {
            if (lnk[0].equals(key)) {
                return lnk;
            }
        }
        return null;
    }
}


