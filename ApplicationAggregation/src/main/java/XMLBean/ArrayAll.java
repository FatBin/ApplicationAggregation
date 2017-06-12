package XMLBean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by mm on 2017/6/12.
 */
@XmlRootElement
public class ArrayAll {
    ArrayList<All> alls;
    @XmlElement
    public ArrayList<All> getAlls() {
        return alls;
    }

    public void setAlls(ArrayList<All> alls) {
        this.alls = alls;
    }
}
