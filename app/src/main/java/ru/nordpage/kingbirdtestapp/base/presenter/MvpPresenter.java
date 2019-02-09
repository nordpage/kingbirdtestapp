package ru.nordpage.kingbirdtestapp.base.presenter;

import ru.nordpage.kingbirdtestapp.base.view.MvpView;

public interface MvpPresenter<P extends MvpView> {

    void onAttach(P view);

    void onResume();

    void onDetach();

}