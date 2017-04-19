package ac.il.shenkar.middleware.services;

import ac.il.shenkar.middleware.models.Device;
import org.springframework.stereotype.Component;

import javax.usb.*;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Component
public class DeviceCheckerService {

	public Set<Device> getActiveDevices(List<Device> devices) throws Exception {
		UsbServices services = UsbHostManager.getUsbServices();
		UsbHub root = services.getRootUsbHub();
		Set<Device> pluggedDevices = getDevices(root);
		pluggedDevices.retainAll(devices);
		return pluggedDevices;
	}

	public Set<Device> getDevices(UsbHub hub) throws UnsupportedEncodingException, UsbException {
		List perepheriques = hub.getAttachedUsbDevices();
		Set<Device> pluggedDevices = new HashSet<>();
		Iterator iterator = perepheriques.iterator();
		while (iterator.hasNext()) {
			UsbDevice perepherique = (UsbDevice) iterator.next();
			UsbDeviceDescriptor usbDeviceDescriptor = perepherique.getUsbDeviceDescriptor();
			Device device = new Device();
			device.setVendorId(String.format("%04x", new Object[]{Integer.valueOf(usbDeviceDescriptor.idVendor() & '\uffff')}));
			device.setProductId(String.format("%04x", new Object[]{Integer.valueOf(usbDeviceDescriptor.idProduct() & '\uffff')}));
			pluggedDevices.add(device);
			if (perepherique.isUsbHub())
				pluggedDevices.addAll(getDevices((UsbHub) perepherique));
		}
		return pluggedDevices;
	}
}