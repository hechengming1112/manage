package admin.com.student.test.testArrayList;

public class Person {
    private String id;

    public Person(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println(this);
        Person p = (Person) obj;
        return this.id.equals(p.id);
    }
}
