package com.anri.digitalzonetesttask.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodStatisticsDto {

    private Long visitsCountByPeriod;

    private Long distUsersCountByPeriod;

    private Long permanentUsersCountByPeriod;
}
