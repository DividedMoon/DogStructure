package byl;

import java.util.Objects;

import lombok.Data;

/**
 * 支付模型
 */
@Data
public class PaymentModel {
    private PaymentStatus lastStatus;
    private PaymentStatus curStatus;

    /**
     * 根据事件进行状态流转
     */
    public void transferStatusByEvent(PaymentEvent event) {
        PaymentStatus nextStatus = PaymentStatus.nextState(curStatus, event);
        if (!Objects.isNull(nextStatus)) {
            lastStatus = curStatus;
            curStatus = nextStatus;
        }else {
            throw new RuntimeException("不支持的事件");
        }
    }
}
