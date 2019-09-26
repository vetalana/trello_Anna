package com.trello.qa.manager;

public class BoardData {
    private String boardName;
    private String s;



    public BoardData withBoardName(String boardName) {
        this.boardName = boardName;
        return this;
    }

    public BoardData withS(String s) {
        this.s = s;
        return this;
    }

    public String getBoardName() {
        return boardName;
    }

    public String getS() {
        return s;
    }
}
