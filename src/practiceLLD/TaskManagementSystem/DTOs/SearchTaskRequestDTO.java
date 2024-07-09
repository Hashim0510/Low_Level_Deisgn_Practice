package practiceLLD.TaskManagementSystem.DTOs;

import practiceLLD.TaskManagementSystem.Models.User;

public class SearchTaskRequestDTO {

    private String keyword;
    private User user;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
