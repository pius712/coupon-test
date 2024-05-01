package pius712.coupoun

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import pius712.storage.db.CouponEntity
import pius712.storage.db.CouponRepository


@Component
class CouponConsumer(
    private val couponRepository: CouponRepository
) {

    @KafkaListener(topics = ["coupon_create"], groupId = "group_1")
    fun listen(userId:Long) {
        couponRepository.save(CouponEntity(userId = userId))
    }
}