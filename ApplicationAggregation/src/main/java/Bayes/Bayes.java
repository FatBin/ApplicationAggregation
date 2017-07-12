package Bayes;

import Bean.Trainingset;
import DAO.TrainingSetDao;
import DaoImpl.TrainingSetDaoImpl;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by mm on 2017/7/10.
 */
public class Bayes {
    TrainingSetDao trainingSetDao=new TrainingSetDaoImpl();
    public ArrayList<String> getSimilarities(String input){
        ArrayList<String> result=new ArrayList<>();
        ArrayList<Trainingset> arrayList= (ArrayList<Trainingset>) trainingSetDao.getAll();
        int max=0;
        for(int i=0;i<arrayList.size();i++){
            if (arrayList.get(i).getType()>max){
                max=arrayList.get(i).getType();
            }
        }

        for(int i=0;i<=max;i++){
            ArrayList<Trainingset> toCheck=new ArrayList<>();
            for(int j=0;j<arrayList.size();j++){
                if (arrayList.get(j).getType()==i){
                    toCheck.add(arrayList.get(j));
                }
            }

            Boolean training=training(input,toCheck);
            if (training){
                for (int j=0;j<toCheck.size();j++){
                    if (!result.contains(toCheck.get(j).getName())){
                        result.add(toCheck.get(j).getName());
                    }
                }
            }
        }
        return result;
    }

    public ArrayList<Character> getCommon(ArrayList<String> arrayList){
        ArrayList<Character> result=new ArrayList<>();
        String father=arrayList.get(0);
        for (int i=0;i<father.length();i++) {
            char c=father.charAt(i);
            boolean allContains=true;
            for(int j=1;j<arrayList.size();j++){
                String temp=arrayList.get(j);
                if (!temp.contains(c+"")){
                    allContains=false;
                    break;
                }
            }
            if (allContains==true&&!result.contains(c)){
                result.add(c);
            }
        }
        return result;
    }

    public int getCoverage(String toTest,String base){
        double count=0;
        for(int i=0;i<toTest.length();i++){
            char c=toTest.charAt(i);
            if (base.contains(c+"")&&count!=toTest.length()){
                count++;
            }
        }
        int result=(int)count/toTest.length()*10;
        return result;
    }

    public Boolean training(String input,ArrayList<Trainingset> arrayList){
        ArrayList<String> names=new ArrayList<>();
        for (Trainingset trainingset:arrayList){
            names.add(trainingset.getName());
        }
        ArrayList<Character> common=getCommon(names);
        String commons="";
        for (Character c:common){
            commons=commons+c;
        }

        int isValid=0;
        int nonValid=0;
        int[] Iscount=new int[11];
        int[] Noncount=new int[11];
        for (int i=0;i<Iscount.length;i++){
            Iscount[i]=0;
        }
        for (int i=0;i<Noncount.length;i++){
            Noncount[i]=0;
        }

        for (int i=0;i<arrayList.size();i++){
            Trainingset trainingset=arrayList.get(i);
            int temp=getCoverage(trainingset.getName(),commons);
            if (trainingset.getIsValid()==0){
                isValid++;
                Iscount[temp]++;
            }
        }
        for (int i=0;i<arrayList.size();i++){
            Trainingset trainingset=arrayList.get(i);
            int temp=getCoverage(trainingset.getName(),commons);
            if (trainingset.getIsValid()==1){
                nonValid++;
                Noncount[temp]++;
            }
        }


        Boolean[] result=new Boolean[11];
        double checkValid=(double) isValid/(double)arrayList.size();
        double checkNonValid=(double) nonValid/(double)arrayList.size();
        for (int i=0;i<11;i++){
            if ((double)Iscount[i]* checkValid/(double)arrayList.size()>=
                    (double)Noncount[i]* checkNonValid/(double)arrayList.size()){
                result[i]=true;
            }else {
                result[i]=false;
            }
        }

        int checkInput=getCoverage(input,commons);
        return result[checkInput];
    }

//    public static void main(String[] args){
//        System.out.println("罗铉斌".substring(0,1));
//    }
}
