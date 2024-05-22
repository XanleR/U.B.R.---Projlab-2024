package game.graphical;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MapView extends JPanel {



    private List<ElementView> elementViewList;

    public MapView(List<ElementView> elementViewList) {
        this.elementViewList = elementViewList;
    }

    public MapView() {
        this.elementViewList = new ArrayList<>();
    }

    public void draw(){
        removeAll();

        int loopLimit = elementViewList.size();

        for(int i=0;i<loopLimit; i++){
            elementViewList.get(i).drawImage();
            loopLimit = elementViewList.size();
        }
    }

    public void addViews(List<ElementView> elementViewList){
        this.elementViewList.addAll(elementViewList);
    }

    public void removeElementView(ElementView elementView){
        elementViewList.remove(elementView);
    }

    public void addViews(ElementView elementView){
        elementViewList.add(elementView);
    }

    public void initPanel(){

    }
}
