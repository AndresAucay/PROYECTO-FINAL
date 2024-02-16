package andresaucay.TGC.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.sql.Timestamp

@Entity
@Table(name = "containers")
class Containers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name = "code_text")
    var codeText: String? = null

    var location: String? = null

    var capacity: Int? = null

    @Column(name = "last_emptying")
    var lastEmptying: Timestamp? = null

    @Column(name = "filling_weight")
    var fillingWeight: BigDecimal? = null

    @Column(name = "weight_check")
    var weightCheck: Boolean? = null

    @Column(name = "device_id")
    var deviceId: Long? = null

   }