package andresaucay.TGC.controller

import andresaucay.TGC.model.Containers
import andresaucay.TGC.model.Roles
import andresaucay.TGC.service.ContainersService
import andresaucay.TGC.service.RolesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/roles")   //endpoint
class RolesController {
    @Autowired
    lateinit var rolesService: RolesService

    @GetMapping
    fun list(): List<Roles> {
        return rolesService.list()
    }
    @PostMapping
    fun save (@RequestBody roles: Roles): ResponseEntity<Roles> {
        return ResponseEntity(rolesService.save(roles), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody roles: Roles ):ResponseEntity<Roles>{
        return ResponseEntity(rolesService.update(roles), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(rolesService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return rolesService.delete(id)
    }
}