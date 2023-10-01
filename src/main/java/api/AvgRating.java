package api;

public class AvgRating {

    //using data class
    private final Data dataAccess;

    // construct
    public AvgRating() {
        this.dataAccess = new Data();
    }

    //Avg rating for pictures implement
    public Integer getAvgPic() {
        Integer[] pictureRatings = dataAccess.getPictureRating();
        if(pictureRatings == null || pictureRatings.length == 0)
            return null;
        int sum = 0;
        for(int rating : pictureRatings) {
            sum += rating;
        }
        return sum / pictureRatings.length;
    }

    //Avg rating for facts implement
    public Integer getAvgFact() {
        Integer[] factRatings = dataAccess.getFactRating();
        if(factRatings == null || factRatings.length == 0)
            return null;
        int sum = 0;
        for(int rating : factRatings) {
            sum += rating;
        }
        return sum / factRatings.length;
    }

}

