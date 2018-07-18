package fragments.homework.aca.com.viewmodelapp.fragments;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

import fragments.homework.aca.com.viewmodelapp.R;
import fragments.homework.aca.com.viewmodelapp.adapter.UsersAdapter;
import fragments.homework.aca.com.viewmodelapp.item.TodoItem;
import fragments.homework.aca.com.viewmodelapp.model.MyViewModel;

public class FirstFragment extends Fragment {

    UsersAdapter mAdapter;
    Button mButton;
    OnFragmentInteraction mListener;

    MyViewModel mModel;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        init(view);
    }

    public void init(View view){
        mButton = view.findViewById(R.id.add);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClickAdd();
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new UsersAdapter();
        recyclerView.setAdapter(mAdapter);

        getTodoItemFromViewModel();
    }

    public void getTodoItemFromViewModel(){
        mModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(MyViewModel.class);
        mModel.getItem().observe(this, new Observer<TodoItem>() {
            @Override
            public void onChanged(@Nullable TodoItem todoItem) {
                mAdapter.addTodoItem(todoItem);
                Toast.makeText(getContext(), Integer.toString(mAdapter.getItemCount()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void setOnFragmentListener(OnFragmentInteraction listener){
        mListener =listener;
    }

    public interface OnFragmentInteraction{
        void onClickAdd();

    }
}
