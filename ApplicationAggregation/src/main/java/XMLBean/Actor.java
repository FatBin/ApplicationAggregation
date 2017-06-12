package XMLBean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by mm on 2017/6/12.
 */
@XmlRootElement
public class Actor {
    private ArrayList<String> names=new ArrayList<>();

    @XmlElement
    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }
}
