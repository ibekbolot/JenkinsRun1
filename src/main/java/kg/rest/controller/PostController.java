package kg.rest.controller;

import kg.rest.HttpRequest;
import kg.rest.endpoint.EndPoint;
import kg.rest.models.Post;
import kg.rest.models.User;

public class PostController extends HttpRequest {

    public PostController(String url){
        super(url);
    }

    public Post[] getAllPosts(){
        return super.get(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.POSTS)).as(Post[].class);
    }

    public Post[] getUserPostById(Integer id){
        return super.get(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS, String.valueOf(id),
                EndPoint.POSTS)).as(Post[].class);
    }


    


//    public UserController(String url){
//        super(url);
//    }
//
//    public User[] getAllUsers(){
//        return get(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS)).as(User[].class);
//    }
//
//    public User createNewUser(User user){
//        return super.post(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS), user.toJson()).as(User.class);
//    }
}
