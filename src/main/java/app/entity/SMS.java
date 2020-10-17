package app.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SMS {
    private final String errno;
    private final String errtext;
    private final String message_id;
    private final String charge;
    private final String balance;
}
