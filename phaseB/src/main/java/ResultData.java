/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kentr
 */
public class ResultData {
    String pcmid;
    double score;
    int rank;
    int topicNO;
    
    public ResultData( int t, String p, int r, double s){
        topicNO = t;
        pcmid = p;
        rank = r;
        score = s;
    }
}
