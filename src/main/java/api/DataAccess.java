package api;

public interface DataAccess {
    public Integer[] getRatingFromCSV(String fileName);

    public void setRatingInCSV(String fileName, int rating);

    public void setPictureRating(int rating);

    public Integer[] getPictureRating();

    public void setFactRating(int rating);

    public Integer[] getFactRating();
}
