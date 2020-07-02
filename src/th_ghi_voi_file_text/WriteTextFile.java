package th_ghi_voi_file_text;

import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter( "Hello.text");
            writer.write( "Hello world\n" );
            writer.write( "Nguyễn Đức Tuyển" );
            writer.close();

        }
         catch (IOException e) {
            e.printStackTrace();
        }

    }
}
