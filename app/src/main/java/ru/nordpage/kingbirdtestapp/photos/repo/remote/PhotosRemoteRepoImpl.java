package ru.nordpage.kingbirdtestapp.photos.repo.remote;

import io.reactivex.Observable;
import ru.nordpage.kingbirdtestapp.base.remote.BaseRemote;
import ru.nordpage.kingbirdtestapp.base.remote.RemoteConst;
import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photos;

public class PhotosRemoteRepoImpl extends BaseRemote implements PhotosRemoteRepo {

    @Override
    public Observable<Photos> getAllPhotos() {
        return create(APIService.class, RemoteConst.API_BASE_URL).getPhotos(RemoteConst.SOL,RemoteConst.CAMERA);
    }
}
