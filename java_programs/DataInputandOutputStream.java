import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class DataInputandOutputStream {


    public static void main(String[] args) throws IOException {

        File file = new File("file.txt");
        file.createNewFile();
        FileOutputStream fileOpStream = new FileOutputStream(file);
        DataOutputStream fileOpdata = new DataOutputStream(fileOpStream);


        // stored data in UTF-8 encoding
        //so if we have to access data we have to use Inputstream and datainputstream

        fileOpdata.writeUTF("java is a programming language");
        fileOpStream.close();
        fileOpdata.close();

        FileInputStream fileIpstream = new FileInputStream(file);
        DataInputStream fileIpdata = new DataInputStream(fileIpstream);
        // String s=fileIpdata.readUTF();
        System.out.println(fileIpdata.readUTF());
        // System.out.println(fileIpdata.readChar());
        fileIpstream.close();
        fileIpdata.close();

    }
}