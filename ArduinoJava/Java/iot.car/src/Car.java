import gnu.io.NoSuchPortException;

public class Car {

	public static void main(String[] args) {
		try {
			IoTCanSerialTest canSerialTest = new IoTCanSerialTest("COM7");
		} catch (NoSuchPortException e) {
			e.printStackTrace();
		}

	}

}
