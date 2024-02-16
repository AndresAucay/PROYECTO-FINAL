package andresaucay.TGC.repository

import andresaucay.TGC.model.Roles
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RolesRespository : JpaRepository<Roles, Long?> {
    fun findById(id: Long?): Roles?
}