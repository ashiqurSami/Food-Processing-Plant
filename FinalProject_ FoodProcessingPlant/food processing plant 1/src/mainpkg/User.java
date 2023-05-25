
package mainpkg;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable{
    protected String name,user_type,email,password;
    protected int id;
    
    public User(){
        
    }
    public User(String name, String user_type, String email, String password, int id) {
        this.name = name;
        this.user_type = user_type;
        this.email = email;
        this.password = password;
        this.id = id;
    }
    
    public abstract void addUser();
    
    public static User login(int id, String pass, String type){
        ArrayList<User>uList = UserList.listOfUser();
        for(User i:uList){
            if(i.getId()==id && i.getUser_type().equals(type) && i.getPassword().equals(pass)){
                return i;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getUser_type() {
        return user_type;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", user_type=" + user_type + ", email=" + email + ", password=" + password + ", id=" + id + '}';
    }
}
