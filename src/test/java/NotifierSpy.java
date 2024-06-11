public class NotifierSpy implements INotifier {
    private int _notifications;

    public int notifications() {
        return _notifications;
    }

    @Override
    public void sendGreetingsTo(String message, Friend friend) {
        _notifications++;
    }
}
