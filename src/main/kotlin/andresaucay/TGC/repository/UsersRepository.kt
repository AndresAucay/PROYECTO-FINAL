package andresaucay.TGC.repository

import andresaucay.TGC.model.Containers
import andresaucay.TGC.model.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository : JpaRepository<Users, Long?> {
    fun findById(id: Long?): Users?

}