package lab4;

public class PrivateMethods {

    private static int dangerousCounter = 5;

    private static void helloWorld() {
        if (dangerousCounter > 0) {
            System.out.println("HelloWorld");
        }
    }

    @IntAnnotation(3)
    private static void dangerousMethod() {
        if (dangerousCounter > 0) {
            System.out.println("Если вы вызовете этот метод еще " +
                    --dangerousCounter +
                    " раз(а), helloWorld() перестанет работать!");
        } else {
            System.out.println("Поздравляем, вы сломали метод helloWorld().");
        }
    }

    @IntAnnotation(10)
    private static void getSum(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
    }

    @IntAnnotation(5)
    private static void showEmoji() {
        System.out.println("¯\\_(ツ)_/¯");
    }
}
