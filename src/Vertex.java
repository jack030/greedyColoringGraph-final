import java.util.Vector;

public class Vertex {
    private int name,
        color;
    //hamsaye ha
    Vector<Integer> adjacencyVertices ;

    public Vertex(int name) {
        this.name = name;
        adjacencyVertices = new Vector<>();
        color = -1;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void addByName(int name) {

    }

    @Override
    public String toString() {
        return ""+(name+1);
    }
}
