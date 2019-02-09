package ru.nordpage.kingbirdtestapp.photos.repo.local;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photo;
import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photos;


public class PhotosLocalRepoImpl implements PhotosLocalRepo {

    private PhotosDao photosDao;


    public PhotosLocalRepoImpl(PhotosDao photosDao) {
        this.photosDao = photosDao;
    }

    @Override
    public Observable<Photos> getAllPhotos() {
        return Observable.fromCallable(new Callable<Photos>() {
            @Override
            public Photos call() throws NullPointerException {
                return photosDao.getAll();
            }
        });
    }

    @Override
    public void addPhotos(Photos photos) {
        photosDao.insertAll(photos);
    }

    @Override
    public void addPhotoList(List<Photo> photos) {
        if (photosDao.getAllPhotos() == null || photosDao.getAllPhotos().size() == 0) {
            photosDao.insertPhotos(photos);
        }
    }

}
