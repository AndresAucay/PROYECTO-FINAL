package andresaucay.TGC.model

import jakarta.persistence.*

@Entity
@Table(name = "monthly_records")
class MonthlyRecords {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null


    @Column(name = "dailyrecords_id")
    var dailyRecordsId: Long? = null
}
