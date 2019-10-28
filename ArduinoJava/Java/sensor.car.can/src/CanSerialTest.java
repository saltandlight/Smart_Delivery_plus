
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class CanSerialTest implements SerialPortEventListener {
	private SerialPort serialPort;
	private CommPortIdentifier portIdentifier;
	private CommPort commPort;
	private BufferedInputStream bin;
	InputStream in;
	OutputStream out;
	ArduinoSerialTest arduinoSerialTest;
	// 들어올 때는 버퍼드 써도 되는데
	// 나갈 떄 OutputStream을 쓰는 이유는
	// 상대는 자바 환경이 아닐 수도 있어서임.
	boolean rflag = true;

	public CanSerialTest() {
	}

	public CanSerialTest(String portName) throws NoSuchPortException {
		this.arduinoSerialTest = new ArduinoSerialTest("COM5");
		portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
		System.out.println("Connect ComPort!");
		try {
			connectSerial();
			System.out.println("Connect OK !!");
			(new Thread(new SerialWriter())).start();
		} catch (Exception e) {
			System.out.println("Connect Fail !!");
			e.printStackTrace();
		}

	}

	public void sendData(String data) {
		SerialWriter sw = new SerialWriter(data);
		new Thread(sw).start();
	}

	public void connectSerial() throws Exception {

		// 다른 아이가 쓰고 있다.

		if (portIdentifier.isCurrentlyOwned()) {
			System.out.println("Error: Port is currently in use");
		} else {
			commPort = portIdentifier.open(this.getClass().getName(), 100);
			if (commPort instanceof SerialPort) {
				serialPort = (SerialPort) commPort;
				serialPort.addEventListener(this);
				serialPort.notifyOnDataAvailable(true);
				serialPort.setSerialPortParams(921600, // 통신속도(Serial 속도) 서로 달라도 상관 없음.
						SerialPort.DATABITS_8, // 데이터 비트
						SerialPort.STOPBITS_1, // stop 비트
						SerialPort.PARITY_NONE); // 패리티
				// 전송하는 데이터를 검증하겠다는 뜻임.
				in = serialPort.getInputStream();
				bin = new BufferedInputStream(in);
				// 데이터를 Serial로 쏠 수 있음.
				out = serialPort.getOutputStream();
			} else {
				System.out.println("Error: Only serial ports are handled by this example.");
			}
		}
	}

	@Override
	public void serialEvent(SerialPortEvent event) {
		switch (event.getEventType()) {
		case SerialPortEvent.BI:
		case SerialPortEvent.OE:
		case SerialPortEvent.FE:
		case SerialPortEvent.PE:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.RI:
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;
		case SerialPortEvent.DATA_AVAILABLE:
			byte[] readBuffer = new byte[128];

			try {
				while (bin.available() > 0) {
//					int numBytes = bin.read(readBuffer);
					String candata = new String(readBuffer);
					boolean result = checkSerialData(candata);
					if (result == true) {
						System.out.println("Receive Low Data:" + candata);
						arduinoSerialTest.sendMsg(candata);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}

	public boolean checkSerialData(String data) {
		boolean check = false;
		// :U2800000050000000000000002046
		String checkData = data.substring(1, 28);
		String checkSum = data.substring(28, 30);

		char c[] = checkData.toCharArray();
		int cdata = 0;
		for (char cc : c) {
			cdata += cc;
		}
		cdata = (cdata & 0xFF);
		String serialCheckSum = Integer.toHexString(cdata).toUpperCase();
		if (serialCheckSum.trim().equals(checkSum)) {
			check = true;
		}
		return check;
	}

	private class SerialWriter implements Runnable {
		String data;

		public SerialWriter() {
			// 나 참가할게 메세지임.
			// 이걸 안 해주면 안 됨.
			this.data = ":G11A9\r";
		}

		public SerialWriter(String data) {
			/*
			 * W28: 데이터를 쏘겠다는 뜻 W28 00000000 000000000000 id data :W28 00000000 000000000000
			 * 53 \r
			 */
			this.data = sendDataFormat(data);
			System.out.println(this.data);
		}

		public String sendDataFormat(String data) {
			data = data.toUpperCase();
			char c[] = data.toCharArray();
			int cdata = 0;
			for (char cc : c) {
				cdata += cc;
			}

			// 비트연산
			System.out.println("before 0xff : " + cdata);
			cdata = (cdata & 0xFF);
			System.out.println("after 0xff : " + cdata);

			String returnData = ":";
			returnData += data + Integer.toHexString(cdata).toUpperCase();
			returnData += "\r";
			System.out.println(returnData);
			return returnData;
		}

		public void run() {
			while (true) {
				if (arduinoSerialTest.getSensordata() != null) {
					this.data = sendDataFormat(arduinoSerialTest.getSensordata());

					try {
						byte[] inputData = data.getBytes();
						out.write(inputData);
						System.out.println(data);
						out.flush();
						Thread.sleep(1000);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
				}

			}
		}
	}

	public static void main(String[] args) throws NoSuchPortException {

		new CanSerialTest("COM8");

//		Timer sendtime2 = new Timer();
//		TimerTask sendtask2 = new TimerTask() {
//
//			@Override
//			public void run() {
//				// client.start();
//			}
//		};

//		sendtime2.schedule(sendtask2, 3000, 3000);

	}
}