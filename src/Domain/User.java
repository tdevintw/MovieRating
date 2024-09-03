package Domain;

import Auth.Register;

public class User {
    private final int id;
    private String name;
    private String password;
    private int age;

    public User(String name, String password, int age) {
        this.id = (int) (Math.random() * 1000000000);
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (Register.isNameTrue(name)) {
            this.name = name;
            System.out.println("Name was updated");
            return true;
        } else {
            System.out.println("Name must be at least 3 character");
            return false;
        }
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        if (Register.isPasswordTrue(password)) {
            this.password = password;
            System.out.println("Password was updated");
            return true;
        } else {
            System.out.println("Password must be at least 6 character");
            return false;
        }
    }

    public int getAge() {
        return age;
    }

    public boolean setAge(int age) {
        if (Register.isAgeTrue(age)) {
            this.age = age;
            System.out.println("Password was updated");
            return true;
        } else {
            System.out.println("Password must be at least 6 character");
            return false;
        }
    }
}
