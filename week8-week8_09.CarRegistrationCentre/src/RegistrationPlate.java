
public class RegistrationPlate {
    // don't change the code which is already given to you

    // ATTENTION: the object variable types are final, meaning that their value cannot be changed!
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + regCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        RegistrationPlate compared = (RegistrationPlate) obj;
        
        return this.regCode.equals(compared.regCode) && this.country.equals(compared.country);
    }

    @Override
    public int hashCode() {
        
        // 7 is randomly chosen
        if (this.regCode == null || this.country == null) {
            return 7;
        }
        
        return this.country.hashCode() + this.regCode.hashCode();
    }
    

}
