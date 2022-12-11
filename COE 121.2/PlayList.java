public class PlayList {

    private String playListName;
    private SongNode currentNode;
    private SongNode firstNode;
    private SongNode lastNode;

    static class SongNode {

        private final Song song;
        private SongNode next;
        private SongNode previous;

        public SongNode(Song data) {
            this.song = data;
        }

        public Song getSong() {
            return song;
        }

        public SongNode getNext() {
            return next;
        }

        public void setNext(SongNode next) {
            this.next = next;
        }

        public SongNode getPrevious() {
            return previous;
        }

        public void setPrevious(SongNode previous) {
            this.previous = previous;
        }

    }

    public PlayList(String playListName) {
        this.playListName = playListName;
    }

    public void addSong(Song song) {
        SongNode newNode = new SongNode(song);
        if(firstNode == null) {
            firstNode = newNode;
            currentNode = newNode;
            newNode.setNext(newNode);
        } else {
            newNode.setNext(firstNode);
            newNode.setPrevious(lastNode);
            lastNode.setNext(newNode);
        }
        lastNode = newNode;
        firstNode.setPrevious(lastNode);
    }

    public Song moveToPrevious() {
        currentNode = currentNode.getPrevious();
        return currentNode.getSong();
    }

    public Song moveToNext() {
        currentNode = currentNode.getNext();
        return currentNode.getSong();
    }

}
