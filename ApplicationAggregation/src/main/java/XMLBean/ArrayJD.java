package XMLBean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by mm on 2017/6/11.
 */
@XmlRootElement
public class ArrayJD {
    ArrayList<JD> jds;
    @XmlElement
    public ArrayList<JD> getJds() {
        return jds;
    }

    public void setJds(ArrayList<JD> jds) {
        this.jds = jds;
    }
}
