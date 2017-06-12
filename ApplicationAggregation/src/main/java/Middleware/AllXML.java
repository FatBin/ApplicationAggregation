package Middleware;

import MiddlewareService.AllXMLService;
import Wrapper.JDXML;
import Wrapper.NuoMiXML;
import WrapperService.JDService;
import WrapperService.NuoMiService;
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
        
//        result.addAll(getAllDataNuoMi(movieName, theater, date));
        return result;
    }
    
    
    
    
    
    private ArrayList<All> getAllDataNuoMi(String movieName, String theater, String date) {
    	ArrayList<All> result=new ArrayList<>();
    	
    	NuoMiService service=new NuoMiXML();
    	
    	 ArrayAll jd=XMLParse.converyToJavaBean(service.getData(movieName,theater,date),ArrayAll.class);
         result.addAll(jd.getAlls());
         return result;
    	
    }
    
    
    public static void main(String[] args) {
		AllXML xml=new AllXML();
		ArrayList<All> list=xml.getAllDataNuoMi("新木乃伊", "新街口", "1");
		
		System.out.println(list.size());
		for (All all : list) {
			System.out.println(all.getPrice());
		}
	}
}
