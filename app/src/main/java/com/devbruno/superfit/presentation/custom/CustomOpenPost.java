package com.devbruno.superfit.presentation.custom;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.devbruno.superfit.R;
import com.devbruno.superfit.infraestruture.Constants;
import com.devbruno.superfit.infraestruture.ImageUtil.ImageDownloadAndCache;
import com.devbruno.superfit.model.Movie;

/**
 * Created by bsilvabr on 10/02/2018.
 */


public class CustomOpenPost extends Dialog implements View.OnClickListener {
    private Button buttonPay;
    private LinearLayout relativeBody;
    private LinearLayout linearLayout;
    private Activity activity;
    private TextView title;
    ImageView foto;
    Movie movies;

    public CustomOpenPost(Activity activity) {
        super(activity);
        // TODO Auto-generated constructor stub
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.post_dialog);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        init();
        setListeners();
        animAfterViews();
    }

    private void init() {
        //     buttonPay = (Button) findViewById(R.id.button2);
        relativeBody = (LinearLayout) findViewById(R.id.relative_body);
        // linearLayout = (LinearLayout) findViewById(R.id.linearbody);
        // userName = (TextView) findViewById(R.id.textViewUserName);
        title = (TextView) findViewById(R.id.dtitle);
        foto = findViewById(R.id.imageViewLogo2);


    }

    public void loadImageFromURL(ImageView imageView, String URL) {
        new ImageDownloadAndCache.DownloadImageTask(imageView,
                activity).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                Constants.BASE_POSTER_URL.concat(URL));

    }

    private void setListeners() {
        relativeBody.setOnClickListener(this);
    }

    private void animAfterViews() {
        title.setText(movies.getTitle());
        loadImageFromURL(foto, movies.getPosterPath());
        relativeBody.startAnimation(AnimationUtils.loadAnimation(relativeBody.getContext(), R.anim.post_opened));
    }

    private void close() {
        dismiss();
    }

    private void animateClose() {
        close();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
            case R.id.relative_body:
            case R.id.linearbody:
                animateClose();
                break;
            default:
                break;
        }
        close();
    }

    public void setPost(Movie post) {
        this.movies = post;
    }
}