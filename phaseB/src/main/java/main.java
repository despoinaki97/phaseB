
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class main {
    public static void main(String[ ] args) {
        
        Map<Integer,ArrayList<ResultData>> res = ReadResults();
        HashMap<Integer,ArrayList<RelevantData>> rel = ReadRelevants();
        System.out.println("Bpref: "+String.format("%.20f",Metrics.bpref(ReadResultsRanked(), rel)));
        System.out.println("Avep:  "+String.format("%.20f", Metrics.avep(ReadResultsRanked(), rel)));
        System.out.println("NDCG:  "+String.format("%.20f", Metrics.ndcg(ReadResultsRanked(), rel)));

    }
    
    static Map<Integer,ArrayList<ResultData>> ReadResults(){
        String folderPath = "../../Results/";
        Map<Integer,ArrayList<ResultData>> res = new HashMap<>();
        
        try{
            BufferedReader bR = new BufferedReader(new FileReader(folderPath+"Results.txt"));
            String line="";
            
            while((line=bR.readLine())!=null){
                StringTokenizer sTokenize = new StringTokenizer(line," ");
                int token = Integer.parseInt(sTokenize.nextToken());
                sTokenize.nextToken();
                String token1 = sTokenize.nextToken();
                int token2 = Integer.parseInt(sTokenize.nextToken());
                
                Double token3 = Double.parseDouble(sTokenize.nextToken());
                ResultData DE = new ResultData(token,token1,token2,token3);
                if(res.containsKey(token)){
                    res.get(token).add(DE);
                }else{
                    ArrayList<ResultData> aL = new ArrayList<>();
                    aL.add(DE);
                    res.put(token, aL);
                }
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
        return res;
    }
    static ArrayList<ResultData> ReadResultsRanked(){
        String folderPath = "../../Results/";
        
        ArrayList<ResultData> res = new ArrayList<>();
        
        try{
            BufferedReader bR = new BufferedReader(new FileReader(folderPath+"Results.txt"));
            String line="";
            
            while((line=bR.readLine())!=null){
                StringTokenizer sTokenize = new StringTokenizer(line," ");
                int token = Integer.parseInt(sTokenize.nextToken());
                sTokenize.nextToken();
                String token1 = sTokenize.nextToken();
                int token2 = Integer.parseInt(sTokenize.nextToken());
                
                Double token3 = Double.parseDouble(sTokenize.nextToken());
                ResultData DE = new ResultData(token,token1,token2,token3);
                res.add(DE);
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
        return res;
    }
    
     static HashMap<Integer,ArrayList<RelevantData>> ReadRelevants(){
        String folderPath = "../../Resources/";
        HashMap<Integer,ArrayList<RelevantData>> res = new HashMap<>();
        
        try{
            BufferedReader bR = new BufferedReader(new FileReader(folderPath+"qrels.txt"));
            String line="";
            
            while((line=bR.readLine())!=null){
                StringTokenizer sTokenize = new StringTokenizer(line," \t");
                int token = Integer.parseInt(sTokenize.nextToken());
                sTokenize.nextToken();
                String token1 = sTokenize.nextToken();
                int token2 = Integer.parseInt(sTokenize.nextToken());
                RelevantData rD = new RelevantData(token1,token2);
                
                if(res.containsKey(token)){
                    res.get(token).add(rD);
                }else{
                    ArrayList<RelevantData> aL = new ArrayList<>();
                    aL.add(rD);
                    res.put(token, aL);
                }
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
        return res;
    }
}


