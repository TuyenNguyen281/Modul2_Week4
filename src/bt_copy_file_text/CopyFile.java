package bt_copy_file_text;

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public void copyFile(String source, String dest) {
        try {
            File is = new File( source );
            if (!is.exists()) {
                throw new FileNotFoundException();
            }
            File os = new File( dest );
            if (!os.exists()) {
                throw new FileNotFoundException();
            }

            FileReader fileReader = new FileReader( is );
            BufferedReader bris = new BufferedReader( fileReader );
            FileWriter fileWriter = new FileWriter( os );
            BufferedWriter bros = new BufferedWriter( fileWriter );

            int sum = 0;
            int dem = 0;
            while ((sum = bris.read()) != -1) {

                bros.write( sum );
                dem ++;
            }
            bris.close();
            bros.close();
            System.out.println(  "Số phần tử được copy sang là : "+ dem );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Đường dẫn file nguồn:" );
        String sourcePath = scanner.nextLine();
        System.out.println( "Đường dẫn file đích:" );
        String destPath = scanner.nextLine();
        CopyFile copy = new CopyFile();
        copy.copyFile( sourcePath, destPath );
    }
}
