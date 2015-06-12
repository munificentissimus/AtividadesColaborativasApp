package mnfc.com.br.atividadescolaborativasapp.lib;

/**
 * Created by Core i5 on 12/06/2015.
 */
public class Config {
    private final static String URL_API = "https://prointeriv-munificentissimus1.c9.io/api";
    private final static String ENCODING_PADRAO = "UTF-8";
    public static final String PREFERENCES = "AppPrefs" ;

    public static String getPREFERENCES() {
        return PREFERENCES;
    }

    public static String getEncodingPadrao() {
        return ENCODING_PADRAO;
    }

    public static String getUrlApi(){
        return Config.URL_API;
    }
}
