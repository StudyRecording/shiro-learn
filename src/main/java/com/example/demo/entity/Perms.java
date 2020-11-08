package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Perms implements Serializable {

    private static final long serialVersionUID = -8000390962939655556L;
    private Integer id;

    private String name;

    private String url;
}
