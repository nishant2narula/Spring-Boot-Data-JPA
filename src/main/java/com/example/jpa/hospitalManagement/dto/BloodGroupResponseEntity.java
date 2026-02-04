package com.example.jpa.hospitalManagement.dto;

import com.example.jpa.hospitalManagement.entity.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class BloodGroupResponseEntity {

    private BloodGroupType bloodGroupType;

    private Long count;

    public BloodGroupResponseEntity(BloodGroupType bloodGroupType, Long count) {
        this.bloodGroupType = bloodGroupType;
        this.count = count;
    }


}
