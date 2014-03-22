package es.appmaster.dinamicfragment.app.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import es.appmaster.dinamicfragment.app.R;
import es.appmaster.dinamicfragment.app.adapter.StudentsAdapter;
import es.appmaster.dinamicfragment.app.repository.StudenRepository;

/**
 * Students list fragment
 *
 * @author manolovn
 */
public class StudentsListFragment extends ListFragment {

    OnStudentSelectedListener listener;

    public interface OnStudentSelectedListener {
        public void onStudentSelected(int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        listener = (OnStudentSelectedListener) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new StudentsAdapter(getActivity(), StudenRepository.getInstance(getActivity()).findAll()));
    }

    @Override
    public void onStart() {
        super.onStart();

        getActivity().setTitle(getString(R.string.app_name));
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        listener.onStudentSelected(position);

        getListView().setItemChecked(position, true);
    }

}
