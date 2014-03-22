package es.appmaster.dinamicfragment.app.repository;

import android.content.Context;

import java.util.ArrayList;

import es.appmaster.dinamicfragment.app.R;
import es.appmaster.dinamicfragment.app.model.Student;

/**
 * Students repository
 *
 * @author manolovn
 */
public class StudenRepository {

    private static StudenRepository INSTANCE = null;
    private Context context;

    private ArrayList<Student> students;

    private StudenRepository(Context context) {
        this.context = context;
    }

    public static StudenRepository getInstance(Context context) {
        if(INSTANCE == null) {
            INSTANCE = new StudenRepository(context);
        }
        return INSTANCE;
    }

    public ArrayList<Student> findAll() {
        students = new ArrayList<Student>();
        for ( int i = 0; i < 100 ; i++ ) {
            students.add(new Student(R.drawable.ic_launcher, "Student n." + i, "Murcia"));
        }
        students.add(new Student(R.drawable.ic_launcher, "Last Student", "New York"));

        return students;
    }

}
