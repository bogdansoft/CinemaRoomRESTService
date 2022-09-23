package cinema.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class ReturnRequest {
    //@Pattern(regexp = "[0-9a-f]{8}-([0-9a-f]{4}-){3}[0-9a-f]{8}")
    String token;
}
