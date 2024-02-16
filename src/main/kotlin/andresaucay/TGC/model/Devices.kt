package andresaucay.TGC.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.sql.Timestamp

@Entity
@Table(name = "devices")
class Devices {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "code_text")
    var codeText: String? = null

    var location: String? = null

    @Column(name = "creation_date")
    var creationDate: Timestamp? = null

    @Column(name = "last_maintenance")
    var lastMaintenance: String? = null
}