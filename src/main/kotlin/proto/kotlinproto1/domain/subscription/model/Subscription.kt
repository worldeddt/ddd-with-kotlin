package proto.kotlinproto1.domain.subscription.model

import proto.kotlinproto1.config.DeliveryCycle
import proto.kotlinproto1.config.SubscriptionStatus
import proto.kotlinproto1.exception.IllegalStateException
import java.time.LocalDate
import java.util.UUID


class Subscription(
    customerId: UUID,
    cycle: DeliveryCycle,
    startDate: LocalDate
) {
    var id:UUID? = null;
    var customerId:UUID? = customerId;
    var cycle:DeliveryCycle? = cycle;
    var startDate:LocalDate? = startDate;
    var status:SubscriptionStatus? = null;

    fun Subscription(
        customerId: UUID,
        cycle: DeliveryCycle,
        startDate: LocalDate
    ) {
        this.id = UUID.randomUUID();
        this.customerId = customerId;
        this.cycle = cycle;
        this.status = SubscriptionStatus.ACTIVE;
        this.startDate = startDate;
    }

    fun pause() {
        if (this.status != SubscriptionStatus.ACTIVE) {
            throw IllegalStateException("정지할 수 없는 상태");
        }

        this.status = SubscriptionStatus.PAUSED;
    }

    fun resume() {
        if (this.status != SubscriptionStatus.PAUSED) {
            throw IllegalStateException("재개할 수 없는 상태");
        }

        this.status = SubscriptionStatus.ACTIVE;
    }

    fun cancel() {
        this.status = SubscriptionStatus.CANCELLED;
    }

    fun getId(): UUID? {
        return id;
    }

    fun getStatus(): SubscriptionStatus? {
        return status;
    }
}