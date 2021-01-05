package com.tell_fail_fast.domain;

import com.tell_fail_fast.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Cesar
 * @see com.tell_fail_fast.domain
 * @since 04/01/2021
 */
@AllArgsConstructor
@Data
public class Post {

    private String namePost;

    private Status status;
}
