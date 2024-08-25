package byl;

import lombok.Getter;

/**
 * 支付事件
 */
@Getter
public enum PaymentEvent implements BaseEvent{
    PAY_CREATE("PayCreate","创建支付"),
    PAY_PROCESS("PayProcess","支付处理"),
    PAY_SUCCESS("PaySuccess","支付成功"),
    PAY_FAIL("PayFail","支付失败"),
    AUDIT_SEND("AuditSend","发送审核"),
    AUDIT_REJECT("AuditReject","审核拒绝"),
    AUDIT_PASS("AuditPass","审核通过");

    private final String event;

    private final String desc;

    PaymentEvent(String event, String desc) {
        this.event = event;
        this.desc = desc;
    }
}
