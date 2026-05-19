package kg.rest.controller;

import kg.rest.HttpRequest;
import kg.rest.endpoint.EndPoint;
import kg.rest.models.User;
import kg.rest.models.Post;

public class UserController extends HttpRequest {

    public UserController(String url){
        super(url);
    }

    public User[] getAllUsers(){
        return get(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS)).as(User[].class);
    }

    public User createNewUser(User user){
        return super.post(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS), user.toJson()).as(User.class);
    }
}
