package api;

public class AvgRating {

    private final Data dataAccess;

    public AvgRating() {
        this.dataAccess = new Data();
    }

    // Constructor to initialize DataAccess implementation

    public Integer getAvgPic() {
        Integer[] pictureRatings = dataAccess.getPictureRating();
        if(pictureRatings == null || pictureRatings.length == 0) return null;

        int sum = 0;
        for(int rating : pictureRatings) {
            sum += rating;
        }

        return sum / pictureRatings.length;
    }

    public Integer getAvgFact() {
        Integer[] factRatings = dataAccess.getFactRating();
        if(factRatings == null || factRatings.length == 0) return null;

        int sum = 0;
        for(int rating : factRatings) {
            sum += rating;
        }

        return sum / factRatings.length;
    }


}

