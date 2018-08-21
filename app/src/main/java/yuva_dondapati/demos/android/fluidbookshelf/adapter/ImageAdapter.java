package yuva_dondapati.demos.android.fluidbookshelf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import yuva_dondapati.demos.android.fluidbookshelf.MainActivity;
import yuva_dondapati.demos.android.fluidbookshelf.R;
import yuva_dondapati.demos.android.fluidbookshelf.model.ImageModel;


public class ImageAdapter extends ArrayAdapter<ImageModel>{
    private Context mContext;
    List<ImageModel> imageList;

    public ImageAdapter(Context mContext,  List<ImageModel> imageList){
        super(mContext, R.layout.grid_item, imageList);
        this.mContext = mContext;
        this.imageList  = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public ImageModel getItem(int position) {
        return imageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View imageView = convertView;
        ViewHolder holder;

        if (imageView == null) {
            LayoutInflater inflater = ((MainActivity) mContext).getLayoutInflater();
            imageView = inflater.inflate(R.layout.grid_item, viewGroup, false);
            holder = new ViewHolder();
            holder.imageTitle = imageView.findViewById(R.id.grid_item_title);
            holder.image = imageView.findViewById(R.id.grid_item_image);
            holder.date = imageView.findViewById(R.id.grid_item_date);
            imageView.setTag(holder);
        } else {
            holder = (ViewHolder) imageView.getTag();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm:ss");
        Date cal = Calendar.getInstance().getTime();
        ImageModel item = imageList.get(position);
        holder.imageTitle.setText(item.getTitle());
        holder.image.setImageResource(item.getImageUrl());
        holder.date.setVisibility(View.VISIBLE);
        holder.date.setText(dateFormat.format(cal));
        return imageView;
    }

    private static class ViewHolder {
        TextView imageTitle;
        ImageView image;
        TextView date;
    }

}
