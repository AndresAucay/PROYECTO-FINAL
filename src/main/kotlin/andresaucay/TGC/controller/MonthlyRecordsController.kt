package andresaucay.TGC.controller

import andresaucay.TGC.model.Containers
import andresaucay.TGC.model.MonthlyRecords
import andresaucay.TGC.service.ContainersService
import andresaucay.TGC.service.MonthlyRecordsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/registro-mensual")   //endpoint
class MonthlyRecordsController {
    @Autowired
    lateinit var monthlyRecordsService: MonthlyRecordsService

    @GetMapping
    fun list(): List<MonthlyRecords> {
        return monthlyRecordsService.list()
    }
    @PostMapping
    fun save (@RequestBody monthlyRecords: MonthlyRecords): ResponseEntity<MonthlyRecords> {
        return ResponseEntity(monthlyRecordsService.save(monthlyRecords), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody monthlyRecords: MonthlyRecords ):ResponseEntity<MonthlyRecords>{
        return ResponseEntity(monthlyRecordsService.update(monthlyRecords), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(monthlyRecordsService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return monthlyRecordsService.delete(id)
    }
}