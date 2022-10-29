package ru.snow4dv;

public class PhoneNumber {
    private int countryCode;
    private int callerNumber;

    public PhoneNumber(int countryCode, int callerNumber) {
        this.countryCode = countryCode;
        this.callerNumber = callerNumber;
    }

    public String getRepresentation() {
        if(countryCode == 7) {
            return "8" + callerNumber;
        }
        return "+" + countryCode + callerNumber;
    }

    public String getBeautifulRepresentation() {
        return "+" + countryCode + (callerNumber /10000000) + ((callerNumber/1000)%1000)
                + (callerNumber%1000);
    }
}
