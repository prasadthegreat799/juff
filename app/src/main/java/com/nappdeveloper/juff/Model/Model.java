package com.nappdeveloper.juff.Model;

public class Model {

    String filterName,filterImage;
    String offerImage;

    public Model() {}

    public Model(String filterName, String filterImage, String offerImage) {
        this.filterName = filterName;
        this.filterImage = filterImage;
        this.offerImage = offerImage;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public String getFilterImage() {
        return filterImage;
    }

    public void setFilterImage(String filterImage) {
        this.filterImage = filterImage;
    }

    public String getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(String offerImage) {
        this.offerImage = offerImage;
    }
}
