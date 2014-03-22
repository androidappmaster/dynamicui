package es.appmaster.dinamicfragment.app.model;

/**
 * Student model class
 *
 * @author manolovn
 */
public class Student {

    private int photo;
    private String name;
    private String city;

    public Student(int photo, String name, String city) {
        this.photo = photo;
        this.name = name;
        this.city = city;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
