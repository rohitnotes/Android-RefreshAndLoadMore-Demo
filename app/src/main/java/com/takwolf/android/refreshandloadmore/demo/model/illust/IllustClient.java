package com.takwolf.android.refreshandloadmore.demo.model.illust;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public final class IllustClient {

    private IllustClient() {}

    private static final String[] images = {
            "https://static.takwolf.com/app-test/minami-kotori/0.jpg",
            "https://static.takwolf.com/app-test/minami-kotori/1.jpg",
            "https://static.takwolf.com/app-test/minami-kotori/2.jpg",
            "https://static.takwolf.com/app-test/minami-kotori/3.png",
            "https://static.takwolf.com/app-test/minami-kotori/4.png",
            "https://static.takwolf.com/app-test/minami-kotori/5.jpg",
            "https://static.takwolf.com/app-test/minami-kotori/6.jpg",
            "https://static.takwolf.com/app-test/minami-kotori/7.jpg",
            "https://static.takwolf.com/app-test/minami-kotori/8.png",
            "https://static.takwolf.com/app-test/minami-kotori/9.jpg",
            "https://static.takwolf.com/app-test/minami-kotori/10.jpg",
            "https://static.takwolf.com/app-test/minami-kotori/11.jpg",
            "https://static.takwolf.com/app-test/minami-kotori/12.png",
            "https://static.takwolf.com/app-test/minami-kotori/13.jpg",
            "https://static.takwolf.com/app-test/minami-kotori/14.jpg",
            "https://static.takwolf.com/app-test/minami-kotori/15.png",
            "https://static.takwolf.com/app-test/minami-kotori/16.jpg",
            "https://static.takwolf.com/app-test/minami-kotori/17.jpg",
            "https://static.takwolf.com/app-test/minami-kotori/18.png",
            "https://static.takwolf.com/app-test/minami-kotori/19.jpg"
    };

    private static final Random random = new Random();

    public static List<Illust> buildIllustList(int size) {
        List<Illust> illustList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int position = Math.abs(random.nextInt()) % images.length;
            illustList.add(new Illust(UUID.randomUUID().toString(), images[position]));
        }
        return illustList;
    }

}
