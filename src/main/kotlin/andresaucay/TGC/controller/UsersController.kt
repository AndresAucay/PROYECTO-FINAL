package andresaucay.TGC.controller

import andresaucay.TGC.model.Containers
import andresaucay.TGC.model.Users
import andresaucay.TGC.service.ContainersService
import andresaucay.TGC.service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")   //endpoint
class UsersController {
    @Autowired
    lateinit var usersService: UsersService

    @GetMapping
    fun list(): List<Users> {
        return usersService.list()
    }
    @PostMapping
    fun save (@RequestBody users: Users): ResponseEntity<Users> {
        return ResponseEntity(usersService.save(users), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody users: Users):ResponseEntity<Users>{
        return ResponseEntity(usersService.update(users), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(usersService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return usersService.delete(id)
    }
}
