package pius712.coupoun.v2

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

@Component
class CouponCountRepository(
    private val redisTemplate: RedisTemplate<String, String>
) {


    fun increment():Long {
        return redisTemplate.opsForValue().increment("coupon_count")!!
    }
}