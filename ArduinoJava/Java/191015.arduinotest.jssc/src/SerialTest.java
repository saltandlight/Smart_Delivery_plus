import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import jssc.SerialPort;
import jssc.SerialPortException;

public class SerialTest {

	static SerialPort serialPort;
	static boolean flag = true;
	HashMap<String, Integer> infomap = new HashMap<>();

	public static void main(String[] args) {
		serialPort = new SerialPort("COM5");
		try {
			serialPort.openPort();
			serialPort.setParams(9600, 8, 1, 0);
			System.out.println("Arduino Port Open");
			SerialTest st = new SerialTest();

//			System.out.println(new String(serialPort.readBytes()));
			st.new ReadThread(serialPort).start();
			st.new WriteThread(serialPort).start();

		} catch (SerialPortException e) {
			System.out.println("Fail to Open Arduino Port");
			e.printStackTrace();
		}
	}

	class ReadThread extends Thread {
		SerialPort serial;

		public ReadThread(SerialPort serial) {
			this.serial = serial;
		}

		@Override
		public void run() {
			while (flag) {
				try {
					String readBuffer = serial.readString();
					if (!(readBuffer == null)) {
						String[] infos = readBuffer.split(" ");
						infomap.put(infos[0], Integer.parseInt(infos[1]));
						infomap.put(infos[2], Integer.parseInt(infos[3]));
						for (String key : infomap.keySet()) {
							int value = infomap.get(key);
							System.out.println(key+" : "+value);
						}
						if (readBuffer.equals("q")) {
							serialPort.closePort();
							System.out.println("Closed Port");
							flag = false;
						}
					}

				} catch (SerialPortException e) {
					System.out.println("Fail to Read Arduino");
					e.printStackTrace();
				}

			}
		}
	}

	class WriteThread extends Thread {
		SerialPort serial;

		public WriteThread(SerialPort serial) {
			this.serial = serial;
		}

		@Override
		public void run() {
			while(flag) {
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					String writeArduino = br.readLine();
					if (writeArduino.equals("q")) {
						serialPort.closePort();
						System.out.println("Closed Port");
						flag = false;
					}
					serial.writeBytes(writeArduino.getBytes());
					System.out.println("Complete to WrieArduino");
				} catch (IOException e) {
					System.out.println("Fail to BufferReader ReadLine");
					e.printStackTrace();
				} catch (SerialPortException e) {
					System.out.println("Fail to WriteArduino");
					e.printStackTrace();
				}
			}
		}
	}
}
