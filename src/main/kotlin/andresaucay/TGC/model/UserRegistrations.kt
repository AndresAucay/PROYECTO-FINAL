package andresaucay.TGC.model

import jakarta.persistence.*

@Entity
@Table(name = "userregistration")
class UserRegistrations {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "user_id")
    var userId: Long? = null

    @Column(name = "container_id")
    var containerId: Long? = null
}