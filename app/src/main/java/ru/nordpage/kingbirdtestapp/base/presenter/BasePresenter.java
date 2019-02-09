package ru.nordpage.kingbirdtestapp.base.presenter;

import java.lang.ref.WeakReference;

import ru.nordpage.kingbirdtestapp.base.view.MvpView;

public abstract class BasePresenter<P extends MvpView> implements MvpPresenter<P> {

    private WeakReference<P> viewRef;

    @Override
    public void onAttach(P view) {
        viewRef = new WeakReference<>(view);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDetach() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }

    }

    protected boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    protected P getView() {
        return viewRef.get();
    }

}
