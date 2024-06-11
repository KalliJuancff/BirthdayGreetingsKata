import java.time.LocalDate;

public class Greeter {
    private final FriendRepository repository;
    private final Notifier notifier;
    private final Calendar calendar;

    public Greeter(FriendRepository repository, Notifier notifier, Calendar calendar) {
        if (repository == null) throw new IllegalArgumentException("Repository can't be null");
        if (notifier == null) throw new IllegalArgumentException("Notifier can't be null");
        if (calendar == null) throw new IllegalArgumentException("Calendar can't be null");

        this.repository = repository;
        this.notifier = notifier;
        this.calendar = calendar;
    }

    public void greet() {
        for (Friend f : repository.getFriends()) {
            if (f.birthday() == calendar.today())
                notifier.sendGreetingsTo("", f);
        }
    }
}
