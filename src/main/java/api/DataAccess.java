package api;

public interface DataAccess {
    public void setPictureRating(int rating);

    public Integer[] getPictureRating();

    public void setFactRating(int rating);

    public Integer[] getFactRating();
}
