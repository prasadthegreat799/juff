package com.nappdeveloper.juff.Model;

public class Model {

    String filterName,filterImage;
    String offerImage;

    String leaderImage,leaderName;

    public Model() {}

    public Model(String filterName, String filterImage, String offerImage, String leaderImage, String leaderName) {
        this.filterName = filterName;
        this.filterImage = filterImage;
        this.offerImage = offerImage;
        this.leaderImage = leaderImage;
        this.leaderName = leaderName;
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

    public String getLeaderImage() {
        return leaderImage;
    }

    public void setLeaderImage(String leaderImage) {
        this.leaderImage = leaderImage;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }
}
