{\rtf1\ansi\ansicpg1252\cocoartf1561\cocoasubrtf610
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 class Solution \{\
    int[] parent = new int[26];\
    \
    public boolean equationsPossible(String[] equations) \{\
        for (int i = 0; i < 26; i++) parent[i] = i;\
        \
        for (String s: equations)\{\
            char c1 = s.charAt(0);\
            char c2 = s.charAt(3);\
            if (s.charAt(1) == '=')\{\
                int i1 = find(c1 - 'a');\
                int i2 = find(c2 - 'a');\
                if (i1 != i2) parent[i1] = i2;\
            \} else if (c1 == c2) return false;\
        \}\
        \
        for (String s: equations)\{\
            if (s.charAt(1) == '!')\{\
                int x = find(s.charAt(0) - 'a');\
                int y = find(s.charAt(3) - 'a');\
                if (x == y) return false;\
            \}\
        \}\
        \
        return true;\
    \}\
    \
    \
    private int find(int c)\{\
        return (c == parent[c]) ? c : find(parent[c]);    \
    \}\
\}}