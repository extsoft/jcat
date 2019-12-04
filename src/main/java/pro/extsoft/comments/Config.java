package pro.extsoft.comments;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

public class Config
{
    Properties prop = new Properties();
    ArrayList<String> resutltList = new ArrayList<String>();


    public ArrayList<String>  getrestProperty(String key,String path) throws IOException
    {
        String result = "";

        //String path = "dev.properties";
        File file = new File (path);
        System.out.print(file.getAbsolutePath());


        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);

        if (inputStream != null)
        {

            prop.load(inputStream);
            result = prop.getProperty (key);

        } else {
            throw new FileNotFoundException("property file '" + path + "' not found in the classpath");
        }

        resutltList.add(result);
        resutltList.add(file.getAbsolutePath());
        return resutltList;
    }

}