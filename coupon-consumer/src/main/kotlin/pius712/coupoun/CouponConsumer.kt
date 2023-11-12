package pius712.coupoun

import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component


@Component
class CouponConsumer {

    @KafkaListener(topics = ["coupon-requested"], groupId = "group_1")
    fun listen(message:String) {
        println("listen ${message}");
    }
}