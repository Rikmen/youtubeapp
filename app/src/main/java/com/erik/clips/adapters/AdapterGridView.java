package com.erik.clips.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.erik.clips.R;
import com.erik.clips.utils.GridViewItem;

import java.util.ArrayList;

/**
 * Created by 1 on 07.02.2017.
 */

public class AdapterGridView extends ArrayAdapter<GridViewItem> {
    Context mContext;
    int resourceId;
    ArrayList<GridViewItem> data = new ArrayList<GridViewItem>();

    public AdapterGridView(Context context, int layoutResourceId, ArrayList<GridViewItem> data) {
        super(context, layoutResourceId, data);
        this.mContext = context;
        this.resourceId = layoutResourceId;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        ViewHolder holder = null;

        if (itemView == null) {
            final LayoutInflater layoutInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = layoutInflater.inflate(resourceId, parent, false);

            holder = new ViewHolder();
            holder.imgItem = (ImageView) itemView.findViewById(R.id.thumbnails);
            holder.txtItem = (TextView) itemView.findViewById(R.id.name);
            itemView.setTag(holder);
        } else {
            holder = (ViewHolder) itemView.getTag();
        }

        GridViewItem item = getItem(position);
        holder.imgItem.setImageDrawable(item.getImage());
        holder.txtItem.setText(item.getTitle());

        return itemView;
    }

    static class ViewHolder {
        ImageView imgItem;
        TextView txtItem;
    }

}
