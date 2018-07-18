package fragments.homework.aca.com.viewmodelapp.fragments;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import fragments.homework.aca.com.viewmodelapp.R;
import fragments.homework.aca.com.viewmodelapp.item.TodoItem;
import fragments.homework.aca.com.viewmodelapp.model.MyViewModel;

public class SecondFragment extends Fragment {

    EditText mName, mSurname, mAge;

    Button mButton;
    TodoItem mTodoItem;
    OnFragmentInteraction mListener;
    MyViewModel mModel;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        init(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mListener = (OnFragmentInteraction) context;
        } catch (ClassCastException e){

        }
    }

    private void init(View view){
        mName = view.findViewById(R.id.edit_name);
        mSurname = view.findViewById(R.id.edit_surname);
        mAge = view.findViewById(R.id.edit_age);

        mButton = view.findViewById(R.id.save);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
                mModel.setItem(getTodoItem());

                mListener.onClickSave();
                //getFragmentManager().popBackStack();
//                getFragmentManager().beginTransaction().replace(R.id.frame, new FirstFragment(), "First").commit();
            }
        });
    }


    public TodoItem getTodoItem(){
        String name = mName.getText().toString();
        String surname = mSurname.getText().toString();
        String age = mAge.getText().toString();

        return new TodoItem(name, surname, Integer.parseInt(age));
    }

    public void setButtonListener(OnFragmentInteraction listener){
        mListener = listener;
    }

    public interface OnFragmentInteraction{
        void onClickSave();
    }
}
