package andresaucay.TGC.repository

import andresaucay.TGC.model.Containers
import andresaucay.TGC.model.MonthlyRecords
import andresaucay.TGC.model.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MonthlyRecordsRepository : JpaRepository<MonthlyRecords, Long?> {
    fun findById(id: Long?): MonthlyRecords?
}