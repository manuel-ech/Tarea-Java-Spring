package login;

public class Image {

    private String image;

    public Image() {
        super();
    }
    
    public Image(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    @Override
    public String toString(){
	    return getImage();
    }
}