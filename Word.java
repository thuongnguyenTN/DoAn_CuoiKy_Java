package model;

public class Word {
    private String word;
    private String pronunciation;
    private String pos;
    private String meaning;

    public Word(String word, String pronunciation, String pos, String meaning) {
        this.word = word;
        this.pronunciation = pronunciation;
        this.pos = pos;
        this.meaning = meaning;
    }

    // Getter và Setter
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
