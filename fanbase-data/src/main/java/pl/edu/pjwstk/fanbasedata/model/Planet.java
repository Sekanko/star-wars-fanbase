package pl.edu.pjwstk.fanbasedata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Setter
@Getter
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer diameter;
    private Integer rotationPeriod;
    private Integer orbitalPeriod;
    private Double gravity;
    private Double population;
    private String climate;
    private String terrain;
    private Integer surfaceWaterPercentage;
    private Long swapiId;
}
