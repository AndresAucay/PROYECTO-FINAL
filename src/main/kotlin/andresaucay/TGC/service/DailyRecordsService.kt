package andresaucay.TGC.service

import andresaucay.TGC.model.Containers
import andresaucay.TGC.model.DailyRecords
import andresaucay.TGC.repository.ContainersRepository
import andresaucay.TGC.repository.DailyRecordsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DailyRecordsService {
    @Autowired
    lateinit var dailyRecordsRepository: DailyRecordsRepository

    fun list ():List<DailyRecords>{
        return dailyRecordsRepository.findAll()
    }
    fun save(dailyRecords: DailyRecords): DailyRecords{
        try{
            return dailyRecordsRepository.save(dailyRecords)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(dailyRecords: DailyRecords ): DailyRecords{
        try {
            dailyRecordsRepository.findById(dailyRecords.id)
                ?: throw Exception("ID no existe")

            return dailyRecordsRepository.save(dailyRecords)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):DailyRecords?{
        return dailyRecordsRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = dailyRecordsRepository.findById(id)
                ?: throw Exception("ID no existe")
            dailyRecordsRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}