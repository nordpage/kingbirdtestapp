package ru.nordpage.kingbirdtestapp.photos.view;

import java.util.List;

import ru.nordpage.kingbirdtestapp.base.view.MvpView;
import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photo;

public interface PhotosView extends MvpView {
    void showPhotos(List<Photo> photos);
    void showLoading();
    void hideLoading();
    void showError(String error);
}
