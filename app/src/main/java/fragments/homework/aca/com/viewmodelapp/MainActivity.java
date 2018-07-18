package fragments.homework.aca.com.viewmodelapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fragments.homework.aca.com.viewmodelapp.fragments.FirstFragment;
import fragments.homework.aca.com.viewmodelapp.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity implements SecondFragment.OnFragmentInteraction{

    FragmentManager mManager;
    FragmentTransaction mTransaction;

    FirstFragment mFirstFragment = new FirstFragment();
    SecondFragment mSecondFragment = new SecondFragment();

    FirstFragment.OnFragmentInteraction mOnFragmentInteraction =
            new FirstFragment.OnFragmentInteraction() {
                @Override
                public void onClickAdd() {
                    mManager = getSupportFragmentManager();
                    mTransaction = mManager.beginTransaction();
                    mSecondFragment = new SecondFragment();

                    mTransaction.replace(R.id.frame, mSecondFragment, "Second");
                    mTransaction.addToBackStack("Second");
                }
            };

//    SecondFragment.OnFragmentInteraction mOnSecondFragmentInteraction =
//            new SecondFragment.OnFragmentInteraction() {
//                @Override
//                public void onClickSave() {
//                    getSupportFragmentManager().popBackStack();
//                }
//            };


    @Override
    public void onClickSave() {
        getSupportFragmentManager().popBackStack();

//        mManager = getSupportFragmentManager();
//        mTransaction = mManager.beginTransaction();
//
//        mTransaction.replace(R.id.frame, new SecondFragment(), "Second");
//        mTransaction.addToBackStack("Second");
//        mTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init(){
        mManager = getSupportFragmentManager();
        mTransaction = mManager.beginTransaction();

        mFirstFragment.setOnFragmentListener(mOnFragmentInteraction);
//        mSecondFragment.setButtonListener(mOnSecondFragmentInteraction);
        mFirstFragment = new FirstFragment();

        mSecondFragment.setButtonListener(this);
        mTransaction.add(R.id.frame, mFirstFragment, "First");
        mTransaction.commit();
    }
}
