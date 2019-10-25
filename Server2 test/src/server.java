import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	static int num = 1;
	ServerSocket serverSocket = null;
	Socket socket = null;
	boolean sflag = true;
	InputStreamReader inputStream = null;
	FileOutputStream fileout = null;
	InputStream input2 = null;
	
	
	public server() throws IOException {
		
		serverSocket = new ServerSocket(50002);
		System.out.println("Server Start..");
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
                    while(sflag) {

                        System.out.println("Server Ready..");
                        socket = serverSocket.accept();
                        fileout = new FileOutputStream("C:/img/capture"+num+".jpg");
                        num++;
                        InputStream input2 = socket.getInputStream();
            			
            			
            			byte[] dataBuff = new byte[10000];
            			int length =input2.read(dataBuff);
            			System.out.println("before : " + length);
            			System.out.print("다운 중 ");
            			
            			
            			while (length != -1) {
            				System.out.print(".");
            				fileout.write(dataBuff, 0, length);
            				length = input2.read(dataBuff);
            				System.out.println("downloading : " + length);
            			}
            			input2.close();
            			fileout.close();
            			socket.close();
            			System.out.println("다운 종료");
                        
                        
                        
                        
                        
                        //receiveData(socket, fileout);
                        //System.out.println("Connect Socket");
                        //System.out.println(socket.toString());
                        //System.out.println(socket.getInetAddress());
                    }
                    System.out.println("Server End..");
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                	if(socket!= null) {
                		try {
                			socket.close();
                		}catch (IOException e) {
                			e.printStackTrace();
                		}
                	}
                	if(inputStream != null) {
                		try {
                			inputStream.close();
                		}catch (IOException e) {
                			e.printStackTrace();
                		}
                	}
                	if(fileout != null) {
                		try {
                			fileout.close();
                		}catch (IOException e) {
                			e.printStackTrace();
                		}
                	}
                }
			}	
		};
		new Thread(r).start();
	}

	
	public static void receiveData(Socket socket, FileOutputStream fileout) {
		try {
			InputStream input2 = socket.getInputStream();
			
			
			byte[] dataBuff = new byte[10000];
			int length =input2.read(dataBuff);
			System.out.println("before : " + length);
			System.out.print("다운 중 ");
			while (length != -1) {
				System.out.print(".");
				fileout.write(dataBuff, 0, length);
				length = input2.read(dataBuff);
				System.out.println("downloading : " + length);
			}
			
			System.out.println("다운 종료");
			
			return;
		}catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
	}
		
		
	public static void main(String[] args) throws InterruptedException, IOException {
		new server();
	}

}
