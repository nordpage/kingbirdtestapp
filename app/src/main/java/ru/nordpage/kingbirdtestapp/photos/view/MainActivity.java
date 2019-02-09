package ru.nordpage.kingbirdtestapp.photos.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.nordpage.kingbirdtestapp.R;
import ru.nordpage.kingbirdtestapp.base.App;
import ru.nordpage.kingbirdtestapp.base.view.BaseActivity;
import ru.nordpage.kingbirdtestapp.photos.adapter.ImageAdapter;
import ru.nordpage.kingbirdtestapp.photos.adapter.ImageViewListener;
import ru.nordpage.kingbirdtestapp.photos.presenter.PhotosPresenter;
import ru.nordpage.kingbirdtestapp.photos.presenter.PhotosPresenterImpl;
import ru.nordpage.kingbirdtestapp.photos.repo.PhotosRepo;
import ru.nordpage.kingbirdtestapp.photos.repo.PhotosRepoImpl;
import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photo;
import ru.nordpage.kingbirdtestapp.photos.repo.local.AppDatabase;
import ru.nordpage.kingbirdtestapp.photos.repo.local.PhotoViewModel;
import ru.nordpage.kingbirdtestapp.photos.repo.local.PhotosLocalRepo;
import ru.nordpage.kingbirdtestapp.photos.repo.local.PhotosLocalRepoImpl;
import ru.nordpage.kingbirdtestapp.photos.repo.remote.PhotosRemoteRepo;
import ru.nordpage.kingbirdtestapp.photos.repo.remote.PhotosRemoteRepoImpl;

import static ru.nordpage.kingbirdtestapp.base.remote.RemoteConst.COLS;

public class MainActivity extends BaseActivity<PhotosPresenter> implements PhotosView {

    @BindView(R.id.list)
    RecyclerView mList;
    @BindView(R.id.prog)
    ProgressBar mProg;
    @BindView(R.id.error)
    TextView mError;
    @BindView(R.id.viewImg)
    ImageView viewImg;

    protected Handler handler;

    List<Photo> phts;
    AppDatabase db;



    @Override
    protected PhotosPresenter createPresenter() {

        PhotosRemoteRepo remotePhotoRepo = new PhotosRemoteRepoImpl();

        db = App.getDb();

        PhotosLocalRepo localPhotosRepo = new PhotosLocalRepoImpl(db.getPhotosDao());

        PhotosRepo photosRepo = new PhotosRepoImpl(remotePhotoRepo, localPhotosRepo);

        return new PhotosPresenterImpl(photosRepo, AndroidSchedulers.mainThread());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        handler = new Handler();
        getPresenter().getPhotos();

    }

    @Override
    public void showPhotos(List<Photo> photos) {
        mError.setVisibility(View.GONE);

        mList.setLayoutManager(new GridLayoutManager(this, COLS));

        PhotoViewModel viewModel = ViewModelProviders.of(this).get(PhotoViewModel.class);


        ImageAdapter adapter = new ImageAdapter(this);
        viewModel.getResults().observe(this, pagedList -> {
            adapter.submitList(pagedList);
        });
        mList.setAdapter(adapter);

        mList.setVisibility(View.VISIBLE);
        adapter.setOnImageViewListener(new ImageViewListener() {
            @Override
            public void onZoom(boolean state, String url) {
                if (state) {
                    viewImg.setVisibility(View.VISIBLE);
                    mList.setVisibility(View.INVISIBLE);
                    Picasso.with(MainActivity.this)
                            .load(url)
                            .into(viewImg);
                    viewImg.setOnClickListener(v -> {
                        mList.setVisibility(View.VISIBLE);
                        viewImg.setVisibility(View.INVISIBLE);
                    });
                }
            }

            @Override
            public void onDelete(Photo photo) {
                db.getPhotosDao().deletePhoto(photo);
                Snackbar.make(mList,String.format("Photo with id %s was deleted.",String.valueOf(photo.getId())),Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void showLoading() {
        mProg.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProg.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        mError.setText(error);
        mError.setVisibility(View.VISIBLE);
    }
}
