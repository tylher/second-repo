package statistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TestCalculator {

	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		StatCalculator SC=new StatCalculator();
		String[][]sample=StatCalculator.getDataSet();
		double[]samplescore=SC.getScores(sample);
		 StatCalculator.resultFormat(SC, samplescore, sample);
	}
		
}
