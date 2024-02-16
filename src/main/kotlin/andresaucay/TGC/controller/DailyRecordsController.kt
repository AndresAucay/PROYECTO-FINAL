package andresaucay.TGC.controller

import andresaucay.TGC.model.Containers
import andresaucay.TGC.model.DailyRecords
import andresaucay.TGC.service.ContainersService
import andresaucay.TGC.service.DailyRecordsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/registro-diario")   //endpoint
class DailyRecordsController {
    @Autowired
    lateinit var dailyRecordsService: DailyRecordsService

    @GetMapping
    fun list(): List<DailyRecords> {
        return dailyRecordsService.list()
    }
    @PostMapping
    fun save (@RequestBody dailyRecords: DailyRecords): ResponseEntity<DailyRecords> {
        return ResponseEntity(dailyRecordsService.save(dailyRecords), HttpStatus.OK)
    }
    @PutMapping
    fun update (@RequestBody dailyRecords: DailyRecords):ResponseEntity<DailyRecords>{
        return ResponseEntity(dailyRecordsService.update(dailyRecords), HttpStatus.OK)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ResponseEntity<*>{
        return ResponseEntity(dailyRecordsService.listById (id), HttpStatus.OK)

    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return dailyRecordsService.delete(id)
    }
}