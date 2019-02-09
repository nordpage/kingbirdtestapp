package ru.nordpage.kingbirdtestapp.photos.repo.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photo;
import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photos;

@Database(entities = {Photos.class, Photo.class}, version = 1)
public abstract class AppDatabase  extends RoomDatabase {

    private static AppDatabase database;
    public abstract PhotosDao getPhotosDao();


    public static AppDatabase getDatabase() {
        return database;
    }
}
