package com.tell_fail_fast.demo;

import com.tell_fail_fast.ExceptionCustom;
import com.tell_fail_fast.domain.Post;
import com.tell_fail_fast.domain.enums.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cesar
 * @see com.tell_fail_fast.demo
 * @since 04/01/2021
 */
@RestController
public class ControllerDontApply {

    //Example dont applicate tell
    @GetMapping("/notapply")
    public void example(@RequestBody Post post) throws ExceptionCustom {
        if(post.getStatus().equals(Status.DRAFT)){
            post.setStatus(Status.PUBLISH);
        }else if(post.getStatus().equals(Status.PUBLISH)){
            post.setStatus(Status.REMOVE);
        }else if(post.getStatus().equals(Status.REMOVE)){
            post.setStatus(Status.DRAFT);
        }else{
            throw new ExceptionCustom("Don't found Status !");
        }
    }
}
