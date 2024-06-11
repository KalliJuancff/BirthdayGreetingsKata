import java.time.LocalDate;

public class StubCalendar implements Calendar {
    private final LocalDate today;

    public StubCalendar(LocalDate today) {
        this.today = today;
    }

    public LocalDate today() {
        return today;
    }
}
