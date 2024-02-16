package andresaucay.TGC.service

import andresaucay.TGC.model.Containers
import andresaucay.TGC.model.Users
import andresaucay.TGC.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UsersService {
    @Autowired
    lateinit var usersRepository: UsersRepository

    fun list ():List<Users>{
        return usersRepository.findAll()
    }
    fun save( users: Users): Users{
        try{
            return usersRepository.save(users)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(users: Users ): Users{
        try {
            usersRepository.findById(users.id)
                ?: throw Exception("ID no existe")

            return usersRepository.save(users)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Users?{
        return usersRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = usersRepository.findById(id)
                ?: throw Exception("ID no existe")
            usersRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


}