public class Human {

    private String name;
    private int age;

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private Human(HumanBuilder humanBuilder){
        this.name = humanBuilder.name;
        this.age = humanBuilder.age;
    }



    public static class HumanBuilder{

        private String name;
        private int age;

        public Human build(){
            return new Human(this);
        }

        public HumanBuilder setName(String name){
            this.name=name;
            return this;
        }

        public HumanBuilder Age(int age){
            this.age=age;
            return this;
        }

    }
}
