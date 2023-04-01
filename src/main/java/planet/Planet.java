package planet;

import jakarta.persistence.*;
import lombok.Data;
import ticket.Ticket;

import java.util.List;

@Entity
@Table(name = "planet")
@Data
public class Planet {
    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "fromPlanet", fetch = FetchType.EAGER)
    private  List<Ticket> ticketsFrom;

    @OneToMany(mappedBy = "toPlanet", fetch = FetchType.EAGER)
    private List<Ticket> ticketsTo;
}
