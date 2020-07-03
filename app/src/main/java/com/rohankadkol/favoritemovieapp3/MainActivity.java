package com.rohankadkol.favoritemovieapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView mTvTitle;
    ImageView mIvMovie;
    Button mBtnNextMovie;

    Movie[] mMovies = {new Movie("Pink Panther (2006)", R.drawable.pink_panther),
            new Movie("Pink Panther 2 (2009)", R.drawable.pink_panther_2)};
    int currentMovie = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvTitle = findViewById(R.id.tv_title);
        mIvMovie = findViewById(R.id.iv_movie);
        mBtnNextMovie = findViewById(R.id.btn_next_movie);

        loadMovie(0);
    }

    public void nextMovieClicked(View view) {
        loadNextMovie();
    }

    private void loadNextMovie() {
        if (currentMovie == mMovies.length - 1) {
            currentMovie = 0;
        } else {
            currentMovie++;
        }

        loadMovie(currentMovie);
    }

    private void loadMovie(int movieIndex) {
        mTvTitle.setText(mMovies[movieIndex].title);
        mIvMovie.setImageResource(mMovies[movieIndex].picture);
    }

    class Movie {
        private String title;
        private int picture;

        Movie(String title, int picture) {
            this.title = title;
            this.picture = picture;
        }
    }
}
