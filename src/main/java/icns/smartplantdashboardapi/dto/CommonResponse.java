package icns.smartplantdashboardapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommonResponse<T> {
    private boolean success;
    private String msg;
    private T data;
}
