package skillUP_class;

public class Tiger {

    private String name;
    private int age;
    private String sex;

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getSex() {
        return this.sex;
    }

    public static class Builder {
        private String name;
        private int age;
        private String sex;

        public Builder(String name) {
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public Tiger build(){
            return new Tiger(this);
        }

    }

    private Tiger(Builder builder) {
        name = builder.name;
        age = builder.age;
        sex = builder.sex;
    }


}
