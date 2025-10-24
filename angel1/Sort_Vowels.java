class Sort_Vowels {
    public String sortVowels(String s) {
        StringBuilder str = new StringBuilder();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        String vowels = "AEIOUaeiou";

        for(int i=0; i<s.length(); i++){
            if(vowels.contains(s.substring(i,i+1)))
                pq.add(s.charAt(i));
        }

        for(int i=0; i<s.length(); i++){
            if(vowels.contains(s.substring(i,i+1)))
                str.append(pq.poll());
            else
                str.append(s.charAt(i));
        }

        return str.toString();
    }
}