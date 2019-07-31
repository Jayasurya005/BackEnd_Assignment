package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Read {
public static String dataread(File tempfile,String key) throws FileNotFoundException, IOException, ParseException{
        Object obj = new JSONParser().parse(new FileReader("C:\\Users\\USER\\Documents\\NetBeansProjects\\Backendweb\\"+tempfile)); 
        JSONArray ja = (JSONArray) obj; 
        Iterator itr2 = ja.iterator(); 
        int flag=0;
        while (itr2.hasNext())  
        { 
            Iterator<Map.Entry> itr1 = ((Map) itr2.next()).entrySet().iterator();   
            while (itr1.hasNext()) { 
                Map.Entry pair = itr1.next();
                if(pair.getKey().equals(key)){
                    return (pair.getKey() + " : " + pair.getValue());
                    }
            }
        }
        return "Error";
        }    
}
