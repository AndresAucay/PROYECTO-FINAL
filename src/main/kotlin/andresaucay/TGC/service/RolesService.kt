package andresaucay.TGC.service

import andresaucay.TGC.model.Containers
import andresaucay.TGC.model.Roles
import andresaucay.TGC.repository.ContainersRepository
import andresaucay.TGC.repository.RolesRespository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class RolesService {
    @Autowired
    lateinit var rolesRespository: RolesRespository

    fun list ():List<Roles>{
        return rolesRespository.findAll()
    }
    fun save(roles: Roles ): Roles{
        try{
            return rolesRespository.save(roles)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun update(roles: Roles ): Roles{
        try {
            rolesRespository.findById(roles.id)
                ?: throw Exception("ID no existe")

            return rolesRespository.save(roles)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Roles?{
        return rolesRespository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = rolesRespository.findById(id)
                ?: throw Exception("ID no existe")
            rolesRespository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}