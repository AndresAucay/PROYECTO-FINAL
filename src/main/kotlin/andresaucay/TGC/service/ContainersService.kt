package andresaucay.TGC.service

import andresaucay.TGC.model.Containers
import andresaucay.TGC.repository.ContainersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class ContainersService {
    @Autowired
    lateinit var containersRepository:ContainersRepository

    fun list ():List<Containers>{
        return containersRepository.findAll()
    }
    fun save(containers: Containers): Containers{
        try{
            return containersRepository.save(containers)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(containers: Containers): Containers{
        try {
            containersRepository.findById(containers.id)
                ?: throw Exception("ID no existe")

            return containersRepository.save(containers)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun listById (id:Long?):Containers?{
        return containersRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = containersRepository.findById(id)
                ?: throw Exception("ID no existe")
            containersRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


}