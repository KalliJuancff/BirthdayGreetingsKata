import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GreeterShould {
    @Test
    public void send_none_notification_when_no_one_was_born_today() {
        LocalDate today = LocalDate.of(2003, 6, 12);
        LocalDate birthday = today.plusDays(1);
        String name = "Rafa";
        Friend friend = new Friend(name, birthday);
        var repository = new StubPersonRepository();
        repository.addFriend(friend);
        var notifier = new NotifierSpy();
        var calendar = new StubCalendar(today);
        Greeter sut = new Greeter(repository, notifier, calendar);

        sut.greet();

        assertThat(notifier.notifications()).isEqualTo(0);
    }

    @Test
    public void send_one_notification_when_one_friend_was_born_today() {
        LocalDate anyToday = LocalDate.of(2003, 6, 12);
        LocalDate birthday = anyToday;
        String name = "Rafa";
        Friend friend = new Friend(name, birthday);
        var repository = new StubPersonRepository();
        repository.addFriend(friend);
        var notifier = new NotifierSpy();
        var calendar = new StubCalendar(anyToday);
        Greeter sut = new Greeter(repository, notifier, calendar);

        sut.greet();

        assertThat(notifier.notifications()).isEqualTo(1);
    }

    @Test
    public void send_more_than_one_notification_when_more_than_one_friend_was_born_today() {
        LocalDate today = LocalDate.of(2003, 6, 12);
        String name1 = "A";
        Friend friend1 = new Friend(name1, today);
        String name2 = "B";
        Friend friend2 = new Friend(name2, today);
        var repository = new StubPersonRepository();
        repository.addFriend(friend1);
        repository.addFriend(friend2);
        var notifier = new NotifierSpy();
        var calendar = new StubCalendar(today);
        Greeter sut = new Greeter(repository, notifier, calendar);

        sut.greet();

        assertThat(notifier.notifications()).isEqualTo(2);
    }


    @Test
    public void send_none_notification_when_no_friends() {
        LocalDate today = LocalDate.of(2003, 6, 12);
        var repository = new StubPersonRepository();
        var notifier = new NotifierSpy();
        var calendar = new StubCalendar(today);
        Greeter sut = new Greeter(repository, notifier, calendar);

        sut.greet();

        assertThat(notifier.notifications()).isEqualTo(0);
    }
}
