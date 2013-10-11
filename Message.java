/**
 * The Arecibo message was broadcast into space a single time (not repeated) via frequency modulated radio waves
 * at a ceremony to mark the remodeling of the Arecibo radio telescope on 16 November 1974. It was aimed at
 * the globular star cluster M13 some 25,000 light years away because M13 was a large and close collection of stars
 * that was available in the sky at the time and place of the ceremony. The message consisted of 1679 binary
 * digits, approximately 210 bytes, transmitted at a frequency of 2380 MHz and modulated by shifting the frequency
 * by 10 Hz, with a power of 1000 kW. The "ones" and "zeros" were transmitted by frequency shifting at the rate of
 * 10 bits per second. The total broadcast was less than three minutes.
 *
 * The cardinality of 1679 was chosen because it is a semiprime (the product of two prime numbers), to be arranged
 * rectangularly as 73 rows by 23 columns. The alternative arrangement, 23 rows by 73 columns, produces jumbled
 * nonsense. The message forms the image shown on the right, or its inverse, when translated into graphics
 * characters and spaces.
 *
 * Dr. Frank Drake, then at Cornell University and creator of the famous Drake equation, wrote the message, with
 * help from Carl Sagan, among others. The message consists of seven parts that encode the following:
 * The numbers one (1) through ten (10)
 * The atomic numbers of the elements hydrogen, carbon, nitrogen, oxygen, and phosphorus, which make up
 * dezoxyribonucleic acid (DNA)
 * The formulas for the sugars and bases in the nucleotides of DNA
 * The number of nucleotides in DNA, and a graphic of the double helix structure of DNA
 * A graphic figure of a human, the dimension (physical height) of an average man, and the human population of
 * Earth
 * A graphic of the Solar System
 * A graphic of the Arecibo radio telescope and the dimension (the physical diameter) of the transmitting antenna
 * dish
 * 
 * */

package Arecibo;

import java.io.*;
import java.util.StringTokenizer;

public class Message {
	
	private static String inputString; 
	private static char[] inputCharArray; 
				
	private static void beolvas() { 
		
		try { 
			BufferedReader br = new BufferedReader(new FileReader("be.txt"));
			try {
				StringTokenizer st = new StringTokenizer(br.readLine());
				inputString = st.nextToken();// be.txt tartalma 1679 számjegy 1db String-ben
			    inputCharArray = inputString.toCharArray();// be.txt tartalma 1679 számjegy 1db char tömbben
			}
			finally {
				br.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}// beolvas metodus
	
	private static void charCsere() {
		for(int i=0;i<inputCharArray.length;i++) {
			if(inputCharArray[i] == '0') inputCharArray[i] = '.';
			else inputCharArray[i] = 'O';			 
		}
	}// charCsere metodus
	
	private static void kiIrat() throws IOException {
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ki.txt")));
		for(int i = 0;i < inputCharArray.length; i++) {
			pw.print((i+1)%23==0 ? inputCharArray[i] + "\n" : inputCharArray[i] + " ");			
		}		
		pw.close();		
	}// kiIrat metodus
	
	public static void main(String[] args) throws Exception {
		beolvas();
		charCsere();
		kiIrat();
	}// main metodus
	
}// CLASS
