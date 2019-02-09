package ru.nordpage.kingbirdtestapp.photos.repo.remote;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photos;

public interface APIService {
    @GET("photos?api_key=DEMO_KEY")
    Observable<Photos> getPhotos(@Query("sol") int sol, @Query("camera") String camera);
}
