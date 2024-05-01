package pius712.coupoun.v3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.test.context.TestConstructor
import pius712.coupoun.v2.CouponV2Repository
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors


@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class CouponIssuerV3Test(
    private val couponIssuer: CouponIssuerV3,
    private val couponV2Repository: CouponV2Repository,
    private val redisTemplate: RedisTemplate<String, String>
) {

    @AfterEach
    fun cleanup() {
        redisTemplate.opsForValue().set("coupon_count", "0")
    }

    @Test
    fun `카프카 이베트`() {

        // 왜 되냐 ㅋㅋ;;
        // total count 를 100개를 하니까 글치 멍청아 ㅋㅋ;
        val totalCount = 1000
        val latch = CountDownLatch(totalCount)
        val executorService = Executors.newFixedThreadPool(32)


        for (i in 1..totalCount) {
            executorService.execute {
                couponIssuer.issue(i.toLong())
                latch.countDown()
            }
        }

        // 테스트 스레드 대기
        latch.await()
        Thread.sleep(10_000)
        Assertions.assertThat(couponV2Repository.count()).isEqualTo(100)
    }

}