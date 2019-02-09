
package ru.nordpage.kingbirdtestapp.photos.repo.dto;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class Camera {

    @ColumnInfo(name = "full_name")
    @SerializedName("full_name")
    private String mFullName;

    @ColumnInfo(name = "camera_id")
    @SerializedName("id")
    private Long mId;

    @ColumnInfo(name = "camera_name")
    @SerializedName("name")
    private String mName;

    @ColumnInfo(name = "rover_id")
    @SerializedName("rover_id")
    private Long mRoverId;

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getRoverId() {
        return mRoverId;
    }

    public void setRoverId(Long roverId) {
        mRoverId = roverId;
    }

}
