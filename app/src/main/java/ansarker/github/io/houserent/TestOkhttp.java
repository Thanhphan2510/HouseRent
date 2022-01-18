package ansarker.github.io.houserent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import ansarker.github.io.houserent.model.Account;
import ansarker.github.io.houserent.myutils.MyUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TestOkhttp extends AppCompatActivity {
    private TextView tvTestOkhttp;
    private Button btn;
    public String url="http://192.168.100.12:8080/accounts";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_okhttp);
        tvTestOkhttp = findViewById(R.id.tvTestOkhttp);
        btn = findViewById(R.id.btnChoose);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    System.out.println("ok");
                    run();
                }catch (Exception e){
                    System.out.println("thanhpt error:  "+ e);
                }
            }
        });
    }

    private void run() throws IOException{
//        OkHttpClient client = new OkHttpClient();
        OkHttpClient client = new OkHttpClient.Builder()
                //default timeout for not annotated requests
//                .readTimeout(10000, TimeUnit.MILLISECONDS)
//                .connectTimeout(10000, TimeUnit.MILLISECONDS)
//                .writeTimeout(10000, TimeUnit.MILLISECONDS)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e);
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                final String myResponse = response.body().string();

                TestOkhttp.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("thanhpt", "run: "+myResponse );
                       List<Account> result = (List<Account>)(Object) MyUtils.fromJSon(myResponse);
                       tvTestOkhttp.setText(result.toString());
                        System.out.println("");

                    }
                });

            }
        });
//        tvTestOkhttp.setText(client.newCall(request).execute( ).body().toString());
    }


}
