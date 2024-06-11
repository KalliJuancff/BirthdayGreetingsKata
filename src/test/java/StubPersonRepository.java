import java.util.ArrayList;
import java.util.List;

public class StubPersonRepository implements FriendRepository {
    private final List<Friend> _friends = new ArrayList<>();

    public void addFriend(Friend friend) {
        _friends.add(friend);
    }

    @Override
    public List<Friend> getFriends() {
        return _friends;
    }
}
