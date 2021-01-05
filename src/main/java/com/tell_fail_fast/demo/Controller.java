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
public class Controller {

    @GetMapping("/apply")
    public void example(@RequestBody Post post) throws ExceptionCustom {

        if(post.getStatus().equals(Status.ERROR)){
            throw new ExceptionCustom("Don't found Status !");
        }
        post.getStatus().alterStatus(post);
    }

}
