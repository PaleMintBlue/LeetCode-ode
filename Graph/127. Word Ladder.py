{\rtf1\ansi\ansicpg1252\cocoartf1561\cocoasubrtf610
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 class Solution \{\
    public int ladderLength(String beginWord, String endWord, List<String> wordList) \{\
        Set<String> set = new HashSet<>(wordList);\
        Deque<String> dq = new ArrayDeque<>();\
        int res = 1;\
        set.remove(beginWord);\
        dq.offer(beginWord);\
        while (!dq.isEmpty()) \{\
            int len = dq.size();\
            for (int k = 0; k < len; k++) \{\
                String word = dq.poll();\
                if (word.equals(endWord)) return res;\
                char[] wordChar = word.toCharArray();\
                for (int i = 0; i < wordChar.length; i++) \{\
                    char original = wordChar[i];\
                    for (char c = 'a'; c <= 'z'; c++) \{\
                        wordChar[i] = c;\
                        String s = String.valueOf(wordChar);\
                        if (set.contains(s)) \{\
                            dq.offer(s);\
                            set.remove(s);\
                        \}\
                    \}\
                    wordChar[i] = original;\
                \}\
            \}\
            res++;\
        \}\
        return 0;\
    \}\
\}}