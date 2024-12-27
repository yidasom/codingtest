package programmers;

import java.util.*;

public class Lv3_42579 {
    public static void main(String[] args) {
        Lv3_42579 lv = new Lv3_42579();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        lv.solution(genres, plays);
    }

    // 장르 -> 재생수 많은 순서대로
    // 가장 많이 틀어진것, 가장 작게
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        // {"classic": [{0, 500}, {2, 150}, {3, 800}]}, {"pop": [{2, 600}, {4, 2500}]}
        Map<String, List<int[]>> map = new HashMap<>();
        // {"classic": 1450, "pop": 3100}
        Map<String, Integer> songMap = new HashMap<>();
        for (int i=0; i<genres.length; i++) {
            map.putIfAbsent(genres[i], new ArrayList<>());
            map.get(genres[i]).add(new int[] {i, plays[i]});

            songMap.put(genres[i], songMap.getOrDefault(genres[i], 0)+plays[i]);
        }
        // 내림차순 {"pop": 3100, "classic": 1450}
        List<Map.Entry<String, Integer>> songList = new ArrayList<>(songMap.entrySet());
        songList.sort((a,b) -> b.getValue() - a.getValue());

        // 가장 많이 들은 노래
        songList.forEach(e -> {
            String keys = e.getKey();
            List<int[]> songs = map.get(keys);
            // 노래횟수 같다면 ? 고유번호 오름차순 : 재생횟수 내림차순
            songs.sort((a,b) -> b[1] == a[1] ? Integer.compare(a[0], b[0]): Integer.compare(b[1], a[1]));

            answer.add(songs.get(0)[0]);
            if (songs.size() > 1) {
                answer.add(songs.get(1)[0]);
            }
        });

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
