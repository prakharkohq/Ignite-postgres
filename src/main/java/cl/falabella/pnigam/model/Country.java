package cl.falabella.pnigam.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigDecimal;

/**
 * Country definition.
 * 
 **/
public class Country implements Serializable {
    /** */
    private static final long serialVersionUID = 0L;

    /** Value for name. */
    private String name;

    /** Value for continent. */
    private String continent;

    /** Value for region. */
    private String region;

    /** Value for surfacearea. */
    private double surfacearea;

    /** Value for indepyear. */
    private Short indepyear;

    /** Value for population. */
    private int population;

    /** Value for lifeexpectancy. */
    private Double lifeexpectancy;

    /** Value for gnp. */
    private BigDecimal gnp;

    /** Value for gnpold. */
    private BigDecimal gnpold;

    /** Value for localname. */
    private String localname;

    /** Value for governmentform. */
    private String governmentform;

    /** Value for headofstate. */
    private String headofstate;

    /** Value for capital. */
    private Integer capital;

    /** Value for code2. */
    private String code2;

    /** Empty constructor. **/
    public Country() {
        // No-op.
    }

    /** Full constructor. **/
    public Country(String name,
        String continent,
        String region,
        double surfacearea,
        Short indepyear,
        int population,
        Double lifeexpectancy,
        BigDecimal gnp,
        BigDecimal gnpold,
        String localname,
        String governmentform,
        String headofstate,
        Integer capital,
        String code2) {
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfacearea = surfacearea;
        this.indepyear = indepyear;
        this.population = population;
        this.lifeexpectancy = lifeexpectancy;
        this.gnp = gnp;
        this.gnpold = gnpold;
        this.localname = localname;
        this.governmentform = governmentform;
        this.headofstate = headofstate;
        this.capital = capital;
        this.code2 = code2;
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
     * Gets continent
     * 
     * @return Value for continent.
     **/
    public String getContinent() {
        return continent;
    }

    /**
     * Sets continent
     * 
     * @param continent New value for continent.
     **/
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Gets region
     * 
     * @return Value for region.
     **/
    public String getRegion() {
        return region;
    }

    /**
     * Sets region
     * 
     * @param region New value for region.
     **/
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Gets surfacearea
     * 
     * @return Value for surfacearea.
     **/
    public double getSurfacearea() {
        return surfacearea;
    }

    /**
     * Sets surfacearea
     * 
     * @param surfacearea New value for surfacearea.
     **/
    public void setSurfacearea(double surfacearea) {
        this.surfacearea = surfacearea;
    }

    /**
     * Gets indepyear
     * 
     * @return Value for indepyear.
     **/
    public Short getIndepyear() {
        return indepyear;
    }

    /**
     * Sets indepyear
     * 
     * @param indepyear New value for indepyear.
     **/
    public void setIndepyear(Short indepyear) {
        this.indepyear = indepyear;
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

    /**
     * Gets lifeexpectancy
     * 
     * @return Value for lifeexpectancy.
     **/
    public Double getLifeexpectancy() {
        return lifeexpectancy;
    }

    /**
     * Sets lifeexpectancy
     * 
     * @param lifeexpectancy New value for lifeexpectancy.
     **/
    public void setLifeexpectancy(Double lifeexpectancy) {
        this.lifeexpectancy = lifeexpectancy;
    }

    /**
     * Gets gnp
     * 
     * @return Value for gnp.
     **/
    public BigDecimal getGnp() {
        return gnp;
    }

    /**
     * Sets gnp
     * 
     * @param gnp New value for gnp.
     **/
    public void setGnp(BigDecimal gnp) {
        this.gnp = gnp;
    }

    /**
     * Gets gnpold
     * 
     * @return Value for gnpold.
     **/
    public BigDecimal getGnpold() {
        return gnpold;
    }

    /**
     * Sets gnpold
     * 
     * @param gnpold New value for gnpold.
     **/
    public void setGnpold(BigDecimal gnpold) {
        this.gnpold = gnpold;
    }

    /**
     * Gets localname
     * 
     * @return Value for localname.
     **/
    public String getLocalname() {
        return localname;
    }

    /**
     * Sets localname
     * 
     * @param localname New value for localname.
     **/
    public void setLocalname(String localname) {
        this.localname = localname;
    }

    /**
     * Gets governmentform
     * 
     * @return Value for governmentform.
     **/
    public String getGovernmentform() {
        return governmentform;
    }

    /**
     * Sets governmentform
     * 
     * @param governmentform New value for governmentform.
     **/
    public void setGovernmentform(String governmentform) {
        this.governmentform = governmentform;
    }

    /**
     * Gets headofstate
     * 
     * @return Value for headofstate.
     **/
    public String getHeadofstate() {
        return headofstate;
    }

    /**
     * Sets headofstate
     * 
     * @param headofstate New value for headofstate.
     **/
    public void setHeadofstate(String headofstate) {
        this.headofstate = headofstate;
    }

    /**
     * Gets capital
     * 
     * @return Value for capital.
     **/
    public Integer getCapital() {
        return capital;
    }

    /**
     * Sets capital
     * 
     * @param capital New value for capital.
     **/
    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    /**
     * Gets code2
     * 
     * @return Value for code2.
     **/
    public String getCode2() {
        return code2;
    }

    /**
     * Sets code2
     * 
     * @param code2 New value for code2.
     **/
    public void setCode2(String code2) {
        this.code2 = code2;
    }

    /** {@inheritDoc} **/
    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        
        if (!(o instanceof Country))
            return false;
        
        Country that = (Country)o;

        if (name != null ? !name.equals(that.name) : that.name != null)
            return false;
        

        if (continent != null ? !continent.equals(that.continent) : that.continent != null)
            return false;
        

        if (region != null ? !region.equals(that.region) : that.region != null)
            return false;
        

        if (Double.compare(surfacearea, that.surfacearea) != 0)
            return false;
        

        if (indepyear != null ? !indepyear.equals(that.indepyear) : that.indepyear != null)
            return false;
        

        if (population != that.population)
            return false;
        

        if (lifeexpectancy != null ? !lifeexpectancy.equals(that.lifeexpectancy) : that.lifeexpectancy != null)
            return false;
        

        if (gnp != null ? !gnp.equals(that.gnp) : that.gnp != null)
            return false;
        

        if (gnpold != null ? !gnpold.equals(that.gnpold) : that.gnpold != null)
            return false;
        

        if (localname != null ? !localname.equals(that.localname) : that.localname != null)
            return false;
        

        if (governmentform != null ? !governmentform.equals(that.governmentform) : that.governmentform != null)
            return false;
        

        if (headofstate != null ? !headofstate.equals(that.headofstate) : that.headofstate != null)
            return false;
        

        if (capital != null ? !capital.equals(that.capital) : that.capital != null)
            return false;
        

        if (code2 != null ? !code2.equals(that.code2) : that.code2 != null)
            return false;
        
        return true;
    }

    /** {@inheritDoc} **/
    @Override public int hashCode() {
        int res = name != null ? name.hashCode() : 0;

        res = 31 * res + (continent != null ? continent.hashCode() : 0);

        res = 31 * res + (region != null ? region.hashCode() : 0);

        long ig_hash_temp = Double.doubleToLongBits(surfacearea);
        res = 31 * res + (int) (ig_hash_temp ^ (ig_hash_temp >>> 32));

        res = 31 * res + (indepyear != null ? indepyear.hashCode() : 0);

        res = 31 * res + (population);

        res = 31 * res + (lifeexpectancy != null ? lifeexpectancy.hashCode() : 0);

        res = 31 * res + (gnp != null ? gnp.hashCode() : 0);

        res = 31 * res + (gnpold != null ? gnpold.hashCode() : 0);

        res = 31 * res + (localname != null ? localname.hashCode() : 0);

        res = 31 * res + (governmentform != null ? governmentform.hashCode() : 0);

        res = 31 * res + (headofstate != null ? headofstate.hashCode() : 0);

        res = 31 * res + (capital != null ? capital.hashCode() : 0);

        res = 31 * res + (code2 != null ? code2.hashCode() : 0);

        return res;
    }

    /** {@inheritDoc} **/
    @Override public String toString() {
        return "Country [" + 
            "name=" + name + ", " + 
            "continent=" + continent + ", " + 
            "region=" + region + ", " + 
            "surfacearea=" + surfacearea + ", " + 
            "indepyear=" + indepyear + ", " + 
            "population=" + population + ", " + 
            "lifeexpectancy=" + lifeexpectancy + ", " + 
            "gnp=" + gnp + ", " + 
            "gnpold=" + gnpold + ", " + 
            "localname=" + localname + ", " + 
            "governmentform=" + governmentform + ", " + 
            "headofstate=" + headofstate + ", " + 
            "capital=" + capital + ", " + 
            "code2=" + code2 +
        "]";
    }
}