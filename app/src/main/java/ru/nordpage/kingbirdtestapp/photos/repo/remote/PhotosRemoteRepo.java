package ru.nordpage.kingbirdtestapp.photos.repo.remote;

import io.reactivex.Observable;
import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photos;

public interface PhotosRemoteRepo {
    Observable<Photos> getAllPhotos();
}
