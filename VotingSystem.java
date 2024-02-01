// The provided code represents a voting system where each voter ranks three candidates. The first choice gets 3 points, the second choice gets 2 points, and the third choice gets 1 point. 
// The objective is to calculate the total points for each candidate across all votes and then output the 
// candidates in descending order of their total points. In case of a tie in points, the ordering of the tied candidates is not specified. The code needs to be fixed to handle tie-breakers.

// Author - Roshan Adhikari 

import java.util.*;

public class VotingSystem {
    
    private Map<String, Integer> votes;
    
    public VotingSystem(){
        votes = new HashMap<>();
    }
    
    // Method that casts the vote
    public void castVote(List<List<String>> candidates) {
        for(List<String> candidate: candidates) {
            // if there is no vote set at 0 or else add with the index value (3,2,1)
            votes.put(candidate.get(0), votes.getOrDefault(candidate.get(0), 0)+3);
            votes.put(candidate.get(1), votes.getOrDefault(candidate.get(1), 0)+2);
            votes.put(candidate.get(2), votes.getOrDefault(candidate.get(2), 0)+1);
        }
    }
    
    // Helper method to sort the values with a tie-breaker
    public List<Map.Entry<String, Integer>> getSortedResults(){
        List<Map.Entry<String, Integer>> sortedVotes = new ArrayList<>(votes.entrySet());
        
        sortedVotes.sort((entry1, entry2) -> {
            // compares two map entry sets
            int compareValue = entry2.getValue().compareTo(entry1.getValue());
            if (compareValue == 0) {
                return entry1.getKey().compareTo(entry2.getKey()); // Tie-breaker: sort alphabetically
            }
            return compareValue;
        });
        return sortedVotes;
    }

    public static void main(String[] args) {
        VotingSystem sys = new VotingSystem();
        List<List<String>> votes = new ArrayList<>();
        votes.add(Arrays.asList("john", "suzie", "sam"));
        votes.add(Arrays.asList("charlie", "suzie", "bob"));
        votes.add(Arrays.asList("jonny", "suzie", "sam"));
    
        sys.castVote(votes);

        List<String> candidates = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sys.getSortedResults()) {
            candidates.add(entry.getKey());
        }
        
        System.out.println(candidates);
    }
}
