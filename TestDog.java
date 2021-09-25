import java.lang.*;
public class TestDog {
    public static void main(String[] args) {
        System.out.println("TEST#1 --> DOG");

        Dog d1 = new Dog("Ball", 12);
        Dog d2 = new Dog("Man", 999);

        System.out.println("d1" + " " + d1 + "\n");

        d1.setAge(d2.getAge() + 1);
        d1.setName((d2.getName()) + "TS");

        System.out.println("d1" + " " + d1);
        System.out.println("d2" + " " + d2);

        System.out.println("\n\nTEST#2 --> Ball");

        Ball b1 = new Ball("footBall", 12);
        Ball b2 = new Ball("voleyball", 999);

        System.out.println("b1" + "  " +b1 + "\n");

        b1.setRadius(b2.getRadius() + 1);
        b1.setType((b2.getType()) + "TS");

        System.out.println("b1" + "  " +b1);
        System.out.println("b2" + "  " +b2);

        System.out.println("\n\nTEST#3 --> Book");

        Book boo1 = new Book("footBall", "Dog", "RTU");
        Book boo2 = new Book("voleyball", "Cat", "MIREA");

        System.out.println("boo1" + "  " + boo1 + "\n");

        boo1.setTitle(boo2.getTitle() + "1");
        boo1.setAuthor((boo2.getAuthor()) + "Cow");
        boo1.setPublisher(boo1.getPublisher() + " " + boo2.getPublisher());

        System.out.println("boo1" + "  " + boo1);
        System.out.println("boo2" + "  " + boo2);
    }
}

class Dog
{
    private String name;
    private  int age;

    public Dog(String Name, int Age)
    {
        name = Name;
        age = Age;
    }
    public String getName()
    {
        return this.name;
    };

    public  int getAge()
    {
        return this.age;
    };

    public void setName(String someName)
    {
        this.name = someName;
    };

    public void setAge(int someAge)
    {
        this.age = someAge;
    };

    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Ball
{
    private int radius;
    private String type;

    public Ball(String Type, int Radius)
    {
        type = Type;
        radius = Radius;
    }
    public String getType()
    {
        return this.type;
    };

    public  int getRadius()
    {
        return this.radius;
    };

    public void setType(String someType)
    {
        this.type = someType;
    };

    public void setRadius(int someRadius)
    {
        this.radius = someRadius;
    };

    public String toString() {
        return "Ball{" +
                "radius=" + radius +
                ", type='" + type + '\'' +
                '}';
    }
}

class Book
{
    private String title;
    private String author;
    private String publisher;

    public Book(String Title, String Author, String Publisher)
    {
        title = Title;
        author = Author;
        publisher = Publisher;
    }
    public String getTitle()
    {
        return this.title;
    };

    public String getAuthor()
    {
        return this.author;
    };

    public String getPublisher()
    {
        return this.publisher;
    }

    public void setAuthor(String someAuthor)
    {
        this.author = someAuthor;
    };

    public void setTitle(String someTitle)
    {
        this.title = someTitle;
    };

    public void setPublisher(String somePublisher)
    {
        this.publisher = somePublisher;
    }

    public String toString() {
        return "Book{" +
                "title='" + this.title + '\'' +
                ", author='" + this.author + '\'' +
                ", publisher='" + this.publisher + '\'' +
                '}';
    }
}

