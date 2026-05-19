package api;

import kg.rest.HttpRequest;
import kg.rest.controller.PostController;
import kg.rest.controller.UserController;
import kg.rest.models.User;
import kg.utils.file.ConfigurationManager;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Tag("UI")
public class UsersTest {

    UserController userController = new UserController(ConfigurationManager.getBaseConfig().gorestBaseUrl());
    PostController postController = new PostController((ConfigurationManager.getBaseConfig().gorestBaseUrl()));

    @Test
    void userTest(){
        System.out.println(Arrays.toString(userController.getAllUsers()));
        User user = User.builder()
                .name("Miraida")
                .email("mira_" + System.currentTimeMillis() + "@gmail.com")
                .gender("female")
                .status("active")
                .build();
        User actualUser = userController.createNewUser(user);
        System.out.println(actualUser);
    }

    @Test
    void postTest(){
        System.out.println(Arrays.toString(postController.getAllPosts()));
    }

    @Test
    void getUserPostById(){
        System.out.println(Arrays.toString(postController.getUserPostById(8433298)));
    }
}
