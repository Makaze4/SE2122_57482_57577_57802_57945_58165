package org.jabref.gui.help.GraphQuery;


import javafx.util.Pair;
import org.antlr.v4.runtime.misc.Triple;
import org.jabref.gui.actions.SimpleCommand;
import org.jabref.gui.search.RebuildFulltextSearchIndexAction;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class QuerryActionGraph extends SimpleCommand {

    RebuildFulltextSearchIndexAction.GetCurrentLibraryTab currentLibraryTab;

    public QuerryActionGraph(RebuildFulltextSearchIndexAction.GetCurrentLibraryTab aux) {
        currentLibraryTab = aux;
    }

    @Override
    public void execute() {
        List<Node> nList = new ArrayList<>();
        JFrame f = new JFrame();
        GraphDraw draw = new GraphDraw();

        Map<Integer, Triple<String, String, List<Integer>>> authorMap = currentLibraryTab.get().getDatabase().getRelations();

        for(int i = 1; i<authorMap.size()+1; i++){
            int j = i-1;
            int x = (j % 10) +1;
            int y = (j / 10) +1;

            Random r = new Random();
            int rX = r.nextInt(60)-30;
            int rY = r.nextInt(60)-30;

            x = x*175;
            y = y*200;

            Node n = new Node();

            n.setDisplayName(authorMap.get(i).b);
            Color c;
            if(!authorMap.get(i).a.equals("")){
                c = new Color(authorMap.get(i).a.hashCode());//TODO verificar melhor
            }
            else{
                c = Color.black;
            }

            n.setColor(c);
            n.setPosition(new Node.Position(x+rX, y+rY));
            nList.add(n);
            draw.addNode(n);
        }

        for(int i = 1; i<authorMap.size()+1; i++){

            for(Integer integer: authorMap.get(i).c){

               Edge e = new Edge(nList.get(i-1), nList.get(integer-1));
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
        //TODO titulo pagina e outras coisas
        //f.setBackground(Color.black);

        /*JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        f.setContentPane(pane);*/
    }
}
