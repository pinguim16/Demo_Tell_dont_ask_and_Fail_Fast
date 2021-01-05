package com.tell_fail_fast.domain.enums;

import com.tell_fail_fast.domain.Post;

/**
 * @author Cesar
 * @see com.tell_fail_fast.domain
 * @since 04/01/2021
 */
public enum Status {

    PUBLISH{
        @Override
        public void alterStatus(Post post) {
            post.setStatus(Status.REMOVE);
        }
    },
    DRAFT{
        @Override
        public void alterStatus(Post post) {
            post.setStatus(Status.PUBLISH);
        }
    },
    REMOVE{
        @Override
        public void alterStatus(Post post) {
            post.setStatus(Status.DRAFT);
        }
    },
    ERROR {
        @Override
        public void alterStatus(Post post) {
        }
    };

    public abstract void alterStatus(Post post);
}
