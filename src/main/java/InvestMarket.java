import org.fest.util.VisibleForTesting;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Charsets.*;

public class InvestMarket {

    public static void main(String[] args) {
        System.out.println(new InvestMarket().compute(System.in));
    }

    public String compute(InputStream inputStream) {
        return computeAllBestPlans(readAllQuotations(inputStream)).toString();
    }

    @VisibleForTesting
    String compute(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(UTF_8));
        return computeAllBestPlans(readAllQuotations(inputStream)).toString();
    }

    public List<Quote> readAllQuotations(InputStream input) {
        List<Quote> quotes = new ArrayList<>();
        AllQuotes allQuotes = new AllQuotes(input);
        while (allQuotes.hasNext()) {
            quotes.add(allQuotes.next());
        }
        return quotes;
    }

    public Plans computeAllBestPlans(List<Quote> quotes) {
        Plans plans = new Plans();
        quotes.forEach(quote -> plans.add(quote.computeBestPlanFor1Year()));
        return plans;
    }

}