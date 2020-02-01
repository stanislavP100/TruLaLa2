package com.exampleTruLaLa.TruLaLa;

import javax.persistence.*;

@Entity

@Table(name="STUDENT", catalog="truladb")

public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="shop_id")
  public   Long id;
}
