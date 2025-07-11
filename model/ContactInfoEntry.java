package cvbuilder.model;

import java.io.Serializable;

public class ContactInfoEntry implements Serializable {
    private String phoneNumber;
    private String address;
    private boolean includePhone;
    private boolean includeAddress;

    public ContactInfoEntry() {
    }

    public ContactInfoEntry(String phoneNumber, String address, boolean includePhone, boolean includeAddress) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.includePhone = includePhone;
        this.includeAddress = includeAddress;
    }

    // Getters and setters

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isIncludePhone() {
        return includePhone;
    }

    public void setIncludePhone(boolean includePhone) {
        this.includePhone = includePhone;
    }

    public boolean isIncludeAddress() {
        return includeAddress;
    }

    public void setIncludeAddress(boolean includeAddress) {
        this.includeAddress = includeAddress;
    }

    @Override
    public String toString() {
        return "ContactInfoEntry{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", includePhone=" + includePhone +
                ", includeAddress=" + includeAddress +
                '}';
    }
}
