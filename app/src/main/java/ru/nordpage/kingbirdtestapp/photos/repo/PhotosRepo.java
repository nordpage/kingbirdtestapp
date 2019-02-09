package ru.nordpage.kingbirdtestapp.photos.repo;

import io.reactivex.Observable;
import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photos;

public interface PhotosRepo {
    Observable<Photos> getAllPhotos();
}
