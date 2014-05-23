package user;

public interface Profile {
    //  wheel revolutions per minute
    void set_username(String newValue);

    void set_birthday(String newValue);

    void set_education(String increment);

    void set_work_history(String decrement);
}
