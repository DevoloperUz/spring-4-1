package devoloperuz.spring41.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Author: Intelligent
 * Date: 04.11.2022
 * Time: 14:26
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Response {
    private Boolean success;
    private String message;
    private Object data;
    private List<Object> dataList;
    private HttpStatus httpStatus;

    public Response(Boolean success, String message) {
        this.success = success;
        this.message = message;
        if (success)
            this.httpStatus = HttpStatus.OK;
    }

    public Response(Boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        if (data instanceof List)
            this.dataList =(List) data;
        else
            this.data = data;
        if (success)
            this.httpStatus = HttpStatus.OK;
    }

    public Response(Boolean success, String message, List<Object> dataList) {
        this.success = success;
        this.message = message;
        this.dataList = dataList;
        if (success)
            this.httpStatus = HttpStatus.OK;
    }

    public Response(Boolean success, String message, HttpStatus httpStatus) {
        this.success = success;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
