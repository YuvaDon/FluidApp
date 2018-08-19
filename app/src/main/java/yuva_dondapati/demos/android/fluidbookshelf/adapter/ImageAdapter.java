package yuva_dondapati.demos.android.fluidbookshelf.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

import yuva_dondapati.demos.android.fluidbookshelf.R;


public class ImageAdapter extends BaseAdapter{
    private Context mContext;
    List<Integer> imageList;

    // Constructor
    public ImageAdapter(Context c,  List<Integer> imageList){
        mContext = c;
        this.imageList  = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imageList.get(position));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(280, 300));
        return imageView;
    }

}
