package com.projections.example.entity;

import com.projections.example.utils.Utils;
import com.vladmihalcea.hibernate.type.array.DateArrayType;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonNodeStringType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@TypeDefs({
        @TypeDef(name = "list-array", typeClass = ListArrayType.class),
        @TypeDef(name = "string-array", typeClass = StringArrayType.class),
        @TypeDef(name = "int-array", typeClass = IntArrayType.class),
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
        @TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class),
        @TypeDef(name = "json-node", typeClass = JsonNodeStringType.class),
        @TypeDef(name = "date-array", typeClass = DateArrayType.class),
        @TypeDef(name = "json", typeClass = JsonType.class)
})
@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
public class BaseEntity implements Serializable {

    @Column(nullable = false, updatable = false)
    private String createdBy;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private String updatedBy;

    @PrePersist
    private void setAuditFields() {
        createdDate = Utils.getCurrentSystemTimeConvertedToEST();
        updatedDate = Utils.getCurrentSystemTimeConvertedToEST();
        createdBy = createdBy.toLowerCase();
        updatedBy = createdBy;
    }

    @PreUpdate
    private void updateAuditFields() {
        updatedDate = Utils.getCurrentSystemTimeConvertedToEST();
        updatedBy = updatedBy.toLowerCase();
    }

}