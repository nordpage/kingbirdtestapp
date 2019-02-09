package ru.nordpage.kingbirdtestapp.photos.presenter;

import ru.nordpage.kingbirdtestapp.base.presenter.BasePresenter;
import ru.nordpage.kingbirdtestapp.photos.view.PhotosView;

public abstract class PhotosPresenter extends BasePresenter<PhotosView> {
    public abstract void getPhotos();
}
