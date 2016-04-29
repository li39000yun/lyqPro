package sy.model.common;

/**
 * Created by lyq on 2016/4/29.
 */
public class StringManage {

    public final static String FS_EMPTY = "";

    public static boolean isEmpty(String factoryName) {
        if (factoryName != null && factoryName != "") {
            return true;
        }
        return false;
    }
}
