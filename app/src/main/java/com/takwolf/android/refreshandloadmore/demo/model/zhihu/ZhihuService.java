package com.takwolf.android.refreshandloadmore.demo.model.zhihu;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ZhihuService {

    @GET("stories/latest")
    Call<StoryPage> getLatestStoryList();

    @GET("stories/before/{date}")
    Call<StoryPage> getStoryListBefore(
            @Path("date") String date
    );

}
