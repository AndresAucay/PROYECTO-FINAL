package andresaucay.TGC.model

import jakarta.persistence.*

@Entity
@Table(name = "dailyrecords")
class DailyRecords {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null


    @Column(name = "userregistration_id")
    var userRegistrationId: Long? = null
}