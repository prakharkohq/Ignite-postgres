package cl.falabella.pnigam.model;

import java.io.Serializable;

/**
 * City definition.
 * 
 **/
public class City implements Serializable {
    /** */
    private static final long serialVersionUID = 0L;

    /** Value for name. */
    private String name;

    /** Value for countrycode. */
    private String countrycode;

    /** Value for district. */
    private String district;

    /** Value for population. */
    private int population;

    /** Empty constructor. **/
    public City() {
        // No-op.
    }

    /** Full constructor. **/
    public City(String name,
        String countrycode,
        String district,
        int population) {
        this.name = name;
        this.countrycode = countrycode;
        this.district = district;
        this.population = population;
    }

    /**
     * Gets name
     * 
     * @return Value for name.
     **/
    public String getName() {
        return name;
    }

    /**
     * Sets name
     * 
     * @param name New value for name.
     **/
    public void setName(String name) {
        this.name = name;
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
     * Gets district
     * 
     * @return Value for district.
     **/
    public String getDistrict() {
        return district;
    }

    /**
     * Sets district
     * 
     * @param district New value for district.
     **/
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Gets population
     * 
     * @return Value for population.
     **/
    public int getPopulation() {
        return population;
    }

    /**
     * Sets population
     * 
     * @param population New value for population.
     **/
    public void setPopulation(int population) {
        this.population = population;
    }

    /** {@inheritDoc} **/
    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        
        if (!(o instanceof City))
            return false;
        
        City that = (City)o;

        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        

        if (countrycode != null ? !countrycode.equals(that.countrycode) : that.countrycode != null)
            return false;
        

        if (district != null ? !district.equals(that.district) : that.district != null)
            return false;
        

        if (population != that.population)
            return false;
        
        return true;
    }

    /** {@inheritDoc} **/
    @Override public int hashCode() {
        int res = name != null ? name.hashCode() : 0;

        res = 31 * res + (countrycode != null ? countrycode.hashCode() : 0);

        res = 31 * res + (district != null ? district.hashCode() : 0);

        res = 31 * res + (population);

        return res;
    }

    /** {@inheritDoc} **/
    @Override public String toString() {
        return "City [" + 
            "name=" + name + ", " + 
            "countrycode=" + countrycode + ", " + 
            "district=" + district + ", " + 
            "population=" + population +
        "]";
    }
}