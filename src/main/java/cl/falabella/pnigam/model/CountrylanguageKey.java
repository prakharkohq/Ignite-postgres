package cl.falabella.pnigam.model;

import java.io.Serializable;

/**
 * CountrylanguageKey definition.
 * 
 **/
public class CountrylanguageKey implements Serializable {
    /** */
    private static final long serialVersionUID = 0L;

    /** Value for countrycode. */
    private String countrycode;

    /** Value for language. */
    private String language;

    /** Empty constructor. **/
    public CountrylanguageKey() {
        // No-op.
    }

    /** Full constructor. **/
    public CountrylanguageKey(String countrycode,
        String language) {
        this.countrycode = countrycode;
        this.language = language;
    }

    /**
     * Gets countrycode
     * 
     * @return Value for countrycode.
     **/
    public String getCountrycode() {
        return countrycode;
    }

    /**
     * Sets countrycode
     * 
     * @param countrycode New value for countrycode.
     **/
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    /**
     * Gets language
     * 
     * @return Value for language.
     **/
    public String getLanguage() {
        return language;
    }

    /**
     * Sets language
     * 
     * @param language New value for language.
     **/
    public void setLanguage(String language) {
        this.language = language;
    }

    /** {@inheritDoc} **/
    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        
        if (!(o instanceof CountrylanguageKey))
            return false;
        
        CountrylanguageKey that = (CountrylanguageKey)o;

        if (countrycode != null ? !countrycode.equals(that.countrycode) : that.countrycode != null)
            return false;
        

        if (language != null ? !language.equals(that.language) : that.language != null)
            return false;
        
        return true;
    }

    /** {@inheritDoc} **/
    @Override public int hashCode() {
        int res = countrycode != null ? countrycode.hashCode() : 0;

        res = 31 * res + (language != null ? language.hashCode() : 0);

        return res;
    }

    /** {@inheritDoc} **/
    @Override public String toString() {
        return "CountrylanguageKey [" + 
            "countrycode=" + countrycode + ", " + 
            "language=" + language +
        "]";
    }
}