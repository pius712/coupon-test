package pius712.coupoun.domain

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory


//@Configuration
//class CouponIssueKafkaConfig(
//) {

//    @Bean
//    fun producerConfig():ProducerFactory<String, Long> {
//        val config = HashMap<String,Any>()
//        config[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:29092"
//        config[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
//        config[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
//        return DefaultKafkaProducerFactory(config)
//    }

//    @Bean
//    fun KafkaTemplate(): KafkaTemplate<String, Long>{
//        return KafkaTemplate(producerConfig())
//    }
//}