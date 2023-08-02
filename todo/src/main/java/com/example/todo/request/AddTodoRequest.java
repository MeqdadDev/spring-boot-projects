package com.example.todo.request;

public class AddTodoRequest {
    private String content;

    public AddTodoRequest() {

    }

    public AddTodoRequest(String content) {
        this.content = content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }

}
