package builder;

import java.time.LocalDate;

public class Person {

    public enum Sex {FEMALE, MALE};
    private Sex gender;
    private String firstName;
    private String lastName;
    private String profession; //optional
    private LocalDate birthDay; //optional

    //field declarations as on previous slide
    public static class Builder {
        private Sex gender;
        private String firstName;
        private String lastName;
        private String profession;
        private LocalDate birthDay;

        public Builder(String firstName, String lastName, Sex gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
        }

        public Builder profession(String profession) {
            this.profession = profession;
            return this;
        }

        public Builder birthday(LocalDate birthday) {
            this.birthDay = birthday;
            return this;
        }
        public Person build() {
            //validate builder state prior to creation
            return new Person(this);
        }
    }

    private Person(Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
        profession = builder.profession;
        birthDay = builder.birthDay;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + ", profession: " + this.profession + " birthday: " + this.birthDay.toString();
    }
}
