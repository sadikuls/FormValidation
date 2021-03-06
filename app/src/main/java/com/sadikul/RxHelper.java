package com.sadikul;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import io.reactivex.subjects.PublishSubject;
/**
 * Created by ASUS on 07-Mar-18.
 */

public class RxHelper{

        public static PublishSubject<String> getTextWatcherObservable(@NonNull final EditText editText) {

             final PublishSubject<String> subject = PublishSubject.create();

            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {}

                @Override
                public void afterTextChanged(Editable s) {
                    subject.onNext(s.toString());
                }
            });

        return subject;
    }

}
