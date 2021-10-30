package com.springstudy;

import com.springstudy.controller.PostController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        final var context = new AnnotationConfigApplicationContext("com.springstudy");

        final var controller = context.getBean("postController");

        final var service = context.getBean("postService");
    }
}
