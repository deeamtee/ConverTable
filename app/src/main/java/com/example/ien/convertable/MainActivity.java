package com.example.ien.convertable;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    String LOG_TAG = "TAG_LOG";

    Button button;
    EditText to;
    EditText from;
    TextView textView;
    TextView infoText;
    int a = 0;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife.bind(this);
        button = (Button) findViewById(R.id.button);
        from = (EditText) findViewById(R.id.from);
        to = (EditText) findViewById(R.id.to);
        textView = (TextView) findViewById(R.id.textView);
        infoText = (TextView) findViewById(R.id.infoText);

        RxView.clicks(button)
                .subscribe(aVoid -> loadCurrencyExchangeData(), error -> System.out.println("Error!"));
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("count", textView.getText().toString());
        Log.d(LOG_TAG, "onSaveInstanceState");
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString("count"));
        Log.d(LOG_TAG, "onRestoreInstanceState");
    }

    private void loadCurrencyExchangeData() {

        Retrofit retrofit = RetrofitClient.getInstance();
        ConvertApi convertApi = retrofit.create(ConvertApi.class);


        String from_to = from.getText() + "_" + to.getText();

        convertApi.converts(from_to.toUpperCase(), "ultra")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<Convert>() {
                    @Override
                    public void onSuccess(@NonNull Convert converts) {
                        System.out.println("Контрольная точка 1");
                        switch (from_to.toUpperCase()) {
                            case ("EUR_RUB"):
                                dataRender(converts.getEURRUB().toString());
                                break;
                            case ("RUB_EUR"):
                                dataRender(converts.getRUBEUR().toString());
                                break;
                            case ("USD_RUB"):
                                dataRender(converts.getUSDRUB().toString());
                                break;
                            case ("RUB_USD"):
                                dataRender(converts.getRUBUSD().toString());
                                break;
                            case ("EUR_USD"):
                                dataRender(converts.getEURUSD().toString());
                                break;
                            case ("USD_EUR"):
                                dataRender(converts.getUSDEUR().toString());
                                break;
                            case ("RUB_RUB"):
                                dataRender("привет:) 1");
                                break;
                            case ("EUR_EUR"):
                                dataRender("1");
                                break;
                            case ("USD_USD"):
                                dataRender("1");
                                break;
                            default:
                                textView.setText("");
                                infoText.setText("Приложение поддерживание переводы \n USD->RUB, RUB->USD \n EUR->RUB, RUB->EUR \n USD->EUR, EUR->USD \n :)");
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                        Toast.makeText(getApplicationContext(), "Нет интернет соединения:(", Toast.LENGTH_SHORT).show();
                        Log.i("onError:", e.getMessage());
                    }
                });


    }

    private void dataRender(String s) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.#####"); //можно поиграть с форматом отображения
        double dbl = Double.parseDouble(s);
        textView.setText(decimalFormat.format(dbl));
    }


}
