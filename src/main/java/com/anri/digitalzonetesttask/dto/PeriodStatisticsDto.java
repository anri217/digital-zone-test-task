package com.anri.digitalzonetesttask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeriodStatisticsDto {

    private Long visitsCountByPeriod;

    private Long distUsersCountByPeriod;

    private Long permanentUsersCountByPeriod;
}
