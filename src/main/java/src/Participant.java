package src;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author yhh1056
 * @since 2021/02/02
 */
public class Participant {

    private String name;

    /**
     * 과제 출석부
     * key : week
     * value : true or false
     */
    private Map<Integer, Boolean> checkList;

    public Participant(String name) {
        this.name = name;
        checkList = new HashMap<>();
    }

    public boolean equalsName(String name) {
        return this.name.equals(name);
    }

    public void addCheck(int week) {
        this.checkList.put(week, true);
    }
}
