import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Euler18Test {

	@Test
	void testFindMaximum() {
		int numbers [][]= {
				{75},
				{95,64},
				{17,47,82},
				{18,35,87,10},
				{20,04,82,47,65},
				{19,01,23,75,03,34},
				{88,02,77,73,07,63,67},
				{99,65,04,28,06,16,70,92},
				{41,41,26,56,83,40,80,70,33},
				{41,48,72,33,37,32,37,16,94,29},
				{53,71,44,65,25,43,91,52,97,51,14},
				{70,11,33,28,77,73,17,78,39,68,17,57},
				{91,71,52,38,17,41,91,43,58,50,27,29,48},
				{63,66,4,68,89,53,67,30,73,16,69,87,40,31},
				{4,62,98,27,23,9,70,98,73,93,38,53,60,4,23}
		};
		//First let's test some numbers from the pyramid to see if it's build correctly
		assertEquals(95,numbers[1][0]);
		assertEquals(4,numbers[7][2]);
		assertEquals(53, numbers[14][11]);
		
		//Let's test the for loop
		for(int i = 15-1; i>-1; i--) {
			for (int j = 1; j<numbers[i].length; j++) {
				if (numbers[i][j]>numbers[i][j-1]) {
					numbers[i-1][j-1]=numbers[i-1][j-1] + numbers[i][j];
				}
				else {
					numbers[i-1][j-1]=numbers[i-1][j-1]+numbers[i][j-1];
				}
			}
		}
		assertEquals(63+62, numbers[13][0]);
		assertEquals(98+66, numbers[13][1]);
		assertEquals(98+66+91, numbers[12][0]);
		
		//The maximum for a single number is 99, this means the maximum sum must be under 15*99
		assertTrue(numbers[0][0]<15*99);
	}

}
