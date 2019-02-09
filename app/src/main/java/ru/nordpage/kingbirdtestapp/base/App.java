package ru.nordpage.kingbirdtestapp.base;

import android.app.Application;
import android.arch.persistence.room.Room;

import ru.nordpage.kingbirdtestapp.photos.repo.local.AppDatabase;
import ru.nordpage.kingbirdtestapp.photos.repo.local.LocalConst;

public class App extends Application {
    static App instanse;
    static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, LocalConst.DB).allowMainThreadQueries().build();
    }

    public static App getInstanse() {
        return instanse;
    }

    public static AppDatabase getDb() {
        return db;
    }
}
