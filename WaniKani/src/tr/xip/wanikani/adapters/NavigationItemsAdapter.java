package tr.xip.wanikani.adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tr.xip.wanikani.R;
import tr.xip.wanikani.items.NavigationItems;

/**
 * Created by xihsa_000 on 3/14/14.
 */
public class NavigationItemsAdapter extends ArrayAdapter<NavigationItems.NavItem> {

    private ArrayList<NavigationItems.NavItem> items;

    private int selectedItem;

    public NavigationItemsAdapter(Context context, int textViewResourceId,
                                  ArrayList<NavigationItems.NavItem> objects) {
        super(context, textViewResourceId, objects);
        this.items = objects;
    }

    public void selectItem(int n) {
        this.selectedItem = n;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_navigation, null);
        }

        NavigationItems.NavItem item = items.get(position);

        if (item != null) {
            ImageView mIcon = (ImageView) v.findViewById(R.id.navigation_item_icon);
            TextView mTitle = (TextView) v.findViewById(R.id.navigation_item_title);

            mIcon.setImageResource(item.icon);
            mTitle.setText(item.title);

            if (position == selectedItem) {
                mTitle.setTextColor(getContext().getResources().getColor(R.color.apptheme_main));
                mIcon.setColorFilter(getContext().getResources().getColor(R.color.apptheme_main), PorterDuff.Mode.SRC_ATOP);
            } else {
                mTitle.setTextColor(getContext().getResources().getColor(R.color.text_gray));
                mIcon.setColorFilter(getContext().getResources().getColor(R.color.text_gray), PorterDuff.Mode.SRC_ATOP);
            }
        }

        return v;
    }


}
