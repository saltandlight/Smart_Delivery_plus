// https://kamang-it.tistory.com/entry/Java%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%9C-Serialuart-%ED%86%B5%EC%8B%A0
// reference url
public class Main {
    public static void main(String[] args) {
        try {
            (new Serial()).connect("COM5");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}