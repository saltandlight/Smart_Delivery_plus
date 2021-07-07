
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class IoTCanSerialTest implements SerialPortEventListener {

	private SerialPort serialPort;
	private CommPortIdentifier portIdentifier;
	private CommPort commPort;
	private BufferedInputStream bin;
	InputStream in;
	OutputStream out;
	String sensordata;
	// ���� ���� ���۵� �ᵵ �Ǵµ�
	// ���� �� OutputStream�� ���� ������
	// ���� �ڹ� ȯ���� �ƴ� ���� �־��.

	public IoTCanSerialTest() {
	}

	public IoTCanSerialTest(String portName) throws NoSuchPortException {
		portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
		System.out.println("CAN Port Connected");
		try {
			connectSerial();
			System.out.println("CAN Connected");
			(new Thread(new SerialWriter())).start();
		} catch (Exception e) {
			System.out.println("Fail to Connect CAN");
			e.printStackTrace();
		}
	}
	

	public String getSensordata() {
		return sensordata;
	}

	public void setSensordata(String sensordata) {
		this.sensordata = sensordata;
	}

	public void sendData(String data) {
		SerialWriter sw = new SerialWriter(data);
		new Thread(sw).start();
	}

	public void connectSerial() throws Exception {

		// �ٸ� ���̰� ���� �ִ�.
		if (portIdentifier.isCurrentlyOwned()) {
			System.out.println("Error: Port is currently in use");
		} else {
			commPort = portIdentifier.open(this.getClass().getName(), 100);
			if (commPort instanceof SerialPort) {
				serialPort = (SerialPort) commPort;
				serialPort.addEventListener(this);
				serialPort.notifyOnDataAvailable(true);
				serialPort.setSerialPortParams(921600, // ��żӵ�(Serial �ӵ�) ���� �޶� ��� ����.
						SerialPort.DATABITS_8, // ������ ��Ʈ
						SerialPort.STOPBITS_1, // stop ��Ʈ
						SerialPort.PARITY_NONE); // �и�Ƽ
				// �����ϴ� �����͸� �����ϰڴٴ� ����.
				in = serialPort.getInputStream();
				bin = new BufferedInputStream(in);
				// �����͸� Serial�� �� �� ����.
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
				if(bin.available() > 0) {
//					int numBytes = bin.read(readBuffer);
					String candata = new String(readBuffer);
					boolean result = checkSerialData(candata);
					System.out.println(candata+result);
					if(result == true) {
						String temp = "Temparature : " + candata.substring(12,14)+"��C ";
						String humi = "Humidity : " + candata.substring(14,16)+"%";
						String senddata = candata.substring(1);
						System.out.println(temp+humi);
						setSensordata(senddata);
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
			// �� �����Ұ� �޼�����.
			// �̰� �� ���ָ� �� ��.
			this.data = ":G11A9\r";
		}

		public SerialWriter(String data) {
			/*
			 * W28: �����͸� ��ڴٴ� �� W28 00000000 000000000000 id data :W28 00000000 000000000000
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

			// ��Ʈ����
			System.out.println("before 0xff : " + cdata);
			cdata = (cdata & 0xFF);
			System.out.println("after 0xff : " + cdata);

			String returnData = ":";
			returnData += data + Integer.toHexString(cdata).toUpperCase();
			returnData += "\r";
			return returnData;
		}

		public void run() {
			try {
				byte[] inputData = data.getBytes();
				System.out.println("inputData:" + inputData.toString());
				out.write(inputData);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws NoSuchPortException {

		new IoTCanSerialTest("COM6");

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