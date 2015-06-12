package mnfc.com.br.atividadescolaborativasapp.lib.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by Core i5 on 12/06/2015.
 */
public class StringUtils {

    public static String toUTF8(String string){
        try {
            return URLDecoder.decode(string,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return string;
        }
    }
}
