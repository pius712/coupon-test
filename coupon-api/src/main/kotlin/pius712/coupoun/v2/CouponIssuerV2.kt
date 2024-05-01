package pius712.coupoun.v2

import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class CouponIssuerV2(
    private val couponV2Repository: CouponV2Repository,
    private val couponCountRepository: CouponCountRepository
) {


    @Transactional
    fun issue(userId:Long) {
        val count = couponV2Repository.count()
        if(count >100) {
            return
        }

        couponV2Repository.save(CouponV2Entity(userId))
    }



    fun issueRedis(userId:Long) {
        val count = couponCountRepository.increment()
        if(count >100) {
            return
        }

        couponV2Repository.save(CouponV2Entity(userId))
    }
}