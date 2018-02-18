package com.devbruno.fastshop.presentation.drawer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.devbruno.fastshop.R;
import com.devbruno.fastshop.infraestruture.AccountUtils;
import com.devbruno.fastshop.infraestruture.Constants;
import com.devbruno.fastshop.presentation.BaseFragment;
import com.devbruno.fastshop.presentation.home.HomeFragment;

/**
 * Created by bsilvabr on 12/02/2018.
 */
public class DrawerFragment extends BaseFragment implements DrawerContract.View {

    private RecyclerView recyclerViewGenre;
    private LinearLayout layoutMain;
    private TextView username;
    private ImageButton imageButtonClose;
    public View view;
    static DrawerFragment drawerFragment;
    private DrawerContract.Presenter mPresenter;

    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_genres, vg, false);

        init();
        setListeners();
        return view;
    }

    public static DrawerFragment newInstance(CharSequence screenTitle) {
        DrawerFragment fragment = new DrawerFragment();

        Bundle args = new Bundle();
        args.putCharSequence(Constants.ARGUMENT_TITLE, screenTitle);

        fragment.setArguments(args);
        drawerFragment = fragment;
        return fragment;
    }


    private void init() {
        username = (TextView) view.findViewById(R.id.textViewUserName);
        recyclerViewGenre = (RecyclerView) view.findViewById(R.id.genre_recycler_view);
        layoutMain = (LinearLayout) view.findViewById(R.id.laymain);
        imageButtonClose = (ImageButton) view.findViewById(R.id.imageButton);
        animateButton();
        username.setText(AccountUtils.getGoogleUsername(getActivity()));
        mPresenter.getGenres();

    }

    private void animateButton(){
        imageButtonClose.clearAnimation();
        imageButtonClose.startAnimation(AnimationUtils.loadAnimation(imageButtonClose.getContext(), R.anim.slide_in_left));
    }
    @Override
    public void onResume() {
        super.onResume();
    }

    private void setListeners() {
        imageButtonClose.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageButton:
                case R.id.laymain:
                    mPresenter.onBackPressed();
                    HomeFragment.getHomeFragment().closeGenresDrawer();
                    break;
                default:
                    return;
            }

        }
    };

    @Override
    public void setPresenter(@NonNull DrawerContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void alertErroApi() {
        Toast.makeText(getActivity(), Constants.ERROR_API, Toast.LENGTH_LONG).show();
    }

    @Override
    public void alertErroUI() {
        Toast.makeText(getActivity(), Constants.ERROR_UI, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerViewGenre;
    }
}

