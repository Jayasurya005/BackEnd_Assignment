package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Create 
{
    public static void datastore(File tempfile,String key) throws FileNotFoundException, IOException, ParseException
    {
         Scanner scan =new Scanner(System.in);
        JSONObject ob=new JSONObject();
        Object obj = new JSONParser().parse(new FileReader("C:\\Users\\USER\\Documents\\NetBeansProjects\\Backendweb\\input.json")); 
        JSONObject jo = (JSONObject) obj; 
        JSONArray ja = new JSONArray();
        ja.add(jo);
        ob.put(key,ja);
        FileReader fr=new FileReader("C:\\Users\\USER\\Documents\\NetBeansProjects\\Backendweb\\"+tempfile);
        JSONArray ja1=null;
        if(fr.read()==-1){
            ja1 = new JSONArray();
            ja1.add(ob);    
            FileWriter file1 = new FileWriter("C:\\Users\\USER\\Documents\\NetBeansProjects\\Backendweb\\"+tempfile);
            file1.write(ja1.toJSONString());
            file1.close();
        }
        else{
            Object obj1 = new JSONParser().parse(new FileReader(tempfile));
            ja1 = (JSONArray) obj1;
            ja1.add(ob);
            FileWriter file1 = new FileWriter(tempfile);
            file1.write(ja1.toJSONString());
            file1.close();
        }
        fr.close();
    } 
}