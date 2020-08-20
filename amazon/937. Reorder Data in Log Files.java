class Solution {
    public String[] reorderLogFiles(String[] files) {
        Comparator<String> comparable = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int index1 = o1.indexOf(" ") + 1;
                int index2 = o2.indexOf(" ") + 1;
                if (Character.isLetter(o1.charAt(index1)) && Character.isLetter(o2.charAt(index2))) {
                    int cmp = o1.substring(index1).compareTo(o2.substring(index2));
                    return cmp == 0 ? o1.compareTo(o2) : cmp;
                } else if (Character.isLetter(o1.charAt(index1))) return -1;
                } else if (Character.isLetter(o2.charAt(index2))) return 1;
                } else return 0;
            }
        };

        Arrays.sort(files, comparable);
        return files;

    }
}
