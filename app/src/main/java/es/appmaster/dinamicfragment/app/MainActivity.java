package es.appmaster.dinamicfragment.app;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import es.appmaster.dinamicfragment.app.fragment.DetailFragment;
import es.appmaster.dinamicfragment.app.fragment.StudentsListFragment;


public class MainActivity extends ActionBarActivity implements StudentsListFragment.OnStudentSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.container) != null && savedInstanceState == null) {

            StudentsListFragment studentsListFragment = new StudentsListFragment();
            studentsListFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, studentsListFragment)
                    .commit();
        }
    }

    @Override
    public void onStudentSelected(int position) {

        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);

        Bundle args = new Bundle();
        args.putInt("POSITION", position);

        if ( detailFragment != null && detailFragment.isInLayout() ) {

            detailFragment.updateDetailView(position);

        } else {

            detailFragment = new DetailFragment();
            detailFragment.setArguments(args);

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
            fragmentTransaction.replace(R.id.container, detailFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

}
