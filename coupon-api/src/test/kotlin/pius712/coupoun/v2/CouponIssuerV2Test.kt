package pius712.coupoun.v2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class CouponIssuerV2Test(
    private val couponIssuerV2: CouponIssuerV2,
    private val couponV2Repository: CouponV2Repository
) {


    @Test
    fun `아무런 락 없이 진행`() {

        // 왜 되냐 ㅋㅋ;;
        // total count 를 100개를 하니까 글치 멍청아 ㅋㅋ;
        val totalCount = 1000
        val latch = CountDownLatch(totalCount)
        val executorService = Executors.newFixedThreadPool(32)


        for (i in 1..totalCount) {
            executorService.execute {
                couponIssuerV2.issue(i.toLong())
                latch.countDown()
            }
        }

        // 테스트 스레드 대기
        latch.await()
        Assertions.assertThat(couponV2Repository.count()).isEqualTo(1000)
    }


    @Test
    fun `redis increment`() {

        val totalCount = 1000
        val latch = CountDownLatch(totalCount)
        val executorService = Executors.newFixedThreadPool(32)


        for (i in 1..totalCount) {
            executorService.execute {
                couponIssuerV2.issueRedis(i.toLong())
                latch.countDown()
            }
        }

        // 테스트 스레드 대기
        latch.await()
        Assertions.assertThat(couponV2Repository.count()).isEqualTo(100)
    }
}