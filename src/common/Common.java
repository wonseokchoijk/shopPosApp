package common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import common.Consts;

public class Common {



    /**
     * 프로퍼티 파일로부터 특정 키값을 반환한다.
     */
    public static String getProperty(String keyName) {
        String value = null;
  
        try {
        	File propertiesFile = new File(Consts.PROPERTIES_FILE);
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream(propertiesFile.getCanonicalFile());
            props.load(new java.io.BufferedInputStream(fis));
            value = props.getProperty(keyName).trim();
            fis.close();
        } catch (java.lang.Exception e) {
            System.out.println(e.toString());
        }
            return value;
    }
}
