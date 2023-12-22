package pages;

import java.io.File;
import java.io.IOException;

import com.jayway.jsonpath.JsonPath;

public class CommonUtility {

    public static String getWebLocator(String webLocator, String jsonFilePath) throws IOException {
        File jsonFile=new File(jsonFilePath);
        return JsonPath.read(jsonFile, "$."+ webLocator);

    }
}
