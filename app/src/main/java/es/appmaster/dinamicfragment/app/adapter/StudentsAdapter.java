package es.appmaster.dinamicfragment.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.appmaster.dinamicfragment.app.R;
import es.appmaster.dinamicfragment.app.model.Student;

/**
 * Students adapter
 *
 * @author manolovn
 */
public class StudentsAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Student> students;

    private LayoutInflater inflater;

    public StudentsAdapter(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.student_item, null);
            holder = new ViewHolder();
            holder.studentPhoto = (ImageView) convertView.findViewById(R.id.student_photo);
            holder.studentName = (TextView) convertView.findViewById(R.id.student_name);
            holder.studentCity = (TextView) convertView.findViewById(R.id.student_city);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Student student = students.get(position);
        holder.studentPhoto.setImageResource(student.getPhoto());
        holder.studentName.setText(student.getName());
        holder.studentCity.setText(student.getCity());

        return convertView;
    }

    class ViewHolder {
        ImageView studentPhoto;
        TextView studentName;
        TextView studentCity;
    }

}
