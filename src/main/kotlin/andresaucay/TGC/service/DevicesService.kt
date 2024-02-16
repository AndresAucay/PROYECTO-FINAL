package andresaucay.TGC.service

import andresaucay.TGC.model.Containers
import andresaucay.TGC.model.Devices
import andresaucay.TGC.repository.ContainersRepository
import andresaucay.TGC.repository.DevicesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DevicesService {
    @Autowired
    lateinit var devicesRepository: DevicesRepository

    fun list(): List<Devices> {
        return devicesRepository.findAll()
    }

    fun save(devices: Devices): Devices {
        try {
            return devicesRepository.save(devices)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun update(devices: Devices): Devices {
        try {
            devicesRepository.findById(devices.id)
                ?: throw Exception("ID no existe")

            return devicesRepository.save(devices)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun listById(id: Long?): Devices? {
        return devicesRepository.findById(id)
    }

    fun delete(id: Long?): Boolean? {
        try {
            val response = devicesRepository.findById(id)
                ?: throw Exception("ID no existe")
            devicesRepository.deleteById(id!!)
            return true
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
}