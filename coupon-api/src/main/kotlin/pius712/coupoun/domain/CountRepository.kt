package pius712.coupoun.domain

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
class CountRepository(
    private val redisTemplate: RedisTemplate<String, String>
) {

    fun add(): Long {
        return redisTemplate
            .opsForValue()
            .increment("count") ?: throw RuntimeException();
    }
}