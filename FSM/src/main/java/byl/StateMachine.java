package byl;

import java.util.HashMap;
import java.util.Map;

/**
 * 状态机
 */
public class StateMachine<S extends BaseStatus, E extends BaseEvent> {
    private final Map<StatusEventPair<S, E>, S> statusMap = new HashMap<>();

    /**
     * 注册指定的当前状态被触发指定的事件后，将转移到指定的目标状态
     * 
     * @param source 当前状态
     * @param event  触发的事件
     * @param target 目标状态
     */
    public void accept(S source, E event, S target) {
        statusMap.put(new StatusEventPair<S, E>(source, event), target);
    }

    /**
     * 获取指定的当前状态被触发指定的事件后，将转移到的目标状态
     * 
     * @param source 当前状态
     * @param event  触发的事件
     * @return 目标状态
     */
    public S getNextStatus(S source, E event) {
        return statusMap.get(new StatusEventPair<S, E>(source, event));
    }
}
