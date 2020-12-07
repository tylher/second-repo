package statistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class StatCalculator {
 public String name;
 public double score;
 double[]scoreSheet;
  
 public StatCalculator() {}
  public StatCalculator(String name,double score) {
	  this.name=name;
	  this.score=score;
  }
  public void setName(String name) {
	  this.name=name;
  }
  public void setScore(double score) {
	  this.score=score;
  }
  
  
  public void setScoreSheet(double[]score) {
	  this.scoreSheet=score;
  }
  

  public double getMeanScore(double[]param) {
	  double sum=0;
	  for(double score:param) {
		  sum+=score;
	  }
	  return sum/param.length;
	  
  }
 

  public double getMedianScore(double[]param) {
	  Arrays.sort(param);
	  double median;
	  int medianpoint=param.length%2;
	  if(medianpoint==0) {
		 median=(param[(param.length/2)-2]+param[(param.length/2)-1])/2;
	  }
	  else {
		  median=param[(int) Math.ceil(param.length/2)-1];
	  }
	  return median;
  }
 

  public double getMaxScore(double[]param) {
	  Arrays.sort(param);
	  return param[param.length-1];
	  
  }
 

  public double getMinScore(double[]param) {
	  Arrays.sort(param);
	  return param[0];
	  
  }
  
 
 public double[] getScores(String[][]param) {
	  String[]row;
	  double[]scores =new double[100];
	  for(int i=0;i<param.length;i++) {
		   row=param[i];
		  for(int j=0;j<row.length;j++) {
			  scores[i]=Double.parseDouble(row[row.length-1]);
		  }
		  
	  }
	  return scores;
  }
  

 public String getMAxScoreStudent(String[][]param,double[]row) {
	  String max = "";
	  for(int i=0;i<param.length;i++) {
		  for(int j=0;j<param[i].length;j++) {
			  if(new StatCalculator().getMaxScore(row)==Double.parseDouble(param[i][1])) {
				  max= param[i][0];
			  }
		  }
	  }
	  return max;
	  
  }
  
  
 public String getMinScoreStudent(String[][]param,double[]row) {
	  String min = "";
	  for(int i=0;i<param.length;i++) {
		  for(int j=0;j<param[i].length;j++) {
			  if(new StatCalculator().getMinScore(row)==Double.parseDouble(param[i][1])) {
				  min= param[i][0];
			  }
		  }
	  }
	  return min;
	  
  }
  
  
  public static String[][] getDataSet() {
		System.out.println("please enter file name or path");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		File file=new File(s);
		BufferedReader in = null;
		String line = "";
		String[][]data = new String[100][2];
		String row[];
		try {
			 in=new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			line=in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0;
		while(line!=null) {
			row=line.split(":");
			
			  if(i<100) {
			  data[i]=row;} 
			 
			/* System.out.println(Arrays.deepToString(row)); */
			try {
				line=in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		return data;
		}
      

  public static void resultFormat(StatCalculator s,double[]param,String[][]params) {
        	System.out.println("Mean Score: "+s.getMeanScore(param)+"\n"+"Median Score: "+s.getMedianScore(param)+"\n"+"Highest Score: "+s.getMaxScore(param)+"\n"+
        "Student with highest score: "+s.getMAxScoreStudent(params, param)+"\n"+"Lowest Score: "+s.getMinScore(param)+"\n"+"Student with the lowest score: "
        	+s.getMinScoreStudent(params, param));
        }
  
}
