package ticket;

import client.Client;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import planet.Planet;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "create_at", insertable = false)
    private LocalDateTime crateAt;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @ToString.Exclude
    private Client client;

    @Column(name = "from_planet_id",insertable = false, updatable = false)
    private String fromPlanetId;

    @Column(name = "to_planet_id", insertable = false, updatable = false)
    private String toPlanetID;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet fromPlanet;

    @ManyToOne
    @JoinColumn(name = "to_planet_id", nullable = false)
    @ToString.Exclude
    private Planet toPlanet;


}
