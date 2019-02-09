package ru.nordpage.kingbirdtestapp.photos.repo.local;

import java.util.List;

import io.reactivex.Observable;
import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photo;
import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photos;

public interface PhotosLocalRepo {
    Observable<Photos> getAllPhotos();
    void addPhotos(Photos photos);
    void addPhotoList(List<Photo> photos);
}
