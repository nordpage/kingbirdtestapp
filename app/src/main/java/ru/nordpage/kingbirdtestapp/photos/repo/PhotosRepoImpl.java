package ru.nordpage.kingbirdtestapp.photos.repo;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photos;
import ru.nordpage.kingbirdtestapp.photos.repo.local.PhotosLocalRepo;
import ru.nordpage.kingbirdtestapp.photos.repo.remote.PhotosRemoteRepo;

public class PhotosRepoImpl implements PhotosRepo {

    PhotosRemoteRepo remotePhotosRepo;
    PhotosLocalRepo localPhotosRepo;

    public PhotosRepoImpl(PhotosRemoteRepo remotePhotosRepo, PhotosLocalRepo localPhotosRepo) {
        this.remotePhotosRepo = remotePhotosRepo;
        this.localPhotosRepo = localPhotosRepo;
    }

    @Override
    public Observable<Photos> getAllPhotos() {

        return Observable.mergeDelayError(remotePhotosRepo.getAllPhotos().doOnNext(new Consumer<Photos>() {
            @Override
            public void accept(Photos photos) throws Exception {
                localPhotosRepo.addPhotos(photos);
                localPhotosRepo.addPhotoList(photos.getPhotos());
            }
        }).subscribeOn(Schedulers.io()),localPhotosRepo.getAllPhotos().subscribeOn(Schedulers.io()));
    }
}
