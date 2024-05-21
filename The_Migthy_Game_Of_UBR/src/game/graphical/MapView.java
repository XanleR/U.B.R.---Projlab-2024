package game.graphical;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MapView extends JPanel {



    private List<ElementView> elementViewList;

    public MapView(List<ElementView> elementViewList) {
        this.elementViewList = elementViewList;
    }

    public void draw(){
        removeAll();
        for(ElementView elementView : elementViewList){
            elementView.drawImage();
        }
    }

    public void addViews(List<ElementView> elementViewList){
        this.elementViewList.addAll(elementViewList);
    }

    public void initPanel(){

    }
}
