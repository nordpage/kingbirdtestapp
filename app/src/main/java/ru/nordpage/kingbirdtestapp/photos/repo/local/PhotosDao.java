package ru.nordpage.kingbirdtestapp.photos.repo.local;

import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photo;
import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photos;

@Dao
public interface PhotosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Photos photos);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPhotos(List<Photo> photos);

    @Query("SELECT * FROM photo_table")
    Photos getAll();

    @Query("SELECT * FROM photos LIMIT :limit OFFSET :offset")
    List<Photo> getAllPhotosLimited(int limit, int offset);

    @Query("SELECT * FROM photos")
    List<Photo> getAllPhotos();

    @Query("SELECT * FROM photos")
    DataSource.Factory<Integer, Photo> getPhotos();

    @Delete
    void deletePhoto(Photo photo);


}
