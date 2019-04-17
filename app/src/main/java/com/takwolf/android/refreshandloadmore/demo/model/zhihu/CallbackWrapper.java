package com.takwolf.android.refreshandloadmore.demo.model.zhihu;

import com.takwolf.android.refreshandloadmore.demo.util.HandlerUtils;

import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallbackWrapper<T> implements Callback<T> {

    @Override
    public final void onResponse(@NonNull Call<T> call, @NonNull final Response<T> response) {
        if (response.isSuccessful()) {
            // 让网络调用时间长一点，以便更明显看到效果
            HandlerUtils.handler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    onDataOk(response.body());
                }

            }, 1000);
        } else {
            onKindsOfError("接口返回失败");
        }
    }

    @Override
    public final void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        onKindsOfError("网络错误：" + t.getMessage());
    }

    public void onDataOk(T data) {}

    public void onKindsOfError(@NonNull String message) {}

}
