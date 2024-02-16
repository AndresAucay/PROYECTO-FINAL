package andresaucay.TGC.service

import andresaucay.TGC.model.Containers
import andresaucay.TGC.model.UserRegistrations
import andresaucay.TGC.repository.ContainersRepository
import andresaucay.TGC.repository.UserRegistrationsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserRegistrationsService {
    @Autowired
    lateinit var userRegistrationsRepository: UserRegistrationsRepository

    fun list ():List<UserRegistrations>{
        return userRegistrationsRepository.findAll()
    }
    fun save(userRegistrations: UserRegistrations): UserRegistrations{
        try{
            return userRegistrationsRepository.save(userRegistrations)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(userRegistrations: UserRegistrations ): UserRegistrations{
        try {
            userRegistrationsRepository.findById(userRegistrations.id)
                ?: throw Exception("ID no existe")

            return userRegistrationsRepository.save(userRegistrations)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):UserRegistrations?{
        return userRegistrationsRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = userRegistrationsRepository.findById(id)
                ?: throw Exception("ID no existe")
            userRegistrationsRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}