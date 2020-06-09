package android.tvz.hr.happyenvelope;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.tvz.hr.happyenvelope.retrofit.ServiceGenerator;
import android.tvz.hr.happyenvelope.retrofit.models.AccessToken;
import android.tvz.hr.happyenvelope.retrofit.services.Auth;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // Ovo bi trebalo pohraniti u lokalnoj bazi. Nalazi se ovdje zbog jednostavnijeg pregleda!
    private static final String URL = "http://10.0.2.2:8080/";
    private final String clientId = "fbolcic@tvz.hr";
    private final String clientSecret = "Krvavice_1";
    private AccessToken token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Auth loginService = ServiceGenerator.createService(Auth.class, URL);

        Call<AccessToken> call = loginService.getAccessToken(clientId, clientSecret, "password");
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
                    token = response.body();
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}