package cl.falabella.pnigam.model;

import java.io.Serializable;

/**
 * Countrylanguage definition.
 * 
 **/
public class Countrylanguage implements Serializable {
    /** */
    private static final long serialVersionUID = 0L;

    /** Value for isofficial. */
    private boolean isofficial;

    /** Value for percentage. */
    private double percentage;

    /** Empty constructor. **/
    public Countrylanguage() {
        // No-op.
    }

    /** Full constructor. **/
    public Countrylanguage(boolean isofficial,
        double percentage) {
        this.isofficial = isofficial;
        this.percentage = percentage;
    }

    /**
     * Gets isofficial
     * 
     * @return Value for isofficial.
     **/
    public boolean getIsofficial() {
        return isofficial;
    }

    /**
     * Sets isofficial
     * 
     * @param isofficial New value for isofficial.
     **/
    public void setIsofficial(boolean isofficial) {
        this.isofficial = isofficial;
    }

    /**
     * Gets percentage
     * 
     * @return Value for percentage.
     **/
    public double getPercentage() {
        return percentage;
    }

    /**
     * Sets percentage
     * 
     * @param percentage New value for percentage.
     **/
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    /** {@inheritDoc} **/
    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        
        if (!(o instanceof Countrylanguage))
            return false;
        
        Countrylanguage that = (Countrylanguage)o;

        if (isofficial != that.isofficial)
            return false;
        

        if (Double.compare(percentage, that.percentage) != 0)
            return false;
        
        return true;
    }

    /** {@inheritDoc} **/
    @Override public int hashCode() {
        int res = isofficial ? 1 : 0;

        long ig_hash_temp = Double.doubleToLongBits(percentage);
        res = 31 * res + (int) (ig_hash_temp ^ (ig_hash_temp >>> 32));

        return res;
    }

    /** {@inheritDoc} **/
    @Override public String toString() {
        return "Countrylanguage [" + 
            "isofficial=" + isofficial + ", " + 
            "percentage=" + percentage +
        "]";
    }
}