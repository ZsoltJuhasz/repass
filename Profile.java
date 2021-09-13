public class Profile {
    String user;
    String pass;
    String place;
    
    public Profile(String [] profileArray) {
        this.user = profileArray[0];
        this.pass = profileArray[1];
        this.place = profileArray[2];
    }
    public String getPass() {
        return pass;
    }
    public boolean isPasswordEmpty() {
        if(this.pass == "") {
            return true;
        }else {
            return false;
        }
    }
}
