package academy.prog;

import java.util.ArrayList;
import java.util.List;

public class JsonMessages {
    private final List<Message> list = new ArrayList<>();

    public JsonMessages(List<Message> sourceList, int fromIndex, String sender) {
        sourceList.stream()
                .filter(sourceMsg -> sourceMsg.getReceiver() == null || sourceMsg.getReceiver().equals(sender) || sourceMsg.getSender().equals(sender))
                .skip(fromIndex)
                .forEach(list::add);
    }
}
