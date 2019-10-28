import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import gnu.io.NoSuchPortException;

public class IoTcpTest {

	Socket socket;
	OutputStream out;
	DataOutputStream dout;
	InputStream in;
	DataInputStream din;
	IoTCanSerialTest ioTCanSerialTest;

	public IoTcpTest() {

	}

	public IoTcpTest(String ip, int port) throws IOException {
		try {
			ioTCanSerialTest = new IoTCanSerialTest("COM6");
		} catch (NoSuchPortException e2) {
			e2.printStackTrace();
		}
		boolean flag = true;
		while (flag) {
			try {
				socket = new Socket(ip, port);
				if (socket != null && socket.isConnected()) {
					System.out.println("Server Connected");
					in = socket.getInputStream();
					din = new DataInputStream(in);
					out = socket.getOutputStream();
					dout = new DataOutputStream(out);
					break;
				}
			} catch (Exception e) {
				System.out.println("Re-Try");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		} // end while

		new Receiver(socket).start();
		new Sender(socket).start();
	}

	public void sendMsg(String msg) throws IOException {
		Sender sender = null;
		sender = new Sender(socket);
		sender.setMsg(msg);
		sender.start();
	}

	public void start() throws Exception {
		Scanner sc = new Scanner(System.in);
		boolean sflag = true;
		while (sflag) {
			System.out.println("Input Msg.");
			String str = sc.next();
			sendMsg(str);
			if (str.equals("q")) {
				break;
			}
		}
		System.out.println("Bye....");
		sc.close();
	}

	class Sender extends Thread {

		String msg;

		public Sender(Socket socket) throws IOException {
//			out = socket.getOutputStream();
//			dout = new DataOutputStream(out);
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public void run() {
			while (true) {
				this.msg = ioTCanSerialTest.getSensordata();
//				System.out.println("??"+msg);

				if (dout != null && msg != null) {
					System.out.println(msg+"to Server");
					try {
						dout.writeUTF(msg);
						dout.flush();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	class Receiver extends Thread {

		public Receiver(Socket socket) throws IOException {
//			in = socket.getInputStream();
//			din = new DataInputStream(in);
		}

		public void run() {
			try {
				while (true) {
					String str = din.readUTF();
					if(str!=null) {
						System.out.println(str);
						ioTCanSerialTest.sendData(str);
					}
				}
			} catch (Exception e) {

			}
		}
	}

	public static void main(String[] args) {
		try {
			IoTcpTest ioTcpTest = new IoTcpTest("70.12.231.197", 8889);
//			ioTcpTest.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
