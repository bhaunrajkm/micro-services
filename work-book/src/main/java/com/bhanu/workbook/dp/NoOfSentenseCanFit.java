package com.bhanu.workbook.dp;

public class NoOfSentenseCanFit {
  public static void main(String[] args) {
    String[] s = {"a", "bcd", "e"};
    System.out.println(noOfSentenceCanFit(s, 3, 6));
  }

  public static int noOfSentenceCanFit(String[] sentence, int row, int col) {
    int count = 0;
    int wordsCount = 0;

    for (int i = 0; i < row; i++) {
      int colCount = 0;

      while (colCount < col
          && sentence[wordsCount].length() <= (col - colCount)) {
        colCount += sentence[wordsCount].length() + 1;
        int tempWordCount = (wordsCount + 1);
        if (tempWordCount >= sentence.length) {
          count++;
        }
        //wordsCount = tempWordCount % (sentence.length - 1);
        wordsCount = tempWordCount % (sentence.length);
      }
    }

    return count;
  }
}
