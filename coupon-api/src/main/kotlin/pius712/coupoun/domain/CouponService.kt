package pius712.coupoun.domain

import org.springframework.stereotype.Service
import pius712.coupoun.storage.db.CouponEntity
import pius712.coupoun.storage.db.CouponRepository


@Service
class CouponService(private val couponRepository: CouponRepository,
    private val countRepository: CountRepository,
){
//    private val publisher: CouponIssueKafkaPublisher) {

}

    /**
     * 동시성 제어 없는 버전
     * */
//    fun issueV1(userId:Long) {
//        val count = couponRepository.count()
//        if(count >100) {
//            return
//        }
//            println("issued count $count")
//            couponRepository.save(CouponEntity("신상쿠폰", userId))
//    }

//    /**
//     * redis incr 활용
//     * */
//    fun issueV3(userId:Long) {
//
//        val count = countRepository.add()
//        if(count > 100){
//            return;
//        }
//        println("issued count $count")
//        couponRepository.save(CouponEntity("신상쿠폰", userId))
//    }
//
//    fun issueV4(userId:Long) {
//        val count = countRepository.add()
//        if(count > 100){
//            return;
//        }
//        println("issued count $count")
//        publisher.publish(userId)
//
//    }
//}