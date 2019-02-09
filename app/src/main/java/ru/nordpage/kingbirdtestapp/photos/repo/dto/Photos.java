
package ru.nordpage.kingbirdtestapp.photos.repo.dto;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.nordpage.kingbirdtestapp.photos.repo.converters.PhotoConverter;

@Entity(tableName = "photo_table")
public class Photos {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @SerializedName("photos")
    @TypeConverters(PhotoConverter.class)
    @ColumnInfo(name = "photos")
    private List<Photo> mPhotos;

    public List<Photo> getPhotos() {
        return mPhotos;
    }

    public void setPhotos(List<Photo> photos) {
        mPhotos = photos;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
