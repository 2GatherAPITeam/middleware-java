package ac.il.shenkar.middleware.controllers;

import ac.il.shenkar.middleware.models.Device;
import ac.il.shenkar.middleware.services.DeviceCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/device-checker")
public class DeviceFinderController {

	@Autowired
	private DeviceCheckerService deviceCheckerService;

	@RequestMapping(path = "/get-user-active-devices", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Set<Device> getActiveDevices(@RequestBody List<Device> devices) throws Exception {
		return deviceCheckerService.getActiveDevices(devices);
	}
}