class Solution {
    public boolean hasMatch(String s, String p) {
    if(p.length()==1 && p.charAt(0)=='*')return true;

        String[] parts=p.split("\\*");
        String prefix=parts[0];
        String suffix=parts.length > 1? parts[1] :"";

        int prefixindex=s.indexOf(prefix);
        if(prefixindex==-1)return false;

        int suffixindex=s.indexOf(suffix,prefixindex+prefix.length());
        return suffixindex != -1;
    }
}
