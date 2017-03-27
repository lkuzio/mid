package xyz.javista.controlpanel.service

import spock.lang.Specification
import xyz.javista.controlpanel.core.repository.DeviceHardwareRepository
import xyz.javista.controlpanel.core.service.DeviceHardwareServiceImpl

/**
 * Created by Luke on 2017-03-27.
 */
class DeviceHardwareServiceSpec extends Specification {

    def deviceHardwareService = new DeviceHardwareServiceImpl()
    DeviceHardwareRepository deviceHardwareRepositoryMock = Mock()

    def setup() {
        deviceHardwareService.deviceHardwareRepository = deviceHardwareRepositoryMock
    }

    def "testInsert"() {

        when:
        deviceHardwareService.insert(null)
        then:
        0 * deviceHardwareRepositoryMock.findByDevicePhysicalPortAndDeviceInternalPortAndDeviceGPIO(_, _, _)
        thrown(NullPointerException.class)
    }
}
