package com.example.android.newsapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(@NonNull Context context, List<News> newsList) {
        super(context, 0, newsList);
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        TextView section = listItemView.findViewById(R.id.section);
        TextView title = listItemView.findViewById(R.id.title);
        TextView date = listItemView.findViewById(R.id.date);
        TextView author = listItemView.findViewById(R.id.author);
        ImageView image = listItemView.findViewById(R.id.image);

        // Create a News object to assign values (taken from News' get methods) to the views in the layout
        News currentNews = getItem(position);

        String authorString = getContext().getString(R.string.by) + currentNews.getAuthor();
        String sectionString = getContext().getString(R.string.section) + currentNews.getSection();
        String dateString = currentNews.getDate().substring(0, 10);
        Bitmap imageBitmap = currentNews.getImage();

        // Make sure to assign a value to the fields if there is no info to display
        if (currentNews.getAuthor().isEmpty()) {
            authorString = getContext().getString(R.string.no_author);
        }
        if (currentNews.getDate().isEmpty()) {
            authorString = getContext().getString(R.string.no_date);
        }
        if (imageBitmap == null) {
            image.setVisibility(View.GONE);
        } else {
            image.setImageBitmap(imageBitmap);
        }
        title.setText(currentNews.getTitle());
        section.setText(sectionString);
        author.setText(authorString);
        date.setText(dateString);

        return listItemView;

    }
}
