
import java.util.ArrayList;
import java.util.HashMap;


public class Metrics {
    
    public static double bpref(ArrayList<ResultData> res, HashMap<Integer,ArrayList<RelevantData>> rel){
        int relevant=0;
        int nonRelevant=0;
        double sum=0;
        int currentNonRV=0;
        ArrayList<RelevantData> vRel=null;
        ArrayList<ResultData> vRes=null;
        for(Integer i: rel.keySet()){
            vRel=rel.get(i);
            for(int k=0;k<vRel.size();k++){
                if(vRel.get(k).grade>0)
                    relevant++;
                else
                    nonRelevant++;
            }
        }
        
        for(int i=0;i<res.size();i++){
            ArrayList<RelevantData> temp = rel.get(res.get(i).topicNO);
            for(int j=0;j<temp.size();j++){
                if(temp.get(j).pcmid.equals(res.get(i).pcmid)){
                    double precision=0;
                    if(temp.get(j).grade==0){
                        currentNonRV++;
                    }else{
                        precision = (double) currentNonRV/Math.min(relevant, nonRelevant);
                        sum += 1- precision;
                    }
                }
            }
        }
        return sum/relevant;
    }
    
    public static double avep(ArrayList<ResultData> res, HashMap<Integer, ArrayList<RelevantData>> rel) {
        double avep=0;
        double ratio=0;
        double fileratio=0;
        int files=0;
        int reli = 0;
        int relevant = 0;

        ArrayList<RelevantData> vRel = null;
        ArrayList<ResultData> vRes = null;
        for (Integer i : rel.keySet()) {
            vRel = rel.get(i);
            for (int k = 0; k < vRel.size(); k++) {
                if (vRel.get(k).grade > 0) {
                    relevant++;
                }
            }
        }
        for (int i = 0; i < res.size(); i++) {
            ArrayList<RelevantData> temp = rel.get(res.get(i).topicNO);
            for (int j = 0; j < temp.size(); j++) {
                if (temp.get(j).pcmid.equals(res.get(i).pcmid)) {
                    double precision = 0;
                    if (temp.get(j).grade > 0) {
                        fileratio = reli / files;
                        ratio = ratio + fileratio;
                        reli++;
                    }
                    files++;
                }
            }

        }
        avep = ratio / reli;
        return avep;
    
    }
    
    
    public static double ndcg(){
        double dcg=0;
        double ndcg=0;
        
        return ndcg;
    }
}
