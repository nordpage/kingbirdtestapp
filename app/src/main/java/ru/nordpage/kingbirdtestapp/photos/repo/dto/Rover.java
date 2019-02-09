
package ru.nordpage.kingbirdtestapp.photos.repo.dto;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ru.nordpage.kingbirdtestapp.photos.repo.converters.CameraConverter;

public class Rover {

    @ColumnInfo(name = "cameras")
    @SerializedName("cameras")
    @TypeConverters({CameraConverter.class})
    private List<Camera> mCameras;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    private Long mId;

    @ColumnInfo(name = "landing_date")
    @SerializedName("landing_date")
    private String mLandingDate;

    @ColumnInfo(name = "launch_date")
    @SerializedName("launch_date")
    private String mLaunchDate;

    @ColumnInfo(name = "max_date")
    @SerializedName("max_date")
    private String mMaxDate;

    @ColumnInfo(name = "max_sol")
    @SerializedName("max_sol")
    private Long mMaxSol;

    @ColumnInfo(name = "rover_name")
    @SerializedName("name")
    private String mName;

    @ColumnInfo(name = "status")
    @SerializedName("status")
    private String mStatus;

    @ColumnInfo(name = "total_photos")
    @SerializedName("total_photos")
    private Long mTotalPhotos;

    public List<Camera> getCameras() {
        return mCameras;
    }

    public void setCameras(List<Camera> cameras) {
        mCameras = cameras;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getLandingDate() {
        return mLandingDate;
    }

    public void setLandingDate(String landingDate) {
        mLandingDate = landingDate;
    }

    public String getLaunchDate() {
        return mLaunchDate;
    }

    public void setLaunchDate(String launchDate) {
        mLaunchDate = launchDate;
    }

    public String getMaxDate() {
        return mMaxDate;
    }

    public void setMaxDate(String maxDate) {
        mMaxDate = maxDate;
    }

    public Long getMaxSol() {
        return mMaxSol;
    }

    public void setMaxSol(Long maxSol) {
        mMaxSol = maxSol;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public Long getTotalPhotos() {
        return mTotalPhotos;
    }

    public void setTotalPhotos(Long totalPhotos) {
        mTotalPhotos = totalPhotos;
    }

}
