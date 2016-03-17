package hotels.com.assesment.hotelsApp;

/**
 * Created by ${Femi} on ${07/03/2016}.
 */
public class HotelExpediaQuestion3 {

    public static void main(String[] args) {
        HotelExpediaQuestion3 hotelExpedia = new HotelExpediaQuestion3();
        int firstNumber = 1, LastNumber = 100;
        hotelExpedia.inputFirstAndLastNumber(firstNumber, LastNumber);
    }


    private void inputFirstAndLastNumber(int firstNumber, int lastNumber) {
        for (int number = firstNumber; number <= lastNumber; ++number) {

            if (number % 3 == 0) {
                System.out.print("Hotel");
            }
            if (number % 5 == 0) {
                System.out.print("Expedia");
            }
            if (number % 3 != 0 && number % 5 != 0) {
                System.out.print(number);
            }
            System.out.println();
        }
    }
}

