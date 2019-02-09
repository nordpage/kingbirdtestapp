
package ru.nordpage.kingbirdtestapp.photos.repo.dto;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "photos")
public class Photo {


    @PrimaryKey(autoGenerate = true)
    private int uid;
    @Embedded
    @SerializedName("camera")
    private Camera mCamera;

    @ColumnInfo(name = "earth_date")
    @SerializedName("earth_date")
    private String mEarthDate;

    @ColumnInfo(name = "photo_id")
    @SerializedName("id")
    private Long mId;

    @ColumnInfo(name = "img_src")
    @SerializedName("img_src")
    private String mImgSrc;

    @Embedded
    @SerializedName("rover")
    private Rover mRover;

    @ColumnInfo(name = "sol")
    @SerializedName("sol")
    private Long mSol;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Camera getCamera() {
        return mCamera;
    }

    public void setCamera(Camera camera) {
        mCamera = camera;
    }

    public String getEarthDate() {
        return mEarthDate;
    }

    public void setEarthDate(String earthDate) {
        mEarthDate = earthDate;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getImgSrc() {
        return mImgSrc;
    }

    public void setImgSrc(String imgSrc) {
        mImgSrc = imgSrc;
    }

    public Rover getRover() {
        return mRover;
    }

    public void setRover(Rover rover) {
        mRover = rover;
    }

    public Long getSol() {
        return mSol;
    }

    public void setSol(Long sol) {
        mSol = sol;
    }


    public static final DiffUtil.ItemCallback<Photo> DIFF_CALLBACK = new DiffUtil.ItemCallback<Photo>() {
        @Override
        public boolean areItemsTheSame(@NonNull Photo oldPhoto, @NonNull Photo newPhoto) {
            return oldPhoto.mId == newPhoto.mId;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Photo oldPhoto, @NonNull Photo newPhoto) {
            return oldPhoto.equals(newPhoto);
        }
    };

    @Override
    public boolean equals(Object obj) {
        if (this.mImgSrc.equals(((Photo)obj).getImgSrc())) {
            return true;
        }

        return false;
    }
}
