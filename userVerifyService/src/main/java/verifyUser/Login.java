package verifyUser;

public class Login {

    private String username;
    private String image;

    public Login() {
        super();
    }
    
    public Login(String username, String image) {
        this.username = username;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    @Override
    public String toString(){
	    return getUsername() + ", "+getImage();
    }
}