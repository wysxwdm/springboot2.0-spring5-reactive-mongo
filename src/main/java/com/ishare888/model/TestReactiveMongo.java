package com.ishare888.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Document(collection = "test-reactive-mongo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestReactiveMongo {
    @Id
    private String id;

    @NotBlank
    @Size(max = 140)
    private String text;

//    @NotNull
    private Date createdAt = new Date();

}
