package searchCodingTst.testdome;

import java.util.Objects;

/**
 *  Set의 가장 큰 장점은 중복을 자동으로 제거
 *  HashSet과 TreeSet이 있는데 
 *  HashSet의 경우 정렬을 해주지 않고 
 *  TreeSet의 경우 자동정렬을 해준다는 차이점
 * @author skyang
 *
 */
public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {
        Song current = this.nextSong;
        
    	while(current != null) {
    		current = current.nextSong;
    		if(current == this)
    			return true;
    	}
    	return false;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        //Song second = new Song("Eye of the tiger");

        //first.setNextSong(second);
//        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}