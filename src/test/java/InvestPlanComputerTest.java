import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class InvestPlanComputerTest {

    @Test
    public void risingMarket() {
        assertThat(new InvestPlanComputer().compute("1 100 1 2 3 4 5 6 7 8 9 10 11 12")).isEqualTo("Case #1: 1 12 1100");
    }

    @Test
    public void loweringMarket() {
        assertThat(new InvestPlanComputer().compute("1 100 12 11 10 9 8 7 6 5 4 3 2 1")).isEqualTo("Case #1: IMPOSSIBLE");
    }

    @Test
    public void risingThenLoweringMarket() {
        assertThat(new InvestPlanComputer().compute("1 100 1 2 3 4 5 6 6 5 4 3 2 1")).isEqualTo("Case #1: 1 6 500");
    }

    @Test
    public void loweringThenRisingMarket() {
        assertThat(new InvestPlanComputer().compute("1 100 12 11 10 9 8 7 7 8 9 10 11 12")).isEqualTo("Case #1: 6 12 70");
    }

    @Test
    public void doubleMarket() {
        assertThat(new InvestPlanComputer().compute("2 100 1 2 3 4 5 6 7 8 9 10 11 12 100 1 2 3 4 5 6 7 8 9 10 11 12")).isEqualTo("Case #1: 1 12 1100\nCase #2: 1 12 1100");
    }

    @Test
    public void flatMarket() {
        assertThat(new InvestPlanComputer().compute("1 100 1 1 1 1 1 1 1 1 1 1 1 1")).isEqualTo("Case #1: IMPOSSIBLE");
    }

    @Test
    public void roundingHell() {
        assertThat(new InvestPlanComputer().compute("1 1 2 3 4 5 6 7 8 9 10 11 12 13")).isEqualTo("Case #1: IMPOSSIBLE");
    }

}
