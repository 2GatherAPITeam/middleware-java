package ac.il.shenkar.middleware.models;

public class Device {

	private String vendorId;
	private String productId;

	public Device() {}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Device device = (Device) o;

		if (vendorId != null ? !vendorId.equals(device.vendorId) : device.vendorId != null)
			return false;
		return productId != null ? productId.equals(device.productId) : device.productId == null;
	}

	@Override public int hashCode() {
		int result = vendorId != null ? vendorId.hashCode() : 0;
		result = 31 * result + (productId != null ? productId.hashCode() : 0);
		return result;
	}

	@Override public String toString() {
		return "Device{" + "vendorId='" + vendorId + '\'' + ", productId='" + productId + '\'' + '}';
	}
}
