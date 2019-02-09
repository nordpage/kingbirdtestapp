package ru.nordpage.kingbirdtestapp.photos.repo.converters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photo;

public class PhotoConverter {
    @TypeConverter
    public static List<Photo> fromValues(String value) {
        Type listType = new TypeToken<List<Photo>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public static String toValues(List<Photo> values) {
        Gson gson = new Gson();
        String json = gson.toJson(values);
        return json;
    }
}
