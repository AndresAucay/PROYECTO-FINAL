package andresaucay.TGC.repository

import andresaucay.TGC.model.Containers
import andresaucay.TGC.model.UserRegistrations
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRegistrationsRepository : JpaRepository<UserRegistrations, Long?> {
    fun findById(id: Long?): UserRegistrations?
}