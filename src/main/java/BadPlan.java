public class BadPlan extends Plan {

    public BadPlan() {
        super(-1, -1, 0);
    }

    @Override
    public String toString() {
        return "IMPOSSIBLE";
    }
}
