package andresaucay.TGC.repository

import andresaucay.TGC.model.Containers
import andresaucay.TGC.model.DailyRecords
import andresaucay.TGC.model.Users
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DailyRecordsRepository : JpaRepository<DailyRecords, Long?> {
    fun findById(id: Long?): DailyRecords?
}