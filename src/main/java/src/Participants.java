package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yhh1056
 * @since 2021/02/02
 */
public class Participants {

    private final List<Participant> participants = new ArrayList<>();

    public void addParticipant(String name, int index) {
        if (!isExisted(name)) {
            Participant participant = new Participant(name);
            participants.add(participant);
        }
        addHomeWorkCheck(name, index);
    }

    private boolean isExisted(String name) {
        return participants.stream().anyMatch(participant -> participant.equalsName(name));
    }

    private void addHomeWorkCheck(String name, int index) {
        for (Participant participant : participants) {
            if (participant.equals(name)) {
                participant.addCheck(index);
            }
        }
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }
}
