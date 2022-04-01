package Amoozesh;

public class Faculty
{
    private String name;

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected Faculty(String name) {
        this.name = name;
    }
}
