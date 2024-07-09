package practiceLLD.TaskManagementSystem.DTOs;

import practiceLLD.TaskManagementSystem.Models.Task;

public class DeleteTaskResponseDTO {

    private ResponseStatus status;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

}
