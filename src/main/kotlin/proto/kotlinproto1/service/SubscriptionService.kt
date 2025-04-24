package proto.kotlinproto1.service

import proto.kotlinproto1.domain.subscription.model.Subscription
import java.time.LocalDate

class SubscriptionService {
    fun createSubscription(UUID customerId, DeliveryCycle cycle) : Subscription {
        return Subscription(customerId, cycle, LocalDate.now())
    }
}