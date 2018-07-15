package org.learning.springboot.oracle.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SIGNUP_DTL")
@Data
@ToString
public class SignUpDetails implements Serializable{

    private static final long serialVersionUID = -3009322422412446L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    @JsonIgnore
    private Long id;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;


}
