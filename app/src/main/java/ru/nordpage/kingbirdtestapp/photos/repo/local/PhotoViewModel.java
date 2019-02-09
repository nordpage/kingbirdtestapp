package ru.nordpage.kingbirdtestapp.photos.repo.local;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import ru.nordpage.kingbirdtestapp.base.App;
import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photo;

public class PhotoViewModel  extends ViewModel {

    private PhotosDao dao;
    private LiveData<PagedList<Photo>> results;

    public PhotoViewModel(){
        dao = App.getDb().getPhotosDao();
        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder()).setEnablePlaceholders(true)
                        .setPrefetchDistance(10)
                        .setPageSize(20).build();

        results = (new LivePagedListBuilder(dao.getPhotos(),
                pagedListConfig))
                .build();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public LiveData<PagedList<Photo>> getResults() {
        return results;
    }
}
