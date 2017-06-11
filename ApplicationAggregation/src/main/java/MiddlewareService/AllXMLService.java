package MiddlewareService;

import XMLBean.All;

import java.util.ArrayList;

/**
 * Created by mm on 2017/6/11.
 */
public interface AllXMLService {
    public ArrayList<All> getAllData(String movieName, String theater, String date);
}
