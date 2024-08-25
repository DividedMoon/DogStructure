package byl;

import lombok.Getter;

@Getter
public enum PaymentStatus implements BaseStatus {
    INIT("Init", "初始化", 0),
    CLOSE("Close", "关闭", 40000),
    PAYING("Paying", "支付中", 20010),
    PAID("Paid", "支付成功", 30020),
    AUDIT_PROCESS("AuditProcess", "审核中", 30030),
    AUDIT_FAIL("AuditFail", "审核失败", 40040),
    AUDIT_SUCCESS("AuditSuccess", "审核成功", 40050);

    /**
     * 支付状态机
     */
    private static final StateMachine<PaymentStatus, PaymentEvent> STATE_MACHINE = new StateMachine<>();
    static {
        STATE_MACHINE.accept(null, PaymentEvent.PAY_CREATE, INIT);
        STATE_MACHINE.accept(INIT, PaymentEvent.PAY_PROCESS, PAYING);
        STATE_MACHINE.accept(PAYING, PaymentEvent.PAY_SUCCESS, PAID);
        STATE_MACHINE.accept(PAYING, PaymentEvent.PAY_FAIL, CLOSE);
        STATE_MACHINE.accept(PAID, PaymentEvent.AUDIT_SEND, AUDIT_PROCESS);
        STATE_MACHINE.accept(AUDIT_PROCESS, PaymentEvent.AUDIT_REJECT, AUDIT_FAIL);
        STATE_MACHINE.accept(AUDIT_PROCESS, PaymentEvent.AUDIT_PASS, AUDIT_SUCCESS);
    }

    /**
     * 获取下一个状态
     * @param current 当前状态
     * @param event 事件
     * @return 下一个状态
     */
    public static PaymentStatus nextState(PaymentStatus current, PaymentEvent event) {
        return STATE_MACHINE.getNextStatus(current, event);
    }

    private final String status;

    private final String desc;

    private final int code;

    PaymentStatus(String status, String desc, int code) {
        this.status = status;
        this.desc = desc;
        this.code = code;
    }
}
