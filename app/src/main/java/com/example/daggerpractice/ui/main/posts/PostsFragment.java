package com.example.daggerpractice.ui.main.posts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daggerpractice.R;
import com.example.daggerpractice.models.Post;
import com.example.daggerpractice.ui.main.Resource;
import com.example.daggerpractice.util.VerticalSpacingItemDecoration;
import com.example.daggerpractice.viewmodels.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class PostsFragment extends DaggerFragment {

    private static final String TAG = "PostsFragment";

    private PostsViewModel postsViewModel;
    private RecyclerView recyclerView;

    @Inject
    PostRecyclerAdapter postRecyclerAdapter;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view);

        postsViewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(PostsViewModel.class);

        initRecyclerView();

        subscribeObservers();
    }

    private void subscribeObservers() {
        postsViewModel.observePosts().removeObservers(getViewLifecycleOwner());
        postsViewModel.observePosts().observe(getViewLifecycleOwner(), new Observer<Resource<List<Post>>>() {
            @Override
            public void onChanged(Resource<List<Post>> listResource) {
                if (listResource != null) {
                    switch (listResource.status) {
                        case LOADING: {
                            Log.d(TAG, "onChanged: LOADING...");
                            break;
                        }
                        case SUCCESS: {
                            Log.d(TAG, "onChanged: GOT POSTS...");
                            postRecyclerAdapter.setPosts(listResource.data);
                            break;
                        }
                        case ERROR: {
                            Log.d(TAG, "onChanged: ERROR..." + listResource.message);
                            break;
                        }
                    }
                }
            }
        });
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        VerticalSpacingItemDecoration itemDecoration= new VerticalSpacingItemDecoration(35);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(postRecyclerAdapter);
    }
}
