package com.facebook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
This problem was asked by Facebook.

Given a stream of elements too large to store in memory, pick a random element from the stream with uniform probability.
 */
public class UniformProbabilityPick {
    class Index {
        int pos;
        int len;

        Index(int pos, int len) {
            this.pos = pos;
            this.len = len;
        }
    }

    HashMap<Integer, HashMap<Integer, Index>> indexes = new HashMap<>();

    int index = 0;

    int maxElementsPerFile = 2;

    List<String> filePathes = new ArrayList<>();

    String FILEPATH = "/Users/apple/Documents/GitHub/AmazonTest";

    String FILENAME_TEMPLATE = "file%d.txt";


    public void add(String word) {
        int fileIndex = 0;
        if (filePathes.size() > 0) {
            fileIndex = index / maxElementsPerFile;
        }

        if (!indexes.containsKey(fileIndex)) {
            indexes.put(fileIndex, new HashMap<Integer, Index>());
            String fileName = String.format(FILEPATH + "/" + FILENAME_TEMPLATE, fileIndex);
            File file = new File(fileName);
            filePathes.add(fileName);
            if (file.exists()) {
                file.delete();
            }
        }

        HashMap<Integer, Index> innerIndex = indexes.get(fileIndex);
        File file = new File(filePathes.get(fileIndex));

        int pos = (int) file.length();
        int len = word.length();
        innerIndex.put(index % maxElementsPerFile, new Index(pos, len));

        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
            fw.append(word, 0, len);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        index++;
    }

    public String randomGet() throws IOException {
        if (filePathes.size() == 0)
            return null;

        int randomIndex = (int) (Math.random() * this.index);
        System.out.println(String.format("random index = %d", randomIndex));
        int fileIndex = randomIndex / filePathes.size();
        HashMap<Integer, Index> innerIndex = indexes.get(fileIndex);
        Index index = innerIndex.get(randomIndex % maxElementsPerFile);
        FileReader fileReader = new FileReader(filePathes.get(fileIndex));
        fileReader.skip(index.pos);
        char[] chars = new char[index.len];
        fileReader.read(chars, 0, index.len);

        return String.valueOf(chars);
    }

    public static void main(String[] args) throws IOException {
        String[] strings = new String[]{
                "a",
                "b",
                "c",
                "d"
        };

        UniformProbabilityPick upp = new UniformProbabilityPick();
        for (String s : strings) {
            upp.add(s);
        }

        String pickedString = upp.randomGet();
        System.out.println(pickedString);
    }

}
