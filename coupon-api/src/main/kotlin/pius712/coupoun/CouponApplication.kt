package pius712.coupoun

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class CoupounApplication

fun main(args: Array<String>) {
    runApplication<CoupounApplication>(*args)
}
