import java.util.Arrays;

import jssc.SerialPort;
import jssc.SerialPortException;

public class ArduinoSerialTest {

	SerialPort serialPort;
	String sensordata;
	boolean flag = true;

	public ArduinoSerialTest() {
	}

	public ArduinoSerialTest(String port) {
		this.serialPort = new SerialPort(port);
		try {
			serialPort.openPort();
			serialPort.setParams(9600, 8, 1, 0);
			System.out.println("Arduino Port Open");

		} catch (SerialPortException e) {
			System.out.println("Fail to Open Arduino Port");
			e.printStackTrace();
			System.out.println("Retry");
			new ArduinoSerialTest(port);
		}

		Runnable r = new Runnable() {

			@Override
			public void run() {
				while (flag) {
					new ReadThread(serialPort).start();
				}
//				try {
//					serialPort.closePort();
//					System.out.println("Arduino Port Close");
//				} catch (SerialPortException e) {
//					System.out.println("Fail to Close Arduino Port");
//					e.printStackTrace();
//				}
			}
		};
		new Thread(r).start();
	}

	public String getSensordata() {
		return sensordata;
	}

	public void setSensordata(String sensordata) {
		this.sensordata = sensordata;
	}

	public void start(String str) {
		System.out.println("Input Command");
		if (str != null) {
			try {
				sendMsg(str);
				if (str.equals("q")) {
					serialPort.closePort();
					System.out.println("Closed Port");
				}
			} catch (SerialPortException e) {
				System.out.println("Fail to Close Port");
				e.printStackTrace();
			}
		}
	}

	public void sendMsg(String msg) {
		WriteThread writeThread = null;
		writeThread = new WriteThread(serialPort);
		writeThread.setMsg(msg);
		writeThread.start();
	}

	class ReadThread extends Thread {
		SerialPort serial;

		public ReadThread() {
		}

		public ReadThread(SerialPort serial) {
			this.serial = serial;
		}

		@Override
		public void run() {
			while (flag) {
				try {
					String readBuffer = serial.readString();
					if (readBuffer != null) {
						String[] infos = readBuffer.split(" ");
						setSensordata("W2800000001" + infos[1] + infos[3] + "000000000000");
//						System.out.println(Arrays.toString(infos));
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
		String msg;

		public WriteThread() {
		}

		public WriteThread(SerialPort serial) {
			this.serial = serial;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		@Override
		public void run() {
			System.out.println(msg);
			try {
				serial.writeBytes(msg.getBytes());
				System.out.println("Complete to WriteArduino");
			} catch (SerialPortException e) {
				// TODO Auto-generated catch block
				System.out.println("Fail to WriteArduino");
				e.printStackTrace();
			} catch (NullPointerException e) {
				System.out.println("Retry to Write");
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		ArduinoSerialTest arduinoSerialTest = null;
		arduinoSerialTest = new ArduinoSerialTest("COM5");
		arduinoSerialTest.start(null);

	}
}
