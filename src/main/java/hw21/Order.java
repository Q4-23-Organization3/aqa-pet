package hw21;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    public long id;
    public long petId;
    public int quantity;
    public String shipDate;
    public String status;
    public boolean complete;
}
