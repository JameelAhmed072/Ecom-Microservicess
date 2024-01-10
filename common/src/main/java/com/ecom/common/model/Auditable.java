package com.ecom.common.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Auditable<U>{

    @CreatedBy
    @Column(name = "created_by",updatable = false)
    protected  U createdBy;
    @CreatedDate
    @Column(name = "created_date",updatable = false)
    protected LocalDateTime localDate;
    @LastModifiedBy
    @Column(name = "modifed_by",insertable = false)
    protected U modifiedBy;
    @LastModifiedDate
    @Column(name = "modified_date",insertable = false)
    protected LocalDateTime modifiedDate;

}
