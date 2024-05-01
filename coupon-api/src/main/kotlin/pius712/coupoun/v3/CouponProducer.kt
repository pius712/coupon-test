package pius712.coupoun.v3

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class CouponProducer(
    private val kafkaProducer: KafkaTemplate<String, Long>
) {

    fun create(userId:Long){
        kafkaProducer.send("coupon_create", userId)
    }
}