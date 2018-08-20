package yuva_dondapati.demos.android.fluidbookshelf.model;

public class ImageModel {

    public String title;
    public Integer imageUrl;


    public ImageModel(String title, Integer imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImg_url(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
