package ru.nordpage.kingbirdtestapp.photos.presenter;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ru.nordpage.kingbirdtestapp.photos.repo.PhotosRepo;
import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photos;

public class PhotosPresenterImpl extends PhotosPresenter{

    private PhotosRepo photosRepo;

    private Scheduler scheduler;

    private Disposable disposable;


    public PhotosPresenterImpl(PhotosRepo photosRepo, Scheduler scheduler) {
        this.photosRepo = photosRepo;
        this.scheduler = scheduler;
    }

    @Override
    public void getPhotos() {
        if (!isViewAttached())
            return;

        getView().showLoading();

        disposable = photosRepo.getAllPhotos().observeOn(scheduler).subscribeWith(new DisposableObserver<Photos>() {
            @Override
            public void onNext(Photos photos) {
                if (!isViewAttached())
                    return;

                getView().showPhotos(photos.getPhotos());
            }

            @Override
            public void onError(Throwable e) {
                if (!isViewAttached())
                    return;
                getView().showError(e.getLocalizedMessage());
                getView().hideLoading();

            }

            @Override
            public void onComplete() {
                getView().hideLoading();
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        disposable.dispose();
    }
}
