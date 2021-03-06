package com.example.aleksei.yatranslator.data.network;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.aleksei.yatranslator.data.DataSource;
import com.example.aleksei.yatranslator.data.Repository;
import com.example.aleksei.yatranslator.data.Task;

public class RemoteDataSource implements DataSource {

    private static RemoteDataSource INSTANCE;

    private Context mContext;

    private RemoteDataSource(@NonNull Context context) {
        mContext = context;
    }

    public static RemoteDataSource getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource(context);
        }
        return INSTANCE;
    }

    public long getTranslation(Task task, @NonNull Repository.RemoteLoadListener callback) {
        return ServiceHelper.get(mContext).translate(task, callback);
    }

    @Override
    public void saveTask(Task task) {

    }

    @Override
    public void getHistory(LoadTranslationCallback callback) {

    }
}
