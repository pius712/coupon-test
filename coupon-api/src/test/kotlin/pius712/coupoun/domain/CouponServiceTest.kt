package pius712.coupoun.domain

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pius712.coupoun.storage.db.CouponRepository
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors

@SpringBootTest
class CouponServiceTest(
    @Autowired private val couponService: CouponService,
    @Autowired private val couponRepository: CouponRepository
) {

    @Test
    fun issueTest() {
        val threadPool = Executors.newFixedThreadPool(32)
        val countDownLatch = CountDownLatch(32)
        for (i in 1..1000L) {
            threadPool.submit{
                couponService.issueV1(i)
                countDownLatch.countDown()
            }
        }

        countDownLatch.await()
        val count = couponRepository.count()
//        Thread.sleep(4000)
        println("coupon count $count")
    }

    @Test
    fun issueV3Test() {
        val threadPool = Executors.newFixedThreadPool(32)
        val countDownLatch = CountDownLatch(32)
        for (i in 1..1000L) {
            threadPool.submit{
                couponService.issueV3(i)
                countDownLatch.countDown()
            }
        }

        countDownLatch.await()
        val count = couponRepository.count()
//        Thread.sleep(4000)
        println("coupon count $count")
    }

    @Test
    fun issueV4Test() {
        val threadPool = Executors.newFixedThreadPool(32)
        val countDownLatch = CountDownLatch(32)
        for (i in 1..1000L) {
            threadPool.submit{
                couponService.issueV4(i)
                countDownLatch.countDown()
            }
        }

        countDownLatch.await()
        val count = couponRepository.count()
//        Thread.sleep(4000)
        println("coupon count $count")
    }
}