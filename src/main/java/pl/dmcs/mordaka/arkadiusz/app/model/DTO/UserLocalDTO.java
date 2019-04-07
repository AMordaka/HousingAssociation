package pl.dmcs.mordaka.arkadiusz.app.model.DTO;

import lombok.Data;
import pl.dmcs.mordaka.arkadiusz.app.model.Local;
import pl.dmcs.mordaka.arkadiusz.app.model.User;

@Data
public class UserLocalDTO {

    private User user;
    private Local local;
}
