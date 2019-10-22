import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class SerialReader implements Runnable {
    InputStream in;

    public SerialReader(InputStream in) {
        this.in = in;
    }

    public void run() {
        byte[] buffer = new byte[1024];
        int len = -1;
        try {
            while ((len = this.in.read(buffer)) > -1) {
            	System.out.println("Get Data");
            	System.out.println(Arrays.toString(buffer));
            	System.out.println(len);
                System.out.print(new String(buffer, 0, len));
            }
        } catch (IOException e) {
        	System.out.println("Fail to Get Data");
            e.printStackTrace();
        }
    }
}