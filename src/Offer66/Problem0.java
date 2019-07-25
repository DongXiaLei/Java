package Offer66;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class Problem0 {
    public static void main(String [] args){
        try{
            File configFile = new File("config.properties");
            //FileInputStream fis = new FileInputStream(configFile);
            // System.out.println(fis.read());
            FileOutputStream fos = new FileOutputStream(configFile);
            Properties config = new Properties();
            //create
            Date current = new Date();
            config.setProperty("Runtime",current.toString());  // entry key
            // save
            config.storeToXML(fos,"Properties Setting"); //comment
            config.list(System.out);
        }catch (final IOException e){
            System.out.println(e.getMessage());
        }
        //  XML format
        Properties prop = new Properties();
        prop.setProperty("username","dongxialei");
        prop.setProperty("brower","IE");
        prop.setProperty("showEmail","no");
        try{
            File file = new File("properties.xml");
            FileOutputStream fos = new FileOutputStream(file);
            Date now = new Date();
            prop.storeToXML(fos,"Created on" + now);
        }catch (final Exception e){
            System.out.println(e.getMessage());
        }
    }
}
