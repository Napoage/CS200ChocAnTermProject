public class Member {
    private String name;
    private String number; // 9-digit member number
    private String streetAddress;
    private String city;
    private String state; // 2-letter state code
    private String zipCode; // 5-digit ZIP code
    private boolean status; // Active or suspended

    // Constructor
    public Member(String name, String number, String streetAddress, String city, String state, String zipCode) {
        this.name = name;
        this.number = number;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.status = true; // Assuming new members are active by default
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state.toUpperCase();
    }

    public String getZipCode() {
        return zipCode;
    }

    public boolean getStatus() {
        return status;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        if (number.length() != 9) {
            System.out.println("Member number must be 9 digits");
            return;
        }
        this.number = number;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        if (city.length() > 20) {
            System.out.println("City name must be less than 20 characters");
            return;
        }
        this.city = city;
    }

    public void setState(String state) {
        if (state.length() != 2) {
            System.out.println("State code must be 2 characters");
            return;
        }
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        if (zipCode.length() != 5) {
            System.out.println("ZIP code must be 5 digits");
            return;
        }
        this.zipCode = zipCode;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // Other methods

    public String toString() {
        return "Name: " + name + "\nNumber: " + number + "\nStreet Address: " + streetAddress + "\nCity: " + city
                + "\nState: " + state + "\nZIP Code: " + zipCode + "\nStatus: " + (status ? "Active" : "Suspended");
    }

    public boolean equals(Member member) {
        return this.number.equals(member.getNumber());
    }
}
