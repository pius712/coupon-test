package pius712.coupoun.domain

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class CouponIssueKafkaPublisher(
    private val kafkaTemplate: KafkaTemplate<String, Long>) {



    fun publish(message:Long) {
        println("publish ${message}")
        kafkaTemplate.send("coupon-requested",message)
    }
}