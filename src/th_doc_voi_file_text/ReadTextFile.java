package th_doc_voi_file_text;

import java.io.*;
import java.lang.reflect.Field;

public class ReadTextFile {
    public static void main(String[] args) {
        try {
            File inFile = new File(  "Hello.text");
            FileReader fileReader = new FileReader( inFile );
            BufferedReader reader = new BufferedReader( fileReader );
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
