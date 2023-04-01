package client;

import jakarta.persistence.*;
import lombok.Data;
import ticket.Ticket;

import java.util.List;

@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Ticket> tickets;

}
