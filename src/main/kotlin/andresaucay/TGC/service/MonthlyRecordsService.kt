package andresaucay.TGC.service


import andresaucay.TGC.model.Containers
import andresaucay.TGC.model.MonthlyRecords
import andresaucay.TGC.repository.MonthlyRecordsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class MonthlyRecordsService {
    @Autowired
    lateinit var monthlyRecordsRepository: MonthlyRecordsRepository

    fun list ():List<MonthlyRecords>{
        return monthlyRecordsRepository.findAll()
    }
    fun save(monthlyRecords: MonthlyRecords): MonthlyRecords {
        try{
            return monthlyRecordsRepository.save(monthlyRecords)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(monthlyRecords: MonthlyRecords): MonthlyRecords{
        try {
            monthlyRecordsRepository.findById(monthlyRecords.id)
                ?: throw Exception("ID no existe")

            return monthlyRecordsRepository.save(monthlyRecords)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):MonthlyRecords?{
        return monthlyRecordsRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = monthlyRecordsRepository.findById(id)
                ?: throw Exception("ID no existe")
            monthlyRecordsRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}