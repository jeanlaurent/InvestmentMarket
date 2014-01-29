import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllQuotes {

    private static final int MAX_MONTH = 12;
    private final Scanner scanner;
    private int numberOfQuotes;

    public AllQuotes(InputStream input) {
        scanner = new Scanner(input);
        numberOfQuotes = scanner.nextInt();
    }

    public boolean hasNext() {
        return numberOfQuotes > 0;
    }

    public Quote next() {
        numberOfQuotes--;
        return new Quote(fetchAmount(), fetchMarketPrices());
    }

    private int fetchAmount() {
        return scanner.nextInt();
    }

    private List<Integer> fetchMarketPrices() {
        List<Integer> marketPrices = new ArrayList< >();
        for (int i = 0; i < MAX_MONTH; i++) {
            marketPrices.add(scanner.nextInt());
        }
        return marketPrices;
    }
}
