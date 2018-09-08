package com.google;

import java.util.HashMap;

/*
Daily Coding Problem: Problem #17
This problem was asked by Google.

Suppose we represent our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty
second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file
file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system.
For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its
length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to a
file in the abstracted file system. If there is no file in the system, return 0.

Note:

The name of a file contains at least a period and an extension.

The name of a directory or sub-directory will not contain a period.


 */
public class LongestAbsoluteFilePath {
    class FileDir {
        String fileDirName;
        int pathLen;
        int level;
        boolean isDir = false;

        FileDir(String fileDirName, int level, boolean isDir) {
            this(fileDirName, level, 0, isDir);
        }

        FileDir(String fileDirName, int level, int pathlen, boolean isDir) {
            this.fileDirName = fileDirName;
            this.level = level;
            this.pathLen = pathlen;
            this.isDir = isDir;
        }
    }

    public static void main(String[] args) {
        String strPath = "dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext";
        System.out.println(strPath.length());

        int result = new LongestAbsoluteFilePath().getLongestPath(strPath);
        System.out.println(result);
    }

    public int getLongestPath(String strPath) {
        if (strPath == null || strPath.length() == 0) {
            return 0;
        }

        String[] pathes = strPath.split("\\\\n");
        HashMap<Integer, FileDir> dirs = new HashMap<>();
        int longest = 0;

        for (String path : pathes) {
            FileDir fileDir = getCurrentFileDir(path);

            if (dirs.containsKey(fileDir.level - 1)) {
                FileDir parentDir = dirs.get(fileDir.level - 1);
                fileDir.pathLen = parentDir.pathLen + fileDir.fileDirName.length() + 1;
            } else {
                fileDir.pathLen = fileDir.fileDirName.length();
            }
            if (fileDir.pathLen > longest) {
                longest = fileDir.pathLen;
            }
            if (fileDir.isDir) {
                dirs.put(fileDir.level, fileDir);
            }
        }
        return longest;
    }

    public FileDir getCurrentFileDir(String path) {
        int level = 0;
        String dirFlag = "\\t";
        while (path.startsWith(dirFlag)) {
            level++;
            path = path.substring(dirFlag.length());
        }
        boolean isDir = path.indexOf(".") == -1;
        return new FileDir(path, level, isDir);
    }
}
