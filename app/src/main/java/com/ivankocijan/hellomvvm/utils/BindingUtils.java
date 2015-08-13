package com.ivankocijan.hellomvvm.utils;

import com.bumptech.glide.Glide;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * @author Koc
 *         ivan.kocijan@infinum.hr
 * @since 13.08.15.
 */
public class BindingUtils {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

}
