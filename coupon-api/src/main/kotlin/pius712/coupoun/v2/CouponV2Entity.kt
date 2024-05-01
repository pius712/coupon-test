package pius712.coupoun.v2

import jakarta.persistence.Entity
import jakarta.persistence.Table
import pius712.coupoun.storage.db.BaseEntity

@Entity()
@Table(name="coupon_v2")
data class CouponV2Entity(
    val userId:Long
): BaseEntity(){

}