package com.springstudy;

import com.springstudy.controller.PostController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.springstudy.service.PostService;

public class Main {
    public static void main(String[] args) {
        // отдаём список пакетов, в которых нужно искать аннотированные классы
        final var context = new AnnotationConfigApplicationContext("com.springstudy");

        // получаем по имени бина
        final var controller = context.getBean(PostController.class);

        // получаем по классу бина
        final var service = context.getBean(PostService.class);

    }
}