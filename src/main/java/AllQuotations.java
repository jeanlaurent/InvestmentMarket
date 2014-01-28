import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllQuotations {

    private final Scanner scanner;
    private int numberOfQuotation;

    public AllQuotations(InputStream input) {
        scanner = new Scanner(input);
        numberOfQuotation = scanner.nextInt();
    }

    public boolean hasNext() {
        return numberOfQuotation > 0;
    }

    public Quote next() {
        numberOfQuotation--;
        return new Quote(fetchAmount(), fetchMarketPrices());
    }

    private int fetchAmount() {
        return scanner.nextInt();
    }

    private List<Integer> fetchMarketPrices() {
        List<Integer> marketPrices = new ArrayList();
        for (int i = 1; i <= 12; i++) {
            marketPrices.add(scanner.nextInt());
        }
        return marketPrices;
    }
}
