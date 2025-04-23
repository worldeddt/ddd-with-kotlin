package proto.kotlinproto1.domain.subscription.model

import proto.kotlinproto1.config.SubscriptionStatus
import java.time.LocalDate
import java.util.UUID


class Subscription(
    id:UUID,
    customerId: UUID,
    cycle: DeliveryCycle,
    startDate: LocalDate,
    status: SubscriptionStatus
) {
    var id:UUID? = id
    var customerId:UUID? = customerId
    var cycle:DeliveryCycle? = cycle
    var startDate:LocalDate? = startDate
    var status:SubscriptionStatus? = status

    fun Subscription() {
        status = SubscriptionStatus.SUBSCRIBED
    }

    fun cancel() {
        status = SubscriptionStatus.CANCELLED
    }
}