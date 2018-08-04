package com.example.yogeshwaraass.timerapp;


import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*import com.rxjava2.android.samples.R;
import com.rxjava2.android.samples.utils.AppConstant;*/

import java.util.Timer;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by amitshekhar on 27/08/16.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static int TIMER_VALUE,start;
    Button btn;
    TextView textView;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        int TIMER_VALUE = Integer.parseInt(et.getText().toString());
        int start = 0;
    }
    public void doSomething(View view) {
        int finish = TIMER_VALUE;
        Observable.intervalRange(1, TIMER_VALUE, 60,10,TimeUnit.MILLISECONDS,Schedulers.computation())
                .take(TIMER_VALUE)
                .subscribe(new Observer<Long>(){
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(Long aLong) {
                         textView.setText(start);
                         start=start+1;
                    }
                    @Override
                    public void onError(Throwable e) {
                        Toast toast = Toast.makeText(getApplicationContext(),"ERROR IN TIMER",Toast.LENGTH_LONG);
                        toast.show();
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }
}