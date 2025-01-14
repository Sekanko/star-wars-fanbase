package pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class SWDTO {
    @JsonIgnore
    private Long swapiId;

}
