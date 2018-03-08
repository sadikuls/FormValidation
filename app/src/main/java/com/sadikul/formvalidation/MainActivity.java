package com.sadikul.formvalidation;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.jakewharton.rxbinding.widget.RxTextView;

import io.reactivex.subjects.PublishSubject;
import rx.Observable;

public class MainActivity extends AppCompatActivity {
    TextInputLayout passInputView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PublishSubject<String> emailSubject = PublishSubject.create();
        EditText emailView = findViewById(R.id.email);
        EditText passView = findViewById(R.id.password);
        passInputView = findViewById(R.id.passwordInput);

        Observable<Boolean> emailCardObservable = RxTextView.textChanges(emailView)
            .map(inputText -> (inputText.length() == 0) || inputText.toString().matches("credit card regex here"));

        Observable<Boolean> passCardObservable = RxTextView.textChanges(passView)
            .map(inputText -> (inputText.length() < 6) )
            .distinctUntilChanged();

        passInputView.setError("Password should be atleast 6 disit");

        passCardObservable.subscribe(isValid -> passInputView.setErrorEnabled(isValid));


    }




    private void setupObservables() {

    }
}
