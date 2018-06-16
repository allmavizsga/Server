package edu.cs.ubb.dictionarylearn.model;
//
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//@Entity
//@NoArgsConstructor
//public class Guest {
//
//    @Id
//    @SequenceGenerator(name = "seq_gen")
//    @GeneratedValue(generator = "seq_gen")
//    private Long guestId;
//
//    @NotNull
//    @Column(length = 100)
//    private String guestName;
//
//    public long getGuestId() {
//        return guestId;
//    }
//
//    public void setGuestId(long id) {
//        this.guestId = id;
//    }
//
//    public String getGuestName() {
//        return guestName;
//    }
//
//    public void setGuestName(String guestName) {
//        this.guestName = guestName;
//    }
//}

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table
public class Guest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Guest(){}
}