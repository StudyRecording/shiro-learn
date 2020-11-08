package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Roles implements Serializable {

    private static final long serialVersionUID = -2648122909440081346L;
    private Integer id;

    private String name;

    private List<Perms> perms;
}
