package androidx.tvz.hr.happyenvelope.retrofit;

import java.io.IOException;

import androidx.tvz.hr.happyenvelope.retrofit.models.AccessToken;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    public static <S> S createService(Class<S> serviceClass, String baseUrl) {
        //HttpLoggingInterceptor služi za Logging - može usporavati aplikaciju!
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();


        return retrofit.create(serviceClass);
    }

    //Za token
    public static <S> S createService(Class<S> serviceClass, String baseUrl, final AccessToken token) {
        if (token != null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create());
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    Request.Builder requestBuilder = original.newBuilder()
                            .header("Accept", "application/json")
                            .header("Authorization",
                                    token.getTokenType() + " " + token.getAccessToken())
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
            OkHttpClient client = httpClient.build();
            Retrofit retrofit = retrofitBuilder.client(client).build();
            return retrofit.create(serviceClass);
        }
        return null;
    }
}