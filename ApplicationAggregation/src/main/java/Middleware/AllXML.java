package Middleware;

import MiddlewareService.AllXMLService;
import Wrapper.JDXML;
import WrapperService.JDService;
import XMLBean.All;
import XMLBean.ArrayAll;
import XMLParse.XMLParse;

import java.util.ArrayList;

/**
 * Created by mm on 2017/6/11.
 */
public class AllXML implements AllXMLService{
    @Override
    public ArrayList<All> getAllData(String movieName, String theater, String date) {
        ArrayList<All> result=new ArrayList<>();
        JDService jdService=new JDXML();
        ArrayAll jd=XMLParse.converyToJavaBean(jdService.getData(movieName,theater,date),ArrayAll.class);
        result.addAll(jd.getAlls());
        return result;
    }
}
