package ru.nordpage.kingbirdtestapp.photos.adapter;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.nordpage.kingbirdtestapp.R;
import ru.nordpage.kingbirdtestapp.photos.repo.dto.Photo;

public class ImageAdapter extends PagedListAdapter<Photo, ImageAdapter.ViewHolder> {

    Context ctx;
    ImageViewListener listener;

    public ImageAdapter(Context ctx) {
        super(Photo.DIFF_CALLBACK);
        this.ctx = ctx;
    }

    public void setOnImageViewListener(ImageViewListener listener){
        if (listener!= null){
            this.listener = listener;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.init(getItem(i));
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img) ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        private void init(Photo photo) {
            if (photo != null) {
                Picasso.with(ctx)
                        .load(photo.getImgSrc())
                        .into(img);
                img.setOnClickListener(v -> {
                    if (listener != null) {
                        listener.onZoom(true, photo.getImgSrc());
                    }
                });
                img.setOnLongClickListener(l -> {
                    if (listener != null) {
                        notifyItemRemoved(getAdapterPosition());
                        listener.onDelete(photo);
                        return true;
                    }
                    return false;
                });
            }
        }
    }
}
