package pius712.storage.db

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name="coupon_v2")
data class CouponEntity(
    val userId:Long
): BaseEntity(){ }
