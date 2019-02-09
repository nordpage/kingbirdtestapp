package ru.nordpage.kingbirdtestapp.photos.adapter;

import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photo;

public interface ImageViewListener {
    void onZoom(boolean state, String url);
    void onDelete(Photo photo);
}
