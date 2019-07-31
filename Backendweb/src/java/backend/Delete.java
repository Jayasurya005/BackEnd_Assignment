/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author BALAJI
 */
public class Delete {
    public static void removedata(File tempfile,String key) throws FileNotFoundException, IOException, ParseException{
        Object obj1 = new JSONParser().parse(new FileReader("C:\\Users\\USER\\Documents\\NetBeansProjects\\Backendweb\\"+tempfile)); 
        JSONArray ja = (JSONArray) obj1; 
        Iterator itr2 = ja.iterator(); 
        int i=0;int flag=0;
        while (itr2.hasNext())  
        { 
            Iterator<Map.Entry> itr1 = ((Map) itr2.next()).entrySet().iterator(); 
            while (itr1.hasNext()) { 
                Map.Entry pair = itr1.next();
                if(pair.getKey().equals(key)){
                    Object i1=ja.remove(i);
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                break;
            }
            i++;
        }
        if(flag==0){
            System.out.println("Element not present");
        }
        else{
            FileWriter file1 = new FileWriter("C:\\Users\\USER\\Documents\\NetBeansProjects\\Backendweb\\"+tempfile);
            file1.write(ja.toJSONString());
            file1.close();
        }
    }
}
