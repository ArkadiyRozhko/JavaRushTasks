package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        List<Word> words= detectAllWords(crossword, "home", "same");
        for (Word word:words
             ) {
            System.out.println(word);
        }

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> wordList=new ArrayList<>();
        for (String word:words
             ) {
            for (int i = 0; i <crossword.length ; i++) {
                for (int j = 0; j <crossword[i].length ; j++) {
                    char ch=(char) crossword[i][j];
                    char firstch=word.charAt(0);
                    if ( ch== firstch) {
                        if (j+word.length()-1<crossword[i].length){
                            char [] tmp=new char[word.length()];
                            for (int k = 0; k <tmp.length; k++) {
                                tmp[k]=(char) crossword[i][j+k];
                            }
                            String wordfrommass=new String(tmp);
                            if (word.equals(wordfrommass)){
                                Word word1=new Word(wordfrommass);
                                word1.setStartPoint(j,i);
                                word1.setEndPoint(j+tmp.length-1,i);
                                wordList.add(word1);
                            }

                        }
                        if (j-word.length()+1>=0){
                            char [] tmp=new char[word.length()];
                            for (int k = 0; k <tmp.length; k++) {
                                tmp[k]=(char) crossword[i][j-k];
                            }
                            String wordfrommass=new String(tmp);
                            if (word.equals(wordfrommass)){
                                Word word1=new Word(wordfrommass);
                                word1.setStartPoint(j,i);
                                word1.setEndPoint(j-tmp.length+1,i);
                                wordList.add(word1);
                            }

                        }
                        if (i+word.length()-1<crossword.length){
                            char [] tmp=new char[word.length()];
                            for (int k = 0; k <tmp.length; k++) {
                                tmp[k]=(char) crossword[i+k][j];
                            }
                            String wordfrommass=new String(tmp);
                            if (word.equals(wordfrommass)){
                                Word word1=new Word(wordfrommass);
                                word1.setStartPoint(j,i);
                                word1.setEndPoint(j,i+tmp.length-1);
                                wordList.add(word1);
                            }

                        }
                        if (i-word.length()+1>=0){
                            char [] tmp=new char[word.length()];
                            for (int k = 0; k <tmp.length; k++) {
                                tmp[k]=(char) crossword[i-k][j];
                            }
                            String wordfrommass=new String(tmp);
                            if (word.equals(wordfrommass)){
                                Word word1=new Word(wordfrommass);
                                word1.setStartPoint(j,i);
                                word1.setEndPoint(j,i-tmp.length+1);
                                wordList.add(word1);
                            }

                        }
                        if ((j+word.length()-1<crossword[i].length) && (i-word.length()+1>=0)){
                            char [] tmp=new char[word.length()];
                            for (int k = 0; k <tmp.length; k++) {
                                tmp[k]=(char) crossword[i-k][j+k];
                            }
                            String wordfrommass=new String(tmp);
                            if (word.equals(wordfrommass)){
                                Word word1=new Word(wordfrommass);
                                word1.setStartPoint(j,i);
                                word1.setEndPoint(j+tmp.length-1,i-tmp.length+1);
                                wordList.add(word1);
                            }

                        }
                        if ((j+word.length()-1<crossword[i].length) && (i+word.length()-1<crossword.length)){
                            char [] tmp=new char[word.length()];
                            for (int k = 0; k <tmp.length; k++) {
                                tmp[k]=(char) crossword[i+k][j+k];
                            }
                            String wordfrommass=new String(tmp);
                            if (word.equals(wordfrommass)){
                                Word word1=new Word(wordfrommass);
                                word1.setStartPoint(j,i);
                                word1.setEndPoint(j+tmp.length-1,i+tmp.length-1);
                                wordList.add(word1);
                            }

                        }
                        if ((j-word.length()+1>=0) && (i+word.length()-1<crossword.length)){
                            char [] tmp=new char[word.length()];
                            for (int k = 0; k <tmp.length; k++) {
                                tmp[k]=(char) crossword[i+k][j-k];
                            }
                            String wordfrommass=new String(tmp);
                            if (word.equals(wordfrommass)){
                                Word word1=new Word(wordfrommass);
                                word1.setStartPoint(j,i);
                                word1.setEndPoint(j-tmp.length+1,i+tmp.length-1);
                                wordList.add(word1);
                            }

                        }
                        if ((j-word.length()+1>=0) && (i-word.length()+1>=0)){
                            char [] tmp=new char[word.length()];
                            for (int k = 0; k <tmp.length; k++) {
                                tmp[k]=(char) crossword[i-k][j-k];
                            }
                            String wordfrommass=new String(tmp);
                            if (word.equals(wordfrommass)){
                                Word word1=new Word(wordfrommass);
                                word1.setStartPoint(j,i);
                                word1.setEndPoint(j-tmp.length+1,i-tmp.length+1);
                                wordList.add(word1);
                            }

                        }

                    }
                }

            }
        }


        return wordList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
