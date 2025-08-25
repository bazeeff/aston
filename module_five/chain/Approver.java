package ru.module_five.chain;

public abstract class Approver {
    private Approver next;
    public Approver linkWith(Approver next) { this.next = next; return next; }
    public final boolean approve(PaymentRequest r) {
        if (canApprove(r)) {
            System.out.printf("%s утвердил платёж %s EUR: %s%n", role(), r.amount, r.purpose);
            return true;
        }
        System.out.printf("%s недостаточно полномочий для %s EUR -> передаёт дальше...%n", role(), r.amount);
        return next != null && next.approve(r);
    }
    protected abstract boolean canApprove(PaymentRequest r);
    protected abstract String role();
}
