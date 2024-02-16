package andresaucay.TGC.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "code_text")
    var codeText: String? = null

    @Column(name = "full_name")
    var fullName: String? = null

    var cedula: Int? = null

    var email: String? = null

    var password: String? = null

    @Column(name = "role_id")
    var roleId: Long?= null
}
