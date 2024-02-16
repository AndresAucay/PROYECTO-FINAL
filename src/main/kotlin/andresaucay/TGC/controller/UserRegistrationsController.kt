package andresaucay.TGC.controller


import andresaucay.TGC.model.Containers
import andresaucay.TGC.model.UserRegistrations
import andresaucay.TGC.service.ContainersService
import andresaucay.TGC.service.UserRegistrationsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/registro-por-usuario")   //endpoint
class UserRegistrationsController {
    @Autowired
    lateinit var userRegistrationsService: UserRegistrationsService

    @GetMapping
    fun list(): List<UserRegistrations> {
        return userRegistrationsService.list()
    }
    @PostMapping
    fun save (@RequestBody userRegistrations: UserRegistrations): ResponseEntity<UserRegistrations> {
        return ResponseEntity(userRegistrationsService.save(userRegistrations), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody userRegistrations: UserRegistrations):ResponseEntity<UserRegistrations>{
        return ResponseEntity(userRegistrationsService.update(userRegistrations), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(userRegistrationsService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return userRegistrationsService.delete(id)
    }
}
