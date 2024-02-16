package andresaucay.TGC.controller

import andresaucay.TGC.model.Containers
import andresaucay.TGC.model.Devices
import andresaucay.TGC.service.ContainersService
import andresaucay.TGC.service.DevicesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/dispositivos")   //endpoint
class DevicesController {
    @Autowired
    lateinit var devicesService: DevicesService

    @GetMapping
    fun list(): List<Devices> {
        return devicesService.list()
    }
    @PostMapping
    fun save (@RequestBody devices: Devices): ResponseEntity<Devices> {
        return ResponseEntity(devicesService.save(devices), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody devices: Devices):ResponseEntity<Devices>{
        return ResponseEntity(devicesService.update(devices), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(devicesService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return devicesService.delete(id)
    }
}