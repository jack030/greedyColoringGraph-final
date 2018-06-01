import java.io.*;
import java.util.Vector;

import static java.lang.Integer.parseInt;

public class Graph {
    private Vertex vertices[];// = new Vector<>();
    private Vector<Edge> edges;

    public Graph() throws IOException {
        try {
            this.makeGraphFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void makeGraphFromFile() throws IOException {
//      reading the file : set path
        File f = new File("src\\testFiles\\mtest2.txt");

//      detect line and numbers
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;

//      find biggest Vertex name!
        int max = 0;
        while ((line = br.readLine()) != null) {
            String[] splitedVertices = line.split("\\s+");
            if (parseInt(splitedVertices[0]) > max) max = parseInt(splitedVertices[0]);
            if (parseInt(splitedVertices[1]) > max) max = parseInt(splitedVertices[1]);
        }
        //System.out.println(max);

//       fill vertexes adjacency!
        vertices = new Vertex[max];
        for (int i = 0; i < max; i++)
            vertices[i] = new Vertex(i);

        br.close();
        br = new BufferedReader(new FileReader(f));
        while ((line = br.readLine()) != null) {

            String[] splitedVertices = line.split("\\s+");

            //ras haye mojood dar har line hamsaye y ham and

            vertices[(parseInt(splitedVertices[0])) - 1].adjacencyVertices.add(parseInt(splitedVertices[1]));
            vertices[(parseInt(splitedVertices[1])) - 1].adjacencyVertices.add(parseInt(splitedVertices[0]));
        }

        //chap e mojaverat haa

        for (int i = 0; i < max; i++) {

            System.out.println(i + 1);
            for (int v1 : vertices[i].adjacencyVertices) {
                System.out.print(v1 + " - ");
            }
            System.out.println();
            System.out.println("-----------------------------");
        }


        paint();
    }

    private void paint() {
        for (int i = 0; i < vertices.length; i++) {
            //rang ha ra bara ye kamtarin moghayese mikonim!
            int maxColor = -1;
            int minColor = -1;
            if (i == vertices.length-1) minColor++;maxColor++;
            int resultColor = 0;
//            System.out.println(i);
            //dar hamsaye haye har node negah mikonim!
            for (int j = 0; j < vertices[i].adjacencyVertices.size(); j++) {
                if (vertices[vertices[i].adjacencyVertices.elementAt(j)-1].getColor() > maxColor)
                    maxColor = vertices[vertices[i].adjacencyVertices.elementAt(j)-1].getColor();
            if (vertices[vertices[i].adjacencyVertices.elementAt(j)-1].getColor() < minColor)
                minColor = vertices[vertices[i].adjacencyVertices.elementAt(j)-1].getColor();
            }

            for (int j = minColor; j <= maxColor; j++) {
                boolean find = false;
                for (int v : vertices[i].adjacencyVertices ){
                    if(vertices[v-1].getColor() == minColor && !find){
                        minColor++;
                        find = true;
                       break;
                    }
                }

            }
            resultColor = minColor;
            vertices[i].setColor(resultColor);
            System.out.println((i+1)+" : "+resultColor);

        }
    }
}


