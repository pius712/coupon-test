package pius712.coupoun.storage.db

import io.lettuce.core.dynamic.annotation.CommandNaming.Strategy
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity(
    @Id @GeneratedValue(strategy=  GenerationType.IDENTITY)
    val id: Long? = null
)
