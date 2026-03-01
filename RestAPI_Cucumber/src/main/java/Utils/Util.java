package Utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Util {
    //public static String value;

    public static String getConfigProperties(String key) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(ConstantPath.configProp);
        prop.load(fis);

        return prop.getProperty(key.toString());
    }

    public static String getJsonPath(Response response, String key) {
        String res = response.asString();
        JsonPath js = new JsonPath(res);
        String value = js.get(key).toString();
        return value;
    }
}
