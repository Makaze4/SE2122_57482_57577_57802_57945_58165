package org.jabref.gui.help;


import javafx.util.Pair;
import org.jabref.gui.actions.SimpleCommand;
import org.jabref.gui.search.RebuildFulltextSearchIndexAction;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuerryActionGraph extends SimpleCommand {

    RebuildFulltextSearchIndexAction.GetCurrentLibraryTab currentLibraryTab;

    public QuerryActionGraph(RebuildFulltextSearchIndexAction.GetCurrentLibraryTab aux) {
        currentLibraryTab = aux;
    }

    class GraphDraw extends JFrame {
        int width;
        int height;

        ArrayList<Node> nodes;
        ArrayList<edge> edges;

        public GraphDraw() { //Constructor
            nodes = new ArrayList<Node>();
            edges = new ArrayList<edge>();
            width = 30;
            height = 30;
        }

        public GraphDraw(String name) { //Construct with label
            this.setTitle(name);
            nodes = new ArrayList<Node>();
            edges = new ArrayList<edge>();
            width = 30;
            height = 30;
        }

        class Node {
            int x, y;
            String name;

            public Node(String myName, int myX, int myY) {
                x = myX;
                y = myY;
                name = myName;
            }
        }

        class edge {
            int i,j;

            public edge(int ii, int jj) {
                i = ii;
                j = jj;
            }
        }

        public void addNode(String name, int x, int y) {
            //add a node at pixel (x,y)
            nodes.add(new Node(name,x,y));
            this.repaint();
        }
        public void addEdge(int i, int j) {
            //add an edge between nodes i and j
            edges.add(new edge(i,j));
            this.repaint();
        }

        public void paint(Graphics g) { // draw the nodes and edges
            FontMetrics f = g.getFontMetrics();
            int nodeHeight = Math.max(height, f.getHeight());

            g.setColor(Color.black);
            for (edge e : edges) {
                g.drawLine(nodes.get(e.i).x, nodes.get(e.i).y,
                        nodes.get(e.j).x, nodes.get(e.j).y);
            }

            for (Node n : nodes) {
                int nodeWidth = Math.max(width, f.stringWidth(n.name)+width/2);
                g.setColor(Color.white);
                g.fillOval(n.x-nodeWidth/2, n.y-nodeHeight/2,
                        nodeWidth, nodeHeight);
                g.setColor(Color.black);
                g.drawOval(n.x-nodeWidth/2, n.y-nodeHeight/2,
                        nodeWidth, nodeHeight);

                g.drawString(n.name, n.x-f.stringWidth(n.name)/2,
                        n.y+f.getHeight()/2);
            }
        }
    }

    @Override
    public void execute() {
        GraphDraw frame = new GraphDraw("Author's relations graph");

        frame.setSize(1280,720);

        frame.setVisible(true);
        frame.toFront();

        Map<Integer, Pair<String, List<Integer>>> authorMap = currentLibraryTab.get().getDatabase().getRelations();

        for(int i = 1; i<authorMap.size()+1; i++){
            int j = i-1;
            int x = (j % 8) +1;
            int y = (j / 8) +1;

            x = x*150;
            y = y*150;
            frame.addNode(authorMap.get(i).getKey(), x,y);
            System.out.println("x: " + x);
            System.out.println("y: " + y);
        }

        for(int i = 1; i<authorMap.size()+1; i++){
            if(i == 41){
                System.out.println("yau");
            }
            for(Integer integer: authorMap.get(i).getValue()){
                System.out.println(i + " - " + integer);
                frame.addEdge(i-1,integer-1);
            }
        }

    }


}
