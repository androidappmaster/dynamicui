package es.appmaster.dinamicfragment.app.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import es.appmaster.dinamicfragment.app.R;
import es.appmaster.dinamicfragment.app.model.Student;
import es.appmaster.dinamicfragment.app.repository.StudenRepository;

/**
 * Detail fragment
 *
 * @author manolovn
 */
public class DetailFragment extends Fragment {

    int currentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if ( savedInstanceState != null ) {
            currentPosition = savedInstanceState.getInt("current_position");
        }

        return inflater.inflate(R.layout.student_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if ( args != null ) {
            updateDetailView(args.getInt("POSITION"));
        } else if ( currentPosition != -1 ) {
            updateDetailView(currentPosition);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("current_position", currentPosition);
    }

    public void updateDetailView(int position) {

        Student student = StudenRepository.getInstance(getActivity()).findAll().get(position);

        getActivity().setTitle(student.getName());

        TextView name = (TextView) getView().findViewById(R.id.student_name);
        TextView city = (TextView) getView().findViewById(R.id.student_city);

        name.setText(student.getName());
        city.setText(student.getCity());

        currentPosition = position;
    }

}
