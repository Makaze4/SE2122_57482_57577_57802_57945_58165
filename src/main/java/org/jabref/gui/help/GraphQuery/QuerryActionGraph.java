package org.jabref.gui.help.GraphQuery;


import javafx.util.Pair;
import org.antlr.v4.runtime.misc.Triple;
import org.jabref.gui.actions.SimpleCommand;
import org.jabref.gui.search.RebuildFulltextSearchIndexAction;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class QuerryActionGraph extends SimpleCommand {

    public static final int MAX_RGB = 2147483647;

    RebuildFulltextSearchIndexAction.GetCurrentLibraryTab currentLibraryTab;

    public QuerryActionGraph(RebuildFulltextSearchIndexAction.GetCurrentLibraryTab aux) {
        currentLibraryTab = aux;
    }

    @Override
    public void execute() {
        List<Node> nList = new ArrayList<>();
        JFrame f = new JFrame();
        GraphDraw draw = new GraphDraw();

        List<Color> colorList = new ArrayList<>();
        colorList.add(new Color(0, 0, 100));
        colorList.add(new Color(0, 100, 0));
        colorList.add(new Color(100, 0, 0));
        colorList.add(Color.black);



        Map<Integer, Triple<String, String, List<Integer>>> authorMap = currentLibraryTab.get().getDatabase().getRelations();

        for(int i = 1; i<authorMap.size()+1; i++){
            int j = i-1;
            int x = (j % 10) ;
            int y = (j / 10) ;

            Random r = new Random();
            int rX = r.nextInt(60)-30;
            int rY = r.nextInt(60)-30;

            x = x*175;
            y = y*200;

            Node n = new Node();

            n.setDisplayName(authorMap.get(i).b);
            Color c;
            if(!authorMap.get(i).a.equals("")){
                int colorRGB = authorMap.get(i).a.hashCode();
                colorRGB = resizeColorRGB(colorRGB);
                c = new Color(colorRGB);
            }
            else{
                c = Color.black;
            }

            n.setColor(c);
            n.setPosition(new Node.Position(x+rX+50, y+rY+50));
            nList.add(n);
            draw.addNode(n);
        }

        for(int i = 1; i<authorMap.size()+1; i++){

            for(Integer integer: authorMap.get(i).c){

               Edge e = new Edge(nList.get(i-1), nList.get(integer-1));
               Random r = new Random();
               int rC = r.nextInt(colorList.size());
               e.setColor(colorList.get(rC));
               e.setFocussed(true);
               draw.addEdge(e);
            }
        }

        //displaying graph
        draw.setSize(1280, 720);
        draw.setVisible(true);
        f.add(draw);
        f.setSize(1280, 720);
        f.setVisible(true);
        f.toFront();
        f.setTitle("Author's relations graph");
    }

    private int resizeColorRGB(int colorRGB){
        if(colorRGB>MAX_RGB){
            return  resizeColorRGB(colorRGB/2);
        }
        return colorRGB;
    }
}
