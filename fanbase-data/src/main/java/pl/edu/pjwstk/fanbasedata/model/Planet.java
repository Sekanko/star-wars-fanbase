package pl.edu.pjwstk.fanbasedata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int diameter;
    private int rotationPeriod;
    private int orbitalPeriod;
    private double gravity;
    private double population;
    private String climate;
    private String terrain;
    private int surfaceWaterPercentage;

}
