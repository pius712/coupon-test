package pius712.coupoun.storage.db

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name="coupon")
data class CouponEntity(
    @Column(name="ref_user_id")
    val userId:Long
): BaseEntity(){ }
