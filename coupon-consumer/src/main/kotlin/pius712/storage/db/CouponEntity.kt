package pius712.coupoun.storage.db

import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
data class CouponEntity(
    @Column
    val name: String,
    @Column(name="ref_user_id")
    val userId:Long
): BaseEntity(){ }
