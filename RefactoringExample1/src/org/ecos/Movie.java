package org.ecos;

public class Movie {
    private final String _title;    
    private int _priceCode;
    
    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }
  
    public String getTitle() {
        return _title;
    }
    
    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int priceCode) {
        _priceCode = priceCode;
    }
    
}
