package pius712.coupoun.v3

import jakarta.transaction.Transactional
import org.springframework.stereotype.Component
import pius712.coupoun.v2.CouponCountRepository
import pius712.coupoun.v2.CouponV2Entity


@Component
class CouponIssuerV3(
    private val couponCountRepository: CouponCountRepository,
    private val couponProducer: CouponProducer,
) {

    fun issue(userId:Long) {
        val count = couponCountRepository.increment()
        if(count >100) {
            return
        }

        couponProducer.create(userId)
    }

}