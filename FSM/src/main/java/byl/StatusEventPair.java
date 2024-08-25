package byl;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 状态事件对，指定的状态只能接受指定的事件
 */
@AllArgsConstructor
@Getter
public class StatusEventPair<S extends BaseStatus, E extends BaseEvent> {
    private S status;
    private E event;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatusEventPair)) return false;

        StatusEventPair<?, ?> that = (StatusEventPair<?, ?>) o;

        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        return event != null ? event.equals(that.event) : that.event == null;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (event != null ? event.hashCode() : 0);
        return result;
    }    
}
