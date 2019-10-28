import gnu.io.NoSuchPortException;

public class Car {

	public static void main(String[] args) {
		ArduinoSerialTest arduinoSerialTest = new ArduinoSerialTest("COM5");
		try {
			CanSerialTest canSerialTest = new CanSerialTest("COM7");
		} catch (NoSuchPortException e) {
			e.printStackTrace();
		}
		arduinoSerialTest.start(null);

	}

}
